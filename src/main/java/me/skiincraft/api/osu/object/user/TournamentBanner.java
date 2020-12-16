package me.skiincraft.api.osu.object.user;

public class TournamentBanner {

    private final long id;
    private final int tournamentId;
    private final String image;

    public TournamentBanner(long id, int tournamentId, String image) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public String getImage() {
        return image;
    }
}
