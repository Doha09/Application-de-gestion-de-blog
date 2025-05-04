package services;

import dao2.CategorieDao;
import entities.Categorie;
import java.util.List;

public class CategorieService {

    private final CategorieDao categorieDao = new CategorieDao();

    // ✅ Lister toutes les catégories
    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    // ✅ Ajouter une nouvelle catégorie
    public void ajouterCategorie(String nom) {
        if (nom != null && !nom.trim().isEmpty()) {
            Categorie categorie = new Categorie();
            categorie.setNom(nom.trim());
            categorieDao.create(categorie);
        }
    }

    // ✅ Modifier une catégorie existante
    public boolean modifierCategorie(int id, String nouveauNom) {
        if (nouveauNom == null || nouveauNom.trim().isEmpty()) return false;
        Categorie cat = categorieDao.findById(id);
        if (cat != null) {
            cat.setNom(nouveauNom.trim());
            return categorieDao.update(cat);
        }
        return false;
    }

    // ✅ Supprimer une catégorie par ID
    public boolean supprimerCategorie(int id) {
        Categorie cat = categorieDao.findById(id);
        return cat != null && categorieDao.delete(cat);
    }

    // ✅ Rechercher une catégorie par ID
    public Categorie trouverCategorie(int id) {
        return categorieDao.findById(id);
    }
}
