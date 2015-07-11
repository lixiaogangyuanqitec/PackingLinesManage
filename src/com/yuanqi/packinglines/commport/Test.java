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
	 * 得到串口名字
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
	 * 打开串口
	 * 
	 * @author lixiaogang
	 */
	public void openCommPort() {
		CommPortIdentifier portId;
		try {
			// 生成CommPortIdentifier类的实例
			portId = CommPortIdentifier.getPortIdentifier("COM3");
			// 打开串口COM3,设置超时时限为3000毫秒
			@SuppressWarnings("unused")
			SerialPort serialPort = (SerialPort) portId.open("testApp", 3000);
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
	public void setCommPortParm(SerialPort serialPort) {
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
	public void closeCommPort(SerialPort serialPort) {
		serialPort.close();
	}

	/**
	 * 向串口写数据
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
