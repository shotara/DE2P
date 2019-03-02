package com.rancre.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class CommonUtil {

	public static String commonCleanXSS(String value) {
		
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("'", "&#39;");		  
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("script", "");
		
		value = value.replaceAll("javascript", "x-javascript");
		value = value.replaceAll("script", "x-script");
		value = value.replaceAll("iframe", "x-iframe");
		value = value.replaceAll("document", "x-document");
		value = value.replaceAll("vbscript", "x-vbscript");
		value = value.replaceAll("applet", "x-applet");
		value = value.replaceAll("embed", "x-embed");  // embed 태그를 사용하지 않을 경우만
		value = value.replaceAll("object", "x-object");    // object 태그를 사용하지 않을 경우만
		value = value.replaceAll("frame", "x-frame");
		value = value.replaceAll("grameset", "x-grameset");
		value = value.replaceAll("layer", "x-layer");
		value = value.replaceAll("bgsound", "x-bgsound");
		value = value.replaceAll("alert", "x-alert");
		value = value.replaceAll("onblur", "x-onblur");
		value = value.replaceAll("onchange", "x-onchange");
		value = value.replaceAll("onclick", "x-onclick");
		value = value.replaceAll("ondblclick","x-ondblclick");
		value = value.replaceAll("enerror", "x-enerror");
		value = value.replaceAll("onfocus", "x-onfocus");
		value = value.replaceAll("onload", "x-onload");
		value = value.replaceAll("onmouse", "x-onmouse");
		value = value.replaceAll("onscroll", "x-onscroll");
		value = value.replaceAll("onsubmit", "x-onsubmit");
		value = value.replaceAll("onunload", "x-onunload");

		return value;
		
	}

	public static void commonPrintLog(String result, String location, String message, HashMap<String, String> map) {

		String printStr = printCurrentTime() + " " + result + " : [" + location + "] " + message + " (";
		
		if(map.get("DEVICE") != null) {
			printStr += "DEVICE : " + map.get("DEVICE") + ", ";
		}
		
		if(map.get("ACTION") != null) {
			printStr += "ACTION : " + map.get("ACTION") + ", ";
		}

		if(map.get("USER-NO") != null) {
			printStr += "USER-NO : " + map.get("USER-NO") + ", ";
		}
						
		if(map.get("POST-NO") != null) {
			printStr += "POST-NO : " + map.get("POST-NO") + ", ";
		}
		
		if(map.get("MEETING-NO") != null) {
			printStr += "MEETING-NO : " + map.get("MEETING-NO") + ", ";
		}
		
		if(map.get("FLASHING-NO") != null) {
			printStr += "FLASHING-NO : " + map.get("FLASHING-NO") + ", ";
		}

		if(map.get("PAYMENT-NO") != null) {
			printStr += "PAYMENT-NO : " + map.get("PAYMENT-NO") + ", ";
		}

		if(map.get("ZONE-NO") != null) {
			printStr += "ZONE-NO : " + map.get("ZONE-NO") + ", ";
		}
		
		if(map.get("NOTICE-NO") != null) {
			printStr += "NOTICE-NO : " + map.get("NOTICE-NO") + ", ";
		}
		
		printStr += ")";
		System.out.println(printStr);
		
		return;
		
	}

	public static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() % 2 != 0) {
        	return new byte[]{};
        }

		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
        	byte value = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
        	bytes[(int) Math.floor(i / 2)] = value;
		}
		return bytes;
	}

	public static boolean commonParameterCheck(ArrayList<Object> list) {
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getClass().getName() == "java.lang.String") {
				
				String tempStr = list.get(i).toString();
				
				if(tempStr.equals("")) {
					return false;
				}

				if(tempStr.equals("null")) {
					return false;
				}
				
				if(tempStr.equals(null)) {
					return false;
				}

				if(tempStr.contains("<") || tempStr.contains(">") || tempStr.contains("'") || tempStr.contains("script")) {
					return false;
				}
			}
			
			if(list.get(i).getClass().getName() == "java.lang.Integer") {
				if(Integer.parseInt(list.get(i).toString()) == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// 현재 시각을 출력한다.
	public static String printCurrentTime() {
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = dayTime.format(new Date(time));
		return str;
	}

	// UnixTimestamp 값을 Datetime 형식으로 변환한다.
	public static String convertUnixTime(long unixTime, int mode) {
		
		if(unixTime == 0) {
			unixTime = System.currentTimeMillis()/1000;
		}
		
		Date date = new Date(unixTime * 1000L);
		SimpleDateFormat sdf = null;
		
		switch(mode) {
			case 1:
				sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				break;
			case 2:
				sdf = new SimpleDateFormat("yyyy.MM.dd (E) HH:mm");
				break;
			case 3:
				sdf = new SimpleDateFormat("yyyy/MM/dd");
				break;
			case 4:
				sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) HH:mm");
				break;
			case 5:
				sdf = new SimpleDateFormat("dd E");
				break;
			case 6:
				sdf = new SimpleDateFormat("dd");
				break;
			case 7:
				sdf = new SimpleDateFormat("MM");
				break;
			case 8:
				sdf = new SimpleDateFormat("yyyyMMdd");
				break;
			case 9:
				sdf = new SimpleDateFormat("MM월 dd일 (E) HH:mm");
				break;
			case 10:
				sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");
				break;
			case 11:
				sdf = new SimpleDateFormat("HH:mm a");
				break;
			case 12:
				sdf = new SimpleDateFormat("HHmm");
				break;
			case 13:
				sdf = new SimpleDateFormat("MM/dd/yyyy");
				break;
			case 14:
				sdf = new SimpleDateFormat("HH:mm");
				break;
			case 15:
				sdf = new SimpleDateFormat("yy.MM.dd");
				break;
			case 16:
				long currentDate = System.currentTimeMillis()/1000;
				long compareDate = currentDate - unixTime;
				
				Date date2 = new Date(compareDate * 1000L);
				SimpleDateFormat sdf2 = null;
				
				if(compareDate <= 60) {
					return compareDate + "초 전";
				} else if(compareDate <= 60*60) {
					return compareDate/60 + "분 전";
				} else if(compareDate <= 60*60*24) {
					return compareDate/(60*60) + "시간 전";	
				} else {
					return compareDate/(60*60*24) + "일 전";
				}
		}
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+9"));
		
		return sdf.format(date);
	}

	public static long convertDateTime(String date, String time) {
	
		// date - 20160222
		// time - 11:00 AM
		
		Date dt = new Date();
	
		if(time.length() == 7) {
			time = "0" + time;
		}
	
		dt.setYear(Integer.parseInt(date.substring(0,4))-1900);
		dt.setMonth(Integer.parseInt(date.substring(4,6))-1);
		dt.setDate(Integer.parseInt(date.substring(6,8)));
		
		if(time.substring(6, 8).equals("AM")) {
			dt.setHours(Integer.parseInt(time.substring(0, 2)));
		} else {
			dt.setHours(Integer.parseInt(time.substring(0, 2))+12);				
		}
		
		dt.setMinutes(Integer.parseInt(time.substring(3, 5)));
		dt.setSeconds(0);
		
		return dt.getTime()/1000; // GMT+9
	}
	
	public static long convertDateTime2(String date, String time) {
		
		// date - 20160222
		// time - 1300
		
		Date dt = new Date();
	
		dt.setYear(Integer.parseInt(date.substring(0,4))-1900);
		dt.setMonth(Integer.parseInt(date.substring(4,6))-1);
		dt.setDate(Integer.parseInt(date.substring(6,8)));
		dt.setHours(Integer.parseInt(time.substring(0,2)));
		dt.setMinutes(Integer.parseInt(time.substring(2,4)));
		dt.setSeconds(0);
		
		return dt.getTime()/1000; // GMT+9
	}
	
	public static ArrayList<String> commonSpiltBySemicolon(String str) {
	
		ArrayList<String> list = new ArrayList<String>();
		String[] temp = null;
	
		temp = str.split(";");
	
		for(int i=0; i<temp.length; i++) {
			list.add(temp[i]);
		}
		
		return list;
	}
	
	public static ArrayList<String> commonSpiltByComma(String str) {
		
		ArrayList<String> list = new ArrayList<String>();
		String[] temp = null;
		
		str = str.replaceAll(" ", "");
		temp = str.split(",");
		
		for(int i=0; i<temp.length; i++) {
			list.add(temp[i]);
		}
		
		return list;
	}

	public static String getCategoryName(int deepCategoryNo) {
		
		switch(deepCategoryNo) {
		case 1:
			return "Database";
		case 2:
			return "Language";
		case 3:
			return "Server";
		case 4:
			return "etc..";
		default:
			return "All";
		}
	}

	public static String getFeedTypeName(int deepFeedType) {
		
		switch(deepFeedType) {
		case 1:
			return "일반문서";
		case 2:
			return "번역문서";
		case 3:
			return "광고";
		default:
			return "일반문서";
		}
	}
	
	public static String splitString(String str, int mode) {
		
		switch(mode) {
		case 1:
			if(str.length() > 10) return str.substring(0,10)+"...";
			else return str;
		case 2:
			if(str.length() > 15) return str.substring(0,15)+"...";
			else return str;		
		case 3:
			if(str.length() > 20) return str.substring(0,20)+"...";
			else return str;
		default:
			return null;
		}
	}
	
	public static String getChannelCategoryName(int categoryNo) {
		
		switch(categoryNo) {
		case 2:
			return "#스튜디오/엔터";
		case 3:
			return "#예능/토크";
		case 4:
			return "#미사용";
		case 5:
			return "#노래 댄스";
		case 6:
			return "#테크/교육";
		case 7:
			return "#시사/이슈";
		case 8:
			return "#뷰티";
		case 9:
			return "#여행/일상";
		case 10:
			return "#게임";
		case 11:
			return "#스포츠";
		case 12:
			return "#먹방/쿡방";
		case 13:
			return "#키즈";
		case 14:
			return "#반려동물";
		case 15:
			return "#ASMR";
		case 16:
			return "#취미/예술";
		case 17:
			return "#리뷰어";
		case 18:
			return "#스트리머";
		default:
			return "#기타";
		}
	}
	
	public static String getChannelCategoryList(String inputChannelCategory) {
		ArrayList<String> category = commonSpiltBySemicolon(inputChannelCategory);
		String result = "";
		for(int i=0; i<category.size(); i++) {
			if(i>0) {
				result += ", " + getChannelCategoryName(Integer.parseInt(category.get(i)));

			} else 
				result += getChannelCategoryName(Integer.parseInt(category.get(i)));
		}
		
		return result;
	
	}
	
	public static String setCommaForInt(int i) {
		return String.format("%,d", i);
	}
	
	public static String setCommaForLong(Long i) {
		return String.format("%,d", i);
	}
	
	public static String getReviewTarget(int no) {
		switch(no) {
		case 1:
			return "달성";
		case 2:
			return "미달성";
		case 3:
			return "초과달성";
		default:
			return "달성";
		}
	}
	
	public static String getGender(int no) {
		switch(no) {
		case 1:
			return "남성";
		case 2:
			return "여성";
		default:
			return "남/녀 공통";
		}
	}
	
	public static String getAge(int no) {
		switch(no) {
		case 1:
			return "10대 초반 ~ 20대 초반";
		case 2:
			return "20대 초반 ~ 30대 초반";
		case 3:
			return "30대 초반 ~ 40대 초반";
		case 4:
			return "40대 초반 ~ 50대 초반";
		default:
			return "전체";
		}
	}
	
	public static String getRecomand(int no) {
		switch(no) {
		case 1:
			return "예";
		case 2:
			return "아니요";
		default:
			return "예";
		}
	}
	
	public static String getChannelAdDate(int no) {
		switch(no) {
		case 0:
			return "2019";
		case 1:
			return "2018";
		case 2:
			return "2017";
		case 3:
			return "2016";
		default:
			return "2019";
		}
	}

	public static String getReviewStatus(int no) {
		switch(no) {
		case 1:
			return "검토중";
		case 2:
			return "승인";
		case 3:
			return "반려";
		case -1:
			return "삭제";
		default:
			return "검토중";
		}
	}

	public static String getReviewSatisfy(int no) {
		switch(no) {
		case 1:
			return "만족";
		case 2:
			return "불만족";
		default:
			return "만족";
		}
	}
	
	public static String getReviewSatisfy5(int no) {
		switch(no) {
		case 1:
			return "매우 만족";
		case 2:
			return "만족";
		case 3:
			return "보통";
		case 4:
			return "불만족";
		case 5:
			return "매우 불만족";
		default:
			return "보통";
		}
	}
	
	public static String getReviewAdType(int no) {
		switch(no) {
		case 1:
			return "기타";
		case 2:
			return "영상 콘텐츠";
		case 3:
			return "배너 광고";
		case 4:
			return "물품협찬";
		case 5:
			return "섭외";
		case 6:
			return "True View";
		default:
			return "기타";
		}
	}	

	public static String getChannelDetailDate(Timestamp date) {
		Date currentDate = new Date();
		long newDate = (currentDate.getTime() - date.getTime()) / 1000;  /// 1초 

		if(newDate <3600) return Math.round(newDate/60) + "분 전";
		else if (newDate < 3600 * 24) return Math.round(newDate/3600) + "시간 전";
		else if (newDate < 3600 * 24 * 7) return Math.round(newDate/(3600*24)) + "일 전";
		else if (newDate < (3600 * 24 * 7 * 5)-(3600 * 24 *4)) return Math.round(newDate/(3600*24*7)) + "주 전";
		else if (newDate < 3600 * 24 * 365) return Math.round(newDate/(3600 * 24 * 31)) + "개월 전";
		else return Math.round(newDate/(3600 * 24 * 365)) + "년 전";
		

	}
	
	public static int getChannelVideoCreateDate(Timestamp date) {
		Date currentDate = new Date();
		int newDate = (int) ((currentDate.getTime() - date.getTime()) / 1000);  /// 1초 
		
		return newDate;
	}
	
	public static String getCompanyAdCategory(int no) {
		switch(no) {
		case 1:
			return "서비스";
		case 2:
			return "제조/화학";
		case 3:
			return "의료/제약/복지";
		case 4:
			return "유통/무역/운송";
		case 5:
			return "교육업";
		case 6:
			return "건설업";
		case 7:
			return "IT/웹/통신";
		case 8:
			return "미디어/디자인";
		case 9:
			return "은행/금융업";
		case 10:
			return "기관/협회";
		case 11:
			return "기타";

		default:
			return "기타";
		}
	}
	
}