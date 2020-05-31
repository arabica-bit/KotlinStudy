import kotlin.reflect.typeOf

/** Created on 2020-05-24 ... */

fun main(args: Array<String>) {
    println("Hello World")

    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println("s1: $s1")
    println("s2: $s2")

    printProduct("test", "test2")

    println(getStringLength(1))
    println(getStringLength("change to Upper"))

}

//함수는 fun으로 정의
fun sum(a: Int, b: Int): Int {
    return a+b
}

//함수 몸체가 Expression인 경우 Return 생략 가능
fun sumEx(a: Int, b:Int) = a+b 

//void 처리. 리턴할 값이 없는 경우 Unit(Object)으로 리턴 한다.
//Unit을 명시하지 않아도 암묵적으로 처리.
fun printKotlin() {
    print("message");
}

//지역변수 val은 읽기 전용 변수. 값의 할당이 1회만 가능. java의 final과 유사.
val a: Int = 1
//var는 Mutable 변수
var x = 5

//조건문
fun maxOf(a: Int, b:Int) = if(a>b) a else b

//Nullable type
fun parseInt(str: String): Int? {
    return if(str == "test") 1
    else null
}

//Null check 하지 않으면 컴파일 오류
fun printProduct(arg1: String, arg2: String) {
    val x: Int? = parseInt("aaa")
    val y: Int? = parseInt("strrrr")

    if(x != null && y != null){
        println(x * y);
    }else{
        println("either '$arg1' or '$arg2' is not a number")
    }
}

//자동 타입 변환 - 타입 체크만 해도 자동으로 타입 변환이 됨
fun getStringLength(obj: Any): String? {
    return if(obj is String){
        // 'obj'가 자동으로 String 타입으로 변환됨
        obj.toUpperCase()
    }else "not a String"
}