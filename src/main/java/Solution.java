import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Solution {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers = Arrays.asList(1,5,8,1,2);
        Integer k = 13;

        Integer firstElement;

        Integer som;
        int indiceA=0;
        int indiceB=0;
        outerLoop:
        for(int i=0; i<numbers.size();i++){
            firstElement=numbers.get(i);

            for(int j=i+1; j<numbers.size();j++){
                som = firstElement + numbers.get(j);
                if(k.equals(som)){
                    indiceA =i;
                    indiceB =j;
                    break outerLoop;
                }
            }


        }

        System.out.println("*** : "+indiceA+" "+indiceB);











    }
}
