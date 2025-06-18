package com.opencode.demo.mapper;

import com.opencode.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User queryById(Integer id);
}
