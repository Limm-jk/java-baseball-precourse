package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int START_GAME_VALUE = 1;
    private static final int END_GAME_VALUE = 2;

    private static final String GAME_ENDING_OUTPUT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final Game game = new Game();

    public static void main(String[] args) {
        int gameStatus = START_GAME_VALUE;

        while (gameStatus != END_GAME_VALUE) {
            game.start();
            playGame();
        }
    }

    private static void playGame() {
        List<Integer> playerInput;
        Result result;

        do {
            playerInput = getPlayerInput();

            result = game.tryBaseball(playerInput);
            System.out.println(result.toString());

        } while (!result.isStrikeOut());

        System.out.println(GAME_ENDING_OUTPUT);
    }

    private static List<Integer> getPlayerInput() {
        String input = Console.readLine();
        String[] splitInput = input.split("");

        return Arrays.stream(splitInput).map(Integer::parseInt).collect(Collectors.toList());
    }
}

class Game {
    Answer answer;

    public Game() {

    }

    public void start() {
        this.answer = new Answer();
    }

    public Result tryBaseball(List<Integer> playerNumbers) {
        return new Result(1, 1);
    }
}

class Answer {
    List<Integer> numbers;

    public Answer() {
        initAnswer();
    }

    private void initAnswer() {
        for (int i = 0; i < 3; i++) {
            numbers.add(getUniqueNumber());
        }
    }

    private int getUniqueNumber() {
        int number;

        while(true) {
            number = Randoms.pickNumberInRange(0, 9);

            if (!numbers.contains(number)) return number;
        }
    }
}

class Result {
    int strike;
    int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }
}