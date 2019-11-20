package TDA;

/**
 * Esta clase posee el comportamiento que tendrá el Dijkstra en el momento de
 * ser ejecutado
 */
public class Edge {
	private String edge_ID;
	private Vertex<Object> startPoint;
	private Vertex<Object> endPoint;
	private double lenght;

	/**
         * constructor
         * @param edge_ID id de la arista
         * @param startPoint punto de partida (vértice)
         * @param endPoint punto de llegada (vértice)
         * @param lenght peso de la relación
         */
	public Edge(String edge_ID, Vertex<Object> startPoint, Vertex<Object> endPoint, double lenght) {
		this.edge_ID = edge_ID;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.lenght = lenght;
	}
	/**
         * get para arista
         * @return arista
         */

	public String getId_arista() {
		return edge_ID;
	}
        /**
         * set para id de arista
         * @param id_arista id de arista nuevo
         */
	public void setId_arista(String id_arista) {
		this.edge_ID = id_arista;
	}
        /**
         * get del punto de partida
         * @return punto de partida (vértice)
         */
	public Vertex<Object> getPuntoPartida() {
		return startPoint;
	}
        /**
         * set del punto de partida
         * @param puntoPartida nuevo vértice
         */
	public void setPuntoPartida(Vertex<Object> puntoPartida) {
		this.startPoint = puntoPartida;
	}
        /**
         * get del punto de llegada
         * @return punto de llegada(vértice)
         */
	public Vertex<Object> getPuntoLlegada() {
		return endPoint;
	}
        /**
         * set del punto de llegada 
         * @param puntoLlegada punto nuevo de llegada (vértice)
         */
	public void setPuntoLlegada(Vertex<Object> puntoLlegada) {
		this.endPoint = puntoLlegada;
	}
        /**
         * get del peso de la arista
         * @return peso 
         */
	public double getLongitud() {
		return lenght;
	}
        /**
         * set de la longitud de la arista
         * @param longitud peso nuevo de la arista
         */
	public void setLongitud(int longitud) {
		this.lenght = longitud;
	}
	/**
         * método para obtener un string con todas la variables
         * @return string con variables de la instancia
         */
	public String toString() {
		String msj = "";
		msj += "ID: " + edge_ID + "\n";
		msj += "Start Vertex: \n";
		msj += startPoint.toString()+" ";
		msj += endPoint.toString()+" ";
		msj += "Lenght: " + lenght;
		return msj;
	}
}
