package com.example.farmtech;

import com.example.database.SeedDb;
import com.example.model.Crop;
import com.example.model.Seed;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "cookieseed", value = "/cookieseed")
public class CookieSeedServlet extends HttpServlet {
    SeedDb sdb = new SeedDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Seed> seed;
        seed = sdb.allseed();

//        Cookie cookie = new Cookie("name", "close");
//        cookie.setMaxAge(60);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order/seedlist.jsp");
        request.setAttribute("allseed", seed);
//        response.addCookie(cookie);
        response.setIntHeader("Refresh",11);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
