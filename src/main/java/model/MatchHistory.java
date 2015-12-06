package model;

import model.downloadStub.StubMatchHistoryRequest;
import model.viewStub.StubHeroView;
import model.viewStub.StubItemView;
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
        int count = 0;
        for(Match m : listMatch){
            ++count;
            System.out.println("read math detail : " + m.getMatchId() +"("+count +"/"+ listMatch.size()+ ")");
            MatchDetail detail = m.getMatchDetail();
            for(PlayerMatchInfo p : detail.getPlayers()) {
                if (p.getAccountId() == this.accountId) {
                    if (((p.getPlayerSlot() >>> 8) != 0) == detail.isRadiantWin())
                        ++nbWin;
                }
            }
        }

        return ((float)nbWin) / ((float)listMatch.size());
    }

    public float getWinRate(int objectId)
    {
        int nbWin = 0;
        int count = 0;
        for(Match m : listMatch){
            System.out.println("read math detail : " + m.getMatchId() +"("+count +"/"+ listMatch.size()+ ")");
            ++count;
            MatchDetail detail = m .getMatchDetail();
            for(PlayerMatchInfo p : detail.getPlayers()) {
                if (p.getAccountId() == this.accountId) {
                    if (((p.getPlayerSlot()  >>> 8) != 0) == detail.isRadiantWin())
                        if(p.getItemZero() == objectId ||p.getItemOne() == objectId || p.getItemTwo() == objectId || p.getItemThree() == objectId || p.getItemFour() == objectId ||p.getItemFive() == objectId )
                             ++nbWin;
                }
            }
        }
        return (float)nbWin / (float)count;
    }

    public StubItemView getAllItemsInformationForDisplay(int objectId){
        System.out.println("Get items informations... id : "+ objectId);
        int nbWin = 0;
        int nbUse = 0;
        for(Match m : listMatch){
            MatchDetail detail = m .getMatchDetail();
            for(PlayerMatchInfo p : detail.getPlayers()) {
                if (p.getAccountId() == this.accountId) {
                    if(p.getItemZero() == objectId ||p.getItemOne() == objectId || p.getItemTwo() == objectId || p.getItemThree() == objectId || p.getItemFour() == objectId ||p.getItemFive() == objectId ){
                        ++nbUse;
                        if (((p.getPlayerSlot() & (1 << 0)) != 0) == detail.isRadiantWin())
                            ++nbWin;
                    }
                }
            }
        }

        Item i = Items.getInstance().getItem(objectId);
        if(nbUse == 0)
            nbUse = 1;
        return new StubItemView(i.getClearName(),objectId, (float)nbWin /(float)nbUse,i.getCost(),nbUse, (float)nbUse/ (float)listMatch.size());
    }

    public StubHeroView getAllHeroesInformationForDisplay(int heroId) {
        System.out.println("Get heroes informations... id : "+ heroId);
        int nbWin = 0;
        int nbUse = 0;
        for(Match m : listMatch){
            MatchDetail detail = m .getMatchDetail();
            for(PlayerMatchInfo p : detail.getPlayers()) {
                if (p.getAccountId() == this.accountId) {
                    if(p.getHeroId() == heroId){
                        ++nbUse;
                        if (((p.getPlayerSlot() & (1 << 0)) != 0) == detail.isRadiantWin())
                            ++nbWin;
                    }
                }
            }
        }

        Heroes h = HeroesList.getInstance().getHero(heroId);
        if(nbUse == 0)
            nbUse = 1;
        return new StubHeroView(h.getClearName(),heroId, (float)nbWin /(float)nbUse,nbUse, (float)nbUse/ (float)listMatch.size());
    }
}
