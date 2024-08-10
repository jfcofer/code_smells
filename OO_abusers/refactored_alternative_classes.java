public interface Notification {
    void send(String recipient, String message);
}

public class EmailNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending email to: " + recipient);
        System.out.println("Subject: " + extractSubjectFromMessage(message));
        System.out.println("Body: " + message);
    }

    private String extractSubjectFromMessage(String message) {
        // Assume the first line of the message is the subject
        int firstLineEnd = message.indexOf("\n");
        return firstLineEnd != -1 ? message.substring(0, firstLineEnd) : "";
    }
}

public class SMSNotification implements Notification {

    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to: " + recipient);
        System.out.println("Message: " + message);
    }
}

public class NotificationService {

    private Notification notification;

    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void notify(String recipient, String message) {
        notification.send(recipient, message);
    }
}