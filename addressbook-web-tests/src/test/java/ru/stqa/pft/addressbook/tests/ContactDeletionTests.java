package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (! app.contact().isThereAContact()) {
            app.contact().create(new ContactData()
                .withContactNameData(new ContactNameData().withFirstName("first").withLastName("last")));
        }
    }

    /* Тест удаляет первый контакт из списке контактов */
    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().list();

        app.contact().delete();
        app.goTo().homePage();

        // check result
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(0);
        Assert.assertEquals(before, after);
    }

}
