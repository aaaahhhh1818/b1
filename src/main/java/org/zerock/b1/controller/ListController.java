package org.zerock.b1.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.graalvm.compiler.lir.LIRInstruction;
import org.zerock.b1.dao.BoardDAO;
import org.zerock.b1.dto.BoardDTO;
import org.zerock.b1.service.BoardService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@Log4j2
@WebServlet(name = "ListController", value = "/board/list")
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("list controller doGet.......................");

        ArrayList<BoardDTO> result = BoardService.INSTANCE.getList();

        request.setAttribute("bno", result);

        request.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(request, response);

    }

}
