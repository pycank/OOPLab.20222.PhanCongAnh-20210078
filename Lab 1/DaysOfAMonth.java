import java.util.Scanner;
public class DaysOfAMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, year, days;

        do {
            System.out.print("Enter a month (1-12): ");
            month = input.nextInt();
        } while (month < 1 || month > 12);
        
        do {
            System.out.print("Enter a year: ");
            year = input.nextInt();
        } while (year < 0);

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                days = 31;
        }

        System.out.println("There are " + days + " days in month " + month + " of year " + year);
        input.close();
        System.exit(0);
    }
}
