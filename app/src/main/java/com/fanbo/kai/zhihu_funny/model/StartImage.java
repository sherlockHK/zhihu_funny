package com.fanbo.kai.zhihu_funny.model;

import com.fanbo.kai.zhihu_funny.model.base.BaseModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by HK on 2017/1/23.
 * Email: kaihu1989@gmail.com.
 */
@Entity
public class StartImage extends BaseModel {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "text")
    private String text;
    @Property(nameInDb = "img")
    private String img;

    @Generated(hash = 579295296)
    public StartImage(Long id, String text, String img) {
        this.id = id;
        this.text = text;
        this.img = img;
    }

    @Generated(hash = 764831010)
    public StartImage() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
