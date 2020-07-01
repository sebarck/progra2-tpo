package ar.edu.uade.progra2.tpo.miApi;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
/**
 * @TDA ConjuntoTDA
 * @Definicion Estructura de datos no repetidos y desordenados, tal que el
 *             primer dato a obtener esta determinado de forma aleatoria.
 *
 */
public interface ConjuntoTDA {

	/**
	 * @Tarea Inicializa el conjunto definiendo la capacidad capacidad maxima: cota
	 *        superior menos cota inferior mas uno
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion Conjunto inicializado.
	 */
	void inicializarConjunto();

	/**
	 * @Tarea Agrega elemento en el conjunto.
	 * @Parametros int elemento
	 * @Devuelve
	 * @Precondicion debe estar inicializado y se debe evaluar si el conjunto ya se
	 *               encuentra lleno
	 * @Postcondicion Elemento agregado al conjunto.
	 */
	void agregar(int elemento);

	/**
	 * @Tarea Quita elemento del conjunto.
	 * @Parametros int elemento
	 * @Devuelve
	 * @Precondicion debe estar inicializado y se debe evaluar que el conjunto no
	 *               este vacio.
	 * @Postcondicion Elemento fue quitado del conjunto.
	 */
	void sacar(int elemento);

	/**
	 * @Tarea Obtiene un elemento NO vacio del conjunto
	 * @Parametros
	 * @Devuelve int elemento
	 * @Precondicion debe estar inicializado y se debe evaluar que el conjunto no
	 *               este vacio.
	 * @Postcondicion devuelve elemento al azar del conjunto.
	 */
	int elegir();

	/**
	 * @Tarea Evalua si el conjunto se encuentra vacio.
	 * @Parametros
	 * @Devuelve boolean indicando verdadero o falso.
	 * @Precondicion debe estar inicializado.
	 * @Postcondicion true o false segun si el conjunto esta vacio o no.
	 */
	boolean conjuntoVacio();

	/**
	 * @Tarea Evalua si el elemento se encuentra dentro del conjunto.
	 * @Parametros int elemento.
	 * @Devuelve boolean indicando verdadero o falso.
	 * @Precondicion debe estar inicializado.
	 * @Postcondicion true o false segun si el elemento pertenece o no.
	 */
	boolean pertenece(int elemento);
}
