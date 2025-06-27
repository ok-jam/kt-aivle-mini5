package mini.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import mini.config.kafka.KafkaProcessor;
import mini.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Autowired
    SubscribeRepository subscribeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DecreaseFailed'"
    )
    public void wheneverDecreaseFailed_Subscribefail(
        @Payload DecreaseFailed decreaseFailed
    ) {
        DecreaseFailed event = decreaseFailed;
        System.out.println(
             "\n\n❌ 포인트 부족으로 구독 불가: 사용자 " + decreaseFailed.getUserId() + "\n");
    }
}
//>>> Clean Arch / Inbound Adaptor
@StreamListener(
    value = KafkaProcessor.INPUT,
    condition = "headers['type']=='PointDecreased'"  // 포인트 차감 완료 이벤트
)
public void wheneverPointDecreased_RequestBookRead(@Payload PointDecreased pointDecreased) {
    System.out.println("\n\n listener: 도서 열람 요청 → " + pointDecreased + "\n");

    // Step 1. 해당 구독 정보 찾아오기
    Long subscriptionId = pointDecreased.getSubscriptionId();  // 전제: 이 필드 존재해야 함

    Subscribe.subscribeRepository().findById(subscriptionId).ifPresent(subscribe -> {
        // Step 2. 상태를 SUBSCRIBED로 변경
        subscribe.setStatus("SUBSCRIBED");
        Subscribe.repository().save(subscribe);

        // Step 3. 열람 요청 이벤트 발행
        BookReadRequested event = new BookReadRequested();
        event.setSubscriptionId(subscriptionId);
        event.setBookId(subscribe.getBookId());
        event.setSubscriberId(subscribe.getSubcriberId());
        event.setStartDate(new Date());
        event.publishAfterCommit();
    });
}
