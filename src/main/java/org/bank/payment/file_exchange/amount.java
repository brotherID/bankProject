package org.bank.payment.file_exchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class amount {

    @GetMapping(value = "/get/dara")
    public String getSara()
    {
        return "sara";
    }
}
