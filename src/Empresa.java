import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private String cif;
	private String nombre;
	private int empleados;
	private String direccion;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	
}
