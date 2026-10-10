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
│   │   └── .gitkeep
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
│   └── Practice-Problems/
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
1. **`RockPaperScissors.java`**
   - **Scenario:** *The College Coding Arcade* – Simulates a 5-round match against computer with history, formatted scoreboard, and win percentage calculation.
   - **Key Method:** `playRound(String playerMove, String computerMove)`
2. **`PalindromeChecker.java`**
   - **Scenario:** *The QA Text Verification Toolkit* – Verifies palindromes via 3 independent methods (iterative two-pointer, recursion, and array reversal).
   - **Key Methods:** `isPalindromeIterative`, `isPalindromeRecursive`, `isPalindromeArrayReversal`
3. **`BMICalculator.java`**
   - **Scenario:** *The Corporate Wellness Program* – Computes BMI for a 10-person team and classifies health status into Underweight, Normal, Overweight, Obese.
   - **Key Methods:** `getBmiStatus(double bmi)`, `printWellnessReport(double[] heights, double[] weights)`
4. **`FirstNonRepeatingCharacter.java`**
   - **Scenario:** *The Unique Letter Hunt Mini-Game* – Counts character frequency and scans left-to-right for the first unique character.
   - **Key Method:** `findFirstNonRepeatingChar(String text)`
5. **`ReverseCustomerName.java`**
   - **Scenario:** *The Customer Identity Verification System* – Reverses a customer name string via character traversal while preserving original immutability.
   - **Key Method:** `reverseCustomerName(String customerName)`

### B. Assignment Problems (`Week-1/Assignment-Problems/`)
1. **`ExamHallSeatDuplicationChecker.java`**
   - **Scenario:** *The Examination Cell* – Detects duplicate seat allocations across an exam hall using primitive arrays and nested loops only (no Collections classes).
   - **Key Method:** `checkDuplicateSeats(int[] seatNumbers)`
2. **`TypingSpeedTestAccuracyChecker.java`**
   - **Scenario:** *Online Typing Practice Website* – Calculates character-by-character accuracy percentage and pinpoints the 1-based position and characters of the first mismatch.
   - **Key Method:** `checkTypingAccuracy(String original, String typed)`
3. **`TrafficSignalStreakAnalyzer.java`**
   - **Scenario:** *City Traffic Control Department* – Scans minute-by-minute traffic light readings (`'R'`, `'Y'`, `'G'`) and detects the longest continuous streak of the same color.
   - **Key Method:** `findLongestStreak(String signalLog)`
4. **`WarehouseInventoryBalancer.java`**
   - **Scenario:** *Retail Warehouse Stock Auditing* – Evaluates section quantities for balance between Section A and Section B and reports the overall highest-quantity item with section and index.
   - **Key Method:** `analyzeInventory(int[] sectionA, int[] sectionB)`
5. **`MovieReviewWordLengthProfiler.java`**
   - **Scenario:** *Movie Review Platform Moderation* – Splits reviews into words and classifies counts into Short (1–4), Medium (5–8), and Long (9+) words.
   - **Key Method:** `classifyWordLengths(String review)`

---

## Week 2: Programs Overview

### Practice Problems (`Week-2/Practice-Problems/`)
1. **`VowelAndConsonantCounter.java`**
   - **Scenario:** *Library Orientation Kiosk* – Loops through text using `charAt()`, counts vowels (case-insensitive) and consonants separately, and ignores spaces.
   - **Key Method:** `countVowelsAndConsonants(String text)`
2. **`CSVStudentRecordParser.java`**
   - **Scenario:** *T&P Team Student Registration* – Splits CSV strings (`"Name,RollNumber,Department"`), validates exactly 3 non-empty fields, and formats output records.
   - **Key Method:** `parseStudentRecord(String csvLine)`
3. **`FileExtensionValidator.java`**
   - **Scenario:** *Assignment-Upload Portal* – Extracts extensions using `lastIndexOf('.')` and `substring()`, validating against accepted formats (`pdf`, `docx`, `zip`) case-insensitively.
   - **Key Method:** `validateFileExtension(String filename)`
4. **`MaskedPhoneNumberFormatter.java`**
   - **Scenario:** *Student-Support Call Center* – Validates 10-digit phone numbers and formats a masked string (`"XXXXXX-XXXX"`) using `StringBuilder` and `insert()`.
   - **Key Method:** `maskPhoneNumber(String phone)`
5. **`BankTransactionReferenceValidator.java`**
   - **Scenario:** *Fintech Onboarding Module* – Normalizes codes (trim + first 3 letters uppercased), validates 14 characters (3 letters + 11 digits via `Character.isLetter()`/`isDigit()`, no regex), and constructs formatted display line `"[BANKCODE] DATE: dd/MM/yy | SEQ: 12345"` using `StringBuilder`.
   - **Key Methods:** `normalizeReference(String raw)`, `validateAndFormat(String reference)`

---

## How to Compile & Run

### Week 1 Practice Problems:
```bash
cd Week-1/Practice-Problems
javac *.java

java RockPaperScissors
java PalindromeChecker
java BMICalculator
java FirstNonRepeatingCharacter
java ReverseCustomerName
```

### Week 1 Assignment Problems:
```bash
cd Week-1/Assignment-Problems
javac *.java

java ExamHallSeatDuplicationChecker
java TypingSpeedTestAccuracyChecker
java TrafficSignalStreakAnalyzer
java WarehouseInventoryBalancer
java MovieReviewWordLengthProfiler
```

### Week 2 Practice Problems:
```bash
cd Week-2/Practice-Problems
javac *.java

java VowelAndConsonantCounter
java CSVStudentRecordParser
java FileExtensionValidator
java MaskedPhoneNumberFormatter
java BankTransactionReferenceValidator
```

---

## Adding Future Weeks (Week-10 and Beyond)

To extend the repository with additional weeks:
```bash
mkdir -p Week-10/Practice-Problems Week-10/Assignment-Problems
touch Week-10/Practice-Problems/.gitkeep Week-10/Assignment-Problems/.gitkeep
```

---

## Connecting to Your GitHub Repository

When you are ready to publish:

1. **Create an empty repository on GitHub**:
   - Go to [GitHub New Repository](https://github.com/new).
   - Name it `STEP-SEM-3`.
   - Do **not** initialize with a README, `.gitignore`, or license.

2. **Run in terminal inside `C:\Users\manikanta\Documents\STEP-SEM-3`**:
   ```bash
   git add .
   git commit -m "Add Week 2 practice problems and update documentation"
   git remote add origin https://github.com/<YOUR_GITHUB_USERNAME>/STEP-SEM-3.git
   git push -u origin main
   ```
