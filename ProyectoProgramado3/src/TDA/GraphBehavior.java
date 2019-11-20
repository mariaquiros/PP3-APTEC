package TDA;


import java.util.*;

/**
 * Interface que contiene los métodos de ejecución para cualquier grafo
 * 
 *
 * @param <GenericObject>
 *            Este genérico permite utilizar cualquier objeto, de modo que este
 *            objeto sea parte del nodo del grafo
 */
public interface GraphBehavior<GenericObject> {
	public void runGraph(GenericObject Grafo);

	public LinkedList<GenericObject> obtainListedRoad(GenericObject pDestino);
}

