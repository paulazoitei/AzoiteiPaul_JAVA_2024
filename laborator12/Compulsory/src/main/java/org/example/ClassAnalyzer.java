package org.example;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassAnalyzer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java ClassAnalyzer <class-name>");
            System.exit(1);
        }

        String className = args[0];
        try {

            Class<?> clazz = loadClass(className);

            if (clazz == null) {
                System.err.println("Class not found: " + className);
                System.exit(1);
            }


            extractClassInfo(clazz);


            invokeTestMethods(clazz);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Class<?> loadClass(String className) throws IOException, ClassNotFoundException {

        File file = new File(".");
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};


        try (URLClassLoader classLoader = new URLClassLoader(urls)) {
            return classLoader.loadClass(className);
        }
    }

    private static void extractClassInfo(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());


        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
        }
    }

    private static void invokeTestMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class) && isStatic(method) && method.getParameterCount() == 0) {
                try {
                    System.out.println("Invoking test method: " + method.getName());
                    method.invoke(null);
                } catch (Exception e) {
                    System.err.println("Failed to invoke method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isStatic(Method method) {
        return (method.getModifiers() & java.lang.reflect.Modifier.STATIC) != 0;
    }
}