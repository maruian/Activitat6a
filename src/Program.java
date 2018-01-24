import java.sql.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		
	
		// obrim la sessio
		Session session = HibernateUtilities.getSessionFactory().openSession();
		
		// comencem la transaccio
		session.beginTransaction();	
	
		/*
		//recuperem un item
		Item i = session.get(Item.class, 1);
		
		//fem el commit
		session.getTransaction().commit();
		
		//Mostrem per pantalla
		System.out.println(i.getId()+"\t"+i.getNombre()+"\t"+i.getCantidad());
		
		//tanquem la sessio
		session.close();
		HibernateUtilities.getSessionFactory().close();
	
		/*
		// creem el objecte cantidad
		Item i = new Item();
		i.setCantidad(1000);
		i.setNombre("Pedido 1");
		
		// salvem l'objecte cantidad
		session.save(i);

		//fem el commit	
		session.getTransaction().commit();
		
		// tanquem la sessio
		session.close();
		HibernateUtilities.getSessionFactory().close();
	    /*
		// recuperem una comanda
		Pedido p = session.get(Pedido.class, 1);
		
		// fem el commit
		session.getTransaction().commit();
		
		// imprimim la comanda per pantalla
		System.out.println("Pedido: "+p.getId()+"\t"+p.getFecha());
		/*
		// Tanquem la sessio
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		// creem la comanda
		Pedido p = new Pedido();
		p.setFecha(Date.valueOf("2018-01-17"));
	
		
		// guardem la comanda
		session.save(p);
		
		session.getTransaction().commit();
		
		/*
		// creem una segona comanda
		Pedido p2 = new Pedido();
		p2.setFecha(Date.valueOf("2018-01-15"));
		
		// guardem la comanda a la base de dades
		session.save(p2);
		
		// fem el commit
		session.getTransaction().commit();
		
		// tanquem la sessio
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		// creem un nou objecte de tipo empresa
		Empresa e = new Empresa();
		e.setCIF("22222222X");
		e.setNombre("EMPRESA 2 SL");
		e.setDireccion("Albal");
		e.setEmpleados(50);
		
		// salvem l'objecte a la base de dades
		session.save(e);
		
		// fem el commit
		session.getTransaction().commit();
		/*
		// creem un objecte de tipo usuari recollint el valor de la base de dades 
		Usuario u = session.get(Usuario.class, 1);
		
		// imprimim el usuari per pantalla
		System.out.println("Hemos recuperado tu usuario: "+u.getNombre()+", Objetivo: "+u.getObjetivo());
		/*
		// fem el commit
		session.getTransaction().commit();
		
		// tanquem la sessio
		session.close();
		
		// creem un nou usuari
		Usuario u = new Usuario();
		u.setNombre("Manolo");
		u.setObjetivo(30);
		u.setTotal(100);
		
		// salvem el usuari creat a la base de dades
		session.save(u);
		
		// fem el commit
		session.getTransaction().commit();
		*/
		// recuperem la empresa
		Empresa e = session.get(Empresa.class, "22222222X");
		//fem el commit
		session.getTransaction().commit();
		
		// Imprimir per pantalla
		System.out.println(
				e.getCIF()+"\t"+e.getNombre()+"\t"+e.getDireccion()+"\t"+e.getEmpleados());
		
		// comencem altra transaccio
		session.beginTransaction();
		session.getTransaction().commit();
		// recuperem la segon empresa
		/*Empresa e2 = session.get(Empresa.class, "22222222X");
		// fem el commit
		session.getTransaction().commit();
		// imprimim per pantalla
		System.out.println(
				e2.getCIF()+"\t"+e2.getNombre()+"\t"+e2.getDireccion()+"\t"+e2.getEmpleados());
		*/
		// tanquem la sessio
		session.close();
		HibernateUtilities.getSessionFactory().close();
		
		

	}

}
