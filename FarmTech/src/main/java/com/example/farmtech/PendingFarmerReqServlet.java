package com.example.farmtech;

import com.example.database.CropDb;
import com.example.database.OrderDb;
import com.example.model.Crop;
import com.example.model.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "pendingfarmerreq", value = "/pendingfarmerreq")
public class PendingFarmerReqServlet extends HttpServlet {
    OrderDb odb = new OrderDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();


        try {
//            String funame = (String) session.getAttribute("username");
            List<Order> order;
            order = odb.allorder();

            if (order.isEmpty()){
                RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerpendinglist.jsp");
                request.setAttribute("order", "");
                dispatcher.forward(request, response);
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerpendinglist.jsp");
                request.setAttribute("order", order);
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
