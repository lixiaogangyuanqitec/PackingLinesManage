package com.yuanqi.packinglines.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IBarSeries;
import org.swtchart.ISeries.SeriesType;

/**
 * An example for chart with stack series.
 */
public class StackSeriesExample {

    private static final double[] ySeries1 = { 100, 2.4};
    private static final double[] ySeries2 = { 30, 2.1};

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Stack Series");
        shell.setSize(500, 400);
        shell.setLayout(new FillLayout());

        createChart(shell);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    /**
     * create the chart.
     * 
     * @param parent
     *            The parent composite
     * @return The created chart
     */
    static public Chart createChart(Composite parent) {

        // create a chart
        Chart chart = new Chart(parent, SWT.NONE);

        // set titles
        chart.getTitle().setText("汇总");
        chart.getAxisSet().getXAxis(0).getTitle().setText("工序");
        chart.getAxisSet().getYAxis(0).getTitle().setText("数量");

        // set category
        chart.getAxisSet().getXAxis(0).enableCategory(true);
        chart.getAxisSet().getXAxis(0).setCategorySeries(
                new String[] { "红外载波测试", "参数设置"});

        // create bar series
        IBarSeries barSeries1 = (IBarSeries) chart.getSeriesSet().createSeries(
                SeriesType.BAR, "完成");
        barSeries1.setYSeries(ySeries1);
        barSeries1.setBarColor(Display.getDefault().getSystemColor(
                SWT.COLOR_GREEN));

        IBarSeries barSeries2 = (IBarSeries) chart.getSeriesSet().createSeries(
                SeriesType.BAR, "未完成");
        barSeries2.setYSeries(ySeries2);

        // enable stack series
        barSeries1.enableStack(true);
        barSeries2.enableStack(true);

        // adjust the axis range
        chart.getAxisSet().adjustRange();

        return chart;
    }
}