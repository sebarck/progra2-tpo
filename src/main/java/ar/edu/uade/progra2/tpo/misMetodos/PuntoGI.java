package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.Conjunto;

public class PuntoGI {
    private static final PuntoHJ puntoHJ = new PuntoHJ();

    /**
     * @Tarea Mostrar aquellas carreras que tengan menos de 20% de materias iguales entre si.
     * @Parametros DiccionarioMultipleTDA diccionario
     * @Devuelve
     * @Precondicion Diccionario inicializado y con csv cargado
     * @Postcondicion
     * @Costo
     **/

    public void crearCombinacionesComparar20Porciento(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA conjunto = diccionario.claves();
        String mensajePorcentajeIguales = " hay menos de un 20% de materias de coincidencia de materias";

        while (!conjunto.conjuntoVacio()) {
            int carrera = conjunto.elegir();
            conjunto.sacar(carrera);

            ConjuntoTDA conjuntoAux = new Conjunto();
            conjuntoAux.inicializarConjunto();

            puntoHJ.copiarConjuntoConjunto(conjunto, conjuntoAux);

            while (!conjuntoAux.conjuntoVacio()) {
                int carreraAux = conjuntoAux.elegir();
                conjuntoAux.sacar(carreraAux);

                int porcentajeCantidadIguales = calcularPorcentajeMateriasIguales(carrera, carreraAux, diccionario);

                if (porcentajeCantidadIguales <= 20) {
                    System.out.println("Entre la carrera " + carrera + " y la carrera " + carreraAux + mensajePorcentajeIguales);
                }
            }
        }
    }

    /**
     * @Tarea Mostrar aquellas carreras que tengan mas de 80% de materias iguales entre si.
     * @Parametros DiccionarioMultipleTDA diccionario
     * @Devuelve
     * @Precondicion Diccionario inicializado y con csv cargado
     * @Postcondicion
     * @Costo
     **/

    public void crearCombinacionesComparar80Porciento (DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA conjunto = diccionario.claves();
        String mensajePorcentajeIguales = " hay mas de un 80% de materias de coincidencia de materias";

        while (!conjunto.conjuntoVacio()) {
            int carrera = conjunto.elegir();
            conjunto.sacar(carrera);

            ConjuntoTDA conjuntoAux = new Conjunto();
            conjuntoAux.inicializarConjunto();

            puntoHJ.copiarConjuntoConjunto(conjunto, conjuntoAux);

            while (!conjuntoAux.conjuntoVacio()) {
                int carreraAux = conjuntoAux.elegir();
                conjuntoAux.sacar(carreraAux);

                int porcentajeCantidadIguales = calcularPorcentajeMateriasIguales(carrera, carreraAux, diccionario);

                if (porcentajeCantidadIguales >= 80) {
                    System.out.println("Entre la carrera " + carrera + " y la carrera " + carreraAux + mensajePorcentajeIguales);
                }
            }
        }
    }

    private int calcularPorcentajeMateriasIguales(int carrera, int carreraAux, DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA materiasCarrera = diccionario.recuperar(carrera);
        ConjuntoTDA materiasCarreraAux = diccionario.recuperar(carreraAux);
        int contadorMateriasCarrera = 0;
        int materiasIguales = 0;

        while (!materiasCarrera.conjuntoVacio()) {
            int materiaCarrera = materiasCarrera.elegir();
            materiasCarrera.sacar(materiaCarrera);

            if (materiasCarreraAux.pertenece(materiaCarrera)) {
                materiasIguales++;
            }

            contadorMateriasCarrera++;
        }

        return (materiasIguales * 100) / contadorMateriasCarrera;
    }
}
