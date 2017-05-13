/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Random;

public class Model {
    private ArrayList<Shape> shapes;
    private final Controller controller;
    private final View view;
    private final mainFrame mvcFrame;
    private int shapesMargin = 10;
    private final int maxSize = 60;
    private final int constYOffset = mainFrame.windowHeight/2;
    
    public void sortWrapper(int index, int direction) {
            switch(index) {
                case 0: {
                    this.Shellsort(direction); //works in a separate thread, swap not separate
                    break;
                }
                case 1: {
                    this.quickSort(direction); //works in a separate thread, swap separate
                    break;
                }
                case 2: {
                    this.bubbleSort(direction); //works in a separate thread, swap separate, both directions
                    break;
                }
                case 3: {
                    this.binaryTree(direction); //buggy, no separate thread, no swap, no directions
                    break;
                }
            }
        view.revalidate();
        view.repaint();
        }  
    public void bubbleSort(int direction) {   
        new BubbleSort(this.shapes, view).sort(direction);
    }
    public void binaryTree(int direction) {
        TreeSort ts = new TreeSort(this.shapes, direction);
        ts.sort();
        int sentinel = 10;
    }
    public void Shellsort(int direction) {
        Thread shellThread = new Thread(new ShellSort(this.shapes, direction));
        shellThread.start();
    }
    public void quickSort(int direction) {
        Thread qsortThread = new Thread(new QuickSort(this.shapes, direction));
        qsortThread.start();
    }
    public ArrayList<Shape> getAllShapes() {
        return this.shapes;
    }
    public int[] generateRandomNumbers() {
            int[] arr = new int[5];
            for(int x = 0;x<5;x++) {
                    arr[x] = 0 + (int)(Math.random() * this.maxSize); 
                }
            return arr;
        }
    public Model() {
        int[] randomNumbers = this.generateRandomNumbers();
        shapes = new ArrayList<>();
        shapes.add(new Square(0,constYOffset,randomNumbers[0],Color.CYAN));
        shapes.add(new Square(maxSize+shapesMargin,constYOffset,randomNumbers[1],Color.RED));
        shapes.add(new Square((maxSize+shapesMargin)*2,constYOffset,randomNumbers[2],Color.BLACK));
        shapes.add(new Square((maxSize+shapesMargin)*3,constYOffset,randomNumbers[3],Color.GREEN));
        shapes.add(new Square((maxSize+shapesMargin)*4,constYOffset,randomNumbers[4],Color.PINK));
        
        controller = new Controller(this);
        view = new View(this);
        mvcFrame = new mainFrame(this);
    }
    public View getView() {
        return view;        
    }
    public void handleResizing() {
            int width = (int)mvcFrame.getBounds().getWidth();
            int height = (int)mvcFrame.getBounds().getHeight();
            mvcFrame.windowWidth = width;
            mvcFrame.windowHeight = height;
        }
}
