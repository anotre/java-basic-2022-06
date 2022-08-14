package net.zaycev.homework.l12;
import java.util.Arrays;
//import java.util.ArrayList;
import java.util.List;

public class Sort {
    public static void bubbleSort(List<Integer> arrList) {
        int isSorted = 0;
        int remain = arrList.size();
        for (int i = 0, j = 1; isSorted == 0;) {
            if (arrList.get(i) > arrList.get(j)) {
                int buffer = arrList.get(i);
                arrList.set(i, arrList.get(j));
                arrList.set(j, buffer);
            }
            if (remain == 2) {
                break;
            }
            if (j == remain - 1) {
                i = 0;
                j = 1;
                remain--;
            } else {
                i++;
                j++;
            }
        }
        System.out.println(arrList);
    }

    public static void main(String[] args) {
        bubbleSort(Arrays.asList(4,3,2,1));

        System.out.println("должно быть 1, 2, 3, 4");
    }
}
