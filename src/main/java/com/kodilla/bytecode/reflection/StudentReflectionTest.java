package com.kodilla.bytecode.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StudentReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> desc = Student.class;

        Constructor<Student> constructor = desc.getConstructor();
        Student student = constructor.newInstance();

        Method generator = Student.class.getDeclaredMethod("generator");
        generator.setAccessible(true);
        String index = (String) generator.invoke(student);

        System.out.println("Student's index: "+index);
        int modifiers = generator.getModifiers();
        boolean aPrivate = Modifier.isPrivate(modifiers);

        System.out.println("Is index generator a private method: "+aPrivate);
    }
}
