package com.pauluooooo.service;

import com.pauluooooo.pojo.Brand;
import com.pauluooooo.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    // 查询所有方法
    List<Brand> selectAll();

    void addAll(Brand brand);

    void updateById(Brand newBrand);

    Brand selectById(int id);

    void deleteById(int id);

    void deleteByIds(int ids[]);

    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    int selectTotalCount();
}
