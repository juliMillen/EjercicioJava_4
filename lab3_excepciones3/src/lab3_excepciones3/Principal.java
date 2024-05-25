package lab3_excepciones3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import Excepciones.NoExisteExcep;
import Iterators.NombreIterator;
import Iterators.TipoComparator;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 ArrayList<Juguete> listaJuguetes= new ArrayList<Juguete>();
		 cargarJuguetes(listaJuguetes);
	     String opcion= null;
	     opcion= JOptionPane.showInputDialog("Ingrese una opcion: "
	    		+ "\n1- alta"
	    		+ "\n2- baja"
	    		+ "\n3- listado por tipo"
	    		+ "\n4- listado alfabetico"
	    		+ "\n5- listado por precio"
	    		+ "\n6- Buscar nombre"
	    		+ "\n7- fin");
	    
	    while(opcion != null && !opcion.equals("7")) {
	    	switch(opcion) {
	    	case "1":
	    		agregarJuguetes(listaJuguetes);
	    		break;
	    	case "2":
	    		eliminarJuguete(listaJuguetes);
	    		break;
	    	case "3":
	    		listarPorTipo(listaJuguetes);
	    		break;
	    	case "4":
	    		listarPorOrdenAlfabetico(listaJuguetes);
	    		break;
	    	case "5":
	    		listarPorPrecio(listaJuguetes);
	    		break;
	    	case "6":
	    		buscarNombre(listaJuguetes);
	    		break;
	    		default:
	    			JOptionPane.showMessageDialog(null, "Ingrese una opcion valida");
	    			break;
	    	}
	    	
	    	opcion= JOptionPane.showInputDialog("Ingrese una opcion: "
	    		+ "\n1- alta"
	    		+ "\n2- baja"
	    		+ "\n3- listado por tipo"
	    		+ "\n4- listado alfabetico"
	    		+ "\n5- listado por precio"
	    		+ "\n6- Buscar nombre"
	    		+ "\n7- fin");
	    }
	    try {
	    contarJuguetes(listaJuguetes);
	    }catch(NoExisteExcep ee) {
	    	JOptionPane.showMessageDialog(null, ee);
	    }
	    
	}
	
	public static void agregarJuguetes(ArrayList<Juguete>listaJuguetes) {
	
		try {
		String nombre= JOptionPane.showInputDialog("Ingrese un nombre: ");
		String tipo= JOptionPane.showInputDialog("Ingrese un tipo debe ser: AUTO-JUEGO DE MESA-MUÑECA-ENCASTRABLES");
		double precio= Double.parseDouble(JOptionPane.showInputDialog("Ingrese un precio: "));
		int id= Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID del muñeco: "));
		Juguete nuevoJuguete= new Juguete(id,nombre,tipo,precio);
		listaJuguetes.add(nuevoJuguete);
		}catch(NumberFormatException ee) {
			JOptionPane.showMessageDialog(null, "Error en el numero ingresado");
		}
		catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "No puede ser null");
		}
	}
	
	public static void eliminarJuguete(ArrayList<Juguete> listaJuguetes) {
		Iterator<Juguete> iterator= listaJuguetes.iterator();
		List<Juguete> nuevaLista = new LinkedList<Juguete>();
		
		String tipo= JOptionPane.showInputDialog("Ingrese el tipo de juguete que quiere eliminar: ");
		if(tipo != null) {
			while(iterator.hasNext()) {
				Juguete aEliminar= iterator.next();
				if(aEliminar.getTipo().equalsIgnoreCase(tipo)) {
					nuevaLista.add(aEliminar);
					iterator.remove();
				}
			}
		}
		if(nuevaLista.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista vacia");
		}
		else {
			String mostrar="";
			for(Juguete juguetes:listaJuguetes) {
				mostrar+= "\n"+juguetes.getTipo()+" "+ juguetes.getNombre();
			}
			JOptionPane.showMessageDialog(null, mostrar);
		}
	}
    public static void cargarJuguetes(ArrayList<Juguete> listaJuguetes){
    	 String[] tips= {"Autos","Juego de mesa","Muñeca","Encastrables"};
    	 String[] nomb= {"Antonio", "Lego", "Batman", "Barbie"};
    	 Random rndom= new Random();
    	for(int i=0; i<10; i++) {
    		String tipo= tips[rndom.nextInt(tips.length)];
    		String nombre= nomb[rndom.nextInt(nomb.length)];
    		double precio= rndom.nextDouble()*4500;
    		listaJuguetes.add(new Juguete(i,tipo,nombre,precio));
    	}
    }
    
    public static void listarPorTipo(ArrayList<Juguete> lJuguetes) {
    	Collections.sort(lJuguetes, new TipoComparator());
    	String mostrar="";
    	for(Juguete juguetes:lJuguetes) {
    		mostrar+= "\n"+ juguetes.getTipo()+ " "+ juguetes.getNombre() + " "+ juguetes.getPrecio();
    	}
    	JOptionPane.showMessageDialog(null, mostrar);
    }
    
    public static void listarPorOrdenAlfabetico(ArrayList<Juguete> listJuguetes) {
    	Collections.sort(listJuguetes, new NombreIterator());
    	String mostrar="";
    	for(Juguete juguete: listJuguetes) {
    		mostrar+= "\n"+ juguete.getNombre();
    	}
    	JOptionPane.showMessageDialog(null, mostrar);
    }
    
    public static void listarPorPrecio(ArrayList<Juguete> listJuguete) {
    	Collections.sort(listJuguete);
    	String mostrar="";
    	for(Juguete juguetes:listJuguete) {
    		mostrar += "\n"+ juguetes.getPrecio() + " "+ juguetes.getNombre();
    	}
    	JOptionPane.showMessageDialog(null, mostrar);
    }
    
    public static void buscarNombre(ArrayList<Juguete> listArrayList) {
    	Iterator<Juguete> iterador= listArrayList.iterator();
    	String n= JOptionPane.showInputDialog("Ingrese nombre a buscar: ");
    	boolean encontrado=false;
    	while(iterador.hasNext()) {
    		Juguete buscado= iterador.next();
    		if(n != null && buscado.getNombre().equalsIgnoreCase(n)) {
    			encontrado=true;
    			JOptionPane.showMessageDialog(null, "juguetes con el nombre buscado: "+buscado.getNombre()+ " "+ buscado.getTipo());
    		}
    	}
    	
      if(n==null && !encontrado) {
    	  JOptionPane.showMessageDialog(null, "No se ha encontrado ese nombre");
      }
    }
    
    public static void contarJuguetes(ArrayList<Juguete> listaJuguetes) throws NoExisteExcep {
    	String tipo = JOptionPane.showInputDialog("Ingrese el tipo de juguete: ");
    	int cont=0;
    	for(Juguete juguetesCont: listaJuguetes) {
    		if(juguetesCont.getTipo().equalsIgnoreCase(tipo)) {
    			cont++;
    		}
    	}
    	JOptionPane.showMessageDialog(null, tipo+" "+ " CANTIDAD: "+cont);
    	
    	if(cont==0) {
    		throw new NoExisteExcep();
    	}
    }

}
