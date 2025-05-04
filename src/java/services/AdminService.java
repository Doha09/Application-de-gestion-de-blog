/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao2.AdminDao;
import entities.Admin;
import java.util.List;

/**
 *
 * @author ouahm
 */



public class AdminService {
    private AdminDao adminDao;

    public AdminService() {
        this.adminDao = new AdminDao();
    }

    public List<Admin> getAllAdmins() {
        return adminDao.findAll();
    }

    public void addAdmin(String nom, String prenom, String email, String motDePasse) {
        Admin admin = new Admin(nom, prenom, email, motDePasse);
        adminDao.create(admin);
    }

    public void deleteAdmin(Admin admin) {
        adminDao.delete(admin);
    }

    public void updateAdmin(Admin admin) {
        adminDao.update(admin);
    }
}

