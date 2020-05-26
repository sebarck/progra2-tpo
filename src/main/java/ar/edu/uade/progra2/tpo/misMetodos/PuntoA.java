package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;

public class PuntoA {
    /**
     * @param diccionario Diccionario que se desea analizar
     * @param nroCarrera Numero de carrera de la cual se desea saber cantidad de materias
     * @return int Cantidad de materias por carrera
     * Precondicion: La carrera debe existir
     */
    public int cantidadMateriasPorCarrera(DiccionarioMultipleTDA diccionario, int nroCarrera) {
        ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
        int contadorMaterias = 0;
        while (!materias.conjuntoVacio()) {
            int codigoMateria = materias.elegir();
            materias.sacar(codigoMateria);
            contadorMaterias++;
        }
        return contadorMaterias;
    }
}
