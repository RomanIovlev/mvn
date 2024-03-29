package com.epam.jdi.light.asserts.generic;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface HasAssert<T> {
    T is();
    default T assertThat() {
        return is();
    }
    default T has() {
        return is();
    }
    default T waitFor() {
        return is();
    }
    default T shouldBe() {
        return is();
    }
    default T verify() {
        assertSoft(); return is();
    }
}