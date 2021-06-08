package algorithm.sort;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  힙 정렬 : 병합정렬, 퀵정렬만큼 빠른 정렬 알고리즘 (O(N*logN))
		 *  힙 트리 구조를 이용하는 정렬 방법(1) 힙구조 > 2) 정렬) 
		 *  # 이진트리 : 컴퓨터 안에서 데이터를 표현할 때 데이터를 각 노드에 다음 뒤에 노드를 두개씩 이어 붙이는 구조. 
		 *            모든 노드의 자식 노드가 2개 이하인 노드 
		 *    완전 이진트리 : 데이터가 루트노드부터 시작해서 자식 노드가 왼쪽 자식 노드, 오른쪽 자식 노드로 차근차근 들어가는 구조의 이진트리(비어 있지 않고 빽빽하게 노드가 있는 트리) 
		 *  # 힙 : 최소값이나 최대값을 빠르게 찾아내기 위해 완전 이진 트리를 기반으로 하는 트리 
		 *        최소힙과 최대힙이 존재하는데 최대힙은 부모노드가 자식노드보다 큰힙임(큰값이 부모노드가 됨) 
		 *  힙 생성 알고리즘 : 힙이 붕괴될 경우, 하나의 노드에서만 수행. 자식 노드가 부모 노드보다 클 경우 자리를 바꾸는 알고리즘(=최대힙 구조를 만듬)          
		 */
		int number =9; 
		int heap[] = {7,6,5,8,3,5,9,1,6};
		
		//힙 구성
		for(int i=1;i<number;i++) {
			int c = i; 
			do {
				int root = (c-1)/2; 
				if(heap[root]<heap[c]) {
					int temp = heap[root]; 
					heap[root] = heap[c]; 
					heap[c] = temp; 
				}
				c=root; 
			}while(c!=0); 
		}
		
		// 크기를 줄여가며 반복적으로 힙을 구성 
		for(int i=number-1; i>=0;i--) {
			int temp = heap[0]; 
			heap[0] = heap[i]; 
			heap[i] = temp; 
			int root =0; 
			int c =1;
			do {
				c = 2*root+1; 
				// 자식 중에 더 큰 값을 찾기
				if(c<i-1 && heap[c] < heap[c+1]) {
					c++;
				}
				//루트보다 자식이 크다면 교환 
				if(c<i && heap[root] < heap[c]) {
					temp = heap[root]; 
					heap[root] = heap[c];
					heap[c] = temp; 
				}
				root=c; 
			}while(c<i);
		}
		
		for(int i=0;i<number;i++) {
			System.out.println("heap["+i+"] : "+heap[i]);
		}
	}

}
