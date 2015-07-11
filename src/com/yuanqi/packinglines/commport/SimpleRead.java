package com.yuanqi.packinglines.commport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;
import javax.comm.UnsupportedCommOperationException;

/***
 * ������
 * 
 * @author lixiaogang
 * @version 1.0
 */
public class SimpleRead implements Runnable, SerialPortEventListener {
	static CommPortIdentifier portId;
	@SuppressWarnings("rawtypes")
	static Enumeration portList;// ö����

	InputStream inputStream;
	SerialPort serialPort;
	Thread readThread;

	public static void main(String[] args) {
		/*
		 * ����������getPortIdentifiers�������һ��ö�ٶ���
		 * ��
		 * �ö����ְ�����ϵͳ�й���ÿ���˿ڵ�CommPortIdentifier����
		 * ��
		 * ע������Ķ˿ڲ�������ָ���ڣ�Ҳ��������
		 * ��������������Դ�������
		 * getPortIdentifiers
		 * (CommPort)
		 * ������Ѿ���Ӧ�ó���򿪵Ķ˿����Ӧ��CommPortIdentifier����
		 * ��
		 * getPortIdentifier
		 * (String
		 * portName)��ȡָ���˿���
		 * �����硰COM1����
		 * ��CommPortIdentifier����
		 * ��
		 */
		portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL)/* getPortType�������ض˿����� */{
				 if (portId.getName().equals(CommPortUtil.getCommPortName()))/* ��Windows�µĵ�һ������*/ {
//				if (portId.getName().equals("/dev/term/a"))/*
//															 * ��Unix-likeϵͳ�µĵ�һ������
//															 */{
					@SuppressWarnings("unused")
					SimpleRead reader = new SimpleRead();
				}
			}
		}
	}

	public SimpleRead() {
		try {
			/*
			 * open������ͨѶ�˿�
			 * ��
			 * ���һ��CommPort����
			 * ��
			 * ��ʹ�����ռ�˿�
			 * ��
			 * ����˿���������Ӧ�ó���ռ��
			 * ����ʹ��
			 * CommPortOwnershipListener�¼�����
			 * ��
			 * ����һ��PORT_OWNERSHIP_REQUESTED�¼�
			 * ��
			 * ÿ���˿ڶ�����һ��
			 * InputStream
			 * ��һ��OutputStream
			 * ��
			 * ����˿�����open�����򿪵�
			 * ��
			 * ��ô�κε�getInputStream����������ͬ������������
			 * ��
			 * ������close
			 * ������
			 * ������������
			 * ��
			 * ��һ��ΪӦ�ó�����
			 * ��
			 * �ڶ����������ڶ˿ڴ�ʱ�����ȴ��ĺ�����
			 * ��
			 */
			serialPort = (SerialPort) portId.open("packinglinesmanage", 2000);
		} catch (PortInUseException e) {
		}
		try {
			inputStream = serialPort.getInputStream();/* ��ȡ�˿ڵ����������� */
		} catch (IOException e) {
		}
		try {
			serialPort.addEventListener(this);/* ע��һ��SerialPortEventListener�¼������������¼� */
		} catch (TooManyListenersException e) {
		}

		serialPort.notifyOnDataAvailable(true);/* ���ݿ��� */

		try {
			serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);/*
																	 * ���ô��ڳ�ʼ��������
																	 * �����ǲ�����
																	 * ������λ
																	 * ��ֹͣλ��У��
																	 */
		} catch (UnsupportedCommOperationException e) {
		}

		readThread = new Thread(this);
		readThread.start();
	}

	public void run() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
		}
	}

	// �����¼�
	public void serialEvent(SerialPortEvent event) {

		switch (event.getEventType()) {
		case SerialPortEvent.BI:/* Break interrupt,ͨѶ�ж� */
		case SerialPortEvent.OE:/* Overrun error����λ���� */
		case SerialPortEvent.FE:/* Framing error����֡���� */
		case SerialPortEvent.PE:/* Parity error��У����� */
		case SerialPortEvent.CD:/* Carrier detect���ز���� */
		case SerialPortEvent.CTS:/* Clear to send��������� */
		case SerialPortEvent.DSR:/* Data set ready�������豸���� */
		case SerialPortEvent.RI:/* Ring indicator������ָʾ */
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:/*
												 * Output buffer is
												 * empty��������������
												 */
			break;

		case SerialPortEvent.DATA_AVAILABLE:/*
											 * Data available at the serial
											 * port���˿��п������ݡ������������飬������ն�
											 */
			byte[] readBuffer = new byte[20];

			try {
				while (inputStream.available() > 0) {
					@SuppressWarnings("unused")
					int numBytes = inputStream.read(readBuffer);
				}
				System.out.print("�Ӵ��ڶ��������ݣ�"+new String(readBuffer));
			} catch (IOException e) {
			}
			break;
		}
	}
}
