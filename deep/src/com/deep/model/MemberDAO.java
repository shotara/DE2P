package com.deep.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.deep.util.DAOFactory;

public class MemberDAO {
	
	private static final String namespace = "member";
	
	public static int checkMember(String inputMemberEmail) {
		
		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		
		try {	
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberEmail", inputMemberEmail);

			return (int)sqlSession.selectOne(namespace + ".checkMember", map);
			
		} finally {
			sqlSession.close();
		}
	}
}
