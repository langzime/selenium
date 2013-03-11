package util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

import com.sun.org.apache.regexp.internal.recompile;

public class Util {
	public static  String getProp(String key) {
		Properties props = new Properties();
		InputStream in = Util.class.getResourceAsStream(
				"OnOff.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = props.getProperty(key);
		return value;
	}
	/**
	 * 得到随机字符串
	 * @param length 要得到字符串的长度
	 * @param haveLetter 是否包含字母
	 * @param haveDigit 是否包含数字
	 * @return 
	 */
	public static String getRandomString(int length,boolean haveLetter,boolean haveDigit){
		StringBuffer sb=new StringBuffer();
		int p=0;
		if(haveLetter){
			sb.append("abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ");
			p=p+sb.length();
		}
		if(haveDigit){
			sb.append("0123456789");
			p=p+10;
		}
		Random rdm=new Random();
		StringBuffer sb1=new StringBuffer();
		char[] sArr=sb.toString().toCharArray();
		System.out.println(sArr.length);
		for(int i=0;i<length;i++){
			sb1.append(sArr[rdm.nextInt(p)]);
		}
		return sb1.toString();
	}
	/**
	 * 得到随机的邮箱
	 * @return
	 */
	public static String getRandomEmail(){
		StringBuffer sb=new StringBuffer();
		sb.append(getRandomString(10,true,true)+"@"+getRandomString(5,true,true)+".com");
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRandomEmail());
		System.out.println(getRandomString(18, true, true));
		System.out.println(getRandomString(18, false, true));
		System.out.println(getRandomString(18, true, false));
	}

	
}
