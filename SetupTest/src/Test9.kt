
//import하는 방법은 자바와 동일
import hi.pkg.printOther2

//단, 이름이 충돌나는 경우 전체경로를 다 풀어써주는 자바와 달리 'as' 키워드로 로컬 리네임이 가능하다.
import hi.pkg.printOther3 as bar

/** Created on 2020-06-07 ... */

//소스 파일은 패키지 선언으로 시작됨.
//패키지를 명세하지 않으면 이름이 없는 기본 패키지에 포함된다. (지금까지 작성한 Test~Test9까지는 패키지 명시가 없는 기본 패키지에 속함.)

fun main(args: Array<String>) {
    printOther2()   //hi.pkg에 선언된 클래스를 임포트 해옴.
    printOther1()   //기본패키지
    bar()           //rename하여 import한 다른 패키지의 함수.

    pkgTest1(1)
}

//명시하지 않아도 import되는 package가 있다.
//kotlin.*, kotlin.annotation.*, kotlin.collections.* 등등은 기본 포함되어 있다.
fun pkgTest1(x: Any): Unit {
    //listOf()는 원래 package kotlin.collections에 정의되어 있고, 우리는 그냥 import할 필요 없이 그냥 이용하면 된다.
    var a = listOf(1,2,3)
    println(a)
}

