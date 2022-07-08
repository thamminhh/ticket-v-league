package com.example.demo_tss;

import com.example.demo_tss.repository.TicketRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
public class DemoTssApplication {

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException {
        FileInputStream initialFirebaseFile = new FileInputStream("src/main/resources/service-account-file.json");
        FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(initialFirebaseFile)).build();
        if (FirebaseApp.getApps().isEmpty()) {
           FirebaseApp app = FirebaseApp.initializeApp(options, "my-app");
        }
        return FirebaseMessaging.getInstance(FirebaseApp.initializeApp(options, "my-app"));
    }
    public static void main(String[] args) throws IOException {

        FileInputStream initialFirebaseFile = new FileInputStream("src/main/resources/service-account-file.json");
        FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(initialFirebaseFile)).build();
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
//        FirebaseToken decoded = FirebaseAuth.getInstance().verifyIdToken("eyJhbGciOiJSUzI1NiIsImtpZCI6Ijk4OTdjZjk0NTllMjU0ZmYxYzY3YTRlYjZlZmVhNTJmMjFhOWJhMTQiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiY29uZ2hpZXUgbGUiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EtL0FPaDE0R2hab1gwaE1Pblc5dFdqamtaNGV4QXYxNEVlbE1HODVBcnBmZjRmcHc9czk2LWMiLCJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vdmxlYWd1ZS10aWNrZXQiLCJhdWQiOiJ2bGVhZ3VlLXRpY2tldCIsImF1dGhfdGltZSI6MTY1NjQ4ODY0OSwidXNlcl9pZCI6InVZYWF2eVJnUElWWWp0YkRJRG5jZDdmUUYwMDIiLCJzdWIiOiJ1WWFhdnlSZ1BJVllqdGJESURuY2Q3ZlFGMDAyIiwiaWF0IjoxNjU2NDg4NjUwLCJleHAiOjE2NTY0OTIyNTAsImVtYWlsIjoiZm9yam9iLmxlY29uZ2hpZXVAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZ29vZ2xlLmNvbSI6WyIxMDI4NzAzOTMyNDkzMDI1OTk1OTIiXSwiZW1haWwiOlsiZm9yam9iLmxlY29uZ2hpZXVAZ21haWwuY29tIl19LCJzaWduX2luX3Byb3ZpZGVyIjoiZ29vZ2xlLmNvbSJ9fQ.gPENAoZfFHqOElHFhDFk4CQHOKai84rHu1M7j7uasv81iyR7csMx_qVDgWz9jELUINZhxdCzZdEghGmsZfU48Tr-S9zcCPJWPp6cn_ukhYkLEfj5z7JQL4pRA_N5jQmO23fw63baWrAloyAbhz97JoeeWhfc3TCjFzVz5QPUHo4XH82B9rizIbgYJzQOpALi3DIN0xUfdLC0w6_pDstucPIamj021TL_ES74de3SXTK1-d3eUzJj56OH0d2RFs4KHXCmc5w6FURb6o4G3NlHGUQYnLVnnjIcR-2pVWK3zROaF0mxoynWOtBH3AoL-Gl68QotjIjIxSpS9joeMfwYlA");
//        String userName = decoded.getName();
//        System.out.println("USERNAME: " + userName);
        SpringApplication.run(DemoTssApplication.class, args);
    }

}
