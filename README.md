# Описание задания
У нас есть 2 файла-справочника городов (файлы во вложении). Один файл в формате xml, другой в формате csv.
Необходимо разработать консольное приложение. После запуска приложение ожидает ввода пути до файла-справочника либо команды на завершение работы (какая-то комбинация клавиш).По команде завершения работы приложение завершает свою работу. После ввода пути до файла-справочника приложение формирует сводную статистику:
1) Отображает дублирующиеся записи с количеством повторений.
2) Отображает, сколько в каждом городе: 1, 2, 3, 4 и 5 этажных зданий.
После вывода статистики приложение снова ожидает ввода пути до файла-справочника либо команды на завершение работы.
В процессе работы приложение падать не должно, выход только по команде на завершение работы.

Условия
Система сборки Gradle, Java 8. Необходимо обойтись только средствами, входящими в пакет Java SE. (Из сторонних библиотек допустимо использование только jUnit - для тестов).

#*В папке resource необходимо распаковать архив*
