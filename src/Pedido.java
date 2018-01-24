import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
	private Date fecha;
	private List<Item> items = new ArrayList<Item>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
