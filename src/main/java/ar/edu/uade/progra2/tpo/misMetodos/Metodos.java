package ar.edu.uade.progra2.tpo.misMetodos;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;

public class Metodos {

	/**
	 * @param diccionario
	 * @return
	 * @Tarea Cantidad de materias de cada una de las carreras
	 * @Par�metros Diccionario, Numero de carrera
	 * @Devuelve cantidad de materias
	 * @Precondici�n La carrera debe existir
	 * @Postcondici�n
	 * @Costo
	 **/
	public int cantidadMateriasPorCarrera(DiccionarioMultipleTDA diccionario, int nroCarrera) {
		ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
		int contadorMaterias = 0;
		while (!materias.conjuntoVacio()) {
			int codigoMateria = materias.elegir();
			materias.sacar(codigoMateria);
			contadorMaterias++;
		}
		return contadorMaterias;
	}

	/**
	 * @Tarea Porcentaje de materias de inform�tica en cada una de las carreras
	 *        (materias que comienzan con c�digo 34xxx)
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/
	public void porcentajeMateriasInformaticaPorCarrera(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA carreras = diccionario.claves();
		while (!carreras.conjuntoVacio()) {
			int contadorMateriasInformatica = 0;
			int contadorMaterias = 0;
			int nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
			while (!materias.conjuntoVacio()) {
				int codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				Matcher esMateriaDeInformatica = compile("^(34)([0-9]+)").matcher(valueOf(codigoMateria));
				if (esMateriaDeInformatica.matches()) {
					contadorMateriasInformatica++;
				}
				contadorMaterias++;
			}
			Double porcentaje = Double.valueOf(contadorMateriasInformatica) / Double.valueOf(contadorMaterias);
			System.out.printf("Carrera %d | Porcenaje materias informatica %.2f\n", nroCarrera, porcentaje);
		}
	}

	/**
	 * @Tarea Porcentaje de materias de ciencias b�sicas en cada una de las carreras
	 *        (materias que comienzan con c�digo 31xxx)
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/
	public void porcentajeMateriasCienciasBasicasPorCarrera(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA carreras = diccionario.claves();
		while (!carreras.conjuntoVacio()) {
			int contadorMateriasCienciasBasicas = 0;
			int contadorMaterias = 0;
			int nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
			while (!materias.conjuntoVacio()) {
				int codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				Matcher esMateriaDeCienciasBasicas = compile("^(31)([0-9]+)").matcher(valueOf(codigoMateria));
				if (esMateriaDeCienciasBasicas.matches()) {
					contadorMateriasCienciasBasicas++;
				}
				contadorMaterias++;
			}
			Double porcentaje = Double.valueOf(contadorMateriasCienciasBasicas) / Double.valueOf(contadorMaterias);
			System.out.printf("Carrera %d | Porcenaje materias de ciencias b�sicas %.2f\n", nroCarrera, porcentaje);
		}
	}

	/**
	 * @Tarea Porcentaje de materias de ciencias sociales en cada una de las
	 *        carreras (materias comienzan con c�digos 2xxxx y 33xxx)
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/
	public void porcentajeMateriasCienciasSocialesPorCarrera(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA carreras = diccionario.claves();
		while (!carreras.conjuntoVacio()) {
			int contadorMateriasCienciasSociales = 0;
			int contadorMaterias = 0;
			int nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
			while (!materias.conjuntoVacio()) {
				int codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				Matcher esMateriaDeCienciasSociales = compile("^(2)([0-9]+)").matcher(valueOf(codigoMateria));
				if (esMateriaDeCienciasSociales.matches()) {
					contadorMateriasCienciasSociales++;
				} else {
					esMateriaDeCienciasSociales = compile("^(33)([0-9]+)").matcher(valueOf(codigoMateria));
					if (esMateriaDeCienciasSociales.matches()) {
						contadorMateriasCienciasSociales++;
					}
				}
				contadorMaterias++;
			}
			Double porcentaje = Double.valueOf(contadorMateriasCienciasSociales) / Double.valueOf(contadorMaterias);
			System.out.printf("Carrera %d | Porcenaje materias de ciencias sociales %.2f\n", nroCarrera, porcentaje);
		}
	}

	/**
	 * @Tarea Cantidad de materias optativas de cada una de las carreras
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/
	public void cantidadOptativasPorCarrera(DiccionarioMultipleTDA diccionario, int nroCarrera) {

	}

	/**
	 * @Tarea Materias comunes a todas las carreras indicadas, ordenadas por c�digo
	 *        de materia (no incluir materias optativas)
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/

	// METODO

	/**
	 * @Tarea Carrera/s que incluyan m�s del 80% de las materias de otra carrera,
	 *        indicando las carreras relacionadas.
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/

	// METODO

	/**
	 * @Tarea Materias de cada carrera que no comparten con ninguna otra carrera,
	 *        ordenadas por // c�digo de materia, indicando la carrera a la que
	 *        pertenecen.
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/

	// METODO

	/**
	 * @Tarea Carrera/s que s�lo tengan el 20% de las materias de otra carrera,
	 *        indicando las // carreras relacionadas.
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/

	// METODO

	/**
	 * @Tarea Para cada combinaci�n de dos carreras, indicar materias no comunes.
	 * @Par�metros
	 * @Devuelve
	 * @Precondici�n
	 * @Postcondici�n
	 * @Costo
	 **/

	// METODO

}
