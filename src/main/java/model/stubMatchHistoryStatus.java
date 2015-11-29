package model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by paulu_000 on 25/11/2015.
 */
public class stubMatchHistoryStatus {
    @JsonProperty("status")
    int status;
    @JsonProperty("num_results")
    int numResults;
    @JsonProperty("total_results")
    int totalsResults;
    @JsonProperty("results_remaining")
    int resultsRemaining;
    @JsonProperty("matches")
    List<Match> matches;

    @JsonProperty("statusDetail")
    String statusDetail ;
}
