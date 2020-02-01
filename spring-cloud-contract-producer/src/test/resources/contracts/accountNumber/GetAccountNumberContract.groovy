package contracts.accountNumber

import org.springframework.cloud.contract.spec.Contract;

Contract.make {
    description("""
User asks for his account number
```
given:
	any client
when:
	he asks for account number
then:
	we'll send him back his account number
```
""")
    request {
        method 'GET'
        url '/accountNumber'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                accountNumber: anyNumber()
        )
        headers {
            contentType(applicationJson())
        }
    }
}