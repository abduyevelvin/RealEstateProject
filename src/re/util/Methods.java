package re.util;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Methods {

    public static boolean sendMail(String subject, String body, String mailTo) {
        boolean result = false;
        final String username = "elvin.abduyev@gmail.com";
        final String password = "melek1989";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("elvin.abduyev@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
            //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("abduyev.elvin@gmail.com"));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Mail is sent!");
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public static String generatePassword() {
        //DateFormat df = new SimpleDateFormat("ddMMyyyyHHMMSS");
        Random r = new Random();
        String password = "";
        for(int i = 0; i < 3; i++) {
            password += r.nextInt(3) + 1;
        }

        return password;
    }

    public static String addEndingToFileName() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHMMSS");
        String ending = df.format(new Date());

        return ending;
    }
}
