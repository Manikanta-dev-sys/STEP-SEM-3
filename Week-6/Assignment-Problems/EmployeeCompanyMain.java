
class EmployeeInfo {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyMain {
    public static void main(String[] args) {
        EmployeeInfo e1 = new EmployeeInfo("Divya", 65000);
        EmployeeInfo e2 = new EmployeeInfo("Arjun", 30000);
        EmployeeInfo e3 = new EmployeeInfo("Ravi", 45000);

        EmployeeInfo.printCompanyInfo();
    }
}
