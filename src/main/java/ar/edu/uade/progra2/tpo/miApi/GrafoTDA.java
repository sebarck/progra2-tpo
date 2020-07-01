package ar.edu.uade.progra2.tpo.miApi;

/**
* @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
* @grupo 18
**/
/**
 * @TDA GrafoTDA
 * @Definicion grafo dirigido, sin aristas paralelas ni bucles.
 *
 */
public interface GrafoTDA {

	/**
	 * @Tarea inicializarGrafo: inicializa el grafo.
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion Grafo inicializado.
	 */
	void inicializarGrafo();

	/**
	 * @Tarea agregarVertice: agrega un nuevo vertice v al grafo.
	 * @Parametros int v.
	 * @Devuelve
	 * @Precondicion debe estar inicializado y no existir el vertice.
	 * @Postcondicion Vertice agregado.
	 */
	void agregarVertice(int v);

	/**
	 * @Tarea eliminarVertice: elimina el vertice v.
	 * @Parametros int v.
	 * @Devuelve
	 * @Precondicion debe estar inicializado y existir el vertice.
	 * @Postcondicion Vertice eliminado.
	 */
	void eliminarVertice(int v);

	/**
	 * @Tarea vertices: devuelve el conjunto de vertices de un grafo.
	 * @Parametros
	 * @Devuelve ConjuntoTDA conjunto de vertices.
	 * @Precondicion debe estar inicializado.
	 * @Postcondicion Devuelve vertices.
	 */
	ConjuntoTDA vertices();

	/**
	 * @Tarea agregarArista: agrega una arista al grafo entre los vertices v1 y v2
	 *        con el peso dado.
	 * @Parametros int v1, int v2, int peso
	 * @Devuelve
	 * @Precondicion debe estar inicializado, no existir la arista entre los
	 *               vertices v1 y v2 y existir ambos vertices.
	 * @Postcondicion Arista agregada.
	 */
	void agregarArista(int v1, int v2, int peso);

	/**
	 * @Tarea eliminarArista: elimina la arista entre los vertices v1 y v2.
	 * @Parametros int v1, int v2.
	 * @Devuelve
	 * @Precondicion debe estar inicializado y existir la arista entre los vertices
	 *               v1 y v2.
	 * @Postcondicion Arista eliminada.
	 */
	void eliminarArista(int v1, int v2);

	/**
	 * @Tarea existeArista: indica si el grafo contiene una arista entre los
	 *        vertices v1 y v2.
	 * @Parametros int v1, int v2.
	 * @Devuelve boolean true si existe, false si no existe.
	 * @Precondicion debe estar inicializado y existir ambos vertices.
	 * @Postcondicion true o false si arista existe o no.
	 */
	boolean existeArista(int v1, int v2);

	/**
	 * @Tarea pesoArista: devuelve el peso de la arista entre los vertices v1 y v2.
	 * @Parametros int v1, int v2.
	 * @Devuelve int peso de la arista.
	 * @Precondicion debe estar inicializado y existir la arista entre los vertices
	 *               v1 y v2.
	 * @Postcondicion Devuelve peso arista.
	 */
	int pesoArista(int v1, int v2);

}
