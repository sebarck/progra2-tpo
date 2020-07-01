
package ar.edu.uade.progra2.tpo.misMetodos;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;

import ar.edu.uade.progra2.tpo.miApi.ColaPrioridadTDA;
import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
import ar.edu.uade.progra2.tpo.miApi.GrafoTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.ColaPrioridad;
import ar.edu.uade.progra2.tpo.misImplementaciones.Conjunto;
import ar.edu.uade.progra2.tpo.misImplementaciones.DiccionarioMultiple;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa
 *          Ignacio Javier
 * @grupo 18
 **/
public class Metodos {

	/**
	 * @Tarea Cantidad de materias de cada una de las carreras
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar int
	 *             nroCarrera
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Cantidad de materias por carrera impresas.
	 * @Costo Temporal Cuadratico // Costo espacial: 2
	 **/

	public void cantidadMateriasPorCarrera(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto a : ");
		System.out.println("Cantidad de materias por carrera:");
		ConjuntoTDA carreras = diccionario.claves();
		int carrera;
		int contadorMaterias = 0;
		int codigoMateria;
		ConjuntoTDA materias;
		while (!carreras.conjuntoVacio()) {
			contadorMaterias = 0;
			carrera = carreras.elegir();
			materias = diccionario.recuperar(carrera);
			while (!materias.conjuntoVacio()) {
				codigoMateria = materias.elegir();
				materias.sacar(codigoMateria);
				contadorMaterias++;
			}
			System.out.println("La carrera " + carrera + " tiene " + contadorMaterias + " materias.");
			carreras.sacar(carrera);
		}
	}

	/**
	 * @Tarea Porcentaje de materias de informática en cada una de las carreras
	 *        (materias que comienzan con código 34xxx)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime porcentaje de materias de informatica por carrera.
	 * @Costo Cuadrático // Costo espacial: 2
	 **/
	public void porcentajeMateriasInformaticaPorCarrera(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto b: ");
		System.out.println("Porcentaje de materias de Informatica por Carrera:");
		porcentajeMaterias(diccionario, "^(34)([0-9]+)");
	}

	/**
	 * @Tarea Porcentaje de materias de ciencias basicas en cada una de las carreras
	 *        (materias que comienzan con codigo 31xxx)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime porcentaje de materias de ciencias basicas por
	 *                carrera.
	 * @Costo Cuadrático // Costo espacial: 2
	 **/
	public void porcentajeMateriasCienciasBasicasPorCarrera(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto c: ");
		System.out.println("Porcentaje de materias de Ciencias Basicas por Carrera:");
		porcentajeMaterias(diccionario, "^(31)([0-9]+)");
	}

	/**
	 * @Tarea Porcentaje de materias de ciencias sociales en cada una de las
	 *        carreras (materias comienzan con codigos 2xxxx y 33xxx)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime porcentaje de materias de ciencias sociales por
	 *                carrera.
	 * @Costo Cuadrático // Costo espacial: 2
	 **/
	public void porcentajeMateriasCienciasSocialesPorCarrera(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto d: ");
		System.out.println("Porcentaje de materias de Ciencias Sociales por Carrera:");
		porcentajeMaterias(diccionario, "^(2|33)([0-9]+)");
	}

	/**
	 * @Tarea Cantidad de materias optativas de cada una de las carreras
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar.
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime cantidad de materias optativas de cada una de las
	 *                carreras.
	 * @Costo Cuadrático // Costo espacial: 2
	 **/

	public void calcularCantidadOptativasPorCarrera(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto e : ");
		ConjuntoTDA carreras = diccionario.claves();
		int cantidadOptativas = 0, codigoMateria, nroCarrera = 0;
		String codigoCarrera, stringMateria;
		ConjuntoTDA materias;
		Matcher esOptativa;
		System.out.println("Cantidad de optativas por carrera : ");
		while (!carreras.conjuntoVacio()) {
			cantidadOptativas = 0;
			nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			materias = diccionario.recuperar(nroCarrera);
			codigoCarrera = "El codigo de carrera " + nroCarrera;
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

			if (cantidadOptativas > 0) {
				// Simplemente para que quede lindo en caso de que la cantidad sea 1
				stringMateria = (cantidadOptativas == 1) ? " materia optativa" : " materias optativas.";

				System.out.println(codigoCarrera + " posee " + cantidadOptativas + stringMateria);
			} else {
				System.out.println(codigoCarrera + " no posee materias optativas.");
			}
		}
	}

