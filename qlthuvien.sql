-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 15, 2022 lúc 03:52 AM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlthuvien`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieumuon`
--

CREATE TABLE `chitietphieumuon` (
  `idSach` int(11) NOT NULL,
  `idPhieuMuon` int(11) NOT NULL,
  `NgayTra` date DEFAULT NULL,
  `TinhTrangSach` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MucPhat` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieumuon`
--

INSERT INTO `chitietphieumuon` (`idSach`, `idPhieuMuon`, `NgayTra`, `TinhTrangSach`, `MucPhat`) VALUES
(2, 20, '2022-06-19', 'Tốt', 0),
(10, 20, '2022-06-19', 'Tốt', 0),
(9, 21, '2022-06-18', 'Hư hỏng', 20000),
(4, 21, '2022-06-18', 'Tốt', 0),
(8, 23, '2022-06-18', 'Tốt', 0),
(4, 24, '2022-06-19', 'Tốt', 0),
(1, 26, '2022-06-19', 'Tốt', 0),
(7, 26, '2022-06-19', 'Tốt', 0),
(84, 28, '2022-06-20', 'Mất', 50000),
(71, 28, '2022-06-20', 'Tốt', 0),
(82, 43, NULL, '', 0),
(10, 43, NULL, '', 0),
(83, 46, '2022-06-20', 'Tốt', 0),
(83, 47, '2022-06-20', 'Tốt', 0),
(88, 51, '2022-06-20', 'Tốt', 0),
(74, 51, '2022-06-20', 'Tốt', 0),
(96, 53, '2022-06-20', 'Tốt', 0),
(1, 53, '2022-06-20', 'Tốt', 0),
(92, 56, '2022-06-20', 'Tốt', 50000),
(88, 58, '2022-06-20', 'Hư hỏng', 50000),
(3, 60, '2022-11-14', 'Mất', 50000),
(65, 60, '2022-11-14', 'Tốt', 0),
(80, 61, '2022-11-15', 'Hư hỏng', 70000),
(146, 61, '2022-11-15', 'Tốt', 0),
(91, 61, '2022-11-15', 'Tốt', 0),
(28, 62, NULL, '', 0),
(74, 62, NULL, '', 0),
(5, 62, NULL, '', 0),
(96, 63, NULL, '', 0),
(29, 63, NULL, '', 0),
(121, 63, NULL, '', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhmuc`
--

CREATE TABLE `danhmuc` (
  `idDM` int(11) NOT NULL,
  `TenDanhMuc` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `danhmuc`
--

INSERT INTO `danhmuc` (`idDM`, `TenDanhMuc`) VALUES
(1, 'Công nghệ thông tin'),
(2, 'Kĩ năng sống khỏe'),
(3, 'Triết học'),
(4, 'Thiếu nhi'),
(5, 'Trinh Thám'),
(9, 'Văn học'),
(10, 'Giáo trình');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dausach`
--

CREATE TABLE `dausach` (
  `idDS` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `idDM` int(11) NOT NULL,
  `TenSach` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `TacGia` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NhaXuatBan` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NamXuatBan` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `MoTa` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `dausach`
--

INSERT INTO `dausach` (`idDS`, `idDM`, `TenSach`, `TacGia`, `NhaXuatBan`, `NamXuatBan`, `SoLuong`, `MoTa`) VALUES
('S001', 2, 'Ăn kiêng keto', 'Nguyễn Xuân An', 'Sống Khỏe', '2022', 5, 'Sách dành cho người muốn sống khỏe'),
('S0010', 9, 'Ngữ văn nâng cao', 'Cao Văn Đài', 'Spider', '2022', 5, 'Sách tham khảo cho hs'),
('S0011', 1, 'Học khôn ngoan mà không gian nan', 'Adam Khoo', 'Kim Đồng', '2011', 15, 'Sách giúp học tốt\n'),
('S0012', 3, 'Nhà giả kim', 'Varga', 'Spider', '2016', 20, 'Sách về cuộc phiêu lưu của 1 cậu bé chăn cừu\n'),
('S0013', 9, 'Ánh sáng thành phố', 'Lôi Mễ', 'Hoằng Dung', '2017', 5, 'Sách trinh thám gay cấn\n'),
('S0014', 1, 'Toán cao cấp 1', 'Hoàng Hương Giang', 'Trường ĐH Quốc Gia', '2015', 5, 'Giáo trình toán cao cấp 1 trường ĐH điện lực\n'),
('S0015', 10, 'Toán cao cấp 2', 'Hoàng Văn Khải', 'Đh Quốc Gia', '2019', 5, 'Giái trình chuẩn toán cao cấp 2\n'),
('S0016', 10, 'Lịch sử Đảng cộng sản VN', 'Bùi Văn Chung', 'ĐH Quốc gia', '2019', 10, 'Giáo trình '),
('S0017', 5, 'Đề thi đẫm máu', 'Lôi Mễ', 'Spider', '2022', 10, 'Trinh thám gay cấn\n'),
('S0018', 1, 'Phương pháp lập trình Java', 'Nguyễn Mạnh Hoàng', 'Kim Đồng', '2016', 3, 'Giải quyết các vấn đề về hệ thống khi lập trình Java\n'),
('S0019', 2, 'Con chúng ta đều tài giỏi', 'Adam Khoo', 'Spider', '2018', 5, 'sách dạy con'),
('S002', 1, 'Tôi đi code dạo', 'Nguyễn Huy Hoàng', 'spiderum', '2019', 5, 'Chill code'),
('S0020', 2, 'Thất bại là mẹ thành công', 'Văn Cao', 'Spider', '2018', 5, 'Đứng vững trước mọi khó khăn'),
('S003', 3, 'Cuộc đời của một dân chơi làng Vũ Đại', 'Chí Phèo', 'Kim đồng', '1998', 5, 'tái hiện hình ảnh của một đân chơi làng Vũ Đại'),
('S004', 1, 'Lập trình C cơ bản', 'Brian Kernighan Dennis Ritchie', 'Kim đồng', '2010', 7, 'Ngôn ngữ lập trình C, một ngôn ngữ cơ bản dành cho người mới bắt đầu lập trình'),
('S005', 5, 'Kẻ tầm xương', 'Jeffery Deaver', 'Kim đồng', '2018', 5, 'Truyện khá gay cấn, nhiều bất ngờ và thu hút được sự tò mò của người đọc.'),
('S006', 5, 'Sherlock Homes', ' Arthur Conan Doyle', 'Kim đồng', '2000', 9, 'Holmes nổi danh với khả năng quan sát, diễn dịch, khoa học pháp y điêu luyện và suy luận logic tuyệt vời, những yếu tố mà anh áp dụng khi điều tra các vụ án của nhiều dạng khách hàng'),
('S007', 4, 'Truyện cổ tích tấm cám', 'Dân gian', 'Kim đồng', '2020', 10, 'Truyện kể về cuộc đấu đá nội bộ gia đình giữa 2 chị em gái '),
('S008', 3, 'Tư tưởng Hồ Chí Minh', 'Mạch Quang Thắng', 'Nhà xuất bản Chính trị Quốc gia', '2022', 5, 'Tư tưởng của chủ tịch HCM vĩ đại'),
('S009', 9, 'Ngữ Văn 12', 'Nguyễn Hoàng Anh', 'Kim Đồng', '2010', 10, 'Sách của bộ giáo dục');

--
-- Bẫy `dausach`
--
DELIMITER $$
CREATE TRIGGER `after_delete` AFTER DELETE ON `dausach` FOR EACH ROW BEGIN
        DELETE FROM sach WHERE sach.idDS = old.idDS;
    END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_members_insert` AFTER INSERT ON `dausach` FOR EACH ROW BEGIN
        DECLARE a INT;
        IF(new.SoLuong > 0) THEN
             SET a=1;
             WHILE a <= new.SoLuong DO
                INSERT sach (idDS, TrangThai) VALUES (new.idDS, 1);
                SET a=a+1;
             END WHILE;
        END IF;
    END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_update` AFTER UPDATE ON `dausach` FOR EACH ROW BEGIN
        DECLARE a INT;
        DELETE FROM sach WHERE idDS = new. idDS;
        IF(new.SoLuong > 0) THEN
             SET a=1;
             WHILE a <= new.SoLuong DO
                INSERT sach (idDS, TrangThai) VALUES (new.idDS, 1);
                SET a=a+1;
             END WHILE;
        END IF;
    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `docgia`
--

CREATE TABLE `docgia` (
  `idDocGia` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `docgia`
--

INSERT INTO `docgia` (`idDocGia`, `HoTen`, `DiaChi`, `Email`, `SDT`, `NgaySinh`) VALUES
('DG0000', 'Trần Quế Trân', 'Cao Bằng', 'uka07@gmail.com', '0907347627', '1999-07-07'),
('DG0001', 'Nguyễn Thị Phương Mai', 'Hà Nội', 'mit@gmail.com', '0386202101', '1999-10-01'),
('DG0002', 'Phùng Thái Sơn', 'Hà Nội', 'sondz@gmail.com', '0383637563', '2002-02-26'),
('DG0003', 'Nguyễn Trí Thành', 'Hà Nội', 'thanhdan@gmail.com', '0978787824', '2002-09-18'),
('DG0004', 'Chu Văn An', 'Hà Nam', 'Anct@gmail.com', '0978725011', '1996-02-09'),
('DG0005', 'Chu Thị Nhã Phương', 'Bắc Giang', 'phuongvt@gmail.com', '0912349876', '1996-02-17'),
('DG0006', 'Nguyễn Anh Nam', 'Quảng Ninh', 'nam@gmail.com', '0141412412', '2022-06-20'),
('DG0007', 'Nguyễn Trung Nguyên', 'Thái Bìn\nh', 'nguyen@gmail.com', '0987123412', '2001-11-06'),
('DG0008', 'Võ Văn Thắng', 'Gia Lâm\n', 'thang@gmail.com', '0912499439', '2001-11-01');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `idNhanVien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `HoTenNV` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PhanQuyen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`idNhanVien`, `password`, `HoTenNV`, `NgaySinh`, `DiaChi`, `SDT`, `PhanQuyen`) VALUES
('NV01', '$argon2id$v=19$m=15360,t=2,p=1$P8GVEtO8as9br6TQDMiF2jdzODnjyiPojEVQT8N8vfM$f6ORQyI0wyOmyyarjZcZYgMB/zDpD3snjavbXhS7nnv9krzCBDmHfY/HHDkBmEH9YR7fczRn3xiNmLZRXbDoCg', 'Nguyễn Mai', '2022-11-15', 'Hà Nội', '0386202101', 1),
('NV02', '$argon2id$v=19$m=15360,t=2,p=1$qkmwGmN6NYZ4YJRGwhRoaw8VjwZI/q2k7p+DnoGtCrM$+KwBlNk6wWCFeUBMK4v2w5glntcy7LrNnoC7u+dZTDjkSPYVL4q8GFe09NyD6ubwemOsPum9Z7kdpKyQNArSDQ', 'Sơn Phùng', '2022-11-15', 'Hà Nội', '0383637563', 1),
('NV03', '$argon2id$v=19$m=15360,t=2,p=1$uAgNUS/vxUgKWywMEJZ5JzgdJgfmhhDxY1/MpNPo2iU$dLhGMrtcUsCQFg2FtGxPArXFiqHgYL8mKH7tcPeFkJORtjnSkzsXPuDMOPdbhemw8cbLA5Dnlpm/aR3fBnuqBg', 'Admin Trần', '2022-11-15', 'Cao Bằng', '0142414234', 0),
('NV04', '$argon2id$v=19$m=15360,t=2,p=1$PM1i+r7f4WqeLke7Owl9K77/CYtHoTH8gcmsxss/Ww0$KfHrbjB3zhMeopE7voEYAbtAmjONymsqLE6wv1Uk+bks5PKw9TJCHQBR4ECSo+TBx0l5aGUewMYpyou/j9dn5Q', 'Trần Anh Tú', '2022-11-15', 'Hà Nam', '0412434133', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieumuontra`
--

CREATE TABLE `phieumuontra` (
  `idDocGia` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `idPhieuMuon` int(11) NOT NULL,
  `idNhanVien` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `HanMuon` int(11) NOT NULL,
  `NgayMuon` date NOT NULL,
  `GhiChu` text COLLATE utf8_unicode_ci DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieumuontra`
--

INSERT INTO `phieumuontra` (`idDocGia`, `idPhieuMuon`, `idNhanVien`, `HanMuon`, `NgayMuon`, `GhiChu`, `TrangThai`) VALUES
('DG0001', 20, 'NV01', 7, '2022-06-18', '', 2),
('DG0001', 21, 'NV01', 7, '2022-06-18', 'Trả đẹp ', 2),
('DG0000', 23, 'NV01', 7, '2022-06-18', '', 2),
('DG0000', 24, 'NV01', 10, '2022-06-18', 'a', 2),
('DG0001', 26, 'NV01', 10, '2022-06-19', '', 2),
('DG0005', 28, 'NV01', 8, '2022-06-20', '', 2),
('DG0004', 43, 'NV01', 4, '2022-06-20', '', 1),
('DG0001', 46, 'NV01', 7, '2022-06-20', '', 2),
('DG0001', 47, 'NV01', 4, '2022-06-20', '', 2),
('DG0004', 51, 'NV01', 10, '2022-06-20', '', 2),
('DG0004', 53, 'NV01', 10, '2022-06-20', '', 2),
('DG0005', 56, 'NV01', 10, '2022-06-20', 'Mất sách', 2),
('DG0003', 58, 'NV04', 10, '2022-06-20', 'Hỏng sách', 2),
('DG0001', 60, 'NV01', 6, '2022-11-14', 'Mất sách', 2),
('DG0008', 61, 'NV01', 14, '2022-11-15', 'Không', 2),
('DG0007', 62, 'NV01', 7, '2022-11-15', '', 1),
('DG0004', 63, 'NV01', 14, '2022-11-15', '', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `idSach` int(11) NOT NULL,
  `idDS` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`idSach`, `idDS`, `TrangThai`) VALUES
(1, 'S001', 1),
(2, 'S001', 1),
(3, 'S001', 0),
(4, 'S001', 1),
(5, 'S001', 0),
(6, 'S002', 1),
(7, 'S002', 1),
(8, 'S002', 1),
(9, 'S002', 0),
(10, 'S002', 0),
(25, 'S003', 1),
(26, 'S003', 1),
(27, 'S003', 1),
(28, 'S003', 0),
(29, 'S003', 0),
(49, 'S005', 1),
(50, 'S005', 1),
(51, 'S005', 1),
(52, 'S005', 1),
(53, 'S005', 0),
(61, 'S006', 1),
(62, 'S006', 1),
(63, 'S006', 1),
(64, 'S006', 1),
(65, 'S006', 1),
(66, 'S006', 1),
(67, 'S006', 1),
(68, 'S006', 1),
(69, 'S006', 1),
(70, 'S007', 1),
(71, 'S007', 1),
(72, 'S007', 1),
(73, 'S007', 1),
(74, 'S007', 0),
(75, 'S007', 1),
(76, 'S007', 1),
(77, 'S007', 1),
(78, 'S007', 1),
(79, 'S007', 1),
(80, 'S008', 0),
(81, 'S008', 1),
(82, 'S008', 0),
(83, 'S008', 1),
(84, 'S008', 0),
(85, 'S004', 1),
(86, 'S004', 1),
(87, 'S004', 1),
(88, 'S004', 0),
(89, 'S004', 1),
(90, 'S004', 1),
(91, 'S004', 1),
(92, 'S009', 1),
(93, 'S009', 1),
(94, 'S009', 1),
(95, 'S009', 1),
(96, 'S009', 0),
(97, 'S009', 1),
(98, 'S009', 1),
(99, 'S009', 1),
(100, 'S009', 1),
(101, 'S009', 1),
(102, 'S0010', 1),
(103, 'S0010', 1),
(104, 'S0010', 1),
(105, 'S0010', 1),
(106, 'S0010', 1),
(107, 'S0011', 1),
(108, 'S0011', 1),
(109, 'S0011', 1),
(110, 'S0011', 1),
(111, 'S0011', 1),
(112, 'S0011', 1),
(113, 'S0011', 1),
(114, 'S0011', 1),
(115, 'S0011', 1),
(116, 'S0011', 1),
(117, 'S0011', 1),
(118, 'S0011', 1),
(119, 'S0011', 1),
(120, 'S0011', 1),
(121, 'S0011', 0),
(142, 'S0012', 1),
(143, 'S0012', 1),
(144, 'S0012', 1),
(145, 'S0012', 1),
(146, 'S0012', 1),
(147, 'S0012', 1),
(148, 'S0012', 1),
(149, 'S0012', 1),
(150, 'S0012', 1),
(151, 'S0012', 1),
(152, 'S0012', 1),
(153, 'S0012', 1),
(154, 'S0012', 1),
(155, 'S0012', 1),
(156, 'S0012', 1),
(157, 'S0012', 1),
(158, 'S0012', 1),
(159, 'S0012', 1),
(160, 'S0012', 1),
(161, 'S0012', 1),
(162, 'S0013', 1),
(163, 'S0013', 1),
(164, 'S0013', 1),
(165, 'S0013', 1),
(166, 'S0013', 1),
(167, 'S0014', 1),
(168, 'S0014', 1),
(169, 'S0014', 1),
(170, 'S0014', 1),
(171, 'S0014', 1),
(172, 'S0015', 1),
(173, 'S0015', 1),
(174, 'S0015', 1),
(175, 'S0015', 1),
(176, 'S0015', 1),
(177, 'S0016', 1),
(178, 'S0016', 1),
(179, 'S0016', 1),
(180, 'S0016', 1),
(181, 'S0016', 1),
(182, 'S0016', 1),
(183, 'S0016', 1),
(184, 'S0016', 1),
(185, 'S0016', 1),
(186, 'S0016', 1),
(187, 'S0017', 1),
(188, 'S0017', 1),
(189, 'S0017', 1),
(190, 'S0017', 1),
(191, 'S0017', 1),
(192, 'S0017', 1),
(193, 'S0017', 1),
(194, 'S0017', 1),
(195, 'S0017', 1),
(196, 'S0017', 1),
(197, 'S0018', 1),
(198, 'S0018', 1),
(199, 'S0018', 1),
(200, 'S0019', 1),
(201, 'S0019', 1),
(202, 'S0019', 1),
(203, 'S0019', 1),
(204, 'S0019', 1),
(205, 'S0020', 1),
(206, 'S0020', 1),
(207, 'S0020', 1),
(208, 'S0020', 1),
(209, 'S0020', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD KEY `idSach` (`idSach`),
  ADD KEY `idPhieuMuon` (`idPhieuMuon`);

--
-- Chỉ mục cho bảng `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`idDM`);

--
-- Chỉ mục cho bảng `dausach`
--
ALTER TABLE `dausach`
  ADD PRIMARY KEY (`idDS`),
  ADD KEY `idDM` (`idDM`);

--
-- Chỉ mục cho bảng `docgia`
--
ALTER TABLE `docgia`
  ADD PRIMARY KEY (`idDocGia`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`idNhanVien`);

--
-- Chỉ mục cho bảng `phieumuontra`
--
ALTER TABLE `phieumuontra`
  ADD PRIMARY KEY (`idPhieuMuon`),
  ADD KEY `idDocGia` (`idDocGia`),
  ADD KEY `idNhanVien` (`idNhanVien`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`idSach`),
  ADD KEY `idDS` (`idDS`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `idDM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `phieumuontra`
--
ALTER TABLE `phieumuontra`
  MODIFY `idPhieuMuon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `idSach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=210;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieumuon`
--
ALTER TABLE `chitietphieumuon`
  ADD CONSTRAINT `chitietphieumuon_ibfk_1` FOREIGN KEY (`idSach`) REFERENCES `sach` (`idSach`),
  ADD CONSTRAINT `chitietphieumuon_ibfk_2` FOREIGN KEY (`idPhieuMuon`) REFERENCES `phieumuontra` (`idPhieuMuon`);

--
-- Các ràng buộc cho bảng `dausach`
--
ALTER TABLE `dausach`
  ADD CONSTRAINT `dausach_ibfk_1` FOREIGN KEY (`idDM`) REFERENCES `danhmuc` (`idDM`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `phieumuontra`
--
ALTER TABLE `phieumuontra`
  ADD CONSTRAINT `phieumuontra_ibfk_1` FOREIGN KEY (`idNhanVien`) REFERENCES `nhanvien` (`idNhanVien`),
  ADD CONSTRAINT `phieumuontra_ibfk_2` FOREIGN KEY (`idDocGia`) REFERENCES `docgia` (`idDocGia`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`idDS`) REFERENCES `dausach` (`idDS`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
