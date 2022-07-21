package com.ll.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req, resp);



        //URL에서 gugudan?dan=4&limit=5 4단 곱하기 5까지
        int dan = rq.getIntParam("dan", 9); //문자열 입력 형변환
        int limit = rq.getIntParam("limit", 9);

        // request에 정보를 담는다.
        // 왜냐하면 나중에 gugudan2.jsp에서 해당 내용을 꺼낼 수 있기 때문에
        req.setAttribute("dan", dan);
        req.setAttribute("limeit", limit);


        // gugudan2.jsp 에게 나머지 작업을 토스
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp");
        requestDispatcher.forward(req, resp);



    }
}