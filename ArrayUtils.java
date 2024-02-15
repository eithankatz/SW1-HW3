import java.util.Arrays;

public class ArrayUtils 
{
	public static int[] shiftArrayCyclic(int[] array, int move, char direction) 
	{
		if(array.length > 0)
			if(direction == 'L' || direction == 'R')
			{
				if(direction == 'L')			//move x to the left == move -x to the right
					move *=-1;
				move = (move % array.length + array.length)%array.length;	//this gives move the "real" move modulo array.length
				if (move == 0)					//no need to shift by 0
					return array;
				
				int[] shifted = new int[array.length];		//holds the shifted array		
				for(int i = 0; i < array.length; i++)	
					shifted[((i+move)%shifted.length+shifted.length)%shifted.length] = array[i];
				for(int i = 0; i < array.length; i++)
					array[i] = shifted[i];
			}
		return array;
	}

	public static int findShortestPath(int[][] m, int i, int j) 
	{
		if(i == j) 
			return 0;
		boolean[] visited = new boolean[m.length];	//memoization
		visited[i] = true;
		return findShortestPathRec(m,i,j,visited);
	}
	
	private static int findShortestPathRec(int[][] m, int i, int j, boolean[] visited) 
	{
		if(i == j) 
			return 0;
		int min = m.length;		//if there is a route, than there must be a route shorter than m.length
		for(int k=0; k<m.length; k++)
			if(m[i][k] == 1 && !visited[k])
			{
				visited[k] = true;
				min = Math.min(min, 1 + findShortestPathRec(m, k, j, visited));
				visited[k] = false;
			}
		return min == m.length ? -1 : min;
	}
}
