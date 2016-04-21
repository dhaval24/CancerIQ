package org.dhaval.service;

import org.dhaval.model.FamilyNode;
import org.springframework.stereotype.Component;

/**
 * Created by Dhaval on 4/19/2016.
 */

@Component
public class ConnectNodes {

    public void ConnectNodes(FamilyNode f1, FamilyNode f2){

//        if(f1.getLeft()== null){
//            f1.setLeft(f2);
//            f2.setParent(f1);
//        }else{
//            f1.setRight(f2);
//            f2.setParent(f1);
//        }

        f1.getChildren().add(f2);
        f2.setParent(f1);

    }
}
