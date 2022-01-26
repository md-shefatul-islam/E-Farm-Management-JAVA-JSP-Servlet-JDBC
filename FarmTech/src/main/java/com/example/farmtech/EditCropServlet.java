package com.example.farmtech;

import com.example.database.*;
import com.example.model.*;
import com.example.model.Farmer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "editcrop", value = "/editcrop")
public class EditCropServlet extends HttpServlet {
    CropDb cdb = new CropDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Crop mycrop = cdb.selectCrop(id);
        session.setAttribute("cropid", id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("crop/edit.jsp");
        request.setAttribute("mycrop", mycrop);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        try{
            int id = (int) session.getAttribute("cropid");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String date = request.getParameter("date");

            Crop crop = new Crop(name, description, quantity, price, date);
            List<Crop> crops;
            crops = cdb.allcrop();
//            out.println("in registrations"+name+description+quantity+price+date);
            boolean isValid = cdb.updatecrop(crop,id);
            Crop mycrop = cdb.selectCrop(id);
            if (isValid) {

                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/croplist.jsp");
                request.setAttribute("allcrop", crops);
//                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/edit.jsp");
                request.setAttribute("cropedit", "success");
//                request.setAttribute("mycrop", mycrop);
                dispatcher.forward(request, response);
            }else {

                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/edit.jsp");
                request.setAttribute("cropedit", "failed");
                request.setAttribute("mycrop", mycrop);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }
}