	/**
	 * @Tarea Materias comunes a todas las carreras indicadas, ordenadas por codigo
	 *        de materia (no incluir materias optativas)
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime materias comunes a todas las carreras indicadas,
	 *                ordenadas por codigo de materia
	 * @Costo Cuadrático * 3 // Costo espacial: 5
	 **/

	public void materiasComunes(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto f : ");
		DiccionarioMultipleTDA diccionarioComunes = new DiccionarioMultiple();
		diccionarioComunes.inicializarDiccionarioMultiple();
		ConjuntoTDA materias, repeticiones, resultado, resultado2;

		ConjuntoTDA carreras = diccionario.claves();
		int i = 1;
		while (!carreras.conjuntoVacio()) {
			int nroCarrera = carreras.elegir();
			carreras.sacar(nroCarrera);
			materias = diccionario.recuperar(nroCarrera);

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
			materias = diccionario.recuperar(nroCarrera);
			while (!materias.conjuntoVacio()) {
				int nroMateria = materias.elegir();
				materias.sacar(nroMateria);
				repeticiones = diccionarioComunes.recuperar(nroMateria);

				for (int j = i - 1; j >= 1; j--) {
					if (!repeticiones.pertenece(j)) {
						diccionarioComunes.eliminar(nroMateria);
					}
				}
			}

		}

		resultado = diccionarioComunes.claves();
		resultado2 = diccionarioComunes.claves();
		if (resultado.conjuntoVacio()) {
			System.out.println("No hay materias comunes en las carreras indicadas.");
		} else {
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
				System.out.println("Codigo de materia: " + mayor);
				diccionarioComunes.eliminar(mayor);
				resultado = diccionarioComunes.claves();
				resultado2 = diccionarioComunes.claves();
			}
		}

	}

	/**
	 * @Tarea Mostrar aquellas carreras que tengan mas de 80% de materias iguales
	 *        entre si.
	 * @Parametros DiccionarioMultipleTDA diccionario que se desea analizar
	 * @Devuelve
	 * @Precondicion El diccionario debe estar inicializado
	 * @Postcondicion Imprime aquellas carreras que tienen mas de 80% de materias
	 *                iguales entre si.
	 * @Costo Cubico // Costo espacial: 5
	 **/

	public void crearCombinacionesComparar80Porciento(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto g : ");
		System.out.println("Carreras que tienen mas de 80% de materias iguales entre si.");
		ConjuntoTDA conjunto = diccionario.claves();
		int carrera, carrera2, nromaterias, materiascomunes, materia;
		nromaterias = 0;
		materiascomunes = 0;
		ConjuntoTDA materias, materiasAux, materiasAux2, conjuntoAux;
		conjuntoAux = new Conjunto();
		while (!conjunto.conjuntoVacio()) {
			carrera = conjunto.elegir();
			conjunto.sacar(carrera);
			conjuntoAux.inicializarConjunto();
			copiarConjuntoConjunto(conjunto, conjuntoAux);
			while (!conjuntoAux.conjuntoVacio()) {
				carrera2 = conjuntoAux.elegir();
				conjuntoAux.sacar(carrera2);
				materias = diccionario.recuperar(carrera);
				materiasAux = diccionario.recuperar(carrera2);
				materiasAux2 = diccionario.recuperar(carrera);
				while (!materias.conjuntoVacio()) {
					materia = materias.elegir();
					materias.sacar(materia);
					nromaterias++;
					if (materiasAux.pertenece(materia)) {
						materiascomunes++;
					}

				}
				if ((materiascomunes * 100) / nromaterias > 80) {
					System.out.println("La carrera nro " + carrera
							+ " tiene un 80% o mas de materias comunes con la carrera nro " + carrera2);
				}
				nromaterias = 0;
				materiascomunes = 0;
				while (!materiasAux.conjuntoVacio()) {
					try {
						materia = materiasAux.elegir();
						materiasAux.sacar(materia);
						nromaterias++;
						if (materiasAux2.pertenece(materia)) {
							materiascomunes++;
						}
					} catch (Exception e) {

					}
				}
				if ((materiascomunes * 100) / nromaterias > 80) {
					System.out.println("La carrera nro " + carrera2
							+ " tiene un 80% o mas de materias comunes con la carrera nro " + carrera);
				}
			}
		}
	}

	/**
	 * @Tarea Materias de cada carrera que no comparten con ninguna otra carrera,
	 *        ordenadas por codigo de materia, indicando la carrera a la que
	 *        pertenecen.
	 * @Parametros DiccionarioMultipleTDA diccionario
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime materias de cada carrera que no comparten con ninguna
	 *                otra carrera, ordenadas por codigo de materia
	 * @Costo Cuadratico // Costo espacial: 9
	 **/

	public void materiasUnicasPorCarrera(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto h: ");
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
		System.out.println("Materias de cada carrera que no comparten con ninguna otra carrera:");
		while (!materiasUnicas.colaVacia()) {
			System.out.println(
					"Codigo materia: " + materiasUnicas.prioridad() + " - Carrera: " + materiasUnicas.primero());
			materiasUnicas.desacolar();
		}
	}

	/**
	 * @Tarea Mostrar aquellas carreras que tengan menos de 20% de materias iguales
	 *        entre si.
	 * @Parametros DiccionarioMultipleTDA diccionario
	 * @Devuelve
	 * @Precondicion Diccionario inicializado y con csv cargado
	 * @Postcondicion Imprime aquellas carreras que tengan menos de 20% de materias
	 *                iguales entre si.
	 * @Costo Cubico // Costo espacial: 5
	 **/
	public void crearCombinacionesComparar20Porciento(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto i: ");
		System.out.println("Carreras que tienen menos de 20% de materias iguales entre si.");
		ConjuntoTDA conjunto = diccionario.claves();
		int carrera, carrera2, nromaterias, materiascomunes, materia;
		nromaterias = 0;
		materiascomunes = 0;
		ConjuntoTDA materias, materiasAux, materiasAux2, conjuntoAux;
		conjuntoAux = new Conjunto();
		while (!conjunto.conjuntoVacio()) {
			carrera = conjunto.elegir();
			conjunto.sacar(carrera);
			conjuntoAux.inicializarConjunto();
			copiarConjuntoConjunto(conjunto, conjuntoAux);
			while (!conjuntoAux.conjuntoVacio()) {
				carrera2 = conjuntoAux.elegir();
				conjuntoAux.sacar(carrera2);
				materias = diccionario.recuperar(carrera);
				materiasAux = diccionario.recuperar(carrera2);
				materiasAux2 = diccionario.recuperar(carrera);
				while (!materias.conjuntoVacio()) {
					materia = materias.elegir();
					materias.sacar(materia);
					nromaterias++;
					if (materiasAux.pertenece(materia)) {
						materiascomunes++;
					}

				}
				if ((materiascomunes * 100) / nromaterias < 20) {
					System.out.println("La carrera nro " + carrera
							+ " tiene un 20% o menos de materias comunes con la carrera nro " + carrera2);
				}
				nromaterias = 0;
				materiascomunes = 0;
				while (!materiasAux.conjuntoVacio()) {
					try {
						materia = materiasAux.elegir();
						materiasAux.sacar(materia);
						nromaterias++;
						if (materiasAux2.pertenece(materia)) {
							materiascomunes++;
						}
					} catch (Exception e) {

					}
				}
				if ((materiascomunes * 100) / nromaterias < 20) {
					System.out.println("La carrera nro " + carrera2
							+ " tiene un 20% o menos de materias comunes con la carrera nro " + carrera);
				}
			}
		}

	}

	/**
	 * @Tarea Para cada combinacion de dos carreras, indicar materias no comunes.
	 * @Parametros DiccionarioMultipleTDA diccionario
	 * @Devuelve
	 * @Precondicion Diccionario inicializado.
	 * @Postcondicion Imprime las materias no comunes entre dos carreras.
	 * @Costo Cubico // Costo espacial: 16
	 **/

	public void materiasNoComunesEntre2Carreras(DiccionarioMultipleTDA diccionario) {
		System.out.println("\nPunto j: ");
		System.out.println("Materias no comunes para cada combinacion de dos carreras:");
		ConjuntoTDA conjunto = diccionario.claves();
		int carrera2, carrera;
		ConjuntoTDA conjuntoAux = new Conjunto();
		conjuntoAux.inicializarConjunto();
		ConjuntoTDA diferencia;
		ConjuntoTDA materias;
		ConjuntoTDA materias2;
		while (!conjunto.conjuntoVacio()) {
			carrera = conjunto.elegir();
			conjunto.sacar(carrera);
			copiarConjuntoConjunto(conjunto, conjuntoAux);
			while (!conjuntoAux.conjuntoVacio()) {
				carrera2 = conjuntoAux.elegir();
				System.out.println("\nLas materias no comunes entre la carrera " + carrera + " y la carrera " + carrera2
						+ " son: ");
				materias = diccionario.recuperar(carrera);
				materias2 = diccionario.recuperar(carrera2);
				diferencia = diferenciaSimetrica(materias, materias2);
				while (!diferencia.conjuntoVacio()) {
					System.out.println("Codigo materia " + diferencia.elegir());
					diferencia.sacar(diferencia.elegir());
				}
				conjuntoAux.sacar(carrera2);
			}
		}
	}

	/**
	 * @Tarea Informar la/s materia/s con mayor cantidad de correlativas precedentes
	 *        inmediatas, ordenadas por código.
	 * @Parametros GrafoTDA grafo
	 * @Devuelve
	 * @Precondicion El grafo debe estar inicializado
	 * @Postcondicion Imprime la/s materia/s con mayor cantidad de correlativas
	 *                precedentes inmediatas, ordenadas por código.
	 * @Costo Lineal  // Costo espacial: 4
	 **/

	public void materiasMaxCorrelativasPrecedentes(GrafoTDA grafo) {
		System.out.println("\nPunto b-1");
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

		System.out.println("\nLa/s materia/s con mayor cantidad de correlativas precedentes inmediatas son: ");
		while (!colaMayorPrioridad.colaVacia()) {
			System.out.println("Materia: " + colaMayorPrioridad.prioridad()
					+ "|| Cantidad de correlativas precedentes: " + colaMayorPrioridad.primero());
			colaMayorPrioridad.desacolar();
		}

	}

	/**
	 * @Tarea Informar la/s materia/s con mayor cantidad de correlativas
	 *        subsiguientes inmediatas.
	 * @Parametros GrafoTDA grafo
	 * @Devuelve
	 * @Precondicion El grafo debe de estar inicializado
	 * @Postcondicion Imprimira en pantalla las materias con mayor cantidad de
	 *                correlativas.
	 * @Costo Lineal// Costo espacial: 4
	 **/

	public void materiasMayorCantCorrelativasSubsiguientes(GrafoTDA grafo) {
		System.out.println("\nPunto b-2");
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

		System.out.println("\nLa/s materia/s con mayor cantidad de correlativas subsiguientes inmediatas son: ");

		while (!colaMayorPrioridad.colaVacia()) {
			System.out.println("Materia: " + colaMayorPrioridad.prioridad()
					+ "|| Cantidad de correlativas subsiguientes: " + colaMayorPrioridad.primero());
			colaMayorPrioridad.desacolar();
		}
	}

	/**
	 * @Tarea Porcentaje de materias que no tienen correlativas precedentes ni
	 *        subsiguientes.
	 * @Parametros GrafoTDA grafo
	 * @Devuelve
	 * @Precondicion El grafo debe de estar inicializado
	 * @Postcondicion debe imprimir el porcentaje de materias tienen correlativas
	 *                precedentes ni subsiguientes.
	 * @Costo Lineal // Costo espacial: 2
	 **/

	public void porcentajeMateriasSinCorrelativas(GrafoTDA grafo) {
		System.out.println("\nPunto b-3");
		Double porcentaje;
		ConjuntoTDA vertices = grafo.vertices();
		int vertice, cantVerticesTotal = 0, cantVerticesAislados = 0;
		while (!vertices.conjuntoVacio()) {
			vertice = vertices.elegir();
			if (!tieneCorrelativas(vertice, grafo)) {
				cantVerticesAislados++;
			}
			vertices.sacar(vertice);
			cantVerticesTotal++;
		}
		porcentaje = (Double.valueOf(cantVerticesAislados) / Double.valueOf(cantVerticesTotal)) * 100;
		System.out.println("\nEl porcentaje de materias que no tienen correlativas precedentes ni subsiguientes son : "
				+ porcentaje + "%");
	}

	/**
	 * @Tarea retorna un booleano indicando
	 * @Parametros int vertice, GrafoTDA grafo
	 * @Devuelve boolean tieneCorrelativas
	 * @Precondicion El grafo debe estar inicializado
	 * @Postcondicion Devuelve true or false si la materia tiene correlativas o no.
	 * @Costo Lineal// Costo espacial: 1
	 **/
	private boolean tieneCorrelativas(int vertice, GrafoTDA grafo) {
		ConjuntoTDA vertices = grafo.vertices();
		int v2;
		boolean tieneCorrelativas = false;
		if (vertices.pertenece(vertice)) {
			while (!vertices.conjuntoVacio()) {
				v2 = vertices.elegir();
				if (grafo.existeArista(vertice, v2) || grafo.existeArista(v2, vertice)) {
					tieneCorrelativas = true;
				}
				vertices.sacar(v2);
			}
		}
		return tieneCorrelativas;
	}

	/**
	 * @Tarea Devuelve la diferencia entre 2 conjuntos
	 * @Parametros ConjuntoTDA c1, ConjuntoTDA c2
	 * @Devuelve ConjuntoTDA conjunto (el resultado de la diferencia)
	 * @Precondicion Los conjuntos deben estar inicializados
	 * @Postcondicion Devuelve la diferencia entre dos conjuntos.
	 * @Costo Lineal // Costo espacial: 1
	 **/
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

	/**
	 * @Tarea Realiza la union entre dos conjuntos.
	 * @Parametros ConjuntoTDA c1, ConjuntoTDA c2
	 * @Devuelve ConjuntoTDA conjunto (el resultado de la unión)
	 * @Precondicion Los conjuntos deben estar inicializados
	 * @Postcondicion Devuelve la union entre dos conjuntos.
	 * @Costo Lineal // Costo espacial: 1
	 **/
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

	/**
	 * @Tarea Realiza la diferencia simetrica entre 2 conjuntos
	 * @Parametros ConjuntoTDA c1, ConjuntoTDA c2
	 * @Devuelve ConjuntoTDA
	 * @Precondicion Los conjuntos deben estar inicializados
	 * @Postcondicion Devuelve la diferencia simetrica entre 2 conjuntos.
	 * @Costo Lineal // Costo espacial: 10
	 **/
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

	/**
	 * @Tarea Pasa los elementos de un conjunto a otro
	 * @Parametros ConjuntoTDA origen, ConjuntoTDA destino
	 * @Devuelve
	 * @Precondicion Los conjuntos deben estar inicializados
	 * @Postcondicion Pasa el contenido de un conjunto a otro.
	 * @Costo Lineal // Costo espacial: 0
	 **/
	private void pasarConjuntoConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
		int x;
		while (!origen.conjuntoVacio()) {
			x = origen.elegir();
			destino.agregar(x);
			origen.sacar(x);
		}
	}

	/**
	 * @Tarea Copia un conjunto a otro
	 * @Parametros ConjuntoTDA origen, ConjuntoTDA destino a copiar
	 * @Devuelve
	 * @Precondicion El conjunto debe estar inicializado
	 * @Postcondicion Copia el contenido de un conjunto a otro.
	 * @Costo Lineal // Costo espacial: 1
	 **/
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

	/**
	 * @Tarea Realiza el calculo de porcentaje de las materias por carrera
	 *        dependiendo el prefijo de las mismas.
	 * @Parametros DiccionarioMultipleTDA diccionario, String prefijoMateria
	 * @Devuelve
	 * @Precondicion Debe existir alguna carrera
	 * @Postcondicion Imprme el porcentaje de materias por carrera segun el
	 *                prefijo enviado.
	 * @Costo Cuadrática // Costo espacial: 2
	 **/
	private void porcentajeMaterias(DiccionarioMultipleTDA diccionario, String prefijoMateria) {
		ConjuntoTDA carreras = diccionario.claves();
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
			porcentaje = (Double.valueOf(contadorMaterias) / Double.valueOf(totalMaterias)) * 100;
			System.out.print("Carrera: " + nroCarrera + " | Porcentaje materias de  " + porcentaje + "%; \n");
		}
	}

	/**
	 * @Tarea Vacía el conjunto especificado
	 * @Parametros ConjuntoTDA conjunto a vaciar
	 * @Devuelve
	 * @Precondicion Conjunto inicializado
	 * @Postcondicion Vacia al conjunto.
	 * @Costo Lineal // Costo espacial: 0
	 **/
	private void vaciarConjunto(ConjuntoTDA conjunto) {
		while (!conjunto.conjuntoVacio()) {
			conjunto.agregar(conjunto.elegir());
			conjunto.sacar(conjunto.elegir());
		}

	}

	/**
	 * @Tarea Retorna la cantidad de vertices adyacentes del grafo
	 * @Parametros GrafoTDA grafo a utilizar, int v
	 * @Devuelve int cantidad (De vertices adyacentes)
	 * @Precondicion El grafo debe estar inicializado
	 * @Postcondicion Devuelve cantidad de vertices adyacentes que tiene el vertice de un grafo.
	 * @Costo Lineal // Costo espacial: 1
	 **/
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

	/**
	 * @Tarea Retorna la cantidad de vertices subsiguientes del grafo
	 * @Parametros GrafoTDA grafo a utilizar, int v
	 * @Devuelve int cantidad (De vertices subsiguientes)
	 * @Precondicion El grafo debe estar inicializado
	 * @Postcondicion Devuelve cantidad de vertices subsiguientes que tiene el vertice de un grafo.
	 * @Costo Lineal // Costo espacial: 1
	 **/
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
