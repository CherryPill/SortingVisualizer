/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

import java.awt.Color;

public class Square extends Shape
{
     public Square(int xCoord, int yCoord, int size, Color color) {
         this.xCoord = xCoord;
         this.yCoord = yCoord;
         this.size = size;
         this.shapeColor = color;    
     }
     public Square(Square obj) {
            this.xCoord = obj.xCoord;
            this.yCoord = obj.yCoord;
            this.size = obj.size;
            this.shapeColor = obj.shapeColor; 
         }
     public int getSize() {
         return this.size;
     }
     public int compareTo(Shape otherShape) { 
         if(this.size > otherShape.size) {
       
             return 1;
         }
         else {
             return -1;
         }
     }
}
