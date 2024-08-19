package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByTypes; // создаем хеш-таблицу блюд по типам
    ArrayList<String> types = new ArrayList<>(); // создаем и иниц. список запрашиваемых типов блюд
    Random random = new Random();

    DinnerConstructor() {
        dishesByTypes = new HashMap<>(); // инициализируем хеш-таблицу блюд по типам
    }

    void saveTypeAndDish(String dishType, String dishName) { // сохраняем блюда по типам в таблицу
        if (dishesByTypes.containsKey(dishType)) { // проверяем наличие уже такого типа в таблице
            ArrayList<String> dishes = dishesByTypes.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesByTypes.put(dishType, dishes);
        }
    }

    boolean checkType(String type) { // проверяем наличие типа блюда в таблице
        return dishesByTypes.containsKey(type);
    }

    void saveType(String item) { // сохраняем тип запрашиваемого блюда
        types.add(item);
    }

    void generateCombo(int numberOfCombos) { // генерируем наборы блюд
        for (int i = 0; i < numberOfCombos; i++) { // создаем наборы в цикле исходя из кол-ва запрошенных наборов
            ArrayList<String> combo = new ArrayList<>(); // создаем новый набор
            for (String type : types) { // обходим все запрошенные типы блюд
                ArrayList<String> dishes = dishesByTypes.get(type); // получаем список блюд из таблицы по типу
                int randomNumberOfDish = random.nextInt(dishes.size() - 1);
                String randomDish = dishes.get(randomNumberOfDish); // получаем случайное блюдо из списка имеющихся
                combo.add(randomDish); // добавляем случаное блюдо в набор
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo);
        }
        types.clear(); // очищаем список запрошенных типов блюд
    }
}
