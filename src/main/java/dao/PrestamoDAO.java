package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Prestamo;

public class PrestamoDAO {
	private static Session session;
	private Transaction transaction;
	private static PrestamoDAO instance;
	
	private PrestamoDAO() { }
	
	public static PrestamoDAO getInstance() {
		if(instance == null) {
			instance = new PrestamoDAO();
		}
		return instance;
	}
	
	private void iniciaOperacion() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}
	
	private void manejaException(HibernateException he) {
		transaction.rollback();
		throw he;
	}
	
	@SuppressWarnings("deprecation")
	public long agregar(Prestamo objeto) {
		long id = -1;
		try {
			this.iniciaOperacion();
			id = (long) session.save(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	@SuppressWarnings("deprecation")
	public void modificar(Prestamo objeto) {
		try {
			this.iniciaOperacion();
			session.update(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void eliminar(Prestamo objeto) {
		try {
			this.iniciaOperacion();
			session.delete(objeto);
			transaction.commit();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Prestamo traer(long id) {
		Prestamo objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Prestamo.class, id);
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Prestamo traerPrestamoCuotas(long id) {
		Prestamo objeto = null;
		try {
			this.iniciaOperacion();
			objeto = session.get(Prestamo.class, id);
			Hibernate.initialize(objeto.getCuotas());
		} catch (HibernateException he) {
			this.manejaException(he);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prestamo> traer() {
		List<Prestamo> objeto = null;
		try {
			this.iniciaOperacion();
			String hql = "from Prestamo x order by x.idPrestamo asc";
			@SuppressWarnings("deprecation")
			Query<Prestamo> query = session.createQuery(hql);
			objeto = query.getResultList();
		} catch (HibernateException he) {
			this.manejaException(he);
			throw he;
		} finally {
			session.close();
		}
		return objeto;
	}
}
