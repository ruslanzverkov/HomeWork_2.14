package com.example.homework2_14.StringArray;

import java.util.Objects;

public class StringListImpl implements StringList {
    private static final int INITIAL_SIZE=15;
    private final String[] stringArray;
    private int capacity;

    public StringListImpl() {
        stringArray = new String[INITIAL_SIZE];
        capacity=0;
    }


    @Override
    public String add(String item) {


        return null;
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
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
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
        boolean expression=includeEquality?index>=capacity:index>capacity;
        if (expression) {
            throw new IllegalArgumentException("индекс: "+index+"размер: "+capacity);
        }

    }


}
