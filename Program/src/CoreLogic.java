import javax.swing.*;
import java.util.List;

public class CoreLogic {
    private List<List<Character>> board_value;
    public CoreLogic(List<List<Character>> value)
    {
        board_value = value;
    }
    public boolean draw_logic()
    {
        for(int i=0;i<board_value.size();i++)
        {
            for(int j=0;j<board_value.size();j++)
            {
                if(board_value.get(i).get(j)=='.') return false;
            }
        }
        return true;
    }
    public boolean game_logic(char player,int index)
    {
        int row,column;
        if(index>=1 && index<=3)
        {
            row = 0;
            column = --index;
        }
        else if(index>=4 && index<=6)
        {
            row = 1;
            column = index%3-1;
            if(column<0) column = 2;
        }
        else {
            row = 2;
            column = index%3-1;
            if(column<0) column = 2;
        }
        if(board_value.get(row).get(0)==player && board_value.get(row).get(1)==player && board_value.get(row).get(2)==player)  return true;
        else if(board_value.get(0).get(column)==player && board_value.get(1).get(column)==player && board_value.get(2).get(column)==player)  return true;
        else if(board_value.get(0).get(0)==player && board_value.get(1).get(1)==player && board_value.get(2).get(2)==player) return true;
        else return board_value.get(0).get(2) == player && board_value.get(1).get(1) == player && board_value.get(2).get(0) == player;
    }
}