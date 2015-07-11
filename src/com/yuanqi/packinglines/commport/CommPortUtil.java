package com.yuanqi.packinglines.commport;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

/***
 * 串口操作工具类
 * 
 * @author lixiaogang
 *
 */
public class CommPortUtil {

	/***
	 * 得到串口名字
	 */
	public static String getCommPortName() {
		CommPortIdentifier portId;
		String commPortName = null;
		@SuppressWarnings("rawtypes")
		Enumeration en = CommPortIdentifier.getPortIdentifiers();
		while (en.hasMoreElements()) {
			portId = (CommPortIdentifier) en.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				commPortName = portId.getName();
		}
		return commPortName;
	}

	/**
	 * 打开串口
	 *
	 * @author lixiaogang
	 */
	public static void openCommPort() {
		CommPortIdentifier portId;
		try {
			// 生成CommPortIdentifier类的实例
			portId = CommPortIdentifier.getPortIdentifier(getCommPortName());
			// 打开串口COM3,设置超时时限为3000毫秒
			@SuppressWarnings("unused")
			SerialPort serialPort = (SerialPort) portId.open(
					"packinglinesmanage", 3000);// 有两个参数，第一个为应用程序名；第二个参数是在端口打开时阻塞等待的毫秒数
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置串口参数
	 *
	 * @author lixiaogang
	 * @param serialPort
	 */
	public static void setCommPortParm(SerialPort serialPort) {
		try {
			serialPort.setSerialPortParams(9600, // 波特率
					SerialPort.DATABITS_8,// 数据位数
					SerialPort.STOPBITS_1, // 停止位
					SerialPort.PARITY_NONE);// 奇偶位
		} catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 关闭串口
	 *
	 * @param serialPort
	 * @author lixiaogang
	 */
	public static void closeCommPort(SerialPort serialPort) {
		serialPort.close();
	}

	

}
