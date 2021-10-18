
public class RotationCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

//		int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}; // expect: 14
//		 int[] arr = {6,6,7,8,1,1,2,2,3,4,5,6}; // expect: 4 
//		 int[] arr = {2,5,6,0,0,1,2}; // expect: 3
//		 int[] arr = {1,0,1,1,1}; // expect: 1
//		 int[] arr = {2,9,2,2,2}; // expect: 2
//		 int[] arr = {5,6,7,8}; // expect 0
//		 int[] arr = {1,1,1,1,1,2,1}; // expect: 6
//		int[] arr = {6,6,7,8,1,1,2,2,3,4,5,6}; // expect : 4
//		int[] arr = {2,5,6,0,0,1,2}; // expect: 3
		 int[] arr = {1,1}; // expect 0
		 
		 System.out.println(rotationCount(arr));

	}
	
	static int rotationCount(int[] a) {

		int pivot = findPivot(a);
		
		// rotation count is the value of pivot index + 1

		return pivot + 1;
	}

	static int findPivot(int[] a) {
		
		int s = 0, e = a.length-1;
		
		while(s<=e) {
			
			int m = s + (e-s)/2;
			
			// checking if the mid element is the pivot
			if( m < e && a[m] > a[m+1]) {
				return m;
			}
			else if (m > s && a[m-1] > a[m]) {
				return m-1;
			}
			
			// next check if the start mid and end are duplicates
			else if(a[s] == a[m] && a[m] == a[e]) {
				
				//we skip the duplicates - but we check if they are the pivot element before skipping
				
				// we don't check for s-1 and s , 
				// whenever we do s = m + 1, 
				// that would happen only if m is not the pivot (checked in the above condition )
				// so no need to check for the previous element
				if(a[s] > a[s+1]) {
					return s;
				}else {
					s++;
				}
				
				// we no not check for e + 1
				// because if we are coming to this step, it is either because we have ignored e + 1 before
				// or if we have checked both m and m-1 to not be pivots
				if(a[e] < a[e-1]) {
					return e-1;
				}
				else {
					e--;
				}
			}
			// all 3 are not equal, we have a rotated array here, with 2 sub arrays sorted in ascending order
			// mid is not the pivot( it did not get detected in the first check )
			// so the pivot has to lie on either the left or right of mid
			
			// checking for right 
			// start == mid or start < mid and end < mid
			else if(a[s] == a[m] || a[s] < a[m] && a[e] < a[m]){
				// check on the right side
				
				// here m is not the pivot, so m + 1 will be anyways greater or == m
				s = m + 1;
			}
			else {
				// pivot could be on the left
				// mid and mid -1 are not pivots
				e = m;
				
				
			}
		}
		return -1;
	}

}
