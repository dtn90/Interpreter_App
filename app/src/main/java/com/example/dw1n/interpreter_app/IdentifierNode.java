/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dw1n.interpreter_app;

/**
 *
 * @author Flex
 */
public class IdentifierNode extends ASTreeNode{

  public String name;

  public IdentifierNode(String name) {
    this.name = name;
    nodeType = "IdentifierNode";
  }

  @Override
  public String toString() {
    return "[" + nodeType + ":" + name + "]";
  }
}
