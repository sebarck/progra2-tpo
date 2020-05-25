/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ar.edu.uade.progra2.tpo;

import ar.edu.uade.progra2.tpo.tdas.DiccionarioMultiple;
import ar.edu.uade.progra2.tpo.tdas.DiccionarioMultipleTDA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    private static String file = "src/main/resources/Materias.csv";

    public static void main(String[] args) {
        DiccionarioMultipleTDA diccionario = inicializarDiccionario();
        try {
            cargarDiccionario(diccionario);
        } catch (Exception e) {
            System.err.format("No se pudo leer el archivo '%s'.", file);
            e.printStackTrace();
        }
    }

    private static void cargarDiccionario(DiccionarioMultipleTDA diccionario) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split(";");
            int nroCarrera = Integer.valueOf(splitLine[0]);
            int codigoMateria = Integer.valueOf(splitLine[1]);
            System.out.format("Codigo carrera %d | Codigo materia %d\n", nroCarrera, codigoMateria);
            diccionario.agregar(nroCarrera, codigoMateria);
        }
        reader.close();
    }

    private static DiccionarioMultipleTDA inicializarDiccionario() {
        DiccionarioMultipleTDA diccionario = new DiccionarioMultiple();
        diccionario.inicializarDiccionarioMultiple();
        return diccionario;
    }
}
