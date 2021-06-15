import java.util.Scanner;

public class ArbRomCalc {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws Exception {
        System.out.print(ANSI_GREEN + "   Калькулятор версии 100500.\n".toUpperCase() +
                "Функции: выполняет операции с римскими и арабскими числами.\n" +
                "Доступные операции: Сложение '+', Вычетание '-', Умножение '*', Деление '/'.\n" +
                "Арабские числа от 1 до 10 включительно.\n" +
                "Римские числа от I до X включительно.\n" +
                "Для выхода из программы нажмите 'ENTER'.\n" +
                "Пример: '1 + 4', 'I * V'. \n\n"+ANSI_RESET);

        Scanner in = new Scanner(System.in);
        Operation operation = new Operation();
        while (true) {
            System.out.println("Введите пример: ");
            String line = in.nextLine().toUpperCase();

            if (line.equals("")) {
                System.out.println("Программа завершена, до скорых встреч!");
                break;
            }


            String[] symbols = line.split(" ");
            operation.sum = 0;
            try {
                String s1 = symbols[0];
                String s2 = symbols[2];
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ANSI_RED + "Ошибка ввода чисел.\n" + ANSI_RESET + "Числа должны быть одного формата.\n" + "Посмотрите пример в описании программы и попробуйте еще раз.");
                break;
            }


            try {
                String s1 = symbols[0];
                String s2 = symbols[2];
                String op = symbols[1];
                operation.s = op.charAt(0);
                operation.num1 = Integer.valueOf(s1);
                operation.num2 = Integer.valueOf(s2);
                String check = operation.checknumb();
                if (check != "") {
                    System.out.println(check);
                    break;
                }
                operation.calculateNum();
                System.out.println(operation.result + ANSI_YELLOW + operation.sum + ANSI_RESET + "\n");

            } catch (NumberFormatException e) {

                try {
                    operation.n1 = Double.valueOf(symbols[0]);
                    operation.n2 = Double.valueOf(symbols[2]);
                    System.out.println(operation.n1);
                    System.out.println(operation.n2);
                    String checkdoub = operation.checkdoub();
                    if (checkdoub != "") {
                        System.out.println(checkdoub);
                        break;
                    }
                } catch (NumberFormatException ee) {

                    String s1 = symbols[0];
                    String s2 = symbols[2];
                    String op = symbols[1];
                    operation.s = op.charAt(0);
                    try {
                        operation.num3 = RomEnum.valueOf(s1);
                        operation.num4 = RomEnum.valueOf(s2);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ANSI_RED + "Ошибка ввода чисел.\n" + ANSI_RESET + "Числа должны быть одного формата.\n" +
                                "Доступны арабские и римские числа от 1-10.\n" + "Посмотрите пример в описании программы и попробуйте еще раз.");
                        break;
                    }

                    operation.num1 = Integer.valueOf(String.valueOf(operation.num3.getNomer()));
                    operation.num2 = Integer.valueOf(String.valueOf(operation.num4.getNomer()));
                    operation.calculateNum();
                    String res = operation.showResultInRom();
                    if (res!=null){
                    System.out.println(operation.result + ANSI_YELLOW + res + ANSI_RESET + "\n");
                    }
                    else{ break;}
                }

            }
        }

    }
}





