package ar.edu.uade.progra2.tpo.miApi;

/**
 * @TDA ColaPrioridadTDA
 * @Definicion 
 *
 */
public interface ColaPrioridadTDA {

	/**
	@Tarea Inicializa la cola
	@Parametros
	@Devuelve
	@Precondicion
	@Postcondicion
	*/
	void inicializarCola();
	
	/**
	@Tarea Agrega un elemento a la cola con prioridad
	@Parametros x,p
	@Devuelve
	@Precondicion cola inicializada
	@Postcondicion
	*/
	void acolarPrioridad(int x,int p);
	
	/**
	@Tarea Demuestra si la cola se encuentra vacia
	@Parametros
	@Devuelve boolean dependiendo si la cola esta vacia o no.
	@Precondicion cola inicializada
	@Postcondicion
	*/
	boolean colaVacia();
	
	/**
	@Tarea Elimina el elemento que tiene mayor prioridad de la cola
	@Parametros
	@Devuelve
	@Precondicion Cola no vacia e inicializada
	@Postcondicion
	*/
	void desacolar();
	
	
	/**
	@Tarea Devuelve al elemento con mayor prioridad de la cola
	@Parametros
	@Devuelve int elemento con mayor prioridad
	@Precondicion Cola inicializada y no vacia
	@Postcondicion
	*/
	int primero();
	
	/**
	@Tarea Devuelve la prioridad que tiene el elemento con mayor prioridad de la cola
	@Parametros
	@Devuelve int prioridad
	@Precondicion cola inicializada y no vacia
	@Postcondicion
	*/
	int prioridad();

}
