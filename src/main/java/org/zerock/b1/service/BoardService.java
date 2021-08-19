package org.zerock.b1.service;

import lombok.extern.log4j.Log4j2;
import org.zerock.b1.dao.BoardDAO;
import org.zerock.b1.dto.BoardDTO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Log4j2
public enum BoardService {

    INSTANCE;

    public void register(BoardDTO boardDTO) throws RuntimeException {

        log.info("service register......" + boardDTO);

        BoardDAO.INSTANCE.insert(boardDTO);

    }

    public BoardDTO read(Long bno) throws RuntimeException {

        return BoardDAO.INSTANCE.select(bno);

    }

    public ArrayList<BoardDTO> getList() throws RuntimeException {

        long start = System.currentTimeMillis();

        ArrayList<BoardDTO> result = BoardDAO.INSTANCE.selectList();

        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));

        return result;
    }


    public BoardDTO modify(BoardDTO boardDTO) throws RuntimeException {

        return BoardDAO.INSTANCE.modify(boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getBno());

    }
}
