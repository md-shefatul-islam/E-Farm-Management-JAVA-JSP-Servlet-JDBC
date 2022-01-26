package com.example.farmtech;

import com.example.database.CropDb;
import com.example.model.Crop;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "cookie", value = "/cookie")
public class CookieServlet extends HttpServlet {
    CropDb cdb = new CropDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Crop> crop;
        crop = cdb.allcrop();

//        Cookie cookie = new Cookie("name", "close");
//        cookie.setMaxAge(60);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/croplist.jsp");
        request.setAttribute("allcrop", crop);
//        response.addCookie(cookie);
        response.setIntHeader("Refresh",11);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
