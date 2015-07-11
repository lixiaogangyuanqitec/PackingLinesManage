package com.yuanqi.packinglines.util;

import java.sql.Timestamp;

import com.yuanqi.packinglines.entity.packflowdetail.PackFlowDetail;

/**
 * PLC报文解析工具类
 * 
 * @author lixiaogang
 *
 */
public class PLCMessageOperation {
	/**
	 * 将从PLC通讯串口接收到的报文内容解析后返回包装流程明细实例
	 * 
	 * @param plcMessageString
	 *            报文内容
	 * @return 包装流程明细实例
	 * @author lixiaogang
	 * @category yuanqitec
	 */
	public static PackFlowDetail getPLCMessageData(String plcMessageString) {
		PackFlowDetail pfd=new PackFlowDetail();
		if (validatePLCMessageString(plcMessageString)) {//报文合法
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
	 * 验证报文合法性(通过开头的68和结尾的16)
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
