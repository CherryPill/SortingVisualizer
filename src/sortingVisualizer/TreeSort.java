/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.util.*;
/**
 *
 * @author Theta1
 */
public class TreeSort {
    Tree mainTree;
    ArrayList<Shape> shapes;
    int direction;
    public TreeSort(ArrayList<Shape> shapes, int direction) {
            this.shapes = shapes;
            this.direction = direction;
            mainTree = new Tree(this.shapes.get(0));
            for(int x = 0;x<this.shapes.size();x++) {
                     mainTree.insert(new Tree(this.shapes.get(x)));
                }
        }
    public void sort() {
            mainTree.traverse(new TreeVisitor(this.shapes, this.direction));
        }
}
