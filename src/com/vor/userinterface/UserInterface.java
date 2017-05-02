package com.vor.userinterface;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Container;
import javax.swing.*;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import com.vor.radio.*;
import com.vor.vorcalculator.*;
/**
 * Created by alliekim on 5/1/17.
 */
public class UserInterface {

  private Frame mainFrame;
  private Label headerLabel;
  private Label statusLabel1;
  private Panel controlPanel1;
  private Label statusLabel2;
  private Panel controlPanel2;
  private JPanel graphPanel;

  public UserInterface(){
    prepareGUI();
  }

  public static void main(String[] args){
    UserInterface  awtControlDemo = new UserInterface();
    awtControlDemo.showEventDemo();
  }

  private void prepareGUI(){
    mainFrame = new Frame("Java AWT Examples");
    mainFrame.setSize(800,800);

    JButton button;
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    mainFrame.setLayout(gridbag);



    mainFrame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent){
        System.exit(0);
      }
    });


    statusLabel1 = new Label();
    statusLabel1.setAlignment(Label.CENTER);
    statusLabel1.setSize(150,100);
    statusLabel2 = new Label();
    statusLabel2.setAlignment(Label.CENTER);
    statusLabel2.setSize(150,100);

    controlPanel1 = new Panel();
    controlPanel1.setLayout(new FlowLayout());

    controlPanel2 = new Panel();
    controlPanel2.setLayout(new FlowLayout());

    graphPanel = createChartPanel();

    //mainFrame.add(headerLabel);

    //Grid component
    c.weightx = 0.5;
    c.gridx = 0;
    c.gridy = 0;
    //button = new JButton("Button 3");
    //gridbag.setConstraints(button, c);
    //mainFrame.add(button);
    //gridbag.setConstraints(controlPanel1, c);
    mainFrame.add(controlPanel1, c);
    mainFrame.add(statusLabel1, c);
    mainFrame.add(controlPanel2, c);
    mainFrame.add(statusLabel2, c);

/*
    //Grid component
    c.gridx = 0;
    c.gridy = 1;
    //button = new JButton("Button 3");
    //gridbag.setConstraints(button, c);
    //mainFrame.add(button);
    gridbag.setConstraints(statusLabel1, c);
    mainFrame.add(statusLabel1, c);

    //Grid component
    c.gridx = 0;
    c.gridy = 2;
    //button = new JButton("Button 3");
    //gridbag.setConstraints(button, c);
    //mainFrame.add(button);
    gridbag.setConstraints(controlPanel2, c);
    mainFrame.add(controlPanel2, c);

    //Grid component
    c.gridx = 0;
    c.gridy = 3;
    //button = new JButton("Button 3");
    //gridbag.setConstraints(button, c);
    //mainFrame.add(button);
    gridbag.setConstraints(statusLabel2, c);
    mainFrame.add(statusLabel2, c);
*/
    //Tall component
    c.ipady = 0;      //make this component tall
    c.weightx = 0.0;
    c.gridheight = 4;
    c.gridx = 1;
    c.gridy = 0;
    gridbag.setConstraints(graphPanel, c);
    mainFrame.add(graphPanel, c);


    mainFrame.setVisible(true);
  }

  private XYDataset createDataset() {
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries series1 = new XYSeries("Object 1");
    XYSeries series2 = new XYSeries("Object 2");
    XYSeries series3 = new XYSeries("Object 3");

    series1.add(1.0, 2.0);
    series1.add(2.0, 3.0);
    series1.add(3.0, 2.5);
    series1.add(3.5, 2.8);
    series1.add(4.2, 6.0);

    series2.add(2.0, 1.0);
    series2.add(2.5, 2.4);
    series2.add(3.2, 1.2);
    series2.add(3.9, 2.8);
    series2.add(4.6, 3.0);

    series3.add(1.2, 4.0);
    series3.add(2.5, 4.4);
    series3.add(3.8, 4.2);
    series3.add(4.3, 3.8);
    series3.add(4.5, 4.0);

    dataset.addSeries(series1);
    dataset.addSeries(series2);
    dataset.addSeries(series3);

    return dataset;
  }

  private JPanel createChartPanel() {
    String chartTitle = "Objects Movement Chart";
    String xAxisLabel = "X";
    String yAxisLabel = "Y";

    XYDataset dataset = createDataset();

    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
        xAxisLabel, yAxisLabel, dataset);

    return new ChartPanel(chart);
  }

  private void showEventDemo() {
    headerLabel.setText("Control in action: Button");
    Label obslabel = new Label("OBS: ", Label.RIGHT);

    Button getRadio = new Button("Get Radio Signal");
    Button submitButton = new Button("Submit OBS Value");
    TextField obsField = new TextField(10);

    getRadio.setActionCommand("Get Radio Signal");
    submitButton.setActionCommand("Submit");

    controlPanel1.add(getRadio);
    controlPanel2.add(obslabel);
    controlPanel2.add(obsField);
    controlPanel2.add(submitButton);

    mainFrame.setVisible(true);

    getRadio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        RadioSignal rs = new RadioSignal();
        statusLabel1.setText("Radial: " + String.valueOf(rs.getRadial()) + " Signal: " + String.valueOf(rs.getSignal()));
      }
    });

    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String data = "OBS: " + obsField.getText();
        statusLabel2.setText(data);
      }
    });
  }
  }

