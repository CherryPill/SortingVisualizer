/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingVisualizer;

/**
 *
 * @author Theta3
 */
public class Tree {
   public Tree left;            
   public Tree right;
   public Shape shape;
   public Tree(Shape shape) {
        this.shape = shape;
        int sentinel = 10;
       }
   public void insert( Tree aTree) {
     if ( aTree.shape.size  < this.shape.size )
        if (left != null) left.insert( aTree );
        else left = aTree;
     else
        if (right != null ) right.insert( aTree );
        else right = aTree;
   }
   public void traverse(TreeVisitor visitor) {
      if (left != null) 
            left.traverse( visitor );
      visitor.visit(this);

      if ( right != null ) 
            right.traverse( visitor );
   }
}
