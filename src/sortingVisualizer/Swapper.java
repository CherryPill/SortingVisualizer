/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;

/**
 *
 * @author Theta3
 */
//swaps color and size, repaints
public class Swapper implements Swappable {
        @Override
        public void swap(Shape first, Shape second)
            {
                    Color temp;
                    temp = first.shapeColor;
                    first.shapeColor = second.shapeColor;
                    second.shapeColor = temp;
        
                    first.size ^= second.size;
                    second.size ^= first.size;
                    first.size ^= second.size;
                    
            }
    }
