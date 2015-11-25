package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class Match {
    @JsonProperty("match_id")
    String matchId;
    @JsonProperty("match_seq_num")
    long matchSeqNum;
    @JsonProperty("start_time")
    long startTime;
    @JsonProperty("lobby_type")
    int lobbyType;
    @JsonProperty("radiant_team_id")
    int radiantTeamId;
    @JsonProperty("dire_team_id")
    int direTeamId;
    @JsonProperty("players")
    List<MatchPlayer> players;

}
