package com.vaadin.addon.charts.examples.sparkline;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.vaadin.addon.charts.AbstractChartExample;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.Labels;
import com.vaadin.addon.charts.model.Legend;
import com.vaadin.addon.charts.model.Marker;
import com.vaadin.addon.charts.model.PlotOptionsLine;
import com.vaadin.addon.charts.model.Series;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.button.Button;
import com.vaadin.ui.grid.Grid;
import com.vaadin.ui.renderers.ComponentTemplateRenderer;

public class SparklineWithLargeDataset extends
        AbstractChartExample {

    @Override
    public void initDemo() {
        List<StockData> data = new LinkedList<>();
        for (int i = 0; i < 200; i++) {
            data.addAll(getStockData());
        }


        Grid<StockData> table = new Grid<>();
        table.setItems(data);
        table.addColumn(StockData::getMonth);
        table.addColumn(new ComponentTemplateRenderer<>(stockData -> {
//            return new Button("I'm a button");
            Chart chart = new Chart();
            DataSeries series = new DataSeries(stockData.getMonth());
            series.setData(stockData.getValues());
            chart.getConfiguration().addSeries(series);
            configureAsSparkline(chart);
            return chart;
        }));

//        Chart chart = new Chart();
//        DataSeries series = new DataSeries(data.get(0).getMonth());
//        series.setData(data.get(0).getValues());
//        chart.getConfiguration().addSeries(series);
//
//        configureAsSparkline(chart);
        add(table);
    }

    protected void configureAsSparkline(Chart chart) {
        chart.getConfiguration().setTitle("");
        chart.getConfiguration().getChart().setWidth(100);
        chart.getConfiguration().getChart().setHeight("50px");
        chart.getConfiguration().setLegend(new Legend(false));
        chart.getConfiguration().getChart().setBackgroundColor(
                new SolidColor(0, 0, 0, 0));
        chart.getConfiguration().getChart().setMargin(0);
        Series series = chart.getConfiguration().getSeries().get(0);

        PlotOptionsLine options = new PlotOptionsLine();
        options.setEnableMouseTracking(false);
        options.setMarker(new Marker(false));
        options.setShowInLegend(false);
        options.setAnimation(false);
        options.setShadow(false);

        series.setPlotOptions(options);

        configureXAxis(chart.getConfiguration().getxAxis());
        configureYAxis(chart.getConfiguration().getyAxis());
    }

    protected void configureXAxis(XAxis axis) {
        axis.setLineWidth(0);
        axis.setMinorTickLength(0);
        axis.setMinorTickWidth(0);

        axis.setMaxPadding(0.1);
        axis.setMinPadding(0.1);

        axis.setLabels(new Labels(false));
        axis.setLineColor(new SolidColor(0, 0, 0, 0));

        axis.setTitle("");
        axis.setStartOnTick(false);
        axis.setEndOnTick(false);
    }

    protected void configureYAxis(YAxis axis) {
        axis.setLineWidth(0);
        axis.setMinorTickLength(0);
        axis.setMinorTickWidth(0);

        axis.setMaxPadding(0.1);
        axis.setMinPadding(0.1);

        axis.setLabels(new Labels(false));
        axis.setLineColor(new SolidColor(0, 0, 0, 0));

        axis.setTitle("");
        axis.setStartOnTick(false);
        axis.setEndOnTick(false);
    }

    private List<StockData> getStockData() {
        return Arrays
                .asList(new StockData("Apr", 21.20, 21.96, 22.07, 23.01, 24.02,
                                22.89, 23.27, 24.13, 24.25, 24.61, 25.01, 24.85),
                        new StockData("May", 25.71, 25.85, 26.39, 26.67, 26.08,
                                26.44, 26.21, 26.88, 27.14, 26.61, 27.10,
                                26.80, 26.23, 26.56, 25.46, 25.29, 25.88,
                                26.63, 26.72, 26.67, 26.96), new StockData(
                                "Jun", 26.59, 26.48, 26.46, 27.06, 26.52,
                                25.94, 26.52, 25.83, 24.75, 24.62, 25.26,
                                25.92, 25.54, 25.84, 25.04, 24.74, 24.75,
                                25.34, 24.04, 24.30, 23.92), new StockData(
                                "July", 24.95, 24.03, 24.30, 25.02, 25.65,
                                24.89, 25.23, 24.65, 24.84, 24.23, 24.69,
                                24.54, 23.59, 23.76, 23.15, 23.75, 22.72,
                                23.16, 22.06, 22.44, 22.84, 22.71),
                        new StockData("Aug", 22.38, 21.89, 22.95, 23.46, 23.37,
                                24.22, 24.79, 25.25, 25.61, 25.62, 25.11,
                                25.06, 24.79, 25.12, 24.90, 25.26, 24.65,
                                24.81, 24.95, 24.82, 24.22), new StockData(
                                "Sep", 23.74, 23.85, 23.03, 22.88, 22.56,
                                21.67, 21.66, 21.81, 21.28, 20.05, 19.98,
                                18.26, 19.16, 20.13, 18.72, 18.12, 18.39,
                                18.85, 18.32, 15.04, 16.24), new StockData(
                                "Oct", 15.59, 14.30, 13.87, 14.02, 12.74,
                                12.83, 12.68, 13.80, 15.75, 14.87, 13.99,
                                14.56, 13.91, 14.06, 13.07, 13.84, 14.03,
                                13.77, 13.16, 14.27, 14.94, 15.86, 15.37),
                        new StockData("Nov", 15.28, 15.86, 14.76, 14.16, 14.03,
                                13.70, 13.54, 12.87, 13.78, 12.89, 12.59,
                                12.84, 12.33, 11.50, 11.80, 13.28, 12.97,
                                13.57, 13.24), new StockData("Dec", 12.70,
                                13.21, 13.70, 13.06, 13.43, 14.25, 14.29,
                                14.03, 13.57, 14.04, 13.54, 13.63, 12.74,
                                12.78, 12.86, 12.25, 12.34, 12.15, 12.26,
                                12.37, 12.33, 12.19));
    }

    public static class StockData {
        private final String month;
        private final Number[] values;

        public StockData(String month, Number... values) {
            this.month = month;
            this.values = values;
        }

        public String getMonth() {
            return month;
        }

        public Number[] getValues() {
            return values;
        }

        public Number getLatest() {
            return values[values.length - 1];
        }
    }
}