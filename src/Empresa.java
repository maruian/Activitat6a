import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String cif;
	private String nombre;
	private int empleados;
	private Direccion direccion;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Empresa() {
		setDireccion(new Direccion());
	}
	
	public String getCIF() {
		return cif;
	}
	public void setCIF(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEmpleados() {
		return empleados;
	}
	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}
	
	public void addPedido(Pedido pedido) {
		pedido.setEmpresa(this);
		this.pedidos.add(pedido);
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
		direccion.setEmpresa(this);
	}
	
	
	
}
