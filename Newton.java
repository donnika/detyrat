public class Newton
{  
	static double[][] A = {{2,-3,0},	
						    {1.2,1,1},
					       {-0.1,2,4}};
   static int n = A.length;

  	public static double[][] Newton(int N, double[][] A, double TOL)
	{
		double[][] y = new double[n][n];
		int k = 1;
		while(k<=N)
		{
			double[][] inversedJ = inverzi(derivati(A[0][0],A[1][0],A[2][0]));
			A = mbledhja(A,shumzimi(inversedJ,funksioni(A[0][0],A[1][1],A[2][2])));
			double[] y1 = {y[0][0],y[1][0],y[2][0]};
			if(vectorNorm(y1)<TOL)
			{ System.out.println("Metoda perfundoi pas " + k + " iterimeve");
           	return A;
           }
			k++;
		}
	   throw new RuntimeException("Eshte tejkaluar numri i iterimeve: " + n);
	}

   
	
	public static double[][] mbledhja(double[][] matrix1,double[][] matrix2)
	{
		double[][] result = new double[matrix1.length][matrix1.length];
		for(int i=0;i<matrix1.length;i++)
		{
			for(int j=0;j<matrix1.length;j++)
			{
				result[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		return result;
	}
	
    public static double[][] inverzi(double[][] A) {
        double[][] res = new double[3][3];
        double detA = A[0][0] * A[1][1] * A[2][2] + A[0][2] * A[1][0] * A[2][1]
        			+ A[2][0] * A[1][2] * A[0][1]- A[2][0] * A[1][1] * A[0][2] 
        			- A[2][2] * A[1][0] * A[0][1] - A[0][0] * A[2][1] * A[1][2];              
        res[0][0] = 1 / detA * (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
        res[0][1] = 1 / detA * (A[0][2] * A[2][1] - A[2][2] * A[0][1]);
        res[0][2] = 1 / detA * (A[0][1] * A[1][2] - A[1][1] * A[0][2]);
        res[1][0] = 1 / detA * (A[1][2] * A[2][0] - A[2][2] * A[1][0]);
        res[1][1] = 1 / detA * (A[0][0] * A[2][2] - A[2][0] * A[0][2]);
        res[1][2] = 1 / detA * (A[0][2] * A[1][0] - A[1][2] * A[0][0]);
        res[2][0] = 1 / detA * (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
        res[2][1] = 1 / detA * (A[0][1] * A[2][0] - A[2][1] * A[0][0]);
        res[2][2] = 1 / detA * (A[0][0] * A[1][1] - A[1][0] * A[0][1]);
        
        return res;
    }
	
    public static double[][] shumzimi(double[][] A, double[][] B) 
    {
        double[][] res = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) 
        {
            for (int j = 0; j < B[0].length; j++) 
            {
                for (int k = 0; k < A[0].length; k++) 
                {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
	
	public static double[][] funksioni(double x1,double x2,double x3)
	{
		double[][] res = new double[3][3];		
		res[0][0] = 3.0*x1 - Math.cos(x2*x3) - 1.0/2;
		res[1][0] = x1*x1 - 81.0*Math.pow(x2+0.1,2) + Math.sin(x3) + 1.06;
		res[2][0] = Math.exp(-x1*x2) + 20.0*x3 + (10*Math.PI - 3)/3.0;
		return res;
	}
	
	public static double[][] derivati(double x1,double x2,double x3)
	{
		double[][] res = new double[3][3];
		res[0][0] = 3;
		res[0][1] = x3*Math.sin(x2*x3);
		res[0][2] = x2*Math.sin(x2*x3);
		res[1][0] = 2*x1;
		res[1][1] = -162*(x2+0.1);
		res[1][2] = Math.cos(x3);
		res[2][0] = -1*x2*Math.exp(-1*x1*x2);
		res[2][1] = -1*x1*Math.exp(-1*x1*x2);
		res[2][2] = 20;
		return res;
	}
	
   public static double vectorNorm(double[] vector)
	{
		double result = 0;
		for(int i=0;i<vector.length;i++)
		{
			result = result + Math.pow(vector[i], 2);
		}
		return Math.sqrt(result);
	}
	
	public static void main(String[] args)
	{  double[][] x = Newton(6,A,0.001);
		System.out.println("x1= " +  x[0][0]);
      System.out.println("x2= " +  x[1][0]);
      System.out.println("x3= " +  x[2][0]);
	}

}
