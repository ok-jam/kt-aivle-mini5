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
    BookRepository bookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RegistrationRequested'"
    )
    public void wheneverRegistrationRequested_BookRegistration(
        @Payload RegistrationRequested registrationRequested
    ) {
        RegistrationRequested event = registrationRequested;
        System.out.println(
            "\n\n##### listener BookRegistration : " +
            registrationRequested +
            "\n\n"
        );

        // Sample Logic //
        Book.bookRegistration(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PointDecreased'"
    )
    public void wheneverPointDecreased_ReadingRequest(
        @Payload PointDecreased pointDecreased
    ) {
        PointDecreased event = pointDecreased;
        System.out.println(
            "\n\n##### listener ReadingRequest : " + pointDecreased + "\n\n"
        );

        // Sample Logic //
        Book.readingRequest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor