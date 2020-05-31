/** Created on 2020-05-28 ... */

fun main(args: Array<String>) {
    //ifelse(6,7)

    //whentest(1, true)
    //whentest(9, false)

    whentest2("hahaha")
    whentest2(4)
}

//코틀린의 Control Flow
//if else문: 자바와 거의 유사함.
// 만약 if문이 Expression으로 사용되는 경우 값을 반환하며, 이 때는 반드시 else를 동반해야 함. 안쓰면 컴파일 에러.
fun ifelse(a:Int, b:Int) {
    val max = if(b>a) a else b   //'if' must have both main and 'else' branches if used as an expression
    println("max is $max");

    //if 식의 branches들이 블록을 가질 수 있음. 블록의 마지막 구문이 반환된다.
    val max2 = if (a > b) {
        print("Choose a")
        a
    }else{
        print("Choose b")
        b
    }
    println("max2 is $max2");

    //위와 같은 기능으로 인해, 자바의 삼항연산자(ternary)가 없음.
    //코틀린의 if문이 그 역할을 잘 해내기 떄문에.
    //Java구문 -->   int max = (a>b)? a:b;
    val test = if(b>a) a else b   //이걸 디컴파일 하면 "int test = b > a ? a : b;"의 삼항연산자가 나옴.
}

//자바의 switch를 대체하는 when
//각 branches의 조건문이 true가 될 때까지 위에서부터 순차적으로 인자를 비교한다.
fun whentest(x:Int, y:Boolean){
    when (x) {
        1 -> println("x is 1")
        2 -> println("x is 2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }

    //when도 Expression으로 사용하면 값을 리턴한다. 역시 else문이 꼭 포함되어야 한다.
    var exp1 = when (x) {
        100 -> "a"
        90 -> "b"
        80 -> "c"
        else -> "f"  //'when' expression must be exhaustive, add necessary 'else' branch
    }
    println("exp1 is $exp1")
    //단, else문이 없어도 된다는 것을 컴파일러가 인식하는 경우 예외적으로 else를 생략할 수 있다.
    var exp2 = when (y) {
        true -> "맞다"
        false -> "틀리다"
    }
    println("exp2 is $exp2")
}

fun whentest2(x: Any): Unit {
    //여러 조건들이 같은 방식으로 처리될 수 있는 경우, 조건문에 콤마를 사용하여 표기할 수 있다.
    when (x) {
        0,1 -> println("x == 0, 1")
        else -> println("otherwise")
    }

    //조건문에 함수나 식을 사용할 수 있음
    when (x) {
        parseInt(x.toString()) -> print("x can be Integer")
        1+3 -> print("x == 4")
        else -> println("else x")
    }
}

