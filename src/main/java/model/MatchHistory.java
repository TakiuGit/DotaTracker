package model;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class MatchHistory {
    List<Match> listMatch = new ArrayList<Match>();

    // Must be a steam 32  bits ID
    // Load the last 100 match.
    public MatchHistory(long account_id)
    {
        if(account_id > 76561197960265728L )
        {
            account_id -= 76561197960265728L;
        }
        String fileName = "match_history_"+ account_id +".json";

        DotaReader reader = new DotaReader();
        Date now = new Date();
        System.out.println("Time : " + now.getTime());

        String url = Constant.MATCH_HISTORY_URL + Constant.STEAM_KEY + "&account_id=" + account_id;
        System.out.println("Dl string : "+ url);
        reader.download(url ,fileName);

        System.out.println(listMatch.size());

        JsonFactory jfactory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper();
        try {
            while (true) {
                JsonParser jParser = jfactory.createJsonParser(new File(fileName));
                stubMatchHistoryRequestTest request = mapper.readValue(jParser, stubMatchHistoryRequestTest.class);
                listMatch.addAll(request.request.matches);
                System.out.println("Match add : " + request.request.matches.size());
                if(request.request.resultsRemaining  == 0)
                    break;
                long lastMatchIdGet =  request.request.matches.get(request.request.matches.size()-1).matchId;
                reader.download(Constant.MATCH_HISTORY_URL + Constant.STEAM_KEY + "&account_id=" + account_id + "&start_at_match_id=" + lastMatchIdGet,fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Match> getListMatch() {
        return listMatch;
    }
}
