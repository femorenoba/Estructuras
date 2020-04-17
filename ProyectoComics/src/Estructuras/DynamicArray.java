package Estructuras;

public class DynamicArray<T>{

    protected Object[] array;
    protected int size;
    protected int capacity;
    
    public DynamicArray(){
        array = new Object[2];
        size = 0;
        capacity = 2;
    }
    
    public T get(int i){
        if(i >= size || i < 0) throw new IndexOutOfBoundsException("El número supera el tamaño del arreglo");
        return (T)array[i];
    }
    
    public void set(int i, T value){
         if(i >= size || i < 0) throw new IndexOutOfBoundsException("El número supera el tamaño del arreglo");
         array[i] = value;
    }
    
    public void pushBack(T value)
    {
        if(size == capacity){
            Object[] temp_array = new Object[capacity * 2];
            
            for(int i = 0; i < size; ++i){
                temp_array[i] = array[i];
            }
            array =  temp_array;
            capacity *=2;
                
        }
        array[size] = value;
        ++size;
        
    }
    
    public boolean pushBackCheck(T value) //Revisa si lo que quiere agregar ya existe o no
    {
        boolean existe = false;
        
        for(Object item: array){
            if(((T)item).equals(value)){
                existe = true;
                break;
            }
        }
        if(!existe) pushBack(value);
        
        return existe;
    }
    
    public void remove(int i){
        if(i >= size || i < 0) throw new IndexOutOfBoundsException("El número supera el tamaño del arreglo");
        
        for(int j = i; j < size - 1; ++j){
            array[j] = array[j+1];
        }
        --size;
    }
    
    public int getSize(){
        return size;
    }
}
