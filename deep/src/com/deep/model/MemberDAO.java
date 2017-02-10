package com.deep.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Member;
import com.deep.model.domain.MemberFavorite;
import com.deep.model.domain.MemberUid;
import com.deep.util.DAOFactory;

public class MemberDAO {
	
	private static final String namespace = "member";
	
	// Insert Method
	public static int addMember(
			int inputMemberStatus, 
			int inputMemberLevel, 
			long inputCurrentDate,
			String encryptMemberMajor,
			String encryptMemberCareer, 
			String encryptMemberEmail, 
			String encryptMemberName,
			String encryptMemberPassword, 
			int inputMemberImage) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberStatus", inputMemberStatus);
			map.put("memberLevel", inputMemberLevel);	
			map.put("inputCurrentDate", inputCurrentDate);
			map.put("memberMajor", encryptMemberMajor);			
			map.put("memberCareer", encryptMemberCareer);			
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberName", encryptMemberName);			
			map.put("memberPassword", encryptMemberPassword);
			map.put("memberImage", inputMemberImage);

			int check = (int)sqlSession.insert(namespace + ".addMember", map);
			
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

	public static int addMemberUid(String encryptMemberEmail, String memberUid) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();		
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberUid", memberUid);			

			int check = (int)sqlSession.insert(namespace + ".addMemberUid", map);
			
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
	
	
	// Update Method
	public static int setMember(
			int inputMemberNo, 
			int inputMemberLevel, 
			String encryptMemberMajor,
			String encryptMemberCareer, 
			String encryptMemberName,
			String encryptMemberPassword) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("memberMajor", encryptMemberMajor);			
			map.put("memberCareer", encryptMemberCareer);			
			map.put("memberName", encryptMemberName);			
			map.put("memberPassword", encryptMemberPassword);

			int check = (int)sqlSession.update(namespace + ".setMember", map);
			
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

	public static boolean setMemberImg(int inputMemberNo, int inputUploadNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("uploadNo", inputUploadNo);			

			int check = (int)sqlSession.update(namespace + ".setMemberImg", map);
			
			if(check == 1) {
				sqlSession.commit();
				return true;
			} else {
				sqlSession.rollback();
				return false;
			}
			
			
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	// Select Method
	public static int checkMember(int mode, String inputMemberParam) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", mode);
			map.put("memberParam", inputMemberParam);

			return (int)sqlSession.selectOne(namespace + ".checkMember", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Member getMemberByMemberNo(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (Member)sqlSession.selectOne(namespace + ".getMemberByMemberNo", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static Member getMemberByMemberMail(String encryptMemberEmail, String encryptMemberPassword) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberPassword", encryptMemberPassword);

			return (Member)sqlSession.selectOne(namespace + ".getMemberByMemberMail", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static MemberUid getMemberUid(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (MemberUid)sqlSession.selectOne(namespace + ".getMemberUid", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	
	public static MemberFavorite getMemberFavorite(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (MemberFavorite)sqlSession.selectOne(namespace + ".getMemberFavorite", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}
}
