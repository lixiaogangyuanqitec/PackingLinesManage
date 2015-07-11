package com.yuanqi.packinglines.commport;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.openCommPort();
	}

	/***
	 * �õ���������
	 */
	public void getCommPortName() {
		CommPortIdentifier portId;
		@SuppressWarnings("rawtypes")
		Enumeration en = CommPortIdentifier.getPortIdentifiers();
		while (en.hasMoreElements()) {
			portId = (CommPortIdentifier) en.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				System.out.println(portId.getName());
		}
	}

	/**
	 * �򿪴���
	 * 
	 * @author lixiaogang
	 */
	public void openCommPort() {
		CommPortIdentifier portId;
		try {
			// ����CommPortIdentifier���ʵ��
			portId = CommPortIdentifier.getPortIdentifier("COM3");
			// �򿪴���COM3,���ó�ʱʱ��Ϊ3000����
			@SuppressWarnings("unused")
			SerialPort serialPort = (SerialPort) portId.open("testApp", 3000);
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
	public void setCommPortParm(SerialPort serialPort) {
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
	public void closeCommPort(SerialPort serialPort) {
		serialPort.close();
	}

	/**
	 * �򴮿�д����
	 * 
	 * @author lixiaogang
	 * @param serialPort
	 */
	public void writeToCommPort(SerialPort serialPort) {
		OutputStream outputStream;
		byte[] bt = new byte[] { (byte) 0x55, (byte) 0xAA, (byte) 0xF1 };
		try {
			outputStream = serialPort.getOutputStream();
			outputStream.write(bt);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
