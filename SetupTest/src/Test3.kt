/** Created on 2020-05-26 ... */


fun main(args: Array<String>) {
    test()

    //작은 타입은 큰 타입의 하위 타입이 아님. 작은 타입에서 큰 타입으로의 묵시적 캐스팅이 안됨.
    val a: Int = 1
//    val b: Long = a //에러
    //println(a == b) //에러 (묵시적으로 a를 캐스팅하지 않음)
    //명시적으로 변환을 해줘야 한다.
    val c: Long = a.toLong()
    val b: Long = 1L
    val i: Int = b.toInt()

}

//코틀린에서 모든 것은 객체라고 생각하면 된다. 모든 것에 멤버 함수나 프로퍼티를 호출 가능하기 때문에.
//자바의 primitive type -> 코틀린의 Basic type.

//코틀린의 Number는 클래스임. 그리고 자바와 달리 char는 숫자형으로 처리되지 않는다.
//Literal 표시 동일. 다만 8진수 미지원. 보통 Hex(16)를 사용하니까 큰 무리 없을 듯.

fun undercore() {
    //숫자가 길어지면 보기 어려우니까 중간에 언더바를 추가할 수 있도록 함.
    val oneMillion = 1_000_000
    val creditCartNumber = 123_456_789_111L
    val hexNumber = 0xFF_EC_DE_51
    val bytes = 0b11010010_01101001_10010100_10010010
}

fun test() {
    //코틀린이 Java 플랫폼에서 동작할 때 숫자들은 JVM Primitive type으로 저장된다.
    //그러나 Nullable 혹은 Generic은 객체로 박싱된다.
    //박싱이 되면 Identity가 유지 되지 않는다.
    //다음의 경우 a와 b는 Identity가 같으며, 값도 같다.
    var a: Int = 10000
    var b: Int = 10000
    println("a === b: ${a === b}")   //Identity의 비교.
    println("a == b: ${a == b}")     //값이 같은지. Equality.

    //이 경우 d가 Nullable로 지정되었다. d는 박싱이 되어 처리된다.
    //그 결과 c와 d는 값은 같지만, Identity는 다르다. (타입이 서로 다르다 보면 됨)
    var c: Int = 10000
    var d: Int? = 10000
    println("a === b: ${c === d}")   //Identity의 비교.
    println("a == b: ${c == d}")     //값이 같은지. Equality.

    //실제 Bytecode tool(show kotlin bytecode)을 보면 a,b,c는 primitive인 'int'로 변환.
    //그러나 Nullable인 d는 박싱되어 'Integer'로 변환된다.
    //이러한 특성을 잘 이해하고 있어야 함.
}


fun check(c: Char) {
    //기존 자바에서는 char를 unsigned short로 처리했는데..
//    if (c == 1) {}  //char는 숫자가 아니라 에러
    if (c == 'a') {}  //이건 OK

    //숫자로 바꾸고 싶다면 아래 함수.
    print('0'.toInt())  //유니코드 48출력. 서로 변환은 되나 숫자 자체로 취급되지 않는다는 점.
}