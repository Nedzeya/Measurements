package com.klachkova.spring.SensorImitation.util;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChartMaker {

    private final Map map;
    private final String title;


    public ChartMaker(Map map, String title) {
        this.map = map;
        this.title = title;
    }

    public void showChart() {
        JFrame jFrame = new SwingWrapper<>(makeTemperatureChart()).displayChart();
        jFrame.toFront();
        jFrame.setAlwaysOnTop(true);
    }


    private CategoryChart makeTemperatureChart() {


        CategoryChart chart = new CategoryChartBuilder()
                .width(1500).height(600)
                .title(this.title)
                .xAxisTitle("Time")
                .yAxisTitle("degrees Celsius")
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setAvailableSpaceFill(0.99);
        chart.getStyler().setXAxisTickMarkSpacingHint(100);
        chart.getStyler().setXAxisLabelRotation(90);

        //Temperature
        List xData = Arrays.asList(map.keySet().toArray());
        //Time
        List yData = new ArrayList<>();
        yData.addAll(map.values());

        chart.addSeries(this.title, xData, yData);

        return chart;
    }
}
