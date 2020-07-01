package ar.edu.uade.progra2.tpo.miApi;
/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
/**
 * @TDA ColaPrioridadTDA
 * @Definicion Conjunto de datos tal que el primer dato en entrar es el primer en salir.
 *
 */
public interface ColaPrioridadTDA {

	/**
	@Tarea Inicializa la cola
	@Parametros
	@Devuelve
	@Precondicion
	@Postcondicion Cola inicializada.
	*/
	void inicializarCola();
	
	/**
	@Tarea Agrega un elemento a la cola con prioridad
	@Parametros int x,int p
	@Devuelve
	@Precondicion cola inicializada
	@Postcondicion Elemento en la cola.
	*/
	void acolarPrioridad(int x,int p);
	
	/**
	@Tarea Demuestra si la cola se encuentra vacia
	@Parametros
	@Devuelve boolean dependiendo si la cola esta vacia o no.
	@Precondicion cola inicializada
	@Postcondicion true o false si la cola esta vacia o no.
	*/
	boolean colaVacia();
	
	/**
	@Tarea Elimina el elemento que tiene mayor prioridad de la cola
	@Parametros
	@Devuelve
	@Precondicion Cola no vacia e inicializada
	@Postcondicion Saca elemento de la cola. 
	*/
	void desacolar();
	
	
	/**
	@Tarea Devuelve al elemento con mayor prioridad de la cola
	@Parametros
	@Devuelve int elemento con mayor prioridad
	@Precondicion Cola inicializada y no vacia
	@Postcondicion Devuelve el primer elemento de la cola.
	*/
	int primero();
	
	/**
	@Tarea Devuelve la prioridad que tiene el elemento con mayor prioridad de la cola
	@Parametros
	@Devuelve int prioridad
	@Precondicion cola inicializada y no vacia
	@Postcondicion Devuelve la prioridad del primer elemento de la cola.
	*/
	int prioridad();

}
