package org.bank.payment.file.exchange.api;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bank.payment.file.exchange.service.kafka.NotificationProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class DemoController {

    @Value("${spring.kafka.topics.event-notification}")
    private String eventNotificationTopic;

    private final NotificationProducerService notificationProducerService;


    @PostMapping("/publish")
    public String publish(@RequestParam String message) {
        notificationProducerService.sendMessage(eventNotificationTopic, message);
        return "Message sent!";
    }

//    @PostMapping("/publish2")
//    public String publish2(@RequestParam String message) {
//        return message;
//    }


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
