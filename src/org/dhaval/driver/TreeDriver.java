package org.dhaval.driver;

import org.dhaval.model.FamilyNode;
import org.dhaval.service.ConnectNodes;
import org.dhaval.service.PerformQueries;
import org.dhaval.service.TreeNodeListCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Dhaval on 4/19/2016.
 */
public class TreeDriver {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        try {
            BufferedReader br = new BufferedReader(new FileReader("input00.txt"));
            String line = br.readLine();
            int totalNodes = Integer.parseInt(line);
            TreeNodeListCreator tx = context.getBean("treeNodeListCreator", TreeNodeListCreator.class);
            tx.createNodeList(totalNodes);
            ArrayList<FamilyNode> familyList = (ArrayList<FamilyNode>) tx.getNodeList();
            ConnectNodes obj = context.getBean("connectNodes", ConnectNodes.class);
            for(int i = 0 ; i < totalNodes-1; i++){

                line = br.readLine();
                String[] temp = line.split(" ");
                int vertex1 = Integer.parseInt(temp[0]) - 1;
                int vertex2 = Integer.parseInt(temp[1]) -1 ;
                if(vertex1 < vertex2){
                    obj.ConnectNodes(familyList.get(vertex1), familyList.get(vertex2));
                }
                else{
                    obj.ConnectNodes(familyList.get(vertex2), familyList.get(vertex1));
                }

            }
            int totalQueriesToProcess = Integer.parseInt(br.readLine());
            PerformQueries pf = context.getBean("performQueries", PerformQueries.class);
            pf.traversePreOrder(familyList.get(0));
            File file = new File("Output.txt");
            file.createNewFile();
            PrintWriter bf = new PrintWriter(new FileWriter(file.getAbsoluteFile()));
            for(int i = 0; i<totalQueriesToProcess; i++){
                String[] query = br.readLine().split(" ");
                String queryType = query[0];
                if(queryType.equals("add")){
                    pf.addValuesToNodesInSubtree(familyList.get(Integer.parseInt(query[1])-1), Integer.parseInt(query[2]));
                }
                else if(queryType.equals("max")){
                    System.out.println("max query result");
                    bf.println((pf.findMaxInPath(familyList.get(Integer.parseInt(query[1])-1),familyList.get(Integer.parseInt(query[2])-1))));
                    //bf.newLine();
                }
            }

            bf.close();
            System.out.println("-------after performing addition------");
            pf.traversePreOrder(familyList.get(0));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
