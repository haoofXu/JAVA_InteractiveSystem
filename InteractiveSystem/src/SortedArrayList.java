import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedArrayList<E> extends ArrayList<E> {
    // 保存ArrayList中数据的数组  
    private transient Object[] elementData;  
    // ArrayList中实际数据的数量  
    private int size;  
    // ArrayList带容量大小的构造函数。  
    public SortedArrayList(int initialCapacity) {  
        super();  
        if (initialCapacity < 0)  
            throw new IllegalArgumentException("Illegal Capacity: "+  
                                               initialCapacity);  
        // 新建一个数组  
        this.elementData = new Object[initialCapacity];  
    }  
    
    // ArrayList构造函数。默认容量是10。  
    public SortedArrayList() {  
        this(10);  
    }
    
	public boolean insert(E object, SortedArrayList<E> list){
		list.add(object);
		for(int i=0;i<list.size()-1;i++){
            for(int j=0;j<list.size()-i-1;j++){
                if(list.get(j).toString().compareTo(list.get(j+1).toString()) > 0){
                    /*交换*/
                    E temp=list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return true;
	}
}



