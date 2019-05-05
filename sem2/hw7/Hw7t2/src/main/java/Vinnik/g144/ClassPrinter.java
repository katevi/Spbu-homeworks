package Vinnik.g144;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;

/**
 * A class describes an unknown given class by reflection.
 * Creates a new class that has all the fields, methods, inner classes, and interfaces that a given class has.
 */
public class ClassPrinter {

    /**
     * Prints all the class information obtained by reflection to a file.
     *
     * @param clazz - class, whose information will be found through reflection.
     * @throws IOException - exception, when file to write not found.
     */
    public void printStructureToFile(Class clazz) throws IOException {
        String fileName = "src\\test\\java\\Vinnik\\g144\\ResultOfReflection\\";
        StringBuilder buildClass = new StringBuilder();
        fileName = fileName + clazz.getSimpleName() + ".java";
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(printStructure(buildClass, clazz).toString());
        fileWriter.close();
    }

    /**
     * Prints all the class information obtained by reflection to a console.
     * @param classBuilder - string, in which will write information about the class.
     * @param clazz - class, whose information will be found through reflection.
     * @return - final string with information.
     */
    public StringBuilder printStructure(StringBuilder classBuilder, Class clazz) {
        classBuilder.append("package " + "Vinnik.g144.ResultOfReflection" + ";\n\n");

        classBuilder.append("import Vinnik.g144.*;\n\n");

        getStructure(classBuilder, clazz);

        return classBuilder;
    }

    private void getStructure(StringBuilder buildClass, Class clazz) {
        //Class declaration
        getModifiers(buildClass, clazz);
        buildClass.append("class ");
        getSimpleNameWithTypeParameters(buildClass, clazz);
        getSuperclass(buildClass, clazz);
        getInterfaces(buildClass, clazz);
        buildClass.append("{\n\t");

        //The contents of the class
        getFields(buildClass, clazz);
        getConstructors(buildClass, clazz);
        getMethods(buildClass, clazz);
        getInnerClasses(buildClass, clazz);

        buildClass.append("\n}");
        buildClass.append("\n\n\t");
    }

    private void getModifiers(StringBuilder classBuilder, Class clazz) {
        if (clazz.getModifiers() != 0) {
            classBuilder.append(Modifier.toString(clazz.getModifiers()));
            classBuilder.append(" ");
        }
    }

    private void getSuperclass(StringBuilder buildClass, Class clazz) {
        if (clazz.getSuperclass() != null) {
            buildClass.append("extends ");
            getSimpleNameWithTypeParameters(buildClass, clazz.getSuperclass());
        }
    }

    private void getSimpleNameWithTypeParameters(StringBuilder buildClass, Class clazz) {
        buildClass.append(clazz.getSimpleName());
        buildClass.append(" ");
        setTypeParameters(buildClass, clazz);
    }

    private void setTypeParameters(StringBuilder buildClass, Class clazz) {
        if (clazz.getTypeParameters().length != 0) {
            TypeVariable[] parameters = clazz.getTypeParameters();
            buildClass.append("<");
            for (int i = 0; i < parameters.length; i++) {
                buildClass.append(parameters[i].getName());

                if (i < parameters.length - 1) {
                    buildClass.append(", ");
                }
            }

            buildClass.append("> ");
        }
    }

    private void getInterfaces(StringBuilder buildClass, Class clazz) {
        if (clazz.getInterfaces().length != 0) {
            buildClass.append("implements ");

            Class[] interfaces = clazz.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                buildClass.append(interfaces[i].getSimpleName());
                setTypeParameters(buildClass, interfaces[i]);

                if (i < interfaces.length - 1) {
                    buildClass.append(", ");
                }
            }
        }

