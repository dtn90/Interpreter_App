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
public class DeclarationNode extends ASTreeNode {
  
  public String identifier;
  public String type;
  
  public DeclarationNode(String type, String identifier) {
    nodeType = "DeclarationNode";
    this.type = type;
    this.identifier = identifier;
  }
  
  @Override
  public String toString() {
    return "["+ nodeType + ":TYPE:" + type + ":IDENTIFIER:" + identifier +"]";
  }
}
