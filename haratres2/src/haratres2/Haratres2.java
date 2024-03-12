package haratres2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Haratres2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Product> sepetList = new ArrayList<Product>();
        HashMap<Product, Integer> sepet = new HashMap<Product, Integer>();

        System.out.println("Kaç farklı ürün gireceksiniz: ");   //(Birden fazla farklı ürün girişi yapılmalıdır, aksi takdirde uyarı verin
        int girilenUrunSayisi = sc.nextInt();

        if (girilenUrunSayisi <= 1) {
            System.out.println("Birden fazla farklı ürün girişi yapılmalıdır, lütfen tekrar deneyin.");
            return;
        }

        sc.nextLine(); // int'den sonra hata almamak için

        for (int i = 0; i < girilenUrunSayisi; i++) {
            System.out.println("Ürün " + (i + 1) + ":");

            String urunAdi;
            do {
                System.out.println("Ürün Adı (En fazla 20 karakter olmalıdır): ");
                urunAdi = sc.nextLine();
            } while (urunAdi.length() > 20);

            float birimFiyat;
            do {
                System.out.println("Birim Fiyat (50 ve 100 arasında olmalıdır): ");
                birimFiyat = sc.nextFloat();
            } while (birimFiyat < 50 || birimFiyat > 100);

            int stokMiktari;
            do {
                System.out.println("Stok miktarı (En az 1 olmalıdır): ");
                stokMiktari = sc.nextInt();
            } while (stokMiktari < 1);

            float degerlendirmePuani;
            do {
                System.out.println("Değerlendirme Puanı (5 üzerinden): ");
                degerlendirmePuani = sc.nextFloat();
            } while (degerlendirmePuani < 0 || degerlendirmePuani > 5);

            Product product = new Product(urunAdi, birimFiyat, stokMiktari, degerlendirmePuani);
            products.add(product);
            sc.nextLine(); // int'den sonra hata almamak için
        }

        while (true) {
            System.out.println("Ürünleri hangi kritere göre sıralamak istersiniz? (name/price/stock/rating)");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("name")) {
                System.out.println("Seçilen Kriter: " + choice);
                products.sort(Comparator.comparing(Product::getName));
                break;
            } else if (choice.equalsIgnoreCase("price")) {
                System.out.println("Seçilen Kriter: " + choice);
                products.sort(Comparator.comparing(Product::getPrice));
                break;
            } else if (choice.equalsIgnoreCase("stock")) {
                System.out.println("Seçilen Kriter: " + choice);
                products.sort(Comparator.comparingInt(Product::getStock));
                break;
            } else if (choice.equalsIgnoreCase("rating")) {
                System.out.println("Seçilen Kriter: " + choice);
                products.sort(Comparator.comparing(Product::getRating));
                break;
            } else {
                System.out.println("Geçersiz seçenek. Lütfen 'name', 'price', 'stock' veya 'rating' seçeneklerinden birini girin.");
            }
        }

        while (true) {
            System.out.println("Sıralama türü artan mı olsun azalan mı ? (artan/azalan)");
            String sortType = sc.nextLine();

            if (sortType.equalsIgnoreCase("artan")) {
                break;
            } else if (sortType.equalsIgnoreCase("azalan")) {
                Collections.reverse(products);
                break;
            } else {
                System.out.println("Geçersiz seçenek. Lütfen 'artan' veya 'azalan' seçeklerinden birini girin.");
            }
        }

        System.out.println("Sıralama sonucu:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Stock: " + product.getStock() + ", Rating: " + product.getRating());
        }

        String sepetChoice;
        while (true) {
            System.out.println("Sepete ürün eklemek ister misiniz ? (E/H) :");
            sepetChoice = sc.nextLine();

            if (sepetChoice.equalsIgnoreCase("E")) {
                System.out.println("Eklemek istediğiniz ürünün adı: ");
                String eklenecekUrun = sc.nextLine();
                System.out.println("Eklemek istediğiniz adet : ");
                int adet = sc.nextInt();
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getName().equals(eklenecekUrun)) {

                        if (products.get(i).getStock() >= adet) {
                            sepet.put(products.get(i), adet);
                            sepetList.add(products.get(i));
                            System.out.println(products.get(i).getName() + " sepetinize eklendi.");
                            break;
                        } else {
                            System.out.println("Yeterli stok bulunmamaktadır. Bilgileri tekrar giriniz !!");
                            break;
                        }
                    }
                    if (i == products.size() - 1) {
                        System.out.println("Aradığınız ürün bulunamadı");
                    }
                }
                sc.nextLine(); // int'den sonra hata almamak için
            } else if (sepetChoice.equalsIgnoreCase("H")) {
                if (sepet.size() < 2) {
                    System.out.println("Sepetinizde en az 2 ürün bulunmak zorundadır lütfen ürün eklemeye devam edin!!");
                } else {
                    System.out.println("Sepetinizin ilk (indirimsiz) hali:");
                    for (HashMap.Entry<Product, Integer> entry : sepet.entrySet()) {
                        Product product = entry.getKey();
                        int adet = entry.getValue();
                        System.out.println("Ürün: " + product.getName() + " - Adet: " + adet + ", Toplam Fiyat: " + (product.getPrice() * adet));
                    }
                    break;
                }
            } else {
                System.out.println("Geçersiz seçenek. Lütfen 'E' veya 'H' seçeneklerinden birini girin.");
            }
        }

        //indirim yapıyoruz      
        for (int i = 0; i < sepetList.size() - 1; i++) {
            if (sepetList.get(i).getPrice() > sepetList.get(i + 1).getPrice()) {
                float yeniFiyat = sepetList.get(i).getPrice() - sepetList.get(i + 1).getPrice();
                sepetList.get(i).setPrice(yeniFiyat);
            }
        }

        float toplamTutar = 0;
        System.out.println("Sepetinizin son (indirimli) hali : ");
        for (HashMap.Entry<Product, Integer> entry : sepet.entrySet()) {
            Product product = entry.getKey();
            int adet = entry.getValue();
            System.out.println("Ürün: " + product.getName() + " - Adet: " + adet + ", Toplam Fiyat: " + (product.getPrice() * adet));
            toplamTutar = toplamTutar + (product.getPrice() * adet);
        }

        System.out.println("SEPET TOPLAMI : " + toplamTutar);
    }
}
