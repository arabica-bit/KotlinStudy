/** Created on 2020-05-31 ... */

fun main(args: Array<String>) {
    whiletest1(5)
}

fun whiletest1(x:Int) : Unit {
    //입력 파라미터는 val로 인식하는것 같다.
    //x를 직접 while문에 넣었더니 컴파일 에러 발생함.
    var t = x
    while (t > 0){
        print("${t--}")
    }
    
    println()

    //자바와의 차이: do-while문에서 body내 지역변수를 do-while 조건문이 참조할 수 있다.
    do {
        var q = t;
        print("q: $q")
    } while (q>0)

}