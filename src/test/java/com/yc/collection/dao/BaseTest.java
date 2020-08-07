package com.yc.collection.dao;

import com.yc.collection.FavoriteBiz;
import com.yc.collection.bean.Favorite;
import com.yc.collection.util.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class BaseTest {
    @Test
    public void test(){
        SqlSession session= MyBatisHelper.openSession();
        FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
        TagMapper tm=session.getMapper(TagMapper.class);
        TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);

        Favorite favorite=new Favorite();
        favorite.setFlabel("淘宝");
        favorite.setFurl("taobao.com");
        favorite.setFdesc("购物网站");
        favorite.setFtags("购物，生活");

        fm.insert(favorite);
        session.commit();
        session.close();
    }
    @Test
    public void test2(){
        FavoriteBiz fb=new FavoriteBiz();
        Favorite favorite=new Favorite();
        favorite.setFlabel("淘宝");
        favorite.setFurl("taobao.com");
        favorite.setFdesc("购物网站");
        favorite.setFtags("购物，生活");
        fb.addFavorite(favorite);
    }
    @Test
    public void test3(){
        FavoriteBiz fb=new FavoriteBiz();
        Favorite favorite=new Favorite();
        favorite.setFlabel("网易");
        favorite.setFurl("163.com");
        favorite.setFdesc("好网站");
        favorite.setFtags("门户，军事，生活");
        fb.addFavorite(favorite);
    }
    @Test
    public void test4(){
        SqlSession session=MyBatisHelper.openSession();
        FavoriteMapper fm=session.getMapper(FavoriteMapper.class);
        fm.selectByTid(null);
        fm.selectByTid(1);
        fm.selectByTid(0);
    }


}
