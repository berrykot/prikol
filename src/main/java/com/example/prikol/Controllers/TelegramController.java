package com.example.prikol.Controllers;

//import com.example.prikol.Models.*;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.*;

import kong.unirest.Unirest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TelegramController {

    final String telegramUrl = "https://api.telegram.org/bot5180751190:AAFCfs7DqJCVvVfvqz9bId-bLc8JFUpeYuk";

    @RequestMapping("/")
    @ResponseBody
    public String index(@RequestBody String request) {
        var update = BotUtils.parseUpdate(request);

        var response = Unirest.post(telegramUrl + "/sendMessage")
                .header("accept", "application/json")
                .field("chat_id", update.message().from().id())
                .field("text", "Привет, " + update.message().from().username())
                .asJson();

        return BotUtils.toJson(update);
    }
}