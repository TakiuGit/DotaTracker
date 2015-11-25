package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class stubHeroesList {
    @JsonProperty("heroes")
    public List<Heroes> heroes;
    @JsonProperty("status")
    String status;
    @JsonProperty("count")
    String count;

    public List<Heroes> getHeroes() {
        return heroes;
    }
}
