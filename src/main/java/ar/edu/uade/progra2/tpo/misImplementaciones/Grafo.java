package ar.edu.uade.progra2.tpo.misImplementaciones;

import ar.edu.uade.progra2.tpo.miApi.ConjuntoTDA;
import ar.edu.uade.progra2.tpo.miApi.GrafoTDA;
/**
 * @autores Lopez Gerardo Martin, Monti Sebastián, Streule Agustina, Ochoa Ignacio Javier
 * @grupo 18
 **/
public class Grafo implements GrafoTDA {

	int[][] matrizAdy;
	int[] vectorVertices;
	int cantMaxVert;
	int cantVert;
	
	public void inicializarGrafo() {
		cantVert = 0;
		cantMaxVert = 100;
		matrizAdy = new int[cantMaxVert][cantMaxVert];
		vectorVertices = new int[cantMaxVert];
		for (int or = 0; or < cantMaxVert; or++) {
			for (int dest = 0; dest < cantMaxVert; dest++) {
				matrizAdy[or][dest] = 0;
			}
		}
	}

	@Override
	public void agregarVertice(int v) {
		vectorVertices[cantVert] = v;
		cantVert++;

	}

	@Override
	public void eliminarVertice(int v) {
		int pos = posicionVertice(v);
		for (int i = 0; i < cantMaxVert; i++) {
			matrizAdy[pos][i] = matrizAdy[i][pos] = 0;
		}
		vectorVertices[pos] = vectorVertices[cantVert-1];
		cantVert--;
	}

	@Override
	public ConjuntoTDA vertices() {
		ConjuntoTDA verts = new Conjunto();
		verts.inicializarConjunto();
		for (int v = 0; v < cantVert; v++) {
			verts.agregar(vectorVertices[v]);
		}
		return verts;
	}

	@Override
	public void agregarArista(int v1, int v2, int peso) {
		int or = posicionVertice(v1);
		int dest = posicionVertice(v2);
		matrizAdy[or][dest] = peso;
	}

	@Override
	public void eliminarArista(int v1, int v2) {
		int or = posicionVertice(v1);
		int dest = posicionVertice(v2);
		matrizAdy[or][dest] = 0;

	}

	@Override
	public boolean existeArista(int v1, int v2) {
		int or = posicionVertice(v1);
		int dest = posicionVertice(v2);
		return matrizAdy[or][dest] != 0;
	}

	@Override
	public int pesoArista(int v1, int v2) {
		int or = posicionVertice(v1);
		int dest = posicionVertice(v2);
		return matrizAdy[or][dest];
	}
	
	private int posicionVertice(int v) {
		int i;
		for (i = 0; i < cantMaxVert && vectorVertices[i]!=v; i++) {
		}
		return i;
	}

}
