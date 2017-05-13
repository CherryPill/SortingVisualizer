/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.util.ArrayList;
import java.awt.Color;
/**
 *
 * @author Theta3
 */

public class TreeVisitor {
        private ArrayList<Shape> shapes;
        private int counter = 0;
        private int direction;
        public TreeVisitor(ArrayList<Shape> shapes, int direction) {
                this.shapes = shapes;
                this.direction = direction;
            }
        public void visit(Tree node) {
                boolean swap = true;
                if(this.counter<this.shapes.size() && swap) {
                        Shape firstObj = this.shapes.get(counter);
                        Shape secondObj = node.shape;
                        //ascending
                        if(direction == 0) {
                        if(firstObj.size > secondObj.size) {
                                new Swapper().swap(firstObj, secondObj);
                                swap = true;
                                this.counter++;
                            }
                        else {
                                swap = false;
                                counter = 0;
                            }
                        }
                        else {
                        //descending
                        if(firstObj.size < secondObj.size) {
                                new Swapper().swap(firstObj, secondObj);
                                swap = true;
                                this.counter++;
                            }
                        else {
                                swap = false;
                                counter = 0;
                                
                            }
                        
                        }
                    }
                
            }
    }
