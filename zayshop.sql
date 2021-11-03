-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 02, 2021 lúc 03:55 PM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `zayshop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `cid` int(11) NOT NULL,
  `cname` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`cid`, `cname`) VALUES
(1, 'Nike'),
(2, 'Adidas'),
(5, 'puma');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact`
--

CREATE TABLE `contact` (
  `ct_id` int(11) NOT NULL,
  `ct_fullname` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ct_email` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ct_subject` varchar(11) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ct_content` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `contact`
--

INSERT INTO `contact` (`ct_id`, `ct_fullname`, `ct_email`, `ct_subject`, `ct_content`) VALUES
(1, 'tưởng', 'abc@gmail.com', 'ád', 'adasf');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `pid` int(11) NOT NULL,
  `pname` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `picture` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_create` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `count_views` int(11) NOT NULL DEFAULT 0,
  `detail` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `c_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`pid`, `pname`, `price`, `picture`, `date_create`, `count_views`, `detail`, `c_id`) VALUES
(4, 'Bộ đá bóng CLB Real Madrid xanh biển mới 2020', 100, '1-461962380720900.jpg', '2021-11-02 09:07:29', 0, 'Nếu bạn đam mê bộ môn túc cầu thì một bộ áo đấu chuẩn đẹp là vật không thể thiếu của chúng ta, hãy nhanh tay chọn cho mình một bộ nào!', 2),
(5, 'Áo quần bóng đá tuyển Hà Lan cam mới 2021', 80, '2-462072163092400.jpg', '2021-11-02 09:09:18', 0, 'Nếu bạn đam mê bộ môn túc cầu thì một bộ áo đấu chuẩn đẹp là vật không thể thiếu của chúng ta, hãy nhanh tay chọn cho mình một bộ nào!', 5),
(6, 'Áo thi đấu đội tuyển Việt Nam trắng mới 2020', 120, '3-462113558205800.jpg', '2021-11-02 09:10:00', 0, 'Nếu bạn đam mê bộ môn túc cầu thì một bộ áo đấu chuẩn đẹp là vật không thể thiếu của chúng ta, hãy nhanh tay chọn cho mình một bộ nào!', 1),
(7, 'Áo quần bóng rổ Warriors xanh trẻ em mới 2020', 75, '4-462178022480500.jpg', '2021-11-02 09:11:04', 0, 'Quần áo trẻ em', 2),
(8, ' ao-polo-camaro-vang-moi-2020 ', 140, '6-462225530917900.jpg', '2021-11-02 14:29:13', 0, '- Tên Sản Phẩm: Áo Polo Camaro Vàng\r\n- Chất liệu: Thun Poli Cá Sấu - Chắc chắn bền bỉ\r\n- Màu sắc: Vàng\r\n- Size S-M-L-XL-XXL\r\n- Có thể mặc đi chơi dạo phố, chơi thể thao, làm việc.... tất cả đều phù hợp\r\n- Thiết kế đơn giản thanh lịch, nam tính', 5),
(9, ' Đồ đá banh CLB Bayern Munich xanh xám mới 2020', 90, '6-462310178430900.jpg', '2021-11-02 14:29:03', 0, 'Nếu bạn đam mê bộ môn túc cầu thì một bộ áo đấu chuẩn đẹp là vật không thể thiếu của chúng ta, hãy nhanh tay chọn cho mình một bộ nào!', 2),
(10, ' giay-bong-da-chinh-hang-prowin-h21-xanh-chuoi - ảnh nhỏ  1 Giày bóng đá chính hãng Prowin - H21 Xanh Chuối', 200, '7-462382025115000.jpg', '2021-11-02 14:18:04', 1, 'Thiết kế mẫu giày form bè là một sự lựa chọn hoàn toàn chuẩn xác bởi hầu như form chân người Việt nói riêng và Châu Á nói chung thì hầu như mọi người đều có dạng bè ngang và hơi dài thì đây là một sự lựa chọn hoàn toàn chuẩn xác đến với người tiêu dùng.', 5),
(11, 'Giày bóng đá chính hãng Prowin - H21 Đen', 170, '8-462421314227700.jpg', '2021-11-02 14:17:42', 3, 'Thiết kế mẫu giày form bè là một sự lựa chọn hoàn toàn chuẩn xác bởi hầu như form chân người Việt nói riêng và Châu Á nói chung thì hầu như mọi người đều có dạng bè ngang và hơi dài thì đây là một sự lựa chọn hoàn toàn chuẩn xác đến với người tiêu dùng.', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_EDITOR');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `username` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fullname` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enabled` int(11) NOT NULL DEFAULT 1,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`u_id`, `username`, `fullname`, `password`, `enabled`, `role_id`) VALUES
(7, 'admin', 'Võ Văn Tưởng', '$2a$10$MDHHjo0vzfC.FBo2GHZxfOIAHkgrVwtr5oOSq1wbzVjN2ePVH0Gfa', 1, 1),
(8, 'member', 'võ yên', '$2a$10$8WNcysKaUC4cM.NgZc/6LejBMgqD7a6sXUHwdmVYm1j.JW5xurFG6', 1, 2),
(9, 'edit', 'quoc', '$2a$10$a3Wm4/2r9wBJ9HcAsvZyx.UKF2TLZ1MYFtF614N8R7ETBtmjiHd4G', 1, 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`cid`);

--
-- Chỉ mục cho bảng `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`ct_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`pid`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `contact`
--
ALTER TABLE `contact`
  MODIFY `ct_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
