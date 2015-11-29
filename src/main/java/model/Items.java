package model;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.annotate.JsonProperty;
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

    public Items()
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
            stubItemsRequest request = mapper.readValue(jParser, stubItemsRequest.class);
            items.addAll(request.items.items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
