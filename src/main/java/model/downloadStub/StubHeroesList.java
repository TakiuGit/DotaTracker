package model.downloadStub;

import model.Heroes;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class StubHeroesList {
    @JsonProperty("heroes")
    public List<Heroes> heroes;
    @JsonProperty("status")
    public String status;
    @JsonProperty("count")
    public String count;

    public List<Heroes> getHeroes() {
        return heroes;
    }
}
