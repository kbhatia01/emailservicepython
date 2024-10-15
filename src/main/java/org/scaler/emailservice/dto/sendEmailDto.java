package org.scaler.emailservice.dto;

import lombok.Data;


@Data
public class sendEmailDto {


        private String from;
        private String to;
        private String subject;
        private String body;

}
