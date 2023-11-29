package org.example.test_1Z0816.ch08.o02;

import java.lang.annotation.Annotation;

/**
 * 驗證注解被繼承了
 */
public class InheritedDemo {

    public static void main(String[] args) {
        Class<Asian> asianClass = Asian.class;
        Annotation[] annotations = asianClass.getAnnotations();
        for(Annotation annotation: annotations) {
            System.out.println(annotation);
        }
    }
}
