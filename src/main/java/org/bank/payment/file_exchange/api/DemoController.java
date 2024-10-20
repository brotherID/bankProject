package org.bank.payment.file_exchange.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping("/hello-1")
    //@PreAuthorize("hasRole('ROLE_USER')")
    public String hello() {
        return "Anyone can access";
    }





    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello2() {
        return "ADMIN can access";
    }

    @GetMapping("/hello-3")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String hello3() {
        return "USER can access";
    }

    @GetMapping("/hello-4")
    @PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_USER')")
    public String hello4() {
        return "ADMIN/USER can access";
    }

}
