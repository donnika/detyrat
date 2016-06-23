import java.text.DecimalFormat;
import javax.swing.*;

public class PageRank {
	
	public static void main(String[] args) {
		int  n = new Integer(JOptionPane.showInputDialog("Shkruaj nr. e faqeve")).intValue();
		double [] v = defineVector(n);
		double[][] m = Matrix.transpose(matrixP(n));
		double[] mv = matrixVector(m, v);
		DecimalFormat f = new DecimalFormat("0.000");
		for (int i = 0; i < n; i++) {
			System.out.print(f.format(mv[i]) + " ");
		}
	}

	public static double[][] matrixP(int n) {
		double[][] matrix = new double[n][n];
		int count;
		for (int i = 0; i < n; i++) {
			int t = new Integer(JOptionPane.showInputDialog("Me sa lidhet "
								+ (i + 1))).intValue();
			count = t;
			while (count > 0) {
				int c = new Integer(JOptionPane.showInputDialog("Me ke lidhet "
									+ (i + 1))).intValue();
				matrix[i][c - 1] = 1.0 / t;
				count--;
			}
		}
		return matrix;
	}

	public static double [] matrixVector(double[][] A, double[] v) {
		double[] result = new double[v.length]; 
		double[] Av = Matrix.multiply(A, v);
		result = Matrix.multiply(A, Av);
		for(int i = 0; i < A.length; i++ )
				Av = result;
		return result;
	}

	public static double[] defineVector(int n) {
		double[] vector = new double[n];
		for(int i = 0; i < vector.length; i++ )
				vector[i] = 1.0/n;
		return vector;
	}
}


