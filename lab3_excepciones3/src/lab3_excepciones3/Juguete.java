package lab3_excepciones3;
public class Juguete implements Comparable<Juguete> {
	private int idJuguete;
	private String tipo;
	private String nombre;
	private double precio;
	public Juguete(int idJuguete,String tipo, String nombre, double precio) {
		super();
		this.idJuguete = idJuguete;
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
	}
	public int getIdJuguete() {
		return idJuguete;
	}
	public void setIdJuguete(int idJuguete) {
		this.idJuguete = idJuguete;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "\nidJuguete= " + idJuguete + " tipo=" + tipo + " nombre=" + nombre + " precio=" + precio;
	}
	@Override
	public int compareTo(Juguete juguete1) {
		// TODO Auto-generated method stub
		return Double.compare(this.getPrecio(), juguete1.getPrecio());
	}
	
	
}
