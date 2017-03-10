package com.deep.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Notice;
import com.deep.util.DAOFactory;

public class NoticeDAO {
	
	private static final String namespace = "notice";

	public static Notice getNoticelist(int inputMemberNo){
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("MemberNo", inputMemberNo);
			
			return (Notice)sqlSession.selectList(namespace + ".getNoticeList", map);
		}finally{
			sqlSession.close();
		}
	}
	
	public static Notice getNotice(int inputNoticeNo) {  
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("NoticeNo", inputNoticeNo);
			
			return (Notice)sqlSession.selectOne(namespace + ".getNotice", map);
		}finally{
			sqlSession.close();
		}
	}
	
	// default(1) : addFollow시 / 확인(2) : getNotice 시, 삭제(3) : Feed에만 해당?? 아님 setFollo?
	public static int setNotice(int inputNoticeNo, int inputNoticeStatus, long inputConfirmDate){ //공지 상태 바꾸기(확인, 미확인, 삭제). 모드가 아니라 스테터스 넘기면됨(컨트롤러에서)
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("NoticeNo", inputNoticeNo);
			map.put("NoticeStatus", inputNoticeStatus);
			map.put("ConfirmDate", inputConfirmDate);
			
			int setNotice = (int)sqlSession.update(namespace + ".setNotice", map);

			if(setNotice == 1) {
				sqlSession.commit();
				return setNotice;
			} else {
				sqlSession.rollback();
				return setNotice;
			}
			
		} finally {
			sqlSession.close();
		}
		
		
	}
	
	public static int addNotice(int inputNoticeCategory, int inputFollower, int inputFollowing, int inputNoticeStatus, long inputCurrentDate){ //일단 Follow입장만 짜놈.
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("NoticeCategory", inputNoticeCategory); // follow(4or 5)쪽일때. 커멘트는 1~3. 시스템은 0.
			map.put("MemberNo", inputFollower); //알림 주는 사람? 만든 사람?
			map.put("NoticeTarget1", inputFollower); //알림 주는 주체
			map.put("NoticeTarget2", inputFollowing); // 알림 받는 주체
			map.put("NoticeStatus", inputNoticeStatus); //status . 안읽음 default
			map.put("NoticeCreateDate", inputCurrentDate);
			
			int addNotice = (int)sqlSession.insert(namespace + ".addNotice", map);
			
			if(addNotice == 1) {
				sqlSession.commit();
				return addNotice;
			} else {
				sqlSession.rollback();
				return addNotice;
			}
		} finally{
			sqlSession.close();
		}
	}
//
	
	
	public NoticeDAO() {
		// TODO Auto-generated constructor stub
	}

}
