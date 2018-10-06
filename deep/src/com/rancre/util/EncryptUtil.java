package com.rancre.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.commons.codec.binary.Base64;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EncryptUtil {
	
	public static byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
	
	// 개인 정보 암호화 키 가져오기
	public static String AES_getKey(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
		File file = new File(xmlPath);
		DocumentBuilderFactory docBuildFact = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuild = docBuildFact.newDocumentBuilder();
		Document doc = docBuild.parse(file);
		doc.getDocumentElement().normalize();
  
		NodeList aesList = doc.getElementsByTagName("aes");
		Node aesNode = aesList.item(0);
			
		Element aesElement = (Element) aesNode;
 		NodeList keyList= aesElement.getElementsByTagName("key");
		Element keyElement = (Element) keyList.item(0);
		Node key = keyElement.getFirstChild();					
 
		return key.getNodeValue().toString();
	}
		
	public static String AES_Encode(String str, String key)	throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,	IllegalBlockSizeException, BadPaddingException {
		if(str == null) return "";
		byte[] textBytes = str.getBytes("UTF-8");
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		Cipher cipher = null;
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
		return Base64.encodeBase64String(cipher.doFinal(textBytes));
	}

	public static String AES_Decode(String str, String key)	throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {	
		byte[] textBytes = Base64.decodeBase64(str);
		//byte[] textBytes = str.getBytes("UTF-8");
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
		return new String(cipher.doFinal(textBytes), "UTF-8");
	}
	
    public static String RSA_Decode(PrivateKey privateKey, String securedValue) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        byte[] encryptedBytes = CommonUtil.hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedValue = new String(decryptedBytes, "UTF-8"); // 문자 인코딩 주의.
        return decryptedValue;
    }
    
    public static String SHA256_Encode(String str) { // 160 bit
    	String SHA = ""; 
    	try{
    		MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
    		sh.update(str.getBytes()); 
    		byte byteData[] = sh.digest();
    		StringBuffer sb = new StringBuffer(); 
    		for(int i = 0 ; i < byteData.length ; i++){
    			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
    		}
    		SHA = sb.toString();
    		
    	} catch(NoSuchAlgorithmException e){
    		e.printStackTrace(); 
    		SHA = null; 
    	}
    	return SHA;
    }
    
    public static String MD5_Encode(String str) {
    	String MD5 = ""; 
    	
    	try {
    		MessageDigest md = MessageDigest.getInstance("MD5"); 
    		md.update(str.getBytes()); 
    		byte byteData[] = md.digest();
    		StringBuffer sb = new StringBuffer(); 
   
    		for(int i = 0 ; i < byteData.length ; i++) {
    			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
    		}
   
    		MD5 = sb.toString();
    	   
    	} catch(NoSuchAlgorithmException e) {
    	   e.printStackTrace(); 
    	   MD5 = null; 
    	}
    	return MD5;
    }
    
    public static int getRandomNumber(int start, int end) {
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}