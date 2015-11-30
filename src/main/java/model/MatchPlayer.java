package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by paulu_000 on 25/11/2015.
 */
    public class MatchPlayer {
    @JsonProperty("account_id")
    long accountId;
    @JsonProperty("player_slot")
    int playerSlot;
    @JsonProperty("hero_id")
    int heroId;
}
