public class AntrianKRS {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;
    int totalDilayani;    
    int maxDilayaniDPA;   

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.totalDilayani = 0;
        this.maxDilayaniDPA = 30;
    }

  
    public boolean isEmpty() {
        return size == 0;
    }


    public boolean isFull() {
        return size == max;
    }

   
    public boolean isDPAFull() {
        return totalDilayani >= maxDilayaniDPA;
    }

  
    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak dapat menambah mahasiswa.");
            return;
        }
        if (isDPAFull()) {
            System.out.println("DPA sudah menangani " + maxDilayaniDPA + " mahasiswa. Layanan ditutup.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk ke antrian KRS. (Nomor antrian: " + size + ")");
    }

  
    public Mahasiswa panggilSatu() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return null;
        }
        Mahasiswa mhs = data[front];
        front = (front + 1) % max;
        size--;
        totalDilayani++;
        return mhs;
    }

    
    public void panggilAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada mahasiswa yang dipanggil.");
            return;
        }
        System.out.println("=== Memanggil Antrian untuk Proses KRS ===");
        int jumlahDipanggil = Math.min(2, size);
        for (int i = 0; i < jumlahDipanggil; i++) {
            Mahasiswa mhs = panggilSatu();
            if (mhs != null) {
                System.out.print("Mahasiswa ke-" + (i + 1) + " dipanggil: ");
                mhs.tampilkanData();
            }
        }
        System.out.println("Total sudah diproses KRS: " + totalDilayani + " mahasiswa.");
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Antrian KRS:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("2 Mahasiswa Terdepan dalam Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        int jumlah = Math.min(2, size);
        for (int i = 0; i < jumlah; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanPalingAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.print("Mahasiswa paling akhir dalam antrian: ");
        data[rear].tampilkanData();
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getTotalDilayani() {
        return totalDilayani;
    }

    public int getBelumProses() {
        return size;
    }

    public void kosongkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian sudah kosong.");
            return;
        }
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }
}