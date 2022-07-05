public class Cat {

    // Константы
    private static final int NUMBER_EYES = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    private double originWeight;
    private double weight;
    private boolean isAlive = true;


    private double minWeight;
    private double maxWeight;
    private Color color;
    private String name;


    //Добавляем кол-во сьеденной еды
    private double eatenFood = 0;

    //Создаем статический метод count
    private static int count = 0;


    public Cat() {
        if (isAlive()) {
            count++;
            weight = 1500.0 + 3000.0 * Math.random();
            originWeight = weight;
            minWeight = 1000.0;
            maxWeight = 9000.0;
        }
    }


    //Для создания копии обьекта Cat
    public Cat makeTwin() {
        Cat catTwin = new Cat( this.weight );
        catTwin.originWeight = this.originWeight;
        catTwin.minWeight = this.minWeight;
        catTwin.maxWeight = this.maxWeight;
        catTwin.name = this.name;
        return catTwin;
    }

    public static Cat makeTwin(Cat ownerCat) {
        return ownerCat.makeTwin();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    //Создаем Сеттеры и Геттеры для окраса кошек
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    //Создаем конструктор для создания новой кошки и присвоения ей веса
    public Cat(double weight) {
        System.out.println( "Создана кошка весом " + weight );
        this.weight = weight;
    }


    //параметры для котенка
    static Cat getKitten(double weight) {
        if (weight < 100) {
        }
        return new Cat();
    }


    //Создаем метод сходить в туател
    public void goTouliet() {
        weight = weight - 200.0;
        System.out.println( "Now, I`m fine" );
    }


    //Метод мяукать
    public void meow() {
        weight = weight - 1;
        System.out.println( "Meow" );
        if (weight < MIN_WEIGHT) {
            count--;
            isAlive = false;
        } else {
            isAlive = true;
        }
    }


    // Добавляем в метод feed данные для вызово команды о кол-во сьеденной еды
    public void feed(Double amount) {
        if (isAlive()) {
            eatenFood += amount;
            weight = weight + amount;
            if (weight > MAX_WEIGHT) {
                count--;
                isAlive = false;
            }
        } else {
            System.out.println( "Cat is Dead" );
        }
    }


    //Метод пить
    public void drink(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            if (weight > MAX_WEIGHT) {
                count--;
                isAlive = false;
            }
        } else {
            System.out.println( "Cat is Dead" );
        }
    }


    //Получение и установление веса
    public Double getWeight() {
        return weight;
    }

    public void setWeight() {
        this.weight = weight;
    }


    //Создаем метод получить сьеденную пищу
    public Double getEatenFood() {
        return eatenFood;
    }


    //Создаем статический метод getСount
    public static int getCount() {
        return count;
    }


    //Присваиваем статус котам
    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }


    //Создаем переменную "жив не жив"
    public boolean isAlive() {
        return getWeight() >= minWeight && getWeight() <= maxWeight;
    }
}
















































