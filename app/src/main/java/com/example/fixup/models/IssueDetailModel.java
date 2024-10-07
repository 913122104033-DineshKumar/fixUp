package com.example.fixup.models;

import java.util.ArrayList;
import java.util.List;

public class IssueDetailModel {
    public String userEmail;
    public String imageUri;
    public String issueTitle;
    public String issueContent;
    public String issueCity;
    public String issueArea;
    public int issuePriority;
    public int issueVolunteersNeeded;
    public List<String> issueVolunteers;
    public boolean isIssueOpen;

    public IssueDetailModel(String userEmail, String imageUri, String issueTitle, String issueContent,
                            String issueCity, String issueArea, int issuePriority, int issueVolunteersNeeded) {
        this.userEmail = userEmail;
        this.imageUri = imageUri;
        this.issueTitle = issueTitle;
        this.issueContent = issueContent;
        this.issueCity = issueCity;
        this.issueArea = issueArea;
        this.issuePriority = issuePriority;
        this.issueVolunteersNeeded = issueVolunteersNeeded;
        this.issueVolunteers = new ArrayList<>();
        this.isIssueOpen = true;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public String getIssueContent() {
        return issueContent;
    }

    public String getIssueCity() {
        return issueCity;
    }

    public String getIssueArea() {
        return issueArea;
    }

    public int getIssuePriority() {
        return issuePriority;
    }

    public int getIssueVolunteersNeeded() {
        return issueVolunteersNeeded;
    }

    public List<String> getIssueVolunteers() {
        return issueVolunteers;
    }

    public boolean isIssueOpen() {
        return isIssueOpen;
    }
    public void setIsIssueOpen() {
        this.isIssueOpen = false;
    }
}
