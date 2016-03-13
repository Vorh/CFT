package model;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    private static double first = 0;
    private static double second = 0;
    private static boolean pastNumber;

    public static LinkedList<String> line = new LinkedList<String>();

    // Основной метод
    public  String process(String[] text) {
        parseSolution(text);
        check(0,line.size());
        solution(0,line.size());
        return line.get(0);
    }

    // Отделяем символы и цифры друг от друга
    public  void parseSolution(String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (checkString(list[i])) {
                   if(pastNumber){
                      String s = line.get(line.size()-1);
                      s = s + list[i];
                      line.set(line.size()-1, s);

                   }else {
                       line.add(list[i]);
                       pastNumber = true;
                   }
            } else {
                pastNumber = false;
                line.add(list[i]);
            }
        }
    }

    // Проверяем на наличие скобок и если они есть выполняем действия внутри них
    public  void check(int x , int y) {
        int begin = 0;
        int end = 0;
        while ( x < y) {

            if(line.get(x).equals("(")){
                begin = x;
            }else if(line.get(x).equals(")")){
                end = x;
                line.remove(begin);
                end = end-1;
                line.remove(end);
                end = end - 1;
                solution(begin, end);
                x = 0;
                y = line.size();
                continue;
            }
            x++;
        }
    }

    // Решаем уравнение
    public  void solution(int x, int y) {
        int a = x;


        while (x<y) {
            if (line.get(x).equals("^")) {                // Проверяем на действие
                line.remove(x);                           // Удаляем знак
                x--;                                      // Сдвигаем точку на -1
                y--;                                      // Сдвигаем точку на -1

                first = Double.parseDouble(line.get(x));  // Преобразуем и Записываем первое число
                line.remove(x);                           // Удаляем его
                y--;                                      // Сдвигаем точку на -1
                second = Double.parseDouble(line.get(x)); // Преобразуем и записываем второе число

                for (int i = 1; i <second ; i++) {        // Выполняем нужное действие
                    first = first * first;
                }
                double s = first;                         // Записываем получившееся число
                String q = String.valueOf(s);             // Преобразуем в строку
                line.set(x, q);                           // Записываем в список
            }
            x++;
        }
        x = a;

        while (x<y) {
            if (line.get(x).equals("*")) {
                line.remove(x);
                x--;
                y--;

                first = Double.parseDouble(line.get(x));
                line.remove(x);
                y--;
                second = Double.parseDouble(line.get(x));

                double s = first * second;
                String q = String.valueOf(s);

                line.set(x, q);
            }
            x++;
        }
        x = a;

        while (x < y) {
            if (line.get(x).equals("/")) {
                line.remove(x);
                x--;
                y--;

                first = Double.parseDouble(line.get(x));
                line.remove(x);
                y--;
                second = Double.parseDouble(line.get(x));

                double s = first / second;
                String q = String.valueOf(s);

                line.set(x, q);
            }
            x++;
        }
        x = a;

        while (x <y ) {
            if (line.get(x).equals("+")) {
                line.remove(x);
                x--;
                y--;

                first = Double.parseDouble(line.get(x));
                line.remove(x);
                y--;
                second = Double.parseDouble(line.get(x));

                double s = first + second;
                String q = String.valueOf(s);

                line.set(x, q);
            }
            x++;
        }
        x = a;

        while (x < y) {
            if (line.get(x).equals("-")) {
                line.remove(x);
                x--;
                y--;

                first = Double.parseDouble(line.get(x));
                line.remove(x);
                y--;
                second = Double.parseDouble(line.get(x));

                double s = first - second;
                String q = String.valueOf(s);

                line.set(x, q);
            }
            x++;
        }
    }

    // Проверяем на наличие цифр
    public  boolean checkString(String testString){
        Pattern p = Pattern.compile("^[0-9.]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }


}
