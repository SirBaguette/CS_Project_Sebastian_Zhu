import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Program made by Sebastian Zhu, 9 Jan 2024
// This is for CS end of semester project
// This program allows persons eligible to pay tax in Hong Kong to calculate their tax due
// There are no current collaborators
public class Main {
    public static void main(String[] args) {
        String FirstName;
        String LastName;
        int age;
        int income;
        int deductions;
        int allowances;
        Scanner mainScanner = new Scanner(System.in);
        int menuOption = 0;
        System.out.println("Hello, and welcome to the HK Tax Calculator. ");
        pause(500);
        System.out.println("There are two things certain in life, death and taxes.");
        pause(500);
        System.out.println("This helpful tool will help you calculate how much tax you need to pay. \n" +
                "This tool requires the input of information such as Income, deduction and allowance." +
                "\nIt will output the NCI, Net Chargeable Income, which you need to pay to the HK Government.");
        pause(1000);
        System.out.println("Press 1 to continue to calculate your taxes." +
                "\nPress 2 to learn more about the Hong Kong Tax system." +
                "\nPress 3 to exit the program.");
        while (menuOption != 1 && menuOption != 2 && menuOption != 3) {
            try {
                menuOption = Integer.parseInt(mainScanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }}
            while (1!=2) {
                if (menuOption == 1) {
                    FirstName = FName(0);
                    LastName = LName(0);
                    age = Age(-1);
                    income = yIncome(0);
                    deductions = deductables(-1);
                    allowances = allowed(-1);
                    int NCI = income - deductions - allowances;
                    if (NCI < 0) {
                        NCI = 0;
                    }
                    double taxDue = tDue(NCI);
                    csvcreation(FirstName, LastName, age, income, deductions, allowances, NCI, taxDue);
                    menuOption = options(0);
                } else if (menuOption == 2) {
                    System.out.println("Hong Kong is considered a tax haven, especially for corporate activities." +
                            "\nIt has low tax rates compared to other financial hubs in the world," +
                            "\nand its taxes doesn't include income generated outside of Hong Kong.");
                    pause(1000);
                    System.out.println("The system also lacks other forms of taxation, such as luxury tax." +
                            "\nIt also refuses to give in to EU pressure on its financial information," +
                            "\nranking fourth on the financial secrecy index.");
                    pause(2000);
                    System.out.println("Press 1 to continue to calculate your taxes." +
                            "\nPress 3 to exit the program.");
                    menuOption = 0;
                    while (menuOption != 1 && menuOption != 3) {
                        try {
                            menuOption = Integer.parseInt(mainScanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number");
                        }
                    }
                    if (menuOption == 1) {
                        FirstName = FName(0);
                        LastName = LName(0);
                        age = Age(-1);
                        income = yIncome(0);
                        deductions = deductables(-1);
                        allowances = allowed(-1);
                        int NCI = income - deductions - allowances;
                        if (NCI < 0) {
                            NCI = 0;
                        }
                        double taxDue = tDue(NCI);
                        csvcreation(FirstName, LastName, age, income, deductions, allowances, NCI, taxDue);
                        menuOption = options(0);
                    }
                    if (menuOption == 3) {
                        System.out.println("The program has been terminated.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("The program has been terminated.");
                    System.exit(0);
                }
            }
        }

    public static int yIncome (int income) {
        System.out.println("Please enter your income.");
        Scanner scanner = new Scanner(System.in);
        while (income <=0) {
        try {
            income = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }}
        return income;
    }
    public static int deductables (int amount) {
        System.out.println("Deductions are necessary expenses listed by the government, which can be claimed by the taxpayer." +
                "\nDeductions are taken out of the NCI, net chargeable income." +
                "\nTypes of deductions include: ");
        pause(1000);
        System.out.println("\n - Expenses necessary in the production of assessable income;");
        pause(500);
        System.out.println("\n - Domestic rents;");
        pause(500);
        System.out.println("\n - Approved charity donations;");
        pause(500);
        System.out.println("\n - Self-Education expenses;");
        pause(500);
        System.out.println("\n - Elderly residential care expenses, etc.");
        pause(1000);
        System.out.println("Please enter the amount of deductions you are eligible to.");
        Scanner scanner = new Scanner(System.in);
        while (amount <0) {
            try {
                amount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }}
        return amount;
    }
    public static int allowed (int amt) {
        System.out.println("Allowances are also deducted from your NCI. They are for peoples dependent on your income.");
        pause(500);
        System.out.println("Examples can include:");
        pause(500);
        System.out.println("Married person allowance, child allowance, dependent family allowance, disability allowances, etc.");
        pause(1000);
        System.out.println("Please enter the amount of allowance you are eligible for.");
        Scanner scanner = new Scanner(System.in);
        while (amt <0) {
            try {
                amt = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }}
        return amt;
    }
    public static int Age (int years) {
        System.out.println("Please enter your age.");
        Scanner scanner = new Scanner(System.in);
        while (years <0) {
            try {
                years = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }}
        return years;
    }
    public static String FName (int nm) {
            System.out.println("Please enter your first name.");
            Scanner scanner = new Scanner(System.in);
            String fnm = scanner.nextLine();
            return fnm;
    }
    public static String LName (int nm) {
        System.out.println("Please enter your last name.");
        Scanner scanner = new Scanner(System.in);
        String lnm = scanner.nextLine();
        return lnm;
    }

    public static double tDue (int NCI) {
        if (NCI > 120000) {
            return (NCI-120000)*0.17 + 8400;
        }
        else if (NCI > 80000) {
            return (NCI-80000)*0.12 + 3600;
        }
        else if (NCI > 40000) {
            return (NCI-40000)*0.07 + 800;
        }
        else {
            return NCI*0.02;
        }
    }

    public static void csvcreation(String FN, String LN, int age, int inc, int allow, int deduct, int NCI, double taxD) {
        System.out.println("The amount of tax due for "+FN + " "+ LN + " is " + taxD);
        pause(1000);
        System.out.println("The data will now be stored in a CSV file.");
        String csvFile = "/Users/yzhu25/IdeaProjects/CS Project Sebastian Zhu/.idea/output.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Write header row
            writer.println("First Name, Last Name, Age, Income, Deductions, Allowances, Net Chargeable Income, Tax Due");

            // Write data rows
            writer.println(FN+", "+LN+", "+age+", "+inc+", "+allow+", "+deduct+", "+NCI+", "+taxD);

            pause(500);
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int options(int a) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to calculate your taxes again." +
                "\nPress 3 to exit the program.");
        while (a != 1 && a != 3) {
            try {
                a = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        if (a == 1) {
            return 1;
        } else {
            System.out.println("Your program will now be terminated.");
            pause(500);
           return 3;
        }
    }

    public static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
