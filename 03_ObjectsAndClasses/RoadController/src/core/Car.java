package core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;


    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }


    //Геттеры и Сеттеры для переменной number
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }


    //Геттеры и Сеттеры для переменной height
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return height;
    }


    //Геттеры и Сеттеры для переменной weight
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }


    //Геттеры и Сеттеры для переменной hasVehicle
    public void setHasVehicle(boolean hasVehicle){
            this.hasVehicle = hasVehicle;
        }

    //Геттеры и Сеттеры для переменной isSpecial
    public void setSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }
}


