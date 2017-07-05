第7章 面向对象编程（OOP）
===

在前面的章节中，我们学习了Kotlin的语言基础知识、类型系统、集合类以及泛型相关的知识。在本章节以及下一章中，我们将一起来学习Kotlin对面向对象编程以及函数式编程的支持。


##7.1 面向对象编程思想

### 7.1.1 一切皆是映射

《易传·系辞上传》：“易有太极，是生两仪，两仪生四象，四象生八卦。” 如今的互联网世界，其基石却是01（阴阳），不得不佩服我华夏先祖的博大精深的智慧。

> 一切皆是映射

计算机领域中的所有问题,都可以通过向上一层进行抽象封装来解决.这里的封装的本质概念，其实就是“映射”。

就好比通过的电子电路中的电平进行01逻辑映射，于是有了布尔代数，数字逻辑电路系统；

对01逻辑的进一步封装抽象成CPU指令集映射，诞生了汇编语言；

通过汇编语言的向上抽象一层编译解释器，于是有了pascal，fortran，C语言；
再对核心函数api进行封装形成开发包（Development Kit), 于是有了Java，C++ 。

从面向过程到面向对象，再到设计模式，架构设计，面向服务，Sass/Pass/Iass等等的思想，各种软件理论思想五花八门，但万变不离其宗——

- 你要解决一个怎样的问题？
- 你的问题领域是怎样的？
- 你的模型（数据结构）是什么？
- 你的算法是什么？
- 你对这个世界的本质认知是怎样的？
- 你的业务领域的逻辑问题，流程是什么？
等等。

> Grady Booch：我对OO编程的目标从来就不是复用。相反，对我来说，对象提供了一种处理复杂性的方式。这个问题可以追溯到亚里士多德：您把这个世界视为过程还是对象？在OO兴起运动之前，编程以过程为中心--例如结构化设计方法。然而，系统已经到达了超越其处理能力的复杂性极点。有了对象，我们能够通过提升抽象级别来构建更大的、更复杂的系统--我认为，这才是面向对象编程运动的真正胜利。


最初， 人们使用物理的或逻辑的二进制机器指令来编写程序， 尝试着表达思想中的逻辑， 控制硬件计算和显示， 发现是可行的；

接着， 创造了助记符 —— 汇编语言， 比机器指令更容易记忆；

再接着， 创造了编译器、解释器和计算机高级语言， 能够以人类友好自然的方式去编写程序， 在牺牲少量性能的情况下， 获得比汇编语言更强且更容易使用的语句控制能力：条件、分支、循环， 以及更多的语言特性： 指针、结构体、联合体、枚举等， 还创造了函数， 能够将一系列指令封装成一个独立的逻辑块反复使用；

逐渐地，产生了面向过程的编程方法；

后来， 人们发现将数据和逻辑封装成对象， 更接近于现实世界， 且更容易维护大型软件， 又出现了面向对象的编程语言和编程方法学， 增加了新的语言特性： 继承、 多态、 模板、 异常错误。

为了不必重复开发常见工具和任务， 人们创造和封装了容器及算法、SDK， 垃圾回收器， 甚至是并发库；

为了让计算机语言更有力更有效率地表达各种现实逻辑， 消解软件开发中遇到的冲突， 还在语言中支持了元编程、 高阶函数， 闭包 等有用特性。

为了更高效率地开发可靠的软件和应用程序， 人们逐渐构建了代码编辑器、 IDE、 代码版本管理工具、公共库、应用框架、 可复用组件、系统规范、网络协议、 语言标准等， 针对遇到的问题提出了许多不同的思路和解决方案， 并总结提炼成特定的技术和设计模式， 还探讨和形成了不少软件开发过程， 用来保证最终发布的软件质量。 尽管编写的这些软件和工具还存在不少 BUG ，但是它们都“奇迹般地存活”， 并共同构建了今天蔚为壮观的互联网时代的电商，互联网金融，云计算，大数据，物联网，机器智能等等的“虚拟世界”。

### 7.1.2 二进制01与易经阴阳


二进制数是用0和1两个数码来表示的数。它的基数为2，进位规则是“逢二进一”，借位规则是“借一当二”，由18世纪德国数理哲学大师莱布尼兹发现。当前的计算机系统使用的基本上是二进制系统。

19世纪爱尔兰逻辑学家B对逻辑命题的思考过程转化为对符号0，1的某种代数演算，二进制是逢2进位的进位制。0、1是基本算符。因为它只使用0、1两个数字符号，非常简单方便，易于用电子方式实现。

二进制的发现直接导致了电子计算器和计算机的发明，并让计算机得到了迅速的普及，进入各行各业，成为人类生活和生产的重要工具。

二进制的实质是通过两个数字“0”和“1”来描述事件。在人类的生产、生活等许多领域，我们可以通过计算机来虚拟地描述现实中存在的事件，并能通过给定的条件和参数模拟事件变化的规律。二进制的计算机几乎是万能的，能将我们生活的现实世界完美复制，并且还能根据我们人类给定的条件模拟在现实世界难以实现的各种实验。

但是，不论计算机能给我们如何多变、如何完美、如何复杂的画面，其本源只是简单的“0”和“1”。“0”和“1”在计算机中通过不同的组合与再组合，模拟出一个纷繁复杂、包罗万象的虚拟世界。我们简单图示如下：


