package com.imooc.vo;

import com.imooc.dto.ArticleComment;
import com.imooc.dto.Articles;

import java.util.List;

public class reOneArticle {

    Articles articles;
    List<ArticleComment> articleComments;
    private String userName;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public List<ArticleComment> getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(List<ArticleComment> articleComments) {
        this.articleComments = articleComments;
    }



}