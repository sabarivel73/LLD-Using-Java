import java.util.*;
import java.io.*;

public class Board {
    private List<List<Character>>board;
    public Board(){
        board = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            List<Character>value = new ArrayList<>();
            for(int j=0;j<3;j++)
            {
                value.add('.');
            }
            board.add(value);
        }
    }
    public void player_1(int value,char player)
    {
        if(value>=1 && value<=3)
        {
            value--;
            board.get(0).set(value, player);
        }
        else if(value>=4 && value<=6)
        {
            value %= 3;
            value--;
            if(value<0) value = 2;
            board.get(1).set(value, player);
        }
        else
        {
            value %= 3;
            value--;
            if(value<0) value = 2;
            board.get(2).set(value, player);
        }
    }
    public void player_2(int value,char player)
    {
        if(value>=1 && value<=3)
        {
            value--;
            board.get(0).set(value, player);
        }
        else if(value>=4 && value<=6)
        {
            value %= 3;
            value--;
            if(value<0) value = 2;
            board.get(1).set(value, player);
        }
        else
        {
            value %= 3;
            value--;
            if(value<0) value = 2;
            board.get(2).set(value, player);
        }
    }
    public boolean check_value(int value)
    {
        if(value>=1 && value<=3)
        {
            value--;
            return board.get(0).get(value)=='.';
        }
        else if(value>=4 && value<=6)
        {
            value %= 3;
            value--;
            if(value<0) value = 2;
            return board.get(1).get(value)=='.';
        }
        else if(value>=7 && value<=9){
            value %= 3;
            value--;
            if (value < 0) value = 2;
            return board.get(2).get(value) == '.';
        }
        return false;
    }
    public void print_board()
    {
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board.get(i).size();j++)
            {
                System.out.print(board.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public List<List<Character>> getBoard() {
        return board;
    }
    public void delete_board()
    {
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board.get(i).size();j++)
            {
                board.get(i).set(j,'.');
            }
        }
    }
}