package com.example.member.controller;


import com.example.member.dto.BoardDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board/api")
public class RestBoardController {
    private final BoardService boardService; //RequiredArgs

    @GetMapping("/{id}")
    public BoardDTO findById(@PathVariable Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        return boardDTO;
    }

    @GetMapping("/")
    public List<BoardDTO> findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        return boardDTOList;
    }

    @PostMapping("/save")
    public BoardDTO save(@RequestBody BoardDTO boardDTO){
        boardService.save(boardDTO);

        return boardDTO;
    }

    @GetMapping("/delete/{id}")
    public BoardDTO delete(@PathVariable Long id){
        BoardDTO boardDTO = boardService.findById(id);
        boardService.delete(id);
        return boardDTO;
    }

    @PostMapping("/update")
    public BoardDTO update(@RequestBody BoardDTO boardDTO) {
        boardService.update(boardDTO);
        return boardDTO;
    }
}
