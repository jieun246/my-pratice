package algorithm.sort;

public class Quick {
	/*
	 *  퀵정렬 : 분할 정복 알고리즘 O(N*logN) 
	 *  특정한 값(피봇)을 기준으로 큰 숫자와 작은 숫자를 서로 교환한 뒤에 배열을 반으로 나눔 
	 *  피봇 초기값은 첫번째 값으로 먼저 설정 
	 *  정렬 방법 : *3 7 8 1 5 9 6 10 2 4 >> 맨왼쪽에서는 피봇보다 큰 값을(7), 맨 오른쪽에서는 피봇보다 작은값을(2) 스왑 
	 *          *3 2 8 1 5 9 6 10 7 4 >> 큰값(8), 작은값(1) 스왑  
	 *          *3 2 1 8 5 9 6 10 7 4 >> 큰값(8), 작은값(1) 엇갈림 발생 >> 1과 3을 스왑 
	 *           1 2 (3) 8 5 9 6 10 7 4 >> 3은 정렬된 상태로 3을 기준으로 왼쪽은 3보다 작은 값들이, 오른쪽은 3보다 큰값들이 위치 
	 *                                     각각 집합대로 퀵정렬 수행 
	 *          *1 2 (3) *8 5 9 6 10 7 4 >> 왼쪽 집합 : 큰값(2), 작은값(1)이므로  자기자신(1)을 선택하여 정렬완료 
	 *          (1) 2 (3) *8 5 9 6 10 7 4 >> 2은 혼자밖에 없으므로 그 자리 그대로 정렬 완료 
	 *          (1) (2) (3) *8 5 9 6 10 7 4 >> 나머지 오른쪽 집합도 똑같이 첫번째값(8) 피봇을 기준으로 정렬 반복           
	 *  그 전의 선택, 버블, 삽입정렬보다 시간복잡도가 빠르지만 모든 조건에서 빠를 수 없음 
	 *  퀵정렬은 정렬된 상태라면 O(N^2)의 수행을 하기 때문에 퀵정렬의 방법대로 수행할 수 없음(<-> 삽입정렬과 반대) 
	 *  따라서 조건에 따라 적절한 알고리즘을 선택해서 구현해야 함                     
	 */
	static void quickSort(int[] data, int start, int end) {
		if(start>=end) { // 원소가 1개인 경우 
			return; 
		}
		int key = start;  // 초기 피봇은 첫번째 값으로 
		int i=start+1, j=end, temp;
		
		while(i<=j) { //엇갈릴때까지 반복
			while(i<=end && data[i] <= data[key]) { // 피봇보다 큰값을 만날때까지 증가
				i++; 
			}
			while(j>start && data[j] >= data[key]) { // 피봇보다 작은값을 만날때까지 감소 
				j--; 
			}
			
			if(i > j) { //현재 엇갈리 상태면 키 값과 교체
				temp = data[j]; 
				data[j] = data[key]; 
				data[key] = temp; 
			}else {
				temp = data[i]; 
				data[i] = data[j]; 
				data[j] = temp; 
			}
		}
		
		// 정렬이 끝난 후, 재귀호출로 기준점을 기점으로 나뉜 집합대로 퀵정렬 진행 
		quickSort(data, start, j-1); 
		quickSort(data, j+1, end); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9}; 
		quickSort(a, 0, 9); 
		
		for(int i=0;i<10;i++) {
			System.out.println("a["+i+"] : "+ a[i]);
		}
	}

}
