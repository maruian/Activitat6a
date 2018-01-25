import java.sql.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		
	
		// obrim la sessio
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		// comencem la transaccio
		session.beginTransaction();	
			
		// creem la comanda
		Pedido p = new Pedido();
		p.setFecha(Date.valueOf("2018-01-17"));
		p.getItems().add(new Item("item 1", 30));
		p.getItems().add(new Item("item 2", 100));
		p.getItems().add(new Item("item 3", 70));
		// guardem la comanda
		session.save(p);
		
		session.getTransaction().commit();
		
		// recuperem la comanda
		session.beginTransaction();
		
		Pedido p1 = session.get(Pedido.class, 1);
		System.out.println("Hemos recuperado el pedido "+p.getId()+
				":\t"+p.getFecha());
		for (Item i: p.getItems()) {
			System.out.println("\tItem\t"+i.getNombre()+", "+i.getCantidad());
		}
		session.getTransaction().commit();
		
		
		// altra comanda
		session.beginTransaction();
		
		Pedido p2 = new Pedido();
		p2.setFecha(Date.valueOf("2018-01-24"));
		p2.getItems().add(new Item("item 4",500));
		p2.getItems().add(new Item("item 5",200));
		p2.getItems().add(new Item("item 6", 70));
		session.save(p2);
		session.getTransaction().commit();
		
		session.beginTransaction();
		Pedido p3 = session.get(Pedido.class, 2);
		System.out.println("Hemos recuperado el pedido "+p3.getId()+
				":\t"+p3.getFecha());
		for (Item i: p3.getItems()) {
			System.out.println("\tItem\t"+i.getNombre()+", "+i.getCantidad());
		}
		session.getTransaction().commit();
		
		
		// creem un nou objecte de tipo empresa
		session.beginTransaction();
		Empresa e = new Empresa();
		e.setCIF("22222222X");
		e.setNombre("EMPRESA 2 SL");
		e.setDireccion("Albal");
		e.setEmpleados(50);
		e.addPedido(p);
		e.addPedido(p2);
		// salvem l'objecte a la base de dades
		session.save(e);
		
		// fem el commit
		session.getTransaction().commit();
		
		
		// creem un nou usuari 
		session.beginTransaction();
		
		Usuario u = new Usuario();
		u.setNombre("Manolo");
		u.setObjetivo(30);
		u.setTotal(100);
		
		// salvem el usuari creat a la base de dades
		session.save(u);
		
		// fem el commit
		session.getTransaction().commit();
		
		// recuperem la empresa
		session.beginTransaction();
		Empresa empresa = session.get(Empresa.class, "22222222X");
		
		// Imprimir per pantalla
		System.out.println(
				e.getCIF()+"\t"+empresa.getNombre()+"\t"+empresa.getDireccion()+"\t"+empresa.getEmpleados());
		System.out.println("Pedidos:");
		for (Pedido pedido: e.getPedidos()) {
			System.out.println("\t"+pedido.getId()+"\t"+pedido.getFecha());
			for (Item item: pedido.getItems()) {
				System.out.println("\t\t"+item.getNombre()+", "+item.getCantidad());
			}
		}
	
		//fem el commit
	    session.getTransaction().commit();
				
		// tanquem la sessio
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		

	}

}
