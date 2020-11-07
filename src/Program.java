import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "CP1251");
        
        // Задача 1
        //----------------------------------------------------------------//
        
        System.out.print("Введите размер квадратной матрицы: ");

        // Ввод размера матрицы
        int size = inputValue(1, 10); 
        
        // Инициализация квадратной матрицы
        int[][] matrix = new int[size][size];
        
        System.out.println("\nВведите элементы квадратной матрицы:");  
        
        // Заполнение матрицы
        for (int row = 0; row < size; row++)
            for (int column = 0; column < size; column++) {
                System.out.print("Matrix[" + (row + 1) + "," + (column + 1) + "] = ");
                
                // Ввод текущего элемента матрицы
                matrix[row][column] = inputValue(-1000, 1000);
            }
        
        // Поиск мин. элемента
        int minElement = getMinElement(matrix); 
        
        System.out.println("Мин. элемент квадратной матрицы = " + minElement);
        
        // Задача 2
        //----------------------------------------------------------------//
        
        System.out.println("\nВведите слова через запятую:");
        
        // Ввод строрки слов через запятую
        String stringOfWords = scanner.nextLine();
        
        // Разделение строки на отдельные слова по запятой
        String[] arrayOfWords = stringOfWords.split(", ");

        System.out.print("\nВведите номер выбранного слова: ");
        
        // Ввод номера выбранного слова
        int number = inputValue(1, arrayOfWords.length);
        
        // Поиск и переворачиванеие выбранного слова
        String word = arrayOfWords[number - 1];        
        String reverseWord = reverseString(word);
        
        // Занесение перевернутого слова в исходную строку
        stringOfWords = stringOfWords.replaceFirst(word, reverseWord);
        
        System.out.println("Строка с перевернутым словом:");
        System.out.println(stringOfWords);
        
        // Задача 3
        //----------------------------------------------------------------//
        
        System.out.println("\nВведите предложение (слова через пробел):");
        
        // Ввод предложения (слов через пробел)
        stringOfWords = scanner.nextLine(); 
        
        // Разделоение предложения на слова по пробелу
        arrayOfWords = stringOfWords.split(" ");
        
        // Удаление каждого 3-го слова из массива
        stringOfWords = removeEachThirdWord(arrayOfWords);                
        
        System.out.println("\nСтрока с удаленным каждым 3-им словом:");
        System.out.println(stringOfWords);
        
        //----------------------------------------------------------------//
    }
    
    // Ввод числа в заданных пределах
    public static int inputValue(int limit1, int limit2) {
        if (limit1 > limit2)
            throw new IllegalArgumentException
                ("Левый предел значений не может быть больше правого!");

        int value = limit1 - 1;
        String error = "Некорректный ввод!\nПовторите ввод данных: ";

        do {
            Scanner scanner = new Scanner(System.in, "CP1251");

            if (!scanner.hasNextInt()) System.out.print(error);            
            else {
                value = scanner.nextInt();
                
                if (value < limit1 || value > limit2) 
                    System.out.print(error);
            }
        } while (value < limit1 || value > limit2);

        return value;
    }
    
    // Поиск мин. элемента матрицы
    public static int getMinElement(int[][] matrix) {
        int minElement = matrix[0][0]; 
        
        for (int[] array : matrix)
            for (int element : array)
                if (element < minElement) minElement = element; 
        
        return minElement;
    } 
    
    // Переворачивание строки
    public static String reverseString(String word) {
        StringBuilder reverseWord = new StringBuilder();

        for (int index = word.length() - 1; index >= 0; index--)
            reverseWord.append(word.charAt(index));

        return reverseWord.toString();
    }
    
    // Удаление каждого 3-го слова в предложении
    public static String removeEachThirdWord(String[] arrayOfWords) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < arrayOfWords.length; index++)
            if ((index + 1) % 3 != 0)
                stringBuilder.append(arrayOfWords[index]).append(" ");

        return stringBuilder.toString();
    }
}