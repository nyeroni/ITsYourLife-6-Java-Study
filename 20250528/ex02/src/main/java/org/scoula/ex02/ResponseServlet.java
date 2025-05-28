package org.scoula.ex02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)

            throws IOException, ServletException {

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.print("<html><body>");
        out.print("ResponseServlet 요청 성공");
        out.print("</body></html>");
    }
}