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
public class CircleCommandNode extends ASTreeNode {

  public ASTreeNode arguments[];
  public int argCount = 4;

  public CircleCommandNode(ASTreeNode args[]) {
    nodeType = "CircleCommandNode";

    arguments = new ASTreeNode[argCount];

    if (args != null) {
      for (int i = 0; i < argCount; i++) {
        arguments[i] = args[i];
      }
    }
  }

  @Override
  public String toString() {
    return "[" + nodeType + ":ARGUMENTS:" + arguments[0].toString() + ","
            + arguments[1].toString() + ","
            + arguments[2].toString() + ","
            + arguments[3].toString() + "]";
  }
}
