package javaError;

public class 创建二维数组的写法 {
    float f[][] = new float[6][6];
    float []a[] = new float[6][6];
   // float b[][] = new float[][6];错误
    float [][]c = new float[6][6];
    float [][]d = new float[6][];
    /*
    答案：ABDE。
    解析：声明时f、[]、[]可以任意组合。new中必须写行数，列数随意。
     */
}
