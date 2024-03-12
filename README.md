Soru 2:
Bir e-ticaret platformu için dinamik bir ürün yönetim sistemi tasarlanması gerekiyor. Bu sistem, kullanıcıdan 
alınan girdilere göre ürünleri kaydetme, sonra da belirli kriterlere göre bu ürünleri sıralama yeteneğine sahip 
olacak. Kullanıcının ürün sayısı, her bir ürün için ad, fiyat, stok miktarı ve değerlendirme puanı gibi bilgileri 
girebilmesini, sonrasında ise bu ürünlerin farklı kriterlere göre sıralanabilmesini ve kullanıcının seçeceği ürünleri 
sepete eklemesini sağlayan bir Java programı tasarlanmalıdır.
Ürün Bilgilerinin Alınması:
 - Kullanıcıdan kaç adet ürün gireceğini sorun. (Birden fazla farklı ürün girişi yapılmalıdır, aksi taktirde 
uyarı verin)
 - Her bir ürün için kullanıcıdan ürün adı, fiyat, stok miktarı ve değerlendirme puanını (5 üzerinden) 
alın.
- Girilen fiyat bilgisi 50 ve 100 arasında olmalıdır. Aksi takdirde kullanıcıya uyarı verip tekrar girilmesi 
istenmelidir.
- Stok miktarı en az 1 olmalıdır. 1’den az olduğunda kullanıcıya uyarı verip tekrar girilmesi istenmelidir.
 - Ürün adı bilgisi en fazla 20 karakter olmalıdır. Aksi takdirde kullanıcıya uyarı verip tekrar girilmesi 
istenmelidir.
• Sıralama:
 - Kullanıcıdan ürünleri hangi kritere göre sıralamak istediğini sorun (örneğin, ad, stok, değerlendirme).
- Kullanıcıdan sıralamanın artan mı yoksa azalan mı olacağını sorun.
- Seçilen kritere ve sıralama türüne göre ürün listesini sıralayın.
• Sepete Ekleme:
 - Sıralama sonrası, kullanıcıya sepete ürün ekleyip eklemek istemediğini sorun.
 - Kullanıcı ürün eklemek istiyorsa, sepete en az iki ürün olacak şekilde ürün adını ve eklemek istediği 
adedi belirterek ürün girişi sağlanır. 
- Girilen ürün adı kontrol edilir ve stok miktarı yeterli ise ürün sepete eklenir. Aksi takdirde, stokta yeterli 
ürün olmadığı belirlelir ve kullanıcıdan yeni bir adet girmesi istenir.
• Sepete Tutarı Hesaplama:
- Kullanıcı ürün eklemeyi bitirdiğinde, sepetin toplam tutarı aşağıdaki mantığa göre hesaplanacaktır:
- Sepeee eklenme sırasına göre ilk ürün fiyatı ikinci üründen fazla ise ilk üründen ikinci ürünün birim 
maliyeti kadar indirim yapılır. Bu mantık sepetin tüm ürünleri dikkate alınarak hesaplanacaktır. 
Örnek: 
İki ürün için oluşturulan sepetin ilk hali :
Ürün Adı Adet Birim Fiyat Toplam
Deher 2 3,00 6,00
Kalem 2 1,50 3,00
Toplam 9,00
İndirim uygulanmış sepet:
Ürün Adı Adet Birim Fiyat Toplam
Deher 2 1,50 (indirim uygulanmış 
birim fiyat)
3,00
Kalem 2 1,50 3,00
Toplam 6,00
Örnek Program Akışı:
Kaç farklı ürün gireceksiniz: 2
Ürün 1:
Ürün Adı: Kalem
Birim Fiyat: 1.50
Stok Miktarı: 100
Değerlendirme Puanı: 4.5
Ürün 2:
Ürün Adı: Deher
Birim Fiyat: 3.00
Stok Miktarı: 50
Değerlendirme Puanı: 4.7
Ürünleri hangi kritere göre sıralamak istersiniz? (name/stock/rating)
Seçilen Kriter: rating
Sıralama türü artan mı azalan mı olsun? (artan/azalan)
Seçilen Sıralama Türü: azalan
Sıralanmış Ürünler:
Deher - Fiyat: 3.00, Stok: 50, Değerlendirme: 4.7
Kalem - Fiyat: 1.50, Stok: 100, Değerlendirme: 4.5
Sepete ürün eklemek ister misiniz? (Evet/Hayır): Evet
Eklemek istediğiniz ürünün adı: Deher
Eklemek istediğiniz adet: 2
Kalem sepetinize eklendi.
Sepete ürün eklemek ister misiniz? (Evet/Hayır): Evet
Eklemek istediğiniz ürünün adı: Kalem
Eklemek istediğiniz adet: 2
Kalem sepetinize eklendi.
Sepete başka ürün eklemek ister misiniz? (Evet/Hayır): Hayır
Sepetiniz:
Deher - Adet: 2, Toplam Fiyat : 3.00
Kalem - Adet: 2, Toplam Fiyat : 3.00
Sepet Toplamı: 6.00
