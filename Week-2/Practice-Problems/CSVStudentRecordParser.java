/**
 * Week 2 Practice - Problem 2: CSV Student Record Parser
 * Scenario: T&P Team Student Registration Data Parser
 * 
 * Splits incoming CSV records formatted as "Name,RollNumber,Department", validates
 * that exactly 3 fields are present, and displays a formatted profile record.
 */
public class CSVStudentRecordParser {

    /**
     * Splits and validates a single CSV student record line, printing the formatted output.
     * 
     * @param csvLine The raw CSV string ("Name,RollNumber,Department")
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma preserving all empty trailing fields
        String[] fields = csvLine.split(",", -1);

        // Validate that exactly 3 fields exist
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        // Ensure fields are not blank
        if (name.isEmpty() || rollNumber.isEmpty() || department.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNumber, department);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("           CSV Student Record Parser             ");
        System.out.println("=================================================\n");

        // Test Case 1: Valid 3-field record (Sample from PDF)
        String line1 = "Ananya Verma,RA2211003010123,CSE";
        System.out.printf("Input: \"%s\"%nOutput: ", line1);
        parseStudentRecord(line1);
        System.out.println();

        // Test Case 2: Missing field (Sample from PDF)
        String line2 = "Ananya Verma,CSE";
        System.out.printf("Input: \"%s\"%nOutput: ", line2);
        parseStudentRecord(line2);
        System.out.println();

        // Test Case 3: Extra field (Invalid)
        String line3 = "Rahul Sharma,RA2211003010456,ECE,Section A";
        System.out.printf("Input: \"%s\"%nOutput: ", line3);
        parseStudentRecord(line3);
    }
}
