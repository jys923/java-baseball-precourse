package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    private User user;
    private Computer computer;
    private int ballCnt;
    private int strikeCnt;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.ballCnt = 0;
        this.strikeCnt = 0;
    }

    public void run(){
        System.out.println("게임을 시작합니다.");

        while (true) {
            this.ballCnt = 0;
            this.strikeCnt = 0;
            user.start();

            for (int i = 0; i < 3; i++) {
                if (computer.getNumber(i) == user.getNumber(i)) {
                    strikeCnt++;
                }

                if (computer.getIndex(user.getNumber(i)) != -1) {
                    ballCnt++;
                }
            }

            if (strikeCnt == 3) {
                System.out.println("3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

            if (strikeCnt == 0 && ballCnt == 0) {
                System.out.println("낫팅");
            } else {
                System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
            }
        }
    }
}
