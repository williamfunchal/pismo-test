package com.pismo.transactionroutines.util.enums;

public enum OperationTypes {
    compra_a_vista(1), compra_parcelada(2), saque(3), pagamento(4);

    private final int type;
    
    private OperationTypes(int type) {
        this.type = type;
    }

    public int getValue() { return type; }
}