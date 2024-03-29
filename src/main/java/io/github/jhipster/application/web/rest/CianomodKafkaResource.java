package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.CianomodKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cianomod-kafka")
public class CianomodKafkaResource {

    private final Logger log = LoggerFactory.getLogger(CianomodKafkaResource.class);

    private CianomodKafkaProducer kafkaProducer;

    public CianomodKafkaResource(CianomodKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
