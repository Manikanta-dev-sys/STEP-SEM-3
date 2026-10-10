/**
 * Week 1 Assignment - Problem 4: The Warehouse Inventory Balancer
 * Scenario: Retail Warehouse Stock Auditing
 * 
 * Compares total item quantities between Section A and Section B to check
 * balance status and identifies the single highest quantity item across the warehouse.
 */
public class WarehouseInventoryBalancer {

    /**
     * Computes totals for Section A and Section B, compares balance status,
     * and locates the overall highest quantity item with its section and item index.
     * 
     * @param sectionA Item quantities in Section A
     * @param sectionB Item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Invalid input: Sections must be non-null and equal in length.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "Section A";
        int highestItemNumber = 1;

        // Process Section A
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1; // 1-indexed item number
            }
        }

        // Process Section B
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1; // 1-indexed item number
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemNumber);
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("         Warehouse Inventory Balancer            ");
        System.out.println("=================================================\n");

        // Sample from PDF
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
        analyzeInventory(sectionA, sectionB);
        System.out.println();

        // Unbalanced inventory example
        int[] sectionC = {40, 25, 15};
        int[] sectionD = {20, 20, 15};
        System.out.println("Input: sectionA={40,25,15}, sectionB={20,20,15}");
        analyzeInventory(sectionC, sectionD);
    }
}
