package ru.stqa.pft.rest;

import org.testng.SkipException;

import java.io.IOException;

public class TestBase {

    protected static final RestHelper restHelper = new RestHelper();

    public boolean isIssueOpen(int issueId) throws IOException {
        for (Issue issue : restHelper.getIssues()) {
            if (issue.getId() == issueId) {
                if (issue.getState_name().equals("In Progress") || issue.getState_name().equals("Open")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
