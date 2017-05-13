/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Theta1
 */
public class mainFrame extends JFrame{
    private Model model;
    public static int windowWidth = 800;
    public static int windowHeight = 200;
    private static double _getUserScreenWidth() {
            GraphicsEnvironment context = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = context.getDefaultScreenDevice();
            return device.getDefaultConfiguration().getBounds().getWidth();
        }
    private static double _getUserScreenHeight() {
            GraphicsEnvironment context = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice device = context.getDefaultScreenDevice();
            return device.getDefaultConfiguration().getBounds().getHeight();
        }
    public static void centerWindow(double[] dims) {
            dims[0] = mainFrame._getUserScreenWidth()/2-windowWidth/2;
            dims[1] = mainFrame._getUserScreenHeight()/2-windowHeight/2;
        }
    public mainFrame(Model model) {
        this.model = model;
        this.setLayout(new GridLayout(1,2));
        this.getContentPane().add(model.getView());
        this.getContentPane().add(new controlPanel(model));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setSize(windowWidth,windowHeight);
        setResizable(false);
        double[] usrScreenDims = new double[2];
        mainFrame.centerWindow(usrScreenDims);
        setLocation((int)usrScreenDims[0], (int)usrScreenDims[1]);
        
        setVisible(true);
        
    }
}
