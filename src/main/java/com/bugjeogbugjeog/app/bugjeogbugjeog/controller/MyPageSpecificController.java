package com.bugjeogbugjeog.app.bugjeogbugjeog.controller;


import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.BusinessVO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.service.BusinessMyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
@Slf4j
public class MyPageSpecificController {

    private final BusinessMyPageService businessMyPageService;

    @GetMapping("edit")
    public String main(Model model){

        model.addAttribute("businessVO", businessMyPageService.businessInfo(1L));
        return "mypage/specific/businessEdit";
    }
//    @GetMapping("favorite")
//    public String main2(Model model){
//        model.addAttribute("memberVO",myPageService.memberInfo(1L));
//        return "mypage/specific/personalFavoriteList";
//    }



    @PostMapping("edit")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView updateLocation(HttpServletRequest req, BusinessVO businessVO){
//        HttpSession session = req.getSession();
//        Long businessId = (Long) session.getAttribute("businessId");
        Long businessId = 1L;
        businessVO = businessMyPageService.businessInfo(businessId);


        String categorys = req.getParameter("categorys");

        String foods = req.getParameter("foods");

        businessVO.setBusinessCategory(categorys);
        businessVO.setBusinessLocation(foods);
        businessMyPageService.updateLocation(businessVO);

        return new RedirectView("/mypage/edit");
    }


}
