/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.util.ArrayList;
import java.lang.InterruptedException;
import javax.swing.JOptionPane;
/**
 *
 * @author Theta1
 */
//done
public class ShellSort implements Runnable{
    ArrayList<Shape> shapes;
    int direction;
    View view;
    public ShellSort(ArrayList<Shape> shapes, int direction, View v) {
            this.direction = direction;
            this.shapes = shapes;
            this.view = v;
        }
    public void run(){
            this.sort();
            this.view.getModel().getMvcFrame().getCntrlPanel().updateStateLabel(2);
        }
    public void sort() {
            int j;
            for( int gap = this.shapes.size() / 2; gap > 0; gap /= 2 ) {
              for( int i = gap; i < this.shapes.size(); i++ ) {
                 Shape tempShape = new Square((Square)this.shapes.get(i));
                 if(direction == 0) {
                        for(j = i; j >= gap && tempShape.compareTo( this.shapes.get(j - gap)) < 0; j -= gap ) {
                           Shape first = this.shapes.get(j);
                           Shape second = this.shapes.get(j - gap);
                           new Swapper().swap(first, second);
                        ;
                           
                           
                        }
                     }
                 else {
                        for(j = i; j >= gap && tempShape.compareTo( this.shapes.get(j - gap)) > 0; j -= gap ) {
                           Shape first = this.shapes.get(j);
                           Shape second = this.shapes.get(j - gap);
                           new Swapper().swap(first, second);
                          
                          
                           
                        }
                     }
                  view.revalidate();
                           view.repaint();
                         try{
                               Thread.sleep(1000);
                           }
                           catch(InterruptedException e){
                              JOptionPane.showMessageDialog(null, "Thread exception occurred", "Error", JOptionPane.OK_OPTION);
                           }
                           
                }
            }
        }
}
