/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import java.util.*;
import java.awt.*;
/**
 *
 * @author Theta1
 */

public class View extends JPanel{
    private final Model model;
    private Color[] availableColors = {
        Color.RED,
        Color.ORANGE,
        Color.GREEN,
        Color.YELLOW,
        Color.BLACK,
        Color.CYAN,
        Color.PINK
    };
    public int getMaxShapesColorNum(){
        return this.availableColors.length;
    }
    public Color[] getAvailableColors() {
        return availableColors;
    }
    
    public Model getModel() {
        return model;
    }
   
    public View(Model model) {
        this.model = model;
        this.setLayout(new GridLayout(1,1));
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.clearRect(0, 0, getWidth(), getHeight());
        
        for(Shape shape:model.getAllShapes()) {
            g2d.setColor(shape.shapeColor);
            g2d.fillRect(shape.xCoord, shape.yCoord, shape.size,shape.size);
            g2d.drawRect(shape.xCoord, shape.yCoord, shape.size,shape.size);  
        }
    }
}
