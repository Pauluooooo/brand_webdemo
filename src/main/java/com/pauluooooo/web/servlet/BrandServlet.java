package com.pauluooooo.web.servlet;

import com.alibaba.fastjson.JSON;
import com.pauluooooo.mapper.BrandMapper;
import com.pauluooooo.pojo.Brand;
import com.pauluooooo.pojo.PageBean;
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
        int id = Integer.parseInt(s);
        Brand brand = brandService.selectById(id);
        // 将返回的对象回传
        String jsonString = JSON.toJSONString(brand);
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
        // 执行方法
        int id = Integer.parseInt(s);
        brandService.deleteById(id);
        // 回传成功标志
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置字符集
        req.setCharacterEncoding("utf-8");
        // 读取请求体JSON数据
        BufferedReader br = req.getReader();
        String s = br.readLine();
        // 执行方法
        int[] ids = JSON.parseObject(s, int[].class);
        brandService.deleteByIds(ids);
        // 回传成功标志
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        // 接收当前页码和每页展示条数
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 读取数据体数据
        BufferedReader br = req.getReader();
        String line = br.readLine();
        // 封装为brand对象
        Brand brand = JSON.parseObject(line, Brand.class);
        // 调用查询方法，返回pageBean对象
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        String s = JSON.toJSONString(pageBean);
        // 回传成功标志
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(s);
    }
}
