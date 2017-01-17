package jp.kafka.scheduler;

import jp.kafka.consumer.KafkaConsumer;
import jp.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MessageScheduler {


    @Value("${kafka.message.test}")
    private String MESSAGE;

    @Autowired
    List<KafkaProducer> kafkaProducers;

    private boolean schedulerActive = true;

    @Scheduled(cron = "*/3 * * * * *")
    public void send() {
        if (schedulerActive) {
            for (KafkaProducer kafkaProducer : kafkaProducers) {
                kafkaProducer.produce(MESSAGE + " " + kafkaProducer.getClass().getName());
            }
        }
    }
}
