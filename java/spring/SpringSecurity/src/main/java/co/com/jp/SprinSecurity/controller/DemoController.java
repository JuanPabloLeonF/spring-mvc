package co.com.jp.SprinSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping({"/",""})
    public String showDemo() {
        return "Hola mundo";
    }
}
