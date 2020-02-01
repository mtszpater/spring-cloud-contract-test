package dev.pater.springcloudcontractproducer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public abstract class BaseTestClass {

    @InjectMocks
    AccountNumberRestController accountNumberRestController;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(this.accountNumberRestController);

    }

}