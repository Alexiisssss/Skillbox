public class Loader {

    //Создаем метод для генерации новой кошки
    private static Cat getKitten(double weight) {
        return new Cat( 1100 );
    }

    public static void main(String[] args) {


        //Создаем новую кошку-котенка
        Cat getKitten = new Cat( 3500.0 );
        System.out.println( "Вес созданной кошки вернулся на 1100" );
        getKitten( 1100 );


        //Создаем еще 3 обьекта по методу getKitten
        Cat roma = Cat.getKitten( 4000 );
        getKitten( 1100 );
        Cat vasilisa = Cat.getKitten( 2000 );
        getKitten( 1100 );
        Cat yasha = Cat.getKitten( 2121 );
        getKitten( 1100 );


        //Создать копию обьекта Cat
        Cat viskas = new Cat();
        viskas.setName( "Вискас" );
        System.out.println( viskas.getWeight() );
        System.out.println( viskas.getName() );
        System.out.println( viskas.getStatus() );
        Cat viskas2 = Cat.makeTwin( viskas );
        System.out.println( viskas2.getName() );
        System.out.println( viskas2.getWeight() );
        System.out.println( viskas2.getStatus() );


        //Котов еще не создали, проверяем количество котов
        System.out.println( "Cats count: " + Cat.getCount() );
        System.out.println( "Creating Cats.." );


        //Создали 5 котов(которые буду задействованы в методе, остальные 3 - для проверки static count), проверяем их количество
        Cat murka = new Cat();
        Cat vasya = new Cat();
        vasya.makeTwin( murka );
        Cat stepa = new Cat();
        Cat innokentii = new Cat();
        Cat chernish = new Cat();
        Cat rizik = new Cat();
        Cat murzik = new Cat();
        Cat egor = new Cat();


        //Проверяем количество котов
        System.out.println( "Cats created: " + Cat.getCount() );


        //Выводим в консоль: вес созданных котов, окрас и статус "жив не жив"
        System.out.println( "Murka weight" + " " + murka.getWeight() );
        murka.setColor( Color.BLACK );
        System.out.println( "murka :" + murka.getColor() );
        System.out.println( murka.isAlive() );
        System.out.println( "Vaysa weight" + " " + vasya.getWeight() );
        vasya.setColor( Color.WHITE );
        System.out.println( "vasya :" + vasya.getColor() );
        System.out.println( vasya.isAlive() );
        System.out.println( "Stepa weight" + " " + stepa.getWeight() );
        stepa.setColor( Color.GRAY );
        System.out.println( "stepa :" + stepa.getColor() );
        System.out.println( stepa.isAlive() );
        System.out.println( "Innokentii weight" + " " + innokentii.getWeight() );
        innokentii.setColor( Color.BROWN );
        System.out.println( "innokentii :" + innokentii.getColor() );
        System.out.println( innokentii.isAlive() );


        //Выводим разные методы с котами
        System.out.println( "Cats ate" );
        System.out.println( "feeding cats..." );
        murka.feed( 1000.0 );
        System.out.println( "Murka weight:" + " " + murka.getWeight() );
        System.out.println( "Murka status:" + " " + murka.getStatus() );
        System.out.println( murka.isAlive() );
        vasya.feed( 434.0 );
        System.out.println( "Vasya weight:" + " " + vasya.getWeight() );
        System.out.println( "Vasya status:" + " " + vasya.getStatus() );
        System.out.println( vasya.isAlive() );
        System.out.println( "vasya goTouliet " );
        //Ваську отправили в туалет.
        System.out.println( "Vasya weight:" + " " + vasya.getWeight() );
        vasya.goTouliet();
        System.out.println( "Vasya weight:" + " " + vasya.getWeight() );
        System.out.println( "Vasya status:" + " " + vasya.getStatus() );
        stepa.drink( 3500.0 );
        System.out.println( "Stepa weight:" + " " + stepa.getWeight() );
        System.out.println( "Stepa status:" + " " + stepa.getStatus() );
        System.out.println( stepa.isAlive() );


        //Создаем цикл - перекормить кошку
        System.out.println( "innokentii eating feed: " );
        System.out.println( "innokentii weight:" + " " + innokentii.getWeight() );
        while (!innokentii.getStatus().equals( "Exploded" )) {
            innokentii.feed( 90.1 );
        }
        System.out.println( "eating.... " );
        System.out.println( "innokentii weight:" + " " + innokentii.getWeight() );
        System.out.println( "Innokentii status:" + " " + innokentii.getStatus() );
        System.out.println( innokentii.isAlive() );


        //Вызываем метод, при котором будет возвращаться вес сьеденной еды
        System.out.println( "Chernish weight:" + " " + chernish.getWeight() );
        chernish.feed( 65.8 );
        System.out.println( "chernish.eatenFood =  " + chernish.getEatenFood() );
        System.out.println( "Chernish weight:" + " " + chernish.getWeight() );
        System.out.println( "Chernish status:" + " " + chernish.getStatus() );
        System.out.println( chernish.isAlive() );

        //Метод при котором мурка мяукает и вес уменьшается
        System.out.println( "Murka meowed:" + " " + murka.getWeight() );
        murka.meow();
        murka.meow();
        System.out.println( "Murka meowed:" + " " + murka.getWeight() );

        //Метод - Замяукиваем кота до смерти.
        while (!murka.getStatus().equals( "Dead" )) {
            murka.meow();
        }
        System.out.println( "Murka meowed to death." );
        System.out.println( "Murka status:" + " " + murka.getStatus() );
        System.out.println( murka.isAlive() );

        //Т.к. у нас коты могут умереть или взорваться, проверим количество котов.
        System.out.println( "Cats count: " + Cat.getCount() );
    }
}








