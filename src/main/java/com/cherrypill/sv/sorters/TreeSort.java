
package com.cherrypill.sv.sorters;

import com.cherrypill.sv.shapes.Shape;
import com.cherrypill.sv.tree.Tree;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.text.View;

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
    }
    public void sort() {
        TreeSort.foundCount = 0;
        this.inOrder(mainTree);;
     }

}
