package Estructuras;

import java.util.EmptyStackException;

public class Stack<T> {

    protected Node<T> head;
        protected Node<T> tail;
        protected int size;

        public Stack()
        {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }


        public boolean empty()
        {
           return(size==0);
        }


        public T peek(){
            if(this.empty()){
                throw new EmptyStackException();
            }
            return(this.head.key);
        }

        public void push(T key){
            Node<T> node = new Node(key,head);
            this.head = node;
            if(tail==null){
                this.tail = head;
            }
            this.size++;
        }

        public T pop(){
            if(size==0){
                throw new EmptyStackException();
            }
            Node<T> oldHead = this.head;
            this.head = head.next;
            if(head==null){
                this.tail = null;
            }
            this.size--;
            return oldHead.key;
        }
}
