package com.example.farmtech;

import com.example.database.*;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    LoginDb ldb = new LoginDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        try {
            //          out.println("in registrations");

            String uname = request.getParameter("username");
            String password = request.getParameter("password");
            HttpSession session = request.getSession();

            Login user = new Login(uname, password);
//            out.println("in registrations"+uname+password);
            Login myUser = ldb.login(user);
            String myUserUname = myUser.getUname();
            String myPassword = myUser.getPassword();
            String myType = myUser.getType();

            if (myUserUname.equals(uname) && myPassword.equals(password)) {
                if(myType.equals("farmer")) {
                    session.setAttribute("username", myUserUname);
                    session.setAttribute("password", myPassword);
                    session.setAttribute("token", "1");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/homefarmer.jsp");
//                    request.setAttribute("log", "success");
                    dispatcher.forward(request, response);
                }
////                else if (myType.equals("farmer")){
////                    RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
////                    request.setAttribute("message", "success");
////                    dispatcher.forward(request, response);
////                }
////                else if(myType.equals("seedBanker")){
////                    RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
////                    request.setAttribute("message", "success");
////                    dispatcher.forward(request, response);
////                }
//                out.println("allah help me"+myUserUname+myType);
            } else {
//            out.println("allah help us");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("log", "failed");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
//            out.println("error in get");
//            out.println(e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("log", "failed");
            dispatcher.forward(request, response);
        }
    }
}
