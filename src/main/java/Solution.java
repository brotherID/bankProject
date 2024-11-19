import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers = Arrays.asList(1,5,8,1,2);
        Integer k = 13;

       // numbers.stream().filter(i -> i)

        int sum = numbers.stream()
                .reduce(0, Integer::sum); // Faire la somme

        System.out.printf("Somme des deux premiers éléments : %d", sum);




    }
}
