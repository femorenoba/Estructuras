package my.packages.Estructuras;


class Node <T> {
    T key;
    
    Node next;
    
    public Node(T key, Node next)
    {
        this.key = key;
        this.next = next;
    }
    
    public Node(T key)
    {
        this(key, null);
    }
    
    public Node()
    {
        this(null, null);
    }
}
