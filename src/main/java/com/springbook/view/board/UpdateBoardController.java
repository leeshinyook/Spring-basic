package com.springbook.view.board;


import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateBoardController {
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
}
