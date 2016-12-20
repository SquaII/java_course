package ru.stqa.pft.mantis.tests;


import biz.futureware.mantis.rpc.soap.client.IssueData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase{

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(app.soap().getRandomIssueId());
        Set<Project> projects = app.soap().getProjects();
        Issue  issue = new Issue().withSummary("TestIssue")
                .withDescription("Test issue description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
    }
}
