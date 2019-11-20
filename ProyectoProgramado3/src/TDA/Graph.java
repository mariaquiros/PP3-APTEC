package TDA;

import java.util.ArrayList;


import java.util.List;

/**
 * La clase grafo permite generar los linkeos entre los vertices y las aristas
 * 
 * @author AARON RM
 *
 */
//atributos
public class Graph {
	private List<Vertex<Object>> vertex;
	private List<Edge> edges;

	/**
	 * constructores del grafo
	 * 
	 * @param pVertices lista de vertices del grafo
	 * @param pEdges  lista de aristas del grafo
	 */
	public Graph(List<Vertex<Object>> pVertices, List<Edge> pEdges) {
		this.vertex = pVertices;
		this.edges = pEdges;
	}
	public Graph() {
		this.vertex = new ArrayList<Vertex<Object>>();
		this.edges = new ArrayList<Edge>();
	}
	// GETTERS Y SETTERS
	public List<Vertex<Object>> getVertices() {
		return vertex;
	}

	public void setVertices(List<Vertex<Object>> vertices) {
		this.vertex = vertices;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> aristas) {
		this.edges = aristas;
	}

	@Override
	/**
	 * metodo para obtener las variables en string
	 */
	public String toString() {
		String msj = "";
		msj += vertex.toString();
		msj += edges.toString();
		return msj;
	}
}

