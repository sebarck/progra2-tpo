package ar.edu.uade.progra2.tpo.misImplementaciones;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
public class DiccionarioMultiple implements DiccionarioMultipleTDA {

    private Elemento[] elementos;
    private int cantidad;
    private int capacidad = 100;

    /**
	 * @Costo Espacial 0/ Temporal constante
	 */
    @Override
    public void inicializarDiccionarioMultiple() {
        elementos = new Elemento[capacidad];
        cantidad = 0;
    }

    /**
	 * @Costo Espacial 0/ Temporal lineal
	 */
    @Override
    public void agregar(int clave, int valor) {
        int posicionClave = obtenerPosicionPorClave(clave);
        if (posicionClave == -1) {
            posicionClave = cantidad++;
            elementos[posicionClave] = new Elemento(clave, 0, new int[capacidad]);
        }
        Elemento elemento = elementos[posicionClave];
        int posicionValor = obtenerPosicionPorValor(elemento, valor);
        if(posicionValor == -1) {
            elemento.agregarValor(valor);
        }
    }

    /**
	 * @Costo Espacial 0/ Temporal lineal
	 */
    @Override
    public void eliminar(int clave) {
        int posicion = obtenerPosicionPorClave(clave);
        if (posicion != -1) {
            elementos[posicion] = elementos[--cantidad];
        }
    }

    /**
	 * @Costo Espacial 1/ Temporal lineal
	 */
    @Override
    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        int posicion = obtenerPosicionPorClave(clave);
        if (posicion != -1) {
            Elemento elemento = elementos[posicion];
            for (int i = 0; i < elemento.cantidad(); i++) {
                conjunto.agregar(elemento.valores()[i]);
            }
        }
        return conjunto;
    }
    /**
	 * @Costo Espacial 0/ Temporal lineal
	 */
    @Override
    public void eliminarValor(int clave, int valor) {
        int posicionPorClave = obtenerPosicionPorClave(clave);
        if (posicionPorClave != -1) {
            Elemento elemento = elementos[posicionPorClave];
            int posicionValor = obtenerPosicionPorValor(elemento, valor);
            if (posicionValor != -1) {
                elemento.cantidad(elemento.cantidad() - 1);
                elemento.valores(posicionValor);
                if (elemento.cantidad() == 0) {
                    eliminar(clave);
                }
            }
        }
    }

    /**
	 * @Costo Espacial 1/ Temporal lineal
	 */
    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        for (int i = 0; i < cantidad; i++) {
            conjunto.agregar(elementos[i].clave());
        }
        return conjunto;
    }

    /**
   	 * @Costo Espacial 0/ Temporal lineal
   	 */
    private int obtenerPosicionPorClave(int clave) {
        int i = cantidad - 1;
        while (i >= 0 && elementos[i] != null && elementos[i].clave() != clave) {
            i--;
        }
        return i;
    }

    /**
   	 * @Costo Espacial 0/ Temporal lineal
   	 */
    private int obtenerPosicionPorValor(Elemento elemento, int valor) {
        int i = elemento.cantidad() - 1;
        while (i >= 0 && elemento.valores() != null && elemento.valores()[i] != valor) {
            i--;
        }
        return i;
    }
}
