package com.example.homework2_14.StringArray;

import java.sql.Array;
import java.util.Objects;

public class StringListImpl implements StringList {
    private static final int INITIAL_SIZE = 15;
    private final String[] stringArray;
    private int capacity;

    public StringListImpl() {
        stringArray = new String[INITIAL_SIZE];
        capacity = 0;
    }


    @Override
    public String add(String item) {
        return add(capacity, item);
    }

    @Override
    public String add(int index, String item) {

        if (capacity >= stringArray.length) {
            throw new IllegalArgumentException("Список полон");
        }
        checkNotNull(item);
        checkNonNegativeIndex(index);
        checkIndex(index, false);
        System.arraycopy(stringArray, index, stringArray, index + 1, capacity - index);
        capacity++;
        return stringArray[index] = item;

    }

    @Override
    public String set(int index, String item) {
        checkNotNull(item);
        checkNonNegativeIndex(index);
        checkIndex(index, true);
        return stringArray[index] = item;
    }

    @Override
    public String remove(String item) {
        int removing = indexOf(item);
        if (removing == -1) {
            throw new IllegalArgumentException("элемент не найден");
        }
        checkNotNull(item);
        return remove(removing);

    }

    @Override
    public String remove(int index) {
        checkIndex(index, true);
        checkNonNegativeIndex(index);
        String removing = stringArray[index];
        System.arraycopy(stringArray, index + 1, stringArray, index, capacity - 1 - index);
        stringArray[--capacity] = null;
        return removing;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkNotNull(item);
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (stringArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {

        checkNotNull(item);
        int index = -1;
        for (int i = capacity-1; i >=0; i--) {
            if (stringArray[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        checkNonNegativeIndex(index);
        checkIndex(index,true);
        return stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!stringArray[i].equals(get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            stringArray[i] = null;

        }
        capacity = 0;

    }

    @Override
    public String[] toArray() {
        String[] resultArray = new String[capacity];
        System.arraycopy(stringArray, 0, stringArray, 0, capacity);
        return resultArray;
    }

    private void checkNotNull(String string) {
        if (Objects.isNull(string)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNonNegativeIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIndex(int index, boolean includeEquality) {
        boolean expression = includeEquality ? index >= capacity : index > capacity;
        if (expression) {
            throw new IllegalArgumentException("индекс: " + index + "размер: " + capacity);
        }

    }


}
