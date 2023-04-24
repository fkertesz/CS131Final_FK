/**
 * This class creates a Matrix object and includes the setters,
 * getters, and methods necessary to reach the objective of
 * the program VECTORIA or for testing. It does not include
 * exceptions, given that the code is correct (based on thorough
 * testing), and the user in the Application class cannot cause
 * the throwing of an exception.
 * 
 * @author Fanni Kertesz
 * @version 1.0
 * Final Project
 * CS131-01
 */

public class Matrix
{
	protected int row;//variable represents the number of rows in the matrix
	protected int col;//variable represents the number of columns in the matrix
	protected double [][] m;//array contains the entries of the matrix
	
	/*
	 * Empty-argument constructor that instantiates the matrix
	 * dimensions (row x col) to 1 x 1, and instantiates the
	 * array with those dimensions.
	 */
	Matrix()
	{
		row = 1;
		col = 1;
		m = new double [row][col];
	}//end constructor
	
	/**
	 * Preferred-argument constructor that instantiates the
	 * dimensions of the matrix to the preferred row and col
	 * integer variable, and instantiates the array dimensions to
	 * those same values.
	 * @param row the preferred row dimension for the matrix
	 * @param col the preferred column dimension for the matrix
	 */
	Matrix(int row, int col)
	{
		this.row = row;
		this.col = col;
		m = new double [row][col];
	}//end constructor

	/**
	 * @return the row dimension of the matrix
	 */
	public int getRow()
	{
		return row;
	}//end getRow

	/**
	 * @return the column dimension of the matrix
	 */
	public int getCol() {
		return col;
	}//end getCol
	
	/**
	 * Getter for a particular entry in the matrix in the
	 * rth row and cth column. The entry numbering corresponds
	 * to array denotation (0 to n for n+1 entries) instead of
	 * the typical matrix denotation(1 to n+1 for n+1 entries).
	 * @param r the row number of the entry
	 * @param c the column number of the entry
	 * @return current entry at r,c
	 */
	public double getEntry(int r, int c)
	{
		return m[r][c];
	}//end getEntry
	
	/**
	 * Setter for a particular entry in the matrix in the
	 * rth row and cth column.
	 * @param r the row number of the entry
	 * @param c the column number of the entry
	 * @param entry the value that is set in the entry
	 */
	public void setEntry(int r, int c, double entry)
	{
		m[r][c] = entry;
	}//end setEntry
	
	/**
	 * @return current array containing entries of matrix
	 */
	public double[][] getMatrix()
	{
		return m;
	}//end getMatrix
	
	/**
	 * This method creates the transpose (matrix with switched
	 * rows and columns) of the matrix and returns it. It does not
	 * affect the matrix stored in the object.
	 * @return transpose of original matrix
	 */
	public Matrix transpose()
	{
		Matrix tM = new Matrix(col, row);//(t)ranspose (M)atrix
		
		//iterates through original matrix
		for(int r = 0; r < row; r++)
		{
			for(int c = 0; c < col; c++)
			{
				//switches the rows and columns of the original
				//matrix and sets it as the entry of the transpose
				tM.setEntry(c, r, m[r][c]);
				
			}//end for c
			
		}//end for r
		
		return tM;
		
	}//end transpose
	
	/**
	 * This method multiplies two matrices and returns their product.
	 * The left matrix is this matrix and the right matrix is the
	 * inputed one (order matters with matrix multiplication).
	 * @param n the right matrix
	 * @return the product of the two matrices
	 */
	public Matrix multiply(Matrix n)
	{
		//product matrix with dimensions left row x right column
		Matrix prod = new Matrix(row, n.getCol());
		
		//iterates through each row of left matrix
		for(int leftR = 0; leftR < row; leftR++)
		{
			//iterates through each column of right matrix
			for(int rightC = 0; rightC < n.getCol(); rightC++)
			{
				//restarts the sum for each entry in the product
				double sum = 0;
				
				//iterates through each common dimension of the two matrices
				for(int comD = 0; comD < col; comD++)
				{
					sum += m[leftR][comD]*n.getEntry(comD, rightC);
				}//end for comD
				
				//sets entry corresponding to left row, right column
				//to the sum
				prod.setEntry(leftR, rightC, sum);
				
			}//end for rightC
		}//end leftR
		return prod;
	}//end multiply
	
	/*
	 * This method prints out the matrix on the system's default
	 * outlet. This method is mainly for testing.
	 */
	public void printMatrix()
	{
		StringBuilder sb = new StringBuilder();
		
		//for loops iterate through matrix
		for(int r = 0; r < row; r++)
		{
			sb.append("[");
			for(int c = 0; c < col; c++)
			{
				sb.append(m[r][c]);
				if(c+1!=col)
					sb.append(" ");
			}//end for c
			sb.append("]\n");
		}//end for r
		System.out.print(sb.toString());
	}//end printMatrix
}//end class
