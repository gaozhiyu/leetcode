package leetcode;

import java.util.HashMap;
import java.util.Stack;

import junit.framework.Assert;

public class UniquePath3 {

	public static int sum = 0;
	//HashMap<String,Boolean> hashMap = new HashMap<String,Boolean>();

	

	public class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	@org.junit.Test
	public void Test() {
		int a[][] = {{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
		//int a[][] = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] b = new int[a.length][a[0].length];
		for(int i =0;i<b.length;i++){
			for(int j =0;j<b[0].length;j++){
				b[i][j]=0;
			}
		}
		
		uniquePathsWithObstacles(a,b);
		System.out.print(sum);
		Assert.assertEquals(sum, 2);
		// System.out.println(a[0][2]);// first mean row , second means column
	}

	// class Solution {
	public void uniquePathsWithObstacles(int[][] obstacleGrid,int[][] map) {
		Stack<Position> stack = new Stack<Position>();
		if(obstacleGrid[0][0] ==0){
			//stack.push(new Position(0,0));
		}else {
			sum =0;
			return ;
		}
		navigate(0, 0, obstacleGrid,stack, map);
	}

	private void navigate(int i, int j, int[][] obstacleGrid,Stack<Position> stack,int[][] map) {
		// if(i < obstacleGrid.length-1 ){
		while (true){
		if (j < obstacleGrid[0].length - 1 && obstacleGrid[i][j + 1] == 0) {
			if (i < obstacleGrid.length - 1 && obstacleGrid[i + 1][j] == 0) {
				//if()
				if(map[i][j]==0){
					stack.push(new Position(i, j));
					map[i][j]=1;
				}
			}
			//navigate(i, j + 1, obstacleGrid,stack);
			j++;
		} else {
			if (j == obstacleGrid[0].length - 1 && i == obstacleGrid.length - 1 && obstacleGrid[i][j] == 0) {
				sum++;
				if(!stack.isEmpty()){
					Position pos = stack.pop();
					i=pos.x+1;
					j= pos.y;
					//navigate(pos.x + 1, pos.y, obstacleGrid,stack);
				}else{
					break;
				}
			} else if (i < obstacleGrid.length - 1) {
				//navigate(i + 1, j, obstacleGrid,stack);
				i++;
			} else {
				if(!stack.isEmpty()){
					Position pos = stack.pop();
					//navigate(pos.x + 1, pos.y, obstacleGrid,stack);
					i=pos.x+1;
					j= pos.y;
				}else{
					break;
				}
			}
		}
		}
		// }
	}

	// }

}
