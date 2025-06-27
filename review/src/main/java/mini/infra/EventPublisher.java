package mini.infra;
import mini.infra.AbstractEvent;
import mini.config.kafka.KafkaProcessor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class EventPublisher {

    public static void publish(AbstractEvent event) {
        KafkaProcessor processor = mini.ReviewApplication.applicationContext.getBean(KafkaProcessor.class);
        MessageChannel outputChannel = processor.outboundTopic();

        outputChannel.send(
            MessageBuilder
                .withPayload(event)
                .setHeader("type", event.getEventType())
                .build()
        );
    }
}
