package entities;

public class PetMachine {
    private Boolean clean;
    private Integer water;
    private Integer shampoo;
    private Pet pet;

    public void takeAShower() {
        if(this.pet == null) {
            System.out.println("Coloque o Pet na maquina para iniciar o banho");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        
        pet.setClean(true);
        System.out.println("O pet: " + pet.getName() + " está limpo");
    }

    public void addWater() {
        if(this.water == 30) {
            System.out.println("A capacidade de água está no máximo!");
            return;
        }

        this.water += 2;
    }

    public void addShampoo() {
        if(this.shampoo == 30) {
            System.out.println("A capacidade de shampoo está no máximo!");
            return;
        }

        this.shampoo += 2;
    }

    public Integer getWater() {
        return water;
    }

    public Integer getShampoo() {
        return shampoo;
    }

    public boolean hasPet() {
        return this.pet != null;
    }

    public void setPet(Pet pet) {

        if(!this.clean) {
            System.out.println("Á maquina está suja, para colocar o pet é necessário limpa-la ");
        }

        if(hasPet()) {
            System.out.println("O pet: " + this.pet.getName() + " está na maquina nesse momento");
        }

        this.pet = pet;
    }


    public void removePet() {
        this.clean = this.pet.isClean();
        this.pet = null;

        System.out.println("O pet " + this.pet.getName() + " está limpo ");
    }
}
