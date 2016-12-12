package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactNameData;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroup extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("header").withFooter("test3"));
        }

        boolean noContactsBinded = true;
        for (ContactData contact : app.db().contacts()) {
            if (contact.getGroups().size() != 0) {
                noContactsBinded = false;
            }
        }
        if (app.db().contacts().size() == 0 || noContactsBinded) {
            app.goTo().homePage();
            app.contact().create(new ContactData()
                    .withContactNameData(new ContactNameData().withFirstName("first").withLastName("last")));
            GroupData group = app.db().groups().iterator().next();
            ContactData contact = null;
            for (ContactData c : app.db().contacts()) {
                if (c.getGroups().size() == 0) {
                    contact = c;
                }
            }
            app.contact().addToGroup(contact, group);
        }
    }

    @Test
    public void RemoveContactFromGroup() {
        ContactData contact = null;
        GroupData group = null;
        for (ContactData c : app.db().contacts()) {
            if (c.getGroups().size() != 0) {
                contact = c;
                group = c.getGroups().iterator().next();
            }
        }
        app.goTo().homePage();
        app.contact().removeFromGroup(contact, group);
        int contactID = contact.getId();
        ContactData unbindedContact = null;
        for (ContactData c : app.db().contacts()) {
            if (c.getId() == contactID) {
                unbindedContact = c;
            }
        }
        assertThat(unbindedContact.getGroups().size(), equalTo(0));
    }
}
