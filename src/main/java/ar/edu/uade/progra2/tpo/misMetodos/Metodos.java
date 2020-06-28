
package ar.edu.uade.progra2.tpo.misMetodos;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;

import ar.edu.uade.progra2.tpo.miApi.ColaPrioridadTDA;
import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioSimpleTDA;
import ar.edu.uade.progra2.tpo.miApi.GrafoTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.ColaPrioridad;
import ar.edu.uade.progra2.tpo.misImplementaciones.Conjunto;
import ar.edu.uade.progra2.tpo.misImplementaciones.DiccionarioMultiple;
import ar.edu.uade.progra2.tpo.misImplementaciones.DiccionarioSimple;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa
 *          Ignacio Javier
 * @grupo 18
 **/
public class Metodos {

	/**
	 * @Tarea Cantidad de materias de cada una de las carreras
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar int
	 *             nroCarrera Numero de carrera de la cual se desea saber cantidad
	 *             de materias
	 * @Devuelve int Cantidad de materias por carrera
	 * @Precondicion La carrera debe existir
	 * @Postcondicion
	 * @Costo
	 **/
	public int cantidadMateriasPorCarrera(DiccionarioMultipleTDA diccionario, int nroCarrera) {
		ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
		int contadorMaterias = 0;
		int codigoMateria;
		while (!materias.conjuntoVacio()) {
			codigoMateria = materias.elegir();
			materias.sacar(codigoMateria);
			contadorMaterias++;
		}
		return contadorMaterias;
	}

	/**
	 * @Tarea Porcentaje de materias de informática en cada una de las carreras
	 *        (materias que comienzan con código 34xxx)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve DiccionarioSimpleTDA con el porcentaje de materias de informática
	 *           en cada una de las carreras
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/
	public DiccionarioSimpleTDA porcentajeMateriasInformaticaPorCarrera(DiccionarioMultipleTDA diccionario) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		resultado.inicializarDiccionarioSimple();
		resultado = porcentajeMaterias(diccionario, "^(34)([0-9]+)");
		return resultado;
	}

	/**
	 * @Tarea Porcentaje de materias de ciencias basicas en cada una de las carreras
	 *        (materias que comienzan con codigo 31xxx)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve DiccionarioSimpleTDA con el porcentaje de materias de ciencias
	 *           basicas en cada una de las carreras
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/
	public DiccionarioSimpleTDA porcentajeMateriasCienciasBasicasPorCarrera(DiccionarioMultipleTDA diccionario) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		resultado.inicializarDiccionarioSimple();
		resultado = porcentajeMaterias(diccionario, "^(31)([0-9]+)");
		return resultado;
	}

	/**
	 * @Tarea Porcentaje de materias de ciencias sociales en cada una de las
	 *        carreras (materias comienzan con codigos 2xxxx y 33xxx)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve DiccionarioSimpleTDA con el porcentaje de materias de ciencias
	 *           basicas en cada una de las carreras
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/
	public DiccionarioSimpleTDA porcentajeMateriasCienciasSocialesPorCarrera(DiccionarioMultipleTDA diccionario) {
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		resultado.inicializarDiccionarioSimple();
		resultado = porcentajeMaterias(diccionario, "^(2|33)([0-9]+)");
		return resultado;
	}

	/**
	 * @Tarea Cantidad de materias optativas de cada una de las carreras
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar int
	 *             nroCarrera Numero de carrera de la cual se desea saber cantidad
	 *             de materias
	 * @Devuelve cantidad de materias optativas de cada una de las carreras
	 * @Precondicion Diccionario inicializado y con csv cargado
	 * @Postcondicion
	 * @Costo
	 **/
	public DiccionarioSimpleTDA calcularCantidadOptativasPorCarrera(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA carreras = diccionario.claves();
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		resultado.inicializarDiccionarioSimple();
		int cantidadOptativas = 0, codigoMateria, nroCarrera = 0;
		ConjuntoTDA materias;
		Matcher esOptativa;
		while (!carreras.conjuntoVacio()) {
			cantidadOptativas = 0;
			nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			materias = diccionario.recuperar(nroCarrera);

			while (!materias.conjuntoVacio() && cantidadOptativas == 0) {
				codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				// Aca evaluo que haya UNA sola ocurrencia del 0 al 9 en la linea
				// Asumimos que los codigos de materias cuando hay optativas van del 0 al 9
				esOptativa = compile("[0-9]").matcher(valueOf(codigoMateria));
				// Aca asumimos que la cantidad de optativas sale del codigo de materia
				// dado que vimos que los valores coinciden
				cantidadOptativas = (esOptativa.matches()) ? codigoMateria : cantidadOptativas;
			}
			resultado.agregar(nroCarrera, Double.valueOf(cantidadOptativas));
		}
		return resultado;
	}

