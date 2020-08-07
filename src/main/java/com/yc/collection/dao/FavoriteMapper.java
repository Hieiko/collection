package com.yc.collection.dao;

import com.yc.collection.bean.Favorite;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper {
    @Insert("insert into favorite values(null"
    +",#{flabel},#{furl},#{fdesc},#{ftags})")
    @Options(useGeneratedKeys = true
    ,keyColumn = "fid",keyProperty = "fid")
    int insert(Favorite f);

    List<Favorite> selectByTid(@Param("tid")Integer tid);

}
