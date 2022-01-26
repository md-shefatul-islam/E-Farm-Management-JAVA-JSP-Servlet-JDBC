package com.example.farmtech;

import com.example.database.FarmerDb;
import com.example.model.Farmer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "search", value = "/search")
public class SearchUserServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        //start
        String search = request.getParameter("search");
        //String todaydate = request.getParameter("todaydate");
//        HttpSession session=request.getSession();
//        session.removeAttribute("token");
//        String username = (String) session.getAttribute("username");
        //String todaydate = (String) session.getAttribute("todaydate");


        //out.println("today date here..."+todaydate);

        try {
            List<Farmer> user;
            user = fdb.searchuser(search);
            if (user.isEmpty()){
                RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/alluser.jsp");
//                request.setAttribute("alluser", "");
                request.setAttribute("search", "failed");
                dispatcher.forward(request, response);
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
