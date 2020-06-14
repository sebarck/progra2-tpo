package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ColaPrioridadTDA;
import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.ColaPrioridad;
import ar.edu.uade.progra2.tpo.misImplementaciones.Conjunto;

public class PuntoHJ {

	/**
	 * @Tarea Materias de cada carrera que no comparten con ninguna otra carrera,
	 *        ordenadas por codigo de materia, indicando la carrera a la que
	 *        pertenecen.
	 * @Parametros DiccionarioMultipleTDA diccionario
	 * @Devuelve ColaPrioridadTDA
	 * @Precondicion
	 * @Postcondicion
	 * @Costo 
	 **/

	// METODO
	
	public ColaPrioridadTDA materiasUnicasPorCarrera(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA carreras = diccionario.claves();
		ColaPrioridadTDA materiasUnicas = new ColaPrioridad();
		materiasUnicas.inicializarCola();
		while(!carreras.conjuntoVacio()) {
			int nroCarrera = carreras.elegir();
			ConjuntoTDA carrerasComparar = diccionario.claves();
			carrerasComparar.sacar(nroCarrera);
			ConjuntoTDA materiasComparar = new Conjunto();
			ConjuntoTDA unionMateriasAComparar = new Conjunto();
			while(!carrerasComparar.conjuntoVacio()) {
				int carrera = carrerasComparar.elegir();
				materiasComparar = diccionario.recuperar(carrera);
				unionMateriasAComparar = union(unionMateriasAComparar, materiasComparar);
				carrerasComparar.sacar(carrera);
			}
			ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
			
			ConjuntoTDA diferencia = diferencia(materias, unionMateriasAComparar);
			while(!diferencia.conjuntoVacio()) {
				materiasUnicas.acolarPrioridad(nroCarrera, diferencia.elegir());
				diferencia.sacar(diferencia.elegir());
			}
			carreras.sacar(nroCarrera);
		}
		return materiasUnicas;
	}
	

	/**
	 * @Tarea Para cada combinacion de dos carreras, indicar materias no comunes.
	 * @Parametros DiccionarioMultipleTDA diccionario, int nroCarrera, int nroCarrera2
	 * @Devuelve ConjuntoTDA
	 * @Precondicion Carreras existan
	 * @Postcondicion
	 * @Costo
	 **/

	// METODO

	public ConjuntoTDA materiasNoComunesEntre2Carreras(DiccionarioMultipleTDA diccionario, int nroCarrera, int nroCarrera2) {
		ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
		ConjuntoTDA materias2 = diccionario.recuperar(nroCarrera2);
		ConjuntoTDA diferencia = diferenciaSimetrica(materias, materias2);
		return diferencia;
		
	}

	
	private ConjuntoTDA diferencia(ConjuntoTDA c1, ConjuntoTDA c2) {
		int e;
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		while (!c1.conjuntoVacio()) {
			e = c1.elegir();
			if (c2.pertenece(e)) {
				c2.sacar(e);
			} else {
				conjunto.agregar(e);
			}
			c1.sacar(e);
		}
		return conjunto;
	}

	private ConjuntoTDA union(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		while (!c1.conjuntoVacio()) {
			conjunto.agregar(c1.elegir());
			c1.sacar(c1.elegir());
		}
		while (!c2.conjuntoVacio()) {
			conjunto.agregar(c2.elegir());
			c2.sacar(c2.elegir());
		}
		return conjunto;
	}
	
	private ConjuntoTDA diferenciaSimetrica(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		ConjuntoTDA conjuntoAux = new Conjunto();
		conjuntoAux.inicializarConjunto();
		ConjuntoTDA conjuntoAux2 = new Conjunto();
		conjuntoAux2.inicializarConjunto();

		copiarConjuntoConjunto(c1, conjuntoAux);
		copiarConjuntoConjunto(c2, conjuntoAux2);

		conjunto = diferencia(conjuntoAux, conjuntoAux2);

		ConjuntoTDA conjunto2 = new Conjunto();
		conjunto2.inicializarConjunto();
		conjunto2 = diferencia(c2, c1);

		ConjuntoTDA conjuntoFinal = new Conjunto();
		conjuntoFinal.inicializarConjunto();
		conjuntoFinal = union(conjunto, conjunto2);
		return conjuntoFinal;
	}
	
	private void pasarConjuntoConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
		int x;
		while (!origen.conjuntoVacio()) {
			x = origen.elegir();
			destino.agregar(x);
			origen.sacar(x);
		}
	}

	public void copiarConjuntoConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
		ConjuntoTDA aux;
		aux = new Conjunto();
		aux.inicializarConjunto();
		int x;
		pasarConjuntoConjunto(origen, aux);

		while (!aux.conjuntoVacio()) {
			x = aux.elegir();
			origen.agregar(x);
			destino.agregar(x);
			aux.sacar(x);
		}
	}


}
