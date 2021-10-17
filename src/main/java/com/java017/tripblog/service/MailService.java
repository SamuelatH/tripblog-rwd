package com.java017.tripblog.service;

import javax.servlet.http.HttpSession;

/**
 * @author YuCheng
 * @date 2021/10/12 - 上午 02:03
 */
public interface MailService {

    //寄送註冊驗證
    void sendSignupMail(HttpSession session);

    //驗證註冊碼
    boolean verifySignupCode(String code, HttpSession session);

    //生成驗證碼
    String generateVerificationCode(int length);


}
