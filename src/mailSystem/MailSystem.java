package mailSystem;

import java.util.ArrayList;
import java.util.List;

public class MailSystem {
    private List<User> users;
    private List<Mail> inbox;
    private List<Mail> outbox;
    private List<Mail> sent;

    public MailSystem() {
        users = new ArrayList<>();
        inbox = new ArrayList<>();
        outbox = new ArrayList<>();
        sent = new ArrayList<>();
    }

    public void signUp(String username, String password, String email) {
        users.add(new User(username, password, email));
    }

    public boolean signIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void composeMail(String sender, String recipient, String subject, String body){
        Mail mail = new Mail(sender, recipient, subject, body);
        outbox.add(mail);
        sent.add(mail);
        receiveMail(mail);
        System.out.println("Mail composed successfully");
    }
    private void receiveMail(Mail mail){
        inbox.add(mail);
    }

    public void displayUnreadMails() {
        System.out.println("Unread mails: ");
        for (Mail mail : inbox) {
            if (!mail.isRead()) {
                System.out.println("From: " + mail.getSender());
                System.out.println("Subject: " + mail.getSubject());
                System.out.println("Body: " + mail.getBody());
                mail.setRead(true);
                System.out.println("_____________________________________");
            }
        }
    }
    public void displayInbox(){
        System.out.println("Inbox: ");
        for (Mail mail : inbox){
            System.out.println("To: " +mail.getRecipient());
            System.out.println("Subject: "+ mail.getSubject());
            System.out.println("Body: " + mail.getBody());
            System.out.println("________________________________________");
        }
    }
        public void displayOutbox(){
            System.out.println("Outbox: ");
            for (Mail mail : outbox){
                System.out.println("To: " + mail.getRecipient());
                System.out.println("Subject: " + mail.getSubject());
                System.out.println("Body: " + mail.getBody());
                System.out.println("_______________________________________");
            }
        }
        public void displaySent(){
            System.out.println("Sent Mails: ");
            for (Mail mail : sent){
                System.out.println("To: " +mail.getRecipient());
                System.out.println("Subject: "+ mail.getSubject());
                System.out.println("Body: " + mail.getBody());
                System.out.println("______________________________________");
            }
        }
        public void deleteMailFromInbox(int mailIndex){
        if(mailIndex >= 0 && mailIndex < inbox.size()){
            inbox.remove(mailIndex);
            System.out.println("Mail deleted from inbox.");
        }else{
            System.out.println("Invalid mail index.");
        }
        }
        public void deleteMailFromOutbox(int mailIndex){
        if(mailIndex >= 0 && mailIndex < outbox.size()){
            outbox.remove(mailIndex);
            System.out.println("Mail deleted from outbox.");
        }else {
            System.out.println("Invalid mail index.");
        }
        }
        public void deleteMailFromSent(int mailIndex){
        if (mailIndex >= 0 && mailIndex < sent.size()){
            sent.remove(mailIndex);
            System.out.println("Mail deleted from sent.");
        }else {
            System.out.println("Invalid mail index.");
        }
        }

        public User getUser(String username){
        for (User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
        }



}