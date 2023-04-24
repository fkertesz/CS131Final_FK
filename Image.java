/**
 * This class creates an Image object and includes the setters,
 * getters, and methods necessary to reach the objective of
 * the program VECTORIA. This object will store a 16-pixel vector
 * image and the 4 3x3 image-parts of it which will be represented
 * as 9-pixel vector images.
 * @author Fanni Kertesz
 * @version 1.0
 * Final Project
 * CS131-01
 */
public class Image
{
	private Vector im;//vector image
	private Vector topLeft;//top-left 3x3 image
	private Vector topRight;//top-right 3x3 image
	private Vector botLeft;//bottom-left 3x3 image
	private Vector botRight;//bottom-right 3x3 image
	
	/**
	 * Preferred-argument constructor that sets the image to the
	 * inputed vector, and sets the corresponding image parts.
	 * @param im vector image
	 */
	public Image(Vector im)
	{
		this.im = im;
		topLeft = new Vector(9);
		topRight = new Vector(9);
		botLeft = new Vector(9);
		botRight = new Vector(9);
		
		//entries of the vector image corresponding to each part
		int[] tL = {0,1,2,4,5,6,8,9,10};
		int[] tR = {4,5,6,8,9,10,12,13,14};
		int[] bL = {1,2,3,5,6,7,9,10,11};
		int[] bR = {5,6,7,9,10,11,13,14,15};
		
		/*Sets entries of partial images to corresponding
		* entries of the image vector.*/
		for(int i = 0; i<9; i++)
		{
			topLeft.setEntry(i, im.getEntry(tL[i]));
			topRight.setEntry(i, im.getEntry(tR[i]));
			botLeft.setEntry(i, im.getEntry(bL[i]));
			botRight.setEntry(i, im.getEntry(bR[i]));
		}//end for
		
	}//end constructor
	
	/**
	 * Sets the image to a new one, and repeats the process the
	 * constructor does.
	 * @param im the new image vector
	 */
	public void setIm(Vector im)
	{
		this.im = im;
		topLeft = new Vector(9);
		topRight = new Vector(9);
		botLeft = new Vector(9);
		botRight = new Vector(9);
		
		int[] tL = {0,1,2,4,5,6,8,9,10};
		int[] tR = {4,5,6,8,9,10,12,13,14};
		int[] bL = {1,2,3,5,6,7,9,10,11};
		int[] bR = {5,6,7,9,10,11,13,14,15};
		
		for(int i = 0; i<9; i++)
		{
			topLeft.setEntry(i, im.getEntry(tL[i]));
			topRight.setEntry(i, im.getEntry(tR[i]));
			botLeft.setEntry(i, im.getEntry(bL[i]));
			botRight.setEntry(i, im.getEntry(bR[i]));
		}//end for
		
	}//end setIm
	
	/**
	 * @return vector image
	 */
	public Vector getIm()
	{
		return im;
	}//end getIm

	/**
	 * @return vector image of top-left
	 */
	public Vector getTopLeft()
	{
		return topLeft;
	}//end getTopLeft

	/**
	 * @return vector image of top-right
	 */
	public Vector getTopRight()
	{
		return topRight;
	}//end getTopRight

	/**
	 * @return vector image of bottom-left
	 */
	public Vector getBotLeft()
	{
		return botLeft;
	}//end getBotLeft

	/**
	 * @return vector image of bottom-right
	 */
	public Vector getBotRight()
	{
		return botRight;
	}//end getBotRight

	/**
	 * This method checks the 4 parts of the image for an inputed
	 * pattern.
	 * @param p pattern to be detected in image
	 * @return boolean array with each value corresponding to the
	 * detection of the pattern in each part of the image
	 */
	public boolean[] checkParts(Pattern p)
	{
		Vector zeroV = new Vector(9);
		double[] z = {0,0,0,0,0,0,0,0,0};
		zeroV.setAllEntries(z);
		boolean[] b = new boolean[4];
		
		/* Entry is true if the dot-product of the vector image of
		 * the partial image and the expansion of the vector image
		 * of the pattern multiplied by the partial image, and if
		 * the partial image is not empty (false positive).*/
		b[0] = (0 == topLeft.dotProduct(topLeft.multByM(p.getExpV()))
				&& !topLeft.equalsTo(zeroV));
		b[1] = (0 == topRight.dotProduct(topRight.multByM(p.getExpV()))
				&& !topRight.equalsTo(zeroV));
		b[2] = (0 == botLeft.dotProduct(botLeft.multByM(p.getExpV()))
				&& !botLeft.equalsTo(zeroV));
		b[3] = (0 == botRight.dotProduct(botRight.multByM(p.getExpV()))
				&& !botRight.equalsTo(zeroV));
		return b;
	}//end checkParts
	
}//end class
