//package ua.cv.vacancy.email;
//
//import org.apache.catalina.Session;
//
//import java.util.Properties;
//
//public class SendEmail {
//    public void sendingEmail(){
//        // Необходимо указать адрес электронной почты получателя
//        String to = "abcd@gmail.com";
//
//        // Необходимо указать адрес электронной почты отправителя
//        String from = "web@gmail.com";
//
//        // Предполагая, что вы отправляете электронное письмо с localhost
//        String host = "localhost";
//
//        // Получить свойства системы
//        Properties properties = System.getProperties();
//
//        // Настроить почтовый сервер
//        properties.setProperty("mail.smtp.host", host);
//
//        // Получение объекта Session по умолчанию
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            // Создание объекта MimeMessage по умолчанию
//            MimeMessage message = new MimeMessage(session);
//
//            // Установить От: поле заголовка
//            message.setFrom(new InternetAddress(from));
//
//            // Установить Кому: поле заголовка
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Установить тему: поле заголовка
//            message.setSubject("Это тема письма!");
//
//            // Теперь установите фактическое сообщение
//            message.setText("Это актуальное сообщение");
//
//            // Отправить сообщение
//            Transport.send(message);
//            System.out.println("Сообщение успешно отправлено....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//
//    public static void main(String [] args) {
//
//    }
//
//    String d_email = "sofien.fkih@gmail.com",
//            d_password = "",
//            d_host = "smtp.gmail.com",
//            d_port = "465",
//            m_to = "sofien.fkih@gmail.com",
//            m_subject = "Testing",
//            m_text = "Hey, this is the testing email.";
//
//    // Those are the values that have the email information
//    public void send(String from, String pass, String host, String port, String to, String subject, String text) {
//
//        Properties props = new Properties();
//
//        // Read properties file.
//
//        props.put("mail.smtp.user", from);
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.socketFactory.port", port);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//
//        SecurityManager security = System.getSecurityManager();
//
//        try {
//            Authenticator auth = new SMTPAuthenticator();
//            Session session = Session.getInstance(props, auth);
//            MimeMessage msg = new MimeMessage(session);
//
//            msg.setText(text);
//            msg.setSubject(subject);
//            msg.setFrom(new InternetAddress(from));
//            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            Transport.send(msg);
//        } catch (Exception mex) {
//            mex.printStackTrace();
//        }
//    }
//
//    public class SMTPAuthenticator extends javax.mail.Authenticator {
//
//        public PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication(d_email, d_password);
//        }
//    }
//}
