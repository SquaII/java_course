package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactNameData;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("header").withFooter("test3"));
        }

        boolean allContactsBinded = true;
        for (ContactData contact : app.db().contacts()) {
            if (contact.getGroups().size() == 0) {
                allContactsBinded = false;
            }
        }
        if (app.db().contacts().size() == 0 || allContactsBinded) {
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withContactNameData(new ContactNameData().withFirstName("first").withLastName("last")));
        }
    }

    @Test
    public void AddContactToGroup() {
        ContactData contact = null;
        for (ContactData c : app.db().contacts()) {
            if (c.getGroups().size() == 0) {
                contact = c;
            }
        }
        GroupData group = app.db().groups().iterator().next();
        app.goTo().homePage();
        app.contact().addToGroup(contact, group);
        int contactID = contact.getId();
        ContactData bindedContact = null;
        for (ContactData c : app.db().contacts()) {
            if (c.getId() == contactID) {
                bindedContact = c;
            }
        }
        assertThat(bindedContact.getGroups().size(), equalTo(1));
        assertThat(bindedContact.getGroups().iterator().next(), equalTo(group));
    }
}
