import java.util.HashMap;
import java.util.Map;

public class Car {

    private static final int maxGears = 6;
    private static final Map<Integer, Integer[]> gearToSpeedMapping = new HashMap<>();
    private boolean isTurnedOn = false;
    private int speedInKmph = 0;
    private int gear = 0;


    public Car() {
        gearToSpeedMapping.put(1, new Integer[] {0, 20});
        gearToSpeedMapping.put(2, new Integer[] {21, 40});
        gearToSpeedMapping.put(3, new Integer[] {41, 60});
        gearToSpeedMapping.put(4, new Integer[] {61, 80});
        gearToSpeedMapping.put(5, new Integer[] {81, 100});
        gearToSpeedMapping.put(6, new Integer[] {101, 120});
    }

    public void turnOn() {
        if (isTurnedOn) {
            System.out.println("O carro já está ligado.");
            return;
        }
        isTurnedOn = true;
        System.out.println("O carro foi ligado.");
    }

    public void turnOff() {
        if (!isTurnedOn) {
            System.out.println("O carro já está desligado.");
            return;
        }

        if (gear > 0) {
            System.out.println("O carro deve estar em ponto morto (marcha 0) primeiro.");
            return;
        }

        if (speedInKmph > 0) {
            System.out.println("A velocidade deve estar em 0 primeiro. Velocidade: %dkm/h");
            return;
        }

        isTurnedOn = false;
        System.out.println("O carro foi desligado.");
    }

    public void increaseGear() {             
        
        if (!isTurnedOn) {
            System.out.println("O carro não está ligado.");
            return;
        }

        if (gear == maxGears) {
            System.out.println("O carro já está na marcha máxima.");
            return;
        }

        if (gear == 0) {
            gear++;
            System.out.println("Aumentou para a marcha 1.");
            return;
        }

        Integer[] limits = gearToSpeedMapping.get(gear);        
        if (speedInKmph < limits[1]) {
            String message = String.format(
                "A velocidade deve ser %dkm/h para aumentar a marcha.",
                limits[1]
            );
            System.out.println(message);            
            return;
        }

        gear++;
        String message = String.format(
            "Marcha aumentada: %d. Velocidade: %dkm/h", 
            gear,
            speedInKmph
        );
        System.out.println(message);
    }

    public void increaseSpeed() {

        if (!isTurnedOn) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (gear == 0) {
            System.out.println("O carro está em ponto morto.");
            return;
        }

        Integer[] limits = gearToSpeedMapping.get(gear);
        boolean canIncreaseSpeed = speedInKmph < limits[1];

        if (!canIncreaseSpeed) {
            String message = String.format(
                "Velocidade no limite da marcha: %dkm/h. Aumente a marcha.",
                speedInKmph
            );
            System.out.println(message);
            return;
        }
        
        speedInKmph++;
        String message = String.format(
            "Velocidade aumentada: %dkm/h. Marcha: %d",
            speedInKmph,
            gear
        );
        System.out.println(message);
    }

    public void decreaseGear() {

        if (!isTurnedOn) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (gear == 0) {
            System.out.println("O carro está em ponto morto.");
            return;
        }

        Integer[] limits = gearToSpeedMapping.get(gear);
        if (speedInKmph > limits[0]) {
            String message = String.format(
                "A velocidade deve ser %dkm/h para reduzir a marcha.",
                limits[0]
            );
            System.out.println(message);
            return;
        }

        gear--;
        String message = String.format(
            "Marcha diminuída: %d. Velocidade: %dkm/h", 
            gear,
            speedInKmph
        );
        System.out.println(message);
    }

    public void decreaseSpeed() {

        if (!isTurnedOn) {
            System.out.println("O carro está desligado.");
            return;
        }

        if (gear == 0) {
            System.out.println("O carro está em ponto morto.");
            return;
        }

        Integer[] limits = gearToSpeedMapping.get(gear);
        boolean canDecreaseSpeed = speedInKmph > limits[0];

        if (!canDecreaseSpeed) {
            String message = String.format(
                "Velocidade no limite da marcha: %dkm/h. Diminua a marcha.",
                speedInKmph
            );
            System.out.println(message);
            return;
        }
        
        speedInKmph--;
        String message = String.format(
            "Velocidade reduzida: %dkm/h. Marcha: %d",
            speedInKmph,
            gear
        );
        System.out.println(message);
    }

    public void turnLeft() {
        if (canTurnLeftRight()) {
            System.out.println("O carro virou à esquerda.");
        }
        else {
            String message = "O carro só pode virar à esquerda quando sua velocidade estiver entre 1 e 40km/h";
            System.out.println(message);
        }
    }

    public void turnRight() {
        if (canTurnLeftRight()) {
            System.out.println("O carro virou à direita.");
        }
        else {
            String message = "O carro só pode virar à direita quando sua velocidade estiver entre 1 e 40km/h";
            System.out.println(message);
        }
    }

    private boolean canTurnLeftRight() {
        return speedInKmph >= 1 && speedInKmph <= 40;
    }

    public void checkSpeed() {
        System.out.println(
            String.format(
            "Velocidade: %dkm/h", speedInKmph
            )
        );
    }

    public void checkGear() {
        System.out.println(
            String.format(
            "Marcha: %d", gear
            )
        );
    }
}
