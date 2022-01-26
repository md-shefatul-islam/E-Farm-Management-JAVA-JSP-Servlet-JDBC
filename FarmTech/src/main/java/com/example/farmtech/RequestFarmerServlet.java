package com.example.farmtech;

import com.example.database.CropDb;
import com.example.database.OrderDb;
import com.example.database.SeedDb;
import com.example.model.Crop;
import com.example.model.Order;
import com.example.model.Seed;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "requestfarmer", value = "/requestfarmer")
public class RequestFarmerServlet extends HttpServlet {
    OrderDb odb = new OrderDb();
    CropDb cdb = new CropDb();
    SeedDb sdb = new SeedDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();


        try {
//            String funame = (String) session.getAttribute("username");
            List<Order> order;
            order = odb.allorder();

            if (order.isEmpty()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerExceptList.jsp");
                request.setAttribute("order", "");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerExceptList.jsp");
                request.setAttribute("order", order);
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            out.println("Error while connecting database");
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");

        String status = "accepted";
        Order accept = new Order(id, status);
//
//        boolean isValid = odb.acceptorder(accept);
//            boolean isValid = true;


//        Crop crop = cdb.selectcrop(name);
//        String que1 = crop.getQuantity();
//        Seed seed = sdb.selectseed(name);
//        String que2 = seed.getQuantity();


//        int count = 0;
//        if (isValid){
            if(type.equals("crop")){
                Crop crop = cdb.selectcrop(name);
                String que1 = crop.getQuantity();
                int oldquantity = Integer.parseInt(que1);
//                out.println("allah help me "+ oldquantity);

                if(oldquantity >= quantity) {
                    String newquantity = String.valueOf(oldquantity - quantity);
                    int ids = crop.getId();
                    Crop crops = new Crop(id, newquantity);
                    boolean isValid1 = cdb.updatequantity(crops);

                    boolean isValid = odb.acceptorder(accept);
                    if(isValid1 && isValid){
//                        count = 1;
                        List<Order> order;
                        order = odb.allorder();
                        RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerExceptList.jsp");
                        request.setAttribute("order", order);
                        request.setAttribute("accept", "accept");
                        dispatcher.forward(request, response);
                    }
                }
                else{
//                    count = 2;
                    List<Order> order;
                    order = odb.allorder();
                    RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerExceptList.jsp");
                    request.setAttribute("order", order);
                    request.setAttribute("accept", "not");
                    dispatcher.forward(request, response);
                }

            }
//            else if(type.equals("seed")){
//                Seed seed = sdb.selectseed(name);
//                String que2 = seed.getQuantity();
//                int oldquantity = Integer.parseInt(que2);
////                out.println("allah help me "+ oldquantity);
//
//                if (oldquantity >= quantity) {
//                    String newquantity = String.valueOf(oldquantity - quantity);
//                    int ids = seed.getId();
//
//                    Seed seeds = new Seed(id, newquantity);
//                    boolean isValid2 = sdb.updatequantity(seeds);
//                    if(isValid2){
//                        count = 3;
//                    }
//                }
//                else{
//                    count = 4;
//                }
//            }
//            RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerExceptList.jsp");
//            request.setAttribute("order", order);

//            if(count == 1 || count == 3 ){
//                request.setAttribute("order", order);
//                request.setAttribute("accept", "accept");
//                dispatcher.forward(request, response);
//            }
//            else if(count == 2 || count == 4){
//                request.setAttribute("order", order);
//                request.setAttribute("accept", "not");
//                dispatcher.forward(request, response);
//            }

//        }
//        else{
//            RequestDispatcher dispatcher = request.getRequestDispatcher("request/farmerExceptList.jsp");
//            request.setAttribute("order", "order");
//            request.setAttribute("accept", "failed");
//            dispatcher.forward(request, response);
//        }
    }
}
