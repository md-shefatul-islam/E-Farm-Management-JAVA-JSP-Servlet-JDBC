package com.example.farmtech;

import com.example.database.FarmerDb;
import com.example.database.LoginDb;
import com.example.model.Farmer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "check", value = "/check")
public class CheckServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

        RequestDispatcher dispatcher = request.getRequestDispatcher("check.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String uname = request.getParameter("username");
        String dob = request.getParameter("dob");

        Farmer user = fdb.check(uname,dob);
        if (uname.equals(user.getUname()) && (dob.equals(user.getDob()))){
//            RequestDispatcher dispatcher = request.getRequestDispatcher("validate.jsp");
//            dispatcher.forward(request, response);
            response.sendRedirect("checkpass");
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("check.jsp");
            request.setAttribute("check","failed");
            dispatcher.forward(request, response);
        }
    }
}
