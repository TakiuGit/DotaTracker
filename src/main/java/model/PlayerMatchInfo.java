package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class PlayerMatchInfo {
    @JsonProperty("account_id")
    long accountId;
    @JsonProperty("player_slot")
    byte playerSlot;
    @JsonProperty("hero_id")
    int heroId;
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
    @JsonProperty("kills")
    int kills;
    @JsonProperty("deaths")
    int deaths;
    @JsonProperty("assists")
    int assists;
    @JsonProperty("leaver_status")
    int leaverStatus;
    @JsonProperty("gold")
    int gold;
    @JsonProperty("last_hits")
    int lastHits;
    @JsonProperty("denies")
    int denies;
    @JsonProperty("gold_per_min")
    int goldPerMin;
    @JsonProperty("xp_per_min")
    int xpPerMin;
    @JsonProperty("gold_spent")
    int goldSpent;
    @JsonProperty("hero_damage")
    int heroDamage;
    @JsonProperty("tower_damage")
    int towerDamage;
    @JsonProperty("hero_healing")
    int heroHealing;
    @JsonProperty("level")
    int level;
    @JsonProperty("ability_upgrades")
    List<AbilityUpgrade> abilityUpgradeList  = new ArrayList<AbilityUpgrade>();
    @JsonProperty("additional_units")
    public List<AdditionalUnit> additionalUnits;

}
