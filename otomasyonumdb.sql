-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 03 Haz 2022, 03:01:01
-- Sunucu sürümü: 10.4.22-MariaDB
-- PHP Sürümü: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `otomasyonumdb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `kID` int(11) NOT NULL,
  `kul_adi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(100) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`kID`, `kul_adi`, `sifre`) VALUES
(1, 'resedat', '12345'),
(2, 'admin', '12345'),
(14, 'admin', '123456');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_kategori`
--

CREATE TABLE `tbl_kategori` (
  `id` int(11) NOT NULL,
  `kategori` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tbl_kategori`
--

INSERT INTO `tbl_kategori` (`id`, `kategori`) VALUES
(5, 'Çay Makinesi'),
(7, 'Bulaşık'),
(9, 'Ocak'),
(10, 'Bulaşık Makinesi'),
(11, 'Kurutma Makinesi'),
(12, 'Fırın'),
(13, 'Derin Dondurucu'),
(14, 'Set Üstü Ocak'),
(15, 'Su Sebili'),
(16, 'Kurutmalı Çamaşır Makinesi'),
(17, 'Davlumbaz'),
(18, 'Aspiratör'),
(19, 'Tost Makinesi'),
(20, 'Televizyon'),
(21, 'Robot'),
(26, 'Set Üstü Fıtrın');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_marka`
--

CREATE TABLE `tbl_marka` (
  `id` int(11) NOT NULL,
  `kategori` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `marka` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tbl_marka`
--

INSERT INTO `tbl_marka` (`id`, `kategori`, `marka`) VALUES
(9, 'Bulaşık Makinesi', 'Bosch'),
(11, 'Derin Dondurucu', 'Altus'),
(12, 'Fırın', 'Profilo'),
(13, 'Kurutma Makinesi', 'Arçelik'),
(14, 'Set Üstü Ocak', 'Beko'),
(15, 'Su Sebili', 'Lenovo'),
(16, 'Çamaşır Makinesi', 'Windsor'),
(17, 'Mikrodalga Fırın', 'Finlux'),
(18, 'Elektrikli Süpürge', 'Siemens'),
(19, 'Aspiratör', 'Silverline'),
(21, 'Davlumbaz', 'SEG'),
(22, 'Tost Makinesi', 'Pierre Cardin'),
(23, 'Çay Makinesi', 'Philips'),
(27, 'Kahve Makinesi', 'Bosch');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_musteri`
--

CREATE TABLE `tbl_musteri` (
  `Id` int(11) NOT NULL,
  `adsoyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `tc` varchar(11) COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(11) COLLATE utf8_turkish_ci NOT NULL,
  `adres` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tbl_musteri`
--

INSERT INTO `tbl_musteri` (`Id`, `adsoyad`, `tc`, `telefon`, `adres`, `email`) VALUES
(6, 'Sedat Barlin', '11111111111', '05458888888', 'İskenderun', 'sedatbarlin@gmail.com'),
(7, 'İbrahim Çelik', '22222222222', '05465555555', 'Antakya', 'ibrahimcelik@hotmail.com'),
(8, 'Mehmet Kanat', '33333333333', '05436666666', 'Antalya', 'mehmetkanat@gmail.com'),
(9, 'Müslüm Dolak', '44444444444', '05425788888', 'Ankara', 'muslumdolak@hotmail.com'),
(10, 'Baki Aslan', '55555555555', '05426989984', 'Hatay', 'bakiaslan@gmail.com'),
(11, 'Müslüm Albayrak', '66666666666', '05356988952', 'İstanbul', 'muslumalbayrak@hotmail.com'),
(12, 'Nihat Barlin', '77777777777', '05428521569', 'İzmir', 'nihatbarlin@gmail.com'),
(13, 'Mahmut Barlin', '88888888888', '05359689895', 'Şanlıurfa', 'mahmutbarlin@hotmail.com'),
(14, 'Onur Tümkaya', '99999999999', '05462589654', 'Harbiye', 'onurtmkyy@gmail.com'),
(15, 'Halil İbrahim İçten', '10000000000', '05345898565', 'Adana', 'halilibo22@gmail.com'),
(16, 'Özkan Taşkıran', '11000000000', '05468526989', 'Ağrı', 'ozkan@gmail.com'),
(17, 'Faik Cem Güler', '11000000000', '05436989895', 'Antakya', 'faikcem@hotmail.com'),
(18, 'Müslüm Barlin', '12000000000', '05465898522', 'Şanlıurfa', 'muslumbarlin@gmail.com'),
(19, 'Arda Barlin', '13000000000', '05469875442', 'Çanakkale', 'ardabarlin@gmail.com'),
(22, 'Abdulkadir Şahin', '14000000000', '05469898216', 'Hakkari', 'abdulkadir@gmail.com'),
(23, 'Mehmet Barlin', '1500000000', '0542158996', 'Şanlıurfa', 'mehmet@hotmail.com'),
(24, 'Fatih Şahin', '16000000000', '05422159985', 'Karaköprü', 'fatih@gmail.com'),
(25, 'Şükrü Şahin', '17000000000', '05412546985', 'İstanbul', 'sukru@gmail.com'),
(26, 'Ali Şahin', '18000000000', '05426598886', 'Eskişehir', 'ali@gmail.com'),
(27, 'Ahmet Şahin', '19000000000', '05426598526', 'Antalya', 'ahmet@hotmail.com'),
(28, 'Ömer Faruk Şahin', '20000000000', '05433659852', 'Elazığ', 'omer@gmail.com'),
(29, 'Furkan Şahin', '21000000000', '05412569985', 'Kırşehir', 'furkan@gmail.com'),
(30, 'Hakim Şahin', '22000000000', '05412587445', 'Bartın', 'hakim@gmail.com');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_satislistele`
--

