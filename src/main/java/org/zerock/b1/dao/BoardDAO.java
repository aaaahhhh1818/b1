package org.zerock.b1.dao;

import com.mysql.cj.jdbc.JdbcConnection;
import lombok.extern.log4j.Log4j2;
import org.zerock.b1.dto.BoardDTO;
import org.zerock.b1.service.BoardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public enum BoardDAO {
    INSTANCE;

    private static final String SQL_INSERT = "insert into tbl_board (title, content, writer) values (?,?,?)";

    private static final String SQL_LIST = "select bno, title, writer, regdate, count from tbl_board";

    private static final String SQL_SELECT = "select bno,title,content,writer,regdate,moddate,count from tbl_board where bno=?";

    private static final String SQL_MODIFY = "update tbl_board set title=?,content=?,moddate=now() where bno=?";

    public BoardDTO modify(String title, String content, Long bno) throws RuntimeException {

        BoardDTO boardDTO = BoardDTO.builder().build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_MODIFY);
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, content);
                preparedStatement.setLong(3, bno);

                preparedStatement.executeUpdate();

            }
        }.makeAll();

        return boardDTO;
    }

    public BoardDTO select(Long bno) throws RuntimeException {

        BoardDTO boardDTO = BoardDTO.builder().build();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_SELECT);
                preparedStatement.setLong(1, bno);
                resultSet = preparedStatement.executeQuery();

                resultSet.next();

                //bno,title,content,writer,regdate
                //moddate,count
                boardDTO.setBno(resultSet.getLong(1));
                boardDTO.setTitle(resultSet.getString(2));
                boardDTO.setContent(resultSet.getString(3));
                boardDTO.setWriter(resultSet.getString(4));
                boardDTO.setRegdate(resultSet.getTimestamp(5));

                boardDTO.setModdate(resultSet.getTimestamp(6));
                boardDTO.setCount(resultSet.getInt(7));

            }
        }.makeAll();

        return boardDTO;

    }


    public void insert(BoardDTO boardDTO) throws RuntimeException {

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_INSERT);
                preparedStatement.setString(1, boardDTO.getTitle());
                preparedStatement.setString(2, boardDTO.getContent());
                preparedStatement.setString(3, boardDTO.getWriter());

                preparedStatement.executeUpdate();


            }
        }.makeAll();

    }

    public ArrayList<BoardDTO> selectList() throws RuntimeException {

        ArrayList<BoardDTO> boardArr = new ArrayList<>();

        new JdbcTemplate() {
            @Override
            protected void execute() throws Exception {

                preparedStatement = connection.prepareStatement(SQL_LIST);

                resultSet = preparedStatement.executeQuery();

                log.info(resultSet);
                while (resultSet.next()) {

                    ArrayList<BoardDTO> boardDTOS = new ArrayList<>();

                    //bno, title, writer, regdate, count
                    boardArr.add(BoardDTO.builder()
                            .bno(resultSet.getLong(1))
                            .title(resultSet.getString(2))
                            .writer(resultSet.getString(3))
                            .regdate(resultSet.getTimestamp(4))
                            .count(resultSet.getInt(5))
                            .build());
                }

            }
        }.makeAll();

        return boardArr;

    }
}
