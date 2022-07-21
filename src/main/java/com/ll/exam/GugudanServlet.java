package com.ll.exam;

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
        req.setCharacterEncoding("UTF-8"); // 들어오는 데이터를 UTF-8 로 해석하겠다.
        resp.setCharacterEncoding("UTF-8"); // 완성되는 HTML의 인코딩을 UTF-로 하겠다.
        resp.setContentType("text/html; charset=utf-8"); // 브라우저에게 우리가 만든 결과물이 UTF-8 이다 라고 알리는 의미

        //gugudan?dan=4&limit=5 4단 곱하기 5까지 URL에서
        int dan = Integer.parseInt(req.getParameter("dan")); //문자열 입력 형변환
        int limit = Integer.parseInt(req.getParameter("limit"));

        resp.getWriter().append("<h2>%d단</h2>".formatted(dan));

        for(int i = 1; i <= limit; i++){
            resp.getWriter().append("<div>%d * %d = %d</div>\n".formatted(dan, i, dan*i));
        }
    }
}