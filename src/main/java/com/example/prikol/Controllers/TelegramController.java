package com.example.prikol.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TelegramController {

    @RequestMapping("/")
    public String index() {
        return "Привет! Альбинка!";
    }


}