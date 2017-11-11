/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Ana
 */
public class Grafico {
    
    private XYSeries series;
    private XYSeriesCollection dataset;
    private JFreeChart grafico;
    
    public Grafico ( ) {
        
    }
    
    /*public Grafico (double[] vetor, String nome) {
        
        series = new XYSeries (nome);
        
        for (int i = 0; i < vetor.length; i++) {
            double j = 0;
            while ( j < vetor[i]) {
                series.add((double) i, j);
                j += 0.01;
            }
            //for ( double j = 0; j < vetor[i]; j += 0,1) {
                
            //}
            //series.add((double) i, vetor[i]);
        }

        
        dataset = new XYSeriesCollection(series);
        grafico = ChartFactory.createXYBarChart(nome, "X",false, "F(X)", dataset, PlotOrientation.VERTICAL, false, false, false);

        XYPlot plot = grafico.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        plot.setRenderer(renderer);
        
        ChartFrame frame = new ChartFrame(nome, grafico);
        frame.pack();
        frame.setVisible(true);
    }*/
    
    public void plotarGraficoProbabilidade (double[] vetor, String nome) {
        series = new XYSeries (nome);
        
        for (int i = 0; i < vetor.length; i++) {
            double j = 0;
            while ( j < vetor[i]) {
                series.add((double) i, j);
                j += 0.01;
            }
            //for ( double j = 0; j < vetor[i]; j += 0,1) {
                
            //}
            //series.add((double) i, vetor[i]);
        }

        
        dataset = new XYSeriesCollection(series);
        grafico = ChartFactory.createXYBarChart(nome, "X",false, "F(X)", dataset, PlotOrientation.VERTICAL, false, false, false);

        XYPlot plot = grafico.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        plot.setRenderer(renderer);
        
        ChartFrame frame = new ChartFrame(nome, grafico);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void plotarGraficoProbabilidadeAcumulada ( double[] vetor, String nome) {
        
        series = new XYSeries (nome);
        
        for (int i = 0; i < vetor.length; i++) {
            series.add((double) i, vetor[i]);
        }

        dataset = new XYSeriesCollection(series);
        grafico = ChartFactory.createXYBarChart(nome, "X",false, "F(X)", dataset, PlotOrientation.VERTICAL, false, false, false);
        
        ChartFrame frame = new ChartFrame(nome, grafico);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
}
