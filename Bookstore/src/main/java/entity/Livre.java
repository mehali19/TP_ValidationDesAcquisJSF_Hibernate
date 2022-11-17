package entity;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.LivreDAO;

@ManagedBean(name="Livre")
@Table(name = "Livre")
@Entity(name = "Livre")
public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "titre")
	private String titre;
	@Column(name = "auteur")
	private String auteur;
	@Column(name = "date")
	private String date;
	@Column(name = "prix")
	private int prix;

	// Constructeur par défaut
	public Livre() {

	}

	// Constructeur
	public Livre(String titre, String auteur, String date, int prix) {
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.prix = prix;
	}

	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	// ToString
	@Override
	public String toString() {
		return "Livre [ titre=" + titre + ", auteur=" + auteur + ", date=" + date + ", prix=" + prix + "]";
	}

	// Méthodes du DAO
	// Ajout d'un livre
	public void addLivre() {
		LivreDAO.save(this);
	}

	// Suppression d'un livre
	public void deleteLivre() {
		LivreDAO.delete();
	}

	//

}
