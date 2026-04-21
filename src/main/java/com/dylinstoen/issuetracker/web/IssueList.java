package com.dylinstoen.issuetracker.web;

import com.dylinstoen.issuetracker.dao.IssueDAO;
import com.dylinstoen.issuetracker.model.Issue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/issues")
public class IssueList extends HttpServlet {
    private final IssueDAO issueDAO = new IssueDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Issue> issues = issueDAO.getAllIssues();
        req.setAttribute("issues", issues);
        req.getRequestDispatcher("/WEB-INF/views/issues.jsp").forward(req, resp);
    }
}