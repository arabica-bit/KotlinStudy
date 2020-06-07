/** Created on 2020-06-07 ... */

//Jump 표현식: return, break, continue (자바와 동일)
fun main(args: Array<String>) {
    //labelTest1()
    //labelTest2(1)
    foo()
    foo1()
    println()
    foo2()
    foo3()
    foo4()
}


//Label로 Break and Continue
fun labelTest1 () {
    name1@ for(i in 1..10){
        println("--- i: $i ---")

        for (j in 1..10){
            println("j: $j")
            if(i+j>12) {
                break@name1
            }
        }
    }
}

fun labelTest2(x: Any): Unit {
    내맘대로@ for(i in 1..10){
        println("--- i: $i ---")
        for(j in 1..10){
            if(j>2){
                continue@내맘대로  //한글도 된다.신기하네.
            }
            println("$j less than 2")
        }
    }
}

//Label로 Return할 때. 코틀린에서 판단하는 블록(중첩)의 요소는??
//함수 리터럴(function literals), 지역함수(local), 객체 표현식(expression), 함수(functions)
fun foo() {
    var ints = listOf(0,1,2,3)

    //다음처럼 함수를 중첩하면, value가 1인경우는 제외하고 나머지 값은 print하도록 처리.
    ints.forEach(
            fun(value:Int) {
                if(value == 1) return
                print(value)
            })
    println()
    println("forEach end")
}
fun foo1() {
    var ints = listOf(0,1,2,3)
    //foo()에 이어서.. 그런데 아래와 같이 람다를 사용하면?
    //코틀린이 판단하는 중첩 기준에 속하지 않기 때문에, 0만 출력하고 1 출력할 순서에서 foo() 함수가 종료된다.
    //즉, 람다식은 함수로 취급되지 않아서, 가장 가까운 함수인 foo()가 종료됨.
    ints.forEach (
            {
                if (it == 1) return
                print(it)
            }
    ) //참고: 람다식을 사용하면 소괄호를 축약할 수 있다. ()없애고, {}만 남길수 있음. 그러나 예시 이해 차원에서 그냥 넣었음.

    println("lamda end")
}
fun foo2() {
    //람다식을 쓸 때 원하는 루프로 점프하려면 label을 사용하면 된다.
    var ints = listOf(0,1,2,3)
    ints.forEach myLabel@{
        if (it == 1) return@myLabel     //label을 안쓰면 foo1()과 동일한 결과.
        print(it)
    }
    println("Lamda End-")
}
//위 foo2()와 같이 레이블을 선언하지 않고, 암시적인 레이블을 이용하는 방법이 있다
fun foo3() {
    println("foo3() 암시적 레이블 사용.")
    //람다가 사용된 가까운 함수의 이름을 입력
    var ints = listOf(0,1,2,3)
    ints.forEach {
        if (it == 1) return@forEach
        print(it)
    }
    println("~Lamda End~")
}
//Label도 사용하고 해당 위치에서 값을 리턴까지 하려면?
//return + @label + value 형태로 사용함
fun foo4() {
    println("foo4() 점프 및 리턴")
    //람다가 사용된 가까운 함수의 이름을 입력
    var ints = listOf(0,1,2,3)
    var result = ints.map {
        if (it == 1) return@map "One"   //레이블 return하면서 "One"이라는 값을 반환한다.
        //print(it)
        "number $it"
    }
    //그러면 map에는 [number 0, One, number 2, number 3] 와 같이 저장된다.
    println("map: $result")
    println("~Label and Return End~")
}