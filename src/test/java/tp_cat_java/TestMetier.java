package tp_cat_java;

import metier.CatalogueMetierImpl;
import metier.entite.Produit;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CatalogueMetierImpl metier= new CatalogueMetierImpl();
		metier.addProduit(new Produit("HP 876",786.00,4));
		metier.addProduit(new Produit("HP 5436",800,9));
		metier.addProduit(new Produit("HP COMPAQ",600.00,3));
	}

}
