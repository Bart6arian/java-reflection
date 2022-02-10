package com.kodilla.bytecode.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException,
            IllegalAccessException {

        Class<Book> descriptor = Book.class;
        for (Method method : descriptor.getMethods()) {
            System.out.println(method.getName());
        }

        int modifiers = descriptor.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);
        boolean anInterface = Modifier.isInterface(modifiers);
        boolean aStatic = Modifier.isStatic(modifiers);

        System.out.println(isPublic);
        System.out.println(isAbstract);
        System.out.println(anInterface);
        System.out.println(aStatic);

        Constructor<Book> constructor = descriptor.getConstructor(new Class[]{String.class, String.class, int.class});
        Book book = constructor.newInstance("Title", "Signature", 2020);
        System.out.println(book.getYear());
    }
}
