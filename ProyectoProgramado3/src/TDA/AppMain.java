package TDA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppMain {
	private static GraphManager controlador;
	private static Graph grafo;
	private static Dijkstra dijkstra;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Primeramente, se utiliza el controlador para crear las listas de vertices y
		// aristas
		controlador = new GraphManager();
		
		controlador.newVertes("A", "ALELUYA");
		controlador.newVertes("B", "QWERTY");
		controlador.newVertes("C", "ASDFGH");
		controlador.newVertes("D", "POIUYY");
		controlador.newVertes("E", "MHJBOIN");

		controlador.newEdge("AB", 0, 1, 23.8);
		controlador.newEdge("BA", 1, 0, 23.8);
		controlador.newEdge("AD", 0, 3, 5.8);
		controlador.newEdge("DA", 3, 0, 5.8);
		
		controlador.newEdge("AC", 0, 2, 17.2);
		controlador.newEdge("CA", 2, 0, 17.2);

		controlador.newEdge("BC", 1, 2, 36.2);
		controlador.newEdge("CB", 2, 1, 36.2);

		controlador.newEdge("CD", 1, 3, 25.1);
		controlador.newEdge("DC", 3, 1, 25.1);
		
		controlador.newEdge("DE", 3, 4, 86.4);
		controlador.newEdge("ED", 4, 3, 86.4);


		// Luego se inicializa el grafo que actuar directamente sobre las listas del
		// controlador
		grafo = new Graph(controlador.getVertices(), controlador.getEdges());
		//System.out.println(grafo.toString());

		// Por ultimo se utliza el Dijkstra para obtener la ruta mas corta de un punto a
		// otro
		dijkstra = new Dijkstra(grafo);
		dijkstra.runGraph(dijkstra.getVertices().get(2));
		
		///OBTIENE LAS DISTANCIAS A TODOS LOS VERTICES A PARTIR DEL GET(NUM) anterior
		//System.out.println(dijkstra.getDistancias().toString());

		///OBTIENE EL CAMINO MaS CORTO A PARTIR DE get(0) a get(4) EN ESTE CASO , puede ser cualquiera
		//System.out.println(dijkstra.obtenerListadoCamino(dijkstra.getVertices().get(0)));
		
		
		//Obtener la distancia entre dos vertices
		//double distanciaMinima = dijkstra.getDistancias().get(dijkstra.getVertices().get(1));
		//System.out.println(distanciaMinima);
		FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		String data="";
		// Write objects to file
		for(int i=0;i < grafo.getVertices().size();i++) {
			data+=grafo.getVertices().get(i)+",";
		}
		o.writeObject(data);

		o.close();
		f.close();
		/*
		 
		FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
		ObjectInputStream oi = new ObjectInputStream(fi);

		// Read objects
		String pr2 = (String) oi.readObject();
		String[] split = pr2.split(",");
		
		//System.out.println(pr2);
		System.out.println(split[2]);

		oi.close();
		fi.close();
		*/
	}
}

