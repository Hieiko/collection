package com.yc.collection.web;

import com.google.gson.Gson;
import com.yc.collection.dao.TagMapper;
import com.yc.collection.util.MyBatisHelper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryTag.do")
public class QueryTagsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession session= MyBatisHelper.openSession();
        TagMapper tagMapper=session.getMapper(TagMapper.class);
        Gson gson=new Gson();
        String json =gson.toJson(tagMapper.selectAll());
        response.getWriter().append(json);
        System.out.println(json);
    }
}
