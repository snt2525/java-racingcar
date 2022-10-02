package racingcarGame;

import racingcarGame.client.ResultView;
import racingcarGame.model.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcarGame.client.InputView.scanCarCount;
import static racingcarGame.client.InputView.scanPlayCount;
import static racingcarGame.client.ResultView.showResult;


public class RacingGame {
    public static void main(String[] args) {
        List<Car> cars = readyCars();

        int playCount = scanPlayCount();

        ResultView.showGameResultTitle();

        for (var i = 0; i < playCount; i++) {
            play(cars);
            showResult(cars);
        }
    }

    private static void play(List<Car> cars) {
       cars.forEach(car -> {
            int chosenNumber = car.pickRandomlyNumber();
            car.move(chosenNumber);
        });
    }

    private static List<Car> readyCars() {
        List<Car> cars = new ArrayList<>();

        int carCount = scanCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }

        return cars;
    }
}
