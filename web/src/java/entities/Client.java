/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedNativeQuery;

/**
 *
 * @author ouahm
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Client.findByEmail", query = "from Client where email = :email"),
    @NamedQuery(name = "Client.findByNom", query = "from Client where nom like :nom"),
    @NamedQuery(name = "Client.findByArticle", query = "SELECT DISTINCT c FROM Client c JOIN c.commentaires com WHERE com.article.id = :articleId")
})
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "Client.findAllNative",
        query = "SELECT * FROM users WHERE type = 'Client'",
        resultClass = Client.class
    )
})
public class Client extends User {

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Commentaire> commentaires;

    public Client() {
        super();
    }

    public Client(String nom, String email, String motDePasse) {
        super(nom, email, motDePasse);
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
