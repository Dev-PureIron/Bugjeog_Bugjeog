package com.bugjeogbugjeog.app.bugjeogbugjeog.controller;

import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.BoardBusinessDTO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.BusinessReviewDTO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.MemberVO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.service.InquiryBoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/board/inquiry")
@RequiredArgsConstructor
@Slf4j
public class InquiryBoardController {
    private final InquiryBoardService inquiryBoardService;

    @GetMapping(value = {"/board/inquiry", "/board/inquiry/"})
    public RedirectView defaultRoot() {
        return new RedirectView("/board/inquiry/list");
    }

    //    리스트
    @GetMapping("/board/inquiry/list")
    public void showList(Model model) {
        model.addAttribute("boards", inquiryBoardService.showList());
    }


    @GetMapping("/board/inquiry/detail")
    public void detail() {
//        model.addAttribute("board", inquiryBoardService.getBoard());
    }

    //    @GetMapping("/board/inquiry/")

    @GetMapping("/board/inquiry/write")
    public void write() {

    }
//    @GetMapping("/board/business/detail")
//    public void detail(Model model, HttpServletRequest req) throws JsonProcessingException {
//
//        BoardBusinessDTO dto = inquiryBoardService.getBoard(Long.parseLong(req.getParameter("boardBusinessId")));
//        String name = dto.getBoardBusinessImgOriginalName();
//
//        List<BusinessReviewDTO> businessReviewDTOs = businessReviewService.getReviews(Long.parseLong(req.getParameter("boardBusinessId")));
//
//        System.out.println(dto.toString());
//        System.out.println(businessReviewDTOs.toString());
//        List<BoardBusinessDTO> otherBoardDTOs = inquiryBoardService.getBoardsByBusinessId(dto.getBusinessId());
//
//
////        MemberVO memberVO = businessReviewService.getMember(Long.parseLong(String.valueOf(req.getSession().getAttribute("memberId"))));
//        MemberVO memberVO = businessReviewService.getMember(5L);
//        String orginalName = memberVO.getMemberImgOriginalName();
//        String memberFullPath = (orginalName == null || orginalName == "null" || orginalName == "") ? "/image/mypage/member_no_image.png" : (memberVO.getMemberImgPath() + "/" + memberVO.getMemberImgUuid() + "_" + memberVO.getMemberImgOriginalName());
//        ObjectMapper objectMapper = new ObjectMapper();
//        //  게시글 정보
//        model.addAttribute("board", objectMapper.writeValueAsString(dto));
//
//        //  게시글 배너 이미지들 정보
//        model.addAttribute("boardImgs", objectMapper.writeValueAsString(businessBoardImgService.getList(dto.getBoardBusinessId())));
//
//        //  게시글 리뷰 정보
//        model.addAttribute("reviews", objectMapper.writeValueAsString(businessReviewDTOs));
//
//        //  게시글 작성자(businessId)의 작성글 리스트
//        model.addAttribute("boardList", objectMapper.writeValueAsString(otherBoardDTOs));
//
//        //  로그인한 사용자 정보
//        model.addAttribute("member", JSONObject.toString("member", memberVO));
//
//        //  로그인한 사용자 이미지 정보
//        model.addAttribute("memberFullPath", objectMapper.writeValueAsString(memberFullPath));
//
//    }
}