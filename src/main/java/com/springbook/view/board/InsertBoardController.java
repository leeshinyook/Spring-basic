package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertBoardController {
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
}
