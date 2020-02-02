package dev.pater.springcloudcontractconsumer;

import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;


class WebService {
    ResponseEntity<MyAccountNumber> getAccountNumber() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate
                .exchange("http://localhost:6565/accountNumber",
                        GET, new HttpEntity<>(headers), MyAccountNumber.class);
    }

    HttpStatus updateAccountNumber(MyAccountNumber myAccountNumber) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            restTemplate.put("http://localhost:6565/accountNumber",
                    new HttpEntity<>(myAccountNumber, headers));
        } catch (HttpClientErrorException ex) {
            return ex.getStatusCode();
        }

        return HttpStatus.ACCEPTED;
    }
}
