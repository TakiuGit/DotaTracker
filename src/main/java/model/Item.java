package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by paulu_000 on 29/11/2015.
 */
public class Item {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cost")
    private int cost;
    @JsonProperty("secret_shop")
    private boolean secretShop;
    @JsonProperty("side_shop")
    private boolean sideShop;
    @JsonProperty("recipe")
    private boolean recipe;

    public String getName() {
        return name;
    }

    public String getShortName() {
        return name.substring(5);
    }

    public String getClearName()
    {
        return getShortName().replace('_',' ');
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public boolean isSecretShop() {
        return secretShop;
    }

    public boolean isSideShop() {
        return sideShop;
    }

    public String getImageUrl()
    {
        return "http://cdn.dota2.com/apps/dota2/images/items/" + getShortName() +"_lg.png";
    }

    @Override
    public String toString() {
        return "Item : " + id + " " + getClearName();
    }
}
