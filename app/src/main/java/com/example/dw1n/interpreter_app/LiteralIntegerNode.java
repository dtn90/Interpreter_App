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
public class LiteralIntegerNode extends ASTreeNode {

  public int value;

  public LiteralIntegerNode(int value) {
    this.value = value;
    nodeType = "LiteralIntegerNode";
  }

  @Override
  public String toString() {
    return "[" + nodeType + ":" + value + "]";
  }
}