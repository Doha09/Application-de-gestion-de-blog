package entities;

import java.util.List;
import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
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

    public Client(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
}
