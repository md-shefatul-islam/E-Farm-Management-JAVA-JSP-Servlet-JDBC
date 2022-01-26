package com.example.farmtech;

import com.example.database.CropDb;
import com.example.database.FarmerDb;
import com.example.model.*;
import com.example.model.Farmer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "allproduct", value = "/allproduct")
public class AllCropServlet extends HttpServlet {
    CropDb cdb = new CropDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();


        try {
//            String funame = (String) session.getAttribute("username");
            List<Crop> crop;
            crop = cdb.allcrop();

            if (crop.isEmpty()){
                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/croplist.jsp");
                request.setAttribute("allcrop", "");
                dispatcher.forward(request, response);
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("crop/croplist.jsp");
                request.setAttribute("allcrop", crop);
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
