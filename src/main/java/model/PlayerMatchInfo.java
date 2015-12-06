package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class PlayerMatchInfo {
    @JsonProperty("account_id")
    private long accountId;
    @JsonProperty("player_slot")
    private int playerSlot;
    @JsonProperty("hero_id")
    private int heroId;
    @JsonProperty("item_0")
    private int itemZero;
    @JsonProperty("item_1")
    private int itemOne;
    @JsonProperty("item_2")
    private int itemTwo;
    @JsonProperty("item_3")
    private int itemThree;
    @JsonProperty("item_4")
    private int itemFour;
    @JsonProperty("item_5")
    private int itemFive;
    @JsonProperty("kills")
    private int kills;
    @JsonProperty("deaths")
    private int deaths;
    @JsonProperty("assists")
    private int assists;
    @JsonProperty("leaver_status")
    private int leaverStatus;
    @JsonProperty("gold")
    private int gold;
    @JsonProperty("last_hits")
    private int lastHits;
    @JsonProperty("denies")
    private int denies;
    @JsonProperty("gold_per_min")
    private int goldPerMin;
    @JsonProperty("xp_per_min")
    private int xpPerMin;
    @JsonProperty("gold_spent")
    private int goldSpent;
    @JsonProperty("hero_damage")
    private int heroDamage;
    @JsonProperty("tower_damage")
    private int towerDamage;
    @JsonProperty("hero_healing")
    private int heroHealing;
    @JsonProperty("level")
    private int level;
    @JsonProperty("ability_upgrades")
    private List<AbilityUpgrade> abilityUpgradeList  = new ArrayList<AbilityUpgrade>();
    @JsonProperty("additional_units")
    private  List<AdditionalUnit> additionalUnits;

    public long getAccountId() {
        return accountId;
    }

    public int getPlayerSlot() {
        return playerSlot;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public int getItemZero() {
        return itemZero;
    }

    public int getItemOne() {
        return itemOne;
    }

    public int getItemTwo() {
        return itemTwo;
    }

    public int getItemThree() {
        return itemThree;
    }

    public int getItemFour() {
        return itemFour;
    }

    public int getItemFive() {
        return itemFive;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public int getLeaverStatus() {
        return leaverStatus;
    }

    public int getGold() {
        return gold;
    }

    public int getLastHits() {
        return lastHits;
    }

    public int getDenies() {
        return denies;
    }

    public int getGoldPerMin() {
        return goldPerMin;
    }

    public void setGoldPerMin(int goldPerMin) {
        this.goldPerMin = goldPerMin;
    }

    public int getXpPerMin() {
        return xpPerMin;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public int getHeroDamage() {
        return heroDamage;
    }

    public int getTowerDamage() {
        return towerDamage;
    }

    public int getHeroHealing() {
        return heroHealing;
    }

    public int getLevel() {
        return level;
    }

    public List<AbilityUpgrade> getAbilityUpgradeList() {
        return abilityUpgradeList;
    }

    public List<AdditionalUnit> getAdditionalUnits() {
        return additionalUnits;
    }
}
