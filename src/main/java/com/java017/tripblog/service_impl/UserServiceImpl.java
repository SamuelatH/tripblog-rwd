package com.java017.tripblog.service_impl;

import com.java017.tripblog.repository.UserRepository;
import com.java017.tripblog.entity.InitializationVector;
import com.java017.tripblog.entity.Intro;
import com.java017.tripblog.entity.User;
import com.java017.tripblog.service.UserService;
import com.java017.tripblog.util.CipherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

/**
 * @author YuCheng
 * @date 2021/9/27 - 下午 02:35
 */

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final String KEY = "TravelAndEatBlog";
    private final SecureRandom secureRandom = new SecureRandom();

    @Override//確認用戶帳密
    public User checkUser(String account, String password) {
        //帳號查詢取得向量值
        User user = userRepository.findByAccount(account);
        if (user == null) {
            return null;
        }

        try {
            password = CipherUtils.encryptString(KEY, password, user.getIv().getIv());
        } catch (Exception e) {
            e.printStackTrace();
        }

        user = userRepository.findByAccountAndPassword(account, password);
        return user;
    }

    @Override//創建會員
    public boolean createUser(User user) {

        //加密
        String encrypt = "";
        //隨機向量產生
        byte[] iv = new byte[128 / 8];
        secureRandom.nextBytes(iv);
        InitializationVector vector = new InitializationVector();
        vector.setIv(iv);
        Intro intro = new Intro();

        try {
            encrypt = CipherUtils.encryptString(KEY, user.getPassword(), iv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //保存
        user.setPassword(encrypt);
        user.setIv(vector);
        user.setIntro(intro);

        try {
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @Override//帳號查詢會員資料
    public User findUserByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    @Override//編號查詢會員資料
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);

//        //解密
//        String encrypt = user.getPassword();
//        String decrypt = "";
//        byte[] iv = user.getIv().getIv();
//
//        try {
//            decrypt = CipherUtils.decryptString(KEY, encrypt, iv);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        user.setPassword(decrypt);
//        return user;
    }

    @Override//修改會員資料
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
