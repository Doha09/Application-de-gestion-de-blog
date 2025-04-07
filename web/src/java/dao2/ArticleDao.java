/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao2;

import entities.Article;

/**
 *
 * @author ouahm
 */
public class ArticleDao extends AbstractDao <Article>{
   
    public  ArticleDao() {
        super(Article.class);
    }
}

