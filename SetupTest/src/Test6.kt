/** Created on 2020-05-31 ... */

fun main(args: Array<String>) {
    whentest3(21)

    println("when: ${hasPrefix(" smart casting")}")
}

fun whentest3(x:Int){
    //range나 collection에 있는 것도 활용할 수 있다.
    val validNumbers = listOf(3,6,9)
    when (x) {
        in validNumbers -> println("x[$x] is valid")
        in 1..10 -> println("in the range 1~10")
        !in 10..20 -> println("not in the 10~20")
        else -> println("none of the above")
    }
}

//is 혹은 !is 를 이용하여 타입 검사를 수행할 수 있다. 타입 검사 이후 스마트캐스트가 적용된다.
fun hasPrefix(x: Any)= when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun whentest4(x: Any): Unit {
    //when은 if-else if 체인을 완전히 대체할 수 있다.
    //when에 인자를 입력하지 않으면, 논리연산으로 처리된다.

}