	/**
	 * @Tarea Materias comunes a todas las carreras indicadas, ordenadas por codigo
	 *        de materia (no incluir materias optativas)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve materias comunes a todas las carreras indicadas, ordenadas por
	 *           codigo de materia
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/

	public void materiasComunes(DiccionarioMultipleTDA diccionario) {
		DiccionarioMultipleTDA diccionarioComunes = new DiccionarioMultiple();
		diccionarioComunes.inicializarDiccionarioMultiple();

		ConjuntoTDA carreras = diccionario.claves();
		int i = 1;
		while (!carreras.conjuntoVacio()) {
			int nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			ConjuntoTDA materias = diccionario.recuperar(nroCarrera);

			while (!materias.conjuntoVacio()) {
				int codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				diccionarioComunes.agregar(codigoMateria, i);

			}
			i++;
		}

		carreras = diccionario.claves();
		while (!carreras.conjuntoVacio()) {
			int nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
			while (!materias.conjuntoVacio()) {
				int nroMateria = materias.elegir();
				materias.sacar(nroMateria);
				ConjuntoTDA repeticiones = diccionarioComunes.recuperar(nroMateria);

				for (int j = i - 1; j >= 1; j--) {
					if (!repeticiones.pertenece(j)) {
						diccionarioComunes.eliminar(nroMateria);
					}
				}
			}

		}

		ConjuntoTDA resultado = diccionarioComunes.claves();
		ConjuntoTDA resultado2 = diccionarioComunes.claves();
		if (resultado.conjuntoVacio()) {
			System.out.println("No hay materias comunes en las carreras indicadas.");
		} else {
			System.out.println("\n");
			System.out.println(
					"Los siguientes codigos corresponden a las materias comunes de todas las carreras indicadas: ");
			int mayor = 0;
			while (!resultado.conjuntoVacio()) {
				mayor = 0;
				while (!resultado2.conjuntoVacio()) {
					int nro2 = resultado2.elegir();
					if (nro2 > mayor) {
						mayor = nro2;
					}
					resultado2.sacar(nro2);
				}
				System.out.println("Codigo de linea: " + mayor);
				diccionarioComunes.eliminar(mayor);
				resultado = diccionarioComunes.claves();
				resultado2 = diccionarioComunes.claves();
			}
		}

	}

	/**
	 * @Tarea Mostrar aquellas carreras que tengan mas de 80% de materias iguales
	 *        entre si.
	 * @Parametros DiccionarioMultipleTDA diccionario
	 * @Devuelve
	 * @Precondicion Diccionario inicializado y con csv cargado
	 * @Postcondicion
	 * @Costo
	 **/

	public void crearCombinacionesComparar80Porciento(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA conjunto = diccionario.claves();
		String mensajePorcentajeIguales = " hay mas de un 80% de materias de coincidencia de materias";

		while (!conjunto.conjuntoVacio()) {
			int carrera = conjunto.elegir();
			conjunto.sacar(carrera);

			ConjuntoTDA conjuntoAux = new Conjunto();
			conjuntoAux.inicializarConjunto();

			copiarConjuntoConjunto(conjunto, conjuntoAux);

			while (!conjuntoAux.conjuntoVacio()) {
				int carreraAux = conjuntoAux.elegir();
				conjuntoAux.sacar(carreraAux);

				Double porcentajeCantidadIguales = calcularPorcentajeMateriasIguales(carrera, carreraAux, diccionario);

				if (porcentajeCantidadIguales >= 80) {
					System.out.println(
							"Entre la carrera " + carrera + " y la carrera " + carreraAux + mensajePorcentajeIguales);
				}
			}
		}
	}

	// METODO

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

	public ColaPrioridadTDA materiasUnicasPorCarrera(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA carreras = diccionario.claves();
		ColaPrioridadTDA materiasUnicas = new ColaPrioridad();
		materiasUnicas.inicializarCola();
		int nroCarrera, carrera;
		ConjuntoTDA materiasComparar, carrerasComparar, diferencia, materias, unionMateriasAComparar = new Conjunto();
		while (!carreras.conjuntoVacio()) {
			nroCarrera = carreras.elegir();
			carrerasComparar = diccionario.claves();
			carrerasComparar.sacar(nroCarrera);
			vaciarConjunto(unionMateriasAComparar);
			while (!carrerasComparar.conjuntoVacio()) {
				carrera = carrerasComparar.elegir();
				materiasComparar = diccionario.recuperar(carrera);
				unionMateriasAComparar = union(unionMateriasAComparar, materiasComparar);
				carrerasComparar.sacar(carrera);
			}
			materias = diccionario.recuperar(nroCarrera);

			diferencia = diferencia(materias, unionMateriasAComparar);
			while (!diferencia.conjuntoVacio()) {
				materiasUnicas.acolarPrioridad(nroCarrera, diferencia.elegir());
				diferencia.sacar(diferencia.elegir());
			}
			carreras.sacar(nroCarrera);
		}
		return materiasUnicas;
	}

