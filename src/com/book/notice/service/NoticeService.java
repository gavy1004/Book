package com.book.notice.service;

import java.util.List;

import com.book.notice.vo.NoticeVO;


public interface NoticeService {
	List<NoticeVO> selectNoticeList();
	NoticeVO selectNotice(NoticeVO vo);
	public int insertNotice(NoticeVO vo);
	public int updateNotice(NoticeVO vo);
	public int deleteNotice(NoticeVO vo);
}
