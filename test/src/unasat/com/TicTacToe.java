package unasat.com;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private final String[] COLORS = {
            "\033[31m", // Red
            "\033[32m", // Green
            "\033[33m", // Yellow
            "\033[34m", // Blue
            "\033[35m", // Magenta
            "\033[36m", // Cyan
            "\033[37m", // White
            "\033[91m", // Bright Red
            "\033[92m"  // Bright Green
    };

    public TicTacToe() {
        initializeBoard();
    }

    public void initializeBoard() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) (count + '0');
                count++;
            }
        }
    }

    public void printBoard() {
        int colorIndex = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    if (board[i][j] == 'X') {
                        System.out.print("\033[41m" + "\033[30m" + board[i][j] + "\033[0m | ");
                    } else if (board[i][j] == 'O') {
                        System.out.print("\033[44m" + "\033[30m" + board[i][j] + "\033[0m | ");
                    } else {
                        System.out.print(COLORS[colorIndex % COLORS.length] + board[i][j] + "\033[0m | ");
                    }
                } else {
                    if (board[i][j] == 'X') {
                        System.out.print("\033[41m" + "\033[30m" + board[i][j] + "\033[0m");
                    } else if (board[i][j] == 'O') {
                        System.out.print("\033[44m" + "\033[30m" + board[i][j] + "\033[0m");
                    } else {
                        System.out.print(COLORS[colorIndex % COLORS.length] + board[i][j] + "\033[0m");
                    }
                }
                colorIndex++;
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && (board[i][0] == 'X' || board[i][0] == 'O')) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && (board[0][i] == 'X' || board[0][i] == 'O')) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && (board[0][2] == 'X' || board[0][2] == 'O')) {
            return true;
        }
        return false;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean placeMark(int cell) {
        int row = (cell - 1) / 3;
        int col = (cell - 1) % 3;

        if (board[row][col] != 'X' && board[row][col] != 'O') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
