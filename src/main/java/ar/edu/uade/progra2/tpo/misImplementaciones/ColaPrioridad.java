package ar.edu.uade.progra2.tpo.misImplementaciones;

import ar.edu.uade.progra2.tpo.miApi.ColaPrioridadTDA;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa
 *          Ignacio Javier
 * @grupo 18
 **/
public class ColaPrioridad implements ColaPrioridadTDA {

	class Elem {
		int v, p;

	}

	Elem[] vector;
	int cant;

	/**
	 * @Costo Espacial 0/ Temporal constante
	 */
	@Override
	public void inicializarCola() {

		vector = new Elem[100];
		cant = 0;
	}

	/**
	 * @Costo Espacial 0/ Temporal lineal
	 */
	@Override
	public void acolarPrioridad(int x, int p) {
		int i;

		for (i = cant - 1; i >= 0 && vector[i].p >= p; i -= 1) {
			vector[i + 1] = vector[i];
		}
		vector[i + 1] = new Elem();
		vector[i + 1].v = x;
		vector[i + 1].p = p;
		cant += 1;
	}

	/**
	 * @Costo Espacial 0/ Temporal constante
	 */
	@Override
	public boolean colaVacia() {

		return cant == 0;
	}

	/**
	 * @Costo Espacial 0/ Temporal constante
	 */
	@Override
	public void desacolar() {

		cant -= 1;

	}

	/**
	 * @Costo Espacial 0/ Temporal constante
	 */
	@Override
	public int primero() {

		return vector[cant - 1].v;
	}

	/**
	 * @Costo Espacial 0/ Temporal constante
	 */
	@Override
	public int prioridad() {

		return vector[cant - 1].p;
	}

}
