package com.java017.tripblog.service;

import com.java017.tripblog.entity.Intro;

/**
 * @author Sandy
 * @date
 */

public interface IntroService {

    //上傳首圖


    //更新自我介紹
    Intro editIntro(Intro intro);

    //編號查詢會員資料
    Intro showIntroData(Long id);

}
