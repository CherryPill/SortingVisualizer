/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Theta1
 */
public class TreeSort implements Runnable {
    Tree mainTree;
    ArrayList<Shape> shapes;
    int direction;
    View view;
    private static int foundCount = 0;
    public TreeSort(ArrayList<Shape> shapes, int direction, View view) {
            this.view = view;
            this.shapes = shapes;
            this.direction = direction;
            mainTree = new Tree(this.shapes.get(0));
            for(int x = 1;x<this.shapes.size();x++) {
                     mainTree.insert(new Tree(this.shapes.get(x)));
                }
    }
    //ascending order
    private void inOrder(Tree t){
        if(t != null) {
            //stub
        }
    }
    public void run() {
        this.sort();
        this.view.getModel().getMvcFrame().getCntrlPanel().updateStateLabel(2);
    }
    public void sort() {
        TreeSort.foundCount = 0;
        this.inOrder(mainTree);;
     }
     private void pauseExecution(){
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
