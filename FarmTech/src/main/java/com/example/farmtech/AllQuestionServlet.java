package com.example.farmtech;

import com.example.database.QuestionDb;
import com.example.model.Question;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "allquestion", value = "/allquestion")
public class AllQuestionServlet extends HttpServlet {
    QuestionDb qdb = new QuestionDb();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<Question> que;
        que = qdb.allquestion();

        RequestDispatcher dispatcher = request.getRequestDispatcher("question/allquestion.jsp");
        request.setAttribute("que", que);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        String answer = request.getParameter("answer");
        String auname = (String) session.getAttribute("username");
        Question ques = new Question(id,answer,auname);

//        out.println("allah help "+answer+" "+id);

        boolean isValid = qdb.update(ques);
        if (isValid){
            List<Question> que;
            que = qdb.allquestion();
            RequestDispatcher dispatcher = request.getRequestDispatcher("question/allquestion.jsp");
            request.setAttribute("que", que);
            request.setAttribute("ques", "success");
            dispatcher.forward(request, response);
        }
        else{
            List<Question> que;
            que = qdb.allquestion();
            RequestDispatcher dispatcher = request.getRequestDispatcher("question/allquestion.jsp");
            request.setAttribute("que", que);
            request.setAttribute("ques", "failed");
            dispatcher.forward(request, response);
        }
    }
}
