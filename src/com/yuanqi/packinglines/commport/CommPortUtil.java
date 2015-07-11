package com.yuanqi.packinglines.commport;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

/***
 * ���ڲ���������
 * 
 * @author lixiaogang
 *
 */
public class CommPortUtil {

	/***
	 * �õ���������
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
	 * �򿪴���
	 *
	 * @author lixiaogang
	 */
	public static void openCommPort() {
		CommPortIdentifier portId;
		try {
			// ����CommPortIdentifier���ʵ��
			portId = CommPortIdentifier.getPortIdentifier(getCommPortName());
			// �򿪴���COM3,���ó�ʱʱ��Ϊ3000����
			@SuppressWarnings("unused")
			SerialPort serialPort = (SerialPort) portId.open(
					"packinglinesmanage", 3000);// ��������������һ��ΪӦ�ó��������ڶ����������ڶ˿ڴ�ʱ�����ȴ��ĺ�����
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ô��ڲ���
	 *
	 * @author lixiaogang
	 * @param serialPort
	 */
	public static void setCommPortParm(SerialPort serialPort) {
		try {
			serialPort.setSerialPortParams(9600, // ������
					SerialPort.DATABITS_8,// ����λ��
					SerialPort.STOPBITS_1, // ֹͣλ
					SerialPort.PARITY_NONE);// ��żλ
		} catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �رմ���
	 *
	 * @param serialPort
	 * @author lixiaogang
	 */
	public static void closeCommPort(SerialPort serialPort) {
		serialPort.close();
	}

	

}
