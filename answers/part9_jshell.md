# Часть 9 — Эксперименты в jshell

## Как запустить jshell

Откройте терминал IntelliJ (View → Tool Windows → Terminal) и введите:
```
jshell
```
Для выхода: `/exit`

---

## Задание 9.1: Sealed-классы

### Команды (скопируйте и вставьте в jshell)

```
sealed interface Shape permits Circle, Square {}
record Circle(double r) implements Shape {}
record Square(double side) implements Shape {}
Shape s = new Circle(5)
s instanceof Circle c ? "Круг r=" + c.r() : "Не круг"
```

### Фактический вывод:

```
|  modified interface Shape
|  modified record Circle
|  modified record Square
|  Error:
|  ';' expected
|  Shape s = new Circle(5)
|                         ^

```

### Вопрос: Что произойдёт при попытке создать `record Triangle(double a) implements Shape {}`?

**Ваш ответ:**
При попытке создать record Triangle(double a) implements Shape {} возникает ошибка


---

## Задание 9.2: Цепочка лямбд

### Команды

```
import java.util.function.*
Function<String, String> trim = String::trim
Function<String, String> upper = String::toUpperCase
Function<String, String> exclaim = s -> s + "!"
var pipeline1 = trim.andThen(upper).andThen(exclaim)
var pipeline2 = exclaim.compose(upper).compose(trim)
pipeline1.apply("  hello world  ")
pipeline2.apply("  hello world  ")
```

### Фактический вывод:

```
|  Error:
|  ';' expected
|  import java.util.function.*
|  
```

### Вопрос: Дают ли `andThen()` и `compose()` одинаковый результат? В каком случае результаты будут различаться?

**Ваш ответ:**
В данном случае andThen() и compose() дают одинаковый результат "HELLO WORLD!", потому что порядок применения функций в обоих случаях один и тот же: сначала trim, затем upper, затем exclaim.


---

## Задание 9.3: Сравнение EnumSet и HashSet

### Команды

```
enum Color { RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE, BLACK }
var enumSet = java.util.EnumSet.of(Color.RED, Color.GREEN, Color.BLUE)
var hashSet = new java.util.HashSet<>(java.util.Set.of(Color.RED, Color.GREEN, Color.BLUE))
enumSet.contains(Color.RED)
hashSet.contains(Color.RED)
enumSet.getClass().getSimpleName()
hashSet.getClass().getSimpleName()
```

### Фактический вывод:

```
|  modified enum Color
|  Error:
|  ';' expected
|  var enumSet = java.util.EnumSet.of(Color.RED, Color.GREEN, Color.BLUE)
|    
```

### Вопрос: Почему внутренний класс EnumSet называется `RegularEnumSet`? Что произойдёт, если enum будет иметь больше 64 констант?

**Ваш ответ:**
Почему RegularEnumSet: Этот класс использует long (64 бита) как битовую маску для хранения элементов. Каждый бит соответствует одному enum-значению по его порядковому номеру (ordinal). Это позволяет очень эффективно хранить и проверять наличие элементов.

Что произойдёт при более чем 64 константах: Когда enum содержит больше 64 констант, JVM автоматически переключается на другой внутренний класс — JumboEnumSet. Этот класс использует массив long[] вместо одного long, что позволяет хранить любое количество элементов. Переключение происходит автоматически внутри реализации EnumSet
