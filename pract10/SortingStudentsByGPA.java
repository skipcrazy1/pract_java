package pract10;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA {

    Student[] iDNumber;

    // Метод заполнения массива
    public void setArray() {
        iDNumber = new Student[] {
                new Student("Ivan", "Petrov", "Math", 2, "A1", 4.1),
                new Student("Olga", "Ivanova", "Math", 1, "A1", 5.0),
                new Student("Sergey", "Kim", "CS", 3, "B2", 3.4),
                new Student("Anna", "Sidorova", "CS", 4, "C3", 4.8)
        };
    }

    // Вывод массива
    public void outArray() {
        for (Student s : iDNumber) {
            System.out.println(s);
        }
        System.out.println();
    }

    // Быстрая сортировка (GPA)
    public void quickSort(Student[] arr, int left, int right, Comparator<Student> c) {
        if (left >= right) return;

        int i = left, j = right;
        Student pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (c.compare(arr[i], pivot) < 0) i++;
            while (c.compare(arr[j], pivot) > 0) j--;

            if (i <= j) {
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }

        quickSort(arr, left, j, c);
        quickSort(arr, i, right, c);
    }

    // Сортировка слиянием
    public Student[] mergeSort(Student[] arr, Comparator<Student> c) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        Student[] left = Arrays.copyOfRange(arr, 0, mid);
        Student[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left, c);
        right = mergeSort(right, c);

        return merge(left, right, c);
    }

    private Student[] merge(Student[] a, Student[] b, Comparator<Student> c) {
        Student[] result = new Student[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (c.compare(a[i], b[j]) <= 0)
                result[k++] = a[i++];
            else
                result[k++] = b[j++];
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }


    public static void main(String[] args) {
        SortingStudentsByGPA test = new SortingStudentsByGPA();

        System.out.println("Исходный массив");
        test.setArray();
        test.outArray();

        System.out.println("QuickSort по GPA ");
        test.quickSort(test.iDNumber, 0, test.iDNumber.length - 1, new GPAComparator());
        test.outArray();
        
        System.out.println(" MergeSort по GPA ");
        test.iDNumber = test.mergeSort(test.iDNumber, new GPAComparator());
        test.outArray();

        System.out.println(" Сортировка по фамилии ");
        test.iDNumber = test.mergeSort(test.iDNumber, new SurnameComparator());
        test.outArray();

        System.out.println(" Объединение двух списков");

        Student[] list1 = {
                new Student("A", "One", "CS", 1, "X1", 4.4),
                new Student("B", "Two", "Math", 1, "X1", 3.3)
        };

        Student[] list2 = {
                new Student("C", "Three", "CS", 2, "X2", 5.0),
                new Student("D", "Four", "Bio", 1, "X3", 2.5)
        };

        Student[] merged = test.merge(list1, list2, new SurnameComparator());

        for (Student s : merged) {
            System.out.println(s);
        }
    }
}
