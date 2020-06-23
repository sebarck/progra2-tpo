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
        ConjuntoTDA resultado2=diccionarioComunes.claves();
        if(resultado.conjuntoVacio()) {
        	System.out.println("No hay materias comunes en las carreras indicadas.");
        }else {
        	System.out.println("\n");
        	System.out.println("Los siguientes codigos corresponden a las materias comunes de todas las carreras indicadas: ");
        	int mayor=0;
        	while(!resultado.conjuntoVacio()){
        		mayor=0;
        		while(!resultado2.conjuntoVacio()) {
        			int nro2=resultado2.elegir();
        			if(nro2>mayor) {
        				mayor=nro2;
        			}
        			resultado2.sacar(nro2);
        		}
        		System.out.println("Codigo de linea: "+mayor);
             	diccionarioComunes.eliminar(mayor);
             	resultado=diccionarioComunes.claves();
             	resultado2=diccionarioComunes.claves();
             }
        }
       
        
    }
}
