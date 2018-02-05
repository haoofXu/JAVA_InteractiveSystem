import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedArrayList<E> extends ArrayList<E> {
    // ����ArrayList�����ݵ�����  
    private transient Object[] elementData;  
    // ArrayList��ʵ�����ݵ�����  
    private int size;  
    // ArrayList��������С�Ĺ��캯����  
    public SortedArrayList(int initialCapacity) {  
        super();  
        if (initialCapacity < 0)  
            throw new IllegalArgumentException("Illegal Capacity: "+  
                                               initialCapacity);  
        // �½�һ������  
        this.elementData = new Object[initialCapacity];  
    }  
    
    // ArrayList���캯����Ĭ��������10��  
    public SortedArrayList() {  
        this(10);  
    }
    
	public boolean insert(E object, SortedArrayList<E> list){
		list.add(object);
		for(int i=0;i<list.size()-1;i++){
            for(int j=0;j<list.size()-i-1;j++){
                if(list.get(j).toString().compareTo(list.get(j+1).toString()) > 0){
                    /*����*/
                    E temp=list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return true;
	}
}



