package com.dylinstoen.issuetracker.web;

import com.dylinstoen.issuetracker.dao.IssueDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/issues/delete")
public class IssueDelete extends HttpServlet {
    private final IssueDAO issueDAO = new IssueDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        issueDAO.deleteIssue(id);

        resp.sendRedirect(req.getContextPath() + "/issues");
    }
}