package com.example.demo_tss.controller;

import com.example.demo_tss.entity.Note;
import com.example.demo_tss.service.FirebaseMessagingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {


    private FirebaseMessagingService fcmService;

    public PushNotificationController(FirebaseMessagingService fcmService) {
        this.fcmService = fcmService;
    }

    @PostMapping("/notification")
    public String sendNotification(@RequestBody Note note) {
        String token = note.getToken();
        return fcmService.sendNotification(note);
    }
}