	/**
	 * @Tarea Mostrar aquellas carreras que tengan menos de 20% de materias iguales
	 *        entre si.
	 * @Parametros DiccionarioMultipleTDA diccionario
	 * @Devuelve
	 * @Precondicion Diccionario inicializado y con csv cargado
	 * @Postcondicion
	 * @Costo
	 **/

	public void crearCombinacionesComparar20Porciento(DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA conjunto = diccionario.claves();
		String mensajePorcentajeIguales = " hay menos de un 20% de materias de coincidencia de materias";
		int carrera;
		ConjuntoTDA conjuntoAux = new Conjunto();
		conjuntoAux.inicializarConjunto();
		while (!conjunto.conjuntoVacio()) {
			carrera = conjunto.elegir();
			conjunto.sacar(carrera);
			copiarConjuntoConjunto(conjunto, conjuntoAux);

			while (!conjuntoAux.conjuntoVacio()) {
				int carreraAux = conjuntoAux.elegir();
				conjuntoAux.sacar(carreraAux);

				Double porcentajeCantidadIguales = calcularPorcentajeMateriasIguales(carrera, carreraAux, diccionario);

				if (porcentajeCantidadIguales <= 20) {
					System.out.println(
							"Entre la carrera " + carrera + " y la carrera " + carreraAux + mensajePorcentajeIguales);
				}
			}
		}
	}

	/**
	 * @Tarea Para cada combinacion de dos carreras, indicar materias no comunes.
	 * @Parametros DiccionarioMultipleTDA diccionario, int nroCarrera, int
	 *             nroCarrera2
	 * @Devuelve ConjuntoTDA
	 * @Precondicion Carreras existan
	 * @Postcondicion
	 * @Costo
	 **/

	public ConjuntoTDA materiasNoComunesEntre2Carreras(DiccionarioMultipleTDA diccionario, int nroCarrera,
			int nroCarrera2) {
		ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
		ConjuntoTDA materias2 = diccionario.recuperar(nroCarrera2);
		ConjuntoTDA diferencia = diferenciaSimetrica(materias, materias2);
		return diferencia;

	}

	/**
	 * @Tarea Informar la/s materia/s con mayor cantidad de correlativas precedentes
	 *        inmediatas, ordenadas por código.
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/
	public ColaPrioridadTDA materiasMaxCorrelativasPrecedentes(GrafoTDA grafo) {

		ColaPrioridadTDA colaCorrelativasPrecedentes = new ColaPrioridad();
		colaCorrelativasPrecedentes.inicializarCola();
		ColaPrioridadTDA colaMayorPrioridad = new ColaPrioridad();
		colaMayorPrioridad.inicializarCola();
		ConjuntoTDA vertices = grafo.vertices();
		int vertice;
		while (!vertices.conjuntoVacio()) {
			vertice = vertices.elegir();
			colaCorrelativasPrecedentes.acolarPrioridad(vertice, cantidadVerticesAdyacentes(grafo, vertice));
			vertices.sacar(vertice);
		}
		int max = colaCorrelativasPrecedentes.prioridad();
		int i = 0;
		while (!colaCorrelativasPrecedentes.colaVacia() && i != 1) {
			if (colaCorrelativasPrecedentes.prioridad() == max) {
				colaMayorPrioridad.acolarPrioridad(max, colaCorrelativasPrecedentes.primero());
			} else {
				i = 1;
			}
			colaCorrelativasPrecedentes.desacolar();
		}

		return colaMayorPrioridad;

	}

	/**
	 * @Tarea Informar la/s materia/s con mayor cantidad de correlativas
	 *        subsiguientes inmediatas.
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/
	
	public ColaPrioridadTDA materiasMayorCantCorrelativasSubsiguientes(GrafoTDA grafo) {
		ColaPrioridadTDA colaCorrelativasSubsiguientes = new ColaPrioridad();
		colaCorrelativasSubsiguientes.inicializarCola();
		ColaPrioridadTDA colaMayorPrioridad = new ColaPrioridad();
		colaMayorPrioridad.inicializarCola();
		ConjuntoTDA vertices = grafo.vertices();
		int vertice;
		while (!vertices.conjuntoVacio()) {
			vertice = vertices.elegir();
			colaCorrelativasSubsiguientes.acolarPrioridad(vertice, cantidadVerticesSubsiguientes(grafo, vertice));
			vertices.sacar(vertice);
		}
		int max = colaCorrelativasSubsiguientes.prioridad();
		int i = 0;
		while (!colaCorrelativasSubsiguientes.colaVacia() && i != 1) {
			if (colaCorrelativasSubsiguientes.prioridad() == max) {
				colaMayorPrioridad.acolarPrioridad(max, colaCorrelativasSubsiguientes.primero());
			} else {
				i = 1;
			}
			colaCorrelativasSubsiguientes.desacolar();
		}

		return colaMayorPrioridad;
	}
	
	
	/**
	 * @Tarea Porcentaje de materias que no tienen correlativas precedentes ni
	 *        subsiguientes.
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 * @Costo
	 **/

