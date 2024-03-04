package com.example.member.controller;


import com.example.member.dto.BoardDTO;
import com.example.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        //해당 게시글의 조회수를 올리고 보드화면 출력
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boarddetail";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDTO);
        return "boardupdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        BoardDTO board = boardService.update(boardDTO);
        System.out.println("boardDTO = " + boardDTO + ", model = " + model);
        model.addAttribute("board", board);
//        return "boarddetail";
        return "redirect:/board/" + boardDTO.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.delete(id);
        return "redirect:/board/";
    }
}
