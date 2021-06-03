package algorithm.sort;

public class Merge {

	/* 병합정렬 : 분할정복방법을 채택한 알고리즘으로써 퀵정렬과 마찬가지로 O(N*logN)만큼의 시간복잡도를 가지는 알고리즘
	 *         피봇값없이 정확히 반으로 나누고 나중에 정렬하는 알고리즘 
	 *         기존의 데이터를 담을 추가적인 배열 공간이 필요(메모리 활용 비효율적) 
	 * 정렬방법 : 시작  7 6 5 8 3 5 9 1 : 크기가 모두 1인 상태에서 시작  
	 *         1   67  58  35  91 : 두개씩 묶어서 크기 비교
	 *         2    5678    1359  : 4개씩 묶어서 크기 비교 
	 *         3      13556789    : 합치는 순간에 정렬 수행  
	 *         3단계까지 진행(log8=3), 이미 정렬된 상태이기 때문에 N만큼만 정렬 수행
	 */
	static int sorted[] = new int[8]; // 정렬 배열은 항상 전역변수로 선언** 
	
	static void merge(int a[], int m, int middle, int n) {
		// middle : i와 j의 중간 
		int i = m; 
		int j = middle+1; 
		int k = m; 
		
		// 작은 순서대로 배열에 삽입 
		while(i <= middle && j <=n) {
			if(a[i] <= a[j]) {
				sorted[k] = a[i]; 
				i++;
			}else {
				sorted[k] = a[j]; 
				j++; 
			}
			k++; 
		}
		
		// 남은 데이터 삽입
		if(i > middle) {
			for(int t=j;t<=n;t++) {
				sorted[k]=a[t]; 
				k++; 
			}
		}else {
			for(int t=i; t<=middle;t++) {
				sorted[k]=a[t]; 
				k++; 
			}
		}
		
		// 마지막 단계, 정렬된 배열을 실제 배열에 삽입 
		for(int t=m;t<=n;t++) {
			a[t]= sorted[t]; 
		}
	}
	
	static void mergeSort(int a[], int m, int n) {
		if(m<n) {
			int middle = (m+n)/2;
			// 재귀함수 처리 
			mergeSort(a, m, middle); 
			mergeSort(a, middle+1, n); 
			merge(a, m, middle, n); 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {7,6,5,8,3,5,9,1}; 
		mergeSort(a,0,7); 
		for(int i=0;i<8;i++) {
			System.out.println("a["+i+"] : "+a[i]);
		}
	}

}
