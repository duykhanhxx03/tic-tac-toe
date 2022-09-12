import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board mainGame = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean isXTurn = true;
        boolean isEnd = false;
        while (!isEnd) {
            if (mainGame.isBoardFull()) {
                isEnd = true;
            }
            if (isXTurn && !mainGame.isBoardFull()) {
                while (true) {
                    int x, y;
                    System.out.println("X turn");
                    mainGame.display();
                    System.out.print("Enter x, y: ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    if (mainGame.isValidMove(x, y)) {
                        mainGame.newMove(x, y, isXTurn);
                        mainGame.display();
                        break;
                    } else {
                        System.out.println("Invalid!");
                    }
                }
                if (mainGame.isWin()) {
                    System.out.println("X Win!");
                    isEnd = true;
                } else {
                    isXTurn = false;
                }
            }
            if (!isXTurn && !mainGame.isBoardFull()) {
                while (true) {
                    int x, y;
                    System.out.println("O turn");
                    mainGame.display();
                    System.out.print("Enter x, y: ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    if (mainGame.isValidMove(x, y)) {
                        mainGame.newMove(x, y, isXTurn);
                        mainGame.display();
                        break;
                    } else {
                        System.out.println("Invalid!");
                    }
                }
                if (mainGame.isWin()) {
                    System.out.println("O Win!");
                    isEnd = true;
                } else {
                    isXTurn = true;
                }
            }

        }
    }
}
