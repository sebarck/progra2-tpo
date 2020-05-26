package ar.edu.uade.progra2.tpo.misImplementaciones;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

    private int[] elementos;
    private int cantidad;
    private int capacidad = 100;

    @Override
    public void inicializarConjunto() {
        elementos = new int[capacidad];
        cantidad = 0;
    }

    @Override
    public void agregar(int elemento) {
        if (!pertenece(elemento)) {
            elementos[cantidad] = elemento;
            cantidad++;
        }
    }

    @Override
	public void sacar(int elemento) {
        int posicion = 0;
        while (posicion < cantidad && elementos[posicion] != elemento) {
            posicion++;
        }
        if (posicion < cantidad) {
            elementos[posicion] = elementos[--cantidad];
        }
	}
    @Override
    public int elegir() {
        return elementos[cantidad - 1];
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }

    @Override
    public boolean pertenece(int elemento) {
        int i = 0;
        while (i < cantidad && elementos[i] != elemento) {
            i++;
        }
        return (i < cantidad);
    }
}
