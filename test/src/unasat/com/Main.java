package unasat.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;

        while (user == null) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                user = User.register(scanner);
            } else if (choice == 2) {
                user = User.login(scanner);
            }
        }

        while (true) {
            System.out.println("1. Start new game");
            System.out.println("2. View top scores");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                startNewGame(user, scanner);
            } else if (choice == 2) {
                viewTopScores();
            } else if (choice == 3) {
                break;
            }
        }

        scanner.close();
    }

    private static void startNewGame(User user, Scanner scanner) {
        TicTacToe game = new TicTacToe();
        boolean gameEnded = false;

        while (!gameEnded) {
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn. Enter a cell number (1-9): ");
            int cell = scanner.nextInt();

            if (cell < 1 || cell > 9) {
                System.out.println("Invalid cell number. Try again.");
                continue;
            }

            if (game.placeMark(cell)) {
                if (game.checkForWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    saveScore(user, 1);
                    gameEnded = true;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("The game is a tie!");
                    saveScore(user, 0);
                    gameEnded = true;
                } else {
                    game.changePlayer();
                }
            } else {
                System.out.println("This position is already taken. Try again.");
            }
        }
    }

    private static void saveScore(User user, int score) {
        try (Connection conn = Database.connect()) {
            String query = "INSERT INTO scores (user_id, score) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, user.getId());
            stmt.setInt(2, score);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    private static void viewTopScores() {
        try (Connection conn = Database.connect()) {
            String query = "SELECT u.username, s.score FROM scores s JOIN users u ON s.user_id = u.user_id ORDER BY s.score DESC LIMIT 10";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Top 10 Scores:");
            while (rs.next()) {
                String username = rs.getString("username");
                int score = rs.getInt("score");
                System.out.println(username + ": " + score);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving scores: " + e.getMessage());
        }
    }
}
