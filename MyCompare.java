package ComparableTemplate;

import java.util.Arrays;
import java.util.Comparator;

//自定义类型 去实现Comparable接口的CompareTo方法，就可以进行大小的比较
//自然顺序
class Person implements Comparable<Person>{
    int age;
    String name;
    public Person(int age,String name){
        this.age=age;
        this.name=name;
    }
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null||!(obj instanceof Person)){
            return false;
        }
        Person p=(Person)obj;
        return age==p.age&&name.equals(p.name);
    }
    /*
    \compare:
    返回值<0:表示当前对象小于被比较对象
    返回值=0：表示两个对象相等
    返回值<:表示当前对象大于被比较对象
     */
    @Override
    public int compareTo(Person o){
        return age-o.age;
    }
    @Override
    public String toString(){
        return name+"--->"+age;
    }
}

//2.可以实现以一个自定义类型的比较器，
// 比较器去实现Comparator的compare方法，自定义也可以进行大小比较
//非自然顺序：也可以成为自定义顺序
class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1,Person o2){
        return o1.age-o2.age;
    }
}
class PersonNameComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1,Person o2){
        //按字典序
        return o1.name.compareTo(o2.name);
    }
}

public class MyCompare {
    public static void swap(Person[] arr,int left,int right){
        Person tem=arr[left];
        arr[left]=arr[right];
        arr[right]=tem;
    }
    public static void bubbleSort(Person[] arr){
        int len=arr.length;
        while(len>0){
            boolean flag=true;
            for(int i=0;i<arr.length;++i){
                if(arr[i-1].compareTo(arr[i])>0){
                    swap(arr,i-1,i);
                    flag=false;
                }
            }
            if(flag){
                break;
            }
            --len;
        }
    }

    public static void bubbleSort(Person[] arr, Comparator<Person> comparator){
        int end = arr.length;
        while(end > 0){
            boolean flag = true;
            for(int i = 1; i < end; ++i){
                if(comparator.compare(arr[i - 1],arr[i]) > 0){
                    swap(arr, i - 1, i);
                    flag = false;
                }
            }
            if(flag)
                break;
            --end;
        }
    }

    public static void test1(){
        Person[] arr={new Person(12,"汤姆"),new Person(9,"杰克"),new Person(1,"玛丽")};
        Person[] copy=arr.clone();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,new PersonAgeComparator());
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,new PersonNameComparator());
        System.out.println(Arrays.toString(arr));
        bubbleSort(copy);
        System.out.println("bubbleSort Age: " + Arrays.toString(copy));
        bubbleSort(copy, new PersonNameComparator());
        System.out.println("bubbleSort name: " + Arrays.toString(copy));


    }

    public static void main(String[] args) {
        test1();
    }
}
