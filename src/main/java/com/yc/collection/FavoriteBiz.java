package com.yc.collection;

import com.yc.collection.bean.Favorite;
import com.yc.collection.bean.Tag;
import com.yc.collection.bean.TagFavorite;
import com.yc.collection.dao.FavoriteMapper;
import com.yc.collection.dao.TagFavoriteMapper;
import com.yc.collection.dao.TagMapper;
import com.yc.collection.util.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;

public class FavoriteBiz {
    public void addFavorite(Favorite f){
        SqlSession session= MyBatisHelper.openSession();
        FavoriteMapper fm =session.getMapper(FavoriteMapper.class);
        TagMapper tm =session.getMapper(TagMapper.class);
        TagFavoriteMapper tfm=session.getMapper(TagFavoriteMapper.class);

        try{
            fm.insert(f);
            String[] tags=f.getFtags().split("[,，;；]");
            for (String tag:tags){
                Tag tag1=new Tag();
                //
                if (tm.updateCount(tag)==0){
                    tag1.setTname(tag);
                    tm.insert(tag1);
                }else {
                    tag1=tm.selectByName(tag);
                }
                TagFavorite tf=new TagFavorite();
                tf.setTid(tag1.getTid());
                tf.setFid(f.getFid());
                tfm.insert(tf);
                session.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }
}
