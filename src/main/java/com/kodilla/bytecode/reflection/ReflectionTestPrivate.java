package com.kodilla.bytecode.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTestPrivate {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Book book = new Book("Title", "Signature", 2021);
        Field signatureField = Book.class.getDeclaredField("year");
        signatureField.setAccessible(true);

        int val = (int) signatureField.get(book);
        System.out.println(val);

        Method setDetails = Book.class.getDeclaredMethod("setDetails", String.class, int.class);
        setDetails.setAccessible(true);
        setDetails.invoke(book, null, 3010);
        System.out.println(book.getYear());
    }
}
