package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;

import java.util.regex.Matcher;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

public class PuntoBCD {

    public void porcentajeMateriasInformaticaPorCarrera(DiccionarioMultipleTDA diccionario) {
        porcentajeMaterias(diccionario, "^(34)([0-9]+)", "informatica");
    }

    public void porcentajeMateriasCienciasBasicasPorCarrera(DiccionarioMultipleTDA diccionario) {
        porcentajeMaterias(diccionario, "^(31)([0-9]+)", "ciencias basicas");
    }

    public void porcentajeMateriasCienciasSocialesPorCarrera(DiccionarioMultipleTDA diccionario) {
        porcentajeMaterias(diccionario, "^(2|33)([0-9]+)", "ciencias sociales");
    }

    private void porcentajeMaterias(DiccionarioMultipleTDA diccionario, String prefijoMateria, String tipoMateria) {
        ConjuntoTDA carreras = diccionario.claves();
        while (!carreras.conjuntoVacio()) {
            int contadorMaterias = 0;
            int totalMaterias = 0;
            int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
            while (!materias.conjuntoVacio()) {
                int codigoMateria = materias.elegir();
                materias.sacar(codigoMateria);
                Matcher esMateria = compile(prefijoMateria).matcher(valueOf(codigoMateria));
                if (esMateria.matches()) {
                    contadorMaterias++;
                }
                totalMaterias++;
            }
            Double porcentaje = Double.valueOf(contadorMaterias) / Double.valueOf(totalMaterias);
            System.out.printf("Carrera %d | Porcenaje materias de %s %.2f\n", nroCarrera, tipoMateria, porcentaje);
        }
    }
}
