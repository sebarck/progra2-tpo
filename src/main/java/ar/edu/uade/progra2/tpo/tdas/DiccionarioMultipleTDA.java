package ar.edu.uade.progra2.tpo.tdas;

public interface DiccionarioMultipleTDA {

    /**
     * Inicializa el diccionario definiendo la capacidad
     */
    void inicializarDiccionarioMultiple();

    /**
     * Precondicion: debe estar inicializado, se debe evaluar si el diccionario ya se encuentra lleno
     * y que la clave|valor a agregar no se encuentre ya en el diccionario
     * en tal caso se podria lanzar una excepcion (DiccionarioNoInicializadoException|DiccionarioLlenoException|DiccionarioElementoRepetidoException)
     * <p>
     * Agrega al diccionario un conjunto asociado a una clave
     *
     * @param clave
     * @param valor
     */
    void agregar(int clave, int valor);

    /**
     * Precondicion: debe estar inicializado, se debe evaluar si el diccionario no se encuentra vacio
     * y que la clave con elemento a eliminar exista
     * en tal caso se podria lanzar una excepcion (DiccionarioNoInicializadoException|DiccionarioVacioException|DiccionarioClaveInexistenteException)
     * <p>
     * Elimina el conjunto del diccionario por clave
     *
     * @param clave
     */
    void eliminar(int clave);

    /**
     * Precondicion: debe estar inicializado, se debe evaluar si el diccionario no se encuentra vacio
     * y que la clave con elemento a obtener exista
     * en tal caso se podria lanzar una excepcion (DiccionarioNoInicializadoException|DiccionarioVacioException|DiccionarioClaveInexistenteException)
     * <p>
     * Recupera el conjunto del diccionario por clave
     *
     * @param clave
     * @return {@code ConjuntoTDA} valor
     */
    ConjuntoTDA recuperar(int clave);

    /**
     * Precondicion: debe estar inicializado, se debe evaluar si el diccionario no se encuentra vacio
     * y que la clave con elemento a eliminar exista
     * en tal caso se podria lanzar una excepcion (DiccionarioNoInicializadoException|DiccionarioVacioException|DiccionarioClaveInexistenteException)
     * <p>
     *
     * Elimina el valor asociado a la clave del conjunto
     *
     * @param clave
     * @param valor
     */
    void eliminarValor(int clave, int valor);

    /**
     * Precondicion: debe estar inicializado en tal caso se podria lanzar una excepcion (DiccionarioNoInicializadoException)
     * <p>
     * Devuelve el conjunto de claves que posee el diccionario
     *
     * @return {@code ConjuntoTDA} conjunto de claves
     */
    ConjuntoTDA claves();
}
