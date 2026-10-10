import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1: Rock-Paper-Scissors Game
 * Scenario: The College Coding Arcade
 * 
 * Simulates a Rock-Paper-Scissors match between a player and the computer,
 * records each round's outcome, and displays a final scoreboard with statistics.
 */
public class RockPaperScissors {

    private static final String[] VALID_MOVES = {"Rock", "Paper", "Scissors"};

    /**
     * Determines the outcome of a single round of Rock-Paper-Scissors.
     * 
     * @param playerMove   The player's move ("Rock", "Paper", or "Scissors")
     * @param computerMove The computer's move ("Rock", "Paper", or "Scissors")
     * @return "Player Wins", "Computer Wins", or "Draw"
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new IllegalArgumentException("Moves cannot be null");
        }

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins = false;
        if (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) {
            playerWins = true;
        } else if (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) {
            playerWins = true;
        } else if (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper")) {
            playerWins = true;
        }

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    /**
     * Randomly generates the computer's move from {"Rock", "Paper", "Scissors"}.
     * 
     * @param random Random instance
     * @return A randomly selected move
     */
    public static String generateComputerMove(Random random) {
        return VALID_MOVES[random.nextInt(VALID_MOVES.length)];
    }

    /**
     * Normalizes and validates user input into canonical format ("Rock", "Paper", "Scissors").
     * 
     * @param input Raw user input
     * @return Canonical move string, or null if invalid
     */
    public static String normalizeMove(String input) {
        if (input == null) return null;
        String trimmed = input.trim().toLowerCase();
        switch (trimmed) {
            case "rock":
            case "r":
                return "Rock";
            case "paper":
            case "p":
                return "Paper";
            case "scissors":
            case "s":
                return "Scissors";
            default:
                return null;
        }
    }

    /**
     * Prints a formatted summary table of all played rounds.
     * 
     * @param playerMoves   Array of player moves
     * @param computerMoves Array of computer moves
     * @param results       Array of round outcomes
     * @param totalRounds   Number of rounds played
     */
    public static void printSummaryTable(String[] playerMoves, String[] computerMoves, String[] results, int totalRounds) {
        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-8s | %-15s | %-15s | %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-8d | %-15s | %-15s | %-15s%n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("------------------------------------------------------------");
    }

    /**
     * Prints overall match statistics including wins, losses, draws, and win percentage.
     * 
     * @param wins   Player win count
     * @param losses Player loss count (Computer wins)
     * @param draws  Draw count
     * @param total  Total rounds played
     */
    public static void printFinalSummary(int wins, int losses, int draws, int total) {
        double winPercentage = (total > 0) ? ((double) wins / total) * 100.0 : 0.0;
        System.out.printf("Final Summary (after %d rounds)%n", total);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int TOTAL_ROUNDS = 5;
        String[] playerMoves = new String[TOTAL_ROUNDS];
        String[] computerMoves = new String[TOTAL_ROUNDS];
        String[] results = new String[TOTAL_ROUNDS];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=================================================");
        System.out.println("   The College Coding Arcade - Rock Paper Scissors");
        System.out.println("=================================================");
        System.out.println("Playing " + TOTAL_ROUNDS + " rounds against the computer.");
        System.out.println("Moves: Rock (r), Paper (p), Scissors (s)");
        System.out.println("(Press Enter directly or type 'demo' to run an automated simulation)\n");

        boolean interactiveMode = (System.console() != null);

        for (int round = 0; round < TOTAL_ROUNDS; round++) {
            String pMove = null;

            if (interactiveMode && scanner.hasNextLine()) {
                System.out.printf("Round %d - Enter your move: ", round + 1);
                String line = scanner.nextLine();
                if (line.trim().equalsIgnoreCase("demo") || line.trim().isEmpty()) {
                    System.out.println("Switching to automated demo moves...");
                    interactiveMode = false;
                } else {
                    pMove = normalizeMove(line);
                    while (pMove == null) {
                        System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                        if (!scanner.hasNextLine()) break;
                        pMove = normalizeMove(scanner.nextLine());
                    }
                }
            }

            if (!interactiveMode || pMove == null) {
                // Predefined / automated moves matching problem scenario demo
                String[] demoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
                pMove = demoMoves[round % demoMoves.length];
            }

            String cMove = generateComputerMove(random);
            String result = playRound(pMove, cMove);

            playerMoves[round] = pMove;
            computerMoves[round] = cMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %d \u2014 Player: %s, Computer: %s -> %s%n", (round + 1), pMove, cMove, result);
        }

        printSummaryTable(playerMoves, computerMoves, results, TOTAL_ROUNDS);
        printFinalSummary(wins, losses, draws, TOTAL_ROUNDS);
    }
}
