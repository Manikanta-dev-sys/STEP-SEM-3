/**
 * Week 2 Practice - Problem 3: File Extension Validator
 * Scenario: Assignment-Upload Portal Verification
 * 
 * Extracts the file extension using lastIndexOf('.') and substring(), and checks
 * case-insensitively whether the file type belongs to accepted formats (pdf, docx, zip).
 */
public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    /**
     * Extracts the extension from the filename and validates it against accepted file types.
     * 
     * @param filename The name of the file to check
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            return "Rejected — invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');

        // Dot not found or dot is the last character with no extension
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("            File Extension Validator             ");
        System.out.println("=================================================\n");

        // Test Case 1: Accepted PDF in uppercase (Sample from PDF)
        String file1 = "Assignment1.PDF";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file1, validateFileExtension(file1));

        // Test Case 2: Rejected txt extension (Sample from PDF)
        String file2 = "notes.txt";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file2, validateFileExtension(file2));

        // Test Case 3: Accepted docx in lowercase
        String file3 = "ProjectReport.docx";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file3, validateFileExtension(file3));

        // Test Case 4: Accepted zip file
        String file4 = "source_code.ZIP";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file4, validateFileExtension(file4));

        // Test Case 5: No extension
        String file5 = "README";
        System.out.printf("Input: \"%s\" -> Output: %s%n", file5, validateFileExtension(file5));
    }
}
