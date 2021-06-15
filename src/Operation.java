public class Operation {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    char s;
    double n1;
    double n2;
    int num1;
    int num2;
    int sum;
    String result = ANSI_BLUE + "Ваш результат: \n";
    RomEnum num3;
    RomEnum num4;

    String restart ="Перезапустите программу и попробуйте еще раз!";

    private static int[] arabNumbers = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static String[] romLetters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String showResultInRom() {
        String rom = null;
        if (sum<0){
            rom="-";
            sum=-sum;
            System.out.println("Результат будет выведен, но римские цифры не могут быть отрицательными.");
        }
        else if (sum == 0){
            rom = "0";
        }
        else {
            rom="";
        }
           for (int i = 0; i < arabNumbers.length; i++) {
            while (sum >= arabNumbers[i]) {
                rom = rom + romLetters[i];
                sum = sum - arabNumbers[i];
    }
           }return rom;
    }

    public String checknumb (){
        String ex="";
        if (num1>10&&num2>10){
            ex=ANSI_RED+"Первое и второе число не могут быть больше 10.\n"+ANSI_RESET +restart;
        }
        else if (num1>10 && num2<=10){
            ex=ANSI_RED+"Первое число не может быть больше 10.\n"+ANSI_RESET+restart;
        }
        else if(num1<=10 &&num2>10){
            ex=ANSI_RED+"Второе число не может быть больше 10.\n"+ANSI_RESET+ restart;
         }
        return ex;
    }

    public String checkdoub(){
        String exd="";
        if (n1%1 !=0 || n2%1 !=0){
            exd=ANSI_RED+"Используйте целые числа.\n"+ANSI_RESET+ restart;
    }return exd;
    }


        void calculateNum () {
            switch (s) {
                case '+':
                    sum = num1 + num2;
                    break;
                case '-':
                    sum = num1 - num2;
                    break;
                case '*':
                    sum = num1 * num2;
                    break;
                case '/':
                    sum = num1 / num2;
                    break;
                default:
                    System.out.println("Ошибка ввода символа операции.");
                    break;
            }
        }
}








