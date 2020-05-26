package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;

import java.util.regex.Matcher;

import static java.lang.String.valueOf;
import static java.util.regex.Pattern.compile;

public class PuntoE {
    public void calcularCantidadOptativasPorCarrera(DiccionarioMultipleTDA diccionario) {
        ConjuntoTDA carreras = diccionario.claves();

        while (!carreras.conjuntoVacio()) {
            // Lo defino como byte, asumiendo que las optativas pueden
            // llegar a un valor de 127.
            byte cantidadOptativas = 0;
            int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);

            while (!materias.conjuntoVacio()) {
                int codigoMateria = materias.elegir();
                materias.sacar(codigoMateria);
                Matcher esOptativa = compile("[0-9]").matcher(valueOf(codigoMateria));
                if (esOptativa.matches()) {
                    cantidadOptativas++;
                }
            }

            if (cantidadOptativas > 0) {
                final String materia = (cantidadOptativas == 1)
                        ? " materia optativa"
                        : " materias optativas";

                System.out.println("El codigo de carrera " + nroCarrera + " posee " + cantidadOptativas + materia);
            } else {
                System.out.println("El codigo de carrera " + nroCarrera + " no posee materias optativas");
            }
        }
    }
}
