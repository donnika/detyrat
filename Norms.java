/**
 * @author Drita Shujaku
 *
 */

import javax.swing.*;

public class Norms {

 public static void main(String[] args) {
      double[][] array = fillMatrix();
      for(int i = 0; i < array.length; i++) {
         for(int j = 0; j < array[0].length; j++) {
            System.out.print(array[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println(findFrobenius(array));
      System.out.println(findlInfinit(array));
   }
 
   public static double[] fillVector(int n) {
      double[] d = new double[n];
      for(int i = 0; i < n; i++) {
         String input = JOptionPane.showInputDialog("Type element " + i);
         d[i] = Double.parseDouble(input);
      }
      return d;
   }
   
   public static double[][] fillMatrix() {
      String row = JOptionPane.showInputDialog("Type the number of rows");
      int r = new Integer(row).intValue();
      String column = JOptionPane.showInputDialog("Type the number of columns");
      int c = new Integer(column).intValue();
      double[][] d = new double[r][c];
      for(int i = 0; i < r; i++) {
         for(int j = 0; j < c; j++) {
            String input = JOptionPane.showInputDialog("Type the element of: row " + i + ", column " + j);
            d[i][j] = Double.parseDouble(input);
         }
      }
      return d;
   }
   
   public double[] findSum(double[] a, double[] b) {
      double[] sum = new double[a.length];
      for(int i = 0; i < sum.length; i++) {
         sum[i] = a[i] + b[i];
      }
      return sum;
   }
   
   public static double[] findDifference(double[] a, double[] b) {
      double[] diff = new double[a.length];
      for(int i = 0; i < diff.length; i++) {
         diff[i] = a[i] - b[i];
      }
      return diff;
   }
   
   public static double findl2(double[] x) {
      double sum = 0;
      for(int i = 0; i < x.length; i++) {
         sum += Math.pow(x[i], 2);
      }
      return Math.sqrt(sum);
   }
   
   public static double findlInfinit(double[] x) {
      double max = Math.abs(x[0]);
      for(int i = 1; i < x.length; i++) {
         if(Math.abs(x[i]) > max)
            max = Math.abs(x[i]);
      }
      return max;
   }
   
   public static double findEuclidDistance(double[] x, double[] y) {
      double distance = 0;
      for(int i = 0; i < x.length; i++) {
         distance += Math.pow(x[i] - y[i], 2);
      }
      return Math.sqrt(distance);
   }
   
   public static double findMaxDistance(double[] x, double[] y) {
      double max = Math.abs(x[0] - y[0]);
      for(int i = 1; i < x.length; i++) {
         if(Math.abs(x[i] - y[i]) > max)
            max = Math.abs(x[i] - y[i]);
      }
      return max;
   }
   
   public static double findlInfinit(double[][] A) {
      double max = 0;
      double sum = 0;
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < A[0].length; j++) {
            sum += Math.abs(A[i][j]);
         }
         if(sum > max){
            max = sum;
         }
         sum = 0;
      }
      return max;
   }
   
   public static double findFrobenius(double[][] A) {
      double sum = 0;
      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < A.length; j++) {
            sum += Math.pow(A[i][j], 2);
         }
      }
      return Math.sqrt(sum);
   }
}