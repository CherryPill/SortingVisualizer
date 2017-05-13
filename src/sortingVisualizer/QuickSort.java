/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Theta1
 */
public class QuickSort implements Runnable{
    ArrayList<Shape> shapes;
    int direction;
    
    public QuickSort(ArrayList<Shape> shapes, int direction) {
            
            this.shapes = shapes;
            this.direction = direction;
        }
    public void run() {
            this.sort(0, this.shapes.size()-1);
        }
    private void sort(int start, int end) {
            int q;
            if(start<end)
            {
                q = partition(start, end);
                sort(start, q);
                sort(q+1, end);
            }
        }
    private static int nextIntInRange(int min, int max, Random rng) {
           if (min > max) {
              throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
           }
           int diff = max - min;
           if (diff >= 0 && diff != Integer.MAX_VALUE) {
              return (min + rng.nextInt(diff + 1));
           }
           int i;
           do {
              i = rng.nextInt();
           } while (i < min || i > max);
           return i;
        }
    private int partition(int start, int end) {
        int init = start;
        int length = end;
        Random r = new Random();
        int pivotIndex = nextIntInRange(start,end,r);
        Shape pivot = this.shapes.get(pivotIndex); 
        System.out.println("Pivot Element "+pivot+" at index:"+pivotIndex);
        if(this.direction == 0) //ascending order
            {
            while(true) {
            while(this.shapes.get(length).size>pivot.size && length>start){
                length--;
            }
            while(this.shapes.get(init).size<pivot.size && init<end) {
                init++;
            }
                if(init<length) {
                    Shape first = this.shapes.get(init);
                    Shape second = this.shapes.get(length);
                    new Swapper().swap(first, second);
                    length--;
                    init++;
                }
                else {
                    return length;
                }
                if(init<length) {
                    Shape first = this.shapes.get(init);
                    Shape second = this.shapes.get(length);
                    new Swapper().swap(first, second);

                    length--;
                    init++;
                }
                else {
                return length;
               }
            }
        }
        else { //descending order
            while(true) {
            while(this.shapes.get(length).size<pivot.size && length>start){
                length--;
            }
            while(this.shapes.get(init).size>pivot.size && init<end) {
                init++;
            }
                if(init<length) {
                    Shape first = this.shapes.get(init);
                    Shape second = this.shapes.get(length);
                    new Swapper().swap(first, second);

                    length--;
                    init++;
                }
                else {
                    return length;
                }
                if(init<length) {
                    Shape first = this.shapes.get(init);
                    Shape second = this.shapes.get(length);
                    new Swapper().swap(first, second);

                    length--;
                    init++;
                }
                else {
                return length;
               }
            }
        }
    }
}
