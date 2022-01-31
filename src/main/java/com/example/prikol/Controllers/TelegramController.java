package com.example.prikol.Controllers;

import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.request.*;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
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
    public Update index(@RequestBody Update update) {

        var response = Unirest.post(telegramUrl + "/sendMessage")
                .header("accept", "application/json")
                .field("chat_id", update.message().from().id())
                .field("text", "Привет, " + update.message().from().firstName())
                .asJson();

        return update;
    }
}