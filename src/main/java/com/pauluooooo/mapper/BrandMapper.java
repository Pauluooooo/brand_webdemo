package com.pauluooooo.mapper;

import com.pauluooooo.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    /*
     * 查询所有功能
     **/
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    // 新增品牌功能
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void addAll(Brand brand);

    // 修改品牌功能
    void updateById(Brand newBrand);

    // 查询单个品牌
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

}
