# STEP-SEM-3

A unified repository containing all college lab practice problems and assignment submissions for **STEP Semester 3**.

---

## Repository Structure

```text
STEP-SEM-3/
├── .gitignore
├── README.md
├── Week-1/
│   ├── Practice-Problems/
│   │   ├── RockPaperScissors.java
│   │   ├── PalindromeChecker.java
│   │   ├── BMICalculator.java
│   │   ├── FirstNonRepeatingCharacter.java
│   │   └── ReverseCustomerName.java
│   └── Assignment-Problems/
├── Week-2/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
├── Week-3/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
├── Week-4/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
├── Week-5/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
├── Week-6/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
├── Week-7/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
├── Week-8/
│   ├── Practice-Problems/
│   └── Assignment-Problems/
└── Week-9/
    ├── Practice-Problems/
    └── Assignment-Problems/
```

- Each week separates in-class lab exercises (`Practice-Problems/`) from homework/submissions (`Assignment-Problems/`).
- Empty folders are tracked via `.gitkeep` placeholders until assignment questions and files are added.

---

## Week 1: Practice Problems Summary

All 5 programs are implemented in Java following standard conventions with modular methods:

1. **`RockPaperScissors.java`**
   - **Scenario:** The College Coding Arcade
   - **Features:** Simulates 5 rounds of Rock-Paper-Scissors against the computer, records round-by-round history, displays a tabular scoreboard, and calculates win percentage.
   - **Main Method:** `playRound(String playerMove, String computerMove)`

2. **`PalindromeChecker.java`**
   - **Scenario:** The QA Text Verification Toolkit
   - **Features:** Validates strings using 3 independent techniques:
     - Iterative comparison (`isPalindromeIterative`)
     - Recursive shrinking substring (`isPalindromeRecursive`)
     - Character array reversal (`isPalindromeArrayReversal`)

3. **`BMICalculator.java`**
   - **Scenario:** The Corporate Wellness Program
   - **Features:** Computes BMI (`weight / (height * height)`) for a team of 10 people, classifies status (*Underweight*, *Normal*, *Overweight*, *Obese*), and outputs a formatted wellness report table.
   - **Main Methods:** `getBmiStatus(double bmi)`, `printWellnessReport(double[] heights, double[] weights)`

4. **`FirstNonRepeatingCharacter.java`**
   - **Scenario:** The Unique Letter Hunt Mini-Game
   - **Features:** Computes character frequency counts and scans from left to right to return the first character appearing exactly once.
   - **Main Method:** `findFirstNonRepeatingChar(String text)`

5. **`ReverseCustomerName.java`**
   - **Scenario:** The Customer Identity Verification System
   - **Features:** Reverses a customer name string via character array traversal while keeping the original string unchanged.
   - **Main Method:** `reverseCustomerName(String customerName)`

---

## How to Compile & Run Java Programs

Open a terminal inside the repository and navigate to the target week:

```bash
# Navigate to Week 1 practice problems
cd Week-1/Practice-Problems

# Compile all programs in the directory
javac *.java

# Run individual programs:
java RockPaperScissors
java PalindromeChecker
java BMICalculator
java FirstNonRepeatingCharacter
java ReverseCustomerName
```

---

## Adding Future Weeks (Week-10 and Beyond)

The repository layout is designed for easy extension. To add a new week:

1. Create the new week folder and subdirectories:
   ```bash
   mkdir -p Week-10/Practice-Problems Week-10/Assignment-Problems
   ```
2. Place `.gitkeep` inside empty folders so Git tracks them:
   ```bash
   touch Week-10/Practice-Problems/.gitkeep Week-10/Assignment-Problems/.gitkeep
   ```
3. Add your Java source code files (`.java`) directly into their respective folders.

---

## Connecting to Your GitHub Repository

When you are ready to link and push this project to GitHub:

1. **Initialize Git locally** (if not already done):
   ```bash
   git init
   git branch -M main
   ```

2. **Stage and commit all files:**
   ```bash
   git add .
   git commit -m "Initial commit: Setup STEP-SEM-3 structure for Weeks 1-9 and Week 1 practice problems"
   ```

3. **Create a new repository on GitHub:**
   - Go to [GitHub New Repository](https://github.com/new).
   - Name it `STEP-SEM-3`.
   - Do **not** initialize with a README, `.gitignore`, or license (they are already present here).

4. **Link the remote and push:**
   ```bash
   git remote add origin https://github.com/<YOUR_GITHUB_USERNAME>/STEP-SEM-3.git
   git push -u origin main
   ```
