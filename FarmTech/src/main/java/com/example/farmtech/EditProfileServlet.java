package com.example.farmtech;

import com.example.database.FarmerDb;
import com.example.model.Farmer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "editprofile", value = "/editprofile")
public class EditProfileServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("allah help me");

        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            Farmer user = fdb.profile(username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/editprofile.jsp");
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
//       out.println("in registrations"+user.getName());

        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            String uname = (String) session.getAttribute("username");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String city = request.getParameter("city");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");

            Farmer user = new Farmer(uname, name, email, phone, city, password, gender, dob);
            boolean isValid = fdb.updateProfile(user);
//            out.println("allah help me post"+uname+name+email+phone+city+password+gender+dob);
            if (isValid){
                Farmer users = fdb.profile(uname);
                RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/profile.jsp");
                request.setAttribute("user", users);
                request.setAttribute("update", "success");
                dispatcher.forward(request, response);
            }else{
                Farmer users = fdb.profile(uname);
                RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/profile.jsp");
                request.setAttribute("user", users);
                request.setAttribute("update", "failed");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println("error in get");
            out.println(e.getMessage());
        }

    }
}
