import java.util.*;

public class Main {
	static int[] input = new int[9], select = new int[7];
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
			sum += input[i];
		}
		int rem = sum - 100;

		for (int i = 0; i < 8; i++){
			for (int j = i+1; j < 9; j++){
				if (input[i] + input[j] == rem){
					input[i] = 0;
					input[j] = 0;
					Arrays.sort(input);
					for (int k = 2; k < 9; k++){
						System.out.println(input[k]);
					}
					return;
				}
			}
		}
	}
}