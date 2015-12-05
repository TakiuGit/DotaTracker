package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class AbilityUpgrade {
    @JsonProperty("ability")
    int ability;
    @JsonProperty("time")
    int time;
    @JsonProperty("level")
    int level;
}
