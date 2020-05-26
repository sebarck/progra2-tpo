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
            int cantidadOptativas = 0;
            int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
            String codigoCarrera = "El codigo de carrera " + nroCarrera;

            while (!materias.conjuntoVacio() && cantidadOptativas == 0) {
                int codigoMateria = materias.elegir();
                materias.sacar(codigoMateria);
                // Aca evaluo que haya UNA sola ocurrencia del 0 al 9 en la linea
                // Asumimos que los codigos de materias cuando hay optativas van del 0 al 9
                Matcher esOptativa = compile("[0-9]").matcher(valueOf(codigoMateria));
                // Aca asumimos que la cantidad de optativas sale del codigo de materia
                // dado que vimos que los valores coinciden
                cantidadOptativas = (esOptativa.matches()) ? codigoMateria : cantidadOptativas;
            }


            if (cantidadOptativas > 0) {
                // Simplemente para que quede lindo en caso de que la cantidad sea 1
                final String stringMateria = (cantidadOptativas == 1)
                        ? " materia optativa"
                        : " materias optativas";

                System.out.println(codigoCarrera + " posee " + cantidadOptativas + stringMateria);
            } else {
                System.out.println(codigoCarrera + " no posee materias optativas");
            }
        }
    }
}
