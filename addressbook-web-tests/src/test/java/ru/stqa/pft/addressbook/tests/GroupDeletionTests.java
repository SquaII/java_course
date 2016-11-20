package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("test1").withHeader("header").withFooter("test3"));
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().list();
        int selectedGroupPosition = before.size() - 1;
        app.group().delete(selectedGroupPosition);
        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(selectedGroupPosition);
        Assert.assertEquals(before, after);
    }

}
