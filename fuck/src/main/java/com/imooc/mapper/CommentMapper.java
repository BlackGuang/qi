package com.imooc.mapper;

import com.imooc.dto.ArticleComment;
import com.imooc.dto.User;

import java.util.List;

public interface CommentMapper {

    List<User> getAll();
    public User getOne(int id);
    public void insert (User user);
    public void delete (int id);
    public User getUserbyName(String name);

    void insertComment(ArticleComment articleComment);
    List<ArticleComment> getCommentbyId(int id);

}
