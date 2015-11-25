package model;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class MatchHistory {
    List<Match> listMatch ;

    // Must be a steam 32  bits ID
    // Load the last 100 match.
    public MatchHistory(long account_id)
    {
        if(account_id > 76561197960265728L )
        {
            account_id -= 76561197960265728L;
        }
        DotaReader reader = new DotaReader();
        reader.download(Constant.HEROES_LIST_URL + Constant.STEAM_KEY,"list_heroes.json");

        JsonFactory jfactory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonParser jParser = jfactory.createJsonParser(new File("list_heroes.json"));
            stubMatchHistoryRequest request = mapper.readValue(jParser,stubMatchHistoryRequest.class);
            listMatch.addAll(request.request.matches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Match> getListMatch() {
        return listMatch;
    }
}
