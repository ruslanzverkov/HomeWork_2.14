package com.example.homework2_14;

import com.example.homework2_14.StringArray.StringList;
import com.example.homework2_14.StringArray.StringListImpl;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringListImplTest {
    private final StringList stringList = new StringListImpl();

    @AfterEach
    public void afterEach() {
        stringList.clear();
    }

    @Test
    public void addTest() {
        String[] elements = new String[]{"t1", "t2", "t3", "t4"};
        stringList.add("t1");
        stringList.add("t2");
        stringList.add("t3");
        stringList.add("t4");

        for (int i = 0; i < elements.length; i++) {
            assertThat(stringList.get(i)).isEqualTo(elements[i]);
            assertThat(stringList.contains(elements[i])).isTrue();
            assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);

        }

        assertThat(stringList.toArray()).hasSize(elements.length);
        assertThat(stringList.toArray()).containsExactly(elements);
    }


}
