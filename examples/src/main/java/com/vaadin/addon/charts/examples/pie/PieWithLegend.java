package com.vaadin.addon.charts.examples.pie;

import com.vaadin.addon.charts.AbstractChartExample;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Cursor;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.addon.charts.model.Tooltip;

import static com.vaadin.addon.charts.examples.events.EventHandling.createToastFunction;
import static com.vaadin.addon.charts.examples.events.EventHandling.toast;

public class PieWithLegend extends AbstractChartExample {

    @Override
    public void initDemo() {
        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Browser market shares at a specific website, 2010");

        Tooltip tooltip = new Tooltip();
        tooltip.setValueDecimals(1);
        tooltip.setPointFormat("{series.name}: <b>{point.percentage}%</b>");
        conf.setTooltip(tooltip);

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor(Cursor.POINTER);
        plotOptions.setShowInLegend(true);
        conf.setPlotOptions(plotOptions);

        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Firefox", 45.0));
        series.add(new DataSeriesItem("IE", 26.8));
        DataSeriesItem chrome = new DataSeriesItem("Chrome", 12.8);
        chrome.setSliced(true);
        chrome.setSelected(true);
        series.add(chrome);
        series.add(new DataSeriesItem("Safari", 8.5));
        series.add(new DataSeriesItem("Opera", 6.2));
        series.add(new DataSeriesItem("Others", 0.7));
        conf.setSeries(series);

        add(chart);

        chart.setSeriesVisibilityTogglingDisabled(true);

        createToastFunction();

        chart.addLegendItemClickListener(event -> toast("Legend item click"));
        chart.addChartClickListener(e -> System.out.println("Chart clicked"));
        chart.addSeriesHideListener(e -> System.out.println("Hiding series"));
        chart.addSeriesShowListener(e -> System.out.println("Showing series"));
        chart.addSeriesClickListener(e -> System.out.println("Clicking series"));
    }

}