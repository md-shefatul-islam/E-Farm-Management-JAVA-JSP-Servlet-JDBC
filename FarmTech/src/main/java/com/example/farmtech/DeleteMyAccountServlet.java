package com.example.farmtech;

import com.example.database.*;

import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deletemyaccount", value = "/deletemyaccount")
public class DeleteMyAccountServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    LoginDb ldb = new LoginDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            boolean isValid = fdb.deletemyaccount(username);
            boolean isValid1 = ldb.deletemyaccount(username);
            if (isValid && isValid1) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("delete", "success");
                dispatcher.forward(request, response);
            }
            else{

                Farmer user = fdb.profile(username);
                RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/profile.jsp");
                request.setAttribute("user", user);
                request.setAttribute("delete", "failed");
                dispatcher.forward(request, response);

            }

        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
