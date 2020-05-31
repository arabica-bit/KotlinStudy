/** Created on 2020-05-31 ... */

fun main(args: Array<String>) {

    var myData = MyData()
    myData.iterator()  //iterator를 반환함.
    for(item in myData){
        print(item)
    }
    println()

    //fortest1()
    fortest2()
}

fun fortest1(): Unit {
    //for문은 iterator()를 제공하는 콜렉션이라면 모두 반복할 수 있다
    val colls = listOf(1,3,5,7,9)
    for(item in colls)
        print(item)
}

fun fortest2(): Unit {
    //배열이나 리스트 반복시에 인덱스를 이용하려면, indices를 이용
    var array = arrayOf("가", "나", "다")
    for(i in array.indices){
        println("$i: ${array[i]}")
    }

    //또는 withIndex()를 이용할 수도 있다.
    for((index, value) in array.withIndex()){
        println("index=$index , value=${value}")
    }
}

class MyIterator {
    //hasNext()와 next()를 operator로 구현.
    //중요한 건 별도의 상속을 받지 않고, 구현만 적절히 해주면 된다는 점.
    val data = listOf(1,2,3,4,5)
    var idx = 0
    operator fun hasNext() : Boolean {
        return data.size > idx
    }

    operator fun next() : Int {
        return data[idx++]
    }
}
//멤버함수나 확장함수 중에 다음 조건을 만족하면 for-loop에 구현할 수 있다.
//iterator()를 구현하고 그 iterator에는 next(), hasNext():Boolean 함수를 구현해야 함. 모두 operator로 표기되어야한다.
class MyData {
    //iterator()라는 operator를 구현.
    operator fun iterator () : MyIterator {
        return MyIterator()
    }
}