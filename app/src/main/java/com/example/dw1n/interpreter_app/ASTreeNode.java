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
public class ASTreeNode {
  
  public String nodeType; 
          
  ASTreeNode() {
    nodeType = "Empty";
  }
  
  @Override 
  public String toString() {
    return "["+ nodeType +"]";
  }
}
