package com.dylinstoen.issuetracker.web;

import com.dylinstoen.issuetracker.dao.IssueDAO;
import com.dylinstoen.issuetracker.model.Issue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/issues/create")
public class IssueCreate extends HttpServlet {
    private final IssueDAO issueDAO = new IssueDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Issue issue = new Issue();
        issue.setTitle(req.getParameter("title"));
        issue.setDescription(req.getParameter("description"));
        issue.setStatus(req.getParameter("status"));
        issue.setPriority(req.getParameter("priority"));

        issueDAO.createIssue(issue);

        resp.sendRedirect(req.getContextPath() + "/issues");
    }
}