public class ScoreCard {
    private int player_1,player_2;

    public ScoreCard()
    {
        player_1 = 0;
        player_2 = 0;
    }

    public int getPlayer_1() {
        return player_1;
    }

    public void setPlayer_1(int player_1) {
        this.player_1 = player_1;
    }

    public int getPlayer_2() {
        return player_2;
    }

    public void setPlayer_2(int player_2) {
        this.player_2 = player_2;
    }

    public void print_score(char player_value_1,char player_value_2)
    {
        if(player_1 >= player_2)
        {
            System.out.println("Player "+player_value_1+" -> "+player_1);
            System.out.println("Player "+player_value_2+" -> "+player_2);
        }
        else
        {
            System.out.println("Player "+player_value_2+" -> "+player_2);
            System.out.println("Player "+player_value_1+" -> "+player_1);
        }
    }
}
