# STEP-SEM-3

A unified repository containing all college lab practice problems and assignment submissions for **STEP Semester 3**.

---

## Repository Structure

```text
STEP-SEM-3/
├── .gitignore
├── README.md
├── Week-1/
│   ├── Assignment-Problems/
│   │   ├── ExamHallSeatDuplicationChecker.java
│   │   ├── MovieReviewWordLengthProfiler.java
│   │   ├── TrafficSignalStreakAnalyzer.java
│   │   ├── TypingSpeedTestAccuracyChecker.java
│   │   └── WarehouseInventoryBalancer.java
│   └── Practice-Problems/
│       ├── BMICalculator.java
│       ├── FirstNonRepeatingCharacter.java
│       ├── PalindromeChecker.java
│       ├── ReverseCustomerName.java
│       └── RockPaperScissors.java
├── Week-2/
│   ├── Assignment-Problems/
│   │   ├── AtmPinLengthValidator.java
│   │   ├── LibraryIsbnValidator.java
│   │   ├── ProductInventoryCsvParser.java
│   │   ├── StopWordFilteredWordFrequencyReport.java
│   │   └── WordReversalEncoder.java
│   └── Practice-Problems/
│       ├── BankTransactionReferenceValidator.java
│       ├── CSVStudentRecordParser.java
│       ├── FileExtensionValidator.java
│       ├── MaskedPhoneNumberFormatter.java
│       └── VowelAndConsonantCounter.java
├── Week-3/
│   ├── Assignment-Problems/
│   └── Practice-Problems/
├── Week-4/
│   ├── Assignment-Problems/
│   │   ├── FindMinimumInRotatedSortedArray.java
│   │   ├── MaximumSubarray.java
│   │   ├── ProductOfArrayExceptSelf.java
│   │   ├── SubarraySumEqualsK.java
│   │   └── ThreeSum.java
│   └── Practice-Problems/
│       ├── BestTimeToBuyAndSellStock.java
│       ├── ContainsDuplicate.java
│       ├── MergeTwoSortedArrays.java
│       ├── RotateArray.java
│       └── TwoSum.java
├── Week-5/
│   ├── Assignment-Problems/
│   └── Practice-Problems/
├── Week-6/
│   ├── Assignment-Problems/
│   └── Practice-Problems/
├── Week-7/
│   ├── Assignment-Problems/
│   └── Practice-Problems/
├── Week-8/
│   ├── Assignment-Problems/
│   └── Practice-Problems/
└── Week-9/
    ├── Assignment-Problems/
    └── Practice-Problems/
```

- Each week cleanly isolates in-class lab exercises (`Practice-Problems/`) from homework/assignments (`Assignment-Problems/`).
- Future and empty folders maintain their directory presence in Git using `.gitkeep` placeholders.

---

## Week 1: Programs Overview

### A. Practice Problems (`Week-1/Practice-Problems/`)
1. **`RockPaperScissors.java`** – Simulates a 5-round match against computer with formatted scoreboard and win percentage.
2. **`PalindromeChecker.java`** – Verifies palindromes using Iterative, Recursive, and Array Reversal methods.
3. **`BMICalculator.java`** – Computes BMI for a 10-person team and classifies status (*Underweight*, *Normal*, *Overweight*, *Obese*).
4. **`FirstNonRepeatingCharacter.java`** – Computes character frequency and scans left-to-right for the first unique character.
5. **`ReverseCustomerName.java`** – Reverses a customer name string via character traversal while preserving original immutability.

### B. Assignment Problems (`Week-1/Assignment-Problems/`)
1. **`ExamHallSeatDuplicationChecker.java`** – Detects duplicate seat allocations across an exam hall using primitive arrays and nested loops only.
2. **`TypingSpeedTestAccuracyChecker.java`** – Calculates character-by-character accuracy percentage and pinpoints first mismatch.
3. **`TrafficSignalStreakAnalyzer.java`** – Scans minute-by-minute traffic readings (`'R'`, `'Y'`, `'G'`) and detects the longest continuous streak.
4. **`WarehouseInventoryBalancer.java`** – Balances section quantities and reports the overall highest-quantity item.
5. **`MovieReviewWordLengthProfiler.java`** – Splits reviews into words and classifies counts into Short (1–4), Medium (5–8), and Long (9+) words.

---

## Week 2: Programs Overview

