package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by paulu_000 on 24/11/2015.
 */
public class Heroes {
    @JsonProperty("name")
    private String name;
    private String shortName;
    @JsonProperty("id")
    private int id;
    private String imgUrl;
    private String clearName;

    public Heroes(String name, int id)
    {
        setName(name);
        this.imgUrl = Constant.HEROES_IMG_URL + name + '_' + Constant.HEROES_IMG_SIZE ;
        this.id = id;
    }

    public Heroes()
    {

    }

    public void setName(String name) {
        this.name = name;
        this.shortName = name.substring(14);
        clearName = shortName.replace('_',' ');
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getClearName() {
        return clearName;
    }
}
