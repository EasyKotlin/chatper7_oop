package com.easy.kotli

import okhttp3.*
import sun.misc.BASE64Encoder
import java.io.File
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by jack on 2017/7/3.
 */

object User {
    val username: String = "admin"
    val password: String = "admin"
}

object AdminUser {
    val username: String = "admin"
    val password: String = "admin"
    fun getTimestamp() = SimpleDateFormat("yyyyMMddHHmmss").format(Date())
    fun md5Password() = EncoderByMd5(password + getTimestamp())
}

@Throws(NoSuchAlgorithmException::class, UnsupportedEncodingException::class)
fun EncoderByMd5(str: String): String {
    val md5 = MessageDigest.getInstance("MD5")
    val base64en = BASE64Encoder()
    val newstr = base64en.encode(md5.digest(str.toByteArray(charset("utf-8"))))
    return newstr
}


class DataProcessor {
    fun process() {
        println("Process Data")
    }


    object FileUtils {
        val userHome = "/Users/jack/"

        fun getFileContent(file: String): String {
            var content = ""
            val f = File(file)
            f.forEachLine { content = content + it + "\n" }
            return content
        }

    }

    companion object StringUtils {
        fun isEmpty(s: String): Boolean {
            return s.isEmpty()
        }
    }

}


class ClassA {
    companion object Factory {
        fun create(): ClassA = ClassA()
    }

//    companion object Factory2 { // error, only 1 companion object is allowed per class
//        fun create(): MyClass = MyClass()
//    }
}

class ClassB {
    companion object {
        val index = 0
        fun create(): ClassB = ClassB()
        fun get() = "Hi, I am CompanyB"
    }
}

class ClassC {
    var index = 1
    fun get(index: Int): Int {
        return 1
    }

    companion object CompanyC {
        val index = 0
        fun create(): ClassC = ClassC()
        fun get() = "Hi, I am CompanyC"
    }
}


open class Square(x: Int) {
    open val y: Int = x * x
}

interface B

fun distance(x: Double, y: Double): Double {
    val porigin = object {
        var x = 0.0
        var y = 0.0
    }
    return Math.sqrt((x - porigin.x) * (x - porigin.x) + (y - porigin.y) * (y - porigin.y))
}


object HttpUtils {
    val client = OkHttpClient()

    @Throws(Exception::class)
    fun getSync(url: String): String? {
        val request = Request.Builder()
                .url(url)
                .build()

        val response = client.newCall(request).execute()
        if (!response.isSuccessful()) throw IOException("Unexpected code " + response)

        val responseHeaders = response.headers()
        for (i in 0..responseHeaders.size() - 1) {
            println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
        }
        return response.body()?.string()
    }

    @Throws(Exception::class)
    fun getAsync(url: String) {
        var result: String? = ""

        val request = Request.Builder()
                .url(url)
                .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException?) {
                e?.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful()) throw IOException("Unexpected code " + response)

                val responseHeaders = response.headers()
                for (i in 0..responseHeaders.size() - 1) {
                    println(responseHeaders.name(i) + ": " + responseHeaders.value(i))
                }
                result = response.body()?.string()
                println(result)
            }
        })
    }
}


interface BeanFactory<T> {
    fun create(): T
}


class MyClass {
    companion object : BeanFactory<MyClass> {
        override fun create(): MyClass {
            println("MyClass Created!")
            return MyClass()
        }
    }
}

class AnonymousObjectType {
    // 私有函数，返回的是匿名object类型
    private fun privateFoo() = object {
        val x: String = "x"
    }

    // 公有函数，返回的类型是 Any
    fun publicFoo() = object {
        val x: String = "x" // 无法访问到
    }

    fun test() {
        val x1 = privateFoo().x        // Works
        //val x2 = publicFoo().x  // ERROR: Unresolved reference 'x'
    }
}


fun countCompare() {
    var list = mutableListOf(1, 4, 3, 7, 11, 9, 10, 20)
    var countCompare = 0
    Collections.sort(list, object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            countCompare++
            println("countCompare=$countCompare")
            println(list)
            return o1.compareTo(o2)
        }
    })
}


fun main(args: Array<String>) {

    ClassC.index
    ClassC.create()// com.easy.kotli.ClassC@7440e464，具体运行值会变化
    ClassC.get() // Hi, I am CompanyC
    ClassC.CompanyC.index
    ClassC.CompanyC.create()
    ClassC.CompanyC.get()

    ClassB.index
    ClassB.create()
    ClassB.get()
    ClassB.Companion.index
    ClassB.Companion.create()
    ClassB.Companion.get()


    countCompare()

    //AnonymousObjectType().publicFoo().x


    val myclass = MyClass()
    MyClass.create()
    MyClass.Companion.create()

    val url = "http://www.baidu.com"
    val html1 = HttpUtils.getSync(url)
    println("html1=${html1}")
    HttpUtils.getAsync(url)

    val nineSquare: Square = object : Square(9), B {}
    println(nineSquare.y)

    val instanceA1 = ClassA.create()
    val instanceA2 = ClassA.Factory.create()

    val instanceB1 = ClassB.create()
    val instanceB2 = ClassB.Companion.create()

    println(instanceA1)
    println(instanceA2)
    println(instanceB1)
    println(instanceB2)

//    val admin = AdminUser()
    val adminUser = AdminUser.username
    val adminPassword = AdminUser.md5Password()
    println(adminUser)
    println(adminPassword)

    val dp = DataProcessor()
    dp.process()
//     dp.FileUtils.userHome // error, cannot access object via reference
    println(DataProcessor.FileUtils.userHome)
    println(DataProcessor.FileUtils.getFileContent("test.data"))
    println(DataProcessor.StringUtils.isEmpty(""))

    println(distance(3.0, 4.0))

}
