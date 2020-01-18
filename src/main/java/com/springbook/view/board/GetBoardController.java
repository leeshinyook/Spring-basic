package com.springbook.view.board;


import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetBoardController {
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");
		mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장.
		mav.setViewName("getBoard.jsp"); //// Viewww 정보 저장.
		return mav;
	}

}
