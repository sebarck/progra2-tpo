package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ColaPrioridadTDA;
import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.ColaPrioridad;
import ar.edu.uade.progra2.tpo.misImplementaciones.Conjunto;

public class PuntoH {

	/**
	 * @return 
	 * @Tarea Materias de cada carrera que no comparten con ninguna otra carrera,
	 *        ordenadas por código de materia, indicando la carrera a la que
	 *        pertenecen.
	 * @Parámetros
	 * @Devuelve
	 * @Precondición
	 * @Postcondición
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
}
