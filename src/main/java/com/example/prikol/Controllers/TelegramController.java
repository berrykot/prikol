package com.example.prikol.Controllers;

//import com.example.prikol.Models.*;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.*;

import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import kong.unirest.Unirest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TelegramController {

    final String telegramUrl = "https://api.telegram.org/bot5180751190:AAFCfs7DqJCVvVfvqz9bId-bLc8JFUpeYuk";
    private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));

    @RequestMapping("/")
    @ResponseBody
    public void index(@RequestBody String request) {
        var update = BotUtils.parseUpdate(request);
        var chatId = update.message().from().id();
        var username = update.message().from().username();
        var text = update.message().text();

        var requestSendMessage = new SendMessage(chatId, username + ", Вы сказали, " + text);
        bot.execute(requestSendMessage);
    }
}