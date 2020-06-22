public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.age = age;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException
                    ("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age<0||age>15){
            throw new IllegalArgumentException
                    ("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double productPerDay(){
        return calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double eggsPerDay;
        if(this.age<6){
            eggsPerDay = 2;
        }else if(this.age<12){
            eggsPerDay = 1;
        }else{
            eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s" + "(age %d) can produce %.2f eggs per day.",this.getName()
        ,this.getAge(),productPerDay());
    }
}
