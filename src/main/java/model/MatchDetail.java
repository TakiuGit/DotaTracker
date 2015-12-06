package model;

import model.downloadStub.StubMatchDetail;
import model.downloadStub.StubMatchDetailRequest;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * File created by Paul NOFERI on 05/12/2015 at ESILV
 */
public class MatchDetail {
    private List<PlayerMatchInfo> players = new ArrayList<>();
    private boolean radiantWin;
    private int duration;
    private long startTime;
    private long matchId;
    private long matchSeqNum;
    private int towerStatusRadiant;
    private int towerStatusDire;
    private int barracksStatusRadiant;
    private int barracksStatusDire;
    private int cluster;
    private int fisrtBloodTime;
    private int lobbyType;
    private int humanPlayer;
    private int leagueId;
    private int positivesVotes;
    private int negativesVotes;
    private int gameMode;
    private int engine;
    private int radiantTreamId;
    private String radiantTeamName;
    private long radiantLogo;
    private int radiantTeamComplete;
    private int radiantCaptain;
    private int direCaptain;
    private List<PickBan> picksBans = new ArrayList<>();

    public MatchDetail(long matchId)
    {
        String fileName = "match_detail_"+ matchId +".json";

        File f = new File(fileName);
        if( !f.exists()){
            DotaReader reader = new DotaReader();
            String url = Constant.MATCH_DETAIL_URL + Constant.STEAM_KEY + "&match_id=" + matchId;
            System.out.println("Dl string : "+ url);
            reader.download(url ,fileName);
        }

        JsonFactory jfactory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonParser jParser = jfactory.createJsonParser(new File(fileName));
            StubMatchDetailRequest request = mapper.readValue(jParser, StubMatchDetailRequest.class);
            StubMatchDetail stub = request.request;
            initWithStub(stub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initWithStub(StubMatchDetail stub){
        this.players = stub.players;
        this.radiantWin = stub.radiantWin;
        this.duration = stub.duration;
        this.startTime = stub.startTime;
        this.matchId = stub.matchId;
        this.matchSeqNum = stub.matchSeqNum;
        this.towerStatusRadiant = stub.towerStatusRadiant;
        this.towerStatusDire = stub.towerStatusDire;
        this.barracksStatusRadiant = stub.barracksStatusRadiant;
        this.barracksStatusDire = stub.barracksStatusDire;
        this.cluster = stub.cluster;
        this.fisrtBloodTime = stub.fisrtBloodTime;
        this.lobbyType = stub.lobbyType;
        this.humanPlayer = stub.humanPlayers;
        this.leagueId = stub.leagueId;
        this.positivesVotes = stub.positiveVotes;
        this.negativesVotes = stub.negativeVotes;
        this.gameMode = stub.gameMode;
        this.engine = stub.engine;
        this.radiantTreamId = stub.radiantTreamId;
        this.radiantTeamName = stub.radiantTeamName;
        this.radiantLogo = stub.radiantLogo;
        this.radiantTeamComplete = stub.radiantTeamComplete;
        this.radiantCaptain = stub.radiantCaptain;
        this.direCaptain = stub.direCaptain;
        this.picksBans = stub.picksBans;
    }

    public List<PlayerMatchInfo> getPlayers() {
        return players;
    }

    public boolean isRadiantWin() {
        return radiantWin;
    }

    public int getDuration() {
        return duration;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getMatchId() {
        return matchId;
    }

    public long getMatchSeqNum() {
        return matchSeqNum;
    }

    public int getTowerStatusRadiant() {
        return towerStatusRadiant;
    }

    public int getTowerStatusDire() {
        return towerStatusDire;
    }

    public int getBarracksStatusRadiant() {
        return barracksStatusRadiant;
    }

    public int getBarracksStatusDire() {
        return barracksStatusDire;
    }

    public int getCluster() {
        return cluster;
    }

    public int getFisrtBloodTime() {
        return fisrtBloodTime;
    }

    public int getLobbyType() {
        return lobbyType;
    }

    public int getHumanPlayer() {
        return humanPlayer;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public int getPositivesVotes() {
        return positivesVotes;
    }

    public int getNegativesVotes() {
        return negativesVotes;
    }

    public int getGameMode() {
        return gameMode;
    }

    public int getEngine() {
        return engine;
    }

    public int getRadiantTreamId() {
        return radiantTreamId;
    }

    public String getRadiantTeamName() {
        return radiantTeamName;
    }

    public void setRadiantTeamName(String radiantTeamName) {
        this.radiantTeamName = radiantTeamName;
    }

    public long getRadiantLogo() {
        return radiantLogo;
    }

    public int getRadiantTeamComplete() {
        return radiantTeamComplete;
    }

    public int getRadiantCaptain() {
        return radiantCaptain;
    }

    public int getDireCaptain() {
        return direCaptain;
    }

    public List<PickBan> getPicksBans() {
        return picksBans;
    }
}
