package com.example.prikol.Controllers;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TelegramController {

    final String telegramUrl = "https://api.telegram.org/bot5180751190:AAFCfs7DqJCVvVfvqz9bId-bLc8JFUpeYuk";

    @RequestMapping("/")
    //@ResponseBody
    public String index(String x) {
        if(x == null)
            x = "Empty";

        System.out.println(x);

        var response = Unirest.post(telegramUrl + "/sendMessage")
                .header("accept", "application/json")
                .field("chat_id", "104830286")
                .field("text", x)
                .asJson();

        return response.getBody().toString();
    }
}