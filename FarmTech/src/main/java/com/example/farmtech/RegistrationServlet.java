package com.example.farmtech;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.database.*;
import com.example.model.*;

import java.io.*;
import java.util.List;

@WebServlet(name = "registration", value = "/registration")
//@MultipartConfig
public class RegistrationServlet extends HttpServlet {
    FarmerDb fdb = new FarmerDb();
    LoginDb ldb = new LoginDb();
//    Login use = new Login();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

//        try {
//            for file start
//            Part part = request.getPart("file");
//            String fileName = part.getSubmittedFileName();
//
//            for (Part p1 : request.getParts()) {
//                p1.write(getServletContext().getRealPath("/"+"img"+ File.separator+fileName));    }
//
//
//
////            String path = getServletContext().getRealPath("/"+"img"+ File.separator+fileName);
////
//////            out.println("uploader"+ fileName+"dfdf"+" "+path);
////            InputStream is = part.getInputStream();
////
////            try{
////                byte[] byt = new byte[is.available()];
////                is.read();
////                FileOutputStream fops = new FileOutputStream(path);
////                fops.write(byt);
////                fops.flush();
////                fops.close();
////                out.println("uploader "+ fileName+"dfasdf"+"  "+path);
////            }catch (Exception e)
////            {
////                out.println("eoorr is hete");
////                out.println(e.getMessage());
////            }
////            file end

//          out.println("in registrations");

            String acctype = request.getParameter("actype");
            String uname = request.getParameter("username");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String city = request.getParameter("city");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String balance = "100";

//            List<Login> users;
//            users = ldb.alluser();

            if(acctype.equals("farmer")) {
                Farmer user = new Farmer(uname, name, email, phone, city, password, gender, dob, balance);

                boolean isValid = fdb.insert(user);
//                boolean isValid = true;
//                out.println("in registrations"+uname+name+email+phone+city+gender+dob+password+balance);
//out.println(isValid);

                if (isValid) {
                    Login login = new Login(uname,password,acctype);
                    boolean isValid1 = ldb.insert(login);
                    if(isValid1){
//                        out.println("login done");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
                        request.setAttribute("message", "success");
                        dispatcher.forward(request, response);
                    }
                    else {
//                        out.println("login failed");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
                        request.setAttribute("regester", user);
                        request.setAttribute("message", "not");
                        dispatcher.forward(request, response);
                    }

                } else {
//                    out.println("reg failed");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
                    request.setAttribute("regester", user);
                    request.setAttribute("message", "not");
                    dispatcher.forward(request, response);
                }
            }
            else if(acctype.equals("admin")){
                out.println("This section is not complete yet");
            }
//    } catch (Exception e) {
//        out.println("Error while connecting database");
//        out.println(e.getMessage());
//    }

    }
}
