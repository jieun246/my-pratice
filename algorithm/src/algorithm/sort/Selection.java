package algorithm.sort;

public class Selection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 선택 알고리즘 : 가장 작은 값을 앞으로 보내는 알고리즘 
		 * 모든 값들을 순차적으로 검색하기 때문에 O(N^2) 시간 복잡도를 수행 
		 * 아래 예시로 설명하면 10 + 9 + 8 + ... + 1 까지 반복 == 등차수열
		 * N*(N*1)/2 만큼 수행 >> N*N 성립 
		 */
		int arr[] = {1, 10, 4, 3, 2, 6, 5, 7, 8, 9}; 
		int i, j, min, index, temp; 
		for(i=0;i<10;i++) {
			min = 999;
			index = 0; // 초기값  
			for(j=i;j<10;j++) {
				if(min > arr[j]) { //가장 작은 값이 발견할 경우 
					min = arr[j];
					index = j; 
				}
			}
			
			//스왑핑 
			temp = arr[i]; 
			arr[index] = temp; 
			arr[i] = min; 
		}
		
		// 출력
		for(i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] : "+ arr[i]);
		}
	}

}
