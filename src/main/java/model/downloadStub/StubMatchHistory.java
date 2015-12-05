package model.downloadStub;

import model.Match;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class StubMatchHistory {
    @JsonProperty("status")
    public int status;
    @JsonProperty("num_results")
    public int numResults;
    @JsonProperty("total_results")
    public int totalsResults;
    @JsonProperty("results_remaining")
    public int resultsRemaining;
    @JsonProperty("matches")
    public List<Match> matches;

    @JsonProperty("statusDetail")
    public String statusDetail ;
}
