package com.ll.exam;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {

        Rq rq = new Rq(req, resp);

        //URL에서 gugudan?dan=4&limit=5 4단 곱하기 5까지
        int dan = rq.getIntParam("dan", 0); //문자열 입력 형변환
        int limit = rq.getIntParam("limit", 0);

        rq.appendBody("<h2>%d단</h2>".formatted(dan));

        for(int i = 1; i <= limit; i++){
            rq.appendBody("<div>%d * %d = %d</div>\n".formatted(dan, i, dan*i));
        }



    }
}