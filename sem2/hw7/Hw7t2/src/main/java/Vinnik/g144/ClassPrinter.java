package Vinnik.g144;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;


public class ClassPrinter {
    public static String printStructure(Class clazz) {
        return clazz.getPackage() + " ;\n"
                + getStructure(clazz);
    }

    private static String getStructure(Class clazz) {
        return getModifiers(clazz)
                + " class "
                + getSimpleNameWithTypeParameters(clazz)
                + " "
                + getSuperClass(clazz)
                + getInterfaces(clazz)
                + " {\n"
                + getFields(clazz)
                + getMethods(clazz)
                + getInnerClasses(clazz)
                + "\n}";
    }

    public static void printToFile(Class clazz) throws IOException {
        String nameOfFile = "src/main/java/Vinnik/g144/" + clazz.getSimpleName() + ".java";
        FileWriter file = new FileWriter(nameOfFile);
        file.write(ClassPrinter.printStructure(clazz));
        file.close();
    }

    private static String getModifiers(Class clazz) {
        if (clazz.getModifiers() != 0) {
            return Modifier.toString(clazz.getModifiers()) + " ";
        }
        return "";
    }

    private static String getSuperClass(Class clazz) {
        if (clazz.getSuperclass() != null) {
            return "extends " + getSimpleNameWithTypeParameters(clazz.getSuperclass()) + " ";
        }
        return "";
    }

    private static String getSimpleNameWithTypeParameters(Class superclass) {
        return superclass.getSimpleName() + getTypeParameters(superclass);
    }

    private static String getTypeParameters(Class clazz) {
        if (clazz.getTypeParameters().length == 0) {
            return "";
        }
        TypeVariable[] parameter = clazz.getTypeParameters();
        String string = "<";
        if (parameter.length > 1) {
            for (int i = 0; i < parameter.length - 1; i++) {
                string = string + parameter[i].getTypeName() + ",";
            }
            string = string + parameter[parameter.length - 1].getTypeName() + ">";
            return string;
        }
        return ("<" + parameter[0].getTypeName() + ">");
    }

    private static String getInterfaces(Class clazz) {
        String string = "";
        if (clazz.getInterfaces().length == 0) {
            System.out.println();
            return string;
        }
        Class[] interfaces = clazz.getInterfaces();
        string = " implements ";
        if (interfaces.length > 1) {
            for (int i = 0; i < interfaces.length; i++) {
                string = interfaces[i].getSimpleName() + getTypeParameters(interfaces[i]);
            }
            string = string + interfaces[interfaces.length - 1].getTypeName() + " "
                    + getTypeParameters(interfaces[interfaces.length - 1]) + ",";
            return string;
        }
        return string + interfaces[0].getSimpleName() + getTypeParameters(interfaces[0]);
    }

    private static String getFields(Class clazz) {
        String string = "";
        if (clazz.getDeclaredFields().length == 0) {
            return string;
        }
        string = "\t";
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 1) {
            for (int i = 0; i < fields.length - 1; i++) {
                string = string + getFieldDeclaration(fields[i]) + "\n\t";
            }
            string = string + getFieldDeclaration(fields[fields.length - 1]) + "\n";
            return string;
        }
        return string + getFieldDeclaration(fields[0]) + "\n";
    }

    private static String getFieldDeclaration(Field field) {
        String modifiers = field.getModifiers() != 0 ? Modifier.toString(field.getModifiers()) + " " : "";
        return modifiers + field.getType().getSimpleName() + " "
                + field.getName() + " = " + writeType(field.getType());
    }

    private static String getMethods(Class clazz) {
        String string = "";
        if (clazz.getDeclaredMethods().length == 0) {
            return string;
        }
        string = "\t";
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length > 1) {
            for (int i = 0; i < methods.length - 1; i++) {
                string = string + getMethod(methods[i]) + ";\n\t";
            }
            string = string + getMethod(methods[methods.length - 1]) + ";\n";
            return string;
        }
        return string + getMethod(methods[0]) + ";\n";
    }

    private static String getMethod(Method method) {
        String modifiers = method.getModifiers() == 0 ? "" : Modifier.toString(method.getModifiers()) + " ";
        String listOfExceptions = "";
        Class[] exceptions = method.getExceptionTypes();
        if (method.getExceptionTypes().length > 1) {
            listOfExceptions = " throws ";
            for (int i = 0; i < exceptions.length - 1; i++) {
                listOfExceptions = listOfExceptions + exceptions[i].getTypeName() + ", ";
            }
            listOfExceptions = listOfExceptions + exceptions[exceptions.length - 1].getTypeName();
        } else {
            if (method.getExceptionTypes().length == 1) {
                listOfExceptions = " throws " + exceptions[0].getTypeName();
            }
        }

        return modifiers + method.getReturnType() + " " + method.getName() +
                Arrays.stream(method.getParameters()).map(p -> p.getParameterizedType() + " " + p.getName())
                        .collect(Collectors.joining(", ", "(", ")"))
                                + listOfExceptions + " { return " + writeType(method.getReturnType()) + " }";

    }

    private static String writeType(Type type) {
        switch (type.getTypeName()) {
            case "Integer":
                return ("Integer.valueOf(0);");
            case "Boolean":
                return ("true;");
            case "String":
                return ("String.valueOf(\"\");");
            case "Double":
                return ("Double.valueOf(0.0);");
            case "Character":
                return ("Character.valueOf('x');");
            case "Byte":
                return ("Byte.valueOf(0);");
            case "Long":
                return ("Long.valueOf(0);");
            case "Short":
                return ("Short.valueOf(0);");
            case "Float":
                return ("Float.valueOf(0);");
            case "int":
                return ("0;");
            case "boolean":
                return ("true;");
            case "double":
                return ("0.0;");
            case "char":
                return ("'x';");
            case "byte":
                return ("0;");
            case "long":
                return ("0;");
            case "short":
                return ("0;");
            case "float":
                return ("0;");
            case "void":
                return (";");
            default:
                return ("null;");
        }
    }

    private static String getInnerClasses(Class clazz) {
        StringBuilder result = new StringBuilder();
        for (Class<?> innerClass : clazz.getDeclaredClasses()) {
            result.append(getStructure(innerClass));
        }
        return "\n" + result.toString();
    }
}

