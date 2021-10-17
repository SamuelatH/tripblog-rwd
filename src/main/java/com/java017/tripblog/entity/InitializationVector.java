package com.java017.tripblog.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;

/**
 * @author YuCheng
 * @date 2021/9/26 - 下午 10:30
 */

@Entity
@Table(name = "InitializationVector")
public class InitializationVector {

    //編號
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //向量值
    @NotEmpty(message = "向量不能為空值")
    @Lob
    private byte[] iv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    @Override
    public String toString() {
        return "InitializationVector{" +
                "id=" + id +
                ", iv=" + Arrays.toString(iv) +
                '}';
    }
}
