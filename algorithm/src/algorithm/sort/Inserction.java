package algorithm.sort;

public class Inserction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  삽입정렬 : 각 숫자를 적절한 위치에 삽입하는 알고리즘.
		 *          정렬되어 있다면, 삽입 버블보다 속도가 빠름(연산횟수가 적음)
		 *          O(N^2)만큼 수행하나 정렬이 되어 있는 가정하에 진행하면 연산 수행이 적어 속도가 빠름 예) 2 3 4 5 6 7 8 9 10 1 
		 *           
		 *  정렬수행 : 1 10 2 9 8 7 4 3 5 6 
		 *          _ 1 _ 10 2 9 8 7 4 3 5 6 > 10이 들어갈 수 있는 곳은 2개인데(_), 1보다 크기 때문에 그 뒤로 삽입 
		 *          _ 1 _ 10 _ 2 9 8 7 4 3 5 6 > 2가 들어갈 수 있는 곳은 3개인데, 10보다 작기 때문에 1 과 10 사이로 삽입
		 *          이런식으로 앞 부분에 이미 정렬이 되어 있기 때문에 적절한 위치로 삽입           
		 */
		int a[] = {1, 10, 2, 9, 8, 7, 4, 3, 5, 6};
		int i, j, temp; 
		for(i=0;i<9;i++) {
			j=i;
			while(j >=0 && a[j] > a[j+1]) {
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp; 
				j--;
			}
		}
		
		for(i=0;i<10;i++) {
			System.out.println("a["+i+"] : "+ a[i]);
		}
	}

}
