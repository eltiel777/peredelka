public class peredelka {
    // Задача a
    public static void taskA(int[][] originalMatr) {
        int sum = 0;

        System.out.println("Исходная матрица:");
        for (int i = 0; i < originalMatr.length; i++) { // количество строк
            for (int j = 0; j < originalMatr[i].length; j++) { // количество столбцов
                sum += originalMatr[i][j]; // считаем сумму элементов массива
                System.out.print(originalMatr[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("Сумма элементов матрицы: " + sum);

        System.out.println("Итоговая матрица:");
        int[][] finalMatr = new int[originalMatr.length][originalMatr[0].length];
        for (int i = 0; i < originalMatr.length; i++) {
            for (int j = 0; j < originalMatr[i].length; j++) {
                finalMatr[i][j] = originalMatr[i][j] * sum; // заполнение нового массива
                System.out.print(finalMatr[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void taskB(int[][] nulMatr) {

        System.out.println("Исходная матрица:");
        for (int i = 0; i < nulMatr.length; i++) { // перебираем строки
            for (int j = 0; j < nulMatr[i].length; j++) { // перебираем столбцы
                System.out.print(nulMatr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < nulMatr.length; i++)
        {
            int index = 0; // индекс ненулевых элементов
            for (int j = 0; j < nulMatr[i].length; j++)
            { //
                if (nulMatr[i][j] != 0)
                { //если элемент ненулевой, то он перемещается влево(к началу строки)
                    nulMatr[i][index] = nulMatr[i][j];
                    index++;
                }
            }
            while (index < nulMatr[i].length)
            {
                nulMatr[i][index] = 0; //а на место ненулевых в оставшиеся элементы ставится 0
                index++;
            }
        }

        System.out.println("Измененная матрица:");
        for (int i = 0; i < nulMatr.length; i++) {
            for (int j = 0; j < nulMatr[i].length; j++) {
                System.out.print(nulMatr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Задача c

    public static void taskC(int[][] twoMatr) {
        int s = twoMatr.length * twoMatr[0].length; // размер одномерного массива
        int index = 0; // индекс для одномерного массива
        int[] oneMatr = new int[s]; // одномерный массив с длиной s

        System.out.println("Исходная матрица:");
        for (int i = 0; i < twoMatr.length; i++) { // количество строк
            for (int j = 0; j < twoMatr[i].length; j++) { // количество столбцов
                oneMatr[index] = twoMatr[i][j]; // создание одномерного массива
                index++;
                System.out.print(twoMatr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Итоговый массив:");
        for (int i = 0; i < s; i++) {
            System.out.print(oneMatr[i] + " ");
        }
        System.out.println();

        System.out.println("Отсортированный массив:");
        int temp;
        for (int i = 0; i < s - 1; i++) {
            for (int j = 0; j < s - i - 1; j++) {
                if (oneMatr[j] > oneMatr[j + 1]) {
                    temp = oneMatr[j];
                    oneMatr[j] = oneMatr[j + 1];
                    oneMatr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < s; i++) {
            System.out.print(oneMatr[i] + " ");
        }
        System.out.println();
    }

    // Задача d
    public static void taskD(String sentence) {
        String[] words = sentence.split(" "); // массив из слов, разделив их по пробелу
        int[] newMass = new int[words.length]; // массив, состоящий только из длин слов

        for (int i = 0; i < words.length; i++) {
            newMass[i] = words[i].length(); // создали новый массив
        }

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < newMass.length; i++) // проходим по массиву с длинами слов
        {
            if (newMass[i] > newMass[maxIndex]) {
                maxIndex = i;
            }
            if (newMass[i] < newMass[minIndex]) {
                minIndex = i;
            }
        }

        if (newMass[maxIndex] == newMass[minIndex]) { //если слова одинаковой длины
            System.out.println("Результат: 0");
        } else {
            int itog = Math.abs(maxIndex - minIndex) - 1;
            System.out.println("Результат:" + itog);
        }
    }

    public static void main(String[] args) {
        // Тест для задачи a
        System.out.println("--Задача a--");
        System.out.println("На основе двумерной числовой матрицы необходимо сгенерировать новую матрицу,");
        System.out.println("в которой элементы равны произведению соответствующих элементов исходной матрицы на сумму элементов исходной матрицы.");
        System.out.println("Тест 1");
        int[][] originalMatr1 = {{1, 2}, {3, 4}};
        taskA(originalMatr1);
        System.out.println("Тест 2");
        int[][] originalMatr2 = {{-1,-2}, {-3, -4}};
        taskA(originalMatr2);
        System.out.println("Тест 3");
        int[][] originalMatr3 = {{0,0}, {0, 0},{0, 0}};
        taskA(originalMatr3);

        // Тест для задачи b
        System.out.println("--Задача b--");
        System.out.println("Сдвинуть вправо все нулевые элементы матрицы.");
        System.out.println("Тест 1");
        int[][] nulMatr1 = {{0, 1,0,2},{3,0,4,5}};
        taskB(nulMatr1);
        System.out.println("Тест 2");
        int[][] nulMatr2 = {{1,3,6,8}};
        taskB(nulMatr2);
        System.out.println("Тест 3");
        int[][] nulMatr3 = {{5, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 0, 0},{0, 0, 0, 3, 1, 9}};
        taskB(nulMatr3);

        // Тест для задачи c
        System.out.println("---Задача с---");
        System.out.println("Сгенерировать новую одномерную матрицу из элементов двумерной преобразованной матрицы,");
        System.out.println("расположив элементы в порядке возрастания.");
        System.out.println("Тест 1");
        int[][] twoMatr1 = {{5, 7, 1}, {3, 8, 9}, {1, 6, 2}};
        taskC(twoMatr1);
        System.out.println("Тест 2");
        int[][] twoMatr2 = {{8, -4, 0}, {-2, 1, 4}, {5, 0, 5}};
        taskC(twoMatr2);
        System.out.println("Тест 3");
        int[][] twoMatr3 = {{2, 0, 0}, {1, 7, 12}, {100, 32, 1}};
        taskC(twoMatr3);

        // Тест для задачи d
        System.out.println("--Задача d--");
        System.out.println("Найти количество слов в предложении стоящих между самым коротким и самым длинным словом.");
        System.out.println("Тест 1");
        String sentence1 = "рыжий кот любил есть картофель очень";
        System.out.println("Предложение: " + sentence1);
        taskD(sentence1);
        System.out.println("Тест 2");
        String sentence2 = "кот кот кот кот";
        System.out.println("Предложение: " + sentence2);
        taskD(sentence2);
        System.out.println("Тест 3");
        String sentence3 = "мой брат гуляет просто так";
        System.out.println("Предложение: " + sentence3);
        taskD(sentence3);

    }
}
