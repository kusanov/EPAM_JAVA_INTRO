package com.company.epam.part2;


import java.util.Arrays;

import static java.lang.Math.*;

public class Part2 {
    static void func1(int A[], int K) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % K == 0) {
                sum = sum + A[i];
            }
        }
        System.out.println(sum);
    }

    static void func2(double D[], int Z) {
        int count = 0;
        for (int i = 0; i < D.length; i++) {
            if (D[i] > Z) {
                D[i] = Z;
                count++;
            }
        }
        System.out.println(Arrays.toString(D));
        System.out.println(count);
    }

    static void func3(double D2[], int N) {
        int countPlus = 0;
        int countZero = 0;
        int countMinus = 0;
        for (int i = 0; i < D2.length; i++) {
            if (D2[i] > 0)
                countPlus++;
            else if (D2[i] == 0)
                countZero++;
            else countMinus++;
        }
        System.out.println(Arrays.toString(D2));
        System.out.println(countPlus);
        System.out.println(countZero);
        System.out.println(countMinus);
    }

    static void func4(double array[]) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max])
                max = i;
            if (array[i] < array[min])
                min = i;
        }
        double tmp = array[max];
        array[max] = array[min];
        array[min] = tmp;
        System.out.println(Arrays.toString(array));
    }

    static void func5(int ar2[]) {
        for (int i = 0; i < ar2.length; i++) {
            if (ar2[i] > i) {
                System.out.println(ar2[i]);
            }
        }

    }

    static void func6(int ar3[]) {
        int sum = ar3[1];
        for (int i = 2; i < ar3.length; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2)
                sum += ar3[i];
        }
        System.out.println("Сумма элементов массива, порядковые номера которых являются простыми числами, равна = " + sum);
    }

    static void func7(double ar4[]) {
        double max = ar4[0] + ar4[ar4.length - 1];
        for (int i = 1; i < ar4.length / 2; i++) {
            if (ar4[i] + ar4[ar4.length - i - 1] > max)
                max = ar4[i] + ar4[ar4.length - i - 1];
        }
        System.out.println(max);
    }

    static void func8(int ar5[]) {
        int min = ar5[0];
        int countMin = 0;
        for (int i = 1; i < ar5.length; i++) {
            if (ar5[i] < min)
                min = ar5[i];
        }
        for (int i = 0; i < ar5.length; i++) {
            if (ar5[i] == min)
                countMin++;
        }
        int j = 0;
        int[] ar5min = new int[ar5.length - countMin];
        for (int i = 0; i < ar5.length; i++) {
            if (ar5[i] != min) {
                ar5min[j] = ar5[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(ar5min));
    }

    static void func9(int ar6[]) {
        int count = 0; //начальное число совпадений
        int countMax = 0; //начальное число максимальных воспадений
        int iMin = 0;
        int num = 0;
        for (int i = 0; i < ar6.length - 1; i++) {
            for (int j = i; j < ar6.length; j++) {
                if (ar6[i] == ar6[j]) { //ищем одинаковые числа и фиксируем количество совпадений
                    count++;
                }
            }
            if (count >= countMax) { //сравниваем количество совпадений
                if (count > countMax) {
                    iMin = i;
                } else {
                    iMin = (ar6[i] < ar6[iMin]) ? i : iMin;//при равенстве совпадений, ищем индекс минимального числа
                }
                num = ar6[iMin];
                countMax = count;
            }
            count = 0; // обнуляем счетчик для сравнения следующиего числа
        }
        System.out.println("Искомое число - " + num + ", количество совпадений - " + countMax);
    }

    static void func10(int ar7[]) {
        for (int i = 1; i < ar7.length; i += 2) {
            ar7[i] = 0;
        }
        System.out.println("Каждый второй элемент массива был заменен нулем. Итоговый массив: " + Arrays.toString(ar7));
    }

    static void func11(int matrix[][]) {
        System.out.println("Нечетные столбцы, у которых первый элемент больше последнего:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j = j + 2) {
                if (matrix[0][j] > matrix[matrix.length - 1][j]) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void func12(int matrix[][]) {
        // диагональ матрицы слева направа
        System.out.println("Диагональ матрицы слева направо: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        // диагональ матрицы справа налево
        System.out.println("\nДиагональ матрицы справо налево: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
    }

    static void func13(int matrix[][], int line, int column) {
        System.out.print("\nВывод строки с индексом k = " + line + ": ");
        for (int j = 0; j < matrix[line].length; j++) {
            System.out.print(matrix[line][j] + " ");
        }
        System.out.print("\nВывод столбца с индексом p = " + column + ": ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][column] + " ");

        }
        System.out.println("");
    }

    static void func14(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 != 0) {
                    System.out.print((matrix[i][j] = (size - j)) + " ");//вывод четной строки
                } else {
                    System.out.print((matrix[i][j] = (j + 1)) + " ");//вывод нечетной строки
                }
            }
            System.out.println();
        }
    }

    static void func15(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i <= j) {
                    System.out.print((matrix[i][j] = (i + 1)) + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void func16(int size) {
        int[][] matrix = new int[size][size];
        //вывод первой половины матрицы
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j >= i && j < matrix[i].length - i) {
                    System.out.print((matrix[i][j] = 1) + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        //вывод второй половины матрицы
        for (int i = matrix.length / 2; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j <= i && j >= matrix[i].length - 1 - i) {
                    System.out.print((matrix[i][j] = 1) + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void func17(int size) {
        int count = 0;//счетчик положительных элементов матрицы
        double[][] matrix = new double[size][size]; //используем тип double, т.к. sin всегда меньше 1
        System.out.println("Вывод матрицы согласно условию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.3f", (matrix[i][j] = sin((pow(i, 2) - pow(j, 2)) / size)));
                System.out.print("  ");
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println("Количество положительных элементов матрицы count = " + count);
    }

    static void func18(int matrix[][], int col1, int col2) {
        //производим замену столбцов
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][col1];
            matrix[i][col1] = matrix[i][col2];
            matrix[i][col2] = temp;
        }
        //Вывод массива с замененными столбцами
        System.out.println("Массив после замены столбцов");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void func19(int matrix[][]) {
        int[] sum = new int[matrix.length];
        int maxSum = 0;
        int index = 0;
        //подсчет суммы в столбцах и определение максимальной суммы и номера столбца
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum[i] += matrix[j][i];
            }
            if (sum[i] > maxSum) {
                maxSum = sum[i];
                index = i;
            }
            System.out.println("Сумма чисел " + i + " столбца равна sum = " + sum[i]);
        }
        System.out.println("Столбец № " + index + " содержит максимальную сумму чисел, равную sum = " + sum[index]);
    }

    static void func20(int matrix[][]) {
        System.out.print("Положительные элементы главной диагонали матрицы: ");
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] > 0) {
                System.out.print(matrix[i][i] + " ");
            }
        }
    }

    static void func21(int matrix[][]) {
        int min = 0;
        int max = 15;
        int count = 0;//счетчик чисел 5
        int countZero = 0;
        // заполняем матрицу случайными числами от 0 до 15
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (random() * ((max - min) + 1) + min);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //поиск чисел 5
        System.out.print("Номера строк, в которых число 5 встречается 3 и более раз: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.print(i + " ");
                countZero++;
            }
            count = 0;
        }
        if (countZero == 0) {
            System.out.println("такие строки отсутствуют");
        }
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (random() * ((max - min) + 1) + min);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //сортируем строки матрицы по возрастанию
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix[i].length - 1; k++) {
                    if (matrix[i][k] > matrix[i][k + 1]) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k + 1];
                        matrix[i][k + 1] = temp;
                    }
                }
            }
        }
        System.out.println("Строки отсортированы по возрастанию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //сортируем строки матрицы по убыванию
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix[i].length - 1; k++) {
                    if (matrix[i][k] < matrix[i][k + 1]) {
                        int temp = matrix[i][k + 1];
                        matrix[i][k + 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        System.out.println("Строки отсортированы по убыванию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void func22(int matrix[][]) {
        int min = 0;
        int max = 100;
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (random() * ((max - min) + 1) + min);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //сортируем строки матрицы по возрастанию
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix[i].length - 1; k++) {
                    if (matrix[i][k] > matrix[i][k + 1]) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[i][k + 1];
                        matrix[i][k + 1] = temp;
                    }
                }
            }
        }
        System.out.println("Строки отсортированы по возрастанию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //сортируем строки матрицы по убыванию
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < matrix[i].length - 1; k++) {
                    if (matrix[i][k] < matrix[i][k + 1]) {
                        int temp = matrix[i][k + 1];
                        matrix[i][k + 1] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        System.out.println("Строки отсортированы по убыванию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void func23(int matrix[][]) {
        int min = 0;
        int max = 9;
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (random() * ((max - min) + 1) + min);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //сортируем столбцы матрицы по убыванию
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[i][k] > matrix[j][k]) {
                        int temp = matrix[i][k];
                        matrix[i][k] = matrix[j][k];
                        matrix[j][k] = temp;
                    }
                }
            }
        }
        System.out.println("Стобцы отсортированы по убыванию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //сортируем столбцы матрицы по возрастанию
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[i][k] < matrix[j][k]) {
                        int temp = matrix[j][k];
                        matrix[j][k] = matrix[i][k];
                        matrix[i][k] = temp;
                    }
                }
            }
        }
        System.out.println("Стобцы отсортированы по возрастанию:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void func24(int numLine, int numColumn) {
        // количество строк должно быть больше или равно, чем количество стобцов, минус 1
        int[][] matrix = numLine >= numColumn - 1 ? new int[numLine][numColumn] : new int[numColumn][numLine];
        int[] count = numLine >= numColumn - 1 ? new int[numColumn] : new int[numLine]; //счетчик столбцов
        int countOne = 0; //счетчик единиц
        for (int i = 0; i < count.length; i++) {
            count[i] = i;
        }

        for (int i = 0; i < count.length; i++) { //перебираем номера столбцов по порядку
            while (true) {
                if (countOne == count[i]) break; //если кол-во 1 равно номеру столбца, то выходим из цикла
                int j = (int) (random() * (matrix.length)); //случайный индекс строки
                if (matrix[j][i] == 0) {
                    matrix[j][i] = 1;
                    countOne++;
                }
            }
            countOne = 0;
        }
        System.out.println("Матрица из 0 и 1:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void func25(int matrix[][]) {
        int numMax = Integer.MIN_VALUE;
        //ищем наибольший элемент матрицы
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > numMax) {
                    numMax = matrix[i][j];
                }
            }
        }
        System.out.println("Наибольший элемент матрицы - " + numMax);
        //заменяем все нечетные элементы матрицы на наибольший элемент
        System.out.println("Матрица с замененными нечетными элементами на " + numMax + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 == 1) {
                    matrix[i][j] = numMax;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void func26(int size) {
        int[][] arr = new int[size][size];
        int i, j;
        // заполняем матрицу значением счетчика
        // начиная с 1;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++)
                arr[i][j] = (size * i) + j + 1;
        // изменить значение элементов массива
        // в исправленном месте согласно правилу
        // (n * n + 1) -arr [i] [j]
        // Левый верхний угол матрицы
        // (заказ (n / 4) * (n / 4))
        for (i = 0; i < size / 4; i++)
            for (j = 0; j < size / 4; j++)
                arr[i][j] = (size * size + 1) - arr[i][j];
        // Верхний правый угол матрицы
        // (заказ (n / 4) * (n / 4))
        for (i = 0; i < size / 4; i++)
            for (j = 3 * (size / 4); j < size; j++)
                arr[i][j] = (size * size + 1) - arr[i][j];
        // Левый нижний угол матрицы
        // (заказ (n / 4) * (n / 4))
        for (i = 3 * size / 4; i < size; i++)
            for (j = 0; j < size / 4; j++)
                arr[i][j] = (size * size + 1) - arr[i][j];
        // правый нижний угол матрицы
        // (заказ (n / 4) * (n / 4))
        for (i = 3 * size / 4; i < size; i++)
            for (j = 3 * size / 4; j < size; j++)
                arr[i][j] = (size * size + 1) - arr[i][j];
        // Центр матрицы (порядок (n / 2) * (n / 2))
        for (i = size / 4; i < 3 * size / 4; i++)
            for (j = size / 4; j < 3 * size / 4; j++)
                arr[i][j] = (size * size + 1) - arr[i][j];
        // Печать магического квадрата
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    static void func27(int[] array1, int[] array2, int k) {
        int[] arrayA = new int[array1.length + array2.length];

        System.arraycopy(array1, 0, arrayA, 0, k + 1);
        System.arraycopy(array2, 0, arrayA, k + 1, array2.length);
        System.arraycopy(array1, k + 1, arrayA, k + array2.length + 1, array1.length - k - 1);

        System.out.println("Новый массив: " + Arrays.toString(arrayA));
    }

    static void func28(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        Arrays.sort(result);
        System.out.println("Новый массив: " + Arrays.toString(result));
    }

    static void func29(int[] arr1) {

        for (int i = 0; i < arr1.length; i++) {
            int min = arr1[i];
            int minId = i;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[j] < min) {
                    min = arr1[j];
                    minId = j;
                }
            }
            int temp = arr1[i];
            arr1[i] = min;
            arr1[minId] = temp;
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr1));

    }

    static void func30(int[] array) {

        boolean sorted = true;

        while (sorted) {
            sorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = true;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    static void func31(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (current < array[j]) {
                    array[j + 1] = array[j];
                } else break;
            }
            array[j + 1] = current;
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    static void func32(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (current < array[j]) {
                    array[j + 1] = array[j];
                } else break;
            }
            array[j + 1] = current;
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    static void func33(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        Arrays.sort(result);
        System.out.println("Новый массив: " + Arrays.toString(result));
    }

    //находим наибольший общий делитель (НОД)
    public static void greatestCommonDivisor(int numA, int numB) {
        int result = 1;
        int min = numA > numB ? numB : numA; //находим минимальное из двух число для начала поиска НОД
        for (int i = min; i > 0; i--) { //перебираем числа от минимального из двух и до 1
            if (numA % i == 0 && numB % i == 0) {
                result = i;
                break;
            }
        }
        System.out.println("Наибольший общий делитель чисел " + numA + " и " + numB + " равен " + result);
    }

    // находим наименьшее общее кратное (НОК)
    public static void smallestCommonMultiple(int numA, int numB) {
        int result = 1;
        int max = numA > numB ? numA : numB;//находим максимальное из двух число для начало поиска НОК
        for (int i = max; i <= numA * numB; i++) {//перебираем числа от максимального до A*B
            if (i % numA == 0 && i % numB == 0) {
                result = i;
                break;
            }
        }
        System.out.println("Наименьшее общее кратное чисел " + numA + " и " + numB + " равно " + result);
    }

    public static void greatestCommonDivisor4(int numA, int numB, int numC, int numD) {
        int result = 1;
        int min = min(min(numA, numB), min(numC, numD)); //находим минимальное из двух число для начала поиска НОД
        for (int i = min; i > 0; i--) { //перебираем числа от минимального из двух и до 1
            if (numA % i == 0 && numB % i == 0 && numC % i == 0 && numD % i == 0) {
                result = i;
                break;
            }
        }
        System.out.println("Наибольший общий делитель чисел " + numA + ", " + numB + ", " + numC + ", " + numD + " равно " + result);
    }

    public static void areaOfTheTriangle(int side) {
        double area = side * sqrt(3) / 4;
        System.out.print("Площадь правильного шестиугольника равна - ");
        System.out.printf("%.3" +
                "f", 6 * area);
    }

    public static void maxDistanceBetweenPoints(int[][] matrix) {
        double maxDistance = Double.MIN_VALUE;
        int idFirstPoint = 0;
        int idSecondPoint = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                int distanceX = matrix[i][0] - matrix[j][0]; //расстояние между точками по Х
                int distanceY = matrix[i][1] - matrix[j][1]; //расстояние между точками по Y
                double distance = sqrt(pow(distanceX, 2) + pow(distanceY, 2)); //расстояние между точками
                if (distance > maxDistance) {
                    maxDistance = distance; //находим максимальное расстояние между точками
                    idFirstPoint = i; //первая точка
                    idSecondPoint = j; //вторая точка
                }
            }
        }
        int[] point = new int[]{idFirstPoint, idSecondPoint};
        System.out.println("\nНаибольшее расстояние между точками №" + point[0] + "(" + matrix[point[0]][0] +
                "," + matrix[point[0]][1] + ") и №" + point[1] + "(" + matrix[point[1]][0] +
                "," + matrix[point[1]][1] + ")");
    }

    public static void secondMax(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) { //находим максимальное число в массиве
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > secondMax && array[i] != max) {
                secondMax = array[i];
            }
        }
        System.out.println("Второе по величине число из массива - " + secondMax);
    }

    public static void mutuallyPrimeNumbers(int numA, int numB, int numC) {
        int min = min(min(abs(numA), abs(numB)), abs(numC));
        System.out.print("Числа " + numA + ", " + numB + " и " + numC);
        int count = 0;
        for (int i = min; i > 1; i--) { //перебираем числа от минимального из двух и до 1
            if (numA % i == 0 && numB % i == 0 && numC % i == 0) {
                System.out.println(" не являются взаимно простыми, наибольший общий делитель равен " + i);
                break;
            } else {
                count++;
            }
            if (count == min - 1) {
                System.out.println(" числа являются взаимно простыми");
            }
        }
        if (abs(numA) == 1 || abs(numB) == 1 || abs(numC) == 1) {
            if (numA == 0 || numB == 0 || numC == 0) {
                System.out.println(" являются не взаимно простыми, т.к. одно из чисел равно 0");
            } else {
                System.out.println(" являются взаимно простыми, т.к. одно из чисел равно 1 или -1");
            }
        }
    }

    public static void sumFactorial(int factorial) {
        int sum = 0;
        for (int i = 1; i <= 9; i = i + 2) {
            sum = sum + factorial(i);
        }
        System.out.println("Сумма факториалов нечетных чисел от 1 до 9 равна " + sum);
    }

    public static int factorial(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    //находим сумму трех последовательно расположенных элементов
    public static int sumOfThreeElements(int numK, int[] array) {
        return array[numK] + array[numK + 1] + array[numK + 2];
    }

    // создаем массив сумм трех последовательно расположенных элементов
    public static void anArrayOfAmounts(int numK, int numM, int[] array) {
        int[] arraySum = new int[(numM - numK) - 1];
        int j = 0;
        for (int i = numK; i < numM - 1; i++) {
            arraySum[j] = sumOfThreeElements(i, array);
            j++;
        }
        System.out.println("Сумма трех последовательно расположенных элементов с номерами от " + numK + " до " + numM + ": ");
        for (int i = 0; i < arraySum.length; i++) {
            System.out.println("[" + numK + "," + (numK + 1) + "," + (numK + 2) + "]: " + arraySum[i]);
            numK++;
        }
    }

    //разобъем четырехугольник на 2 треугольника, один из которых прямоугольный
    //недостающая сторона второго треугольника, не прямоугольного
    public static double hypotenuse(int sideA, int sideB) {
        return sqrt(sideA * sideA + sideB * sideB);
    }

    //определим площадь четырехугольника как сумма площадей двух треугольников
    public static void squareQuadrilateral(int sideA, int sideB, int sideC, int sideD) {
        double area1 = (sideA * sideB) / 2; //определим площадь прямоугольного треугольника
        double sideE = hypotenuse(sideA, sideB);
        double halfPerimetr = (sideC + sideD + sideE) / 2; //полупериметр второго треугольника
        //определяем площадь второго треугольника по формуле Герона
        double area2 = sqrt(halfPerimetr * (halfPerimetr - sideC) * (halfPerimetr - sideD) * (halfPerimetr - sideE));
        double area = area1 + area2; //возвращаем площадь четырехугольника (сумма площадей двух треугольников)
        System.out.printf("Площадь четырехугольника равна %.2f", area);
    }

    public static void arrayOfNumbers(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int[] array = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            array[i] = Character.getNumericValue(ch[i]);
        }
        System.out.println("\nМассив из числа N = " + num + ": " + Arrays.toString(array));
    }

    public static void numberOfDigits(int num1, int num2) {
        char[] charArr1 = Integer.toString(abs(num1)).toCharArray();
        char[] charArr2 = Integer.toString(abs(num2)).toCharArray();
        if (charArr1.length > charArr2.length) {
            System.out.println("Количество цифр в числе " + num1 + " больше, чем в числе " + num2);
        } else if (charArr1.length == charArr2.length) {
            System.out.println("Количество цифр в числе " + num1 + " равно количеству цифр в числе " + num2);
        } else {
            System.out.println("Количество цифр в числе " + num2 + " больше, чем в числе " + num1);
        }
    }

    //создаем массив из числа
    public static int[] arrayOfNumbers12(int num) {
        char[] charArr = Integer.toString(num).toCharArray();
        int[] array = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            array[i] = Character.getNumericValue(charArr[i]);
        }
        return array;
    }

    //находим сумму цифр числа
    public static int sumOfOddNumbers(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    //определяем длину массива, в который будем записывать числа, удовлетворяющие условию задачи
    public static int lengthArray(int numN, int numK) {
        int length = 0;
        for (int i = 0; i <= numN; i++) {
            if (sumOfOddNumbers(arrayOfNumbers12(i)) == numK) {
                length++;
            }
        }
        return length;
    }

    //создаем массив чисел согласно условию задачи
    public static void newArray(int numN, int numK) {
        int[] array = new int[lengthArray(numN, numK)];
        int j = 0;
        for (int i = 0; i <= numN; i++) {
            if (sumOfOddNumbers(arrayOfNumbers12(i)) == numK) {
                array[j] = i;
                j++;
            }
        }
        System.out.println("При K = " + numK + " и N = " + numN + ", массив чисел будет выглядеть так: " + Arrays.toString(array));
    }

    //создаем массив с последовательными числами на отрезке [n, 2n]
    public static int[] createAnArray(int number) {
        int[] array = new int[(2 * number - number) + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = number + i;
        }
        return array;
    }

    //создаем матрицу, состояющую из чисел-близнецов
    public static void createAnArrayOfArrays(int number) {
        System.out.println("Пары чисел-близнецов на отрезке от " + number + " до " + 2 * number + ":");
        int[][] matrix = new int[2 * number - number - 1][2];
        for (int i = 0; i < createAnArray(number).length - 2; i++) {
            matrix[i][0] = createAnArray(number)[i];
            matrix[i][1] = createAnArray(number)[i + 2];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
    //создаем массив из числа
    public static int[] arrayOfNumbers14(int num) {
        char[] charArr = Integer.toString(num).toCharArray();
        int[] array = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            array[i] = Character.getNumericValue(charArr[i]);
        }
        return array;
    }

    //найдем сумму чисел массива, возведенную в степень, равную количеству цифр
    public static int sumOfOddNumbers14(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + (int) pow(array[i], array.length);
        }
        return sum;
    }
    //создаем массив из числа
    public static int[] arrayNumbers15(int num) {
        char[] charArr = Integer.toString(num).toCharArray();
        int[] array = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            array[i] = Character.getNumericValue(charArr[i]);
        }
        return array;
    }

    //создаем массив из n-значных чисел (n - количество цифр в числе)
    public static int[] array15(int num) {
        int[] array = new int[((int) pow(10, num)) - (int) pow(10, num - 1)];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) pow(10, num - 1) + i;
        }
        return array;
    }

    //массив чисел преобразуем в число
    public static int number15(int[] array) {
        String string = "";
        for (int i = 0; i < array.length; i++) {
            string = string + String.valueOf(array[i]);
        }
        return Integer.parseInt(string);
    }

    //находим все натуральные n-значные числа со строго возрастающей последовательностью
    public static void increasingSequence15(int n, int[] array) {
        System.out.println(n + "-значные числа со строго возрастающей последовательностью:");
        for (int i = 0; i < array.length; i++) {
            int[] temp = arrayNumbers15(array[i]);
            int count = 0;
            for (int j = 0; j < temp.length - 1; j++) {
                if (temp[j + 1] - temp[j] == 1) {
                    count++;
                } else break;
            }
            if (count == temp.length - 1) {
                System.out.println(number15(temp));
            }
        }
    }
    //создаем массив из n-значного числа
    public static int[] arrayNumbers16(int num) {
        char[] charArr = Integer.toString(abs(num)).toCharArray();
        int[] array = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            array[i] = Character.getNumericValue(charArr[i]);
        }
        return array;
    }

    //проверяем число на наличие нечетных чисел
    public static boolean oddNumber16(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                count++;
            } else break;
        }
        if (count == array.length) {
            return true;
        } else {
            return false;
        }
    }

    //найдем сумму чисел массива
    public static int sumOddNumbers16(int[] array) {
        int sum16 = 0;
        for (int i = 0; i < array.length; i++) {
            sum16 = sum16 + array[i];
        }
        return sum16;
    }

    //определяем количество четных чисел в числе
    public static int numberEvenNumbers16(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    //создаем массив из n-значного числа
    public static int[] arrayNumbers17(int num) {
        char[] charArr = Integer.toString(abs(num)).toCharArray();
        int[] array = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            array[i] = Character.getNumericValue(charArr[i]);
        }
        return array;
    }

    //найдем сумму чисел массива
    public static int sumOddNumbers17(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    //подсчитываем количество вычитаний, пока число не будет равно или меньше нуля
    public static int subtraction17(int num) {
        int count = 1;
        while (true) {
            int temp = num - sumOddNumbers17(arrayNumbers17(num));
            if (temp > 0) {
                num = temp;
                count++;
            } else break;
        }
        return count;
    }
}