package me.skiincraft.api.osu.object.user;

public class Grade {

    private final int ss, ssh, s, sh, a;

    public Grade(int ss, int ssh, int s, int sh, int a) {
        this.ss = ss;
        this.ssh = ssh;
        this.s = s;
        this.sh = sh;
        this.a = a;
    }

    public int getSS() {
        return ss;
    }

    public int getSsh() {
        return ssh;
    }

    public int getS() {
        return s;
    }

    public int getSh() {
        return sh;
    }

    public int getA() {
        return a;
    }
}
