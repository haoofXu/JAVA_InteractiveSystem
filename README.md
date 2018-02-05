# JAVA_InteractiveSystem
Java，互动系统  
目的：  
获得设计具有实际重要性的互动系统的经验；加强你对标准java.util.ArrayList <E>类的了解；在Java中使用java.lang.Comparable <E>接口，继承和泛型类的经验。  
  
背景：  
有时我们希望按照排序顺序将这些项目保存在一个列表中，我们可以用a来实现排序列表。排序列表和未排序列表之间的根本区别在于“添加项目”/插入方法。为列表定义一个类，我们可以得到一个通过改变现有的或添加新的插入方法来排序列表类。  
  
任务一：  
从java.util.ArrayList <E>类中派生一个SortedArrayList <E>类，使得有序数组列表中的项按升序排序。 ArrayList <E>类的这个子类将需要完成任务2（参见下面的附加假设（2））。为了简单起见，您只能在SortedArrayList <E>类中提供新的插入方法。考虑到ArrayList <E>类的所有mutator方法，并不是这个项目的一部分，并且看看它们是否应该被重载，以确保排序后的列表在列表中被调用时保留它的顺序。  
任务二：  
你被要求写一个程序来帮助世界体育锦标赛售票处职员工作。您的程序应从文件中读取可用事件列表和注册客户端列表。输入文件的内容应该具有以下形式：第一行包含一个表示可用事件数量的整数，后面是有关事件的信息（每个事件两行：一行包含事件的名称和第二个包含可用于此事件的票数）。下一行包含一个整数，表示已注册客户的数量，后面是关于客户的信息（每个客户名字和姓氏的一行）。  
示例文件内容如下：
6  
Tennis  
8  
Athletics  
4  
Handball  
66  
Equestrian Jumping  
7  
Football  
2  
Volleyball  
41  
3  
Emma Williams  
Anna Smith  
John Williams  
