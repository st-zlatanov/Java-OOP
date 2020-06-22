package Pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(backingTechnique);
        this.setWeight(weight);
    }


    public void setFlourType(String flourType) {
        Validator.validateFlourType(flourType);
        this.flourType = flourType;
    }

    public void setBakingTechnique(String backingTechnique) {
        Validator.validateBackingTechnique(backingTechnique);
        this.bakingTechnique = backingTechnique;
    }

    private void setWeight(double weight) {
        Validator.validateDoughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories(){
        double calories=this.weight*2;
        if(this.flourType.equals("White")){
            calories *=1.5;
        }
        if(this.bakingTechnique.equals("Crispy")){
            calories*=0.9;
        }else if(this.bakingTechnique.equals("Chewy")){
            calories*=1.1;
        }

        return calories;
    }
}
