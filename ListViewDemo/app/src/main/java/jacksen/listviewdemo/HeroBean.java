package jacksen.listviewdemo;

import android.support.annotation.IdRes;

/**
 * Created by Admin on 2016/6/15.
 */

public class HeroBean {

    @IdRes
    private int imgRes;
    private String name;
    private String introduce;

    public HeroBean() {
    }

    public HeroBean(int imgRes, String name, String introduce) {
        this.imgRes = imgRes;
        this.introduce = introduce;
        this.name = name;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
