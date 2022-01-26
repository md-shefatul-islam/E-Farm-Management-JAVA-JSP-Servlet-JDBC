package com.example.farmtech;

import com.example.database.OrderDb;
import com.example.model.Crop;
import com.example.model.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "deleteorder", value = "/deleteorder")
public class DeleteOrderServlet extends HttpServlet {
    OrderDb odb = new OrderDb();
    Order order = new Order();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        boolean isValid = odb.deleteorder(id);

        if (isValid){
            List<Order> order;
            order = odb.allorder();

            RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerpendinglist.jsp");
            request.setAttribute("order", order);
            request.setAttribute("deleteorder", "success");
            dispatcher.forward(request, response);
        }
        else {
            List<Order> order;
            order = odb.allorder();

            RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerpendinglist.jsp");
            request.setAttribute("order", order);
            request.setAttribute("deletecrop", "failed");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
