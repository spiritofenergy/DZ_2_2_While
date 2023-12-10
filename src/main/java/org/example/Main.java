package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static jdk.xml.internal.SecuritySupport.isFileExists;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("1. Выведите числа от 0 до миллиона");
        int million = 0;
        while (million < 1000000) {
            System.out.print("-" + million);
            million++;
        }
        /////////////////////
        System.out.println("2. Выведите числа от 1.5 до 101.5: 1.5,2,2.5,3,3.5...101.5");
        double half = 1.5;
        while (half <= 101.5) {
            System.out.print(" half= " + half);
            half++;
        }
        System.out.print(" \n Дальше я не понял заданя(");


        ///////////////////
        System.out.println("3. Выведите латинский алфавит от a до z");
        char c = 'a';
        while (c <= 'z') {
            System.out.print(c + " ");
            c++;
        }
        System.out.println("\n");

        //////////////////////
        System.out.println("4. Выведите русский алфавит от а до ");
        char c1 = 'а';
        while (c1 <= 'я') {
            c1++;
            System.out.print(c1 + " ");

        }

        ////////////////////////
        System.out.println("5. Создайте 10 тысяч файлов");
        int x = 1;
        while (x <= 10) {
            File file = new File("E:\\Sinergy\\DZ_2_2_While\\src\\main\\java\\org\\example/" + x);
            file.createNewFile();
            x++;
        }

        /////////////////////
        System.out.println("6. В файле две строки: секретное слово и подсказка. Вывести подсказку.");

        File output = new File("E:\\Sinergy\\DZ_2_2_While\\src\\main\\java\\org\\example\\file.txt");
        FileWriter writer = new FileWriter(output);

        writer.write("Я вам подскакажу \n");
        writer.write("Где будет подсказка \n");
        writer.write("Здесь будет основной текст \n");
        writer.flush();
        writer.close();

        File file = new File("E:\\Sinergy\\DZ_2_2_While\\src\\main\\java\\org\\example\\file.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String help = "подсказка";
        String line = reader.readLine();
        while (true) {
            if (line.contains(help)) {
                System.out.println(line);
                break;
            }
            line = reader.readLine();
        }

        //////////////////
        System.out.println("7. Предыдущее задание, но если пользователь ввел хотя бы часть слова \n" +
                " верно, то писать: горячо. (Проверять с помощью str.contains).");
        Scanner sc = new Scanner(System.in);
        String strEter = sc.next();
        System.out.println(line);
        do {
            if (line.contains(strEter)) {
                System.out.println("Горячо");
            } else {
                System.out.println("Холодно");
            }
        } while (line.contains("Подсказка"));

        ///////////////////
        System.out.println("8. Первый игрок сохраняет слово и подсказку в первый файл, \n " +
                "второй игрок во второй. Игра начинается, выводятся подсказки, игроки по-очереди пытаются отгадать слово противника.");
        File gameUno = new File("E:\\Sinergy\\DZ_2_2_While\\src\\main\\java\\org\\example\\gameUno.txt");
        FileWriter writerUno = new FileWriter(gameUno);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ваш ход Uno");
        String strUno = scan.nextLine();
        writerUno.write(strUno);
        writerUno.flush();
        writerUno.close();

        File gameDos = new File("E:\\Sinergy\\DZ_2_2_While\\src\\main\\java\\org\\example\\gameDos.txt");
        FileWriter writerDos = new FileWriter(gameDos);
        System.out.println("Ваш ход Dos");
        String strDos = scan.nextLine();
        writerDos.write(strDos);
        writerDos.flush();
        writerDos.close();

        System.out.println("Угадай  Uno");
        String strEnterUno = scan.nextLine();
        System.out.println(strDos + " содержит " + strEnterUno);
        if (strDos.contains(strEnterUno)) {
            System.out.println("Горячо");
        } else {
            System.out.println("Холодно");
        }
        System.out.println("Угадай Dos");
        String strEnterDos = scan.nextLine();
        System.out.println(strUno + " содержит " + strEnterDos);
        if (strUno.contains(strEnterDos)) {
            System.out.println("Горячо");
        } else {
            System.out.println("Холодно");
        }

        /////////////////
        System.out.println("9. Пока пользователь не введёт строку, содержащую пробел,\n считывайте строки и выводите их первые буквы");
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Введите строку или слово: ");
            input = scanner.nextLine();
            if (input.contains(" ")) {
                break;
            }
            System.out.println("Первая буква: " + input.charAt(0));
        } while (true);


        /////////////////
        System.out.println("10. Пользователь вводит полный путь и название файла. " +
                "Пока пользователь не ввел путь к существующему файлу, повторять ввод. " +
                "Проверить, что файл существует, можно так: File f = new File(); boolean isExists = f.exists()");

        String path;
        File f;
        Scanner sc1 = new Scanner(System.in);
        do {
            path = sc1.nextLine();
            f = new File(path);
            if (!f.exists()) {
                System.out.println("Нет такого файла");
            } else if (f.exists()) {
                System.out.println("Файл на месте");
                break;
            }
        } while (true);


     /////////////////
      System.out.println("11. Сохраните снимки NASA за январь 2022 года");

        String key = "WgH82FSmI6M04geem07EWObXt2MbUuZGM2dmfYTg";
       for (int day = 1; day < 30; day++) {

           String page = downloadWebPage("https://api.nasa.gov/planetary/apod?api_key=" + key + "&date=2022-01-" + day + "");
           int urlBegin = page.lastIndexOf("url");
           int urlEnd = page.lastIndexOf("}");
           String url = page.substring(urlBegin + 6, urlEnd - 1);

           InputStream in = new URL(url).openStream();
           Files.copy(in, Paths.get(day + "январ_2022.jpg"));
       }
        System.out.println("Готово");
    }

    private static String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (
                InputStream is = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            while ((line = br.readLine()) != null){
                result.append(line);
            }
        }
        return result.toString();
        }

    }


