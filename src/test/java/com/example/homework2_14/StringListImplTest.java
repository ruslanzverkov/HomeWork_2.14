package com.example.homework2_14;

import com.example.homework2_14.StringArray.StringList;
import com.example.homework2_14.StringArray.StringListImpl;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringListImplTest {
    private final StringList stringList = new StringListImpl();

    @AfterEach
    public void afterEach() {
        stringList.clear();
    }

    @BeforeEach
    public void beforeEach() {

        stringList.add("t1");// i-0
        stringList.add("t2");// i-1
        stringList.add("t3");// i-2
        stringList.add("t4");// i-3
    }

    @Test
    void addTest() {
        String[] elements = new String[]{"t1", "t2", "t3", "t4"};
        assertThat(stringList.toArray()).hasSize(elements.length);
        for (int i = 0; i < elements.length; i++) {
            assertThat(stringList.get(i)).isEqualTo(elements[i]);
            assertThat(stringList.contains(elements[i])).isTrue();
            assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);

        }

    }

    @Test
    void removeTest() {
        String[] elements = new String[]{"t1", "t2", "t3"};
        stringList.remove("t4");
        assertThat(stringList.toArray()).hasSize(elements.length);

        for (int i = 0; i < elements.length; i++) {
            assertThat(stringList.get(i)).isEqualTo(elements[i]);
            assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            assertThat(stringList.contains(elements[i])).isTrue();
            assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
        }
    }

    @Test
    void setTest() {
        String[] elements = new String[]{"t1", "t5", "t3", "t4"};
        stringList.set(1, "t5");
        assertThat(stringList.toArray()).hasSize(elements.length);

        for (int i = 0; i < elements.length; i++) {
            assertThat(stringList.get(i)).isEqualTo(elements[i]);
            assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            assertThat(stringList.contains(elements[i])).isTrue();
            assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
        }
    }

    @Test
    void equalsTest() {
        String[] elements = new String[]{"t1", "t2", "t3", "t4"};
        StringList stringList2=new StringListImpl();

        for (String element : elements) {
            stringList2.add(element);
        }
        assertThat(stringList.equals(stringList2)).isTrue();
        stringList2.clear();
        assertThat(stringList.equals(stringList2)).isFalse();



    }


}
