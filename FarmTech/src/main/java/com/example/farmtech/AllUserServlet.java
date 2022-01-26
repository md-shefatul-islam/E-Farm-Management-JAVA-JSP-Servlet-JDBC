package com.example.farmtech;

import com.example.database.*;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "alluser", value = "/alluser")
public class AllUserServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        //start
        //String username = request.getParameter("username");
        //String todaydate = request.getParameter("todaydate");
//        HttpSession session=request.getSession();
//        session.removeAttribute("token");
//        String username = (String) session.getAttribute("username");
        //String todaydate = (String) session.getAttribute("todaydate");


        //out.println("today date here..."+todaydate);

        try {
            List<Farmer> user;
            user = fdb.alluser();
            if (user.isEmpty()){
                out.println("allah help me");
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/alluser.jsp");
                request.setAttribute("alluser", user);
                dispatcher.forward(request, response);
//                out.println("allah help us");
            }
        } catch (Exception e) {
            out.println("Error while connecting database");
            out.println(e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
