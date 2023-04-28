package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.bytebuddy.NamingStrategy;

import java.util.ArrayList;

public class Computer implements Player{

    private ArrayList<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();

        for (int i= 0 ;i<3;i++){
            int number = Randoms.pickNumberInRange(1, 9);
            if(numbers.contains(number)){
                i--;
            } else {
                numbers.add(number);
            }
        }
        for (Integer number : numbers) {
            System.out.print(number);
        }
        System.out.println();
    }

    @Override
    public int getNumber(int index) {
        return numbers.get(index);
    }

    public int getIndex(int number){
        return numbers.indexOf(number);
    }
}
