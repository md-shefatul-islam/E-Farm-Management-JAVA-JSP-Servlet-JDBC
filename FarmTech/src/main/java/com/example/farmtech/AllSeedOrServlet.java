package com.example.farmtech;

import com.example.database.SeedDb;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "allseedor", value = "/allseedor")
public class AllSeedOrServlet extends HttpServlet {
    SeedDb sdb = new SeedDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();


        try {
//            String funame = (String) session.getAttribute("username");
            List<Seed> seed;
            seed = sdb.allseed();
            session.removeAttribute("orderquantity");
            session.removeAttribute("orderid");
            session.removeAttribute("orderquantity");

            if (seed.isEmpty()){
                RequestDispatcher dispatcher = request.getRequestDispatcher("order/seedlist.jsp");
                request.setAttribute("allseed", "");
                dispatcher.forward(request, response);
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("order/seedlist.jsp");
                request.setAttribute("allseed", seed);
                dispatcher.forward(request, response);
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
