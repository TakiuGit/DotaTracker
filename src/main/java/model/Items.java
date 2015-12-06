package model;

import model.downloadStub.StubItemsRequest;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulu_000 on 29/11/2015.
 */
public class Items {
    List<Item> items = new ArrayList<Item>();



    /** Constructeur privé */
    private Items()
    {
        String fileName = "item_list.json";

        DotaReader reader = new DotaReader();
        String url = Constant.ITEM_LIST_URL + Constant.STEAM_KEY ;
        System.out.println("Dl string : "+ url);
        reader.download(url ,fileName);

        JsonFactory jfactory = new JsonFactory();
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonParser jParser = jfactory.createJsonParser(new File(fileName));
            StubItemsRequest request = mapper.readValue(jParser, StubItemsRequest.class);
            items.addAll(request.items.items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Holder */
    private static class SingletonHolder
    {
        /** Instance unique non préinitialisée */
        private final static Items instance = new Items();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static Items getInstance()
    {
        return SingletonHolder.instance;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(int id)
    {
        for(Item i : items)
        {
            if (i.getId() == id)
                return i;
        }
        return null;
    }
}
