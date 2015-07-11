package com.yuanqi.packinglines.mainwindow;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yuanqi.packinglines.PLCoperationutil.PLCTest;
import com.yuanqi.packinglines.service.line.LineService;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;

public class MainWindow {

	protected Shell shell;
	private Text text_task_no;
	private Table table;
	private Text text_products_no;
	private Text text_specifications;
	private Text text_voltage;
	private Text text_current;
	private Text text_task_num;
	private Text text_products_description;
	private Table table_1;
	private Text text_order_info;
	private Text text_task_type;
	private Text text_screw_num;
	private Text text_seal_num;
	private Text text_task_complete_num;
	private Button button;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = null;
		try {
			PropertyConfigurator.configure(ClassLoader
					.getSystemResource("file/log4j.properties"));
			logger = Logger.getLogger(MainWindow.class);
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
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
		shell = new Shell();
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				boolean bb = MessageDialog.openQuestion(shell, "提示", "确定退出吗？");
				if (bb) {
					e.doit = true;
				} else {
					e.doit = false;
				}
			}
		});
		shell.setMaximized(true);
		shell.setText("\u5305\u88C5\u6D41\u6C34\u7EBF\u7BA1\u7406\u7CFB\u7EDF");
		Group group = new Group(shell, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group.setText("\u57FA\u672C\u4FE1\u606F");
		group.setBounds(10, 10, 303, 289);

		Label label = new Label(group, SWT.NONE);
		label.setBounds(10, 35, 61, 17);
		label.setText("\u8BA2\u5355\u4FE1\u606F\uFF1A");

		Label label_1 = new Label(group, SWT.NONE);
		label_1.setText("\u4EFB\u52A1\u7C7B\u522B\uFF1A");
		label_1.setBounds(10, 70, 61, 17);

		Label label_2 = new Label(group, SWT.NONE);
		label_2.setText("\u4EFB\u52A1\u7F16\u53F7\uFF1A");
		label_2.setBounds(10, 104, 61, 17);

		text_task_no = new Text(group, SWT.BORDER);
		text_task_no.setBounds(77, 101, 197, 23);
		text_task_no.setEditable(false);

		Label label_3 = new Label(group, SWT.NONE);
		label_3.setText("\u7EBF\u4F53\u7F16\u53F7\uFF1A");
		label_3.setBounds(10, 138, 61, 17);

		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(10, 171, 61, 17);
		lblNewLabel.setText("\u87BA\u4E1D\u4E2A\u6570\uFF1A");

		Label label_4 = new Label(group, SWT.NONE);
		label_4.setBounds(10, 208, 61, 17);
		label_4.setText("\u94C5\u5C01\u4E2A\u6570\uFF1A");

		text_order_info = new Text(group, SWT.BORDER);
		text_order_info.setBounds(77, 32, 197, 23);
		text_order_info.setEditable(false);

		text_task_type = new Text(group, SWT.BORDER);
		text_task_type.setBounds(77, 67, 197, 23);
		text_task_type.setEditable(false);
		text_task_type.setText("包装任务");

		text_screw_num = new Text(group, SWT.BORDER);
		text_screw_num.setBounds(77, 168, 197, 23);
		text_screw_num.setEditable(false);

		text_seal_num = new Text(group, SWT.BORDER);
		text_seal_num.setBounds(77, 205, 197, 23);
		text_seal_num.setEditable(false);

		Button button_open_order_info = new Button(group, SWT.NONE);
		button_open_order_info.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				SelectTaskWindow window = new SelectTaskWindow();
				window.open();
				if (window.taskID != null) {
					text_task_no.setText(window.taskID);
				}
				if (window.taskNum != null) {
					text_task_num.setText(window.taskNum);
				}
				if (window.orderID != null) {
					text_order_info.setText(window.orderID);
				}
				if (window.material != null) {
					text_products_no.setText(window.material.getMaterialId());
					text_specifications.setText(window.material.getStandards());
					text_voltage.setText(window.material.getVolt());
					text_current.setText(window.material.getCurr());
					text_products_description.setText(window.material
							.getmName());
				}
				button.setEnabled(true);
			}
		});
		button_open_order_info.setBounds(194, 252, 80, 27);
		button_open_order_info.setText("\u9009\u62E9\u4EFB\u52A1");

		Combo combo_thread_no = new Combo(group, SWT.NONE | SWT.READ_ONLY);
		combo_thread_no.setBounds(77, 135, 197, 25);
		LineService ls = new LineService();
		combo_thread_no.setItems(ls.getDataLine());

		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		group_1.setText("\u4EA7\u54C1\u4FE1\u606F");
		group_1.setBounds(10, 305, 303, 319);

		Label label_6 = new Label(group_1, SWT.NONE);
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_6.setBounds(10, 35, 61, 17);
		label_6.setText("\u4EA7\u54C1\u7F16\u53F7\uFF1A");

		text_products_no = new Text(group_1, SWT.BORDER);
		text_products_no.setBounds(77, 32, 202, 23);
		text_products_no.setEditable(false);

		Label label_7 = new Label(group_1, SWT.NONE);
		label_7.setBounds(10, 77, 61, 17);
		label_7.setText("\u89C4\u683C\u578B\u53F7\uFF1A");

		text_specifications = new Text(group_1, SWT.BORDER);
		text_specifications.setBounds(77, 74, 202, 23);
		text_specifications.setEditable(false);

		Label label_8 = new Label(group_1, SWT.NONE);
		label_8.setBounds(10, 118, 61, 17);
		label_8.setText("\u7535\u538B\u89C4\u683C\uFF1A");

		text_voltage = new Text(group_1, SWT.BORDER);
		text_voltage.setBounds(77, 115, 202, 23);
		text_voltage.setEditable(false);

		Label label_9 = new Label(group_1, SWT.NONE);
		label_9.setBounds(10, 158, 61, 17);
		label_9.setText("\u7535\u6D41\u89C4\u683C\uFF1A");

		text_current = new Text(group_1, SWT.BORDER);
		text_current.setBounds(77, 155, 202, 23);
		text_current.setEditable(false);

		Label label_10 = new Label(group_1, SWT.NONE);
		label_10.setBounds(10, 201, 61, 17);
		label_10.setText("\u4EFB\u52A1\u6570\u91CF\uFF1A");

		text_task_num = new Text(group_1, SWT.BORDER);
		text_task_num.setBounds(77, 198, 202, 23);
		text_task_num.setEditable(false);

		Label label_11 = new Label(group_1, SWT.NONE);
		label_11.setBounds(10, 272, 61, 17);
		label_11.setText("\u4EA7\u54C1\u63CF\u8FF0\uFF1A");

		text_products_description = new Text(group_1, SWT.BORDER);
		text_products_description.setBounds(77, 269, 202, 40);
		text_products_description.setEditable(false);

		Label label_16 = new Label(group_1, SWT.NONE);
		label_16.setBounds(10, 235, 80, 17);
		label_16.setText("\u5B8C\u6210\u6570\u91CF\uFF1A");

		text_task_complete_num = new Text(group_1, SWT.BORDER);
		text_task_complete_num.setBounds(77, 232, 202, 23);
		text_task_complete_num.setEditable(false);

		Group group_2 = new Group(shell, SWT.NONE);
		group_2.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_2.setText("\u5408\u8BA1");
		group_2.setBounds(10, 630, 303, 65);

		Label label_5 = new Label(group_2, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_5.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		label_5.setBounds(24, 26, 110, 19);
		label_5.setText("\u5F53\u65E5\u5B8C\u6210\u6570\u91CF\uFF1A");

		Label lblNewLabel_1 = new Label(group_2, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_1.setBounds(189, 30, 61, 17);
		lblNewLabel_1.setText("0");

		Group group_3 = new Group(shell, SWT.NONE);
		group_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_3.setText("\u5DE5\u827A\u6D41\u7A0B\u660E\u7EC6\u8868");
		group_3.setBounds(340, 10, 990, 318);

		table = new Table(group_3, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 21, 970, 287);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tc0 = new TableColumn(table, SWT.CENTER);
		tc0.setText("\u5E8F\u53F7");// 设置列名
		tc0.setWidth(50);

		TableColumn tc1 = new TableColumn(table, SWT.CENTER);
		tc1.setText("\u5C40\u7F16");// 设置列名
		tc1.setWidth(326);

		TableColumn tc2 = new TableColumn(table, SWT.CENTER);
		tc2.setText("\u5DE5\u827A\u540D\u79F0");// 设置列名
		tc2.setWidth(320);

		TableColumn tc3 = new TableColumn(table, SWT.CENTER);
		tc3.setText("\u6570\u636E\u63A5\u6536\u65F6\u95F4");// 设置列名
		tc3.setWidth(265);

		Group group_4 = new Group(shell, SWT.NONE);
		group_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		group_4.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_4.setText("\u5305\u88C5\u8FDB\u5EA6\u6C47\u603B");
		group_4.setBounds(340, 405, 991, 219);

		table_1 = new Table(group_4, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(10, 29, 971, 155);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_1.setWidth(66);
		tblclmnNewColumn_1.setText("\u5E8F\u53F7");

		TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn.setWidth(216);
		tblclmnNewColumn.setText("\u5DE5\u5E8F\u540D\u79F0");

		TableColumn tableColumn = new TableColumn(table_1, SWT.NONE);
		tableColumn.setWidth(141);
		tableColumn.setText("\u5B8C\u6210\u6570\u91CF");

		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.NONE);
		tableColumn_1.setWidth(155);
		tableColumn_1.setText("\u4E0D\u826F");

		TableColumn tableColumn_2 = new TableColumn(table_1, SWT.NONE);
		tableColumn_2.setWidth(186);
		tableColumn_2.setText("\u4E0D\u826F\u7387");

		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.NONE);
		tableColumn_3.setWidth(200);
		tableColumn_3.setText("\u8BBE\u5907\u72B6\u6001");

		TableItem item1_1 = new TableItem(table_1, SWT.NONE);
		item1_1.setText(new String[] { "1", "红外载波测试", "10", "4", "40%", "良好" });
		TableItem item1_2 = new TableItem(table_1, SWT.NONE);
		item1_2.setText(new String[] { "2", "参数设置", "10", "4", "40%", "良好" });
		TableItem item1_3 = new TableItem(table_1, SWT.NONE);
		item1_3.setText(new String[] { "3", "打螺丝", "10", "4", "40%", "良好" });
		TableItem item1_4 = new TableItem(table_1, SWT.NONE);
		item1_4.setText(new String[] { "4", "按铅封帽", "10", "4", "40%", "良好" });
		TableItem item1_5 = new TableItem(table_1, SWT.NONE);
		item1_5.setText(new String[] { "5", "贴合格证", "10", "4", "40%", "良好" });
		TableItem item1_6 = new TableItem(table_1, SWT.NONE);
		item1_6.setText(new String[] { "6", "扫码装箱", "10", "4", "40%", "良好" });

		Group group_5 = new Group(shell, SWT.NONE);
		group_5.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_5.setText("\u88C5\u7BB1\u4FE1\u606F");
		group_5.setBounds(338, 334, 992, 55);

		Label label_13 = new Label(group_5, SWT.NONE);
		label_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		label_13.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		label_13.setBounds(31, 25, 86, 20);
		label_13.setText("\u6B63\u5728\u88C5\u7B2C\uFF1A");

		Label label_14 = new Label(group_5, SWT.NONE);
		label_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		label_14.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		label_14.setBounds(134, 25, 61, 17);
		label_14.setText("10");

		Label label_15 = new Label(group_5, SWT.NONE);
		label_15.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		label_15.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
		label_15.setBounds(201, 25, 61, 20);
		label_15.setText("\u7BB1");

		Group group_6 = new Group(shell, SWT.NONE);
		group_6.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_6.setText("\u64CD\u4F5C\u6309\u94AE");
		group_6.setBounds(340, 630, 990, 65);

		button = new Button(group_6, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (!combo_thread_no.getText().equals("")) {
					MessageDialog.openInformation(shell, "提示", "下发成功");
				} else {
					MessageDialog.openInformation(shell, "提示", "请选择线体编号");
				}
			}
		});

		button.setBounds(27, 26, 80, 27);
		button.setText("\u4E0B\u53D1");
		button.setEnabled(false);

		Button button_1 = new Button(group_6, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				PLCTest p = new PLCTest(table);
				p.start();
			}
		});
		button_1.setBounds(154, 26, 80, 27);
		button_1.setText("\u5F00\u59CB");

		Button button_2 = new Button(group_6, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				
			}
		});
		button_2.setBounds(279, 26, 80, 27);
		button_2.setText("\u505C\u6B62");

	}
}
