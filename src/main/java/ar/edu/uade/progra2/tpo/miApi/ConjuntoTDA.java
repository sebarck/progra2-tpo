package ar.edu.uade.progra2.tpo.miApi;

public interface ConjuntoTDA {

    /**
     * Inicializa el conjunto definiendo la capacidad
     * capacidad maxima: cota superior menos cota inferior mas uno
     */
    void inicializarConjunto();

    /**
     * Precondición: debe estar inicializado y se debe evaluar si el conjunto ya se encuentra lleno
     * en tal caso se podria lanzar una excepcion (ConjuntoNoInicializadoException|ConjuntoLlenoException)
     * <p>
     * Agrega elemento en el conjunto
     *
     * @param elemento
     */
    void agregar(int elemento);

    /**
     * Precondición: debe estar inicializado y se debe evaluar que el conjunto no este vacio
     * en tal caso se podria lanzar una excepcion (ConjuntoNoInicializadoException|ConjuntoVacioException)
     * <p>
     * Quita elemento del conjunto
     *
     * @param elemento
     */
    void sacar(int elemento);

    /**
     * Precondición: debe estar inicializado y se debe evaluar que el conjunto no este vacio
     * en tal caso se podria lanzar una excepcion (ConjuntoNoInicializadoException|ConjuntoVacioException)
     * <p>
     * Obtiene un elemento NO vacio del conjunto
     *
     * @return {@code int} elemento
     */
    int elegir();

    /**
     * Precondición: debe estar inicializado
     * en tal caso se podria lanzar una excepcion (ConjuntoaNoInicializadoException)
     *
     * Evalua si el conjunto se encuentra vacio
     *
     * @return {@code boolean} indicando verdadero o falso
     */
    boolean conjuntoVacio();

    /**
     * Precondición: debe estar inicializado
     * en tal caso se podria lanzar una excepcion (ConjuntoaNoInicializadoException)
     * <p>
     * Evalua si el elemento se encuentra dentro del conjunto
     *
     * @param elemento
     * @return {@code boolean} indicando verdadero o falso
     */
    boolean pertenece(int elemento);
}
