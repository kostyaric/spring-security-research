package my.security.zero.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalController {

    @GetMapping("/hello")
    public String hello() {
        return "HELLO USER!";
    }

    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "HELLO ADMIN!";
    }
}
