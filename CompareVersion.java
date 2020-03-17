package ComparableTemplate;

//165. 比较版本号
//比较两个版本号 version1 和 version2。
//如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//来源：力扣（LeetCode）

public class CompareVersion {
    //把字符串转换为以点分割的字符串数组，在进行一位一位的比较
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            String num1 = i < v1.length ? v1[i] : "0";
            String num2 = j < v2.length ? v2[j] : "0";
            if (compare(num1, num2) == 0) {
                i++;
                j++;
            } else {
                return compare(num1, num2);
            }
        }
        return 0;
    }

    private int compare(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (n1 > n2) {
            return 1;
        } else if (n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }
}


