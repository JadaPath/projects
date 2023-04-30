import java.util.*;

public class ticTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {


        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please enter your placement (1-9);");
            int player1pos = scanner.nextInt();
            while (playerPositions.contains(player1pos) || cpuPositions.contains(playerPositions)) {
                System.out.println("position taken! Enter a new choice");
                player1pos = scanner.nextInt();
            }

            placePiece(gameBoard, player1pos, "player 1");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                System.out.println("position taken! Enter a new choice");
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
            }

        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();

        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';


        if (user.equals("player 1")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }


        if (pos == 1) {
            gameBoard[0][0] = symbol;
        }
        if (pos == 2) {
            gameBoard[0][2] = symbol;
        }
        if (pos == 3) {
            gameBoard[0][4] = symbol;
        }
        if (pos == 4) {
            gameBoard[2][0] = symbol;
        }
        if (pos == 5) {
            gameBoard[2][2] = symbol;
        }
        if (pos == 6) {
            gameBoard[2][4] = symbol;
        }
        if (pos == 7) {
            gameBoard[4][0] = symbol;
        }
        if (pos == 8) {
            gameBoard[4][2] = symbol;
        } else if (pos == 9) {
            gameBoard[4][4] = symbol;
        }
    }

    public static String checkWinner() {


        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List lastRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List diagRow = Arrays.asList(1, 5, 9);
        List diagRow2 = Arrays.asList(3, 5, 7);

        List<List> winningConditons = new ArrayList<List>();
        winningConditons.add(topRow);
        winningConditons.add(midRow);
        winningConditons.add(lastRow);
        winningConditons.add(leftCol);
        winningConditons.add(midCol);
        winningConditons.add(rightCol);
        winningConditons.add(diagRow);
        winningConditons.add(diagRow2);

        for (List winner : winningConditons) {
            if (playerPositions.containsAll(winner)) {
                return "LOOKS LIKE YOU GOT EM' THIS TIME!";
            } else if (cpuPositions.containsAll(winner)) {
                return "CPU WINS! BETTER LUCK NEXT TIME :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "GAME OVER -- NO WINNER";
            }

        }
        return "";
    }
}


