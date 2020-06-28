package ar.edu.uade.progra2.tpo.miApi;

/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
/**
 * @TDA ConjuntoTDA
 * @Definicion
 *
 */
public interface ConjuntoTDA {

	/**
	 * @Tarea Inicializa el conjunto definiendo la capacidad capacidad maxima: cota
	 *        superior menos cota inferior mas uno
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 */
	void inicializarConjunto();

	/**
	 * @Tarea Agrega elemento en el conjunto.
	 * @Parametros int elemento
	 * @Devuelve
	 * @Precondicion debe estar inicializado y se debe evaluar si el conjunto ya se
	 *               encuentra lleno
	 * @Postcondicion
	 */
	void agregar(int elemento);

	/**
	 * @Tarea Quita elemento del conjunto.
	 * @Parametros int elemento
	 * @Devuelve
	 * @Precondicion debe estar inicializado y se debe evaluar que el conjunto no
	 *               este vacio.
	 * @Postcondicion
	 */
	void sacar(int elemento);

	/**
	 * @Tarea Obtiene un elemento NO vacio del conjunto
	 * @Parametros
	 * @Devuelve int elemento
	 * @Precondicion debe estar inicializado y se debe evaluar que el conjunto no
	 *               este vacio.
	 * @Postcondicion
	 */
	int elegir();

	/**
	 * @Tarea Evalua si el conjunto se encuentra vacio.
	 * @Parametros
	 * @Devuelve boolean indicando verdadero o falso.
	 * @Precondicion debe estar inicializado.
	 * @Postcondicion
	 */
	boolean conjuntoVacio();

	/**
	 * @Tarea Evalua si el elemento se encuentra dentro del conjunto.
	 * @Parametros int elemento.
	 * @Devuelve boolean indicando verdadero o falso.
	 * @Precondicion debe estar inicializado.
	 * @Postcondicion
	 */
	boolean pertenece(int elemento);
}
