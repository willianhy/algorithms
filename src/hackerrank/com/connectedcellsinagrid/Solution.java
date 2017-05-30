package hackerrank.com.connectedcellsinagrid;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int numberOfRows = scan.nextInt();
		int numberOfColumns = scan.nextInt();
		int[][] matrix = new int[numberOfRows][numberOfColumns];
		int[][] considered = new int[numberOfRows][numberOfColumns];
		
		for(int rows = 0; rows < numberOfRows; rows++)
			for(int columns = 0; columns < numberOfColumns; columns++){
				matrix[rows][columns] = scan.nextInt();
				considered[rows][columns] = 0;
			}
		
		int maxRegion = 0;
		int[] points = null;
		while((points = giveMeFreePoint(considered, numberOfRows, numberOfColumns))!= null){
			int result = regionSize(matrix, considered, points[0], points[1], numberOfRows, numberOfColumns);
			if (result > maxRegion)
				maxRegion = result;
		}
		
		System.out.println(maxRegion);
		scan.close();
	}
	
	static int regionSize(int[][] matrix, int[][] considered, int startRow, int startColumn, int maxRow, int maxColumn){
		if ((startRow > maxRow - 1) || (startColumn > maxColumn - 1) || (startRow < 0) || (startColumn < 0))
			return 0;
		
		if (matrix[startRow][startColumn] == 1 && considered[startRow][startColumn] == 0){
			considered[startRow][startColumn] = 1;
			return 1 + regionSize(matrix, considered, startRow - 1, startColumn - 1, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow - 1, startColumn, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow - 1, startColumn + 1, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow, startColumn - 1, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow, startColumn + 1, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow + 1, startColumn - 1, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow + 1, startColumn, maxRow, maxColumn) +
				       regionSize(matrix, considered, startRow + 1, startColumn + 1, maxRow, maxColumn);
		}
		
		considered[startRow][startColumn] = 1;
		return 0;
	}
	
	static int[] giveMeFreePoint(int[][] considered, int maxRow, int maxColumn){
		for(int i = 0; i < maxRow; i++)
			for(int j = 0; j< maxColumn; j++)
				if (considered[i][j] == 0)
					return new int[]{i, j};
		
		return null;
	}
}
