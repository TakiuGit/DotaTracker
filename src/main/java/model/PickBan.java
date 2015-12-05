package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class PickBan {
    @JsonProperty("is_pick")
    boolean isPick;
    @JsonProperty("hero_id")
    int heroId;
    @JsonProperty("team")
    int team;
    @JsonProperty("order")
    int order;
}
