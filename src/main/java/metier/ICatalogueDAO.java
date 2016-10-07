package metier;

import java.util.List;

import metierentite.Produit;

public interface ICatalogueDAO {
	public void addProduit(Produit p);
	public List<Produit> listProduits();
	public Produit getProduit(Long idProd);
	public List<Produit> getProduitParMC(String mc);
	public void deleteProduit(Long idProd);
	public void updateProduit(Produit p);
	

}
