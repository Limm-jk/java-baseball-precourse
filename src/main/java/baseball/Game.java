package baseball;

import java.util.List;

class Game {
    private Answer answer;

    public Game() {

    }

    public void start() {
        this.answer = new Answer();
    }

    public Result tryBaseball(List<Integer> playerNumbers) {
        Result result = new Result();

        for (int i = 0; i < playerNumbers.size(); i++) {
            if (answer.isStrike(i, playerNumbers.get(i))) {
                result.addStrike();

                continue;
            }

            if (answer.isBall(playerNumbers.get(i))) {
                result.addBall();
            }
        }


        return result;
    }
}
