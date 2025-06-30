package mini.infra;

import mini.config.kafka.KafkaProcessor;
import mini.domain.Mypage;
import mini.domain.MypageRepository;
import mini.domain.SubscribeApplicationed;
import mini.domain.SubscribeCanceled;
import mini.domain.DecreaseFailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Date;

@Service