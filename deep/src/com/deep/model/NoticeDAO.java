package com.deep.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Notice;
import com.deep.util.DAOFactory;

public class NoticeDAO {
	
	private static final String namespace = "notice";

	public static int getNoticelist(){
		return 0;
	}
	
	public static int getNotice() {  //공지 도메인 하나가져오기(먼말이지)
		return 0;
	}
	
	// default 1 - 미확인, 삭제 3도 해야하듯. 삭제는 언제? set은 읽을때만 해당되는 메서드로 코딩함.
	public static int setNotice(int inputNoticeNo){ //공지 상태 바꾸기(확인, 미확인, 삭제)
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputNoticeNo);
			
			int setNotice = (int)sqlSession.update(namespace + ".setNotice", map);
			//읽은 날짜도set해줘야?
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
	
	public static int addNotice(
			int inputNoticeNo, 
			int intputNoticeCategory, 
			int inputMemberNo,
			int NoticeTarget1,
			int NoticeTarget2,
			int inputNoticeStatus
			) {
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try{
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("NoticeNo", inputNoticeNo);
			map.put("NoticeCategory", intputNoticeCategory);
			map.put("NoticeTarget1", inputMemberNo);
			map.put("NoticeTarget2", NoticeTarget2);
			map.put("inputNoticeStatus", inputNoticeStatus);

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

	
	
	public NoticeDAO() {
		// TODO Auto-generated constructor stub
	}

}
