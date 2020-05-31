/** Created on 2020-05-24 ... */


fun main(args: Array<String>) {
//    makeLoop()
//    println(describe(1))
//    println(describe("Hello"))
//    println(describe(0.1))
//    ranges()
//    collecs()
    collAndLamda()
}

//람다식과 컬렉션
fun collAndLamda(): Unit {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    // 'it'은 람다식에서 대상을 지칭하는 예약어
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

//Collections
fun collecs(): Unit {
    val items = listOf("apple", "banana", "kiwi")
    for(item in items) {
        println("items -> $item")
    }

    val items2 = setOf("apple", "banana", "kiwi")
    //처음 걸리는 하나만 출력한다. 첫번째 이후는 패스하는것 같다.
    when {
        "k34i"  !in items2 -> println("no ki")
        "orange" in items2  -> println("Orange Juice")
        "apple"  in items2  -> println("Apple is fine too")
    }
}

//ranges 범위체크
fun ranges(): Unit {
    val x = 3
    //조건문
    if(x in 1..10){
        println("fits in range")
    }
    //for 구문
    for(x in 1..5){
        print(x)
    }
}

//when 표현 (Switch-Case의 확장)
fun describe(obj: Any): String {
    return when (obj) {
        1           -> "One"
        "Hello"     -> "Greeting"
        is Long     -> "Long"
        !is String  -> "Not a String"
        else        -> "Unknown"
    }
}

//Loop
fun makeLoop(): Unit {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at '$index' is '${items[index]}'")
        index++
    }
}