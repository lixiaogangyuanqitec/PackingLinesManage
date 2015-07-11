package com.yuanqi.packinglines.mainwindow;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;

import com.yuanqi.packinglines.util.PropertiesUtil;

public class ProgressBarWindow {
	private Text text;
	private ProgressBar progressBar;
	private int max;
	private int i;
	private int Value;
	private int value;
	protected Shell shell;
	public boolean flag;
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ProgressBarWindow p=new ProgressBarWindow();
		p.ProgessBarExample1("", "", "", "", "");
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}

	public void ProgessBarExample1(String ip, String port, String database,
			String username, String password){
		final Display display = Display.getDefault();
		final Shell shell = new Shell(SWT.CLOSE);
		shell.setText("");
		shell.setSize(315, 127);
		shell.setLocation(350, 180);
		shell.setLayout(new FormLayout());

		progressBar = new ProgressBar(shell, SWT.HORIZONTAL);

		FormData data = new FormData(237, 20);
		data.left = new FormAttachment(0, 35);
		data.bottom = new FormAttachment(100, -30);
		progressBar.setLayoutData(data);
		progressBar.setMaximum(100);
		max = progressBar.getMaximum();
		text = new Text(shell, SWT.BORDER);
		data.right = new FormAttachment(100, -69);
		text.setEnabled(false);

		final FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(progressBar, 0, SWT.TOP);
		fd_text.left = new FormAttachment(progressBar, 11);
		fd_text.right = new FormAttachment(100, -25);
		text.setLayoutData(fd_text);

		Label label = new Label(shell, SWT.NONE);
		data.top = new FormAttachment(label, 25);
		FormData fd_label = new FormData();
		fd_label.bottom = new FormAttachment(100, -72);
		fd_label.right = new FormAttachment(100, -67);
		fd_label.left = new FormAttachment(0, 25);
		label.setLayoutData(fd_label);
		label.setText("\u9A8C\u8BC1\u4E2D\uFF0C\u8BF7\u7A0D\u540E\u3002\u3002\u3002\u3002\u3002");

		new Thread() {
			public void run() {
				new Thread() {
					public void run() {
						PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
						Logger logger = Logger.getLogger(ProgressBarWindow.class);
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							@SuppressWarnings("unused")
							Connection conn = DriverManager
									.getConnection(
											"jdbc:sqlserver://"+ip+":"+port+";DatabaseName="+database+"",
											""+username+"", ""+password+"");
							flag=true;
							PropertiesUtil
									.writePropertiesFile(
											"jdbc.ip",
											ip,
											System.getProperty("user.dir")
													+ "\\configuration\\database_configuration.properties");
							PropertiesUtil
									.writePropertiesFile(
											"jdbc.port",
											port,
											System.getProperty("user.dir")
													+ "\\configuration\\database_configuration.properties");
							PropertiesUtil
									.writePropertiesFile(
											"jdbc.databasename",
											database,
											System.getProperty("user.dir")
													+ "\\configuration\\database_configuration.properties");
							PropertiesUtil
									.writePropertiesFile(
											"jdbc.username",
											username,
											System.getProperty("user.dir")
													+ "\\configuration\\database_configuration.properties");
							PropertiesUtil
									.writePropertiesFile(
											"jdbc.password",
											password,
											System.getProperty("user.dir")
													+ "\\configuration\\database_configuration.properties");
						} catch (ClassNotFoundException e) {
							flag=false;
							e.printStackTrace();
							logger.info(e.getMessage());
						} catch (SQLException e) {
							flag=false;
							e.printStackTrace();
							logger.info(e.getMessage());
						}
					}
				}.start();
				for (i = 1; i < max; i++) {
					try {
						Thread.sleep(150);
					} catch (Throwable e) {

					}
					display.asyncExec(new Runnable() {
						public void run() {
							progressBar.setSelection(i);
							Value = progressBar.getMaximum();
							value = progressBar.getSelection();
							text.setText(value + "%");
							if (Value == value) {
								final Display dis = Display.getDefault();
								@SuppressWarnings("unused")
								Shell sh = new Shell(dis);
								if(flag==false){
									MessageDialog.openInformation(shell, "提示", "数据库参数有误，请核对");
								}else{
									MessageDialog.openInformation(shell, "提示", "数据库参数配置正确，将重启软件");
									
									try {
										Runtime.getRuntime().exec(System.getProperty("user.dir")+"//APL.exe");//此处的exe文件名必须和打包生成的exe文件名一致
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.exit(Value);
								}
								shell.dispose();
								return;
							}
						}
					});
				}
			}
		}.start();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
