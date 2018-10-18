package com.rancre.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.amazon.aws.AmazonSSS;
import com.rancre.config.GlobalValue;
import com.rancre.model.MemberDAO;
import com.rancre.model.UploadDAO;
import com.rancre.model.domain.Member;
import com.rancre.model.domain.Upload;
import com.rancre.util.EncryptUtil;

public class UploadController {

	public static int uploadFile(HashMap<String, Object> uploadMap, String location, String fileName, String filePath) {
	
		try {
			int inputUploadCategory = 0;
			int inputUploadStatus = 1; // 초기값
			String inputUploadKeyName = "";
			int inputUploadThumbnail = 1;
			long inputUploadCreateDate = System.currentTimeMillis()/1000;
			long inputUploadDeleteDate = 0;
			long inputUploadFileSize = 0;
			String inputUploadFileExtension = "";
			String inputUploadOriginalFileName = "";
			String inputUploadEncryptFileName = "";
			
			// AWS S3 업로드 키네임 설정
			switch(location) {
				case "MemberController":
					inputUploadCategory = 1;
					inputUploadKeyName = "member/" + uploadMap.get("deepMemberUid").toString() + "/";
					break;
				case "FeedController":
					inputUploadCategory = 2;
					inputUploadKeyName = "feed/temp/";
					break;
				default:
					return -1;				
			}

			// 확장자 가져오기
			int pos = fileName.lastIndexOf( "." );
			inputUploadFileExtension = fileName.substring( pos + 1 );
			
			// 업로드할 파일 이름 암호화
			inputUploadOriginalFileName = fileName;
			inputUploadEncryptFileName = EncryptUtil.MD5_Encode(fileName + System.currentTimeMillis()); // 32 bytes
					
			// 파일 사이즈 구하기
			File file = new File(filePath);
			inputUploadFileSize = file.length(); // bytes
			
			if(!(inputUploadFileSize > 0)) {
				return -2;
			}
			
			// 업로드 테이블에 삽입
			if(!UploadDAO.addUpload(Integer.parseInt(uploadMap.get("deepMemberNo").toString()), inputUploadCategory, inputUploadStatus, inputUploadThumbnail, inputUploadCreateDate, inputUploadDeleteDate, inputUploadFileSize, inputUploadFileExtension, inputUploadOriginalFileName, inputUploadEncryptFileName)) {
				return -3;
			}
			
			// AWS S3 업로드
			String keyName = inputUploadKeyName + inputUploadEncryptFileName + "." + inputUploadFileExtension;
			if(!AmazonSSS.singleFileUpload(keyName, filePath)) {
				return -4;
			}
			
			// 인덱스 키 가져오기
			int check = UploadDAO.getUploadLastInsertKey();
			if(check > 0) {
				return check;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return -5;
	}

	public static int deleteUpload(ArrayList<String> uploadList, HashMap<String, Object> uploadMap, int inputMemberNo) {

//		try {
//			for(int i=0; i<uploadList.size(); i++) {
//				Upload upload = UploadDAO.getUploadByUploadNo(Integer.parseInt(uploadList.get(i)));
//				
//				Member member = MemberDAO.getMemberByMemberNo(inputMemberNo);
//				if(member.getDeepMemberImage() != -1) {
//					if(!UploadDAO.setUpload(upload.getDeepUploadNo(), inputMemberNo, -1, System.currentTimeMillis()/1000)) {
//						return -1;
//					}
//					
//					if(!AmazonSSS.singleFileDelete(getAWSKeyName(2, uploadMap, upload.getDeepUploadCategory(), false) + upload.getDeepUploadEncryptFileName() + "." + upload.getDeepUploadFileExtension())) {
//						return -2;
//					}					
//				}
//			}
//			
//			return 1;
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		
		return -3;
	}
	
	public static String getAWSKeyName(int mode, HashMap<String, Object> uploadMap, int inputUploadCategory, boolean service) {	
		
		try {
			if(service) { // 출력하기
				switch(inputUploadCategory) {
					case 1:
						return (mode == 1 ? GlobalValue.AWS_CLOUDFRONT_USER_BUCKET_URL : "") + "/member/" + uploadMap.get("deepMemberUid").toString() + "/";
					case 2:
						return (mode == 1 ? GlobalValue.AWS_CLOUDFRONT_USER_BUCKET_URL : "") + "/feed/" + uploadMap.get("deepFeedgNo").toString() + "/";
				}

			} else { // 업로드하기
				switch(inputUploadCategory) {
					case 1:
						return (mode == 1 ? GlobalValue.AWS_S3_USER_BUCKET_URL : "") + "/member/" + uploadMap.get("deepMemberUid").toString() + "/";
					case 2:
						return (mode == 1 ? GlobalValue.AWS_S3_USER_BUCKET_URL : "") + "/feed/" + uploadMap.get("deepFeedgNo").toString() + "/";
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "-1";
	}
}

