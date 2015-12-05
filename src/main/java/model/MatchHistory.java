package model;

import model.downloadStub.StubMatchHistoryRequest;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class MatchHistory {

    private List<Match> listMatch = new ArrayList<Match>();
    long accountId = 0;

    // Must be a steam 32  bits ID
    // Load the last 100 match.
    public MatchHistory(long account_id)
    {
        if(account_id > 76561197960265728L )
        {
            account_id -= 76561197960265728L;
        }
        accountId = account_id;
        String fileName = "match_history_"+ account_id +".json";

        DotaReader reader = new DotaReader();

        String url = Constant.MATCH_HISTORY_URL + Constant.STEAM_KEY + "&account_id=" + account_id;
        System.out.println("Dl string : "+ url);
        reader.download(url ,fileName);

        System.out.println(listMatch.size());

        JsonFactory jfactory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper();
        try {
            while (true) {
                JsonParser jParser = jfactory.createJsonParser(new File(fileName));
                StubMatchHistoryRequest request = mapper.readValue(jParser, StubMatchHistoryRequest.class);
                listMatch.addAll(request.request.matches);
                System.out.println("Match add : " + request.request.matches.size());
                if(request.request.resultsRemaining  == 0)
                    break;
                long lastMatchIdGet =  request.request.matches.get(request.request.matches.size()-1).getMatchId();
                reader.download(Constant.MATCH_HISTORY_URL + Constant.STEAM_KEY + "&account_id=" + account_id + "&start_at_match_id=" + lastMatchIdGet,fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Match> getListMatch() {
        return listMatch;
    }

    public float getWinRate()
    {
        int nbWin = 0;
        int count =0;
        for(Match m : listMatch){
            System.out.println("read math detail : " + m.getMatchId() +"("+count +"/"+ listMatch.size()+ ")");
            ++count;
            MatchDetail detail = m.getMatchDetail();
            for(PlayerMatchInfo p : detail.players) {
                if (p.accountId == this.accountId) {
                    if (((p.playerSlot & (1 << 0)) != 0) == detail.radiantWin)
                        ++nbWin;
                }
            }
        }

        return ((float)nbWin) / ((float)listMatch.size());
    }

    public float getWinRate(int objectId)
    {
        //TODO
        return 0;
    }
}
