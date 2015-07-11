package com.yuanqi.packinglines.util;

/***
 * ASCII码工具类
 * 
 * @author lixiaogang
 *
 */
public class ASCIIUtil {
	
	/***
	 * 字符串转成ASCII码
	 * @author lixiaogang
	 */
	public static void t2() {// 字符串转换为ASCII码
		String s = "3130018005611561185435";// 字符串
		char[] chars = s.toCharArray(); // 把字符中转换为字符数组
		System.out.println("\n\n汉字 ASCII\n----------------------");
		for (int i = 0; i < chars.length; i++) {// 输出结果
			System.out.print((int) chars[i]);
		}
	}
	
	
	/***
	 * ascii码转成字符串
	 * @param text ASCII码
	 * @return
	 */
	public static String asciiToString(String text) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) <= '2' && i <= text.length() - 3) {
                int code = Integer.parseInt(text.substring(i, i + 3));
                builder.append((char) code);
                i += 2;
            } else {
                int code = Integer.parseInt(text.substring(i, i + 2));
                builder.append((char) code);
                i += 1;
            }
        }
        return builder.toString();
    }
}
