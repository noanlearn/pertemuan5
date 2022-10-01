import java.util.ArrayList;
import java.util.Scanner;

/**
 * Javaaplication1
 */


public class Javaaplication1 {

    public static void main(String[] args) {
        ArrayList<Pesan> p = new ArrayList();
        Scanner sc = new Scanner(System.in);
        Integer pilihan = 0;

        do {
            /*
                Jika dipilih 1, maka input data
                jika 2, maka tampilkan data
                jika 3 maka keluar sistem 
            */

            System.out.println("---------------------------");
            System.out.println("--- Bintang Buck Coffee ---");
            System.out.println("---------------------------");
            System.out.println("  1. Pembelian");
            System.out.println("  2. Bayar");
            System.out.println("  3. Keluar sistem");
            System.out.println("---------------------------");
            System.out.print("  Pilihanmu: ");
            pilihan = sc.nextInt();
            System.out.println();

            if (pilihan == 1) {
                p = beli(p);
            } else if (pilihan == 2) {
                p = bayar(p);
            }
        } while (pilihan != 3);
    }
    
    private static ArrayList<Pesan> beli(ArrayList<Pesan> p) {
        Scanner sc = new Scanner(System.in);
        String nama, tipe, gula;
        Integer harga, qty;
        Boolean done;

        do {
            System.out.print("  Nama: ");
            nama = sc.nextLine();
            done = cekNama(nama);
        } while (done == false);
        
        System.out.print("  Tipe: ");
        tipe = sc.nextLine();

        System.out.print("  Gula: ");
        gula = sc.nextLine();

        System.out.print("  Harga: ");
        harga = sc.nextInt();

        do {
            System.out.print("  Qty: ");
            qty = sc.nextInt();
            done = cekQty(qty);
        } while (done == false);

        p.add(new Pesan(nama, tipe, gula, harga, qty));
        return p;
 
    }
    
    private static Boolean cekNama(String nama) {
        boolean done = false;

        if (nama.equalsIgnoreCase("Americano") || nama.equalsIgnoreCase("Latte") || nama.equalsIgnoreCase("Arabika")) {
            done = true;
        } else {
            System.out.println("  --- Nama harus Americano, Latte, Arabika ---");
            System.out.println();
        }
        return done;
    }
    
    private static Boolean cekQty(Integer qty) {
        boolean done = false;

        if(qty > 0){
            done = true;
        } else {
            System.out.println("  --- Minimal qty pembelian 1 buah ---");
            System.out.println();
        } 

        return done;
    }

    private static ArrayList<Pesan> bayar(ArrayList<Pesan> p) {
        Scanner sc = new Scanner(System.in);
        Integer total_bayar;
        Boolean done;

        // tampilkan data
        System.out.println("Jumlah data: " + p.size()); //ini error
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-3s | %-10s | %-10s | %-10s | %-7s | %-3s | %-7s |", 
            "No",
            "Nama",
            "Tipe",
            "Gula",
            "Harga",
            "Qty",
            "Jumlah");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

        Integer total = 0;
        for (int i = 0; i < p.size(); i++) {
            System.out.printf("| %-3s | %-10s | %-10s | %-10s | %-7s | %-3s | %-7s |",
                    i + 1,
                    p.get(i).getNama(),
                    p.get(i).getTipe(),
                    p.get(i).getGula(),
                    p.get(i).getHarga(),
                    p.get(i).getQty(),
                    total = (p.get(i).getHarga() * p.get(i).getQty()));
            System.out.println();
            System.out.println("------------------------------------------------------------------------");

        }

        System.out.println("Total               = Rp " + total);

        do {
            System.out.print("Masukan pembayaran  = Rp ");
            total_bayar = sc.nextInt();
            done = cekPembayaran(total, total_bayar);

        } while (done == false);

        System.out.println();
        System.out.println("Terima Kasih, Selamat Menikmati...");
        sc.nextLine();

        p.clear();
        return p;
    }

    private static Boolean cekPembayaran(Integer total, Integer total_bayar) {
        Boolean done = false;
        if (total_bayar >= total) {
            System.out.println("Kembalian Anda      = Rp " + (total_bayar - total));
            done = true;
        } else {
            System.out.println("--- Mohon maaf, uang Anda tidak cukup! ---");
            System.err.println();
        }
        return done;
    }
}