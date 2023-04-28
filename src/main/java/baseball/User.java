package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class User implements Player{

    private final ArrayList<Integer> numbers;

    public User(){
        numbers = new ArrayList<>();
        //start();
    }

    public void start() {
        numbers.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String[] input = Console.readLine().split("");
        //3개가 아니면
        check3(input);
        check0(input);
        checkDouble(input);
        setNumber(input);
    }

    private void check3(String[] aaa){
        if ( aaa.length != 3){
            throw new IllegalArgumentException("3333");
        }
    }

    private void check0(String[] aaa){
        if (Arrays.stream(aaa).anyMatch(Predicate.isEqual("0"))) {
            throw new IllegalArgumentException("ERR_INPUT_MSG");
        }
    }

    private void checkDouble(String[] aaa){
        if (aaa.length != Arrays.stream(aaa).distinct().count()) {
            throw new IllegalArgumentException("ERR_INPUT_MSG");
        }
    }

    //1~9 숫자만 있는지 확인 자바 스트림 사용해서
    private void setNumber(String[] input) {
        for (String s : input) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ERR_INPUT_MSG");
            }
        }
    }

    @Override
    public int getNumber(int index) {
        return numbers.get(index);
    }
}
