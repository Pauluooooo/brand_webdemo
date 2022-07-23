package com.pauluooooo.web.servlet;

import com.alibaba.fastjson.JSON;
import com.pauluooooo.mapper.BrandMapper;
import com.pauluooooo.pojo.Brand;
import com.pauluooooo.service.BrandService;
import com.pauluooooo.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private final BrandService brandService = new BrandServiceImpl();

    // 查询所有
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Brand> brands = brandService.selectAll();
        String s = JSON.toJSONString(brands);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    // 添加品牌
    public void addAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader br = req.getReader();
        String s = br.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        brandService.addAll(brand);
        resp.getWriter().write("success");
    }

    // 根据ID查询数据，回显
    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        // 读取请求体JSON数据
        BufferedReader br = req.getReader();
        String s = br.readLine();
        // 将传入的JSON数据封装为brand对象
        Brand brand = JSON.parseObject(s, Brand.class);
        // 调用方法查询
        Integer id = brand.getId();
        Brand brand1 = brandService.selectById(id);
        // 将返回的对象回传
        String jsonString = JSON.toJSONString(brand1);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    // 修改品牌
    public void updateById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        // 读取请求体JSON数据
        BufferedReader br = req.getReader();
        String s = br.readLine();
        // 将传入的JSON数据封装为brand对象
        Brand newBrand = JSON.parseObject(s, Brand.class);
        // 调用修改方法
        brandService.updateById(newBrand);
        // 回传成功标志
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        // 读取请求体JSON数据
        BufferedReader br = req.getReader();
        String s = br.readLine();
        // 将传入的JSON数据封装为brand对象
        Brand brand = JSON.parseObject(s, Brand.class);
        // 执行方法
        Integer id = brand.getId();
        brandService.deleteById(id);
        // 回传成功标志
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }
}
