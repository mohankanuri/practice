package com.riddle;
import java.util.Scanner;

public class NumberSwirl {
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
	int value = n*n;
    
    int minCol = 0;
     
    int maxCol = n-1;
     
    int minRow = 0;
     
    int maxRow = n-1;
    
    int[][] spiral = new int[n][n];
    
	 while (value >= 1)
     {
         for (int i = minCol; i <= maxCol; i++){spiral[minRow][i] = value;value--;}
         
         for (int i = minRow+1; i <= maxRow; i++){spiral[i][maxCol] = value;value--;}
         
         for (int i = maxCol-1; i >= minCol; i--){spiral[maxRow][i] = value;value--;}
         
         for (int i = maxRow-1; i >= minRow+1; i--){spiral[i][minCol] = value;value--;}
         
         minCol++; minRow++; maxCol--; maxRow--;
         }
	
	
	
	System.out.println();
	System.out.println();
	
	// For loop to print in matrix form
	for(int rows=0;rows<n;rows++) {
		for(int columns =0; columns<n;columns++) {
			System.out.print(spiral[rows][columns]+"\t");
		}
		System.out.println();
	}
	
	input.close();
}
}
