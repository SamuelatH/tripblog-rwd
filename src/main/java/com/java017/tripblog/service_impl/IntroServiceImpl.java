package com.java017.tripblog.service_impl;

import com.java017.tripblog.repository.IntroRepository;
import com.java017.tripblog.entity.Intro;
import com.java017.tripblog.service.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sandy
 * @date
 */

@Service
public class IntroServiceImpl implements IntroService {


    private IntroRepository introRepository;

    @Autowired
    public IntroServiceImpl(IntroRepository introRepository) {
        this.introRepository = introRepository;
    }

    @Override//更新自我介紹頁面資訊
    public Intro editIntro(Intro intro) {
        return introRepository.save(intro);
    }

    @Override
    public Intro showIntroData(Long id) {
        Intro intro =  introRepository.findById(id).orElse(null);
        return intro;
    }
}
