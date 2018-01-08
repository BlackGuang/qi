package com.imooc.controller;

import java.util.List;


import com.imooc.dto.ArticleComment;
import com.imooc.dto.User;
import com.imooc.mapper.CommentMapper;
import com.imooc.mapper.UserMapper;
import com.imooc.vo.Article;
import com.imooc.vo.reOneArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.imooc.dto.Articles;
import com.imooc.mapper.ArticlesMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
@RequestMapping("/article")
public class ArticlesController {

	@Autowired
	private ArticlesMapper articleMapper;

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getArticles")
	public List<Article> getArticles(HttpServletRequest request, HttpServletResponse response ) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Article> article= articleMapper.getAllFirst();
		return article;
	}

	@RequestMapping("/getArticlesByType/{type}")
	public List<Article> getArticlesByType(@PathVariable("type") String type, HttpServletResponse response ) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Article> article= articleMapper.getTopTEnByType(type);
		return article;
	}
//	public String login(HttpServletRequest request,HttpServletResponse response){

	@RequestMapping(value = "/submitComment",method = RequestMethod.POST)
	public reOneArticle submitComment(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");

		String userID=request.getParameter("userID");
		User zuser =userMapper.getUserbyName(userID);
		int user_ID=zuser.getId();
		String userComment=request.getParameter("userComment");

		String newsID=request.getParameter("newsID");
		int news_ID=Integer.parseInt(newsID);

		ArticleComment articleComment=new ArticleComment();

		articleComment.setArticleId(news_ID);
		articleComment.setUserId(user_ID);
		articleComment.setComment(userComment);
		articleComment.setUserName(userID);
		commentMapper.insertComment(articleComment);

		Articles article = articleMapper.getOne(news_ID);
		reOneArticle reoneArticle=new reOneArticle();
		List<ArticleComment> articleComment_1=commentMapper.getCommentbyId(news_ID);
		reoneArticle.setArticles(article);
		reoneArticle.setArticleComments(articleComment_1);

		return reoneArticle;



	}

	@RequestMapping("/getArticle/{id}")
	public reOneArticle getArticle(@PathVariable("id") String Sid,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		int id=Integer.parseInt(Sid);
		Articles article = articleMapper.getOne(id);
		reOneArticle reoneArticle=new reOneArticle();
		List<ArticleComment> articleComment=commentMapper.getCommentbyId(id);
		reoneArticle.setArticles(article);
		reoneArticle.setArticleComments(articleComment);
		return reoneArticle;
	}

	@RequestMapping("/testArticle")
	public Articles testArticle(){
		Articles article = articleMapper.getOne(1);
		return article;
	}

}