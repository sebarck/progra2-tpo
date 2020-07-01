package ar.edu.uade.progra2.tpo.miApi;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
/**
 * @TDA DiccionarioMultipleTDA
 * @Definicion Estructura tal que cada elemento tiene asociado una clave.Donde
 *             cada clave puede tener asociado mas de un valor y estos no pueden
 *             estar repetidos.
 *
 */
public interface DiccionarioMultipleTDA {

	/**
	 * @Tarea Inicializa el diccionario definiendo la capacidad.
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion Diccionario inicializado.
	 */
	void inicializarDiccionarioMultiple();

	/**
	 * @Tarea Agrega al diccionario un conjunto asociado a una clave
	 * @Parametros int clave, int valor
	 * @Devuelve
	 * @Precondicion debe estar inicializado, se debe evaluar si el diccionario ya
	 *               se encuentra lleno y que la clave|valor a agregar no se
	 *               encuentre ya en el diccionario
	 * @Postcondicion Clave y valor agregadas al diccionario.
	 */
	void agregar(int clave, int valor);

	/**
	 * @Tarea Elimina el conjunto del diccionario por clave.
	 * @Parametros int clave
	 * @Devuelve
	 * @Precondicion debe estar inicializado, se debe evaluar si el diccionario no
	 *               se encuentra vacio y que la clave con elemento a eliminar
	 *               exista
	 * @Postcondicion Clave eliminada del diccionario.
	 */
	void eliminar(int clave);

	/**
	 * @Tarea Recupera el conjunto del diccionario por clave.
	 * @Parametros
	 * @Devuelve ConjuntoTDA valor.
	 * @Precondicion debe estar inicializado, se debe evaluar si el diccionario no
	 *               se encuentra vacio y que la clave con elemento a obtener exista
	 * @Postcondicion Clave recuperada del diccionario.
	 */
	ConjuntoTDA recuperar(int clave);

	/**
	 * @Tarea Elimina el valor asociado a la clave del conjunto.
	 * @Parametros int clave, int valor.
	 * @Devuelve
	 * @Precondicion debe estar inicializado, se debe evaluar si el diccionario no
	 *               se encuentra vacio y que la clave con elemento a eliminar
	 *               exista.
	 * @Postcondicion Valor eliminado del diccionario.
	 */
	void eliminarValor(int clave, int valor);

	/**
	 * @Tarea Devuelve el conjunto de claves que posee el diccionario.
	 * @Parametros
	 * @Devuelve ConjuntoTDA conjunto de claves.
	 * @Precondicion debe estar inicializado.
	 * @Postcondicion Devuelve el conjunto de claves del diccionario.
	 */
	ConjuntoTDA claves();
}
