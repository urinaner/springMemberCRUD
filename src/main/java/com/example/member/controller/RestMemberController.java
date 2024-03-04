package com.example.member.controller;


import com.example.member.dto.BoardDTO;
import com.example.member.dto.MemberDTO;
import com.example.member.service.BoardService;
import com.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/api")
public class RestMemberController {
    private final MemberService memberService; //RequiredArgs;

    @GetMapping("/")
    public List<MemberDTO> findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        return memberDTOList;
    }
    @GetMapping("/{id}")
    public MemberDTO findById(@PathVariable Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        return memberDTO;
    }
    @PostMapping("/save")
    public MemberDTO save(@RequestBody MemberDTO memberDTO){
        memberService.save(memberDTO);
        return memberDTO;
    }

    @PostMapping("/update")
    public MemberDTO update(@RequestBody MemberDTO memberDTO){
        memberService.update(memberDTO);
        return memberDTO;
    }

    @GetMapping("/delete/{id}")
    public MemberDTO delete(@PathVariable Long id){
        MemberDTO byId = memberService.findById(id);
        memberService.deleteById(id);
        return byId;
    }

}
