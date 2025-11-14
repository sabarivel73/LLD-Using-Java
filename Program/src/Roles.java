public class Roles {
    private Character player_1;
    private Character player_2;

    public Roles()
    {
        player_1 = 'X';
        player_2 = 'O';
    }

    public Character getPlayer_1() {
        return player_1;
    }

    public void setPlayer_1(Character player_1) {
        this.player_1 = player_1;
    }

    public Character getPlayer_2() {
        return player_2;
    }

    public void setPlayer_2(Character player_2) {
        this.player_2 = player_2;
    }
}