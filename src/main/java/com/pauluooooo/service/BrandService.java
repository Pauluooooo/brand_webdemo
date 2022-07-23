package com.pauluooooo.service;

import com.pauluooooo.pojo.Brand;

import java.util.List;

public interface BrandService {
    // 查询所有方法
    List<Brand> selectAll();

    void addAll(Brand brand);

    void updateById(Brand newBrand);

    Brand selectById(int id);

    void deleteById(int id);
}
