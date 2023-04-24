/**
 * This class creates a Vector object which is a special Matrix
 * with 1 column. The class includes the setters, getters, and
 * methods necessary to reach the objective of the program VECTORIA.
 * It does not include exceptions, given that the code is correct
 * (based on thorough testing), and the user in the Application
 * class cannot cause the throwing of an exception.
 * @author Fanni Kertesz
 * @version 1.0
 * Final Project
 * CS131-01
 */
public class Vector extends Matrix
{
	
	/*
	 * Empty-argument constructor that instantiates the vector
	 * dimension row to 1 using the super class's constructor.
	 */
	Vector()
	{
		super(1,1);
	}//end constructor
	
	/**
	 * Preferred-argument constructor that instantiates the vector
	 * dimension row to preferred row using the super class's
	 * constructor
	 * @param row the preferred row
	 */
	Vector(int row)
	{
		super(row, 1);
	}//end constructor
	
	/**
	 * @return row dimension
	 */
	public int getRow()
	{
		return row;
	}//end getRow
	
	/**
	 * Getter for a particular entry in the rth row.
	 * @param r the row number of the entry 
	 * @return the entry in row r
	 */
	public double getEntry(int r)
	{
		return m[r][0];
	}//end getEntry
	
	/**
	 * Setter for a particular entry in the rth row.
	 * @param r the row number of the entry
	 * @param the entry in row r
	 */
	public void setEntry(int r, double entry)
	{
		m[r][0] = entry;
	}//end setEntry
	
	/**
	 * Setter for all entries using a 1-d array of length
	 * corresponding to the vector row numbers and of type double.
	 * @param a the array corresponding to set entries
	 */
	public void setAllEntries(double[] a)
	{
		for(int t = 0; t<row; t++)
		{
			m[t][0] = a[t];
		}//end for t
	}//end setAllEntries
	
	/**
	 * This method multiplies a matrix on the left with this vector
	 * on the right. This method is necessary regardless of the
	 * multiply method in the matrix class because this method's
	 * product is a vector and thus returns a Vector object
	 * instead of a Matrix object.
	 * @param m the left matrix
	 * @return the product vector
	 */
	public Vector multByM(Matrix m)
	{
		//product vector with row number same as left matrix
		Vector prod = new Vector(m.getRow());
		
		//iterates through each row of left matrix
		for(int leftR = 0; leftR < m.getRow(); leftR++)
		{
			//restarts the sum for each entry in the product
			double sum = 0;
			
			//iterates through each common dimensions of the matrix
			//and the vector
			for(int comD = 0; comD < row; comD++)
			{
				sum += m.getEntry(leftR, comD)*getEntry(comD);
			}//end for comD
			
			//sets entry corresponding to left row to the sum
			prod.setEntry(leftR, sum);
			
		}//end for leftR
		
		return prod;
	
	}//end multbyM
	
	/**
	 * This method calculates the dot-product of this vector
	 * and another vector. Order does not matter here.
	 * @param v the other vector
	 * @return the dot-product
	 */
	public double dotProduct(Vector v)
	{
		double sum = 0;
		
		//iterates through each entry in the vectors
		for(int r = 0; r < row; r++)
		{
			sum += m[r][0]*v.getEntry(r);
		}//end for r
		
		return sum;
	}//end dotProduct
	
	/**
	 * This method parameterizes the entries of this vector,
	 * and represents that parameterization as a matrix.
	 * The columns of represent the "construction" of each variable,
	 * and the rows represent each variable.
	 * @return the parameterization matrix
	 */
	public Matrix simpleParam()
	{
		//parameterization matrix with dimensions (row-1) x row
		Matrix p = new Matrix(row-1,row);
		boolean go = true;
		
		//This variable keeps track of which entry = 1 first.
		//The entry corresponding to i is the parameterized variable
		int i = -1;
		
		while(go)
		{
			i++;
			if(m[i][0] == 1)//checks if entry = 1
			{
				go = false;
			}//end if
		}//end while
		
		/*variable skips the param variable column when making
		 * up an identity matrix "besides" the param variable*/
		int altJ = 0;
		
		//iterates through the entries of the vector
		for(int j = 0; j < row; j++)
		{
			//if j = the param variable, so column represents
			//the param variable
			if(j == i)
			{
				int altQ = 0;//variable for skipping param variable
				for(int q = 0; q < row; q++)
				{
					
					/*Entry setting skips the row that would
					correspond to the param variable in the column
					that corresponds to the param variable,
					hence there not being an else block*/
					if(q != i)
					{
						p.setEntry(altQ, j, -1*m[q][0]);
						altQ++;
					}//end if
					
				}//end for q
				
			}//end if
			
			/*Creates the identity matrix wrapping around the
			 * one column that represents the param variable*/
			else
			{
				//iterates through rows
				for(int k = 0; k < row-1; k++)
				{
					//row number corresponding to next 1-diagonal
					if(k == altJ)
					{
						p.setEntry(k, j, 1);
					}//end if
					
					else
					{
						p.setEntry(k, j, 0);
					}//end else
					
				}//end for k
				
				altJ++;
			}//end else
			
		}//end for j
		
		return p;
	}//end simpleParam
	
	/**
	 * This method checks if two vectors have the same number of
	 * entries and the same values in corresponding entries,
	 * therefore equal.
	 * @param w the vector being compared to this vector
	 * @return true if equal, false if not equal
	 */
	public boolean equalsTo(Vector w)
	{
		boolean b = false;
		
		//immediately rules out equality if entry numbers don't match
		if(row == w.getRow())
		{
			b = true;
			
			//iterates through each entry and checks if they are unequal
			for(int r = 0; r < row; r++)
			{
				if(m[r][0] != w.getEntry(r))
					b = false;
			}//end for r
			
			return b;
		}//end if
		
		else
			return b;
	}//end equalsTo
	
}//end class