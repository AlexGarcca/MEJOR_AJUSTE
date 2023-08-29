package com.mycompany.mejorajuste;
class PARTICION {
    String nombre;
    int tamano;
    boolean ocupada;
    String nombreProceso;

    public PARTICION(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.ocupada = false;
        this.nombreProceso = "";
    }
}
