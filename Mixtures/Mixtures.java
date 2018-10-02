
//Harry Potter has n mixtures in front of him, arranged in a row. Each mixture has one of 100 different colors (colors have numbers from 0 to 99).

//He wants to mix all these mixtures together. At each step, he is going to take two mixtures that stand next to each other and mix them together, and put the resulting mixture in their place.

//When mixing two mixtures of colors a and b, the resulting mixture will have the color (a+b) mod 100.

//Also, there will be some smoke in the process. The amount of smoke generated when mixing two mixtures of colors a and b is a*b.

//Find out what is the minimum amount of smoke that Harry can get when mixing all the mixtures together.
//You can find the original problem here.

//Input Format:
//The first line of each input file will contain n, the number of mixtures. The second line will contain n integers between 0 and 99 - the initial colors of the mixtures.

//Explanation:
//There are two possibilities: first mix 40 and 60 (smoke: 2400), getting 0, then mix 0 and 20 (smoke: 0); total amount of smoke is 2400. first mix 60 and 20 (smoke: 1200), getting 80, then mix 40 and 80 (smoke: 3200); total amount of smoke is 4400. The first scenario is a much better way to proceed.

public class Mixtures {
	public static void main(String[] args) {

		int[] arr = { 41, 67, 34, 0, 69, 24, 78, 58, 62, 64 };
		System.out.println(mixturesTD(arr, 0, arr.length - 1));
		System.out.println(mixturesBU(arr));

	}

	public static int mixturesTD(int[] arr, int si, int ei) {

		if (si == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k < ei; k++) {

			int fc = mixturesTD(arr, si, k);
			int sc = mixturesTD(arr, k + 1, ei);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int ta = fc + sc + sw;

			if (ta < min) {
				min = ta;
			}
		}

		return min;
	}

	public static int mixturesBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int min = Integer.MAX_VALUE;

				for (int k = si; k < ei; k++) {

					int fc = strg[si][k];
					int sc = strg[k + 1][ei];

					int sw = color(arr, si, k) * color(arr, k + 1, ei);

					int ta = fc + sc + sw;

					if (ta < min) {
						min = ta;
					}
				}

				strg[si][ei] = min;

			}
		}

		return strg[0][n - 1];

	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}
		return sum % 100;
	}

}
