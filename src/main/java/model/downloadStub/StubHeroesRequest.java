package model.downloadStub;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class StubHeroesRequest {
    @JsonProperty("result")
    public StubHeroesList result;
}
