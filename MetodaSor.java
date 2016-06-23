public class MetodaSor {

	private static double Toleranca = 1E-7;
	private static int N = 50; 
	
	public static void main(String[] args) {
		double[][] a = {{2, 1, 0},
						{5, 4, 1},
						{0, -1, 4}};
		double[] b = {24, 30, -24};
		double[] xo = {1, 1, 1};
		double w = 1.25;
		double[] result = SOR(a, xo, b, w);
		for(int i = 0; i < result.length; i++) {
			System.out.println("x[i] = " + result[i]);
		}
	}
	
	public static double[] SOR(double[][] a, double[] xo, 
							   double[] b, double w) {
		
		int n = a.length;
		double[] x = new double[n];
		int k = 1;
		while(k <= N) {
			for(int i = 0; i < n; i++) {
				x[i] = (1 - w) * xo[i] + (w * (- SUM(i, a, x, xo) + b[i]))/a[i][i];
			}
			if(findlInfinit(x, xo) < Toleranca) {
				return xo;
			}
			k++;
			for(int i = 0; i < n; i++) {
				xo[i] = x[i];
			}
		}
		System.out.println("Numri maksimal i iterimeve");
		return xo;
	}
	
	public static double SUM(int row, double[][] a, double[] x, double[] xo) {
		double SUM = 0;
		for(int j = 0; j < a.length; j++) {
			if(row == j)
				continue;
			else if (row < j) {
				SUM += a[row][j] * xo[j];
			}
			else {
				SUM += a[row][j] * x[j];
			}
		}
		return SUM;
	}
	
	public static double findlInfinit(double[] x, double[] xo) {
	      double max = Math.abs(x[0] - xo[0]);
	      for(int i = 1; i < x.length; i++) {
	         if(Math.abs(x[i] - xo[0]) > max)
	            max = Math.abs(x[i]);
	      }
	      return max;
	   }
}
