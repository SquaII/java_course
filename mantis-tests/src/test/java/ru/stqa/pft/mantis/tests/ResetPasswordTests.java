package ru.stqa.pft.mantis.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.User;

import javax.mail.MessagingException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() throws IOException, MessagingException {
        app.mail().start();
        if (app.db().users().size() < 2) {
            long now = System.currentTimeMillis();
            String username = "user" + now;
            String password = "password";
            String email = username + "@localhost.localdomain";
            app.user().signUp(username, email, password);
        }
    }

    @Test
    public void testResetPasswordByAdmin() throws IOException, MessagingException {
        String password = "password";
        // get not admin user
        User user = null;
        for (User u : app.db().users()) {
            if (u.getUsername() != app.getProperty("web.adminLogin")) {
                user = u;
            }
        }
        app.user().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));    // Logging as admin
        String resetPasswordLink = app.user().resetPasswordByAdmin(user);
        app.user().changePassword(resetPasswordLink, password);

        HttpSession session = app.newSession();
        assertTrue(session.login(user.getUsername(), password));
        assertTrue(session.isLoggedInAs(user.getUsername()));
    }

}
