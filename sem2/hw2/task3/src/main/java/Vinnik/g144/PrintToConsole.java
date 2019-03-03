package Vinnik.g144;

//import static org.graalvm.compiler.core.CompilationWrapper.ExceptionAction.Print;

class PrintToConsole implements Print {
    @Override
    public int[] printSpiral(int[][] originalArray) {
        Spiral spiral = new Spiral();
        int[] resultArray = spiral.resultArray(originalArray);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
        return resultArray;
    }
}