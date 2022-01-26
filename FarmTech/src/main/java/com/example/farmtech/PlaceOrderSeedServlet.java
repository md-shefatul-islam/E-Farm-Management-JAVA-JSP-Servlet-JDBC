package com.example.farmtech;

import com.example.database.*;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "placeorderseed", value = "/placeorderseed")
public class PlaceOrderSeedServlet extends HttpServlet {
    OrderDb odb = new OrderDb();
    SeedDb sdb = new SeedDb();
    Order order = new Order();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        java.util.Date date = new java.util.Date();
        try{
            Cookie cookie = new Cookie("name", "close");
            Cookie cookie1 = new Cookie("orderinsert", "success");
            Cookie cookie2 = new Cookie("alert", "alert");
            cookie.setMaxAge(10);
            cookie1.setMaxAge(10);
            cookie2.setMaxAge(10);



//            String id = (String) session.getAttribute("orderid");
            String name = request.getParameter("name");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String dates = date.toString();
            String suname = (String) session.getAttribute("ordersuname");
            String buname = (String) session.getAttribute("username");
            String status = "pending";
            String type = "seed";

//            session.setAttribute("seeddate", dates);

            Order order = new Order(name, quantity, price, dates, suname, buname, status, type);
            List<Seed> seed;
            seed = sdb.allseed();
//            out.println("in registrations"+date);



            if(null == session.getAttribute("updatequantity")) {

                boolean isValid = odb.insert(order);
                if (isValid) {
                    session.setAttribute("seeddate", dates);
//                    Cookie cookie = new Cookie("name", "close");
//                    Cookie cookie1 = new Cookie("orderinsert", "success");
//                    Cookie cookie2 = new Cookie("alert", "alert");
//                    cookie.setMaxAge(10);
//                    cookie1.setMaxAge(10);
//                    cookie2.setMaxAge(10);

                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);

                    response.sendRedirect("cookieseed");
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("order/seedlist.jsp");
                    request.setAttribute("orderinsert", "failed");
                    request.setAttribute("allseed", seed);
                    dispatcher.forward(request, response);
                }
            }
            else{
                String olddate = (String) session.getAttribute("seeddate");
                Order uporder = new Order(quantity, olddate);
                boolean isValid = odb.updateorder(uporder);
                if (isValid) {

//                    Cookie cookie = new Cookie("name", "close");
//                    Cookie cookie1 = new Cookie("orderinsert", "success");
//                    Cookie cookie2 = new Cookie("alert", "alert");
//                    cookie.setMaxAge(10);
//                    cookie1.setMaxAge(10);
//                    cookie2.setMaxAge(10);

                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);

                    response.sendRedirect("cookieseed");

                } else {
//                out.println("allh with us");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("order/seedlist.jsp");
                    request.setAttribute("orderinsert", "update");
                    request.setAttribute("allseed", seed);
                    dispatcher.forward(request, response);
                }
            }

        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }
}
