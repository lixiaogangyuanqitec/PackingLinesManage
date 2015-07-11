package com.yuanqi.packinglines.util;

/***
 * ASCII�빤����
 * 
 * @author lixiaogang
 *
 */
public class ASCIIUtil {
	
	/***
	 * �ַ���ת��ASCII��
	 * @author lixiaogang
	 */
	public static void t2() {// �ַ���ת��ΪASCII��
		String s = "3130018005611561185435";// �ַ���
		char[] chars = s.toCharArray(); // ���ַ���ת��Ϊ�ַ�����
		System.out.println("\n\n���� ASCII\n----------------------");
		for (int i = 0; i < chars.length; i++) {// ������
			System.out.print((int) chars[i]);
		}
	}
	
	
	/***
	 * ascii��ת���ַ���
	 * @param text ASCII��
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
