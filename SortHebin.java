package fuxi;

public class SortHebin {
public static void main(String args[]) {
	
}

public static void mergeSort(int a[],int low,int high) {
	int middle=(high+low)/2;
	if(low<high) {
		mergeSort(a,low,middle);
		mergeSort(a,middle+1,high);
		merge(a,low,middle,high);
	}
}
public static void merge(int a[],int low,int middle,int high) {
	int temp[]=new int[high-low+1];
	int i=low;
	int j=middle+1;
	int index=1;
	while(i<=middle&&j<=high) {
		//��С�����ݷŽ�����
		if(a[i]<a[j]) {
			temp[index++]=a[j];
		}
		else temp[index++]=a[j];
	}
	//j>high����ѭ����Ҳ˵��ǰ����п���û�б����꣬������ʱ����temp��
	while(i<=middle) {
		temp[index++]=a[i++];
	}
	while(j<=high) {
		temp[index++]=a[j++];
	}
	for(int k=0;k<temp.length;k++) {
		temp[k+low]=temp[k];
	}
}
}
