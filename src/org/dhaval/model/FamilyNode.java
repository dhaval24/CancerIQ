package org.dhaval.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Dhaval on 4/19/2016.
 */

@Component
@Scope("prototype")
public class FamilyNode {

    private int value;
    private FamilyNode parent;
    private ArrayList<FamilyNode> children = new ArrayList<>();

    public ArrayList<FamilyNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<FamilyNode> children) {
        this.children = children;
    }

    public FamilyNode getParent() {
        return parent;
    }

    public void setParent(FamilyNode parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
