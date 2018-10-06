package com.rancre.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.rancre.model.domain.Notice;
import com.rancre.util.DAOFactory;

public class NoticeDAO {
	
	private static final String namespace = "notice";

	// insert
	public static int addNotice(int inputNoticeCategory, int inputMemberNo, int inputNoticeTarget1,
			int inputNoticeTarget2, int inputNoticeStatus, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
				
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("noticeCategory", inputNoticeCategory);
			map.put("memberNo", inputMemberNo);
			map.put("noticeTarget1", inputNoticeTarget1);
			map.put("noticeTarget2", inputNoticeTarget2);
			map.put("noticeStatus", inputNoticeStatus);
			map.put("inputCurrentDate", inputCurrentDate);
			
			int check = (int)sqlSession.insert(namespace + ".addNotice", map);

			if(check == 1) {
				sqlSession.commit();
				return check;
			} else {
				sqlSession.rollback();
				return check;
			}
			
		} finally {
			sqlSession.close();
		}
	}
	
	// update
	public static int setNotice(int inputNoticeNo, int inputNoticeStatus, long inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("noticeNo", inputNoticeNo);
			map.put("noticeStatus", inputNoticeStatus);
			map.put("inputCurrentDate", inputCurrentDate);
			
			int check = (int)sqlSession.update(namespace + ".setNotice", map);

			if(check == 1) {
				sqlSession.commit();
				return check;
			} else {
				sqlSession.rollback();
				return check;
			}
			
		} finally {
			sqlSession.close();
		}
	}
	
	// select 
	public static int checkNotice(int inputNoticeNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try{
			return (int)sqlSession.selectOne(namespace + ".checkNotice", inputNoticeNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Notice> getNoticeList(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try{
			return (ArrayList)sqlSession.selectList(namespace + ".getNoticeList", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countNotice(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try{
			return (int)sqlSession.selectOne(namespace + ".countNotice", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Notice getNotice(int inputNoticeNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try{
			return (Notice)sqlSession.selectOne(namespace + ".getNotice", inputNoticeNo);
			
		} finally {
			sqlSession.close();
		}
	}
}
