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
		//把小的数据放进数组
		if(a[i]<a[j]) {
			temp[index++]=a[j];
		}
		else temp[index++]=a[j];
	}
	//j>high跳出循环，也说明前半段有可能没有遍历完，插入临时数组temp中
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
