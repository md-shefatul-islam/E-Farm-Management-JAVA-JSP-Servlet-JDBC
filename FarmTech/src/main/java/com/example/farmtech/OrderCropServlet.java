package com.example.farmtech;

import com.example.database.*;
import com.example.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ordercrop", value = "/ordercrop")
public class OrderCropServlet extends HttpServlet {
    CropDb cdb = new CropDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        String ids = request.getParameter("id");
//        Crop crop = cdb.selectCrop(id);
        if(null == session.getAttribute("orderid")){
            session.setAttribute("orderid", id);
        }
        else{
            int idd = (int) session.getAttribute("orderid");
            String iddd = String.valueOf(idd);
            if(ids.equals(iddd)){
                session.setAttribute("orderid", id);
//                session.setAttribute("orderquantity", "i am no were");
            }else{
//                session.setAttribute("orderquantity", "i am here   "+ids+"   "+session.getAttribute("orderid"));
                session.removeAttribute("orderquantity");
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("order/order.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession();
            int id = (int) session.getAttribute("orderid");
            Crop crop = cdb.selectCrop(id);

            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String quantitiess = request.getParameter("quantity");
//            out.println("allah is with me"+id+quantity);
            int oldquantity = Integer.parseInt(crop.getQuantity());
            if( oldquantity >= quantity){
                int price = Integer.parseInt(crop.getPrice());





                if(null == session.getAttribute("orderquantity")){
//                    out.println("allah is sorbo soktiman");
                    session.setAttribute("orderquantity", quantitiess);
                }
                else{
//                    out.println("allah is sorbo mohan");
                    String quantities = (String) session.getAttribute("orderquantity");
                    session.setAttribute("orderquantity", quantitiess);
                    session.setAttribute("updatequantity", quantities);
                }




                int totalprice = quantity * price;
                session.setAttribute("totalprice", totalprice);
                session.setAttribute("ordersuname", crop.getFuname());

                RequestDispatcher dispatcher = request.getRequestDispatcher("order/confirmorder.jsp");
                request.setAttribute("order", crop);
                dispatcher.forward(request, response);
            }
            else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("order/order.jsp");
                request.setAttribute("order", "failed");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            out.println("error in get in crop");
            out.println(e.getMessage());
        }
    }
}
