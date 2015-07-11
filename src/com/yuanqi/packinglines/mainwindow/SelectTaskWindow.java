package com.yuanqi.packinglines.mainwindow;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;






import com.yuanqi.packinglines.entity.material.Material;
import com.yuanqi.packinglines.service.material.MaterialService;
import com.yuanqi.packinglines.service.order.OrderService;
import com.yuanqi.packinglines.service.task.TaskService;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.wb.swt.SWTResourceManager;

public class SelectTaskWindow{

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Text text_order_no;
	public String taskID;//点击任务表行时，得到的任务ID
	public String taskNum;//点击任务表行时，得到的任务数量
	private String taskStatus;//点击任务表行时，得到的任务状态
	private String materialID;//点击任务表行时，得到该任务对应的materialID
	public String orderID;//点击订单表时，得到订单ID
	public Material material;//点击任务表时，得到该任务对应的material实例
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SelectTaskWindow window = new SelectTaskWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
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
		shell.setMaximized(true);
		shell.setText("\u4EFB\u52A1\u8D44\u6599\u7EF4\u62A4");
		OrderService os=new OrderService();
		TaskService ts=new TaskService();
		MaterialService ms=new MaterialService();
		Group group = new Group(shell, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group.setText("\u8BA2\u5355\u8D44\u6599");
		group.setBounds(10, 10, 538, 580);
		
		table = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 29, 518, 538);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(238);
		tblclmnNewColumn.setText("\u8BA2\u5355\u7F16\u53F7");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(264);
		tableColumn.setText("\u8BA2\u5355\u540D\u79F0");
		//订单表获取数据
		os.getDataOrder(table);

		//点击表的行获取订单ID
		table.addListener(SWT.MouseDown, new Listener() {  
            public void handleEvent(Event event) {  
                Point pt = new Point(event.x, event.y);  
                int index = table.getTopIndex();  
                while (index < table.getItemCount()) {  
                    final TableItem item = table.getItem(index);  
                    for (int i = 0; i < table.getColumnCount(); i++) {  
                        Rectangle rect = item.getBounds(i);  
                        if (rect.contains(pt)) { 
                        	table_1.removeAll();
                        	ts.getDataTaskByOrderId(table_1, item.getText(0));
                        	orderID=item.getText(0);
                        }  
                    }  
                      
                    index++;  
                }  
            }  
        });
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_1.setText("\u4EFB\u52A1\u8D44\u6599");
		group_1.setBounds(569, 10, 775, 580);
		
		table_1 = new Table(group_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(10, 28, 755, 542);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.NONE);
		tableColumn_1.setWidth(268);
		tableColumn_1.setText("\u4EFB\u52A1\u7F16\u53F7");
		
		TableColumn tableColumn_2 = new TableColumn(table_1, SWT.NONE);
		tableColumn_2.setWidth(250);
		tableColumn_2.setText("\u4EFB\u52A1\u63CF\u8FF0");
		
		TableColumn tableColumn_3 = new TableColumn(table_1, SWT.NONE);
		tableColumn_3.setWidth(116);
		tableColumn_3.setText("\u4EFB\u52A1\u6570\u91CF");
		
		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.NONE);
		tableColumn_4.setWidth(90);
		tableColumn_4.setText("\u4EFB\u52A1\u72B6\u6001");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_1.setWidth(0);
		tblclmnNewColumn_1.setText("materialID");
		
		//点击表的行获取任务ID和任务状态
				table_1.addListener(SWT.MouseDown, new Listener() {  
		            public void handleEvent(Event event) {  
		                Point pt = new Point(event.x, event.y);  
		                int index = table_1.getTopIndex();  
		                while (index < table_1.getItemCount()) {  
		                    final TableItem item = table_1.getItem(index);  
		                    for (int i = 0; i < table_1.getColumnCount(); i++) {  
		                        Rectangle rect = item.getBounds(i);  
		                        if (rect.contains(pt)) { 
		                        	taskID=item.getText(0);
		                        	taskNum=item.getText(2);
		                        	taskStatus=item.getText(3);
		                        	materialID=item.getText(4);
		                        }  
		                    }  
		                      
		                    index++;  
		                }  
		            }  
		        });
		
		
		
		Group group_2 = new Group(shell, SWT.NONE);
		group_2.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_2.setText("\u64CD\u4F5C");
		group_2.setBounds(569, 615, 775, 77);
		
		Button button = new Button(group_2, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(taskStatus.equals("未完成")){
					material=ms.getDataTaskByOrderId(materialID);
					shell.close();
				}else{
					MessageDialog.openInformation(shell, "提示","这个任务已经完成了");
		        }
				
			}
		});
		button.setBounds(79, 29, 80, 27);
		button.setText("\u786E\u5B9A");
		
		Button button_1 = new Button(group_2, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.close();
			}
		});
		button_1.setBounds(254, 29, 80, 27);
		button_1.setText("\u5173\u95ED");
		
		Group group_3 = new Group(shell, SWT.NONE);
		group_3.setFont(SWTResourceManager.getFont("微软雅黑", 10, SWT.BOLD));
		group_3.setText("\u67E5\u8BE2");
		group_3.setBounds(10, 615, 538, 77);
		
		Label label = new Label(group_3, SWT.NONE);
		label.setBounds(20, 37, 104, 17);
		label.setText("\u8BF7\u8F93\u5165\u8BA2\u5355\u7F16\u53F7\uFF1A");
		
		text_order_no = new Text(group_3, SWT.BORDER);
		text_order_no.setBounds(130, 34, 205, 23);
		//文本框的回车事件
		text_order_no.addKeyListener(new KeyListener() {  
		      public void keyPressed(KeyEvent e) {  
		      }  
		      @Override  
		      public void keyReleased(KeyEvent e) {  
		        if (e.keyCode == 13) {  
		        	table.removeAll();
					os.getDataOrderByOrderId(table, text_order_no.getText());
					text_order_no.setText("");
		        }  
		      }  
		    });
		
		Button btnNewButton = new Button(group_3, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(text_order_no.getText()!=""){
					table.removeAll();
					table_1.removeAll();
					os.getDataOrderByOrderId(table, text_order_no.getText());
					text_order_no.setText("");
				}else{
					table.removeAll();
					table_1.removeAll();
					os.getDataOrder(table);
				}
			}
		});
		btnNewButton.setBounds(395, 32, 80, 27);
		btnNewButton.setText("\u67E5\u8BE2");

	}
	
	
}
