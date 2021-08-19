package org.zerock.b1.controller;

import lombok.extern.log4j.Log4j2;
import org.graalvm.compiler.nodes.calc.AbsNode;
import org.zerock.b1.dao.BoardDAO;
import org.zerock.b1.dto.BoardDTO;
import org.zerock.b1.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@Log4j2
@WebServlet(name = "ReadController", value = "/board/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long bno = Long.parseLong(request.getParameter("bno"));

        BoardDTO boardDTO = BoardService.INSTANCE.read(bno);

        request.setAttribute("dto", boardDTO);

        request.getRequestDispatcher("/WEB-INF/board/read.jsp").forward(request,response);

    }

}
