// Пусть дан произвольный список целых чисел, удалить из него четные числа
// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф из этого списка.

import java.util.ArrayList;
import java.util.Random;

public class MergeSort{
    public static void main(String[] args) {
        ArrayList<Integer> userList = new ArrayList<>();
        fillArray(userList);
        System.out.println(userList);
        findStatistic(userList);
        mergeSort(userList);
        System.out.println("\n"+userList); 
        delEven(userList);
        System.out.println("\n"+userList);
    }
    public static ArrayList<Integer> fillArray(ArrayList<Integer> list) {
        Random random = new Random();
        for (int index = 0; index < 15; index++) {
            list.add(random.nextInt(20));
        }
        return list;
    }

    public static void findStatistic(ArrayList<Integer> list) {
        int min = list.get(0);
        int max = list.get(0);
        int averageSum = 0;
        int count = 0;
        double average=0;
        for (int i = 0; i < list.size(); i++) {
            min = min > list.get(i) ? list.get(i): min;
            max = max < list.get(i) ? list.get(i): max;
            count = i;
            averageSum += list.get(i);
        }
        average = (double)averageSum / (double)count;
        System.out.printf("min = %d, max = %d, average = %.2f",min,max,average);
    
    }

    public static void mergeSort(ArrayList<Integer> list) {
        if (list.size() > 1) {
            Integer mid = list.size() / 2;
            ArrayList<Integer> left = new ArrayList(list.subList(0, mid));
            ArrayList<Integer> right = new ArrayList(list.subList(mid, list.size()));
    
            mergeSort(left);
            mergeSort(right);
    
            int i = 0, j = 0, k = 0;
            while (i < left.size() && j < right.size()) {
                if (left.get(i) < right.get(j)) {
                    list.set(k++,left.get(i++));
                } else {
                    list.set(k++,right.get(j++));
                }
            }
            while (i < left.size()) {
                list.set(k++,left.get(i++));
            }
            while (j < right.size()) {
                list.set(k++,right.get(j++));
            }
        }
    }

    public static ArrayList<Integer> delEven(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0){
            list.remove(list.get(i));
            i--;
            }
        }
        return list;
    }
        
}
