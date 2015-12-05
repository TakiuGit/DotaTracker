package model.downloadStub;

import model.PickBan;
import model.PlayerMatchInfo;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class StubMatchDetail {
    @JsonProperty("players")
    List<PlayerMatchInfo> players = new ArrayList<>();

    @JsonProperty("radiant_win")
    public boolean radiantWin;
    @JsonProperty("duration")
    public int duration;
    @JsonProperty("start_time")
    public long startTime;
    @JsonProperty("match_id")
    public long matchId;
    @JsonProperty("match_seq_num")
    public long matchSeqNum;
    @JsonProperty("tower_status_radiant")
    public int towerStatusRadiant;
    @JsonProperty("tower_status_dire")
    public int towerStatusDire;
    @JsonProperty("barracks_status_radiant")
    public int barracksStatusRadiant;
    @JsonProperty("barracks_status_dire")
    public int barracksStatusDire;
    @JsonProperty("cluster")
    public int cluster;
    @JsonProperty("first_blood_time")
    public int fisrtBloodTime;
    @JsonProperty("lobby_type")
    public int lobbyType;
    @JsonProperty("human_players")
    public int humanPlayers;
    @JsonProperty("leagueid")
    public int leagueId;
    @JsonProperty("positive_votes")
    public int positiveVotes;
    @JsonProperty("negative_votes")
    public int negativeVotes;
    @JsonProperty("game_mode")
    public int gameMode;
    @JsonProperty("engine")
    public int engine;
    @JsonProperty("radiant_team_id")
    public int radiantTreamId;
    @JsonProperty("radiant_name")
    public String radiantName;
    @JsonProperty("radiant_team_name")
    public String radiantTeamName;
    @JsonProperty("radiant_logo")
    public long radiantLogo;
    @JsonProperty("radiant_team_complete")
    public int radiantTeamComplete;
    @JsonProperty("radiant_captain")
    public int radiantCaptain;
    @JsonProperty("dire_team_id")
    public int direTeamId;
    @JsonProperty("dire_name")
    public String direName;
    @JsonProperty("dire_logo")
    public String direLogo;
    @JsonProperty("dire_team_complete")
    public String direTeamComplete;
    @JsonProperty("dire_captain")
    public int direCaptain;
    @JsonProperty("picks_bans")
    public List<PickBan> picksBans = new ArrayList<>();

}
