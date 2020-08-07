package com.yc.collection.dao;

import com.yc.collection.bean.TagFavorite;
import org.apache.ibatis.annotations.Insert;

public interface TagFavoriteMapper {
    @Insert("insert into tagfavorite values(#{tid},#{fid})")
    int insert(TagFavorite f);
}
