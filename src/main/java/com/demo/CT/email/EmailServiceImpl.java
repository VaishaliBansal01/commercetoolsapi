package com.demo.CT.email;


// Java Program to Illustrate Creation Of
// Service implementation class



// Importing required classes
//        import com.SpringBootEmail.Entity.EmailDetails;
        //        import javax.mail.MessagingException;
//        import javax.mail.internet.MimeMessage;
        import com.demo.CT.email.EmailDetails;
        import com.demo.CT.email.EmailService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
                import org.springframework.mail.SimpleMailMessage;
        import org.springframework.mail.javamail.JavaMailSender;
                import org.springframework.stereotype.Service;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    // Method 1
    // To send a simple email
    public String sendSimpleMail(String Recipient,String Body, String Subject)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(Recipient);
            mailMessage.setText(Subject);
            mailMessage.setSubject(Body);

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    // Method 2
    // To send an email with attachment


}
