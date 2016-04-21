package org.dhaval.service;

import org.dhaval.model.FamilyNode;
import org.springframework.stereotype.Component;

/**
 * Created by Dhaval on 4/19/2016.
 */
@Component
public class PerformQueries {

    public void traversePreOrder(FamilyNode root){

        if(root == null)
            return;
        System.out.println(root.getValue());
        //traversePreOrder(root.getLeft());
        //traversePreOrder(root.getRight());
        for(FamilyNode f : root.getChildren()){
            traversePreOrder(f);
        }
    }

    public void addValuesToNodesInSubtree(FamilyNode root, int val){
        if(root == null)
            return;
        root.setValue(root.getValue()+ val);
        for(FamilyNode f : root.getChildren()){
            addValuesToNodesInSubtree(f, val);
        }
    }

    public int findMaxInPath(FamilyNode f1, FamilyNode f2)
    {
        int max = Integer.MIN_VALUE;
        if(f1 == f2)
            max = f1.getValue();
        int depth1 = findDepth(f1);
        int depth2 = findDepth(f2);
        while(depth1 > depth2){
            if(f1.getValue() > max){
                max = f1.getValue();
            }
            f1 = f1.getParent();
            depth1--;
        }
        while(depth2 > depth1){

            if(f2.getValue() > max){
                max = f2.getValue();
            }
            f2 = f2.getParent();
            depth2--;
        }
        while(f1 != f2){
            if(f1.getValue() > max)
                max = f1.getValue();
            if(f2.getValue() > max)
                max = f2.getValue();
            f1= f1.getParent();
            f2 = f2.getParent();
        }
        return max;
    }
    private static int findDepth(FamilyNode f1){
        int level =0;
        while(f1.getParent()!= null){
            f1 = f1.getParent();
            level++;
        }
        return level;
    }

}
