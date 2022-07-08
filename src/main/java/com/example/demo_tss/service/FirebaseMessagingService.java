package com.example.demo_tss.service;

import com.example.demo_tss.entity.Note;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String sendNotification(Note note) {
        Notification notification = Notification.builder().setTitle(note.getSubject()).setBody(note.getContent()).build();

        Message message = Message.builder().setToken(note.getToken()).setNotification(notification).putData("content", note.getContent()).build();
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        return response;
    }



}
