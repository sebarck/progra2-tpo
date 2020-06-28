package ar.edu.uade.progra2.tpo.misImplementaciones;
/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
public class Elemento {

    private int clave;
    private int[] valores;
    private int cantidad;

    public Elemento(int clave, int cantidad, int[] valores) {
        this.clave = clave;
        this.cantidad = cantidad;
        this.valores = valores;
    }

    public void agregarValor(int valor) {
        valores[cantidad++] = valor;
    }

    public int clave() {
        return clave;
    }

    public int[] valores() {
        return valores;
    }

    public void valores(int posicion) {
        valores[posicion] = valores[cantidad];
    }

    public int cantidad() {
        return cantidad;
    }

    public void cantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
