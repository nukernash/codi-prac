package com.nukernash.google.easy;

/*
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 */

/*
 * 3 + 3 + 0 + 3 + 2 + 2 + 3
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
		System.out.println(islandPerimeter(grid));
	}
	
	public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[i].length;j++){
        		if(grid[i][j] == 1){
        			count += (4 - getNeighbourOnesCount(i, j, grid));
        		}
        	}
        }
        return count;
    }
	
	private static int getNeighbourOnesCount(int i, int j, int[][] grid){
		int count = 0;
		for(int x=-1; x<=1; x++){
			for(int y=-1; y<=+1; y++){
				if(Math.abs(x) == Math.abs(y) 
						|| i+x<0 || j+y<0 
						|| i+x>grid.length-1 || j+y>grid[i].length-1
						|| (x==0 && y==0)){
					continue;
				}
				
				if(grid[i+x][j+y] == 1){
					count=count+1;
				}
			}
		}
		System.out.println(i + " , " + j + " : " + count);
		return count;
	}
}
