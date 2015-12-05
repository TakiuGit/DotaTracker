package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class AdditionalUnit {
    @JsonProperty("unitname")
    String name;
    @JsonProperty("item_0")
    int itemZero;
    @JsonProperty("item_1")
    int itemOne;
    @JsonProperty("item_2")
    int itemTwo;
    @JsonProperty("item_3")
    int itemThree;
    @JsonProperty("item_4")
    int itemFour;
    @JsonProperty("item_5")
    int itemFive;

}