![螢幕快照 2017-07-01 10.38.22.png](http://upload-images.jianshu.io/upload_images/1233356-c1a1e595ce1b98e1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


二进制的“0”和“1”通过计算机里能够创造出一个虚拟的、纷繁的世界。自然界中的阴阳形成了现实世界的万事万物。

所以自然世界的“阴”“阳”作为基础切实地造就了复杂的现实世界，计算机的“0”和“1”形象地模拟现实世界的一切现象，易学中的“卦”和“阴阳爻”抽象地揭示了自然界存在的事件和其变化规律。

所以说，编程的本质跟大自然创造万物的本质是一样的。



### 7.1.3 从面向过程到面向对象

从IBM公司的约翰·巴库斯在1957年开发出世界上第一个高级程序设计语言Fortran至今，高级程序设计语言的发展已经经历了整整半个世纪。在这期间，程序设计语言主要经历了从面向过程（如C和Pascal语言）到面向对象（如C++和Java语言），再到面向组件编程（如.NET平台下的C#语言），以及面向服务架构技术（如SOA、Service以及最近很火的微服务架构）等。



#### 面向过程编程

> 结构化编程思想的核心：功能分解（自顶向下，逐层细化）。


1971年4月份的 Communications of ACM上，尼古拉斯·沃斯（Niklaus Wirth，1934年2月15日—, 结构化编程思想的创始人。因发明了Euler、Alogo-W、Modula和Pascal等一系列优秀的编程语言并提出了结构化编程思想而在1984年获得了图灵奖。）发表了论文“通过逐步求精方式开发程序’（Program Development by Stepwise Refinement），首次提出“结构化程序设计”（structure programming）的概念。

不要求一步就编制成可执行的程序，而是分若干步进行，逐步求精。

第一步编出的程序抽象度最高，第二步编出的程序抽象度有所降低…… 最后一步编出的程序即为可执行的程序。

用这种方法编程，似乎复杂，实际上优点很多，可使程序易读、易写、易调试、易维护、易保证其正确性及验证其正确性。

结构化程序设计方法又称为“自顶向下”或“逐步求精”法，在程序设计领域引发了一场革命，成为程序开发的一个标准方法，尤其是在后来发展起来的软件工程中获得广泛应用。有人评价说Wirth的结构化程序设计概念“完全改变了人们对程序设计的思维方式”，这是一点也不夸张的。

尼古拉斯· 沃思教授在编程界提出了一个著名的公式：

> 程序 = 数据结构 + 算法



 



#### 面向对象编程

> 面向对象编程思想的核心：应对变化，提高复用。

阿伦·凯（Alan Kay）：面向对象编程思想的创始人。2003年因在面向对象编程上所做的巨大贡献而获得图灵奖。

> The best way to predict the future is to invent it，预测未来最好的方法是创造它！（Alan Kay）

阿伦·凯是Smalltalk面向对象编程语言的发明人之一，也是面向对象编程思想的创始人之一，同时，他还是笔记本电脑最早的构想者和现代Windows GUI的建筑师。最早提出PC概念和互联网的也是阿伦·凯，所以人们都尊称他为“预言大师”。他是当今IT界屈指可数的技术天才级人物。

面向对象编程思想主要是复用性和灵活性（弹性）。复用性是面向对象编程的一个主要机制。灵活性主要是应对变化的特性，因为客户的需求是不断改变的，怎样适应客户需求的变化，这是软件设计灵活性或者说是弹性的问题。
 
Java是一种面向对象编程语言，它基于Smalltalk语言，作为OOP语言，它具有以下五个基本特性：

1.万物皆对象，每一个对象都会存储数据，并且可以对自身执行操作。因此，每一个对象包含两部分：成员变量和成员方法。在成员方法中可以改变成员变量的值。

2.程序是对象的集合，他们通过发送消息来告知彼此所要做的事情，也就是调用相应的成员函数。

3.每一个对象都有自己的由其他对象所构成的存储，也就是说在创建新对象的时候可以在成员变量中使用已存在的对象。

4.每个对象都拥有其类型，每个对象都是某个类的一个实例，每一个类区别于其它类的特性就是可以向它发送什么类型的消息，也就是它定义了哪些成员函数。

5.某一个特定类型的所有对象都可以接受同样的消息。另一种对对象的描述为：对象具有状态(数据，成员变量)、行为(操作，成员方法)和标识(成员名，内存地址)。

面向对象语言其实是对现实生活中的实物的抽象。

每个对象能够接受的请求(消息)由对象的接口所定义，而在程序中必须由满足这些请求的代码，这段代码称之为这个接口的实现。当向某个对象发送消息(请求)时，这个对象便知道该消息的目的(该方法的实现已定义)，然后执行相应的代码。



我们经常说一些代码片段是优雅的或美观的，实际上意味着它们更容易被人类有限的思维所处理。

对于程序的复合而言，好的代码是它的表面积要比体积增长的慢。

代码块的“表面积”是是我们复合代码块时所需要的信息（接口API协议定义）。代码块的“体积”就是接口内部的实现逻辑（API背后的实现代码）。

在面向对象编程中，一个理想的对象应该是只暴露它的抽象接口（纯表面， 无体积），其方法则扮演箭头的角色。如果为了理解一个对象如何与其他对象进行复合，当你发现不得不深入挖掘对象的实现之时，此时你所用的编程范式的原本优势就荡然无存了。



#### 面向组件和面向服务
 
- 面向组件

我们知道面向对象支持重用，但是重用的单元很小，一般是类；而面向组件则不同，它可以重用多个类甚至一个程序。也就是说面向组件支持更大范围内的重用，开发效率更高。如果把面向对象比作重用零件，那么面向组件则是重用部件。
 
 
- 面向服务

将系统进行功能化，每个功能提供一种服务。现在非常流行微服务MicroService技术以及SOA（面向服务架构）技术。
 
> 面向过程（Procedure）→面向对象（Object）→ 面向组件（Component） →面向服务（Service）



正如解决数学问题通常我们会谈“思想”，诸如反证法、化繁为简等，解决计算机问题也有很多非常出色的思想。思想之所以称为思想，是因为“思想”有拓展性与引导性，可以解决一系列问题。

解决问题的复杂程度直接取决于抽象的种类及质量。过将结构、性质不同的底层实现进行封装，向上提供统一的API接口，让使用者觉得就是在使用一个统一的资源，或者让使用者觉得自己在使用一个本来底层不直接提供、“虚拟”出来的资源。

计算机中的所有问题 , 都可以通过向上抽象封装一层来解决。同样的,任何复杂的问题, 最终总能够回归最本质,最简单。



面向对象编程是一种自顶向下的程序设计方法。万事万物都是对象,对象有其行为(方法),状态(成员变量,属性)。OOP是一种编程思想，而不是针对某个语言而言的。当然，语言影响思维方式，思维依赖语言的表达，这也是辩证的来看。

所谓“面向对象语言”，其实经典的“过程式语言”（比如Pascal，C），也能体现面向对象的思想。所谓“类”和“对象”，就是C语言里面的抽象数据类型结构体（struct）。

而面向对象的多态是唯一相比struct多付出的代价，也是最重要的特性。这就是SmallTalk、Java这样的面向对象语言所提供的特性。

回到一个古老的话题：程序是什么？

在面向对象的编程世界里，下面的这个公式

> 程序 = 算法 + 数据结构

可以简单重构成：

> 程序 = 基于对象操作的算法 + 以对象为最小单位的数据结构


封装总是为了减少操作粒度，数据结构上的封装导致了数据的减少，自然减少了问题求解的复杂度；对代码的封装使得代码得以复用，减少了代码的体积，同样使问题简化。这个时候，算法操作的就是一个抽象概念的集合。

在面向对象的程序设计中，我们便少不了集合类容器。容器就用来存放一类有共同抽象概念的东西。这里说有共同概念的东西（而没有说对象），其实，就是我们上一个章节中讲到的泛型。这样对于一个通用的算法，我们就可以最大化的实现复用，作用于的集合。

面向对象的本质就是让对象有多态性，把不同对象以同一特性来归组，统一处理。至于所谓继承、虚表、等等概念，只是其实现的细节。


在遵循这些面向对象设计原则基础上，前辈们总结出一些解决不同问题场景的设计模式，以GOF的23中设计模式最为知名。

我们用一幅图简单概括一下面向对象编程的知识框架：


![螢幕快照 2017-07-01 11.29.07.png](http://upload-images.jianshu.io/upload_images/1233356-a30d72d7ab57d7cd.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

讲了这么多思考性的思想层面的东西，我们下面来开始Kotlin的面向对象编程的学习。Kotlin对面向对象编程是完全支持的。




## 7.2 类与构造函数


Kotlin和Java很相似，也是一种面向对象的语言。下面我们来一起学习Kotlin的面向对象的特性。如果您熟悉Java或者C++、C#中的类，您可以很快上手。同时，您也将看到Kotlin与Java中的面向对象编程的一些不同的特性。

Kotlin中的类和接口跟Java中对应的概念有些不同，比如接口可以包含属性声明；Kotlin的类声明，默认是final和public的。

另外，嵌套类并不是默认在内部的。它们不包含外部类的隐式引用。

在构造函数方面，Kotlin简短的主构造函数在大多数情况下都可以满足使用，当然如果有稍微复杂的初始化逻辑，我们也可以声明次级构造函数来完成。

我们还可以使用 data 修饰符来声明一个数据类，使用 object 关键字来表示单例对象、伴生对象等。

Kotlin类的成员可以包含：

- 构造函数和初始化块
- 属性
- 函数
- 嵌套类和内部类
- 对象声明

等。


### 7.2.1 声明类

和大部分语言类似，Kotlin使用class作为类的关键字，当我们声明一个类时，直接通过class加类名的方式来实现：

```
class World
```
这样我们就声明了一个World类。


### 7.2.2 构造函数

在 Kotlin 中，一个类可以有一个

- 主构造函数（primary constructor）和一个或多个
- 次构造函数（secondary constructor）。


#### 主构造函数

主构造函数是类头的一部分，直接放在类名后面：

```
open class Student constructor(var name: String, var age: Int) : Any() {
...
}

```

如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：

```

annotation class MyAutowired

class ElementaryStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {
...
}

```


与普通属性一样，主构造函数中声明的属性可以是可变的（var）或只读的（val）。

主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中：

```
open class Student constructor(var name: String, var age: Int) : Any() {

    init {
        println("Student{name=$name, age=$age} created!")
    }
   ...

}

```

主构造的参数可以在初始化块中使用,也可以在类体内声明的属性初始化器中使用。


#### 次构造函数

在类体中，我们也可以声明前缀有 constructor的次构造函数，次构造函数不能有声明 val 或 var ：

```
class MiddleSchoolStudent {
    constructor(name: String, age: Int) {
    }
}
```



如果类有一个主构造函数，那么每个次构造函数需要委托给主构造函数， 委托到同一个类的另一个构造函数用 this 关键字即可：

```
class ElementarySchoolStudent public @MyAutowired constructor(name: String, age: Int) : Student(name, age) {
    override var weight: Float = 80.0f

    constructor(name: String, age: Int, weight: Float) : this(name, age) {
        this.weight = weight
    }

    ...
}
```
如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。构造函数的可见性是 public。


#### 私有主构造函数

我们如果希望这个构造函数是私有的，我们可以如下声明：

```
class DontCreateMe private constructor() {
}
```
这样我们在代码中，就无法直接使用主构造函数来实例化这个类，下面的写法是不允许的：

```
val dontCreateMe = DontCreateMe() // cannot access it
```

但是，我们可以通过次构造函数引用这个私有主构造函数来实例化对象：




### 7.2.2 类的属性

我们再给这个World类加入两个属性。我们可能直接简单地写成：

```
class World1 {
    val yin: Int
    val yang: Int
}

```
在Kotlin中，直接这样写语法上是会报错的：


![螢幕快照 2017-07-02 01.22.34.png](http://upload-images.jianshu.io/upload_images/1233356-bd68eec208cf93ca.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


意思很明显，是说这个类的属性必须要初始化，或者如果不初始化那就得是抽象的abstract属性。

我们把这两个属性都给初始化如下：

```
class World1 {
    val yin: Int = 0
    val yang: Int = 1
}
```

我们再来使用测试代码来看下访问这两个属性的方式：
```
>>> class World1 {
...     val yin: Int = 0
...     val yang: Int = 1
... }
>>> val w1 = World1()
>>> w1.yin
0
>>> w1.yang
1
```

上面的World1类的代码，在Java中等价的写法是：

```
public final class World1 {
   private final int yin;
   private final int yang = 1;

   public final int getYin() {
      return this.yin;
   }

   public final int getYang() {
      return this.yang;
   }
}
```

我们可以看出，Kotlin中的类的字段自动带有getter方法和setter方法。而且写起来比Java要简洁的多。


### 7.2.3 函数（方法）

我们再来给这个World1类中加上一个函数：

```
class World2 {
    val yin: Int = 0
    val yang: Int = 1

    fun plus(): Int {
        return yin + yang
    }
}


val w2 = World2()
println(w2.plus()) // 输出 1

```





## 7.3 抽象类

### 7.3.1 抽象类的定义

含有抽象函数的类(这样的类需要使用abstract修饰符来声明)，称为抽象类。

下面是一个抽象类的例子：

```
abstract class Person(var name: String, var age: Int) : Any() {

    abstract var addr: String
    abstract val weight: Float

    abstract fun doEat()
    abstract fun doWalk()

    fun doSwim() {
        println("I am Swimming ... ")
    }

    open fun doSleep() {
        println("I am Sleeping ... ")
    }
}
```


### 7.3.2 抽象函数

在上面的这个抽象类中，不仅可以有抽象函数`abstract fun doEat()` `abstract fun doWalk()`，同时可以有具体实现的函数`fun doSwim()`， 这个函数默认是final的。也就是说，我们不能重写这个doSwim函数：


![螢幕快照 2017-07-02 14.02.27.png](http://upload-images.jianshu.io/upload_images/1233356-7257fda9702bb64c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


如果一个函数想要设计成能被重写，例如`fun doSleep()`,我们给它加上open关键字即可。然后，我们就可以在子类中重写这个`open fun doSleep()`:

```
class Teacher(name: String, age: Int) : Person(name, age) {
    override var addr: String = "HangZhou"
    override val weight: Float = 100.0f

    override fun doEat() {
        println("Teacher is Eating ... ")
    }

    override fun doWalk() {
        println("Teacher is Walking ... ")
    }

    override fun doSleep() {
        super.doSleep()
        println("Teacher is Sleeping ... ")
    }

//    override fun doSwim() { // cannot be overriden
//        println("Teacher is Swimming ... ")
//    }
}
```

抽象函数是一种特殊的函数：它只有声明，而没有具体的实现。抽象函数的声明格式为：

```
abstract fun doEat()
```

关于抽象函数的特征，我们简单总结如下：

- 抽象函数必须用abstract关键字进行修饰
- 抽象函数不用手动添加open，默认被open修饰
- 抽象函数没有具体的实现
- 含有抽象函数的类成为抽象类，必须由abtract关键字修饰。抽象类中可以有具体实现的函数，这样的函数默认是final（不能被覆盖重写），如果想要重写这个函数，给这个函数加上open关键字。



### 7.3.3  抽象属性

抽象属性就是在var或val前被abstract修饰，抽象属性的声明格式为：
```
abstract var addr : String
abstract val weight : Float
```
关于抽象属性，需要注意的是：

1. 抽象属相在抽象类中不能被初始化 
2. 如果在子类中没有主构造函数，要对抽象属性手动初始化。如果子类中有主构造函数，抽象属性可以在主构造函数中声明。


综上所述，抽象类和普通类的区别有：

1.抽象函数必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。

也就是说，这三个函数
```
    abstract fun doEat()
    abstract fun doWalk()

    fun doSwim() {
        println("I am Swimming ... ")
    }
```

默认的都是public的。

另外抽象类中的具体实现的函数，默认是final的。上面的三个函数，等价的Java的代码如下：

```
   public abstract void doEat();

   public abstract void doWalk();

   public final void doSwim() {
      String var1 = "I am Swimming ... ";
      System.out.println(var1);
   }
```

2.抽象类不能用来创建对象实例。也就是说，下面的写法编译器是不允许的：


![螢幕快照 2017-07-02 13.24.58.png](http://upload-images.jianshu.io/upload_images/1233356-efc802307edad040.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


3.如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。实现父类抽象函数，我们使用override关键字来表明是重写函数：

```
class Programmer(override var addr: String, override val weight: Float, name: String, age: Int) : Person(name, age) {
    override fun doEat() {
        println("Programmer is Eating ... ")
    }

    override fun doWalk() {
        println("Programmer is Walking ... ")
    }
}
```





如果子类没有实现父类的抽象函数，则必须将子类也定义为为abstract类。例如：

```
abstract class Writer(override var addr: String, override val weight: Float, name: String, age: Int) : Person(name, age) {
    override fun doEat() {
        println("Programmer is Eating ... ")
    }

    abstract override fun doWalk();
}
```

doWalk函数没有实现父类的抽象函数，那么我们在子类中把它依然定义为抽象函数。相应地这个子类，也成为了抽象子类，需要使用abstract关键字来声明。


如果抽象类中含有抽象属性，再实现子类中必须将抽象属性初始化，除非子类也为抽象类。例如我们声明一个Teacher类继承Person类：
```
class Teacher(name: String, age: Int) : Person(name, age) {
    override var addr: String //  error， 需要初始化，或者声明为abstract
    override val weight: Float //  error， 需要初始化，或者声明为abstract
    ...
}
```

这样写，编译器会直接报错：

![螢幕快照 2017-07-02 13.29.25.png](http://upload-images.jianshu.io/upload_images/1233356-fd6f920de969ab61.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

解决方法是，在实现的子类中，我们将抽象属性初始化即可：
```
class Teacher(name: String, age: Int) : Person(name, age) {
    override var addr: String = "HangZhou"
    override val weight: Float = 100.0f

    override fun doEat() {
        println("Teacher is Eating ... ")
    }

    override fun doWalk() {
        println("Teacher is Walking ... ")
    }
}

```



## 7.4 接口

### 7.4.1 接口定义

和Java类似，Kotlin使用interface作为接口的关键词：

```
interface ProjectService
```

Kotlin 的接口与 Java 8 的接口类似。与抽象类相比，他们都可以包含抽象的方法以及方法的实现:

```
interface ProjectService {
    val name: String
    val owner: String
    fun save(project: Project)
    fun print() {
        println("I am project")
    }
}
```


### 7.4.2 实现接口

接口是没有构造函数的。我们使用冒号`:` 语法来实现一个接口，如果有多个用`，`逗号隔开：
```
class ProjectServiceImpl : ProjectService
class ProjectMilestoneServiceImpl : ProjectService, MilestoneService
```

我们也可以实现多个接口：

```
class Project

class Milestone

interface ProjectService {
    val name: String
    val owner: String
    fun save(project: Project)
    fun print() {
        println("I am project")
    }
}

interface MilestoneService {
    val name: String
    fun save(milestone: Milestone)
    fun print() {
        println("I am Milestone")
    }
}

class ProjectMilestoneServiceImpl : ProjectService, MilestoneService {
    override val name: String
        get() = "ProjectMilestone"
    override val owner: String
        get() = "Jack"

    override fun save(project: Project) {
        println("Save Project")
    }

    override fun print() {
//        super.print()
        super<ProjectService>.print()
        super<MilestoneService>.print()
    }

    override fun save(milestone: Milestone) {
        println("Save Milestone")
    }
}
```



当子类继承了某个类之后，便可以使用父类中的成员变量，但是并不是完全继承父类的所有成员变量。具体的原则如下：

1.能够继承父类的public和protected成员变量；不能够继承父类的private成员变量；

2.对于父类的包访问权限成员变量，如果子类和父类在同一个包下，则子类能够继承；否则，子类不能够继承；

3.对于子类可以继承的父类成员变量，如果在子类中出现了同名称的成员变量，则会发生隐藏现象，即子类的成员变量会屏蔽掉父类的同名成员变量。如果要在子类中访问父类中同名成员变量，需要使用super关键字来进行引用。



### 7.4.3 覆盖冲突

在kotlin中， 实现继承通常遵循如下规则：如果一个类从它的直接父类继承了同一个函数的多个实现，那么它必须重写这个函数并且提供自己的实现(或许只是直接用了继承来的实现) 为表示使用父类中提供的方法我们用 super 表示。


在重写`print()`时，因为我们实现的ProjectService、MilestoneService都有一个`print()`函数，当我们直接使用`super.print()`时，编译器是无法知道我们想要调用的是那个里面的print函数的，这个我们叫做覆盖冲突：


![螢幕快照 2017-07-02 15.36.20.png](http://upload-images.jianshu.io/upload_images/1233356-f5c09fb60ed60477.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



这个时候，我们可以使用下面的语法来调用：

```
        super<ProjectService>.print()
        super<MilestoneService>.print()
```


### 7.4.4 接口中的属性

在接口中声明的属性，可以是抽象的，或者是提供访问器的实现。

在企业应用中，大多数的类型都是无状态的，如：Controller、ApplicationService、DomainService、Repository等。

因为接口没有状态， 所以它的属性是无状态的。

``` kotlin

interface MilestoneService {
    val name: String // 抽象的
    val owner: String get() = "Jack" // 访问器

    fun save(milestone: Milestone)
    fun print() {
        println("I am Milestone")
    }
}


class MilestoneServiceImpl : MilestoneService {
    override val name: String
        get() = "MilestoneServiceImpl name"
    

    override fun save(milestone: Milestone) {
        println("save Milestone")
    }
}
```

### 7.5 抽象类和接口的差异

#### 概念上的区别

接口主要是对动作的抽象，定义了行为特性的规约。
抽象类是对根源的抽象。当你关注一个事物的本质的时候，用抽象类；当你关注一个操作的时候，用接口。



#### 语法层面上的区别

接口不能保存状态，可以有属性但必须是抽象的。
一个类只能继承一个抽象类，而一个类却可以实现多个接口。

类如果要实现一个接口，它必须要实现接口声明的所有方法。但是，类可以不实现抽象类声明的所有方法，当然，在这种情况下，类也必须得声明成是抽象的。

接口中所有的方法隐含的都是抽象的。而抽象类则可以同时包含抽象和非抽象的方法。

#### 设计层面上的区别

抽象类是对一种事物的抽象，即对类抽象，而接口是对行为的抽象。抽象类是对整个类整体进行抽象，包括属性、行为，但是接口却是对类局部（行为）进行抽象。

继承是 `is a`的关系，而 接口实现则是 `has a` 的关系。如果一个类继承了某个抽象类，则子类必定是抽象类的种类，而接口实现就不需要有这层类型关系。

设计层面不同，抽象类作为很多子类的父类，它是一种模板式设计。而接口是一种行为规范，它是一种辐射式设计。也就是说：

- 对于抽象类，如果需要添加新的方法，可以直接在抽象类中添加具体的实现，子类可以不进行变更；

- 而对于接口则不行，如果接口进行了变更，则所有实现这个接口的类都必须进行相应的改动。


#### 实际应用上的差异

在实际使用中，使用抽象类(也就是继承)，是一种强耦合的设计，用来描述`A is a B` 的关系，即如果说A继承于B，那么在代码中将A当做B去使用应该完全没有问题。比如在Android中，各种控件都可以被当做View去处理。

如果在你设计中有两个类型的关系并不是`is a`，而是`is like a`，那就必须慎重考虑继承。因为一旦我们使用了继承，就要小心处理好子类跟父类的耦合依赖关系。组合优于继承。

## 7.6 继承

继承是面向对象编程的一个重要的方式，因为通过继承，子类就可以扩展父类的功能。

在Kotlin中，所有的类会默认继承Any这个父类，但Any并不完全等同于java中的Object类，因为它只有equals(),hashCode()和toString()这三个方法。

### 7.6.1 open类

除了抽象类、接口默认可以被继承（实现）外，我们也可以把一个类声明为open的，这样我们就可以继承这个open类。

当我们想定义一个父类时，需要使用open关键字:

```
open class Base{ 
} 
```
当然，抽象类是默认open的。

然后在子类中使用冒号`：`进行继承
```
class SubClass : Base(){ 
} 
```
如果父类有构造函数，那么必须在子类的主构造函数中进行继承，没有的话则可以选择主构造函数或二级构造函数
```
//父类 
open class Base(type:String){ 
  
} 
  
//子类 
class SubClass(type:String) : Base(type){ 
  
} 
```


Kotlin中的`override`重写和java中也有所不同，因为Kotlin提倡所有的操作都是明确的，因此需要将希望被重写的函数设为open: 
```
open fun doSomething() {} 
```
然后通过override标记实现重写
```
override fun doSomething() { 
 super.doSomething() 
 } 
```
同样的，抽象函数以及接口中定义的函数默认都是open的。

override重写的函数也是open的，如果希望它不被重写，可以在前面增加final :
```
open class SubClass : Base{ 
 constructor(type:String) : super(type){ 
 } 
  
 final override fun doSomething() { 
 super.doSomething() 
 } 
} 
```


### 7.6.2 多重继承

有些编程语言支持一个类拥有多个父类，例如C++。 我们将这个特性称之为多重继承（multiple inheritance）。多重继承会有二义性和钻石型继承树（DOD：Diamond Of Death）的复杂性问题。Kotlin跟Java一样，没有采用多继承，任何一个子类仅允许一个父类存在，而在多继承的问题场景下，使用实现多个interface 组合的方式来实现多继承的功能。

代码示例：

```
package com.easy.kotlin

/**
 * Created by jack on 2017/7/2.
 */

abstract class Animal {
    fun doEat() {
        println("Animal Eating")
    }
}


abstract class Plant {
    fun doEat() {
        println("Plant Eating")
    }
}


interface Runnable {
    fun doRun()
}

interface Flyable {
    fun doFly()
}

class Dog : Animal(), Runnable {
    override fun doRun() {
        println("Dog Running")
    }
}

class Eagle : Animal(), Flyable {
    override fun doFly() {
        println("Eagle Flying")
    }
}

// 始祖鸟, 能飞也能跑
class Archaeopteryx : Animal(), Runnable, Flyable {
    override fun doRun() {
        println("Archaeopteryx Running")
    }

    override fun doFly() {
        println("Archaeopteryx Flying")
    }

}

fun main(args: Array<String>) {
    val d = Dog()
    d.doEat()
    d.doRun()

    val e = Eagle()
    e.doEat()
    e.doFly()

    val a = Archaeopteryx()
    a.doEat()
    a.doFly()
    a.doRun()
}



```

上述代码类之间的关系，我们用图示如下：


![螢幕快照 2017-07-02 22.30.59.png](http://upload-images.jianshu.io/upload_images/1233356-e8d34b2d3cf01ac5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


我们可以看出，Archaeopteryx继承了Animal类，用了父类doEat()函数功能；实现了Runnable接口，拥有了doRun()函数规范；实现了Flyable接口，拥有了doFly()函数规范。

在这里，我们通过实现多个接口，组合完成了的多个功能，而不是设计多个层次的复杂的继承关系。



## 7.7 枚举类

Kotlin的枚举类定义如下：
```
public abstract class Enum<E : Enum<E>>(name: String, ordinal: Int): Comparable<E> {
    companion object {}

    public final val name: String
    public final val ordinal: Int

    public override final fun compareTo(other: E): Int
    protected final fun clone(): Any

    public override final fun equals(other: Any?): Boolean
    public override final fun hashCode(): Int
    public override fun toString(): String
}
```

我们可以看出，这个枚举类有两个属性：

```
    public final val name: String
    public final val ordinal: Int
```
分别表示的是枚举对象的值跟下标位置。

同时，我们可以看出枚举类还实现了Comparable<E>接口。

### 7.7.1 枚举类基本用法

枚举类的最基本的用法是实现类型安全的枚举：

``` kotlin
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

>>> val north = Direction.NORTH
>>> north.name
NORTH
>>> north.ordinal
0
>>> north is Direction
true

```
每个枚举常量都是一个对象。枚举常量用逗号分隔。

### 7.7.2 初始化枚举值

我们可以如下初始化枚举类的值：

``` kotlin
enum class Color(val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF)
}

>>> val red = Color.RED
>>> red.rgb
16711680


```

另外，枚举常量也可以声明自己的匿名类:

``` kotlin

enum class ActivtyLifeState {
    onCreate {
        override fun signal() = onStart
    },

    onStart {
        override fun signal() = onStop
    },

    onStop {
        override fun signal() = onStart
    },

    onDestroy {
        override fun signal() = onDestroy
    };

    abstract fun signal(): ActivtyLifeState
}

>>> val s = ActivtyLifeState.onCreate
>>> println(s.signal())
onStart

```



### 7.7.3 使用枚举常量

我们使用enumValues()函数来列出枚举的所有值：

```
@SinceKotlin("1.1")
public inline fun <reified T : Enum<T>> enumValues(): Array<T>
```

每个枚举常量，默认都`name`名称和`ordinal`位置的属性(这个跟Java的Enum类里面的类似)：

``` kotlin
val name: String
val ordinal: Int
```
代码示例：

```
enum class RGB { RED, GREEN, BLUE }

>>> val rgbs = enumValues<RGB>().joinToString { "${it.name} : ${it.ordinal} " }
>>> rgbs
RED : 0 , GREEN : 1 , BLUE : 2 

```
我们直接声明了一个简单枚举类，我们使用遍历函数` enumValues<RGB>()`列出了RGB枚举类的所有枚举值。使用`it.name` `it.ordinal`直接访问各个枚举值的名称和位置。

另外，我们也可以自定义枚举属性值：

```
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

>>> val colors = enumValues<Color>().joinToString { "${it.rgb} : ${it.name} : ${it.ordinal} " }
>>> colors
16711680 : RED : 0 , 65280 : GREEN : 1 , 255 : BLUE : 2 

```

然后，我们可以直接使用`it.rgb`访问属性名来得到对应的属性值。


## 7.8 注解类

Kotlin 的注解与 Java 的注解完全兼容。

### 7.8.1 声明注解
```
annotation class 注解名
```

代码示例：
```

@Target(AnnotationTarget.CLASS,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.EXPRESSION,
        AnnotationTarget.FIELD,
        AnnotationTarget.LOCAL_VARIABLE,
        AnnotationTarget.TYPE,
        AnnotationTarget.TYPEALIAS,
        AnnotationTarget.TYPE_PARAMETER,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MagicClass


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MagicFunction


@Target(AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
@Repeatable
annotation class MagicConstructor

```

在上面的代码中，我们通过向注解类添加元注解(meta-annotation)的方法来指定其他属性： 

- @Target ： 指定这个注解可被用于哪些元素(类, 函数, 属性, 表达式, 等等.); 
- @Retention ： 指定这个注解的信息是否被保存到编译后的 class 文件中, 以及在运行时是否可以通过反 
射访问到它； 
- @Repeatable：  允许在单个元素上多次使用同一个注解； 
- @MustBeDocumented ： 表示这个注解是公开 API 的一部分, 在自动产生的 API 文档的类或者函数签名中, 应该包含这个注解的信息。

这几个注解定义在`kotlin/annotation/Annotations.kt`类中。


### 7.8.2 使用注解

注解可以用在类、函数、参数、变量（成员变量、局部变量）、表达式、类型上等。这个由该注解的元注解@Target定义。

```
@MagicClass class Foo @MagicConstructor constructor() {

    constructor(index: Int) : this() {
        this.index = index
    }

    @MagicClass var index: Int = 0
    @MagicFunction fun magic(@MagicClass name: String) {

    }
}
```

注解在主构造器上，主构造器必须加上关键字 “constructor”

```
@MagicClass class Foo @MagicConstructor constructor() {
...
}
```



## 7.9 单例模式(Singleton)与伴生对象(companion object)

## 7.9.1 单例模式(Singleton)

单例模式很常用。它是一种常用的软件设计模式。例如，Spring中的Bean默认就是单例。通过单例模式可以保证系统中一个类只有一个实例。即一个类只有一个对象实例。

我们用Java实现一个简单的单例类的代码如下：
```
class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```
测试代码：

```
Singleton singleton1 = Singleton.getInstance();
```

可以看出，我们先在单例类中声明了一个私有静态的`Singleton instance`变量，然后声明一个私有构造函数`private Singleton() {}`, 这个私有构造函数使得外部无法直接通过new的方式来构建对象：

```
Singleton singleton2 = new Singleton(); //error, cannot private access
```


最后提供一个public的获取当前类的唯一实例的静态方法`getInstance()`。我们这里给出的是一个简单的单例类，是线程不安全的。

### 7.9.2 object对象


Kotlin中没有 **静态属性和方法**，但是也提供了实现**类似于单例的功能**，我们可以使用关键字 `object` 声明一个object对象:
```
object AdminUser {
    val username: String = "admin"
    val password: String = "admin"
    fun getTimestamp() = SimpleDateFormat("yyyyMMddHHmmss").format(Date())
    fun md5Password() = EncoderByMd5(password + getTimestamp())
}

```
测试代码：

```

    val adminUser = AdminUser.username
    val adminPassword = AdminUser.md5Password()
    println(adminUser)  // admin
    println(adminPassword)  // g+0yLfaPVYxUf6TMIdXFXw==，这个值具体运行时会变化

```


为了方便在REPL中演示说明，我们再写一个示例代码：
```
>>> object User {
...     val username: String = "admin"
...     val password: String = "admin"
... }
```

object对象只能通过对象名字来访问：

```
>>> User.username
admin
>>> User.password
admin
```

不能像下面这样使用构造函数：

```
>>> val u = User()
error: expression 'User' of type 'Line130.User' cannot be invoked as a function. The function 'invoke()' is not found
val u = User()
        ^

```

为了更加直观的了解object对象的概念，我们把上面的`object User`的代码反编译成Java代码：

```
public final class User {
   @NotNull
   private static final String username = "admin";
   @NotNull
   private static final String password = "admin";
   public static final User INSTANCE;

   @NotNull
   public final String getUsername() {
      return username;
   }

   @NotNull
   public final String getPassword() {
      return password;
   }

   private User() {
      INSTANCE = (User)this;
      username = "admin";
      password = "admin";
   }

   static {
      new User();
   }
}
```
从上面的反编译代码，我们可以直观了解Kotlin的object背后的一些原理。


### 7.9.3 嵌套（Nested）object对象

这个object对象还可以放到一个类里面：

```

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
}


```


测试代码：
```
DataProcessor.FileUtils.userHome // /Users/jack/
DataProcessor.FileUtils.getFileContent("test.data") // 输出文件的内容
```
同样的，我们只能通过类的名称来直接访问object，不能使用对象实例引用。下面的写法是错误的：
```
val dp = DataProcessor()
dp.FileUtils.userHome // error, Nested object FileUtils cannot access object via reference
```


我们在Java中通常会写一些Utils类，这样的类我们在Kotlin中就可以直接使用object对象：
```

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
```

测试代码：
```
    val url = "http://www.baidu.com"
    val html1 = HttpUtils.getSync(url) // 同步get
    println("html1=${html1}") 
    HttpUtils.getAsync(url) // 异步get
```

### 7.9.4 匿名object

还有，在代码行内，有时候我们需要的仅仅是一个简单的对象，我们这个时候就可以使用下面的匿名object的方式：
```
fun distance(x: Double, y: Double): Double {
    val porigin = object {
        var x = 0.0
        var y = 0.0
    }
    return Math.sqrt((x - porigin.x) * (x - porigin.x) + (y - porigin.y) * (y - porigin.y))
}
```
测试代码：
```
distance(3.0, 4.0)
```

需要注意的是，匿名对象只可以用在本地和私有作用域中声明的类型。代码示例：


```
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


fun main(args: Array<String>) {
    AnonymousObjectType().publicFoo().x // Unresolved reference 'x'
}
```


跟 Java 匿名内部类类似，object对象表达式中的代码可以访问来自包含它的作用域的变量（与 Java 不同的是，这不限于 final 变量）:

```
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
```

测试代码：
```
countCompare()

countCompare=1
[1, 4, 3, 7, 11, 9, 10, 20]
...
countCompare=17
[1, 3, 4, 7, 9, 10, 11, 20]
```


### 7.9.5 伴生对象(companion object)

Kotlin中还提供了 **伴生对象** ，用`companion object`关键字声明:

```
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
```
一个类只能有1个伴生对象。也就是是下面的写法是错误的：
```
class ClassA {
    companion object Factory {
        fun create(): ClassA = ClassA()
    }

    companion object Factory2 { // error, only 1 companion object is allowed per class
        fun create(): MyClass = MyClass()
    }
}
```

一个类的伴生对象默认引用名是Companion:

```
class ClassB {
    companion object {
        fun create(): ClassB = ClassB()
        fun get() = "Hi, I am CompanyB"
    }
}

```
我们可以直接像在Java静态类中使用静态方法一样使用一个类的伴生对象的函数，属性(但是在运行时，它们依旧是实体的实例成员)：

```
    ClassB.Companion.index
    ClassB.Companion.create()
    ClassB.Companion.get()
```
其中， Companion可以省略不写：

```
    ClassB.index
    ClassB.create()
    ClassB.get()
```

当然，我们也可以指定伴生对象的名称：

```
class ClassC {
    var index = 0
    fun get(index: Int): Int {
        return 0
    }

    companion object CompanyC {
        fun create(): ClassC = ClassC()
        fun get() = "Hi, I am CompanyC"
    }
}

```

测试代码：

```
    ClassC.index
    ClassC.create()// com.easy.kotli.ClassC@7440e464，具体运行值会变化
    ClassC.get() // Hi, I am CompanyC
    ClassC.CompanyC.index
    ClassC.CompanyC.create()
    ClassC.CompanyC.get()
```


伴生对象的初始化是在相应的类被加载解析时，与 Java 静态初始化器的语义相匹配。

即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员。而且，还可以实现接口：

```
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
```

测试代码：

```
    MyClass.create()  // "MyClass Created!"
    MyClass.Companion.create() // "MyClass Created!"


```


另外，如果想使用Java中的静态成员和静态方法的话，我们可以用：

**@JvmField**注解：生成与该属性相同的静态字段
**@JvmStatic注解**：在单例对象和伴生对象中生成对应的静态方法



## 7.10 sealed 密封类

### 7.10.1 为什么使用密封类

就像我们为什么要用enum类型一样，比如你有一个enum类型 MoneyUnit，定义了元、角、分这些单位。枚举就是为了控制住你所有要的情况是正确的，而不是用硬编码方式写成字符串“元”，“角”，“分”。

同样，sealed的目的类似，一个类之所以设计成sealed，就是为了限制类的继承结构，将一个值限制在有限集中的类型中，而不能有任何其他的类型。

在某种意义上，sealed类是枚举类的扩展：枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，而密封类的一个子类可以有可包含状态的多个实例。


### 7.10.1  声明密封类

要声明一个密封类，需要在类名前面添加 sealed 修饰符。密封类的所有子类都必须与密封类在同一个文件中声明（在 Kotlin 1.1 之前， 该规则更加严格：子类必须嵌套在密封类声明的内部）：

```

sealed class Expression

class Unit : Expression()
data class Const(val number: Double) : Expression()
data class Sum(val e1: Expression, val e2: Expression) : Expression()
data class Multiply(val e1: Expression, val e2: Expression) : Expression()
object NaN : Expression()


```

使用密封类的主要场景是在使用 when 表达式的时候，能够验证语句覆盖了所有情况，而无需再添加一个 else 子句：

```
fun eval(expr: Expression): Double = when (expr) {
    is Unit -> 1.0
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    is Multiply -> eval(expr.e1) * eval(expr.e2)
    NaN -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}
```

测试代码：

```
fun main(args: Array<String>) {
    val u = eval(Unit())
    val a = eval(Const(1.1))
    val b = eval(Sum(Const(1.0), Const(9.0)))
    val c = eval(Multiply(Const(10.0), Const(10.0)))
    println(u)
    println(a)
    println(b)
    println(c)
}


```

输出：

```
1.0
1.1
10.0
100.0
```

## 7.11 data 数据类

### 7.11.1 构造函数中的 `val/var`

在开始讲数据类之前，我们先来看一下几种类声明的写法。

写法一：
```
class Aook(name: String)
```
这样写，这个name变量是无法被外部访问到的。它对应的反编译之后的Java代码如下：
```
public final class Aook {
   public Aook(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
   }
}
```


写法二：
要想这个name变量被访问到，我们可以在类体中再声明一个变量，然后把这个构造函数中的参数赋值给它：

```
class Cook(name: String) {
    val name = name
}
```
测试代码：
```
    val cook = Cook("Cook")
    cook.name
```
对应的Java实现代码是：
```
public final class Cook {
   @NotNull
   private final String name;

   @NotNull
   public final String getName() {
      return this.name;
   }

   public Cook(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.name = name;
   }
}
```

写法三：
```
class Dook(val name: String)
class Eook(var name: String)
```

构造函数中带var、val修饰的变量，Kotlin编译器会自动为它们生成getter、setter函数。



上面的写法对应的Java代码就是：

```
public final class Dook {
   @NotNull
   private final String name;

   @NotNull
   public final String getName() {
      return this.name;
   }

   public Dook(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.name = name;
   }
}

public final class Eook {
   @NotNull
   private String name;

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final void setName(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.name = var1;
   }

   public Eook(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.name = name;
   }
}
```

测试代码：

```
    val dook = Dook("Dook")
    dook.name
    val eook = Eook("Eook")
    eook.name

```

下面我们来学习一下Kotlin中的数据类： `data class` 。


### 7.11.2  领域实体类

我们写Java代码的时候，会经常创建一些只保存数据的类。比如说：

- POJO类：POJO全称是Plain Ordinary Java Object / Pure Old Java Object，中文可以翻译成：普通Java类，具有一部分getter/setter方法的那种类就可以称作POJO。

- DTO类：Data Transfer Object，数据传输对象类，泛指用于展示层与服务层之间的数据传输对象。

- VO类：VO有两种说法,一个是ViewObject,一个是ValueObject。

- PO类：Persisent Object，持久对象。它们是由一组属性和属性的get和set方法组成。PO是在持久层所使用，用来封装原始数据。

- BO类：Business Object，业务对象层，表示应用程序领域内“事物”的所有实体类。

- DO类：Domain Object，领域对象，就是从现实世界中抽象出来的有形或无形的业务实体。

等等。

这些我们统称为领域模型中的实体类。最简单的实体类是POJO类，含有属性及属性对应的set和get方法，实体类常见的方法还有用于输出自身数据的toString方法。

### 7.11.3 数据类`data class`的概念

在 Kotlin 中，也有对应这样的领域实体类的概念，并在语言层面上做了支持，叫做数据类 ：

```
data class Book(val name: String)
data class Fook(var name: String)
data class User(
        val name: String,
        val gender: String,
        val age: Int
) {
    fun validate(): Boolean {
        return true
    }
}


```

这里的var/val是必须要带上的。因为编译器要把主构造函数中声明的所有属性，自动生成以下函数：

```
equals()/hashCode() 
toString() : 格式是 User(name=Jacky, gender=Male, age=10)
componentN() 函数 : 按声明顺序对应于所有属性component1()、component2() ...
copy() 函数
```

如果我们自定义了这些函数，或者继承父类重写了这些函数，编译器就不会再去生成。

测试代码：
```
    val book = Book("Book")
    book.name
    book.copy("Book2")

    val jack = User("Jack", "Male", 1)
    jack.name
    jack.gender
    jack.age
    jack.toString()
    jack.validate()


    val olderJack = jack.copy(age = 2)
    val anotherJack = jack.copy(name = "Jacky", age = 10)
```


在一些场景下，我们需要复制一个对象来改变它的部分属性，而其余部分保持不变。 copy() 函数就是为此而生成。例如上面的的 User 类的copy函数的使用：
```
    val olderJack = jack.copy(age = 2)
    val anotherJack = jack.copy(name = "Jacky", age = 10)
```

### 7.11.4 数据类的限制

数据类有以下的限制要求：

1.主构造函数需要至少有一个参数。下面的写法是错误的：
```
data class Gook // error, data class must have at least one primary constructor parameter
```


2.主构造函数的所有参数需要标记为 val 或 var；
```
data class Hook(name: String)// error, data class must have only var/val property
```

跟普通类一样，数据类也可以有次级构造函数：
```
data class LoginUser(val name: String = "", val password: String = "") : DBase(), IBaseA, IBaseB {

    var isActive = true

    constructor(name: String, password: String, isActive: Boolean) : this(name, password) {
        this.isActive = isActive
    }
    ...
}
```

3.数据类不能是抽象、开放、密封或者内部的。也就是说，下面的写法都是错误的：

```
abstract data class Iook(val name: String) // modifier abstract is incompatible with data
open data class Jook(val name: String) // modifier abstract is incompatible with data
sealed data class Kook(val name: String)// modifier sealed is incompatible with data
inner data class Look(val name: String)// modifier inner is incompatible with data

```
数据类只能是final的：
```
final data class Mook(val name: String) // modifier abstract is incompatible with data

```


4.在1.1之前数据类只能实现接口。自 1.1 起，数据类可以扩展其他类。代码示例：

```

open class DBase
interface IBaseA
interface IBaseB

data class LoginUser(val name: String, val password: String) : DBase(), IBaseA, IBaseB {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    fun validate(): Boolean {
        return true
    }
}
```

测试代码：

```
    val loginUser1 = LoginUser("Admin", "admin")
    println(loginUser1.component1())
    println(loginUser1.component2())
    println(loginUser1.name)
    println(loginUser1.password)
    println(loginUser1.toString())
```
输出：

```
Admin
admin
Admin
admin
com.easy.kotlin.LoginUser@7440e464
```
可以看出，由于我们重写了`override fun toString(): String`, 对应的输出使我们熟悉的类的输出格式。

如果我们不重写这个toString函数，则会默认输出：
```
LoginUser(name=Admin, password=admin)
```

上面的类声明的构造函数，要求我们每次必须初始化name、password的值，如果我们想拥有一个无参的构造函数，我们只要对所有的属性指定默认值即可：

```
data class LoginUser(val name: String = "", val password: String = "") : DBase(), IBaseA, IBaseB {
...
}
```

这样我们在创建对象的时候，就可以直接使用：

```
    val loginUser3 = LoginUser()
    loginUser3.name
    loginUser3.password
```




### 7.11.5 数据类的解构

解构相当于 Component 函数的逆向映射：

```
    val helen = User("Helen", "Female", 15)
    val (name, gender, age) = helen
    println("$name, $gender, $age years of age")
```

输出：

Helen, Female, 15 years of age


### 7.11.6 标准数据类`Pair` 和`Triple`

标准库中的二元组 Pair类就是一个数据类：
```
public data class Pair<out A, out B>(
        public val first: A,
        public val second: B) : Serializable {
    public override fun toString(): String = "($first, $second)"
}
``` 

Kotlin标准库中，对Pair类还增加了转换成List的扩展函数：
```
public fun <T> Pair<T, T>.toList(): List<T> = listOf(first, second)
```



还有三元组Triple类：

```
public data class Triple<out A, out B, out C>(
        public val first: A,
        public val second: B,
        public val third: C) : Serializable {
    public override fun toString(): String = "($first, $second, $third)"
}
 fun <T> Triple<T, T, T>.toList(): List<T> = listOf(first, second, third)

```


## 7.12 嵌套类（Nested Class）

## 7.12.1 嵌套类：类中的类 

类可以嵌套在其他类中，可以嵌套多层：

```
class NestedClassesDemo {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1

        class Nested {
            fun getTwo() = 2
            class Nested1 {
                val three = 3
                fun getFour() = 4
            }
        }
    }
}
```
测试代码：
```
    val one = NestedClassesDemo.Outer().one
    val two = NestedClassesDemo.Outer.Nested().getTwo()
    val three = NestedClassesDemo.Outer.Nested.Nested1().three
    val four = NestedClassesDemo.Outer.Nested.Nested1().getFour()
    println(one)
    println(two)
    println(three)
    println(four)
```

我们可以看出，访问嵌套类的方式是直接使用 `类名.`， 有多少层嵌套，就用多少层类名来访问。

普通的嵌套类，没有持有外部类的引用，所以是无法访问外部类的变量的：
```
class NestedClassesDemo {
class Outer {
        private val zero: Int = 0
        val one: Int = 1


        class Nested {
            fun getTwo() = 2

            fun accessOuter() = {
                println(zero) // error, cannot access outer class
                println(one)  // error, cannot access outer class
            }
        }
}
}
```

我们在Nested类中，访问不到Outer类中的变量zero，one。
如果想要访问到，我们只需要在Nested类前面加上`inner`关键字修饰，表明这是一个嵌套的内部类。




### 7.12.2 内部类（Inner Class）

类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：

```
class NestedClassesDemo {
class Outer {
        private val zero: Int = 0
        val one: Int = 1

        inner class Inner {
            fun accessOuter() = {
                println(zero) // works
                println(one) // works
            }

        }
}
```

测试代码：
```
val innerClass = NestedClassesDemo.Outer().Inner().accessOuter()
```
我们可以看到，当访问`inner class Inner`的时候，我们使用的是`Outer().Inner()`, 这是持有了Outer的对象引用。跟普通嵌套类直接使用类名访问的方式区分。

### 7.12.3 匿名内部类（Annonymous Inner Class）

匿名内部类，就是没有名字的内部类。既然是内部类，那么它自然也是可以访问外部类的变量的。

我们使用对象表达式创建一个匿名内部类实例：

```
class NestedClassesDemo {
class AnonymousInnerClassDemo {
            var isRunning = false
            fun doRun() {
                Thread(object : Runnable {
                    override fun run() {
                        isRunning = true
                        println("doRun : i am running, isRunning = $isRunning")
                    }
                }).start()
            }
}
}
```

如果对象是函数式 Java 接口，即具有单个抽象方法的 Java 接口的实例，例如上面的例子中的Runnable接口：

```
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
```

 我们可以使用lambda表达式创建它，下面的几种写法都是可以的：

```
            fun doStop() {
                var isRunning = true
                Thread({
                    isRunning = false
                    println("doStop: i am not running, isRunning = $isRunning")
                }).start()
            }

            fun doWait() {
                var isRunning = true

                val wait = Runnable {
                    isRunning = false
                    println("doWait: i am waiting, isRunning = $isRunning")
                }

                Thread(wait).start()
            }

            fun doNotify() {
                var isRunning = true

                val wait = {
                    isRunning = false
                    println("doNotify: i notify, isRunning = $isRunning")
                }

                Thread(wait).start()
            }
```

测试代码：

```
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doRun()
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doStop()
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doWait()
    NestedClassesDemo.Outer.AnonymousInnerClassDemo().doNotify()
```

输出：

doRun : i am running, isRunning = true
doStop: i am not running, isRunning = false
doWait: i am waiting, isRunning = false
doNotify: i notify, isRunning = false


关于lambda表达式以及函数式编程，我们将在下一章中学习。


## 7.13 委托(Delegation)

### 7.13.1 代理模式（Proxy Pattern）

代理模式，也称委托模式。

在代理模式中，有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。代理模式是一项基本技巧，许多其他的模式，如状态模式、策略模式、访问者模式本质上是在特殊的场合采用了代理模式。

代理模式使得我们可以用聚合来替代继承，它还使我们可以模拟mixin（混合类型）。委托模式的作用是将委托者与实际实现代码分离出来，以达成解耦的目的。

一个代理模式的Java代码示例：
```
package com.easy.kotlin;

/**
 * Created by jack on 2017/7/5.
 */
interface JSubject {
    public void request();
}

class JRealSubject implements JSubject {
    @Override
    public void request() {
        System.out.println("JRealSubject Requesting");
    }
}

class JProxy implements JSubject {
    private JSubject subject = null;

    //通过构造函数传递代理者
    public JProxy(JSubject sub) {
        this.subject = sub;
    }

    @Override
    public void request() { //实现接口中定义的方法
        this.before();
        this.subject.request();
        this.after();
    }

    private void before() {
        System.out.println("JProxy Before Requesting ");
    }

    private void after() {
        System.out.println("JProxy After Requesting ");
    }
}

public class DelegateDemo {
    public static void main(String[] args) {
        JRealSubject jRealSubject = new JRealSubject();
        JProxy jProxy = new JProxy(jRealSubject);
        jProxy.request();
    }
}

```
输出：

JProxy Before Requesting 
JRealSubject Requesting
JProxy After Requesting 

### 7.13.2 类的委托(Class Delegation)

就像支持单例模式的object对象一样，Kotlin 在语言层面原生支持委托模式。

代码示例：


```
package com.easy.kotlin

import java.util.*

/**
 * Created by jack on 2017/7/5.
 */

interface Subject {
    fun hello()
}

class RealSubject(val name: String) : Subject {
    override fun hello() {
        val now = Date()
        println("Hello, REAL $name! Now is $now")
    }
}

class ProxySubject(val sb: Subject) : Subject by sb {
    override fun hello() {
        println("Before ! Now is ${Date()}")
        sb.hello()
        println("After ! Now is ${Date()}")
    }
}

fun main(args: Array<String>) {
    val subject = RealSubject("World")
    subject.hello()
    println("-------------------------")
    val proxySubject = ProxySubject(subject)
    proxySubject.hello()
}

```

在这个例子中，委托代理类 ProxySubject 继承接口 Subject，并将其所有共有的方法委托给一个指定的对象sb :

```
class ProxySubject(val sb: Subject) : Subject by sb 
```


ProxySubject 的超类型Subject中的 `by sb` 表示sb 将会在 ProxySubject 中内部存储。 

另外，我们在覆盖重写了函数`override fun hello() `。

测试代码：

```
fun main(args: Array<String>) {
    val subject = RealSubject("World")
    subject.hello()
    println("-------------------------")
    val proxySubject = ProxySubject(subject)
    proxySubject.hello()
}
```

输出：

```
Hello, REAL World! Now is Wed Jul 05 02:45:42 CST 2017
-------------------------
Before ! Now is Wed Jul 05 02:45:42 CST 2017
Hello, REAL World! Now is Wed Jul 05 02:45:42 CST 2017
After ! Now is Wed Jul 05 02:45:42 CST 2017
```


### 7.13.3 委托属性 (Delegated Properties)

通常对于属性类型，我们是在每次需要的时候手动声明它们：
```
class NormalPropertiesDemo {
    var content: String = "NormalProperties init content"
}
```
那么这个content属性将会很“呆板”。属性委托赋予了属性富有变化的活力。

例如：

* 延迟属性（lazy properties）: 其值只在首次访问时计算
* 可观察属性（observable properties）: 监听器会收到有关此属性变更的通知
* 把多个属性储存在一个映射（map）中，而不是每个存在单独的字段中。


#### 委托属性

Kotlin 支持 _委托属性_:

``` kotlin
class DelegatePropertiesDemo {
    var content: String by Content()

    override fun toString(): String {
        return "DelegatePropertiesDemo Class"
    }
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        return "${delegatePropertiesDemo} property '${property.name}' = 'Balalala ... ' "
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        println("${delegatePropertiesDemo} property '${property.name}' is setting value: '$value'")
    }
}
```

在 `var content: String by Content()`中， `by` 后面的表达式的`Content()`就是该属性 _委托_的对象。content属性对应的 `get()`（和 `set()`）会被委托给`Content()`的 `operator fun getValue()` 和 `operator fun setValue()` 函数，这两个函数是必须的，而且得是操作符函数。

测试代码：

```
    val n = NormalPropertiesDemo()
    println(n.content)
    n.content = "Lao tze"
    println(n.content)

    val e = DelegatePropertiesDemo()
    println(e.content) // call Content.getValue
    e.content = "Confucius" // call Content.setValue
    println(e.content) // call Content.getValue
```
输出：

```
NormalProperties init content
Lao tze
DelegatePropertiesDemo Class property 'content' = 'Balalala ... ' 
DelegatePropertiesDemo Class property 'content' is setting value: 'Confucius'
DelegatePropertiesDemo Class property 'content' = 'Balalala ... 
```




#### 懒加载属性委托 lazy

lazy() 函数定义如下：

```
@kotlin.jvm.JvmVersion
public fun <T> lazy(initializer: () -> T): Lazy<T> = SynchronizedLazyImpl(initializer)

```
它接受一个 lambda 并返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现懒加载属性的委托： 

第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录下结果， 后续调用 get() 只是返回之前记录的结果。


代码示例：

```
    val synchronizedLazyImpl = lazy({
        println("lazyValueSynchronized1  3!")
        println("lazyValueSynchronized1  2!")
        println("lazyValueSynchronized1  1!")
        "Hello, lazyValueSynchronized1 ! "
    })

    val lazyValueSynchronized1: String by synchronizedLazyImpl
    println(lazyValueSynchronized1)
    println(lazyValueSynchronized1)

    val lazyValueSynchronized2: String by lazy {
        println("lazyValueSynchronized2  3!")
        println("lazyValueSynchronized2  2!")
        println("lazyValueSynchronized2  1!")
        "Hello, lazyValueSynchronized2 ! "
    }

    println(lazyValueSynchronized2)
    println(lazyValueSynchronized2)


```

输出：

```
lazyValueSynchronized1  3!
lazyValueSynchronized1  2!
lazyValueSynchronized1  1!
Hello, lazyValueSynchronized1 ! 
Hello, lazyValueSynchronized1 ! 


lazyValueSynchronized2  3!
lazyValueSynchronized2  2!
lazyValueSynchronized2  1!
Hello, lazyValueSynchronized2 ! 
Hello, lazyValueSynchronized2 ! 
```


默认情况下，对于 lazy 属性的求值是同步的（synchronized）, 下面两种写法是等价的：

```
    val synchronizedLazyImpl = lazy({
        println("lazyValueSynchronized1  3!")
        println("lazyValueSynchronized1  2!")
        println("lazyValueSynchronized1  1!")
        "Hello, lazyValueSynchronized1 ! "
    })
    
    val synchronizedLazyImpl2 = lazy(LazyThreadSafetyMode.SYNCHRONIZED, {
        println("lazyValueSynchronized1  3!")
        println("lazyValueSynchronized1  2!")
        println("lazyValueSynchronized1  1!")
        "Hello, lazyValueSynchronized1 ! "
    })
```
该值是线程安全的。所有线程会看到相同的值。


如果初始化委托多个线程可以同时执行，不需要同步锁，使用`LazyThreadSafetyMode.PUBLICATION`：
```
    val lazyValuePublication: String by lazy(LazyThreadSafetyMode.PUBLICATION, {
        println("lazyValuePublication 3!")
        println("lazyValuePublication 2!")
        println("lazyValuePublication 1!")
        "Hello, lazyValuePublication ! "
    })
```

 而如果属性的初始化是单线程的，那么我们使用 LazyThreadSafetyMode.NONE 模式(性能最高)：

```
    val lazyValueNone: String by lazy(LazyThreadSafetyMode.NONE, {
        println("lazyValueNone 3!")
        println("lazyValueNone 2!")
        println("lazyValueNone 1!")
        "Hello, lazyValueNone ! "
    })
```

#### Delegates.observable 可观察属性委托

我们把属性委托给`Delegates.observable`函数，当属性值被重新赋值的时候， 触发其中的回调函数 onChange。

该函数定义如下：
```
public inline fun <T> observable(initialValue: T, crossinline onChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Unit):
        ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {
            override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) = onChange(property, oldValue, newValue)
        }
```
代码示例：

```
class PostHierarchy {
    var level: String by Delegates.observable("P0",
            { property: KProperty<*>,
              oldValue: String,
              newValue: String ->
                println("$oldValue -> $newValue")
            })
}


```

测试代码：
```
    val ph = PostHierarchy()
    ph.level = "P1"
    ph.level = "P2"
    ph.level = "P3"
    println(ph.level) // P3
```

输出：
```
P0 -> P1
P1 -> P2
P2 -> P3
P3
```

我们可以看出，属性`level`每次赋值，都回调了`Delegates.observable`中的lambda表达式所写的`onChange`函数。

#### Delegates.vetoable 可否决属性委托

这个函数定义如下：
```
public inline fun <T> vetoable(initialValue: T, crossinline onChange: (property: KProperty<*>, oldValue: T, newValue: T) -> Boolean):
        ReadWriteProperty<Any?, T> = object : ObservableProperty<T>(initialValue) {
            override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean = onChange(property, oldValue, newValue)
        }
```

当我们把属性委托给这个函数时，我们可以通过`onChange`函数的返回值是否为true， 来选择属性的值是否需要改变。

代码示例:

```
class PostHierarchy {
    var grade: String by Delegates.vetoable("T0", {
        property, oldValue, newValue ->
        true
    })

    var notChangeGrade: String by Delegates.vetoable("T0", {
        property, oldValue, newValue ->
        false
    })
}
```

测试代码：
```
    ph.grade = "T1"
    ph.grade = "T2"
    ph.grade = "T3"
    println(ph.grade) // T3

    ph.notChangeGrade = "T1"
    ph.notChangeGrade = "T2"
    ph.notChangeGrade = "T3"
    println(ph.notChangeGrade) // T0
```
我们可以看出，当onChange函数返回值是false的时候，对属性notChangeGrade的赋值都没有生效，依然是原来的默认值T0 。

#### Delegates.notNull 非空属性委托

我们也可以使用委托来实现属性的非空限制：

```
var name: String by Delegates.notNull()
```

这样name属性就被限制为不能为null，如果被赋值null，编译器直接报错：

```
ph.name = null // error 
Null can not be a value of a non-null type String
```

#### 属性委托给Map映射

我们也可以把属性委托给Map：

```
class Account(val map: Map<String, Any?>) {
    val name: String by map
    val password: String by map
}
```

测试代码：

```
val account = Account(mapOf(
            "name" to "admin",
            "password" to "admin"
    ))

println("Account(name=${account.name}, password = ${account.password})")
```

输出：
```
Account(name=admin, password = admin)
```

如果是可变属性，这里也可以把只读的 Map 换成 MutableMap ：

```
class MutableAccount(val map: MutableMap<String, Any?>) {
    var name: String by map
    var password: String by map
}

```

测试代码：
```
val maccount = MutableAccount(mutableMapOf(
            "name" to "admin",
            "password" to "admin"
))

maccount.password = "root"
println("MutableAccount(name=${maccount.name}, password = ${maccount.password})")
```
输出：

```
MutableAccount(name=admin, password = root)
```

## 本章小结

本章我们介绍了Kotlin面向对象编程的特性： 类与构造函数、抽象类与接口、继承以及多重继承等基础知识，同时介绍了Kotlin中的注解类、枚举类、数据类、密封类、嵌套类、内部类、匿名内部类等特性类。最后我们学习了Kotlin中对单例模式、委托模式的语言层面上的内置支持：object对象、委托。

总的来说，Kotlin相比于Java的面向对象编程，增加不少有趣的功能与特性支持，这使得我们代码写起来更加方便快捷了。

我们知道，在Java 8 中，引进了对函数式编程的支持：Lambda表达式、Function接口、stream API等，而在Kotlin中，对函数式编程的支持更加全面丰富，代码写起来也更加简洁优雅。下一章中，我们来一起学习Kotlin的函数式编程。

本章示例代码工程：

https://github.com/EasyKotlin/chatper7_oop





