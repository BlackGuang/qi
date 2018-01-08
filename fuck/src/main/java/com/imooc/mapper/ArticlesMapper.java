package com.imooc.mapper;
import com.imooc.dto.Articles;
import com.imooc.vo.Article;

import java.util.List;

public interface ArticlesMapper {

    List<Article> getAllFirst();
    Articles getOne(int id);
    List<Article> getTopTEnByType(String type);

}
