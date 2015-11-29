package model;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulu_000 on 24/11/2015.
 */
public class HeroesList {
    private List<Heroes> listHeroes = new ArrayList<Heroes>();

    public HeroesList(){
        loadList();
    }

    private void loadList() {
        DotaReader reader = new DotaReader();
        reader.download(Constant.HEROES_LIST_URL + Constant.STEAM_KEY,"list_heroes.json");

        JsonFactory jfactory = new JsonFactory();

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonParser jParser = jfactory.createJsonParser(new File("list_heroes.json"));
            stubHeroesRequestTest list = mapper.readValue(jParser, stubHeroesRequestTest.class);
            listHeroes.addAll(list.result.heroes);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void display()
    {
        for(Heroes h : listHeroes)
        {
            System.out.println(h.getId() + " : " + h.getClearName() );
        }
    }
    public List<Heroes> getListHeroes() {
        return listHeroes;
    }
}
