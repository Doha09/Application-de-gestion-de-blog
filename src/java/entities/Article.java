package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titre;
    private String contenu;

    @Column(name = "date_publication")
    private Date datePublication;

    private String image;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // ✅ Mise à jour ici : cascade + orphanRemoval
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER,
               cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commentaire> commentaires = new ArrayList<>();

    public Article() {}

    public Article(String titre, String contenu, Date datePublication, Categorie categorie, String image) {
        this.titre = titre;
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.categorie = categorie;
        this.image = image;
    }

    public Article(String titre, String contenu, Date datePublication, Categorie categorie) {
        this.titre = titre;
        this.contenu = contenu;
        this.datePublication = datePublication;
        this.categorie = categorie;
    }

    public Article(int id) {
        this.id = id;
    }

    // ====== GETTERS & SETTERS =======

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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
