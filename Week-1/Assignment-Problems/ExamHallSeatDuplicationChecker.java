/**
 * Week 1 Assignment - Problem 1: The Exam Hall Seat Duplication Checker
 * Scenario: The Examination Cell
 * 
 * Scans a list of assigned seat numbers for an exam hall to detect and report
 * any duplicated seats. Uses arrays and loops only (no Collections classes).
 */
public class ExamHallSeatDuplicationChecker {

    /**
     * Checks an array of seat numbers for duplicate assignments using nested loops.
     * Prints duplicated seat number(s) or a confirmation message if all are unique.
     * 
     * @param seatNumbers Array of integer seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seat numbers provided.");
            return;
        }

        boolean hasDuplicate = false;
        // Boolean array to avoid reporting the same duplicate value multiple times
        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }

            boolean isCurrentDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isCurrentDuplicate = true;
                    alreadyReported[j] = true;
                }
            }

            if (isCurrentDuplicate) {
                hasDuplicate = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      Exam Hall Seat Duplication Checker         ");
        System.out.println("=================================================\n");

        // Test Case 1: Duplicates present (Sample from PDF)
        int[] hallA = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> ");
        checkDuplicateSeats(hallA);

        // Test Case 2: All seats unique (Sample from PDF)
        int[] hallB = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> ");
        checkDuplicateSeats(hallB);

        // Test Case 3: Multiple different duplicates
        int[] hallC = {201, 202, 203, 201, 204, 203, 205};
        System.out.print("Input: {201, 202, 203, 201, 204, 203, 205} -> ");
        checkDuplicateSeats(hallC);
    }
}
