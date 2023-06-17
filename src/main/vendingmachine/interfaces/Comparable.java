// Классы, реализующие этот интерфейс, могут сравнять по определенному критерию.
// Интерфейс Comparable используется для сравнения объектов класса Beverage по цене.
package src.main.vendingmachine.interfaces;

public interface Comparable<T> {
    int compareTo(T other); // Метод для сравнения объектов
}