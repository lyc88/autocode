package com.example.demo.utils;

import java.util.List;

public class Node {

    private String name;

    private String value;

    List<Node> nodeList;

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", nodeList=" + nodeList +
                '}';
    }
}
