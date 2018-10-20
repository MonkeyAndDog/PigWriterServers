package org.pigwriter.controller;

import com.alibaba.fastjson.JSON;
import org.pigwriter.dto.APITarget;
import org.pigwriter.model.Article;
import org.pigwriter.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private ArticleService articleService;

    @CrossOrigin("http://localhost:8081")
    @RequestMapping("/list")
    @ResponseBody
    public String getArticles() {
        List<Article> articles = articleService.loadAll();
        return JSON.toJSONString(articles);
    }

    @CrossOrigin("http://localhost:8081")
    @RequestMapping("/read")
    @ResponseBody
    public String getArticleById(String id) {
        Article article = articleService.loadById(id);
        return JSON.toJSONString(article);
    }

    @CrossOrigin("http://localhost:8081")
    @RequestMapping("/add")
    @ResponseBody
    public String addArticle(String title, String content) {
        APITarget apiTarget = new APITarget();
        try {
            Article article = new Article();
            article.setContent(content);
            article.setTitle(title);
            article.setCreateDate(new Date());
            articleService.save(article);
            apiTarget.setData("存储成功")
                    .setState(200)
                    .setMessage("存储成功");
        } catch (Exception e) {
            e.printStackTrace();
            apiTarget.setData("存储失败")
                    .setState(-1)
                    .setMessage("存储失败");
        }
        return JSON.toJSONString(apiTarget);
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
