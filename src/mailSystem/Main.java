package mailSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MailSystem mailsystem = new MailSystem();
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        User currentUser = null;
        String username;
        String password;

        while (true){
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit ");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter Username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter Password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter EmailID: ");
                    String email = scanner.nextLine();
                    mailsystem.signUp(username, password, email);
                    System.out.println("Successfully signed Up.");
                    break;

                case 2:
                    System.out.println("Enter Username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    password = scanner.nextLine();
                    if(mailsystem.signIn(username, password)){
                        System.out.println("Login Successfully!");
                        isLoggedIn = true;
                        currentUser = mailsystem.getUserByUsername(username);
                    }else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting. ");
                    System.out.println("See You Later :) ");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. please try again.");
                    break;
            }

            if (isLoggedIn){
                while (isLoggedIn){
                    System.out.println("01. Compose Mail: ");
                    System.out.println("02. View Inbox: ");
                    System.out.println("03. View Outbox: ");
                    System.out.println("04. View sent mail: ");
                    System.out.println("05. View Unread mails: ");
                    System.out.println("06. Delete mail from Inbox: ");
                    System.out.println("07. Delete mail from Outbox: ");
                    System.out.println("08. Delete mail from Sent Mails: ");
                    System.out.println("09. Logout");
                    System.out.println("choose an option: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){
                        case 1:
                            System.out.println("Enter recipient: ");
                            String recipient = scanner.nextLine();
                            System.out.println("Enter subject: ");
                            String subject = scanner.nextLine();
                            System.out.println("Enter body: ");
                            String body = scanner.nextLine();
                            mailsystem.composeMail(currentUser.getEmail(), recipient, subject, body);
                            System.out.println("Mail composed successfully.");
                            break;

                        case 2:
                            mailsystem.displayInbox();
                            break;
                        case 3:
                            mailsystem.displayOutbox();
                            break;
                        case 4:
                            mailsystem.displaySent();
                            break;
                        case 5:
                            mailsystem.displayUnreadMails();
                            break;
                        case 6:
                            System.out.println("Enter mail index to delete from inbox: ");
                            int inboxIndex = scanner.nextInt();
                            scanner.nextLine();
                            mailsystem.deleteMailFromInbox(inboxIndex);
                            break;
                        case 7:
                            System.out.println("Enter mail index to delete from outbox: ");
                            int outboxIndex = scanner.nextInt();
                            scanner.nextLine();
                            mailsystem.deleteMailFromOutbox(outboxIndex);
                            break;
                        case 8:
                            System.out.println("Enter mail index to delete from sent: ");
                            int sentIndex = scanner.nextInt();
                            scanner.nextLine();
                            mailsystem.deleteMailFromSent(sentIndex);
                            break;
                        case 9:
                            isLoggedIn = false;
                            currentUser = null;
                            System.out.println("Logged out successfully.");
                            break;
                        default:
                            System.out.println("Invalid choice. Try again ");
                            break;
                    }
                }
            }

        }

    }

}
