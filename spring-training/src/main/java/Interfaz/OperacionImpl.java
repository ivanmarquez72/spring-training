package Interfaz;

import Interfaz.IOperacion;

public class OperacionImpl implements IOperacion {
    @Override
    public int suma(int a, int b) {
        return a + b;
    }

    @Override
    public int resta(int a, int b) {
        return a - b;
    }
}
