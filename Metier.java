import java.io.FileReader;
import java.util.Scanner;
import iut.algo.Decomposeur;

public class Metier {
	private Departement[] ensDepartements;
	private int nbDept;

	private Region[] ensRegions;
	private int nbRegion;

	public Metier() {
		this.ensDepartements = new Departement[101];
		this.ensRegions = new Region[27];

		this.chargerDept();
		this.chargerRegion();
		this.lierRegionDept();
	}

	/** Retourne le nombre total de dÃ©partements */
	public int getNbDept() {
		return this.nbDept;
	}

	/** Retourne le nombre total de rÃ©gion */
	public int getNbRegion() {
		return this.nbRegion;
	}

	public Departement getDept(int indice) {

		if (this.ensDepartements[indice] != null) {

			return this.ensDepartements[indice];
		}
		return null;

	}

	public Region getRegion(int indice) {

		if (ensRegions[indice] != null) {

			return this.ensRegions[indice];
		}
		return null;
	}

	public String[] listerRegion() {
		String[] liste = new String[this.nbDept];

		for (int i = 0; i < this.nbDept; i++) {
			liste[i] = ensRegions[i].getNom();
		}

		return liste;
	}

	private void chargerDept() {
		int i = 0;
		String ligne;
		FileReader fr;
		try {
			fr = new FileReader("departement.data");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				ligne = sc.nextLine();
				Decomposeur dec = new Decomposeur(ligne);

				this.ensDepartements[i] = new Departement(dec.getString(0), dec.getString(1), dec.getInt(2),
						dec.getInt(3));
				this.nbDept++;
				i++;

			}

			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void chargerRegion() {
		int i = 0;
		String ligne;
		FileReader fr;
		Decomposeur dec;
		try {
			fr = new FileReader("region.data");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				ligne = sc.nextLine();
				dec = new Decomposeur(ligne);
				this.ensRegions[i] = new Region(dec.getInt(0), dec.getString(1), dec.getInt(2));
				this.nbRegion++;
				i++;

			}

			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lierRegionDept() {

		int indice = 0;
		String ligne;
		FileReader fr;
		try {
			fr = new FileReader("region.data");
			Scanner sc = new Scanner(fr);

			while (sc.hasNext()) {
				ligne = sc.nextLine();
				Decomposeur dec = new Decomposeur(ligne);

				indice = rechercherRegion(dec.getString(1));
				if (indice >= 0) {
					for (int j = 3; j < dec.getInt(2) + 3; j++) {
						this.ensRegions[indice].ajouterDepartement(rechercherDept(dec.getString(j)));
					}
				}
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Departement rechercherDept(String numero) {

		for (int i = 0; i < nbDept; i++) {
			if (this.ensDepartements[i] != null && this.ensDepartements[i].getNumero().equals(numero)) {
				return this.ensDepartements[i];
			}
		}
		return null;
	}

	private int rechercherRegion(String nom) {
		for (int i = 0; i < nbRegion; i++) {
			if (this.ensRegions[i] != null && this.ensRegions[i].getNom().equals(nom)) {
				return i;
			}
		}
		return -1;
	}

}