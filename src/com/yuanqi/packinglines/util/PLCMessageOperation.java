package com.yuanqi.packinglines.util;

import java.sql.Timestamp;

import com.yuanqi.packinglines.entity.packflowdetail.PackFlowDetail;

/**
 * PLC���Ľ���������
 * 
 * @author lixiaogang
 *
 */
public class PLCMessageOperation {
	/**
	 * ����PLCͨѶ���ڽ��յ��ı������ݽ����󷵻ذ�װ������ϸʵ��
	 * 
	 * @param plcMessageString
	 *            ��������
	 * @return ��װ������ϸʵ��
	 * @author lixiaogang
	 * @category yuanqitec
	 */
	public static PackFlowDetail getPLCMessageData(String plcMessageString) {
		PackFlowDetail pfd=new PackFlowDetail();
		if (validatePLCMessageString(plcMessageString)) {//���ĺϷ�
			pfd.setMeterId(ASCIIUtil.asciiToString(plcMessageString.substring(2, plcMessageString.indexOf("0D0A"))));
			pfd.setDataFlag(plcMessageString.substring((plcMessageString.length()-12),(plcMessageString.length()-12)+2));
			pfd.setFinish_Date(new Timestamp(System.currentTimeMillis()));
			pfd.setResultFlag(plcMessageString.substring(plcMessageString.indexOf("0D0A")+4,plcMessageString.indexOf("0D0A")+6));
			return pfd;
		} else {
			return null;
		}

	}

	/**
	 * ��֤���ĺϷ���(ͨ����ͷ��68�ͽ�β��16)
	 * 
	 * @param plcMessageString
	 * @return
	 */

	private static boolean validatePLCMessageString(String plcMessageString) {
		String beginString = plcMessageString.substring(0, 2);
		String endString = plcMessageString.substring(
				plcMessageString.length() - 2, plcMessageString.length());
		if (beginString.equals("68") && endString.equals("16")) {
			return true;
		} else {
			return false;
		}

	}
}
