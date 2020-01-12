package com.springbook.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	private LogAdvice log;
	
	public BoardServiceImpl() {
		log = new LogAdvice();
	}
	
	public void insertBoard(BoardVO vo) {
		log.printLog();
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		log.printLog();
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		log.printLog();
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		log.printLog();
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		log.printLog();
		return boardDAO.getBoardList(vo);
	}

}
