Задание

Имеется некая система, которая обрабатывает авиа перелёты. Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками. Т. о. перелёт можно представить как набор из одного или нескольких элементарных перемещений, называемых сегментами. Сегмент — это атомарная перевозка, которую для простоты будем характеризовать всего двумя атрибутами: дата/время вылета и дата/время прилёта.

Постановка задачи

Нужно написать небольшой модуль, который будет заниматься фильтрацией набора перелётов согласно различным правилам.
•	Вылет до текущего момента времени
•	Имеются сегменты с датой прилёта раньше даты вылета
•	Общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)

Структура классов main

1.	Класс Flight - Класс полета (Атрибуты: List, id)
2.	Класс Segment - Класс расписания перелата (Атрибуты: departureDate(Время вылета),arrivalDate(Время прилета)
3.	Класс FlightBuilder - фабрика создания перелетов c исходным набором перелетов
4.	Интерфейс FlightFilter - Интерфейс для создания фильтра исключения полетов по заданным правилам.
5.	Класс FlightFilterImp - Класс реализующий интерфейс FlightFilter.

Структура классов test

1.	Класс FlightFilterImplTest - класс для тестирования основных методов .

