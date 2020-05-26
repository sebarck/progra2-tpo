package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;

import java.util.regex.Matcher;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

public class PuntoD {
    public void porcentajeMateriasCienciasSocialesPorCarrera(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA carreras = diccionario.claves();
        while (!carreras.conjuntoVacio()) {
            int contadorMateriasCienciasSociales = 0;
            int contadorMaterias = 0;
            int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
            while (!materias.conjuntoVacio()) {
                int codigoMateria = materias.elegir();
                materias.sacar(codigoMateria);
                Matcher esMateriaDeCienciasSociales = compile("^(2|33)([0-9]+)").matcher(valueOf(codigoMateria));
                if (esMateriaDeCienciasSociales.matches()) {
                    contadorMateriasCienciasSociales++;
                }
                contadorMaterias++;
            }
            Double porcentaje = Double.valueOf(contadorMateriasCienciasSociales) / Double.valueOf(contadorMaterias);
            System.out.printf("Carrera %d | Porcenaje materias de ciencias sociales %.2f\n", nroCarrera, porcentaje);
        }
    }
}
