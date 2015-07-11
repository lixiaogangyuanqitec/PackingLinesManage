package com.yuanqi.packinglines.mainwindow;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

import com.yuanqi.packinglines.util.PropertiesUtil;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class DatabaseConfigurationWindow extends Dialog{

	public DatabaseConfigurationWindow(Shell parent) {
		super(parent, SWT.NONE);
		// TODO Auto-generated constructor stub
	}

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
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
	 */
	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM  | SWT.APPLICATION_MODAL);
		shell.setSize(450, 342);
		shell.setText("\u8BBE\u7F6E\u6570\u636E\u5E93\u8FDE\u63A5\u53C2\u6570");
		shell.setLocation(Display.getCurrent().getClientArea().width / 3
				- shell.getShell().getSize().x / 3, Display.getCurrent()
				.getClientArea().height / 3 - shell.getSize().y / 3);
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		label.setBounds(76, 28, 73, 17);
		label.setText("\u670D  \u52A1  \u5668\uFF1A");
		text = new Text(shell, SWT.BORDER);
		text.setBounds(166, 25, 178, 23);
		text.setText(PropertiesUtil.readPropertiesFile("jdbc.ip",System.getProperty("user.dir")+"\\configuration\\database_configuration.properties"));
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		label_1.setBounds(76, 69, 73, 17);
		label_1.setText("\u7AEF       \u53E3\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(166, 68, 178, 23);
		text_1.setText(PropertiesUtil.readPropertiesFile("jdbc.port",System.getProperty("user.dir")+"\\configuration\\database_configuration.properties"));
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		label_2.setBounds(76, 112, 73, 17);
		label_2.setText("\u6570  \u636E  \u5E93\uFF1A");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(166, 111, 178, 23);
		text_2.setText(PropertiesUtil.readPropertiesFile("jdbc.databasename",System.getProperty("user.dir")+"\\configuration\\database_configuration.properties"));
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		label_3.setBounds(76, 159, 73, 17);
		label_3.setText("\u7528  \u6237  \u540D\uFF1A");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(166, 158, 178, 23);
		text_3.setText(PropertiesUtil.readPropertiesFile("jdbc.username",System.getProperty("user.dir")+"\\configuration\\database_configuration.properties"));
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 10, SWT.NORMAL));
		label_4.setBounds(76, 202, 73, 17);
		label_4.setText("\u5BC6        \u7801\uFF1A");
		
		text_4 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_4.setBounds(166, 202, 178, 23);
		text_4.setText(PropertiesUtil.readPropertiesFile("jdbc.password",System.getProperty("user.dir")+"\\configuration\\database_configuration.properties"));
		
		Label label_5 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(23, 249, 394, 2);
		
		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!text.getText().equals("")&&!text_1.getText().equals("")&&!text_2.getText().equals("")&&!text_3.getText().equals("")&&!text_4.getText().equals("")){
					ProgressBarWindow p=new ProgressBarWindow();
					p.ProgessBarExample1(text.getText(),text_1.getText(),text_2.getText(),text_3.getText(),text_4.getText());
				}else{
					MessageDialog.openInformation(shell, "ÌáÊ¾", "Çë½«Êý¾Ý¿â²ÎÊýÌîÐ´ÍêÕû");
				}
			}
		});
		button.setBounds(76, 268, 80, 27);
		button.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(264, 268, 80, 27);
		button_1.setText("\u53D6\u6D88");
	}
}
