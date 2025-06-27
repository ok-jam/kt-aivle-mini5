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
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SubscribeApplicationed'"
    )
    public void wheneverSubscribeApplicationed_PointDecreaseRequeset(
        @Payload SubscribeApplicationed subscribeApplicationed
    ) {
        SubscribeApplicationed event = subscribeApplicationed;
        System.out.println(
            "\n\n##### listener PointDecreaseRequeset : " +
            subscribeApplicationed +
            "\n\n"
        );

        // Sample Logic //
        Point.pointDecreaseRequeset(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SignupCompleted'"
    )
    public void wheneverSignupCompleted_Signup(
        @Payload SignupCompleted signupCompleted
    ) {
        SignupCompleted event = signupCompleted;
        System.out.println(
            "\n\n##### listener Signup : " + signupCompleted + "\n\n"
        );

        // Sample Logic //
        Point.signup(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
