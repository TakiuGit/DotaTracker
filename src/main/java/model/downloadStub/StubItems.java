package model.downloadStub;

import model.Item;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulu_000 on 29/11/2015.
 */
public class StubItems {
    @JsonProperty("items")
    public List<Item> items = new ArrayList<Item>();
    @JsonProperty("status")
    public int status;
}
