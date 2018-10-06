package com.amazon.aws;

import java.io.File;
import java.util.HashMap;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.rancre.config.GlobalValue;
import com.rancre.util.CommonUtil;

public class AmazonSSS {
	
	private static final String className = "AmazonSSS";
	
	public static boolean singleFileUpload(String keyName, String filePath) throws Exception {
       
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("USER-IP", "127.0.0.1");
		
		// 파일 업로드
        TransferManager tm = new TransferManager(new ProfileCredentialsProvider());
        CommonUtil.commonPrintLog("REQUEST", className, "Uploading to S3", map);
        Upload upload = tm.upload(GlobalValue.AWS_UPLOAD_BUCKET_NAME, keyName, new File(filePath));
 
        try {
        	upload.waitForCompletion();
        	CommonUtil.commonPrintLog("SUCCESS", className, "Upload OK", map);
        	return true;
        	
        } catch (AmazonClientException amazonClientException) {
        	CommonUtil.commonPrintLog("FAIL", className, "Upload Fail", map);
        	amazonClientException.printStackTrace();
        	return false;
        }
	}
	
	public static boolean singleFileDelete(String keyName) {
		
		// http://docs.aws.amazon.com/ko_kr/AmazonS3/latest/dev/DeletingOneObjectUsingJava.html
		
	    AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
	    
	    try {
	        s3Client.deleteObject(new DeleteObjectRequest(GlobalValue.AWS_UPLOAD_BUCKET_NAME, keyName));
	        
	    } catch (AmazonServiceException ase) {
	        System.out.println("Caught an AmazonServiceException.");
	        System.out.println("Error Message:    " + ase.getMessage());
	        System.out.println("HTTP Status Code: " + ase.getStatusCode());
	        System.out.println("AWS Error Code:   " + ase.getErrorCode());
	        System.out.println("Error Type:       " + ase.getErrorType());
	        System.out.println("Request ID:       " + ase.getRequestId());
	    } catch (AmazonClientException ace) {
	        System.out.println("Caught an AmazonClientException.");
	        System.out.println("Error Message: " + ace.getMessage());
	    }
	    
	    return true;
	}
	
	public static boolean moveFile(String sourceKeyName, String destKeyName) {
		
	    AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
	    
	    try {
            CopyObjectRequest copyObjRequest = new CopyObjectRequest(GlobalValue.AWS_UPLOAD_BUCKET_NAME, sourceKeyName, GlobalValue.AWS_UPLOAD_BUCKET_NAME, destKeyName);
            s3Client.copyObject(copyObjRequest);
            singleFileDelete(sourceKeyName);
            
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it to Amazon S3, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
            
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered an internal error while trying to communicate with S3, such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
	    
	    return true;
	}
}