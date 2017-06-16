package com.baizhi.util;

import java.util.Random;

/**
 * 随机盐的工具类
 * @author Administrator
 *
 */
public class SaltUtils {
	
	/**
	 * 生成随机盐的方法
	 * @param n
	 * @return
	 */
	public static String  getSalt(int n){
		char[] code ="1234567890ASDFGHJKLPOIUYTREWQZXCVBNMasdfghjklpoiuytrewqzxcvbnm!Q@W#E$R%T^Y&U".toCharArray();
		//随机数
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		//StringBuilder 线程不安全  轻量级    效率高
		for (int i = 0; i < n; i++) {
			sb.append(code[random.nextInt(code.length)]);
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
	
}
