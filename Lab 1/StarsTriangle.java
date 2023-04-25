import java.util.Scanner;
public class StarsTriangle {
    
	public static void printTriangle(int n){
        for (int i = 0; i < n; i++){
			for (int j = n - i; j > 1; j--){
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++){
                System.out.print("* ");
			}
            System.out.println();
		}
	}
	
    public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		printTriangle(n);
        keyboard.close();
        System.exit(0);
	}
}

