package com.ise.epic.DataStructures;

import java.util.*;

public class ArrayListImplementation<E> implements List<E> {

    // This is a method to check if the index is within bounds
    void inBounds(int i){
        if(i < 0 || i >= this.size){
            throw new IndexOutOfBoundsException();
        }
    }

    // An Array to store elements
    Object[] data;
    // variable to track number of elements in the ArrayList
    int size;
    public ArrayListImplementation(){
        this.data = new Object[1];
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < this.size; i++){
            if(o.equals(this.data[i])){
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator<E> iterator() {
        ArrayListImplementation<E> al = this;
        return new Iterator<E>() {
            ArrayListImplementation<E> l = al;
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < l.size;
            }

            @Override
            public E next() {
                return l.get(index++);
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        for(int i = 0; i < this.size; i++){
            arr[i] = this.data[i];
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        if(ts.length < this.size){
            return (T[]) this.toArray();
        }
        for(int i = 0; i < this.size; i++){
            ts[i] = (T) this.data[i];
        }
        return ts;
    }

    @Override
    public boolean add(E e) {
        if(this.size == this.data.length){
            Object[] newData = new Object[this.data.length  * 2];
            for(int i = 0; i < this.size; i++){
                newData[i] = this.data[i];
            }
            this.data = newData;
        }
        this.data[this.size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < this.size; i++){
            if(o.equals(this.data[i])){
                for(int j = i; j < this.size - 1; j++){
                    this.data[j] = this.data[j + 1];
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object o : collection){
            if(!this.contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for(E e : collection){
            this.add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        for(E e : collection){
            this.add(i++, e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for(Object o : collection){
            this.remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        for(int i = 0; i < this.size; i++){
            if(!collection.contains(this.data[i])){
                this.remove(this.data[i]);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public E get(int i) {
        inBounds(i);
        return (E) this.data[i];
    }

    @Override
    public E set(int i, E e) {
        inBounds(i);
        this.data[i] = e;
        return e;
    }

    @Override
    public void add(int i, E e) {
        if(this.size == this.data.length){
            Object[] newData = new Object[this.data.length * 2];
            for(int j = 0; j < this.size; j++){
                newData[j] = this.data[j];
            }
            this.data = newData;
        }
        for(int j = this.size; j > i; j--){
            this.data[j] = this.data[j - 1];
        }
        this.data[i] = e;
        this.size++;
    }

    @Override
    public E remove(int i) {
        inBounds(i);
        E e = (E) this.data[i];
        for(int j = i; j < this.size - 1; j++){
            this.data[j] = this.data[j + 1];
        }
        this.size--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < this.size; i++){
            if(o.equals(this.data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = this.size - 1; i >= 0; i--){
            if(o.equals(this.data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        ArrayListImplementation<E> al = this;
        return new ListIterator<E>() {
            ArrayListImplementation<E> l = al;
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < l.size;
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public E previous() {
                return l.get(index--);
            }

            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                l.remove(index);
            }

            @Override
            public void set(E e) {
                l.set(index, e);
            }

            @Override
            public void add(E e) {
                l.add(index, e);
            }

            @Override
            public E next() {
                return l.get(index++);
            }
        };
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        ArrayListImplementation<E> al = this;
        return new ListIterator<E>() {
            ArrayListImplementation<E> l = al;
            int index = i;
            @Override
            public boolean hasNext() {
                return index < l.size;
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public E previous() {
                return l.get(index--);
            }

            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                l.remove(index);
            }

            @Override
            public void set(E e) {
                l.set(index, e);
            }

            @Override
            public void add(E e) {
                l.add(index, e);
            }

            @Override
            public E next() {
                return l.get(index++);
            }
        };
    }

    @Override
    public List<E> subList(int i, int i1) {
        ArrayList<E> l = new ArrayList<>();
        for(int j = i; j < i1; j++){
            l.add(this.get(j));
        }
        return l;
    }
}