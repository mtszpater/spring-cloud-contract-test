package dev.pater.springcloudcontractproducer;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accountNumber")
public class AccountNumberRestController {

    @GetMapping
    public ResponseEntity<AccountNumber> get() {

        return ResponseEntity.ok().body(new AccountNumber(123L));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity put(@RequestBody AccountNumber accountNumber) {

        if (accountNumber.getAccountNumber() < 10)
            return ResponseEntity.badRequest().body(new ErrorMessage("ACCOUNT_NUMBER_INVALID", "Account number too short"));

        // logic

        return ResponseEntity.ok().build();
    }


}


class ErrorMessage {
    private String errorCode;

    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    ErrorMessage(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }


}

class AccountNumber {
    AccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public AccountNumber() {
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    private long accountNumber;
}
