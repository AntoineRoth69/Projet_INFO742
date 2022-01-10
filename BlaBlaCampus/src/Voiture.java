
public class Voiture {
	// Atributs
	private String marque;
	private String modele;
	private String couleur;
	
	
	/**
	 * @param marque
	 * @param modele
	 * @param couleur
	 * Constructeur, permet d'entrer une nouvelle voiture
	 */
	public Voiture(String marque, String modele, String couleur) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
	}
	
	
	//Getter and Setter
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

}
