package ie.atu.notificationsservice.service;

import ie.atu.notificationsservice.dto.BookDueSoonRequestDTO;
import ie.atu.notificationsservice.dto.BookOverdueRequestDTO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendBookDueSoon(BookDueSoonRequestDTO request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getUserEmail());
        msg.setSubject("Book Due Soon: " + request.getBookTitle());
        msg.setText("Your book \"" + request.getBookTitle() + "\" is due on " + request.getDueDate());
        //mailSender.send(msg);                                                                         // error 500 from email settings issue
        System.out.println("EMAIL WOULD SEND: " + msg);                                                  // for testing

    }

    public void sendBookOverdue(BookOverdueRequestDTO request) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(request.getUserEmail());
        msg.setSubject("Book Overdue: " + request.getBookTitle());
        msg.setText("Your book \"" + request.getBookTitle() + "\" was due on " + request.getDueDate());
        //mailSender.send(msg);                                                                         // error 500 from email settings issue
        System.out.println("EMAIL WOULD SEND: " + msg);                                                 // for testing

    }
}

