package ru.stqa.pft.mantis.appmanager;


import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.User;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public void signUp(String username, String email, String password) throws IOException, MessagingException {
        app.registration().start(username, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String confirmationLink = app.registration().findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.xpath("//input[@class='button']"));
    }

    public String resetPasswordByAdmin(User user) throws IOException, MessagingException {
        wd.get(app.getProperty("web.baseUrl") + "/my_view_page.php");
        click(By.className("manage-menu-link"));
        click(By.xpath("//a[@href='/mantisbt//manage_user_page.php']"));
        click(By.xpath(String.format("//table//td//a[text()='%s']", user.getUsername())));
        click(By.xpath("//form[@id='manage-user-reset-form']//input[@class='button']"));
        return findResetPasswordLink(user);
    }

    private String findResetPasswordLink(User user) throws IOException, MessagingException {
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 15000);
        String sequence = "Someone (presumably you) requested a password change through e-mail";
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.text.contains(sequence)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    public void changePassword(String changePasswordLink, String password) {
        wd.get(changePasswordLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.xpath("//input[@class='button']"));
    }
}
