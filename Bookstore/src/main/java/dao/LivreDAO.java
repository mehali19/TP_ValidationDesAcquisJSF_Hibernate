package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Livre;
import util.HibernateUtil;

public class LivreDAO {

	
	// Ajout d'une personne dans la bdd
		public static void save(Livre l){
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			
			try {
				session.persist(l);
				tr.commit();
			}catch(Exception e) {
				tr.rollback();
				System.out.println("Erreur lors de l'ajout de l'objet Livre. "+ e.getMessage());
			}
			session.close();
		}
		
		// Suppression d'une personne dans la BDD
		public static void delete() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			Livre l=null;
			try {
				l = session.get(Livre.class, l.getId());
				session.delete(l);
				tr.commit();
			}catch(Exception e) {
				tr.rollback();
				System.out.println("Erreur lors de la suppression de l'objet Livre. "+ e.getMessage());
			}
			session.close();
		}
		
		public static void update(Livre l) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tr = session.beginTransaction();
			try {
				session.update(l);// p devient persistant
				tr.commit();
			} catch (Exception e) {
				System.out.print("Erreur lors la mise à jour de l'objet Livre. " + e.getMessage());
				tr.rollback();
			}
			session.close();
		}
		
		public static Livre getLivre(int id) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Livre l = new Livre();
			try {
				l = session.get(Livre.class, id);
				transaction.commit();

			} catch (Exception e) {
				transaction.rollback();
				System.out.println("Erreur lors du get de l'objet Livre. " + e.getMessage());
			}

			return l;
		}
		
}
