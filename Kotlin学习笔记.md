# Kotlin学习笔记

## 逻辑控制

### If语句

Kotlin中if语句的基础用法和Java一样。比如写一个求比较大的值的函数，基础写法：

```kotlin
	fun largeNum(num1: Int, num2: Int): Int {
        var value = 0
        if (num1 > num2) {
            value = num1
        } else {
            value = num2
        }
        return value
    }
```

**不过，与Java不同的是，Kotlin的if语句是有一个返回值的。**于是上面的写法就可以简化成：

```kotlin
	fun largeNum2(num1: Int, num2: Int): Int {
        val value = if (num1 > num2) {
            num1
        } else {
            num2
        }
        return value
    }
```

这里if语句的返回值就直接赋值给了value变量。再结合Kotlin函数的特点，上面的函数还可以简化：

```kotlin
	fun largeNum3(num1: Int, num2: Int): Int = if (num1 > num2) {
        num1
    } else {
        num2
    }
```

这样整个函数体都简洁很多。

### when语句

kotlin里没有Java里的Switch语句，取而代之的是when。他和switch类似，但是更强大。

比如现在有这样一个函数

```kotlin
	fun getScore(name: String): Int = if (name == "a") {
        100
    } else if (name == "b") {
        99
    } else if (name == "c") {
        98
    } else {
        59
    }
```

大量的if-else if ，在Java里switch很简洁，在kotlin中用when也同样简洁。可以改写成下面这样：

```kotlin
	fun getScore2(name: String): Int = when (name) {
        "a" -> 100
        "b" -> 99
        "c" -> 98
        else -> 59
    }
```

when的强大功能之一是，可以用来判断传入的数据类型。比如：

```kotlin
	fun getType(num: Number): String = when (num) {
        is Int -> "Int"
        is Long -> "Long"
        else -> "other"
    }
```

这里的is相当于Java里的instanceof关键字，可以判断类型。

when还有一个强大的地方在于，他可以不接受参数。比如上面getScore可以改写成：

```kotlin
	fun getScore3(name: String): Int = when {
        name == "a" -> 100
        name == "b" -> 99
        name == "c" -> 98
        else -> 59
    }
```

这样写有什么好处呢？可以让条件判断更加灵活，比如条件是一个范围

```kotlin
	fun getLow(num: Int): Int = when {
        num < 10 -> 0
        num < 20 -> 10
        num < 30 -> 20
        else -> 30
    }
```

这样也能够避免大量的if else语句。相比之下要比Java的switch灵活很多。

### for循环

说循环之前，先说一下kotlin特有的表示区间的方式。

- 左闭右闭升序区间 [0,10]  在kotlin中的表示为 **0..10**
- 左闭右开升序区间 [0,10)  在kotlin中的表示为 **0 until 10**
- 左闭右闭降序区间 [10,1]  在kotlin中的表示为 **10 downto 1**

明白怎么表示区间之后，kotlin的for循环表示方法也和Java有所不同。**kotlin主要是for-in语句。**

比如打印0-10，可以这样写

```kotlin
	fun print1To10() {
        for (i in 0..10) {
            print(i)
        }
    }
```

还可以这样写

```kotlin
	fun print1To10Tow() {
        for (i in 0 until 11) {
            print(i)
        }
    }
```

![image-20220701170442686](C:\Users\lukarzhang\AppData\Roaming\Typora\typora-user-images\image-20220701170442686.png)

for循环默认在until区间内每次+1，我们还可以通过step来指定每次的增量。

```kotlin
	fun print1To10Tow() {
        for (i in 0 until 11 step 3) {
            print(i)
        }
    }
```

![image-20220701170543791](C:\Users\lukarzhang\AppData\Roaming\Typora\typora-user-images\image-20220701170543791.png)

downTo和until用法差不多。这里就不演示了。**要注意的就是until是一个左闭右开区间。**

## 面向对象

### 构造函数

kotlin类的构造函数和Java有着很大的区别。我们都知道Java的构造函数要求**不带返回值，方法名和类名完全一致。**

但是在kotlin里的构造函数完全不同。kotlin里分主构造函数和次构造函数。

#### 主构造函数

**主构造函数的特点是没有函数体。**我们和Java来对比一下。比如有一个Person类，有name和age两个属性，在创建对象的时候需要传入这两个参数。那么在Java中的写法是

```java
public class Person {

    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

放到kotlin里就变成了

```kotlin
class Person(val name: String, val age: Int) {
}
```

kotlin的主构造函数就是把参数放在类名后面，我们在创建Person对象的时候，直接

```kotlin
val person = Person("Luka", "23")
```

就可以创建了，我们不用再写一个多余的赋值操作。

**可是有人会问，那我想在构造函数里执行一些操作呢？**不用担心，kotlin提供了init结构体。执行主构造函数的时候就会执行到init结构体里。

```kotlin
class Person(val name: String, val age: Int) {

    init {
        println("name is $name  age is $age")
    }

}

fun main() {
    val person = Person("Luka", 23)
}
```

![image-20220701172358543](C:\Users\lukarzhang\AppData\Roaming\Typora\typora-user-images\image-20220701172358543.png)

然后需要说一下主构造函数里的参数。**如果主构造函数里的参数用val或var声明了，那么这个参数就会变为该类的一个字段；如果没有用var或val声明，那么这个参数就只是主构造函数的一个参数，只能在init结构体里访问。**

![image-20220701173709050](C:\Users\lukarzhang\AppData\Roaming\Typora\typora-user-images\image-20220701173709050.png)

主构造函数一开始比较难理解，建议多写一写，也可以配合后面的继承来理解。

#### 次构造函数

首先在Java里是允许多个参数不同的构造函数的，参数不同