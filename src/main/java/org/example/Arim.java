package org.example;

public enum Arim {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    Arim(int i) {
        number = i;
    }

    private int number;

    public int getNumber() {
        return number;
    }
}
