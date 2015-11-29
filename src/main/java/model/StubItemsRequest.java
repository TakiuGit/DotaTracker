package model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by paulu_000 on 29/11/2015.
 */
public class StubItemsRequest {
    @JsonProperty("result")
    StubItems items;
}
