package com.example.farmtech;

import com.example.database.FarmerDb;
import com.example.model.*;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "profile", value = "/profile")
public class ProfileServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            Farmer user = fdb.profile(username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/profile.jsp");
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
//       out.println("in registrations"+user.getName());

        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
