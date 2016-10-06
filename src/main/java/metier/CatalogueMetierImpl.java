package metier;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import metier.entite.Produit;
import util.HibernateUtil;

public class CatalogueMetierImpl implements ICatalogueDAO{

	public void addProduit(Produit p) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(p);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		org.hibernate.Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req= session.createQuery("select p from Produit p");
		List<Produit> prods= req.list();
		session.getTransaction().commit();
		return prods;
	}

	public Produit getProduit(Long idProd) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object p= session.get(Produit.class,idProd);// get product with his primary key
		if (p==null) throw new RuntimeException("Produit introuvable");
		return (Produit)p;
	}
	
	public List<Produit> getProduitParMC(String mc) {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query req= session.createQuery("select p from Produit p where p.designation like:x");
		req.setParameter("x","%"+mc+"%" );
		
		List<Produit> prod = req.list();
		session.getTransaction().commit();
		return prod;
	}
	

	public void deleteProduit(Long idProd) {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object p = session.get(Produit.class, idProd );
		if (p==null) throw new RuntimeException("Produit introuvable");	
		session.delete(p);
		session.getTransaction().commit();
	}

	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
	}



}