        buildClass.append(" ");
    }

    private void getFields(StringBuilder buildClass, Class clazz) {
        if (clazz.getDeclaredFields().length != 0) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field x: fields){
                getFieldDeclaration(buildClass, x);
                buildClass.append("\n\t");
            }
        }
    }

    private void getFieldDeclaration(StringBuilder buildClass, Field field) {
        if (field.getModifiers() != 0) {
            buildClass.append(Modifier.toString(field.getModifiers()));
            buildClass.append(" ");
        }

        buildClass.append(field.getType().getSimpleName());
        buildClass.append(" ");
        buildClass.append(field.getName());
        buildClass.append(" = ");
        setReturnType(buildClass, field.getType());
        buildClass.append("\n");
    }

    private void setReturnType(StringBuilder buildClass, Type type) {
        switch (type.getTypeName()) {
            case "Boolean":
                buildClass.append("true;");
                break;
            case "Integer":
                buildClass.append("Integer.valueOf(0);");
                break;
            case "String":
                buildClass.append("String.valueOf(\"\");");
                break;
            case "Double":
                buildClass.append("Double.valueOf(0.0);");
                break;
            case "Character":
                buildClass.append("Character.valueOf('x');");
                break;
            case "Byte":
                buildClass.append("Byte.valueOf(0);");
                break;
            case "float":
                buildClass.append("0;");
                break;
            case "Long":
                buildClass.append("Long.valueOf(0);");
                break;
            case "Short":
                buildClass.append("Short.valueOf(0);");
                break;
            case "Float":
                buildClass.append("Float.valueOf(0);");
                break;
            case "int":
                buildClass.append("0;");
                break;
            case "boolean":
                buildClass.append("true;");
                break;
            case "double":
                buildClass.append("0.0;");
                break;
            case "char":
                buildClass.append("'x';");
                break;
            case "byte":
                buildClass.append("0;");
                break;
            case "long":
                buildClass.append("0;");
                break;
            case "short":
                buildClass.append("0;");
                break;
            case "void":
                buildClass.append(";");
                break;
            default:
                buildClass.append("null;");
                break;
        }
    }

    private void getMethods(StringBuilder buildClass, Class clazz) {
        if (clazz.getDeclaredMethods().length != 0) {
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                getOneMethod(buildClass, methods[i]);

                if (i < methods.length - 1) {
                    buildClass.append("\n\n\t");
                }
            }
        }
    }

    private void getOneMethod(StringBuilder buildClass, Method method) {
        if (method.getModifiers() != 0) {
            buildClass.append(Modifier.toString(method.getModifiers()));
            buildClass.append(" ");
        }

        buildClass.append(method.getReturnType().getSimpleName());
        buildClass.append(" ");
        buildClass.append(method.getName());
        buildClass.append(" (");

        Parameter[] parameters = method.getParameters();
        writeParameters(buildClass, parameters);

        buildClass.append(") ");
        writeExceptions(buildClass, method);
        buildClass.append(" {\n\t\treturn ");
        setReturnType(buildClass, method.getReturnType());
        buildClass.append("\n\t}");
    }

    private void writeExceptions(StringBuilder buildClass, Method method) {
        if (method.getExceptionTypes().length == 0) {
            buildClass.append(" ");
        } else {
            buildClass.append("throws ");
            Class[] exceptions = method.getExceptionTypes();
            for (int i = 0; i < exceptions.length; i++) {
                buildClass.append(exceptions[i].getSimpleName());

                if (i < exceptions.length - 1) {
                    buildClass.append(", ");
                }
            }
        }

    }

    private void getConstructors(StringBuilder buildClass, Class clazz) {
        buildClass.append("\n\t");
        if (clazz.getDeclaredConstructors().length != 0) {
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor i : constructors) {
                writeOneConstructor(buildClass, clazz, i);
                buildClass.append("\n\n\t");
            }
        }
    }

    private void writeOneConstructor(StringBuilder buildClass, Class clazz, Constructor constructor) {
        if (constructor.getModifiers() != 0) {
            buildClass.append(Modifier.toString(constructor.getModifiers()));
            buildClass.append(" ");
        }

        buildClass.append(clazz.getSimpleName());
        buildClass.append("(");
        Parameter[] parameters = constructor.getParameters();
        writeParameters(buildClass, parameters);
        buildClass.append(") { }");
    }

    private void writeParameters(StringBuilder buildClass, Parameter[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            buildClass.append(parameters[i].getType().getSimpleName() + " " + parameters[i].getName());
            if (i != parameters.length - 1) {
                buildClass.append(", ");
            }
        }
    }

    private void getInnerClasses(StringBuilder buildClass, Class clazz) {
        if (clazz.getDeclaredClasses().length != 0) {
            buildClass.append("\n\t");
        }
        for (Class<?> innerClass : clazz.getDeclaredClasses()) {
            getStructure(buildClass, innerClass);
            buildClass.append("\n\n\t");
        }
    }

    // Comparison difference classes part

    /** Finds the difference between classes - prints it to the console
     *
     * @param first - first class to compare
     * @param second - second class to compare
     * @return - true if class are equal, false otherwise
     */
    public boolean diffClasses(Class first, Class second) {
        StringBuilder differenceBetweenClasses = new StringBuilder();
        getDifference(differenceBetweenClasses, first, second);
        if (differenceBetweenClasses.length() == 0) {
            System.out.println("Classes are equal!");
            return true;
        }
        System.out.println("Classes are not equal!");
        System.out.println(differenceBetweenClasses);
        return false;
    }

    private void getDifference(StringBuilder differenceBetweenClasses, Class first, Class second) {
        areFieldsDiffer(differenceBetweenClasses, first, second);
        areMethodsDiffer(differenceBetweenClasses, first, second);
        areInnerClassesDiffer(differenceBetweenClasses, first, second);
    }

    private void areInnerClassesDiffer(StringBuilder differenceBetweenClasses, Class first, Class second) {
        if (first.getDeclaredClasses().length != 0 && second.getDeclaredClasses().length != 0) {
            Class[] innerClassesFirst = first.getDeclaredClasses();
            Class[] innerClassesSecond = second.getDeclaredClasses();
            if (innerClassesFirst.equals(innerClassesSecond)) {
                return;
            }

            for (Class i : innerClassesFirst) {
                Class curClass = i;

                for (Class j : innerClassesSecond) {
                    Class curSecondClass = j;
                    getDifference(differenceBetweenClasses, curClass, curSecondClass);
                }
            }
        } else if (first.getDeclaredClasses().length != 0 && second.getDeclaredClasses().length == 0
                    || first.getDeclaredClasses().length == 0 && second.getDeclaredClasses().length != 0) {
            Class[] innerClasses = first.getDeclaredClasses();
            for (Class i : innerClasses) {
                getStructure(differenceBetweenClasses, i);
            }
        }
    }

    private void areFieldsDiffer(StringBuilder differenceBetweenClasses, Class first, Class second) {
        Field[] fieldsFirst = first.getDeclaredFields();
        Field[] fieldsSecond = second.getDeclaredFields();
        if (fieldsFirst.equals(fieldsSecond)) {
            return;
        }
        for (Field i : fieldsFirst) {
            if (!containsCurrentField(i, second)) {
                getFieldDeclaration(differenceBetweenClasses, i);
            }
        }
        for (Field i : fieldsSecond) {
            if (!containsCurrentField(i, first)) {
                getFieldDeclaration(differenceBetweenClasses, i);
            }
        }
    }

    private boolean containsCurrentField(Field field, Class clazz) {
        if (Modifier.isFinal(field.getModifiers()) && field.getName().equals("this$0$")) {
            return true;
        }
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder givenFieldDeclaration = new StringBuilder();
        getFieldDeclaration(givenFieldDeclaration, field);
        for (Field i : fields) {
            StringBuilder currentFieldDeclaration = new StringBuilder();
            getFieldDeclaration(currentFieldDeclaration, i);
            if (givenFieldDeclaration.toString().equals(currentFieldDeclaration.toString())) {
                return true;
            }
        }
        return false;
    }

    private void areMethodsDiffer(StringBuilder differenceBetweenClasses, Class first, Class second) {
        Method[] methodsFirst = first.getDeclaredMethods();
        Method[] methodsSecond = second.getDeclaredMethods();
        if (methodsFirst.equals(methodsSecond)) {
            return;
        }
        for (Method i : methodsFirst) {
            if (!containsCurrentMethod(i, second)) {
                getOneMethod(differenceBetweenClasses, i);
                differenceBetweenClasses.append("\n");
            }
        }
        for (Method i : methodsSecond) {
            if (!containsCurrentMethod(i, first)) {
                getOneMethod(differenceBetweenClasses, i);
                differenceBetweenClasses.append("\n");
            }
        }
    }

    private boolean containsCurrentMethod(Method method, Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        StringBuilder givenMethodDeclaration = new StringBuilder();
        getOneMethod(givenMethodDeclaration, method);
        for (Method i : methods) {
            StringBuilder currentMethodDeclaration = new StringBuilder();
            getOneMethod(currentMethodDeclaration, i);
            if (currentMethodDeclaration.toString().equals(givenMethodDeclaration.toString())) {
                return true;
            }
        }
        return false;
    }

}

