package com.example.dw1n.interpreter_app;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

  private Map<String, Integer> symbol_table = new HashMap();
  private static SymbolTable instance = new SymbolTable();

  private SymbolTable() {

  }

  public static SymbolTable getInstance() {
    return instance;
  }

  public void put(String key, int value) {
    symbol_table.put(key, value);
  }

  public int get(String key) {
    return (int) symbol_table.get(key);
  }

  public void clear() {
    symbol_table.clear();
  }
}