CREATE TABLE `tbl_satislistele` (
  `id` int(100) NOT NULL,
  `tc` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `adsoyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `barkodno` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `urunadi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `miktari` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `satisfiyati` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `toplamfiyati` varchar(100) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tbl_satislistele`
--

INSERT INTO `tbl_satislistele` (`id`, `tc`, `adsoyad`, `telefon`, `barkodno`, `urunadi`, `miktari`, `satisfiyati`, `toplamfiyati`) VALUES
(1, '11111111111', 'Sedat Barlin', '05458888888', '10', 'Çamaşır Makinesi', '5', '600', '3000'),
(2, '22222222222', 'İbrahim Çelik', '05465555555', '16', 'Bulaşık Makinesi', '3', '1000', '3000'),
(3, '66666666666', 'Müslüm Albayrak', '05356988952', '15', 'Televizyon', '6', '950', '5700'),
(4, '44444444444', 'Müslüm Dolak', '05425788888', '11', 'Buzdolabı', '6', '600', '3600'),
(5, '88888888888', 'Mahmut Barlin', '05359689895', '13', 'Fırın', '5', '900', '4500'),
(6, '77777777777', 'Nihat Barlin', '05428521569', '20', 'Kurutma Makinesi', '9', '2200', '19800'),
(7, '11111111111', 'Furkan Şahin', '054668955622', '11', 'Çamaşır Makinesi', '8', '500', '4000');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_satisyap`
--

CREATE TABLE `tbl_satisyap` (
  `id` int(50) NOT NULL,
  `tc` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `adsoyad` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `telefon` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `barkodno` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `urunadi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `miktari` int(50) NOT NULL,
  `satisfiyati` int(50) NOT NULL,
  `toplamfiyati` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tbl_urunekle`
--

CREATE TABLE `tbl_urunekle` (
  `id` int(100) NOT NULL,
  `barkodno` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `kategori` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `marka` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `urunadi` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `miktari` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `alisfiyati` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `satisfiyati` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tbl_urunekle`
--

INSERT INTO `tbl_urunekle` (`id`, `barkodno`, `kategori`, `marka`, `urunadi`, `miktari`, `alisfiyati`, `satisfiyati`) VALUES
(2, '11', 'Buzdolabı', 'Siemens', 'Buzdolabı', '10', '600', '850'),
(3, '12', 'Fırın', 'Bosch', 'Fırın', '10', '700', '1000'),
(4, '13', 'Fırın', 'Kumtel', 'Fırın', '20', '900', '1350'),
(5, '14', 'Televizyon', 'Arçelik', 'Televizyon', '35', '950', '1450'),
(6, '15', 'Televizyon', 'LG', 'Televizyon', '40', '1000', '1600'),
(7, '16', 'Çamaşır Makinesi', 'Regal', 'Çamaşır Makinesi', '40', '1100', '1350'),
(8, '17', 'Çamaşır Makinesi', 'Altus', 'Çamaşır Makinesi', '50', '1250', '1500'),
(9, '18', 'Bulaşık Makinesi', 'Beko', 'Bulaşık Makinesi', '50', '1000', '1850'),
(10, '19', 'Bulaşık Makinesi', 'Vestel', 'Bulaşık Makinesi', '50', '1000', '1450'),
(11, '20', 'Kurutma Makinesi', 'SEG', 'Kurutma Makinesi', '40', '2200', '3000');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`kID`);

--
-- Tablo için indeksler `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_marka`
--
ALTER TABLE `tbl_marka`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_musteri`
--
ALTER TABLE `tbl_musteri`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `tbl_satislistele`
--
ALTER TABLE `tbl_satislistele`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_satisyap`
--
ALTER TABLE `tbl_satisyap`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `tbl_urunekle`
--
ALTER TABLE `tbl_urunekle`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `kID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_kategori`
--
ALTER TABLE `tbl_kategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_marka`
--
ALTER TABLE `tbl_marka`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_musteri`
--
ALTER TABLE `tbl_musteri`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_satislistele`
--
ALTER TABLE `tbl_satislistele`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_satisyap`
--
ALTER TABLE `tbl_satisyap`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Tablo için AUTO_INCREMENT değeri `tbl_urunekle`
--
ALTER TABLE `tbl_urunekle`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
