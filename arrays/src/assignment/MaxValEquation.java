package assignment;

public class MaxValEquation {

	public static void main(String[] args) {
		
		int[][] points = {{-19,9},{-15,-19},{-5,-8}, {18, -20}};
		// | x2 - x1 | <= k
		int k = 10;
	
		System.out.println(findMaxValueOfEquation(points, k));

	}
	
	static int findMaxValueOfEquation(int[][] points, int k) {
		int maxVal = Integer.MIN_VALUE;
		
        /**
        We are giving an array of x,y coordinates
        Then we are given on integer k
        
        We need to find pairs of points where | x2 - x1 | <= k
        and find he max value of y1 + y2 + | x2 - x1 | of such pairs
        */
        
        /**
        Constraints
        - Minimum of 2 points upto 10^5 points
        - x, y can range between -10^8 to + 10^8
        - the points are sorted by x values
        */
		
		/**
		 * Step 1. 
		 * 
		 * Find the pairs
		 * 
		 * How do we find a pair of points on a number line such that
		 * |x2 - x1| <= k
		 * 
		 * We know both x2 and x1 are positive 
		 * => -k <= x2 - x1 <= k
		 * => For given x1 and k, x1 -k <= x2 <= k + x1
		 * 
		 * So we need to find the index of 
		 * point having the ceiling of x1 - k 
		 * and the point having the floor of x1 + k;
		 * 
		 * Basically here we are finding he range of points that can satisfy the condition
		 * |x2 - x1| <= k, for a given x1 and x2
		 * 
		 * Step 2.
		 * As we find the pairs we can also find the value of the equation
		 * y1 + y2 + | x2 - x1 | 
		 * and check it against the max value found
		 */
		
		/**
		 * While finding the points we also need to ensure that we do not
		 * re consider the pair of same points
		 * 
		 * Since we are taking the modulus of x2 - x1 , there is a chance we recalculate the same pair
		 * for a point for which we are calculating the range later
		 * 
		 * Example: 
		 * int[][] points = {{1,3},{2,0},{3, 4},{5,10},{6,-10}};
		 * int k = 100;
		 * 
		 * | x2 - x1 | <= k
		 * All the points above satisfy the above equation
		 * 
		 * how we we ensure we do not double count here,
		 * This can be ensured by not taking points before the current x coordinate
		 * while searching for the range of values, or by not considering the points before this co-cordinate
		 * while calculating the max
		 */
		
		/**
		 * Step 1: Run a for loop iterating through the array of points
		 */
		
		for(int i = 0; i < points.length-1; i++) {
			
			int[] point = points[i];
			
			/**
			 * Index of element which is Ceiling of x1 - k 
		     * Index of element which is Floor of x1 + k;
			 */
			int x1 = point[0];
			int y1 = point[1];
			
			int upperCap = x1 + k;
			int lowerCap = x1 - k; 
			
			int upperBound = returnEnds(points, x1, upperCap, i+1, points.length-1, true );
			int lowerBound = returnEnds(points, x1, lowerCap, i+1 , points.length-1, false);
			
			/**
			 * Now we have the range of indices of the range that does not 
			 * exactly solve the above equation, we need to eliminate the ones that 
			 * lie outside the range
			 */
			System.out.printf("%s, %s, %s\n",i, lowerBound, upperBound);
			
			for(int ind = lowerBound ; ind <= upperBound; ind ++) {
				int x2 = points[ind][0];
				int y2 = points[ind][1];
				
				if(lowerCap <= x2 && x2 <= upperCap) {
					/**
					 * the pair at this index will satisfy the first constraint
					 * 
					 * Let's find the value of the equation
					 * y1 + y2 + | x2 - x1 | 
					 */
//					(x_j + y_j) + (y_i - x_i)
//					y1 + y2 + Math.abs(x2 - x1)
					int valEqn = x2 + y2 + y1 - x1;
					if(valEqn > maxVal) {
						maxVal = valEqn;
					}
				}
			}
		}
		
		return maxVal;
	}
	
	static int returnEnds(int [][] points, int val, int target, int start, int end, boolean floor) {
		int s = start;
		int e = end;
		/**
		 * Floor is the point that is lesser than or equal to the given value
		 * Ceiling is the point that is greater or equal to the given value
		 */
		
		while(s <= e) {
			
			int mid = s + (e - s)/2;
			
			if(points[mid][0] == target ) {
				return mid;
			}
			else if (points[mid][0] > target) {
				e = mid -1;
			}
			else {
				// the x value is lesser than the target
				s = mid + 1;
			}
		}
		
		if(floor) {
			
				return e;
			
		}
		else {
			
				return s;
			
		}

		
		
	}

}
