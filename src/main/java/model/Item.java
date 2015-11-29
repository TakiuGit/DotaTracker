package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by paulu_000 on 29/11/2015.
 */
public class Item {
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("cost")
    int cost;
    @JsonProperty("secret_shop")
    boolean secretShop;
    @JsonProperty("side_shop")
    boolean sideShop;
    @JsonProperty("recipe")
    boolean recipe;
}
