package com.yc.collection.web;

import com.google.gson.Gson;
import com.yc.collection.FavoriteBiz;
import com.yc.collection.bean.Favorite;
import com.yc.collection.util.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTag.do")
public class AddTagServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String flabel=request.getParameter("web");
        System.out.println(flabel);
        String furl=request.getParameter("link");
        System.out.println(furl);
        String fdesc=request.getParameter("desc");
        System.out.println(fdesc);
        String ftags=request.getParameter("tags");
        System.out.println(ftags);
        if (flabel==null||flabel.trim().isEmpty()){
            Gson gson=new Gson();
            String json =gson.toJson(new Result<>().setCode(404).setMsg("网站名不能为空"));
            response.getWriter().append(json);
        }else if (furl==null ||furl.trim().isEmpty()){
            Gson gson=new Gson();
            String json =gson.toJson(new Result<>().setCode(404).setMsg("链接不能为空"));
            response.getWriter().append(json);
        }else if (fdesc==null||fdesc.trim().isEmpty()){
            Gson gson=new Gson();
            String json =gson.toJson(new Result<>().setCode(404).setMsg("描述不能为空"));
            response.getWriter().append(json);
        }else{
            FavoriteBiz fb=new FavoriteBiz();
            Favorite favorite=new Favorite();
            favorite.setFlabel(flabel);
            favorite.setFurl(furl);
            favorite.setFdesc(fdesc);
            favorite.setFtags(ftags);
            fb.addFavorite(favorite);
            Gson gson=new Gson();
            String json =gson.toJson(new Result<>().setCode(200).setMsg("收藏成功"));
            System.out.println(json);
            response.getWriter().append(json);
        }
    }
}
