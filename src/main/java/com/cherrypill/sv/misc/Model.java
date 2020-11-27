package com.cherrypill.sv.misc;

import com.cherrypill.sv.shapes.Shape;
import com.cherrypill.sv.shapes.Square;
import com.cherrypill.sv.sorters.BubbleSort;
import com.cherrypill.sv.sorters.QuickSort;
import com.cherrypill.sv.sorters.ShellSort;
import com.cherrypill.sv.sorters.TreeSort;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.View;
import java.util.Random;

public class Model {
    private ArrayList<Shape> shapes;
    private final int maxNumOfShapes = 5;
    private int shapesMargin = 10;
    private final int maxSize = 60;
    private final int minSize = 10;
    private final int constYOffset = 60;
    private final int constXOffset = 20;

    public void sortWrapper(int index, int direction) {
        switch (index) {
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
    }

    public void bubbleSort(int direction) {
        new BubbleSort(this.shapes, null).sort(direction);
    }

    public void binaryTree(int direction) {
        Thread treeThread = new Thread(new TreeSort(this.shapes, direction, null));
        treeThread.start();
    }

    public void Shellsort(int direction) {
        Thread shellThread = new Thread(new ShellSort(this.shapes, direction, null));
        shellThread.start();
    }

    public void quickSort(int direction) {
        Thread qsortThread = new Thread(new QuickSort(this.shapes, direction, null));
        qsortThread.start();
    }

    public ArrayList<Shape> getAllShapes() {
        return this.shapes;
    }

    public int[] generateRandomNumbers() {
        int[] arr = new int[5];
        for (int x = 0; x < 5; x++) {
            arr[x] = minSize + (int) (Math.random() * this.maxSize);
        }
        return arr;
    }

    public Model() {

        this.generateShapes();
    }


    public void generateShapes() {
        int[] randomNumbers = this.generateRandomNumbers();
        shapes = new ArrayList<>();
        int currentColorIndex = 0;
        for (int x = 0; x < maxNumOfShapes; x++) {
            currentColorIndex = this.pickColor(randomNumbers[x]);
            shapes.add(
                    new Square(
                            ((x == 0 ? 0 : maxSize) + (x == 0 ? 0 : shapesMargin)) * x + constXOffset,
                            constYOffset,
                            randomNumbers[x],
                            null
                    )
            );
        }

    }

    private int pickColor(int size) {
        int color = 0;
       /* while(isColorTaken(view.getAvailableColors()[color=size % view.getMaxShapesColorNum()])){
            size+=10;
        }*/
        return color;
    }

    private boolean isColorTaken(Color color) {
        if (this.shapes != null) {
            for (Shape shape : this.shapes) {
                if (shape.shapeColor.equals(color)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }

    }
}
