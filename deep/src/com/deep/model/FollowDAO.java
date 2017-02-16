package com.deep.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Follow;
import com.deep.util.DAOFactory;


public class FollowDAO {
	private static final String namespace = "Follow";
	
	public static int getFollower(int deepFollower){ // 로그인했다는 전제니까. 매개변수x?
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace +" .getFollower", deepFollower);
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static int getFollowing(int deepFollower) { // 팔로워에 따른 팔로잉
	
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (int)sqlSession.selectOne(namespace +" .getFollowing", deepFollower);
			//set List??
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static int addFollow(int inputFollower, int inputFollowing) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("follower", inputFollower);
			map.put("following", inputFollowing);
			
			int addFo = (int)sqlSession.insert(namespace + " .addFollow", map);
			
			if(addFo == 1) { //2명한꺼번에 add가능한가...?
				sqlSession.commit();
				return addFo;
			} else {
				sqlSession.rollback();
				return addFo;
			}
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static boolean setFollow(int deepFollowing) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {
			int setFo = (int)sqlSession.delete(namespace + " .setFollow", deepFollowing);
			
			if(setFo == 1) { //여러명 삭제할수 있나?
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
}
