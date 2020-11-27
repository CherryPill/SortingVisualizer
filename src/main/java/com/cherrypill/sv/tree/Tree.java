package com.cherrypill.sv.tree;

import com.cherrypill.sv.shapes.Shape;

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
}
