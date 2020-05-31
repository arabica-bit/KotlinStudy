/** Created on 2020-05-26 ... */


fun main(args: Array<String>) {
    normalArray()
    specialArray()

    //String은 문자열. character로 구성됨. s[i]와 같은 방식으로 접근 가능하지만, immutable이므로 변경은 불가능하다. 자바와 별차이 없다.

    //문자열 리터럴은 자바와 일부 차이 있다.
    //escaped string (전통적인 방식) - 역슬래쉬를 이용하여 escape문자 처리
    val s = "Hello, world! \n"
    //raw string (자바와 다른 코틀린만의 방식) - escape문자 처리 필요 없음.
    val s2 = """ 
        "이것은 코틀린의 raw string
        이며, 따옴표 3개면 별도의 escape 처리가 필요 없다.
        개행도 그냥 사용.
    """
}

fun normalArray() {
    //배열은 Array 클래스로 표현되며, 다양한 멤버 함수 포함.
    var array: Array<String> = arrayOf("코틀린", "강좌")
    println(array.get(0))
    println(array[1])

    //팩토리 함수 이용하여 생성
    val b = Array(5) { i -> i.toString()} //람다식을 이용해서 생성했다.
    for( i in b ) { print(i) }
    println()
    //라이브러리 함수 이용하여 생성
    val c = arrayOf("0", "1", "2", "3", "4")
    for( i in c ) { print(i) }
}

fun specialArray() {
    //다음처럼 Generic이 사용된 경우. primitive 타입이 아닌 객체 형식으로 동작하게 된다.
    //이 경우 primitive 타입을 박싱하면서 오버헤드가 발생한다.
    //Null이 필요하지 않은, 숫자만 포함된 배열을 사용하고 싶다면.
    var array2: Array<String> = arrayOf("코틀린", "강좌")

    //특별한 Array 클래스: IntArray, ShortArray, ...
    //Array와 같은 메소드와 프로퍼티를 갖지만, 사실 Array를 상속한 클래스는 아니다.
    val x: IntArray = intArrayOf(1,2,3)
    x[0] = 7
    println(x.get(0))
    println(x[0])
    println(x.size)
}