	public Double porcentajeMateriasSinCorrelativas(GrafoTDA grafo) {
		Double porcentaje;
		ConjuntoTDA vertices = grafo.vertices();
		int vertice, cantVerticesTotal = 0, cantVerticesAislados = 0;
		while(!vertices.conjuntoVacio()) {
			vertice = vertices.elegir();
			if(!tieneCorrelativas(vertice, grafo)) {
				cantVerticesAislados++;
			}
			vertices.sacar(vertice);
			cantVerticesTotal++;
		}
		porcentaje = (Double.valueOf(cantVerticesAislados) / Double.valueOf(cantVerticesTotal))* 100;
		return porcentaje;
	}

	private boolean tieneCorrelativas(int vertice, GrafoTDA grafo) {
		ConjuntoTDA vertices = grafo.vertices();
		int v2;
		boolean tieneCorrelativas = false;
		if (vertices.pertenece(vertice)) {
			while (!vertices.conjuntoVacio()) {
				v2 = vertices.elegir();
				if (grafo.existeArista(vertice, v2) || grafo.existeArista(v2,vertice)) {
					tieneCorrelativas = true;
				}
				vertices.sacar(v2);
			}
		}
		return tieneCorrelativas;
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

	private DiccionarioSimpleTDA porcentajeMaterias(DiccionarioMultipleTDA diccionario, String prefijoMateria) {
		ConjuntoTDA carreras = diccionario.claves();
		DiccionarioSimpleTDA resultado = new DiccionarioSimple();
		resultado.inicializarDiccionarioSimple();
		int contadorMaterias = 0;
		int totalMaterias = 0;
		int nroCarrera;
		ConjuntoTDA materias;
		int codigoMateria;
		Double porcentaje;
		while (!carreras.conjuntoVacio()) {
			contadorMaterias = 0;
			totalMaterias = 0;
			nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			materias = diccionario.recuperar(nroCarrera);
			while (!materias.conjuntoVacio()) {
				codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				Matcher esMateria = compile(prefijoMateria).matcher(valueOf(codigoMateria));
				if (esMateria.matches()) {
					contadorMaterias++;
				}
				totalMaterias++;
			}
			porcentaje = (Double.valueOf(contadorMaterias) / Double.valueOf(totalMaterias))* 100;
			resultado.agregar(nroCarrera, porcentaje);
		}
		return resultado;
	}

	private Double calcularPorcentajeMateriasIguales(int carrera, int carreraAux, DiccionarioMultipleTDA diccionario) {
		ConjuntoTDA materiasCarrera = diccionario.recuperar(carrera);
		ConjuntoTDA materiasCarreraAux = diccionario.recuperar(carreraAux);
		int contadorMateriasCarrera = 0;
		int materiasIguales = 0;

		while (!materiasCarrera.conjuntoVacio()) {
			int materiaCarrera = materiasCarrera.elegir();
			materiasCarrera.sacar(materiaCarrera);

			if (materiasCarreraAux.pertenece(materiaCarrera)) {
				materiasIguales++;
			}

			contadorMateriasCarrera++;
		}

		return (Double.valueOf((materiasIguales * 100)) / Double.valueOf(contadorMateriasCarrera));
	}

	private void vaciarConjunto(ConjuntoTDA conjunto) {
		while (!conjunto.conjuntoVacio()) {
			conjunto.agregar(conjunto.elegir());
			conjunto.sacar(conjunto.elegir());
		}

	}

	private int cantidadVerticesAdyacentes(GrafoTDA grafo, int v) {
		int cantidad = 0;
		ConjuntoTDA vertices = grafo.vertices();
		int v2;
		if (vertices.pertenece(v)) {
			while (!vertices.conjuntoVacio()) {
				v2 = vertices.elegir();
				if (grafo.existeArista(v, v2)) {
					cantidad++;
				}
				vertices.sacar(v2);
			}
		}
		return cantidad;
	}
	
	private int cantidadVerticesSubsiguientes(GrafoTDA grafo, int v) {
		int cantidad = 0;
		ConjuntoTDA vertices = grafo.vertices();
		int v2;
		if (vertices.pertenece(v)) {
			while (!vertices.conjuntoVacio()) {
				v2 = vertices.elegir();
				if (grafo.existeArista(v2, v)) {
					cantidad++;
				}
				vertices.sacar(v2);
			}
		}
		return cantidad;
	}

}
