/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;
import java.util.ArrayList;
public class BubbleSort{
    ArrayList<Shape> shapes;
    public BubbleSort(ArrayList<Shape> shapes, View view) {
            this.shapes = shapes;
        }
    public void sort(int direction) {
            (new Thread() {
                public void run() {
                        boolean pass = true;
                        while(pass) {
                            pass = false;
                            for(int x = 0;x<shapes.size()-1;x++) {
                                Shape first = shapes.get(x);
                                Shape second = shapes.get(x+1);
                                if(direction == 0) {
                                        if(first.size > second.size) {
                                        new Swapper().swap(first, second);
                                        pass = true;
                                    }
                                }
                                else {
                                        if(first.size < second.size) {
                                        new Swapper().swap(first, second);
                                        pass = true;
                                       }
                                }
                            }
                        }
                    }
            }).start();     
        }
}
