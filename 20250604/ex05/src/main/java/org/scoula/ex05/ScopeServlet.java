package org.scoula.ex05;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.scoula.ex05.domain.Member;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;
    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        sc.setAttribute("scopeName", "applicationScope 값"); // Application Scope
        HttpSession session = req.getSession(); // Session Scope
        session.setAttribute("scopeName", "sessionScope 값");
        req.setAttribute("scopeName", "requestScope 값"); // Request Scope
        Member member = new Member("홍길동", "hong");
        req.setAttribute("member", member);
        req.getRequestDispatcher("scope.jsp").forward(req, res);
    }
}