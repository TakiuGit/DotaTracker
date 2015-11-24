package model;

/**
 * Created by paulu_000 on 24/11/2015.
 */
public class Heroes {
    private String fullName;
    private String name;
    private int id;
    private String imgUrl;

    public Heroes(String fullName, int id)
    {
        this.fullName = fullName;
        this.name = fullName.substring(14);
        this.imgUrl = Constant.HEROES_IMG_URL + name + '_' + Constant.HEROES_IMG_SIZE ;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
