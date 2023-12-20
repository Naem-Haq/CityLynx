package com.ise.epic.DataStructures;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListImplementationTest {

    @Test
    void testAdd() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    void testAddIndex() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0, 1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        list.add(0, 2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void testAddIndexOutOfBounds() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 1));
    }

    @Test
    void testAddResize() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        for(int i = 0; i < 100; i++){
            list.add(i);
        }
        assertEquals(100, list.size());
        for(int i = 0; i < 100; i++){
            assertEquals(i, list.get(i));
        }
    }

    @Test
    void testSet() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));

        list.set(1, 3);
        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    void testSetIndexOutOfBounds() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 1));
    }

    @Test
    void testRemove() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(3, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));

        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(0, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testRemoveIndexOutOfBounds() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testIndexOf() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(0, list.indexOf(0));
        assertEquals(1, list.indexOf(1));
        assertEquals(2, list.indexOf(2));
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    void testLastIndexOf() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(0, list.lastIndexOf(0));
        assertEquals(1, list.lastIndexOf(1));
        assertEquals(2, list.lastIndexOf(2));
        assertEquals(-1, list.lastIndexOf(3));
    }

    @Test
    void testGetIndexOutOfBounds() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testIterator() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        int i = 0;
        for(Integer item : list){
            assertEquals(i, item);
            i++;
        }
    }

    @Test
    void testContains() {
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    @Test
    void testToArray(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
        assertEquals(2, array[2]);
    }

    @Test
    void testToArrayWithArray(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        Integer[] array = new Integer[3];
        list.toArray(array);
        assertEquals(3, array.length);
        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
        assertEquals(2, array[2]);
    }

    @Test
    void testRemoveObject(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        assertTrue(list.remove((Integer) 1));
        assertEquals(2, list.size());
        assertEquals(0, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testContainsAll(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        ArrayListImplementation<Integer> list2 = new ArrayListImplementation<>();
        list2.add(0);
        list2.add(1);

        assertTrue(list.containsAll(list2));
    }

    @Test
    void testAddAll(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        ArrayListImplementation<Integer> list2 = new ArrayListImplementation<>();
        list2.add(3);
        list2.add(4);

        assertTrue(list.addAll(list2));
        assertEquals(5, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
        assertEquals(4, list.get(4));
    }

    @Test
    void testAddAllIndex(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        ArrayListImplementation<Integer> list2 = new ArrayListImplementation<>();
        list2.add(3);
        list2.add(4);

        assertTrue(list.addAll(1, list2));
        assertEquals(5, list.size());
        assertEquals(0, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(1, list.get(3));
        assertEquals(2, list.get(4));
    }

    @Test
    void testRemoveAll(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        ArrayListImplementation<Integer> list2 = new ArrayListImplementation<>();
        list2.add(1);
        list2.add(2);

        assertTrue(list.removeAll(list2));
        assertEquals(1, list.size());
        assertEquals(0, list.get(0));
    }

    @Test
    void testRetainAll(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        ArrayListImplementation<Integer> list2 = new ArrayListImplementation<>();
        list2.add(1);
        list2.add(2);

        assertTrue(list.retainAll(list2));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testClear(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void testListIterator(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        int i = 0;
        for(Integer item : list){
            assertEquals(i, item);
            i++;
        }
    }

    @Test
    void testListIteratorIndex(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<>();
        list.add(0);
        list.add(1);
        list.add(2);

        int i = 0;
        for(Integer item : list){
            assertEquals(i, item);
            i++;
        }
    }

    @Test
    void testSubList(){
        ArrayListImplementation<Integer> list = new ArrayListImplementation<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        List<Integer> sublist = list.subList(1, 3);
        assertEquals(2, sublist.size());
        assertEquals(1, sublist.get(0));
        assertEquals(2, sublist.get(1));
    }
}