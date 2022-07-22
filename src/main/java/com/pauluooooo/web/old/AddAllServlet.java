package com.pauluooooo.web.old;

import com.alibaba.fastjson.JSON;
import com.pauluooooo.pojo.Brand;
import com.pauluooooo.service.BrandService;
import com.pauluooooo.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addAllServlet")
public class AddAllServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String s = br.readLine();
        Brand brand = JSON.parseObject(s, Brand.class);
        brandService.addAll(brand);
        response.getWriter().write("success");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
