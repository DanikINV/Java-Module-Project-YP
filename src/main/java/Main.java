import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        System.out.println("Добро пожаловать на гонку '24 часа Ле-Мана'!");

        for (int i = 1; i <= 3; i++) {
            System.out.println("\n Автомобиль №" + i + ".");

            String name;
            while (true) {
                System.out.print("Введите название машины №" + i + ": ");
                name = scanner.nextLine().trim();

                if (!name.isEmpty()) {
                    break;
                }
                System.out.println("Название машины не может быть пустым. Попробуйте снова.");
            }
            int speed;
            while (true) {
                System.out.print("Введите скорость машины №" + i + " (0-250 км/ч): ");
                try {
                    speed = Integer.parseInt(scanner.nextLine());

                    if (speed > 0 && speed <= 250) {
                        break;
                    } else {
                        System.out.println("Неправильная скорость! Скорость должна быть от 1 до 250 км/ч.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Введите целое число для скорости.");
                }
            }

            Car car = new Car(name, speed);
            race.updateLeader(car);
        }

        System.out.println("\nРЕЗУЛЬТАТЫ ГОНКИ");
        System.out.println("Самая быстрая машина: " + race.name);
        scanner.close();
    }
     static class Car {
        private String name;
        private int speed;
        public Car(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }
        public String getName() {
            return name;
        }
        public int getSpeed() {
            return speed;
        }
        public int calculateDistance() {
            return 24 * speed;
        }
    }
    static class Race {
        private String name;
        private int distance;
        public Race() {
            this.name = "";
            this.distance = 0;
        }
        public void updateLeader(Car car) {
            int carDistance = car.calculateDistance();
            if (carDistance > distance) {
                name = car.getName();
                distance = carDistance;
            }
        }
    }
}