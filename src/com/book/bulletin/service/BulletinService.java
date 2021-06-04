package com.book.bulletin.service;

import java.util.List;

import com.book.bulletin.vo.BulletinVO;

public interface BulletinService {
	 List<BulletinVO> reviewSelect(BulletinVO vo);
	List<BulletinVO> bulletinSelectList();
	BulletinVO bulletinSelect(BulletinVO vo);
	int insertBulletin(BulletinVO vo);
	int updateBulletin(BulletinVO vo);
	int deleteBulletin(BulletinVO vo);
}
