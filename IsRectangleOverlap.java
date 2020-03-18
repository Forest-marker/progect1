package gittub;
//力扣 ：836. 矩形重叠
//矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
//如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
//给出两个矩形，判断它们是否重叠并返回结果。
public class IsRectangleOverlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //左下角的横坐标大于原图像右上角的横坐标；右上角的横坐标小于原左下角的横坐标；右上角的纵坐标小于原左下角的纵坐标；左下角的纵坐标大于原右上角的纵坐标
        System.out.println(rec2[3]+" "+rec1[1]);
        if(rec2[0]>=rec1[2]){
            return false;
        }else if(rec2[1]>=rec1[3]){
            return false;
        }else if(rec2[2]<=rec1[0]){
            return false;
        }else if(rec2[3]<=rec1[1]){
            return false;
        }else{
            return true;
        }
        /*return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top*/

    }

    public static void main(String[] args) {
        int[] a=new int[]{5,15,8,18};
        int[] b=new int[]{0,3,7,9};
        System.out.println(isRectangleOverlap(a,b));
    }
}
