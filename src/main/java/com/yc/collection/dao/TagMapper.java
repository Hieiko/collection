package com.yc.collection.dao;

import com.yc.collection.bean.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TagMapper {
    @Insert("insert into tag values(null,#{tname},1)")
    @Options(useGeneratedKeys = true
    ,keyColumn = "tid",keyProperty = "tid")
    int insert(Tag f);

    @Update("update tag set tcount =tcount+1 where tname=#{tname}")
    int updateCount(String tag);

    @Select("select * from tag where tname=#{tname}")
    Tag selectByName(String tag);

    @Select("select * from tag")
    List<Tag> selectAll();
}
