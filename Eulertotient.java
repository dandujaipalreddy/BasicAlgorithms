import java.util.Scanner;

public class Eulertotient {

	/*
	 *  Euler's totient :the numbers of numbers prime to it
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n;
		while ((n = in.nextInt()) != 0)
			System.out.println(phi(n));

	}

	public static int phi(int n) {
		int result = n;
		for (int i = 2; i * i <= n; ++i)
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				result -= result / i;
			}
		if (n > 1)
			result -= result / n;
		return result;

	}

}
