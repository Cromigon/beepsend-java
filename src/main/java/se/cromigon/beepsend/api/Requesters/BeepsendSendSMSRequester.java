package se.cromigon.beepsend.api.requesters;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import se.cromigon.beepsend.api.Endpoints;
import se.cromigon.beepsend.api.connection.Connection;
import se.cromigon.beepsend.api.exceptions.ApiTokenInvalidException;
import se.cromigon.beepsend.api.sms.SMS;

public class BeepsendSendSMSRequester {


    private class SMSRequestBody {
        private String to;
        private String message;
        private String from;
        private String encoding;
        private Integer receive_dlr;
        private Boolean auto_gsm7_conversion;

        private SMSRequestBody(String to, String message, String from, String encoding, Integer receive_dlr,
                               Boolean auto_gsm7_conversion) {
            this.to = to;
            this.message = message;
            this.from = from;
            this.encoding = encoding;
            this.receive_dlr = receive_dlr;
            this.auto_gsm7_conversion = auto_gsm7_conversion;
        }

        public String getTo() {
            return to;
        }

        public String getMessage() {
            return message;
        }

        public String getFrom() {
            return from;
        }

        public String getEncoding() {
            return encoding;
        }

        public Integer getReceive_dlr() {
            return receive_dlr;
        }

        public Boolean getAuto_gsm7_conversion() {
            return auto_gsm7_conversion;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        public void setReceive_dlr(Integer receive_dlr) {
            this.receive_dlr = receive_dlr;
        }

        public void setAuto_gsm7_conversion(Boolean auto_gsm7_conversion) {
            this.auto_gsm7_conversion = auto_gsm7_conversion;
        }
    }

    private HttpEntity<String> generateHttpEntity(String api_token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + api_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>("parameters", headers);
    }

    private HttpEntity<SMSRequestBody> generateHttpEntity(String api_token, SMS sms) {
        SMSRequestBody smsRequestBody = new SMSRequestBody(sms.getTo(), sms.getMessage(), sms.getFrom(),
                sms.getEncoding(), sms.getReceive_dlr(), sms.getAuto_gsm7_conversion());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Token " + api_token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(smsRequestBody, headers);
    }

    public SMS sendSMS(String api_token, SMS sms, Connection connection) throws ApiTokenInvalidException, HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<SMSRequestBody> entity = generateHttpEntity(api_token, sms);

        try {
            ResponseEntity<SMS> response = restTemplate.exchange(Endpoints.BASE_URL +
                            String.format(Endpoints.SEND_SMS, connection.getId()), HttpMethod.POST, entity,
                            SMS.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                throw new ApiTokenInvalidException("The API Token is invalid");
            } else {
                throw e;
            }
        }
    }
}