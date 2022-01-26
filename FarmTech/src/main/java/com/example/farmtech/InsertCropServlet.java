package com.example.farmtech;

import com.example.database.CropDb;
import com.example.model.Crop;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "insert", value = "/insert")
public class InsertCropServlet extends HttpServlet {
    CropDb cdb = new CropDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher dispatcher = request.getRequestDispatcher("crop/insert.jsp");
//        request.setAttribute("message", "success");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try{
            String uname = (String) session.getAttribute("username");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String date = request.getParameter("date");

            Crop crop = new Crop(name, description, quantity, price, date, uname);
            out.println("in registrations"+uname+name+description+quantity+price+date);
            boolean isValid = cdb.insert(crop);
            if (isValid) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/insert.jsp");
                request.setAttribute("cropinsert", "success");
                dispatcher.forward(request, response);
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/insert.jsp");
                request.setAttribute("cropinsert", "failed");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }
}
