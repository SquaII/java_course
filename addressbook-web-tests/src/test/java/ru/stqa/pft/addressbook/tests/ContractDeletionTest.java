package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContractDeletionTest extends TestBase {

    @Test
    public void testContractDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();

    }
}
