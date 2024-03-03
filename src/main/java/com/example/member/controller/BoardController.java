package com.example.member.controller;


import com.example.member.dto.BoardDTO;
import com.example.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService; //RequiredArgs

    @GetMapping("/save")
    public String saveForm(){
        return "boardsave";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";

    }

    @GetMapping("/")
    public String findAll(Model model){
        //DB에서 전체 게시글 가져와서 boardlist에 보여준다
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardlist";

    }
}
