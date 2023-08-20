package Java_Exceptions.HomeWork.HW1;

public class ArrayDivision {
    public int[] divideArrays(int[] arr1, int[] arr2) {
        int[] newArray = new int[arr1.length];
        if (arr1 == null || arr2 == null) {
            throw new NullPointerException("Input arrays cannot be null.");
        }        
        if (arr1.length != arr2.length) {
            throw new RuntimeException("The lengths of the input arrays are not equal.");
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Division by zero at index " + i);
            }
            newArray[i] = arr1[i] / arr2[i];
        }
        return newArray;
    }

    public static void main(String[] args){
        int[] arr1 = {10, 20, 6, 18};
        int[] arr2 = {5, 10, 0, 9};
        ArrayDivision ad = new ArrayDivision();
        int[] result = ad.divideArrays(arr1, arr2);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }
}
