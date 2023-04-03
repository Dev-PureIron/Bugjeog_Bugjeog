package com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dao;

import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.AdminCriteria;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.dto.InquiryDTO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.BoardInquiryVO;
import com.bugjeogbugjeog.app.bugjeogbugjeog.domain.vo.Criteria;
import com.bugjeogbugjeog.app.bugjeogbugjeog.mapper.InquiryBoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryBoardDAO {

    private final InquiryBoardMapper inquiryBoardMapper;

    //    문의 작성 목록
    public List<BoardInquiryVO> findAllByIdToInquire(Long memberId, Criteria criteria){
        return inquiryBoardMapper.inquireList(memberId,criteria);
    };

    //    문의 게시글 작성 갯수
    public Integer getCountToInquire(Long memberId){
        return inquiryBoardMapper.inquireCount(memberId);
    };

    // 문의 답변 여부
    public Long inquireAnswer(Long boardInquireId){
        return inquiryBoardMapper.inquireAnswer(boardInquireId);
    }

    // 유통업체 문의 작성 목록
    public List<BoardInquiryVO> findAllToBusiness(@Param("businessId") Long businessId, @Param("criteria") Criteria criteria){
        return inquiryBoardMapper.businessInquireList(businessId, criteria);
    };

    //    문의 게시글 작성 갯수
    public Integer getBusinessInquireCount(Long businessId){
        return inquiryBoardMapper.businessInquireCount(businessId);
    };

    /* 관리자 ------------------------------------------------------------------------ */

    // 문의 목록
    public List<BoardInquiryVO> getInquiryList(AdminCriteria adminCriteria){return inquiryBoardMapper.adminSelectAllInquiry(adminCriteria);}

    // 문의 조회
    public InquiryDTO getInquiry(Long boardInquiryId){return inquiryBoardMapper.adminSelectInquiry(boardInquiryId);}

    // 문의 삭제
    public void deleteInquiry(Long boardInquiryId){inquiryBoardMapper.delete(boardInquiryId);}

    // 문의 카운트
    public int count(){return inquiryBoardMapper.count();}


}
