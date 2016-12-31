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
	private static List<Set<Node>> islandList = new ArrayList<Set<Node>>();

	public static int numIslands(char[][] grid) {
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
					Set<Node> island = new HashSet<Node>();
					island.add(new Node(i, j));
					islandList.add(island);
					bfs(i, j, grid, island);
				}else{
					return 0;
				}
				visited[i][j] = true;
			}
		}
		System.out.println(islandList);
		return islandList.size();
    }
	
	private static void bfs(int i, int j, char[][] grid, Set<Node> island){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(i, j));
		while(!queue.isEmpty()){
			Node currentNode = queue.poll();
			Set<Node>  neigboursThatAreOne =  getNeighboursThatAreOne(grid, currentNode.i, currentNode.j);
			for(Node node : neigboursThatAreOne){
				if(!visited[node.i][node.j]){
					visited[node.i][node.j] = true;
					island.addAll(neigboursThatAreOne);
					queue.add(node);
				}
			}
		}
	}
	
	private static Set<Node> isPartOfAnExistingIsland(int i, int j){
		for(Set<Node> island : islandList){
			for(Node node : island){
				if(node.i == i && node.j == j){
					return island;
				}
			}
		}
		return null;
	}
	
	public static Set<Node> getNeighboursThatAreOne(char[][] grid, int x, int y){
		
		Set<Node> neighbors = new HashSet<Node>();
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
	            		neighbors.add(new Node(x + xx, y + yy));
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
}
