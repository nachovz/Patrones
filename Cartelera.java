package patrones;

import java.util.NoSuchElementException;
import java.util.TreeSet;

public class Cartelera {
	private Cartelera(){}
	
	private static class CarteleraHolder{
		public static Cartelera instance = new Cartelera();
	}
	
	public static Cartelera getInstance(){
		return CarteleraHolder.instance;
	}
	
	private TreeSet<Requerimiento> m_data = new TreeSet<Requerimiento>();
	
	public class Iterator{
		private Cartelera m_collCartelera;
		private java.util.Iterator<Requerimiento> m_Iterator;
		private Requerimiento m_current;
		
		public Iterator(Cartelera in){
			m_collCartelera = in;
		}
		
		public void first(){
			m_Iterator = m_collCartelera.m_data.iterator();
			next();
		}
		
		public void next(){
			try{
				m_current = m_Iterator.next();
			}catch(NoSuchElementException ex){
				m_current = null;
			}
		}
		
		public boolean is_done(){
			return m_current == null;
		}
		
		public Requerimiento current_item() {
			return m_current;
		}
		
	}
	
	public void add(Requerimiento in){
		m_data.add(in);
	}
	
	public Iterator create_iterator(){
		return new Iterator(this);
	}
}
