package com.rancre.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.rancre.model.domain.Channel;
import com.rancre.model.domain.ChannelLike;
import com.rancre.model.domain.ChannelView;
import com.rancre.model.domain.Company;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.MemberFavorite;
import com.rancre.model.domain.MemberUid;
import com.rancre.model.domain.Review;
import com.rancre.util.DAOFactory;

public class MemberDAO {
	
	private static final String namespace = "member";
	
	// Insert Method
	public static int addMember(
			int inputMemberStatus, 
			Timestamp inputCurrentDate,
			String encryptMemberEmail, 
			String encryptMemberPassword,
			String authToken) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberStatus", inputMemberStatus);
			map.put("inputCurrentDate", inputCurrentDate);
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberPassword", encryptMemberPassword);
			map.put("memberAuthToken", authToken);

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

	public static int addMemberUid(
			String encryptMemberEmail, 
			String memberUid) {
		
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
	

	public static int addCompany(
			String encryptMemberEmail, 
			String encryptCompanyName, 
			String encryptBusinessNumber, 
			Timestamp inputCurrentDate) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();		
			map.put("memberEmail", encryptMemberEmail);
			map.put("companyName", encryptCompanyName);			
			map.put("businessNo", encryptBusinessNumber);			

			int check = (int)sqlSession.insert(namespace + ".addCompany", map);
			
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
	

	public static int addMemberAdTarget(
			int inputAdCategory, 
			int inputTargetAge, 
			int inputTargetSex,
			String inputMemberUid) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();		
			map.put("adCategory", inputAdCategory);
			map.put("targetAge", inputTargetAge);			
			map.put("targetSex", inputTargetSex);			
			map.put("memberUid", inputMemberUid);			

			int check = (int)sqlSession.update(namespace + ".addMemberAdTarget", map);
			
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
			int mode, 
			int inputMemberNo, 
			String encryptMemberMajor, 
			String encryptMemberCareer,
			String encryptMemberName, 
			String encryptMemberPassword) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("mode", mode);
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
	
	public static int changeMemberPassword(String inputMemberEmail, String inputMemberPassword) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", inputMemberEmail);
			map.put("memberPassword", inputMemberPassword);

			int check = (int)sqlSession.update(namespace + ".changeMemberPassword", map);
			
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
	

	public static int permitJoin(String inputEmail) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("email", inputEmail);

			int check = (int)sqlSession.update(namespace + ".permitJoin", map);
			
			if(check == 1) {
				sqlSession.commit();
				return 1;
			} else {
				sqlSession.rollback();
				return 0;
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

	public static int getMemberNoByMemberUid(String inputMemberUid) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".getMemberNoByMemberUid", inputMemberUid);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkCompany(String inputBusinessNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".checkCompany", inputBusinessNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Member getMemberByJoinPermit(String encryptMemberEmail, String inputUid) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberUid", inputUid);

			return (Member)sqlSession.selectOne(namespace + ".getMemberByJoinPermit", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Member getMemberByMemberUid(String inputMemberUid) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberUid", inputMemberUid);

			return (Member)sqlSession.selectOne(namespace + ".getMemberByMemberUid", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Company getCompanyByMemberNo(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (Company)sqlSession.selectOne(namespace + ".getCompanyByMemberNo", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Review> getReviewListByMemberNo(int inputMemberNo, int startNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("startNo", startNo);

			return (ArrayList)sqlSession.selectList(namespace + ".getReviewListByMemberNo", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Channel> getRecentChannelList(int inputMemberNo, int startNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("startNo", startNo);

			return (ArrayList)sqlSession.selectList(namespace + ".getRecentChannelList", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static ArrayList<Channel> getChannelLikeList(int inputMemberNo, int startNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("startNo", startNo);

			return (ArrayList)sqlSession.selectList(namespace + ".getChannelLikeList", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countMemberReview(int sessionMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".countMemberReview", sessionMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countMemberChannelView(int sessionMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".countMemberChannelView", sessionMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int countMemberChannelLike(int sessionMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".countMemberChannelLike", sessionMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkValidMember(String inputMemberEmail) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (int)sqlSession.selectOne(namespace + ".checkValidMember", inputMemberEmail);
			
		} finally {
			sqlSession.close();
		}
	}

	public static MemberUid getMemberUidByEmail(String inputMemberEmail) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			return (MemberUid)sqlSession.selectOne(namespace + ".getMemberUidByEmail", inputMemberEmail);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkMemberAuthToken(String encryptMemberEmail, String inputCheckValue) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberAuthToken", inputCheckValue);

			return (int)sqlSession.selectOne(namespace + ".checkMemberAuthToken", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static int setAuthTokenByValidMember(String encryptMemberEmail, String checkValue) {
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberAuthToken", checkValue);


			int check = (int)sqlSession.update(namespace + ".setAuthTokenByValidMember", map);
			
			if(check == 1) {
				sqlSession.commit();
				return 1;
			} else {
				sqlSession.rollback();
				return 0;
			}
			
			
		} finally {
			sqlSession.close();
		}
	}

	public static int checkValidMemberByToken(String encryptMemberEmail, String inputCheckValue) {
			
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", encryptMemberEmail);
			map.put("memberAuthToken", inputCheckValue);

			return (int)sqlSession.selectOne(namespace + ".checkValidMemberByToken", map);			
		} finally {
			sqlSession.close();
		}
	
	}

}
