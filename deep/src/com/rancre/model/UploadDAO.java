package com.rancre.model;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.rancre.model.domain.Upload;
import com.rancre.util.DAOFactory;

public class UploadDAO {

	public static final String namespace = "upload";
	
	public static boolean addUpload(int inputMemberNo, int inputUploadCategory, int inputUploadStatus, int inputUploadThumbnail, long inputUploadCreateDate,
			long inputUploadDeleteDate, long inputUploadFileSize, String inputUploadFileExtension, String inputUploadOriginalFileName, String inputUploadEncryptFileName) {
	
		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		int check = 0;
		
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", inputMemberNo);
			map.put("uploadCategory", inputUploadCategory);
			map.put("uploadStatus", inputUploadStatus);
			map.put("uploadThumbnail", inputUploadThumbnail);
			map.put("uploadCreateDate", inputUploadCreateDate);
			map.put("uploadDeleteDate", inputUploadDeleteDate);
			map.put("uploadFileSize", inputUploadFileSize);
		    map.put("uploadFileExtension", inputUploadFileExtension);
		    map.put("uploadOriginalFileName", inputUploadOriginalFileName);
		    map.put("uploadEncryptFileName", inputUploadEncryptFileName);
			
			check = (Integer)sqlSession.insert(namespace + ".addUpload", map);

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

	public static int getUploadLastInsertKey() {

		SqlSession sqlSession = DAOFactory.getSqlSession(false);
		int check = 0;

		try {
			check = (Integer)sqlSession.selectOne(namespace + ".getUploadLastInsertKey");
			
			if(check > 0) {
				sqlSession.commit();	
				return check;
			} else {
				sqlSession.rollback();
				return -1;
			}

		} finally {
			sqlSession.close();
		}	
	}

	public static Upload getUploadByUploadNo(int inputUploadNo) {

		SqlSession sqlSession = DAOFactory.getSqlSession(true);

		try {
			return (Upload)sqlSession.selectOne(namespace + ".getUploadByUploadNo", inputUploadNo);
			
		} finally {
			sqlSession.close();
		}	
	}

	public static boolean setUpload(int inputUploadNo, int inputMemberNo, int inputUploadStatus, long inputUploadDeleteDate) {

		SqlSession sqlSession = DAOFactory.getSqlSession(true);
		int check = 0;
			
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("uploadNo", inputUploadNo);
			map.put("memberNo", inputMemberNo);
			map.put("uploadStatus", inputUploadStatus);
			map.put("uploadDeleteDate", inputUploadDeleteDate);
	
			check = (Integer)sqlSession.delete(namespace + ".setUpload", map);
			
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
}
