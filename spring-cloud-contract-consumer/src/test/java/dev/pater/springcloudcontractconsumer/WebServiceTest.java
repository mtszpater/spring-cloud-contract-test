package dev.pater.springcloudcontractconsumer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"dev.pater:spring-cloud-contract-producer:+:stubs:6565"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class WebServiceTest {


    @Test
    public void testGet() {

        WebService webService = new WebService();
        ResponseEntity<MyAccountNumber> myAccountNumber = webService.getAccountNumber();

        Assert.assertEquals(myAccountNumber.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testPut() {

        WebService webService = new WebService();
        HttpStatus httpStatus = webService.updateAccountNumber(new MyAccountNumber(5));

        Assert.assertEquals(httpStatus, HttpStatus.BAD_REQUEST);
    }
}