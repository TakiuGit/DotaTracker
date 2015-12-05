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
    List<PlayerMatchInfo> players = new ArrayList<>();
    boolean radiantWin;
    int duration;
    long startTime;
    long matchId;
    long matchSeqNum;
    int towerStatusRadiant;
    int towerStatusDire;
    int barracksStatusRadiant;
    int barracksStatusDire;
    int cluster;
    int fisrtBloodTime;
    int lobbyType;
    int humanPlayer;
    int leagueId;
    int positivesVotes;
    int negativesVotes;
    int gameMode;
    int engine;
    int radiantTreamId;
    String radiantTeamName;
    long radiantLogo;
    int radiantTeamComplete;
    int radiantCaptain;
    int direCaptain;
    List<PickBan> picksBans = new ArrayList<>();

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
}
