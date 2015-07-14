package com.yuanqi.packinglines.mainwindow;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import com.yuanqi.packinglines.service.operator.OperatorService;
import com.yuanqi.packinglines.util.PropertiesUtil;
import com.yuanqi.packinglines.util.SecurityEncode;
public class LoginWindow {

	protected Shell shell;
	private Text text_username;
	private Text text_password;
	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LoginWindow window = new LoginWindow();
		window.open();
	}

	/**
	 * Open the window.
	 * @throws Exception 
	 */
	public void open(){
			OperatorService os = new OperatorService();
			Display display = Display.getDefault();
			createContents();
			shell.open();
			shell.layout();
			shell.setLocation(Display.getCurrent().getClientArea().width / 2
					- shell.getShell().getSize().x / 2, Display.getCurrent()
					.getClientArea().height / 2 - shell.getSize().y / 2);
			Label lblNewLabel = new Label(shell, SWT.NONE);
			lblNewLabel.setBounds(10, 10, 142, 142);
			lblNewLabel.setImage(new Image(Display.getDefault(),System.getProperty("user.dir")+"\\configuration\\login.jpg"));

			Label label = new Label(shell, SWT.NONE);
			label.setFont(SWTResourceManager.getFont("微软雅黑", 13, SWT.BOLD));
			label.setBounds(168, 10, 142, 24);
			label.setText("\u8BF7\u8F93\u5165\u767B\u5F55\u4FE1\u606F\uFF1A");

			Label lblNewLabel_1 = new Label(shell, SWT.NONE);
			lblNewLabel_1.setFont(SWTResourceManager
					.getFont("微软雅黑", 11, SWT.NORMAL));
			lblNewLabel_1.setBounds(178, 47, 69, 24);
			lblNewLabel_1.setText("\u7528\u6237\u4EE3\u7801\uFF1A");

			text_username = new Text(shell, SWT.BORDER);
			text_username.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_username.setBounds(279, 47, 155, 23);
			text_username.setFocus();
			text_username.setText(PropertiesUtil.readPropertiesFile("username",System.getProperty("user.dir")+"\\configuration\\login_info.properties"));
			Label lblNewLabel_2 = new Label(shell, SWT.NONE);
			lblNewLabel_2.setFont(SWTResourceManager
					.getFont("微软雅黑", 11, SWT.NORMAL));
			lblNewLabel_2.setBounds(178, 112, 75, 24);
			lblNewLabel_2.setText("\u7528\u6237\u53E3\u4EE4\uFF1A");
			
			text_password = new Text(shell, SWT.BORDER | SWT.PASSWORD);
			text_password.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			text_password.setBounds(279, 112, 155, 23);
			text_password.setText(SecurityEncode.decoderByDES(PropertiesUtil.readPropertiesFile("password",System.getProperty("user.dir")+"\\configuration\\login_info.properties"),""));
			
			// 文本框的回车事件
			text_password.addKeyListener(new KeyListener() {
				@Override
				public void keyReleased(KeyEvent e) {
					if (e.keyCode == 13) {
						if (os.loginValidate(text_username.getText(),
								SecurityEncode.encoderByDES(text_password.getText(),"")) > 0) {
							shell.dispose();
							MainWindow mw = new MainWindow();
							mw.open();
						} else {
							MessageDialog.openInformation(shell, "提示", "用户代码或用户密码错误");
						}
					}
				}

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});

			Button button_checkbox_username = new Button(shell, SWT.CHECK);
			button_checkbox_username.setBounds(168, 177, 98, 17);
			button_checkbox_username.setText("\u8BB0\u4F4F\u7528\u6237\u4EE3\u7801");
			if(!PropertiesUtil.readPropertiesFile("username",System.getProperty("user.dir")+"\\configuration\\login_info.properties").equals("")){
				button_checkbox_username.setSelection(true);
			}else{
				button_checkbox_username.setSelection(false);
			}
			

			Button button_checkbox_password = new Button(shell, SWT.CHECK);
			button_checkbox_password.setBounds(303, 177, 98, 17);
			button_checkbox_password.setText("\u8BB0\u4F4F\u7528\u6237\u53E3\u4EE4");
			if(!PropertiesUtil.readPropertiesFile("password",System.getProperty("user.dir")+"\\configuration\\login_info.properties").equals("")){
				button_checkbox_password.setSelection(true);
			}else{
				button_checkbox_password.setSelection(false);
			}
			
			Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
			label_1.setBounds(10, 207, 424, 13);
			Button btnNewButton = new Button(shell, SWT.NONE);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					if (os.loginValidate(text_username.getText(),
								SecurityEncode.encoderByDES(text_password.getText(),"")) > 0) {//验证成功
							if(button_checkbox_username.getSelection()&&button_checkbox_password.getSelection()){//两个全勾选了
								PropertiesUtil.writePropertiesFile("username",text_username.getText(),System.getProperty("user.dir")+"\\configuration\\login_info.properties");
								PropertiesUtil.writePropertiesFile("password",SecurityEncode.encoderByDES(text_password.getText(),""),System.getProperty("user.dir")+"\\configuration\\login_info.properties");
							}else if(button_checkbox_username.getSelection()&&!button_checkbox_password.getSelection()){//勾了用户代码没勾用户密码
								PropertiesUtil.writePropertiesFile("username",text_username.getText(),System.getProperty("user.dir")+"\\configuration\\login_info.properties");
								PropertiesUtil.writePropertiesFile("password","",System.getProperty("user.dir")+"\\configuration\\login_info.properties");
							}else if(!button_checkbox_username.getSelection()&&button_checkbox_password.getSelection()){//勾了用户密码没勾用户代码
								PropertiesUtil.writePropertiesFile("password",SecurityEncode.encoderByDES(text_password.getText(),""),System.getProperty("user.dir")+"\\configuration\\login_info.properties");
								PropertiesUtil.writePropertiesFile("username","",System.getProperty("user.dir")+"\\configuration\\login_info.properties");
							}else if(!button_checkbox_username.getSelection()&&!button_checkbox_password.getSelection()){//两个都没勾
								PropertiesUtil.writePropertiesFile("password","",System.getProperty("user.dir")+"\\configuration\\login_info.properties");
								PropertiesUtil.writePropertiesFile("username","",System.getProperty("user.dir")+"\\configuration\\login_info.properties");
							}
							shell.dispose();
							MainWindow mw = new MainWindow();
							mw.open();
						} else {//验证失败
							MessageDialog.openInformation(shell, "提示", "用户代码或用户密码错误");
						}
					
				}
			});
			btnNewButton.setBounds(39, 226, 80, 27);
			btnNewButton.setText("\u786E\u5B9A");

			Button btnNewButton_1 = new Button(shell, SWT.NONE);
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					shell.close();
				}
			});
			btnNewButton_1.setBounds(178, 226, 80, 27);
			btnNewButton_1.setText("\u53D6\u6D88");
			
			Button btnNewButton_2 = new Button(shell, SWT.NONE);
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					DatabaseConfigurationWindow dcw=new DatabaseConfigurationWindow(shell);
					dcw.open();
				}
			});
			btnNewButton_2.setBounds(318, 226, 80, 27);
			btnNewButton_2.setText("\u53C2\u6570\u8BBE\u7F6E");
			
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.CLOSE);
		shell.setSize(450, 298);
		shell.setText("\u5305\u88C5\u6D41\u6C34\u7EBF\u7BA1\u7406\u7CFB\u7EDF");
		
	}
}
