package com.yuanqi.packinglines.mainwindow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

/**   
 * @Title: AboutInfoWindow.java 
 * @Package com.yuanqi.packinglines.mainwindow 
 * @Description: TODO¹ØÓÚµÄµ¯³ö´°Ìå
 * @author ÔªÆôÖÇÄÜ   ÀîÏþ¸Õ
 * @date 2015Äê7ÔÂ23ÈÕ ÉÏÎç9:39:34 
 * @version V1.0   
 */
public class AboutInfoWindow extends Dialog
{

  public AboutInfoWindow(Shell parent) {
    super(parent, SWT.NONE);
    // TODO Auto-generated constructor stub
  }
  
  protected Shell shlAboutApl;

  /**
   * Launch the application.
   * @param args
   */
  public static void main(String[] args)
  {
    try
    {
     
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Open the window.
   */
  public void open()
  {
    Display display = Display.getDefault();
    createContents();
    shlAboutApl.open();
    shlAboutApl.layout();
    while (!shlAboutApl.isDisposed())
    {
      if (!display.readAndDispatch())
      {
        display.sleep();
      }
    }
  }

  /**
   * Create contents of the window.
   */
  protected void createContents()
  {
    shlAboutApl = new Shell(getParent(), SWT.DIALOG_TRIM  | SWT.APPLICATION_MODAL);
    shlAboutApl.setSize(529, 270);
    shlAboutApl.setText("About APL");
    shlAboutApl.setLocation(Display.getCurrent().getClientArea().width / 2
                      - shlAboutApl.getShell().getSize().x / 2, Display.getCurrent()
                      .getClientArea().height / 2 - shlAboutApl.getSize().y / 2);
    
    Label lblNewLabel = new Label(shlAboutApl, SWT.NONE);
    lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 13, SWT.NORMAL));
    lblNewLabel.setBounds(37, 75, 462, 36);
    lblNewLabel.setText("APL-Automation Production Line Management System");
    
    Label lblNewLabel_1 = new Label(shlAboutApl, SWT.NONE);
    lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
    lblNewLabel_1.setBounds(37, 22, 222, 26);
    lblNewLabel_1.setText("\u81EA\u52A8\u5316\u751F\u4EA7\u7EBF\u7BA1\u7406\u7CFB\u7EDF");
    
    Label lblNewLabel_2 = new Label(shlAboutApl, SWT.NONE);
    lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.NORMAL));
    lblNewLabel_2.setBounds(37, 130, 88, 26);
    lblNewLabel_2.setText("\u8F6F\u4EF6\u7248\u672C\uFF1A");
    
    Label lblNewLabel_3 = new Label(shlAboutApl, SWT.NONE);
    lblNewLabel_3.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.NORMAL));
    lblNewLabel_3.setBounds(145, 130, 79, 17);
    lblNewLabel_3.setText("V1.0");
    
    Label label = new Label(shlAboutApl, SWT.NONE);
    label.setText("\u7248\u6743\u6240\u6709\uFF1A");
    label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.NORMAL));
    label.setBounds(37, 182, 88, 26);
    
    Label label_1 = new Label(shlAboutApl, SWT.NONE);
    label_1.setText("\u9752\u5C9B\u5143\u542F\u667A\u80FD\u673A\u5668\u4EBA\u79D1\u6280\u6709\u9650\u516C\u53F8");
    label_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.NORMAL));
    label_1.setBounds(145, 182, 246, 17);
  }
}
