/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao2.CategorieDao;
import entities.Categorie;
import java.util.List;

/**
 *
 * @author ouahm
 */
public class CategorieService {

    private CategorieDao categorieDao;

    public CategorieService() {
        this.categorieDao = new CategorieDao();
    }

    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    public void addCategorie(String nom) {
        Categorie categorie = new Categorie(nom);
        categorieDao.create(categorie);
    }

    public void deleteCategorie(Categorie categorie) {
        categorieDao.delete(categorie);
    }

    public void updateCategorie(Categorie categorie) {
        categorieDao.update(categorie);
    }

    public void ajouterCategorie(String nom) {
        Categorie categorie = new Categorie();
        categorie.setNom(nom);
        categorieDao.create(categorie);
    }

    public List<Categorie> listerToutes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean modifierCategorie(int id, String nom) {
        Categorie cat = categorieDao.findById(id);

        if (cat != null && nom != null && !nom.trim().isEmpty()) {
            cat.setNom(nom);
            return categorieDao.update(cat);
        }
        return false;
    }

    public Categorie trouverCategorie(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean supprimerCategorie(int id) {
        Categorie cat = categorieDao.findById(id);
        if (cat != null) {
            return categorieDao.delete(cat);
        }
        return false;
    }
}
