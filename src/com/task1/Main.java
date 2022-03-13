package com.task1;

/* 1. В классе Cat создать метод "protected void finalize() throws Throwable". */

class Cat
{
    String name;
    static int catCount = 0;

    protected Cat (String name)
    {
        catCount += 1; // Часть задания №4
        this.name = name;
        System.out.println("Котов стало: " + catCount + "\n"); // Часть задания №4
    }

    protected void finalize() throws Throwable
    {
        catCount -= 1; // Часть задания №4
        System.out.println(name + " больше не с нами. Прощай, мы будем скучать"); // Часть задания №2
        System.out.println("Котов стало: " + catCount + "\n"); // Часть задания №4
    }
}

/* 2. В каждом классе Cat и Dog написать метод finalize, который выводит на экран текст о том, что такой-то объект уничтожен. */

class Dog
{
    String name;

    protected Dog (String name)
    {
        this.name = name;
    }

    protected void finalize() throws Throwable
    {
        System.out.println(name + " больше не с нами. Прощай, мы будем скучать");
    }
}

public class Main {

    /* 3. Создать в цикле по 50 000 объектов Cat и Dog.
    (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется). */

    public static void main(String[] args) {
        System.out.println();

        for (int i = 0; i < 100000; i++) { // 100000 - потому что только так на моем ПК получается вызвать вывод
            Object Cat = new Cat("Пушок");
            Object dog = new Dog("Рекс");
        }
        System.out.println();

        /* 4. В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную catCount этого же класса) на 1.
        В методе finalize уменьшать на 1. (смотрим выше) */
    }
}