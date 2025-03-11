import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Car car = new Car();

    public static void main(String[] args) throws Exception {
        
        do {
            System.out.println("=== Escolha uma das opções ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Verificar a velocidade");
            System.out.println("4 - Acelerar");
            System.out.println("5 - Reduzir a velocidade");
            System.out.println("6 - Verificar a marcha");
            System.out.println("7 - Aumentar a marcha");
            System.out.println("8 - Reduzir a marcha");
            System.out.println("9 - Virar à esquerda");
            System.out.println("10 - Virar à direita");
            System.out.println("0 - Sair");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> car.turnOn();
                case 2 -> car.turnOff();
                case 3 -> car.checkSpeed();
                case 4 -> car.increaseSpeed();
                case 5 -> car.decreaseSpeed();
                case 6 -> car.checkGear();
                case 7 -> car.increaseGear();
                case 8 -> car.decreaseGear();
                case 9 -> car.turnLeft();
                case 10 -> car.turnRight();
                case 0 -> System.exit(0);
            }
        }
        while (true);
    }

}
