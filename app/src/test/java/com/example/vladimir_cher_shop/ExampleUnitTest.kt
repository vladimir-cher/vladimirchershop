package com.example.vladimir_cher_shop

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

/*
    fun formatPrice(price: Int, measure: String, discount: Int): String {
        val discountPrice = price - (price * discount / 100)
    return "Цена товара - $price/$measure, скидка - $discount%, цена со скидкой - $discountPrice"

    }

    fun doSomethingShort(arg1: Int, arg2: String): String = "Hello World! $arg1, $arg2"


    @Test
    fun printDiscount() {
        val formattedPrice = formatPrice(123, "кг", 5)
        println(formattedPrice)

        val a: Double = 1.5
        val b = 1
        val c = a + b.toInt()
        println(c)
    }


    fun formatPriceHomeTask(price: Double, measure: String = "шт", discount: Int): String {

        val discountPrice = price - (price * discount / 100)
        var result: String = ""
        val division = discountPrice%10

        if (discount > 0 && division > 0) {
            result = "${String.format("%.2f", discountPrice)}/$measure,(скидка$discount%)"
        }

        if (discount > 0 && division <= 0) {
            result = "${discountPrice/10}/$measure, (скидка$discount%)"
        }

        if (discount <= 0 && price%10 <= 0){
            result = "${price/10}/$measure"
        }

        if (discount <= 0 && price%10 > 0){
            result = "${String.format("%.2f", price)}/$measure"
        }
        return "$result"
    }

    @Test
    fun printPrice() {
        val resultTwo = formatPriceHomeTask(100.52344, "L", 0)
            println(resultTwo)
    }




    @Test
    fun sum() {
        val first = 1
        val second = 2
        val summa = first + second

        println(summa)
    }



    @Test
    fun sqrtUrav() {
        val a = 1.0
        val b = 8.0
        val c = 12.0
        val dis: Double = (b * b) - (4 * a * c)
        val x1 = (b * (-1) + Math.sqrt(dis)) / (2 * a)
        val x2 = (b * (-1) - Math.sqrt(dis)) / (2 * a)

        println(x1)
        println(x2)
    }

    //решение из чатика

    fun descriminant(a: Double, b: Double, c: Double){
        val d = b*b - 4*a*c

        val x1 = (-b - Math.sqrt(d))/(2*a)
        val x2 = (-b + Math.sqrt(d))/(2*a)

        println("$x1, $x2")
    }

    fun descriminantUslovie(a: Double, b: Double, c: Double){
        val d = b*b - 4*a*c

        if (d> 0.0) {
            val x1 = (-b - Math.sqrt(d))/(2*a)
            val x2 = (-b + Math.sqrt(d))/(2*a)
            println("$x1, $x2")
        }

        if (d == 0.0) {
            val x = (-b - Math.sqrt(d))/(2*a)
            println("$x")

        }

        if (d < 0.0) {

            println("Решений нет")
        }

    }

    //решение из чатика с when
    fun disc(a: Double, b: Double, c: Double) {
        val D = Math.pow(b, 2.0) - 4 * a * c
        when {
            (D > 0) -> print("${-1.0 * b - Math.sqrt(D) / (2.0 * a)}, ${-1.0 * b + Math.sqrt(D) / (2.0 * a)}")
            (D == 0.0) -> print(-1.0 * b / (2.0 * a))
            else -> print("Error")
        }
    }

    //ДЗ одного из участников
    @Test
    fun PriceFormat(price : Double, measure: String, discount: Int = 0) : String{
        val finalPrice : String
        if((discount > 0) and (discount <= 100)){
            //вычисляем цену по скидке
            val discountPrice : Double = ((100 - discount)*price)/100;
            //определяем, целое число или дробное
            if (Math.floor(discountPrice) == (discountPrice)) {
                //число целое - цена без дробной части
                finalPrice  = Math.floor(discountPrice).toInt().toString()
            } else {
                //число дробное - цена с дробной частью
                finalPrice = String.format("%.2f", discountPrice);
            }
            return "$finalPrice/$measure (скидка $discount%)"
        }
        else if (discount == 0){
            //определяем, целое число или дробное
            if (Math.floor(price) == (price)) {
                //число целое - цена без дробной части
                finalPrice  = Math.floor(price).toInt().toString()
            } else {
                //число дробное - цена с дробной частью
                finalPrice = String.format("%.2f", price);
            }
            //выводим цену без скидки
            return "$finalPrice/$measure"
        }
        else{
            return "Скидка не может принимать значение меньше 0 или больше 100"
        }
    }


    val f = PriceFormat(100.24, "sd", 44)
        */

    //описываем предметную область
    @Test
    fun example() {

        val murka = object {
            //описываем состояние и поведение объекта
            var isDreaming = false

            fun goSleep() {
                isDreaming = true
            }

            fun wakeUp() {
                isDreaming = false
            }

            fun voice() {
                if (isDreaming) {
                    voiceWhenDreaming()
                } else {
                    voiceWhenWakedUp()
                }
            }

            private fun voiceWhenDreaming() {
                println("hrr")
            }

            private fun voiceWhenWakedUp() {
                println("murr")
            }

        }
        //для вызова действия объекта используется точечный синтаксис

        //старый вариант вызова голоса

        //здесь будет hrr
        murka.voice()
        //а здесь уже mur
        murka.isDreaming = true
        murka.voice()

        //новый вариант вызова голоса
        murka.wakeUp()
        murka.voice()

        murka.goSleep()
        murka.voice()

    }


    @Test
    fun internetShop() {

        /*
        val readmeFile = File("/README.md")

        readmeFile.writeText("Hello World!")
        */


        //если конструктор один, слово конструктор можно не писать. класс с конструктором становится похож на просто функцию
        class Product constructor(
            private val price: Double,
            private val discountInPercent: Int
        ) {

            /*
           Полный синтаксис конструктора
            private val price: Double
            private val discountInPercent: Int

            constructor(price: Double, discountInPercent: Int) {
                this.price = price
                this.discountInPercent = discountInPercent
            }
            */

            fun printPrice() {
                val discountPrice = price - (price * discountInPercent / 100)
                println(discountPrice)
            }

        }

        val iphoneCase = Product(price = 123.12, discountInPercent = 10)

        iphoneCase.printPrice()

        val samsungCase = Product(price = 155.99, discountInPercent = 15)

        samsungCase.printPrice()


        val list = listOf(1, 2, 3)
        //лямбда функции
        list.forEach({ int -> println(int) })


        val priceFormatter: PriceFormatter = CleanKotlinPriceFormatter()

        //
        // val formattedIphoneCasePrice = priceFormatter.format(discountPrice)
    }

    interface PriceFormatter {

        fun format(price: Double): String
    }

    class CleanKotlinPriceFormatter : PriceFormatter {

        override fun format(price: Double): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}