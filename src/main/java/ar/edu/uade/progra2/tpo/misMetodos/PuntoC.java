package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;

import java.util.regex.Matcher;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

public class PuntoC {
    public void porcentajeMateriasCienciasBasicasPorCarrera(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA carreras = diccionario.claves();
        while (!carreras.conjuntoVacio()) {
            int contadorMateriasCienciasBasicas = 0;
            int contadorMaterias = 0;
            int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
            while (!materias.conjuntoVacio()) {
                int codigoMateria = materias.elegir();
                materias.sacar(codigoMateria);
                Matcher esMateriaDeCienciasBasicas = compile("^(31)([0-9]+)").matcher(valueOf(codigoMateria));
                if (esMateriaDeCienciasBasicas.matches()) {
                    contadorMateriasCienciasBasicas++;
                }
                contadorMaterias++;
            }
            Double porcentaje = Double.valueOf(contadorMateriasCienciasBasicas) / Double.valueOf(contadorMaterias);
            System.out.printf("Carrera %d | Porcenaje materias de ciencias basicas %.2f\n", nroCarrera, porcentaje);
        }
    }
}
