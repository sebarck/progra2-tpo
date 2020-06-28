package ar.edu.uade.progra2.tpo.miApi;
/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
/**
 * @TDA DiccionarioSimpleTDA
 * @Definicion
 *
 */
public interface DiccionarioSimpleTDA {

	/**
	 * @Tarea  Inicializa al diccionario.
	 * @Parametros
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 */
	void inicializarDiccionarioSimple();
	
	/**
	 * @Tarea  Agrega al diccionario un valor x asociado a una clave c.
	 * @Parametros int c, int x.
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 */
	void agregar(int c, Double x);
	
	/**
	 * @Tarea  Elimina el valor x asociado a la clave c.
	 * @Parametros int c.
	 * @Devuelve
	 * @Precondicion
	 * @Postcondicion
	 */
	void eliminar(int c);
	
	/**
	 * @Tarea  Devuelve el valor x de una clave dada c.
	 * @Parametros int c.
	 * @Devuelve int clave.
	 * @Precondicion diccionario inicializado y que la clave exista.
	 * @Postcondicion
	 */
	Double recuperar(int c);
	
	/**
	 * @Tarea Devuelve a todas las claves que componen al diccionario.
	 * @Parametros 
	 * @Devuelve ConjuntoTDA claves.
	 * @Precondicion diccionario inicializado.
	 * @Postcondicion
	 */
	ConjuntoTDA claves();

}
