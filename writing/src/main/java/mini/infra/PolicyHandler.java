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
    WritingRepository writingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ResultsReturned'"
    )
    public void wheneverResultsReturned_Bookupdate(
        @Payload ResultsReturned resultsReturned
    ) {
        ResultsReturned event = resultsReturned;
        System.out.println(
            "\n\n##### listener Bookupdate : " + resultsReturned + "\n\n"
        );

        // Sample Logic //
        Writing.bookupdate(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
