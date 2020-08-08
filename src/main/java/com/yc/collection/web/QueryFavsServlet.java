package com.yc.collection.web;

import com.google.gson.Gson;
import com.yc.collection.bean.Favorite;
import com.yc.collection.dao.FavoriteMapper;
import com.yc.collection.dao.TagMapper;
import com.yc.collection.util.MyBatisHelper;
import com.yc.collection.util.Result;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryFavs.do")
public class QueryFavsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession session= MyBatisHelper.openSession();
        FavoriteMapper tm=session.getMapper(FavoriteMapper.class);
        String sTid=request.getParameter("tid");
        System.out.println(sTid);
        Integer iTid;
        if (sTid==null || sTid.trim().isEmpty() || "null".equals(sTid)){
            iTid =null;
        }else {
            iTid=Integer.valueOf(sTid);
        }
        List<Favorite>  data = tm.selectByTid(iTid);
        Gson gson=new Gson();
        String json =gson.toJson(new Result<>().setCode(200).setData(data));
        System.out.println(json);
        response.getWriter().append(json);
    }
}
