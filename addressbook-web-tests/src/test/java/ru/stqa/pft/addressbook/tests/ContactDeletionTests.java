package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    /* Тест удаляет первый контакт из списке контактов */
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();

        // prepare data
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(new ContactNameData("first", null, "last", null)));
        }
        List<ContactData> before = app.getContactHelper().getContactList();

        // delete contact
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();

        // check result
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(0);
        Assert.assertEquals(before, after);
    }

}
