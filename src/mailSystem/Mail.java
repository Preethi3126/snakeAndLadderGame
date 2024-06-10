package mailSystem;

public class Mail {
    private final String sender;
    private final String recipient;
    private final String subject;
    private final String body;
    private boolean isRead;

    public Mail(String sender,String recipient, String subject, String body){
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.isRead = false;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
