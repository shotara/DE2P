package com.deep.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.model.domain.Follow;
import com.deep.model.domain.FollowMember;
import com.deep.util.DAOFactory;


public class FollowDAO {
	
	private static final String namespace = "follow";
	
	// insert
	public static int addFollow(int inputFollower, int inputFollowing) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("follower", inputFollower);	
			map.put("following", inputFollowing);			
	
			int check = (int)sqlSession.insert(namespace + ".addFollow", map);
			
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
	
	// delete
	public static int deleteFollow(int inputFollower, int inputFollowing) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("follower", inputFollower);
			map.put("following", inputFollowing);			
		
			int check = (int)sqlSession.delete(namespace + ".deleteFollow", map);
			
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
	public static ArrayList<FollowMember> getFollower(int inputMemberNo){ 
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (ArrayList)sqlSession.selectList(namespace +" .getFollower", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}
	
	public static ArrayList<FollowMember> getFollowing(int inputMemberNo) {
	
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (ArrayList)sqlSession.selectList(namespace +" .getFollowing", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}
	

	public static int checkFollow(int inputFollower, int inputFollowing) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("follower", inputFollower);
			map.put("following", inputFollowing);

			return (int)sqlSession.selectOne(namespace + ".checkFollow", map);
			
		} finally {
			sqlSession.close();
		}
	}

	public static Follow countFollow(int inputMemberNo) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {
			return (Follow)sqlSession.selectList(namespace +" .countFollow", inputMemberNo);
			
		} finally {
			sqlSession.close();
		}
	}
}
