package com.example.farmtech;

import com.example.database.CropDb;
import com.example.model.Crop;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "deletecrop", value = "/deletecrop")
public class DeleteCropServlet extends HttpServlet {
    CropDb cdb = new CropDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
//        String funame = (String) session.getAttribute("username");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isValid = cdb.deleteCrop(id);

        if (isValid){
        List<Crop> crop;
        crop = cdb.allcrop();

        RequestDispatcher dispatcher = request.getRequestDispatcher("crop/croplist.jsp");
        request.setAttribute("allcrop", crop);
        request.setAttribute("deletecrop", "success");
        dispatcher.forward(request, response);
        }
        else {
            List<Crop> crop;
            crop = cdb.allcrop();

            RequestDispatcher dispatcher = request.getRequestDispatcher("crop/croplist.jsp");
            request.setAttribute("allcrop", crop);
            request.setAttribute("deletecrop", "failed");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
