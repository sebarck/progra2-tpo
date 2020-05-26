package ar.edu.uade.progra2.tpo.misMetodos;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.Conjunto;
import ar.edu.uade.progra2.tpo.miApi.DiccionarioMultipleTDA;
import ar.edu.uade.progra2.tpo.misImplementaciones.DiccionarioMultiple;

public class PuntoF {
    public void materiasComunes(DiccionarioMultipleTDA diccionario) {
    	DiccionarioMultipleTDA diccionarioComunes=new DiccionarioMultiple();
    	diccionarioComunes.inicializarDiccionarioMultiple();
    	
    	ConjuntoTDA carreras = diccionario.claves();
    	int i=1;
        while (!carreras.conjuntoVacio()) {
        	int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
            
            while(!materias.conjuntoVacio()) {
        		int codigoMateria = materias.elegir();
                materias.sacar(codigoMateria);
                diccionarioComunes.agregar(codigoMateria, i);
                
            }
            i++;
        }
        
        carreras = diccionario.claves(); 
        while(!carreras.conjuntoVacio()) {
        	int nroCarrera = carreras.elegir();
            carreras.sacar(nroCarrera);
            ConjuntoTDA materias = diccionario.recuperar(nroCarrera);
            while(!materias.conjuntoVacio()) {
            	int nroMateria=materias.elegir();
            	materias.sacar(nroMateria);
            	ConjuntoTDA repeticiones=diccionarioComunes.recuperar(nroMateria);
            	
                for(int j=i-1;j>=1;j--) {
                	if(!repeticiones.pertenece(j)) {
                		diccionarioComunes.eliminar(nroMateria);
                	}
                }
            }
            
        }
        
        ConjuntoTDA resultado=diccionarioComunes.claves();
        if(resultado.conjuntoVacio()) {
        	System.out.println("No hay materias comunes en las carreras indicadas.");
        }else {
        	System.out.print("Los siguientes codigos corresponden a las materias comunes de todas las carreras indicadas: ");
        	while(!resultado.conjuntoVacio()) {
             	int nro=resultado.elegir();
             	resultado.sacar(nro);
             	System.out.print(nro+", ");
             }
        }
       
        
    }
}
