package contracts.accountNumber

import org.springframework.cloud.contract.spec.Contract;

Contract.make {
    description("""
User want to update his account number and passes invalid number 
```
given:
	any client and too short account number
when:
	he want to update his account number
then:
	we'll send him error message
```
""")
    request {
        method 'PUT'
        url '/accountNumber'
        body(
                accountNumber: $(regex('[0-9]{1}'))
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status BAD_REQUEST()
        body([
                errorCode: "ACCOUNT_NUMBER_INVALID",
                message: anyNonEmptyString()
        ])
        headers {
            contentType(applicationJson())
        }
    }
}