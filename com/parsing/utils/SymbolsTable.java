package com.parsing.utils;

import java.util.LinkedHashMap;

public class SymbolsTable {
    
    private SymbolsTable _previousTable = null;
    private LinkedHashMap<String, String> _symbolTable = null;

    public void setPreviousTable(SymbolsTable v) {
        _previousTable = v;
    } 


    public SymbolsTable getPreviousTable() {
        return _previousTable;
    }


    public boolean addSymbol(String id, String data) {
        if (_symbolTable.containsKey(id))
            return false;

        _symbolTable.put(id, data);
        return true;
    }


    public boolean isSymbolInTable(String id) {
        return _symbolTable.containsKey(id);
    }


    public String getSymbolType(String id) {
        if (!isSymbolInTable(id))
            return null;

        return _symbolTable.get(id);
    }


    public SymbolsTable() {
        _symbolTable = new LinkedHashMap<String, String>();
    }


    public SymbolsTable(SymbolsTable prev) {
        _symbolTable = new LinkedHashMap<String, String>();
        _previousTable = prev;
    }
}
