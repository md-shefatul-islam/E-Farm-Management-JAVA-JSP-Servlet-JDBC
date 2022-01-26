package com.example.farmtech;

import com.example.database.QuestionDb;
import com.example.model.Crop;
import com.example.model.Question;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "question", value = "/question")
public class QuestionServlet extends HttpServlet {
    QuestionDb qdb = new QuestionDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher dispatcher = request.getRequestDispatcher("question/create.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

        String question = request.getParameter("question");
        String quname = (String) session.getAttribute("username");
        String answer = "";
        Question que = new Question(question,answer,quname);

//        out.println("allah help "+question+" "+quname);

        boolean isValid = qdb.insert(que);
        if (isValid){
            RequestDispatcher dispatcher = request.getRequestDispatcher("question/create.jsp");
            request.setAttribute("que", "success");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("question/create.jsp");
            request.setAttribute("que", "failed");
            dispatcher.forward(request, response);
        }
    }
}
