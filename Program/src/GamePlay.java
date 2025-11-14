import java.util.Scanner;

public class GamePlay {
    private Board board = new Board();
    private Roles roles = new Roles();
    private CoreLogic cl;
    private ScoreCard score = new ScoreCard();
    private Scanner scanner = new Scanner(System.in);
    public void play()
    {
        boolean condition = true;
        boolean approve;
        System.out.println("Are You Ready to start the game?");
        System.out.println("1.Play");
        System.out.println("2.Exit");
        int v = scanner.nextInt();
        while (v == 1 && condition) {
            int user_value;
            approve = true;
            while (true) {
                System.out.println("#### Now Player - "+roles.getPlayer_1()+" ####");
                System.out.print("Enter the number between 1 to 9 (1 and 9 inclusive) based on row and column : ");
                user_value = scanner.nextInt();
                while (user_value < 1 || user_value > 9) {
                    System.out.print("Wrong input Enter the number in between 1 to 9 (1 and 9 inclusive) : ");
                    user_value = scanner.nextInt();
                }
                if (board.check_value(user_value)) {
                    board.player_1(user_value, roles.getPlayer_1());
                    board.print_board();
                    cl = new CoreLogic(board.getBoard());
                    if (cl.game_logic(roles.getPlayer_1(), user_value)) {
                        System.out.println("Player - "+roles.getPlayer_1()+" Won The Game");
                        score.setPlayer_1(score.getPlayer_1()+1);
                        System.out.print("Are you want to check Score Board (y/n) : ");
                        scanner.nextLine();
                        String value = scanner.next();
                        if(value.equals("y") || value.equals("Y"))
                        {
                            score.print_score(roles.getPlayer_1(), roles.getPlayer_2());
                        }
                        char player_value = roles.getPlayer_1();
                        roles.setPlayer_1(roles.getPlayer_2());
                        roles.setPlayer_2(player_value);
                        int player_score = score.getPlayer_1();
                        score.setPlayer_1(score.getPlayer_2());
                        score.setPlayer_2(player_score);
                        System.out.print("Are you want to play again (y/n) : ");
                        value = scanner.next();
                        if (value.equals("n") || value.equals("N")) condition = false;
                        else board.delete_board();
                        approve = false;
                    } else if (cl.draw_logic()) {
                        System.out.println("Match Draw");
                        System.out.print("Are you want to check Score Board (y/n) : ");
                        scanner.nextLine();
                        String value = scanner.next();
                        if(value.equals("y") || value.equals("Y"))
                        {
                            score.print_score(roles.getPlayer_1(), roles.getPlayer_2());
                        }
                        System.out.print("Are you want to play again (y/n) : ");
                        value = scanner.next();
                        if (value.equals("n") || value.equals("N")) condition = false;
                        else board.delete_board();
                        approve = false;
                    }
                    break;
                } else {
                    System.out.println("Kindly Enter the valid box");
                }
            }
            if (approve) {
                while (true) {
                    System.out.println("#### Now Another Player - "+roles.getPlayer_2()+" ####");
                    System.out.print("Enter the number between 1 to 9 (1 and 9 inclusive) based on row and column : ");
                    user_value = scanner.nextInt();
                    while (user_value < 1 || user_value > 9) {
                        System.out.print("Wrong input Enter the number in between 1 to 9 (1 and 9 inclusive) : ");
                        user_value = scanner.nextInt();
                    }
                    if (board.check_value(user_value)) {
                        board.player_2(user_value, roles.getPlayer_2());
                        board.print_board();
                        cl = new CoreLogic(board.getBoard());
                        if (cl.game_logic(roles.getPlayer_2(), user_value)) {
                            System.out.println("Player - "+roles.getPlayer_2()+" Won The Game");
                            score.setPlayer_2(score.getPlayer_2()+1);
                            System.out.print("Are you want to check Score Board (y/n) : ");
                            scanner.nextLine();
                            String value = scanner.next();
                            if(value.equals("y") || value.equals("Y"))
                            {
                                score.print_score(roles.getPlayer_1(), roles.getPlayer_2());
                            }
                            System.out.print("Are you want to play again (y/n) : ");
                            value = scanner.next();
                            if (value.equals("n") || value.equals("N")) condition = false;
                            else board.delete_board();
                        } else if (cl.draw_logic()) {
                            System.out.println("Match Draw");
                            System.out.print("Are you want to check Score Board (y/n) : ");
                            scanner.nextLine();
                            String value = scanner.next();
                            if(value.equals("y") || value.equals("Y"))
                            {
                                score.print_score(roles.getPlayer_1(), roles.getPlayer_2());
                            }
                            System.out.print("Are you want to play again (y/n) : ");
                            value = scanner.next();
                            if (value.equals("n") || value.equals("N")) condition = false;
                            else board.delete_board();
                        }
                        break;
                    } else {
                        System.out.println("Kindly Enter the valid box");
                    }
                }
            }
        }
        System.out.println("Thanks for spending time to play our game have a great day");
    }
}