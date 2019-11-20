package Objetos;

import java.util.ArrayList;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class DataBase {
	
	private ObjectContainer data;
	
	public DataBase() {}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion de objetos donde seran guardados.
	 */
	@SuppressWarnings("deprecation")
	public void crearColeccion(String collection) {
		data=Db4o.openFile(collection);
		data.close();
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion de objetos para ser utilizados.
	 */
	@SuppressWarnings("deprecation")
	private void utilizarColeccion(String collection) {
		data=Db4o.openFile(collection);
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion de objetos.
	 * @return data : ArrayList<Object> - Lista con los resultados de la consulta.
	 */
	public ArrayList<Object> consult(String collection){
		utilizarColeccion(collection);
		
		ObjectSet<Object> result=data.queryByExample(null);
		ArrayList<Object> list=ObjectSetToArrayList(result);
		
		data.close();
		return list;
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion donde se buscara el objeto.
	 * @param obj : Object - Objeto que sera utilizado como ejemplo para ser consultado.
	 * @return data : ArrayList<Object> - Lista con los resultados de la consulta.
	 */
	public ArrayList<Object> consult(String collection, Object obj){
		utilizarColeccion(collection);
		
		ObjectSet<Object> result=data.queryByExample(obj);
		ArrayList<Object> list=ObjectSetToArrayList(result);
		
		data.close();
		return list;
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion de objetos donde sera guardado el objeto. 
	 * @param obj : Object - Objecto que sera guardado.
	 */
	public void save(String collection,Object obj) {
		utilizarColeccion(collection);
		data.store(obj);
		data.close();
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion donde se eliminara el objeto.
	 * @param obj : Object - Objeto que sera utilizado como ejemplo para ser eliminado.
	 */
	public void delete(String collection, Object obj) {
		utilizarColeccion(collection);
		
		ObjectSet<Object> res=data.queryByExample(obj);
		while(res.hasNext()) {
			data.delete(res.next());
		}
		
		data.close();
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion donde se editara el objeto.
	 * @param obj : Object - Objeto que sera utilizado como ejemplo para ser editado.
	 * @param task : Task - Objeto con los atributos actualizados.
	 */
	public void editTask(String collection,Object obj, Task task) {
		utilizarColeccion(collection);

		ObjectSet<Object> res=data.queryByExample(obj);
		while(res.hasNext()) {
			Task t1=(Task) res.next();
			t1.setType(task.getType());
			t1.setID(task.getID());
			t1.setDescription(task.getDescription());
			t1.setResponsible(task.getResponsible());
			t1.setEffort(task.getEffort());
			data.store(t1);
		}
		
		data.close();
	}
	
	/**
	 * 
	 * @param collection : String - Nombre de la coleccion donde se editara el objeto.
	 * @param obj : Object - Objeto que sera utilizado como ejemplo para ser editado.
	 * @param resource : Resource - Objeto con los atributos actualizados.
	 */
	public void editResource(String collection,Object obj, Resource resource) {
		utilizarColeccion(collection);

		ObjectSet<Object> res=data.queryByExample(obj);
		while(res.hasNext()) {
			Resource r1=(Resource) res.next();
			r1.setType(resource.getType());
			r1.setID(resource.getID());
			r1.setCapacity(resource.getCapacity());
			r1.setName(resource.getName());
			r1.setQuantity(resource.getQuantity());
			r1.setResponsable(resource.getResponsable());
			data.store(r1);
		}
		
		data.close();
	}
	
	/**
	 * 
	 * @param data : ObjectSet - Datos obtenidos de la BD
	 * @return newData : ArrayList<Object> - ArrayList de los objetos transformados.
	 */
	private ArrayList<Object> ObjectSetToArrayList(ObjectSet<Object> data){
		ArrayList<Object> newData=new ArrayList<Object>();
		while(data.hasNext()) {
			newData.add(data.next());
		}
		return newData;
	}
	

}
