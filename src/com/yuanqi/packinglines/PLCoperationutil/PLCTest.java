package com.yuanqi.packinglines.PLCoperationutil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;



public class PLCTest extends Thread{
	private Table table;
	
	public PLCTest(Table table){
		this.table=table;
		
	}
	public void run(){
		for(int i=0;i<100;i++){
			//然后在表格中添加一行   
            try {Thread.sleep(1000); } catch (InterruptedException e) {e.printStackTrace();}     
            Display.getDefault().asyncExec(new Runnable() {  
                public void run() {  
                	TableItem[] items = table.getItems();
         	        TableItem item1 = new TableItem(table, SWT.NONE);
         			item1.setText(new String[] {String.valueOf(items.length+1), "a", "b", "c", "d" });
         			if(items.length==12){
                    	table.removeAll();
                    }
                }  
            });  
            
		}
		
	}
	

	
	
}
