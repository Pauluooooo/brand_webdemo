package com.pauluooooo.service.impl;

import com.pauluooooo.mapper.BrandMapper;
import com.pauluooooo.pojo.Brand;
import com.pauluooooo.pojo.PageBean;
import com.pauluooooo.service.BrandService;
import com.pauluooooo.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = new SqlSessionFactoryUtils().getSqlSessionFactory();

    /*查询所有*/
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    /*添加*/
    @Override
    public void addAll(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addAll(brand);
        sqlSession.commit();
        sqlSession.close();

    }

    /*编辑*/
    @Override
    public void updateById(Brand newBrand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateById(newBrand);
        sqlSession.commit();
        sqlSession.close();
    }

    /*数据回显*/
    @Override
    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /*单个删除*/
    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    /*批量删除*/
    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        // 获取mapper
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 计算条目数和当前页
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Brand> rows = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();
        // 封装为PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public int selectTotalCount() {
        return 0;
    }
}
