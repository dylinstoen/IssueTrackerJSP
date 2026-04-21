package com.dylinstoen.issuetracker.dao;

import com.dylinstoen.issuetracker.model.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IssueDAO {
    private static final List<Issue> issues = new ArrayList<>();
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Issue> getAllIssues() {
        return new ArrayList<>(issues);
    }

    public void createIssue(Issue issue) {
        issue.setId(idCounter.getAndIncrement());
        issues.add(issue);
    }
    public void deleteIssue(int id) {
        issues.removeIf(issue -> issue.getId() == id);
    }
}
