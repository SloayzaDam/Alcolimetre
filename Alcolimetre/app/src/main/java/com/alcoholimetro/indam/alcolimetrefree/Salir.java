package com.alcoholimetro.indam.alcolimetrefree;

public class Salir {
    private static boolean salir = false;

    public static void setSalir(boolean estado) {
        salir = estado;
    }

    public static boolean getSalir() {
        return salir;
    }
}
