package org.scaler.emailservice.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.scaler.emailservice.dto.sendEmailDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SendEmailProducer {

    private ObjectMapper objectMapper;
    SendEmailProducer(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sendEmails", groupId = "emailService")
    public void handleMessage(String message){
        sendEmailDto sendEmailDto = null;

        try {
            sendEmailDto = objectMapper.readValue(message, org.scaler.emailservice.dto.sendEmailDto.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sendEmailDto);

    }
}
