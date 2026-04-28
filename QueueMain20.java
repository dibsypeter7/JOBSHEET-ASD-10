import java.util.Scanner;

public class QueueMain20 {
    static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println("Masukan operasi yang diinginkan");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        int pilih;
        Queue20 Q = new Queue20(5); // kapasitas bebas, misal 5

        do {
            menu();
            pilih = sc.nextInt();
            switch(pilih) {
                case 1:
                    System.out.print("Masukan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar);
                    }
                    break;
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}