public class Board {
    public CellStatus[][] mainBoardStatus = new CellStatus[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mainBoardStatus[i][j] = CellStatus.UNK;
            }
        }
    }

    public boolean isBoardFull() {
        boolean flags = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mainBoardStatus[i][j].equals(CellStatus.UNK)) {
                    flags = false;
                    break;
                }
            }
        }
        return flags;
    }

    public boolean isWin() {
        //Kiem tra hang ngang, doc
        for (int i = 0; i < 3; i++) {
            int sumOfRows = 0;
            int sumOfColumn = 0;
            for (int j = 0; j < 3; j++) {
                if (mainBoardStatus[i][j].equals(CellStatus.X)) sumOfRows += 1;
                if (mainBoardStatus[i][j].equals(CellStatus.O)) sumOfRows -= 1;

                if (mainBoardStatus[j][i].equals(CellStatus.X)) sumOfColumn += 1;
                if (mainBoardStatus[j][i].equals(CellStatus.O)) sumOfColumn -= 1;
            }
            if (sumOfRows == 3 || sumOfRows == -3 || sumOfColumn == 3 || sumOfColumn == -3) {
                return true;
            }
        }

        //Kiem tra duong cheo
        int sumOfDiagonal_1 = 0; //duong cheo 1
        int sumOfDiagonal_2 = 0; //duong cheo 2
        for (int i = 0; i < 3; i++) {
            //Neu o la X
            if (mainBoardStatus[i][i].equals(CellStatus.X)) sumOfDiagonal_1 += 1;
            if (mainBoardStatus[i][3 - i - 1].equals(CellStatus.X)) sumOfDiagonal_2 += 1;

            //Neu o la  O
            if (mainBoardStatus[i][i].equals(CellStatus.O)) sumOfDiagonal_1 -= 1;
            if (mainBoardStatus[i][3 - i - 1].equals(CellStatus.O)) sumOfDiagonal_2 -= 1;
        }
        if (sumOfDiagonal_1 == 3 || sumOfDiagonal_1 == -3 || sumOfDiagonal_2 == 3 || sumOfDiagonal_2 == -3) return true;
        return false;
    }

    public void newMove(int x, int y, boolean isXTurn) {
        if (isXTurn) {
            mainBoardStatus[x - 1][y - 1] = CellStatus.X;
        } else mainBoardStatus[x - 1][y - 1] = CellStatus.O;
    }

    public boolean isValidMove(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            return false;
        }
        return mainBoardStatus[x - 1][y - 1].equals(CellStatus.UNK) ? true : false;
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mainBoardStatus[i][j].equals(CellStatus.X)) System.out.print("[X]");
                else if (mainBoardStatus[i][j].equals(CellStatus.O)) System.out.print("[O]");
                else System.out.print("[ ]");
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}