### A. Practice Problems (`Week-2/Practice-Problems/`)
1. **`VowelAndConsonantCounter.java`** – Loops through text using `charAt()`, counts vowels (case-insensitive) and consonants, and ignores spaces.
2. **`CSVStudentRecordParser.java`** – Splits CSV strings (`"Name,RollNumber,Department"`), validates 3 fields, and formats output records.
3. **`FileExtensionValidator.java`** – Extracts extensions using `lastIndexOf('.')` and `substring()`, validating against accepted formats (`pdf`, `docx`, `zip`).
4. **`MaskedPhoneNumberFormatter.java`** – Validates 10-digit phone numbers and formats a masked string (`"XXXXXX-XXXX"`) using `StringBuilder` and `insert()`.
5. **`BankTransactionReferenceValidator.java`** – Normalizes and validates 14-character reference codes without regex and formats with `StringBuilder`.

### B. Assignment Problems (`Week-2/Assignment-Problems/`)
1. **`AtmPinLengthValidator.java`** – Validates that an entered PIN string is exactly 4 characters using `length()` and a single `if/else` check.
2. **`WordReversalEncoder.java`** – Splits sentences by space, reverses each word individually using a loop and `StringBuilder`, and joins back.
3. **`ProductInventoryCsvParser.java`** – Splits CSV lines into fields (`"ProductName,SKU,Quantity"`), validates 3 fields, and prints formatted records.
4. **`LibraryIsbnValidator.java`** – Normalizes codes, validates 13 characters (3 letters + 10 digits via loop), and builds display line with `StringBuilder`.
5. **`StopWordFilteredWordFrequencyReport.java`** – Filters stop words, counts frequencies with a `HashMap`, and prints results sorted descending by count.

---

## Week 4: Programs Overview

### A. Practice Problems (`Week-4/Practice-Problems/`) — Category C Problems
1. **`TwoSum.java`** – Uses nested loops to check every pair `(i, j)` and returns the indices summing to `target`.
2. **`BestTimeToBuyAndSellStock.java`** – Single-pass traversal tracking running minimum price and maximum achievable profit.
3. **`ContainsDuplicate.java`** – Pairwise nested loop comparison with early exit upon finding any duplicate.
4. **`MergeTwoSortedArrays.java`** – Two-pointer while-loop merge combining two sorted arrays in non-decreasing order.
5. **`RotateArray.java`** – Right rotation by `k` positions using modulo wraparound indexing `(i + k) % n`.

### B. Assignment Problems (`Week-4/Assignment-Problems/`) — Category C Problems
1. **`ProductOfArrayExceptSelf.java`**
   - **Scenario:** *Pricing Engine Combined Product Value* – Computes running product of all elements except current element in $O(n)$ time and $O(1)$ extra space using prefix and suffix passes without division.
   - **Key Method:** `int[] productExceptSelf(int[] nums)`
2. **`MaximumSubarray.java`**
   - **Scenario:** *Stock Trading Best Consecutive Trading Days* – Implements Kadane's algorithm in $O(n)$ time and $O(1)$ space to find the contiguous subarray with the largest sum.
   - **Key Method:** `int maxSubArray(int[] nums)`
3. **`ThreeSum.java`**
   - **Scenario:** *Budgeting Tool Transaction Triplet Canceller* – Sorts the array and uses inward two-pointer traversal in $O(n^2)$ time with duplicate avoidance to find all unique triplets summing to 0.
   - **Key Method:** `int[][] threeSum(int[] nums)`
4. **`SubarraySumEqualsK.java`**
   - **Scenario:** *Hostel Attendance Net Change Analyzer* – Uses prefix sums combined with a hash map of prefix-sum frequencies in $O(n)$ time to count contiguous subarrays with sum equal to $k$.
   - **Key Method:** `int subarraySum(int[] nums, int k)`
5. **`FindMinimumInRotatedSortedArray.java`**
   - **Scenario:** *Circular Duty Roster Earliest Join Date Finder* – Employs modified binary search in $O(\log n)$ time comparing mid to rightmost element to find the minimum value in a rotated sorted array.
   - **Key Method:** `int findMin(int[] nums)`

---

## How to Compile & Run

### Week 4 Practice Problems:
```bash
cd Week-4/Practice-Problems
javac *.java

java TwoSum
java BestTimeToBuyAndSellStock
java ContainsDuplicate
java MergeTwoSortedArrays
java RotateArray
```

### Week 4 Assignment Problems:
```bash
cd Week-4/Assignment-Problems
javac *.java

java ProductOfArrayExceptSelf
java MaximumSubarray
java ThreeSum
java SubarraySumEqualsK
java FindMinimumInRotatedSortedArray
```

---

## Connecting to Your GitHub Repository

When you are ready to publish:

```powershell
cd "C:\Users\manikanta\Documents\STEP-SEM-3"
git add .
git commit -m "Add Week 4 assignment problems and update documentation"
git push origin main
```
