package com.java017.tripblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author YuCheng
 * @date 2021/9/27 - 上午 01:36
 */

@Controller
public class IndexController {

    //跳轉主畫面
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    //跳轉關於我們畫面
    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    //跳轉詳細文章畫面
    @GetMapping("/article")
    public String article() {
        return "/article";
    }

    //跳轉美食主題文章
    @GetMapping("/eat")
    public String eat() {
        return "/article_eat";
    }

    //跳轉旅遊主題文章
    @GetMapping("/travel")
    public String travel() {
        return "/article_travel";
    }

    //跳轉地圖搜尋頁面
    @GetMapping("/map")
    public String map() {
        return "/map_search";
    }

    //跳轉作者美食文章
    @GetMapping("/userEat")
    public String userEat() {
        return "/user_article_eat";
    }

    //跳轉作者旅遊文章
    @GetMapping("/userTravel")
    public String userTravel() {
        return "/user_article_travel";
    }

    //跳轉作者收藏頁面
    @GetMapping("/userCollection")
    public String userCollection() {
        return "/user_collection";
    }

    //跳轉作者介紹頁面
    @GetMapping("/userSpace")
    public String userSpace() {
        return "/user_space";
    }

}
