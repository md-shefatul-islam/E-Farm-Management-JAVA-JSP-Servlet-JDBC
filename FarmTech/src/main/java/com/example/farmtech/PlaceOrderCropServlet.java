package com.example.farmtech;

import com.example.database.*;
import com.example.model.*;
import com.example.model.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "placeordercrop", value = "/placeordercrop")
public class PlaceOrderCropServlet extends HttpServlet {
    OrderDb odb = new OrderDb();
    CropDb cdb = new CropDb();
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
            String type = "crop";


            Order order = new Order(name, quantity, price, dates, suname, buname, status, type);
            List<Crop> crop;
            crop = cdb.allcrop();
//            out.println("in registrations"+date);




//            int oldquantity = (int) session.getAttribute("orderquantity");
            if(null == session.getAttribute("updatequantity")){

                boolean isValid = odb.insert(order);
                if (isValid) {
                    session.setAttribute("cropdate", dates);
//                    Cookie cookie = new Cookie("name", "close");
//                    Cookie cookie1 = new Cookie("orderinsert", "success");
//                    Cookie cookie2 = new Cookie("alert", "alert");
//                    cookie.setMaxAge(10);
//                    cookie1.setMaxAge(10);
//                    cookie2.setMaxAge(10);

                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);

                    response.sendRedirect("cookie");

                }else {
//                out.println("allh with us");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("order/croplist.jsp");
                    request.setAttribute("orderinsert", "failed");
                    request.setAttribute("allcrop", crop);
                    dispatcher.forward(request, response);
                }
            }
            else{
                String olddate = (String) session.getAttribute("cropdate");
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

                    response.sendRedirect("cookie");

                }else {
//                out.println("allh with us");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("order/croplist.jsp");
                    request.setAttribute("orderinsert", "update");
                    request.setAttribute("allcrop", crop);
                    dispatcher.forward(request, response);
                }

            }


        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }
}
