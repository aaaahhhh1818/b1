package org.zerock.b1.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.b1.dto.BoardDTO;
import org.zerock.b1.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Log4j2
@WebServlet(name = "ModifyController", value = "/board/modify")
public class ModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long bno = Long.parseLong(request.getParameter("bno"));

        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);

        request.setAttribute("dto", boardDTO);

        request.getRequestDispatcher("/WEB-INF/board/modify.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Long bno = Long.parseLong(request.getParameter("bno"));
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        BoardDTO boardDTO = BoardDTO.builder().bno(bno).writer(writer).content(content).build();

        BoardService.INSTANCE.modify(boardDTO);

        response.sendRedirect("/board/list");

    }
}
