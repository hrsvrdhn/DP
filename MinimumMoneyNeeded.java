
public class MinimumMoneyNeeded {

	// Cody went to the market to buy some oranges for his N friends. There he finds
	// orange wrapped in packets, with the price of i^th packet as val[i]. Now he
	// wants to buy exactly W kg oranges, so he wants you to tell him what minimum
	// price he should pay to buy exactly W kg oranges. Weight of i^th packet is i
	// kg. If price of i^th packet is -1 then this packet is not available for sale.
	// The market has infinite supply of orange packets.

//Input Format
//First line of input contains two space separated integers N and W, the number of friend he has and the amount of Oranges in kilograms which he should buy.

//The second line contains W space separated integers in which the i^th^ integer specifies the price of a ‘i’kg apple packet. A value of -1 denotes that the corresponding packet is unavailable

	public static void main(String[] args) {
		int[] price = { 0, -1, 33, -1, 176, -1, 46, -1, 120, -1, 300 };
		System.out.println(minimumMoneyBU(price));
	}

	public static int minimumMoneyBU(int[] price) {

		int[] strg = new int[price.length];

		strg[0] = 0;

		if (price[1] == -1) {
			strg[1] = Integer.MAX_VALUE;
		} else {
			strg[1] = price[1];
		}

		for (int i = 2; i < price.length; i++) {

			int min;

			if (price[i] == -1) {
				min = Integer.MAX_VALUE;
			} else {
				min = price[i];
			}

			int left = 1;
			int right = i - 1;

			while (left <= right) {

				int lc = strg[left];
				int rc = strg[right];

				int tw;
				if (lc != Integer.MAX_VALUE && rc != Integer.MAX_VALUE) {

					tw = lc + rc;

					if (tw < min) {
						min = tw;
					}
				}

				left++;
				right--;
			}

			strg[i] = min;
		}

		if (strg[strg.length - 1] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return strg[strg.length - 1];
		}
	}

}
