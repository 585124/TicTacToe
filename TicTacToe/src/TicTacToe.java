import java.util.Random;
import java.util.Scanner;

/*
**************************************
**************************************
*FERDIG SPILL* CODING WITH JOHN
**************************************
**************************************
 */

public class TicTacToe {

    public static void main(String[] args) {
        /*
        Ønsker å gjøre slik at brukeren selv kan taste
        inn verdiene de ønsker ved hjelp av Scanner.
         */
        Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' ' },
                          {' ', ' ', ' ' },
                          {' ', ' ', ' ' }};
        //Kaller på denne når vi ønsker å hente ut formatet av spillet.
        //printBoard(board);
        printBoard(board);
        while (true){
            playerTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            computerTurn(board);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);
        }

    }

    private static boolean isGameFinished(char[][] board) {
        //Refererer til hasContestantWon metoden. Her sjekker eg om spilleren har vunnet
        if (hasContestantWon(board, 'X')){
        printBoard(board);
        System.out.println("Player wins!");
            return true;
        }
        //Her sjekker eg om maskinen har vunnet.
        if (hasContestantWon(board, 'O')){
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        }
        //Her sjekker eg om spillet ender uavgjort. Koden går gjennom alle plasser som er ledig.
        //Når det ikke lengre er ledige plasser så vil spillet slutte, så lenge ingen har vunnet.
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Game ended in a tie");
        return true;
    }

    //Metode for å se om spiller eller PC har vunnet. Har laget code for alle 6 måter man kan vinne.
    private static boolean hasContestantWon(char[][] board, char symbol) {
        if (    (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1]== symbol && board[2][2] == symbol)  ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2]== symbol && board[2][2] == symbol)  ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1]== symbol && board[2][0] == symbol)){


            return true;
        }
        return false;
    }

    //Koden som gjør at maskinen velger seg en tilfeldig plass å plassere 0.
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9 + 1);
            if (isValidMove(board, Integer.toString(computerMove))){
                break;
            }
        }

        /*
        Under fikk eg engentlig en feilkode, ettersom placeMove vil ta inn
        computerMove som en string. computerMove er erklært som en int variabel,
        noe som tvinger oss til å bruke Integer.toString() metoden for å forvandle computerMove
        til en String.
         */
        System.out.println("Computer choose: " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    //Denne koden gjør at man ikke kan jukse ved å sette en brikke hvor det ikke er ledig
    private static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    //Koden som gjør at man kan skrive inn et tall fra 1-9, som vil avgjøre plassen til X i formatet
    private static void playerTurn(char[][] board, Scanner scanner) {
        String userInput;
        while (true){
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput))
                break;
            else {

                System.out.println(userInput + " is not a valid move!" + "\n" + "Remember, only number 1-9!!!");
                printBoard(board);
            }


        }
        placeMove(board, userInput, 'X');


    }

    private static void placeMove(char[][] board, String position, char symbol ) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;

            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    // For å lage denne til en metode, highlight teksten -> Refactor -> extract method (Ctrl+alt+M)
    //Dette er formatet for brettspillet
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }


}
