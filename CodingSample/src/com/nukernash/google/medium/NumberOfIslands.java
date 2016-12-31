package com.nukernash.google.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 */

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1', '1', '1'},
		                 {'0', '1', '0'},
		                 {'1', '1', '1'}};
		
		System.out.println(numIslands(grid));
	}
	
	private static final boolean  CONSIDER_CORNERS = false;
	private static boolean[][] visited;

	public static int numIslands(char[][] grid) {
		int count = 0;
		if(grid.length == 0){
			return 0;
		}
		visited = new boolean[grid.length][grid[0].length];
		for(int i=0; i < grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(visited[i][j] || grid[i][j] == '0'){
					visited[i][j] = true;
					continue;
				}else if(grid[i][j] == '1'){
					count++;
					bfs(i, j, grid);
				}else{
					return 0;
				}
				visited[i][j] = true;
			}
		}
		return count;
    }
	
	private static void bfs(int i, int j, char[][] grid){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(i, j));
		while(!queue.isEmpty()){
			Node currentNode = queue.poll();
			Set<String>  neigboursThatAreOne =  getNeighboursThatAreOne(grid, currentNode.i, currentNode.j);
			for(String nodeStr : neigboursThatAreOne){
				Node node = Node.getValueOf(nodeStr);
				if(!visited[node.i][node.j]){
					visited[node.i][node.j] = true;
					queue.add(node);
				}
			}
		}
	}
	
	public static Set<String> getNeighboursThatAreOne(char[][] grid, int x, int y){
		
		Set<String> neighbors = new HashSet<String>();
	    for (int xx = -1; xx <= 1; xx++) {
	        for (int yy = -1; yy <= 1; yy++) {
	            if (xx == 0 && yy == 0) {
	                continue; // You are not neighbor to yourself
	            }
	            if (!CONSIDER_CORNERS && Math.abs(xx) + Math.abs(yy) > 1) {
	                continue;
	            }
	            if (isOnMap(x + xx, y + yy, grid)) {
	            	if(grid[x + xx][y + yy] == '1'){
	            		neighbors.add(new Node(x + xx, y + yy).toString());
	            	}
	            }
	        }
	    }
	    return neighbors;
	}
	
	public static boolean isOnMap(int x, int y, char[][] grid) {
		//System.out.println("x -> " + x + ", y -> " + y);
	    return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
	}

}

class Node{
	int i;
	int j;
	
	public Node(int i, int j) {
		this.i=i;
		this.j = j;
	}
	
	@Override
	public String toString(){
		return "[" + i + "," + j + "]";
	}
	
	public static Node getValueOf(String node){
		String s = node.substring(1, node.length()-1);
		String[] index = s.split(",");
		return new Node(Integer.valueOf(index[0]), Integer.valueOf(index[1]));
	}
}
