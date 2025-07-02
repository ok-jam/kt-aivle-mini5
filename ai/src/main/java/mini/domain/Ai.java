package mini.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.*;
import lombok.Data;
import mini.AiApplication;
import mini.domain.InformationCreated;
import mini.domain.ResultsReturned;

import java.io.File;
import java.io.IOException;
// OPENAI
import okhttp3.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name = "Ai_table")
@Data
//<<< DDD / Aggregate Root
public class Ai {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private Long writingId;

    @Column(length = 9999)
    private String resultImage;
    @Column(length = 9999)
    private String resultsummary;
    @Column(length = 9999)
    private String resultPdf;

    @PostPersist
    public void onPostPersist() {
        ResultsReturned resultsReturned = new ResultsReturned(this);
        resultsReturned.publishAfterCommit();

        // InformationCreated informationCreated = new InformationCreated(this);
        // informationCreated.publishAfterCommit();
        
        // BookInformationRequested requested = new BookInformationRequested(this);
        // requested.publishAfterCommit();
    }

    public static AiRepository repository() {
        AiRepository aiRepository = AiApplication.applicationContext.getBean(
            AiRepository.class
        );
        return aiRepository;
    }

    //<<< Clean Arch / Port Method
    public static Ai informationcreate(
        BookInformationRequested bookInfo
    ) {
        //implement business logic here:
        String openaiKey = "openapikey";

        try {

            // 1. 책 내용 기반 요약 (GPT)
            String summary = callGptApi(bookInfo.getContent(), openaiKey);
            // String summary = "Test";
            System.out.println("GPT 호출 시작");
            System.out.println("GPT 결과: " + summary);

            // 2. DALL·E 이미지 생성
            
            String dallePrompt = bookInfo.getTitle() + " - " + bookInfo.getContent();
            String imageUrl = callDalleApi(dallePrompt, openaiKey);
            // String imageUrl = "Test";
            System.out.println("이미지 결과: " + imageUrl);
            // 3. PDF로 변환
            String pdfPath = "";
            
            
            try{
                pdfPath = generatePdf(bookInfo.getTitle(), bookInfo.getContent());
            } catch(Exception e){
                e.printStackTrace();
                pdfPath = "PDF 생성 실패";
                throw new RuntimeException("AI 생성 중 예외 발생", e);
            }
                

            System.out.println("PDF 경로: " + pdfPath);
            // 4. DB 저장
            Ai ai = new Ai();
            ai.setWritingId(bookInfo.getWritingId()); // 예시
            //ai.setWritingId(1L);
            ai.setResultsummary(summary);
            ai.setResultImage(imageUrl);
            ai.setResultPdf(pdfPath);
            System.out.println("저장 전 Ai 객체: " + ai.toString());
            repository().save(ai);

            System.out.println(summary);
            System.out.println(imageUrl);
            System.out.println(pdfPath);
            return repository().save(ai);
            // // // 5. 이벤트 발행
            // ResultsReturned event = new ResultsReturned();
            // event.setWritingId(bookInfo.getWritingId());
            // event.setResultImage(imageUrl);
            // event.setResultsummary(summary);
            // event.setResultPdf(pdfPath);
            // event.publishAfterCommit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("AI 정보 생성 중 예외 발생", e);
            // 로그 기록 및 예외 처리
        }


    }
    //>>> Clean Arch / Port Method

    private static String callDalleApi(String prompt, String key) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build();

        // 요청 JSON 생성
        JSONObject json = new JSONObject();
        json.put("model", "dall-e-3");
        json.put("prompt", "너는 사람들의 이목을 끌만한 책 표지를 잘 만드는 화가야. " +
                "내가 책 제목과 내용 요약을 제공해줄 테니 이를 바탕으로 책 표지 이미지를 생성해줘"+ prompt);
        json.put("n", 1);
        json.put("size", "1024x1024");

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/images/generations")
                .post(RequestBody.create(json.toString(), MediaType.get("application/json")))
                .addHeader("Authorization", "Bearer " + key)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("DALL·E 호출 실패: " + response.body().string());
            }

            String responseBody = response.body().string();
            JSONObject responseJson = new JSONObject(responseBody);
            String imageUrl = responseJson
                    .getJSONArray("data")
                    .getJSONObject(0)
                    .getString("url");
            return imageUrl;
    }
}

    private static String callGptApi(String content, String key) throws IOException {
            OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build();

            // ChatGPT 프롬프트 구성
            JSONArray messages = new JSONArray();

            JSONObject systemMsg = new JSONObject();
            systemMsg.put("role", "system");
            systemMsg.put("content", "당신은 책 내용을 요약하는 전문 AI입니다.");
            messages.put(systemMsg);

            JSONObject userMsg = new JSONObject();
            userMsg.put("role", "user");
            userMsg.put("content", "다음 책 내용을 3문단으로 요약해줘:\n" + content);
            messages.put(userMsg);

            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "gpt-4");
            requestBody.put("messages", messages);
            requestBody.put("temperature", 0.7);

            Request request = new Request.Builder()
                    .url("https://api.openai.com/v1/chat/completions")
                    .post(RequestBody.create(requestBody.toString(), MediaType.get("application/json")))
                    .addHeader("Authorization", "Bearer " + key)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("GPT 요약 실패: " + response.body().string());
                }

                String responseBody = response.body().string();
                JSONObject json = new JSONObject(responseBody);
                return json.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content")
                        .trim();
            }
    }

    private static String generatePdf(String title, String fullcontent) throws IOException {
        String sanitizedTitle = title.replaceAll("[^a-zA-Z0-9가-힣]", "_");
    
        String baseDir = System.getProperty("user.dir"); // 현재 프로젝트 디렉토리
        String outputDir = baseDir + File.separator + "output";
        
        File dir = new File(outputDir);
        if (!dir.exists()) dir.mkdirs();
        
        String path = outputDir + File.separator + sanitizedTitle + ".pdf";
        
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // ✅ 한글 지원 폰트 경로 (윈도우 기준 예: Malgun Gothic)
            // File fontFile = new File("/usr/share/fonts/truetype/dejavu/DejaVuSans.ttf");
            // File fontFile = new File("C:/Windows/Fonts/malgun.ttf");
            // PDType0Font font = PDType0Font.load(document, fontFile);
            PDType1Font font = PDType1Font.HELVETICA; 

            PDPageContentStream content = new PDPageContentStream(document, page);
            content.beginText();
            content.setFont(font, 12); // ← 여기에서 한글 폰트 적용
            content.setLeading(14.5f);
            content.newLineAtOffset(50, 750);

            int maxCharsPerLine = 90;
            String[] lines = fullcontent.split("\n");
            for (String line : lines) {
                while (line.length() > maxCharsPerLine) {
                    content.showText(line.substring(0, maxCharsPerLine));
                    content.newLine();
                    line = line.substring(maxCharsPerLine);
                }
                content.showText(line);
                content.newLine();
            }

            content.endText();
            content.close();

            document.save(path);
        }

        return path;
    }
}
//>>> DDD / Aggregate Root
