/**
 * Week 2 Assignment - Problem 3: Product Inventory CSV Parser
 * Scenario: Warehouse Inventory Updates Parser
 * 
 * Splits inventory update CSV lines into fields ("ProductName,SKU,Quantity"),
 * validates that exactly 3 non-empty fields are present, and displays a formatted record.
 */
public class ProductInventoryCsvParser {

    /**
     * Parses, validates, and prints a single product inventory CSV record line.
     * 
     * @param csvLine The raw CSV line ("ProductName,SKU,Quantity")
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        // Split by comma preserving empty fields
        String[] fields = csvLine.split(",", -1);

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        // Validate that fields are not empty
        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", productName, sku, quantity);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          Product Inventory CSV Parser           ");
        System.out.println("=================================================\n");

        // Test Case 1: Valid 3-field line (Sample from PDF)
        String line1 = "Wireless Mouse,WM-2201,150";
        System.out.printf("Input: \"%s\"%nOutput: ", line1);
        parseInventoryRecord(line1);
        System.out.println();

        // Test Case 2: Incomplete line with 2 fields (Sample from PDF)
        String line2 = "Wireless Mouse,150";
        System.out.printf("Input: \"%s\"%nOutput: ", line2);
        parseInventoryRecord(line2);
        System.out.println();

        // Test Case 3: Line with trailing comma / empty field
        String line3 = "Mechanical Keyboard,MK-882,";
        System.out.printf("Input: \"%s\"%nOutput: ", line3);
        parseInventoryRecord(line3);
        System.out.println();

        // Test Case 4: Another valid product record
        String line4 = "Gaming Monitor,GM-4402,75";
        System.out.printf("Input: \"%s\"%nOutput: ", line4);
        parseInventoryRecord(line4);
    }
}
