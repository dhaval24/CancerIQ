package org.dhaval.service;

import org.dhaval.model.FamilyNode;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dhaval on 4/19/2016.
 */
@Component
public class TreeNodeListCreator implements ApplicationContextAware{

    private ApplicationContext context;
    private Collection<FamilyNode> nodeList = new ArrayList<>();

    public Collection<FamilyNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(Collection<FamilyNode> nodeList) {
        this.nodeList = nodeList;
    }

    public Collection<FamilyNode> createNodeList(int number){

        for(int i = 0; i < number; i++){
            FamilyNode node  = context.getBean("familyNode", FamilyNode.class);
            getNodeList().add(node);
        }

        return getNodeList();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
