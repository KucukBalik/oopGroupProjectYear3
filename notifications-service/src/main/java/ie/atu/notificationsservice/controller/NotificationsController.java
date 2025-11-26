package ie.atu.notificationsservice.controller;

import ie.atu.notificationsservice.service.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/notifications")
@RestController

public class NotificationsController {




    // Constructor Based Dependency Injection
    private final NotificationsService notificationsService;

    public NotificationsController (NotificationsService notificationsService) { this.notificationsService = notificationsService; }


    @GetMapping(" /ReturnAllUsers")

    public ResponseEntity<String> ReturnAllUsers() {
        return ResponseEntity.ok(notificationsService.ReturnAllUsers());
    }
    // Rethink endpoints needed

}
//**********************************************************************
/*
 Create basic endpoints for notifications service

 */