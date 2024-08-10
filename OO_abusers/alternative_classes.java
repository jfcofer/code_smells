public class EmailNotification {

    public void sendEmail(String recipient, String subject, String body) {
        System.out.println("Sending email to: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}

public class SMSNotification {

    public void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to: " + phoneNumber);
        System.out.println("Message: " + message);
    }
}

public class NotificationService {

    private EmailNotification emailNotification = new EmailNotification();
    private SMSNotification smsNotification = new SMSNotification();

    public void notifyByEmail(String recipient, String subject, String body) {
        emailNotification.sendEmail(recipient, subject, body);
    }

    public void notifyBySMS(String phoneNumber, String message) {
        smsNotification.sendSMS(phoneNumber, message);
    }
}