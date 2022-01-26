package com.example.farmtech;

import com.example.database.FarmerDb;
import com.example.database.LoginDb;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "changepassword", value = "/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/changepassword.jsp");
        dispatcher.forward(request, response);
    }

    FarmerDb fdb = new FarmerDb();
    LoginDb ldb = new LoginDb();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String uname = (String) session.getAttribute("username");
        String currentpassword = (String) session.getAttribute("password");

        String currentpass = request.getParameter("cpass");
        String password = request.getParameter("npass");
        String retypepass = request.getParameter("rnpass");

        if (currentpassword.equals(currentpass)){
            if (password.equals(retypepass)){
                Farmer user = new Farmer(uname,password);
                Login myuser = new Login(uname,password);
                boolean isValid = fdb.updatePasswordFarmer(user);
                boolean isValid1 = ldb.updatePasswordLogin(myuser);
                if (isValid && isValid1) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/changepassword.jsp");
                    request.setAttribute("update", "success");
                    dispatcher.forward(request, response);
                }
                else{
                    RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/changepassword.jsp");
                    request.setAttribute("update", "failed");
                    dispatcher.forward(request, response);
                }
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/changepassword.jsp");
                request.setAttribute("update", "val");
                dispatcher.forward(request, response);
            }
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("farmer/changepassword.jsp");
            request.setAttribute("update", "lock");
            dispatcher.forward(request, response);
        }
    }
}
