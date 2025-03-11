public class PetMachine {
    
    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o banho.");
            return;
        }

        if (water < 10) {
            System.out.println(String.format("Água insuficiente: %d litro(s).", water));
            return;
        }

        if (shampoo < 2) {
            System.out.println(String.format("Shampoo insuficiente: %d litro(s).", shampoo));
            return;
        }

        water -= 10;
        shampoo -= 2;
        pet.setClean(true);
        System.out.println(String.format("O pet %s está limpo.", pet.getName()));
    }

    public void addWater() {
        if (water == 30) {
            System.out.println("A capacidade de água da máquina está no máximo.");
            return;
        }

        water += 2;
    }

    public void addShampoo() {
        if (shampoo == 10) {
            System.out.println("A capacidade de shampoo da máquina está no máximo.");
            return;
        }

        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {

        if (!clean) {
            System.out.println("A máquina está suja. Para colocar o pet, é necessário limpá-la.");
            return;
        }

        if (hasPet()) {
            System.out.println(
                String.format("O pet %s está na máquina neste momento.", this.pet.getName())
            );
            return;
        }

        this.pet = pet;        
        System.out.println(String.format("O pet %s foi colocado na máquina.", pet.getName()));
    }

    public void removePet() {       
        if (pet == null)  {
            System.out.println("Não há pet na máquina no momento.");
            return;
        }
        clean = pet.isClean();
        System.out.println(String.format("O pet %s foi tirado da máquina.", pet.getName()));
        pet = null;
    }

    public void wash() {

        if (water < 10) {
            System.out.println(String.format("Água insuficiente: %d litro(s).", water));
            return;
        }

        if (shampoo < 2) {
            System.out.println(String.format("Shampoo insuficiente: %d litro(s).", shampoo));
            return;
        }

        water -= 10;
        shampoo -= 2;
        clean = true;
        System.out.println("A máquina foi limpa.");
    }
}
