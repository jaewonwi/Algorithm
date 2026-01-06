import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	int[] nums = new int[10];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++){
			nums[i] = sc.nextInt();
			set.add(nums[i] % 42);
		}
		System.out.println(set.size());
    }
}