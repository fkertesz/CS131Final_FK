/**
 * This class creates a Pattern object and includes the setters,
 * getters, and methods necessary to reach the objective of
 * the program VECTORIA. This object stores the image of the
 * pattern in vector form stored and the expansion of the vector
 * which is necessary for the detection of the pattern. The vector
 * form consists of the entry iteration down each column of a
 * pixel image, and the expansion is the transpose of the
 * parameterization of the vector multiplied by the parameterization
 * of the vector.
 * @author Fanni Kertesz
 * @version 1.0
 * Final Project
 * CS131-01
 */
public class Pattern
{
	private Vector v;//image of the pattern in vector form
	private Matrix expV;//expansion of the vector
	
	/**
	 * Preferred-argument constructor that instantiates the pattern's
	 * vector image to the received pattern, and constructs the
	 * expansion as well.
	 * @param v the vector image of the pattern
	 */
	public Pattern(Vector v)
	{
		this.v = v;
		expV = v.simpleParam().transpose().multiply(v.simpleParam());
	}//end constructor

	/**
	 * @return current vector image of pattern
	 */
	public Vector getV()
	{
		return v;
	}//end getV

	/**
	 * Receives new pattern, and resets the expansion, so it
	 * corresponds.
	 * @param v new vector image of pattern
	 */
	public void setV(Vector v)
	{
		this.v = v;
		expV = v.simpleParam().transpose().multiply(v.simpleParam());
	}//end setV

	/**
	 * @return current expansion of the vector image
	 */
	public Matrix getExpV()
	{
		return expV;
	}//end getExpV
	
}//end class