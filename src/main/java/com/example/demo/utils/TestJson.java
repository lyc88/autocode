package com.example.demo.utils;

import java.util.*;
import java.util.stream.Collectors;

public class TestJson {
    public static void main(String[] args) {


        List<Node> root = new ArrayList<>();

        String str = "{'a':1,'b.a':2,'b.b':3,'cc.d.e':4,'cc.d.f':5}";

        String newStr = str.substring(1,str.lastIndexOf("}"));

        String[] splits = newStr.split(",");


        for (int i = 0; i <splits.length ; i++) {
            Map map = new HashMap();
            String[] s = splits[i].split(":");
            String substring = String.valueOf(s[0]).substring(1, String.valueOf(s[0]).lastIndexOf("'"));

            if(substring.indexOf(".")!=-1){
                String[] split = substring.split("\\.");
                List<Node> nodeList = getNode(split,s[1]);
                for (int i1 = 0; i1 < nodeList.size(); i1++) {
                    root.add(nodeList.get(i1));
                }

            }else {
                //
                Node node = new Node();
                node.setName(substring);
                node.setValue(s[1]);
                root.add(node);
            }




        }

        System.out.println(newStr);

        //System.out.println(root);

        List<Node> root1 = new ArrayList<>();

        root.forEach(e->{
            String name = e.getName();
            root1.add(e);
            if(e.getNodeList() != null){

                root.forEach(e1->{
                    if(Objects.equals(name,e1.getName())){
                         e.getNodeList().addAll(e1.getNodeList());
                         e.setNodeList(e.getNodeList().stream().distinct().collect(Collectors.toList()));
                    }
                });
            }

        });


        System.out.println(root1);

        short i = 1+1;
        i += 4;
/*

        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("ja")
                .append("va").toString();

        System.out.println(s2.intern() == s2);
*/

        int k =  1 << 3;
        int k1 = 8 >> 2;
        System.out.println(k);
        System.out.println(k1);


        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//true
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());

    }

    public static  List<Node> getNode(String[] split,String v){
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < split.length-1; i++) {
            Node node = new Node();
            node.setValue(v);
            node.setName(split[i]);
            Node node1 = new Node();
            node1.setValue(v);
            node1.setName(split[i+1]);
            List<Node> nodeList = new ArrayList<>();
            nodeList.add(node1);
            node.setNodeList(nodeList);

            list.add(node);

        }
        return list;
    }

}

