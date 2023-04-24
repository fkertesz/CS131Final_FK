import java.util.*;
/**
 * This class is the Application class that uses the
 * Matrix, Vector, Pattern, and Image classes to reach
 * the objective of the program VECTORIA. The class declares
 * some basic patterns, receives input from the user, detects
 * patterns in the inputed images, and prints out the results
 * as long as the user desires to keep using the program. This
 * class catches the one possible exception out of the control of
 * the program, which is an input mismatch exception.
 * @author Fanni Kertesz
 * @version 1.0
 * Final Project
 * CS131-01
 */
public class Application
{
	public static void main(String[] args)
	{
		/* Instantiation of some basic patterns with a corresponding
		 * number above them*/
		
		//0
		double[] letterT_A = {1,0,0,1,1,1,1,0,0};
		Vector letterT_V = new Vector(9);
		letterT_V.setAllEntries(letterT_A);
		Pattern letterT = new Pattern(letterT_V);
		
		//1
		double[] upsDownT_A = {0,0,1,1,1,1,0,0,1};
		Vector upsDownT_V = new Vector(9);
		upsDownT_V.setAllEntries(upsDownT_A);
		Pattern upsDownT = new Pattern(upsDownT_V);
		
		//2
		double[] letterV_A = {1,1,0,0,0,1,1,1,0};
		Vector letterV_V = new Vector(9);
		letterV_V.setAllEntries(letterV_A);
		Pattern letterV = new Pattern(letterV_V);
		
		//3
		double[] upsDownV_A = {0,1,1,1,0,0,0,1,1};
		Vector upsDownV_V = new Vector(9);
		upsDownV_V.setAllEntries(upsDownV_A);
		Pattern upsDownV = new Pattern(upsDownV_V);
		
		//4
		double[] crossX_A = {1,0,1,0,1,0,1,0,1};
		Vector crossX_V = new Vector(9);
		crossX_V.setAllEntries(crossX_A);
		Pattern crossX = new Pattern(crossX_V);
		
		//5
		double[] plusSign_A = {0,1,0,1,1,1,0,1,0};
		Vector plusSign_V = new Vector(9);
		plusSign_V.setAllEntries(plusSign_A);
		Pattern plusSign = new Pattern(plusSign_V);
		
		//6
		double[] vertLine_A = {0,0,0,1,1,1,0,0,0};
		Vector vertLine_V = new Vector(9);
		vertLine_V.setAllEntries(vertLine_A);
		Pattern vertLine = new Pattern(vertLine_V);
		
		//7
		double[] horizLine_A = {0,1,0,0,1,0,0,1,0};
		Vector horizLine_V = new Vector(9);
		horizLine_V.setAllEntries(horizLine_A);
		Pattern horizLine = new Pattern(horizLine_V);
		
		//8
		double[] square_A = {1,1,1,1,1,1,1,1,1};
		Vector square_V = new Vector(9);
		square_V.setAllEntries(square_A);
		Pattern square = new Pattern(square_V);
		
		//the empty image
		double[] im_A = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		Vector im_V = new Vector(16);
		im_V.setAllEntries(im_A);
		Image im = new Image(im_V);
		
		Scanner scan = new Scanner(System.in);
		boolean go = true;
		String forGo;
		boolean det = false;//for message if nothing detected
		
		//Arrays for pattern names, image parts, and patters
		
		String[] patternNames_A = {"letterT", "upsDownT", "letterV", "upsDownV",
				"crossX", "plusSign", "vertLine", "horizLine", "square"};
		
		String[] parts_A = {"top left", "top right", "bottom left", "bottom right"};
		
		Pattern[] patternPat_A = {letterT, upsDownT, letterV, upsDownV,
				crossX, plusSign, vertLine, horizLine, square};
		
		boolean[][] patternDet_A = new boolean[9][4];//4 parts, 9 patterns
		
		/* While loop takes in double-type entries from the
		 * user (checks exception and restarts loop if exception
		 * thrown), sets it as the image, checks for the patterns,
		 * and prints out detected patterns and locations. Restarts
		 * if user desires it to.
		 */
		while(go)
		{
			det = false;
			
			System.out.println("Enter your image in vector form, "
					+ "one entry at a time: ");
			
			for(int i = 0; i < 16; i++)
			{
				try
				{
					im_A[i] = scan.nextDouble();
				}//end try
				
				catch(InputMismatchException e)
				{
					i = 16;
					det = false;
					System.out.println("Restart image"
							+ "and enter numbers only");
				}//end catch
			}//end for i
			
			System.out.println();
			
			im_V.setAllEntries(im_A);
			im.setIm(im_V);
			
			for(int j = 0; j < 9; j++)
			{
				for(int m = 0; m < 4; m++)
				{
					patternDet_A[j][m] = im.checkParts(patternPat_A[j])[m];
				}//end for m
			}//end for j
			
			for(int k = 0; k < 9; k++)
			{
				for(int l = 0; l < 4; l++)
				{
					if(patternDet_A[k][l] == true)
					{
						det = true;
						System.out.println("Pattern " + patternNames_A[k]
								+ " was detected in the " + parts_A[l]
										+ " part of your image.");
					}//end if
				}//end for l
			}//end for k
			
			if(det == false)//if nothing was detected
				System.out.println("No patterns were detected.");
			
			System.out.println("\nWould you like to process another image?(y/n)");
			
			forGo = scan.next();
			if(forGo.equals("n"))
				go = false;
			System.out.println();
		}
		
		scan.close();
	}//end main
}//end class