package me.skiincraft.api.osu.object.score;

public enum ScoreType {

    BEST("get_user_best"), FIRSTS(null), RECENT("get_user_recent");

    private final String apiV1Endpoint;

    ScoreType(String apiV1Endpoint) {
        this.apiV1Endpoint = apiV1Endpoint;
    }

    public String getNameToLowerCase(){
        return name().toLowerCase();
    }

    public String getAPIV1Endpoint() {
        return apiV1Endpoint;
    }
}
