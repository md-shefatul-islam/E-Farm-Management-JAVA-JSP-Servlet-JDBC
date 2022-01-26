package com.example.farmtech;

import com.example.database.CropDb;
import com.example.database.OrderDb;
import com.example.database.SeedDb;
import com.example.model.Crop;
import com.example.model.Order;
import com.example.model.Seed;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "deleteseedorder", value = "/deleteseedorder")
public class DeleteSeedOrderServlet extends HttpServlet {
    OrderDb odb = new OrderDb();
    SeedDb sdb = new SeedDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String date = (String) session.getAttribute("seeddate");
        Cookie cookie = new Cookie("name", "");
        Cookie cookie1 = new Cookie("orderinsert", "");
        Cookie cookie2 = new Cookie("alert", "");
        cookie.setMaxAge(0);
        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
//        out.println("in delete");
        try{
            Order order = odb.selectOrder(date);


            RequestDispatcher dispatcher = request.getRequestDispatcher("order/deleteSeedOrder.jsp");
            request.setAttribute("order", order);
            response.addCookie(cookie);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            out.println("error in delete");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String date = (String) session.getAttribute("seeddate");
        session.removeAttribute("orderquantity");
        boolean isValid = odb.deleteOrder(date);
        if(isValid){

            List<Seed> seed;
            seed = sdb.allseed();
            RequestDispatcher dispatcher = request.getRequestDispatcher("order/seedlist.jsp");
            request.setAttribute("delete", "success");
            request.setAttribute("allseed", seed);
            dispatcher.forward(request, response);
        }
        else{
            out.println("allah help");
        }
    }
}
