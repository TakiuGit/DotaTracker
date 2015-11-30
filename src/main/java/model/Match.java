package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class Match {
    @JsonProperty("match_id")
    private long matchId;
    @JsonProperty("match_seq_num")
    private long matchSeqNum;
    @JsonProperty("start_time")
    private long startTime;
    @JsonProperty("lobby_type")
    private int lobbyType;
    @JsonProperty("radiant_team_id")
    private int radiantTeamId;
    @JsonProperty("dire_team_id")
    private int direTeamId;
    @JsonProperty("players")
    private List<MatchPlayer> players;

    public int getDireTeamId() {
        return direTeamId;
    }

    public int getLobbyType() {
        return lobbyType;
    }

    public int getRadiantTeamId() {
        return radiantTeamId;
    }

    public List<MatchPlayer> getPlayers() {
        return players;
    }

    public long getMatchId() {
        return matchId;
    }

    public long getMatchSeqNum() {
        return matchSeqNum;
    }

    public long getStartTime() {
        return startTime;
    }
}
