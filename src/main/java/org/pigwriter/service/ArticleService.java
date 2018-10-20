package org.pigwriter.service;

import org.pigwriter.model.Article;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class ArticleService {
    private HibernateTemplate hibernateTemplate;

    public boolean save(Article article) {
        try {
            hibernateTemplate.save(article);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Article> loadAll() {
        List<Article> articles = (List<Article>) hibernateTemplate.find("from Article article order by article.createDate desc");
        return articles;
    }

    public Article loadById(String id) {
        Article article = hibernateTemplate.load(Article.class, id);
        if (article != null) {
            return article;
        } else {
            return null;
        }
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
