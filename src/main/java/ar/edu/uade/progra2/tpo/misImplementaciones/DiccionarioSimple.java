package ar.edu.uade.progra2.tpo.misImplementaciones;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioSimpleTDA;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	class Elem {
		int cl;
		Double dato;
	}

	Elem[] vector;
	int cant;

	@Override
	public void inicializarDiccionarioSimple() {
		cant = 0;
		vector = new Elem[100];
	}

	@Override
	public void agregar(int clave, Double valor) {

		int i = 0;
		while(i<cant && vector[i].cl != clave) {
			i+=1;
		}
		if (i==cant) {
			
			vector[i] = new Elem();
			vector[i].cl = clave;
			cant+=1;
		}
		vector[i].dato = valor;

	}

	@Override
	public void eliminar(int clave) {

		int i = 0;
		while(i<cant && vector[i].cl != clave) {
			i+=1;
		}
		if (i<cant) {
			vector[i] = vector[cant - 1];
			cant--;
		}

	}

	@Override
	public Double recuperar(int clave) {
		int i = 0;
		while(i<cant && vector[i].cl != clave) {
			i+=1;
		}
		return vector[i].dato;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();

		for (int i = 0; i < cant; i++) {
			c.agregar(vector[i].cl);
		}
		return c;
	}

	

}
