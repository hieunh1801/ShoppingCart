USE [WebsiteBanLaptop]
GO
/****** Object:  Table [dbo].[HIBERNATE_GEN_ID]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HIBERNATE_GEN_ID](
	[GEN_NAME] [varchar](50) NULL,
	[GEN_VALUE] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbArticle]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbArticle](
	[articleid] [int] NOT NULL,
	[title] [nvarchar](255) NULL,
	[content] [text] NULL,
	[thumbnail] [varchar](255) NULL,
	[laptopid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[articleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbCategory]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCategory](
	[categoryid] [int] NOT NULL,
	[name] [nvarchar](255) NULL,
	[parentid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbInvoice]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbInvoice](
	[invoiceId] [int] NOT NULL,
	[employeeId] [int] NULL,
	[supplierId] [int] NULL,
	[createdate] [datetime] NULL,
	[notes] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[invoiceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbInvoiceDetail]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbInvoiceDetail](
	[invoiceDetailId] [int] NOT NULL,
	[invoiceId] [int] NULL,
	[laptopid] [int] NULL,
	[amount] [int] NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[invoiceDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbLaptop]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbLaptop](
	[laptopid] [int] NOT NULL,
	[name] [nvarchar](255) NULL,
	[title] [nvarchar](255) NULL,
	[description] [nvarchar](3999) NULL,
	[quantity] [int] NULL,
	[size] [varchar](50) NULL,
	[weight] [varchar](50) NULL,
	[height] [varchar](50) NULL,
	[color] [varchar](50) NULL,
	[image] [varchar](255) NULL,
	[memory] [nvarchar](255) NULL,
	[os] [nvarchar](255) NULL,
	[ram] [nvarchar](255) NULL,
	[cpu] [nvarchar](255) NULL,
	[battery] [nvarchar](255) NULL,
	[categoryid] [int] NULL,
	[status] [int] NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[laptopid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbOrder]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbOrder](
	[orderid] [int] NOT NULL,
	[customerid] [int] NULL,
	[status] [bit] NULL,
	[createdate] [datetime] NULL,
	[totalprice] [float] NULL,
	[note] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[orderid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbOrderDetail]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbOrderDetail](
	[orderDetailId] [int] NOT NULL,
	[orderid] [int] NULL,
	[laptopid] [int] NULL,
	[totalprice] [float] NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbPromotion]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbPromotion](
	[promotionid] [int] NOT NULL,
	[value] [varchar](20) NULL,
	[discount] [float] NULL,
	[laptopid] [int] NULL,
	[startdate] [datetime] NULL,
	[enddate] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[promotionid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbRole]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbRole](
	[roleid] [int] NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbSupplier]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbSupplier](
	[supplierid] [int] NOT NULL,
	[name] [nvarchar](50) NULL,
	[phone] [varchar](20) NULL,
	[address] [nvarchar](100) NULL,
	[image] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[supplierid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbUser]    Script Date: 10/27/2019 2:24:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbUser](
	[userid] [int] NOT NULL,
	[username] [varchar](255) NULL,
	[password] [varchar](255) NULL,
	[roleid] [int] NULL,
	[avatar] [varchar](255) NULL,
	[fullname] [nvarchar](255) NULL,
	[status] [bit] NULL,
	[address] [nvarchar](255) NULL,
	[phone] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbUser', 2)
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbLaptop', 12)
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbInvoice', 20)
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbInvoiceDetail', 26)
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbOrder', 3)
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbOrderDetail', 5)
INSERT [dbo].[HIBERNATE_GEN_ID] ([GEN_NAME], [GEN_VALUE]) VALUES (N'tbPromotion', 13)
INSERT [dbo].[tbCategory] ([categoryid], [name], [parentid]) VALUES (1, N'MSI', 1)
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (1, 1, 1, CAST(N'1970-01-01T07:00:00.020' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (2, 1, 1, CAST(N'1970-01-01T07:00:00.020' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (3, 1, 1, CAST(N'1970-01-01T07:00:00.020' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (4, 1, 1, CAST(N'2019-10-21T22:40:26.540' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (5, 1, 1, CAST(N'2019-10-21T22:48:06.467' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (6, 1, 1, CAST(N'2019-10-21T22:50:15.287' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (7, 1, 1, CAST(N'2019-10-21T22:53:22.350' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (8, 1, 1, CAST(N'2019-10-21T22:56:32.153' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (9, 1, 1, CAST(N'2019-10-21T22:58:12.783' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (10, 1, 1, CAST(N'2019-10-21T22:59:21.933' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (11, 1, 1, CAST(N'2019-10-21T23:03:38.357' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (12, 1, 1, CAST(N'2019-10-22T15:54:40.127' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (13, 1, 1, CAST(N'2019-10-22T23:12:12.170' AS DateTime), N'')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (14, 1, 1, CAST(N'2019-10-22T23:21:14.660' AS DateTime), N'abc')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (15, 1, 1, CAST(N'2019-10-22T23:31:12.123' AS DateTime), N'1')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (16, 1, 1, CAST(N'2019-10-22T23:34:49.707' AS DateTime), N'1')
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (17, 1, 2, CAST(N'2019-10-26T15:35:36.367' AS DateTime), NULL)
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (18, 1, 3, CAST(N'2019-10-26T15:36:15.997' AS DateTime), NULL)
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (19, 1, 4, CAST(N'2019-10-26T15:36:39.850' AS DateTime), NULL)
INSERT [dbo].[tbInvoice] ([invoiceId], [employeeId], [supplierId], [createdate], [notes]) VALUES (20, 1, 5, CAST(N'2019-10-26T15:37:09.643' AS DateTime), NULL)
INSERT [dbo].[tbInvoiceDetail] ([invoiceDetailId], [invoiceId], [laptopid], [amount], [price]) VALUES (1, 1, NULL, 30, 1000)
INSERT [dbo].[tbInvoiceDetail] ([invoiceDetailId], [invoiceId], [laptopid], [amount], [price]) VALUES (2, 1, NULL, 10, 1200)
INSERT [dbo].[tbInvoiceDetail] ([invoiceDetailId], [invoiceId], [laptopid], [amount], [price]) VALUES (17, 14, NULL, 10, 111)
INSERT [dbo].[tbInvoiceDetail] ([invoiceDetailId], [invoiceId], [laptopid], [amount], [price]) VALUES (18, 15, NULL, 2, 1)
INSERT [dbo].[tbInvoiceDetail] ([invoiceDetailId], [invoiceId], [laptopid], [amount], [price]) VALUES (22, 18, 7, 20, 15000000)
INSERT [dbo].[tbInvoiceDetail] ([invoiceDetailId], [invoiceId], [laptopid], [amount], [price]) VALUES (23, 18, 7, 15, 10000000)
INSERT [dbo].[tbLaptop] ([laptopid], [name], [title], [description], [quantity], [size], [weight], [height], [color], [image], [memory], [os], [ram], [cpu], [battery], [categoryid], [status], [price]) VALUES (3, N'Dell Inspiron 5482 C4TI7007W', N'Laptop Dell Inspiron 5482 C4TI7007W Core i7-8565U/ Win10 (14 inch FHD IPS Touch) - Hàng Chính Hãng', N'<p>Thiết kế đơn giản</p><p><strong>Laptop Dell Inspiron 5482 C4TI7007W Core i7-8565U/ Win10 (14 inch FHD IPS Touch) - Hàng Chính Hãng&nbsp;</strong>được thiết kế khá đơn giản nhưng vẫn đảm bảo sự sang trọng, tinh tế với tông màu bạc và các góc cạnh được bo tròn nhẹ tạo cảm giác thoải mái khi cầm nắm. Phần khung máy cứng cáp, chắc chắn giúp bảo vệ tốt các linh kiện bên trong. Đặc biệt để đem lại sự thuận tiện cho người dùng, máy đã được thiết kế khá mỏng nhẹ</p><p>Màn hình 14 inch</p><p>Với màn hình 14 inch có độ phân giải Full HD (1920 x 1080), Dell Inspiron 5482 C4TI7007W mang đến cho người dùng những phút giây giải trí ấn tượng cùng những hình ảnh chi tiết ró nét, màu sắc trung thực ấn tượng. Không chỉ đó, đây còn là một màn hình cảm ứng nhanh nhạy giúp bạn làm mọi việc thật hoàn hảo.</p><p>Cấu hình mạnh mẽ</p><p>Laptop Dell Inspiron 5482 C4TI7007W vẫn được trang bị một cấu hình mạnh mẽ để có thể đáp ứng tốt nhu cầu của bạn. Được tiếp sức mạnh bởi bộ vi xử lý Intel Core i7 thế hệ thứ 8 với bộ nhớ Ram 8GB DDR4, máy có khả năng xử lý đa nhiệm mượt mà, ổn định. Ổ cứng SSD 256GB giúp việc khởi động máy trở nên nhanh chóng hơn và bạn sẽ không cần chờ đợi lâu nữa. Bên cạnh đó, máy còn được trang bị card đồ họa tích hợp Intel UHD Graphics 620. Với cấu hình này, bạn có thể làm việc tốt với các phần mềm văn phòng, chỉnh sửa hình ảnh/video hoặc chơi một số tựa game online đang được yêu thích hiện nay.</p><p>Cổng kết nối đa dạng</p><p>Trong suốt quá trình sử dụng máy, bạn luôn cần kết nối thiết bị của mình với các thiết bị khác để trao đổi dữ liệu. Chính vì vậy, Laptop Dell Inspiron 5482 C4TI7007W đã được lắp đặt đầy đủ các cổng kết nối cần thiết điển hình như cổng USB 3.1 Gen 1 Type-C với khả năng kết nối hai chiều và tốc độ trao đổi dữ liệu nhanh hơn nhiều lần so với cổng USB 2.0. Ngoài ra, máy còn có các cổng USB 3.1 Gen 1, HDMI, SD card.</p><p><i>* Giá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Tuy nhiên tuỳ vào từng loại sản phẩm hoặc phương thức, địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, .</i></p><figure class="image"><img src="http://localhost:8080/images\6d111c1dc4c5879f5a61a2009c802bc9.jpg"></figure>', 105, N'14 inch', N'2Kg', N'2cm', N'Xám', N'http://localhost:8080/images\6d111c1dc4c5879f5a61a2009c802bc9.jpg', N'256GB SSD M.2 NVMe', N'Windows 10 Home SL 64-bit', N'1 x 8GB DDR4 2666MHz', N'i7-8565U', N'3 cell 42 Wh Pin liền', 1, 0, NULL)
INSERT [dbo].[tbLaptop] ([laptopid], [name], [title], [description], [quantity], [size], [weight], [height], [color], [image], [memory], [os], [ram], [cpu], [battery], [categoryid], [status], [price]) VALUES (4, N'Apple MB Pro Touch Bar 2019', N'Apple Macbook Pro Touch Bar 2019 - 13 inchs (i5/ 8GB/ 128GB) - Hàng Nhập Khẩu Chính Hãng', N'<p>Thiết kế cao cấp, sang trọng</p><p><strong>Apple Macbook Pro Touch Bar 2019 - 13 Inchs (i5/ 8GB/ 128GB)</strong>&nbsp;được thiết kế sang trọng, tinh tế với khung làm bằng hợp kim nhôm đảm bảo được toàn bộ kiến trúc của máy có một trọng lượng mỏng và nhẹ, giúp bạn dễ dàng mang theo, bỏ trong balo hoặc túi xách một cách thuận tiện.</p><figure class="image"><img src="http://localhost:8080/images\d27c67da780d9af9ced2c173a00ee6c4.jpg"></figure><p>Màn hình Retina siêu ấn tượng</p><p>Màn hình Retina trên MacBook Pro 13 Touch Bar 2019 là màn hình tốt nhất từ trước đến nay trên những chiếc laptop Mac. Màn hình này sử dụng đèn nền LED và độ tương phản cao, tạo ra màu đen sâu thẳm cùng ánh sáng trắng sáng hơn. Công nghệ P3 wide color và sRGB giúp màu xanh và đỏ rực rỡ hơn. Ngoài ra phiên bản Touch Bar còn có cả công nghệ True Tone, cân bằng trắng tự động dựa theo nhiệt độ môi trường để mang đến trải nghiệm tự nhiên nhất. Không thể không nhắc đến độ phân giải siêu cao 5120 x 1600 pixels, cho bạn những hình ảnh sắc nét đến từng chi tiết.</p><figure class="image"><img src="http://localhost:8080/images\0efc0da411e3f74d338682c221ee1781.jpg"></figure><p>Vi xử lý Intel Core i5 mới nhất</p><p>Sức mạnh của MacBook Pro Touch Bar (2019) đã được nâng cấp vượt trội, với bốn lõi thay vì chỉ hai lõi như các thế hệ trước đây. Bộ vi xử lý cho tốc độ 1.4GHz Turbo Boost 3.9GHz, giúp MacBook Pro 2019 có hiệu năng CPU đạt tới tầm cao mới, xử lý tuyệt vời mọi tác vụ chuyên dụng. Bạn có thể thao tác thoải mái với những ứng dụng nặng như rending video 3D; thêm các hiệu ứng đặc biệt; xử lý bản nhạc đa phương tiện; lập trình các phần mềm phức tạp; … mọi thứ đều diễn ra nhanh chóng như ý muốn.</p><p>Tích hợp card đồ họa rời Intel Iris Plus Graphic 645</p><p>Chiếc MacBook Pro 2019 13 inch này được sử dụng GPU đồ họa Intel Iris Plus Graphics 645 cực mạnh, cho khả năng xử lý đồ họa mạnh hơn rất nhiều. Mọi game 3D hay các tác vụ đồ họa nặng đều sẽ diễn ra một cách trơn tru và mượt mà.</p><figure class="image"><img src="http://localhost:8080/images\ba99cb7baee28142521e7e98001739b1.jpg"></figure>', 31, N'13 inch', N'1kg', N'1.5cm', N'Xám', N'http://localhost:8080/images\0efc0da411e3f74d338682c221ee1781.jpg', N'8GB 2133MHz LPDDR3 memory', N'Preinstalled macOS Mojave', N'8GB 2133MHz LPDDR3 memory', N'Intel Core I5, 1.4 GHz Turbo Boost up to 3.9 GHz with 4 Cores, 8 Threads', N'9 cell', 1, 0, NULL)
INSERT [dbo].[tbLaptop] ([laptopid], [name], [title], [description], [quantity], [size], [weight], [height], [color], [image], [memory], [os], [ram], [cpu], [battery], [categoryid], [status], [price]) VALUES (9, N'Lenovo IdeaPad L340-15IRH', N'Laptop Lenovo IdeaPad L340-15IRH 81LK007HVN Core i5-9300H/ GTX 1050 3GB/ Dos (15.6 FHD IPS) - Hàng Chính Hãng', N'<p>Thiết kế ấn tượng, nhỏ gọn</p><p><strong>Laptop Lenovo IdeaPad L340-15IRH 81LK007HVN Core i5-9300H/ GTX 1050 3GB/ Dos (15.6 FHD IPS)</strong>&nbsp;được thiết đầy ấn tượng ngay từ đầu với chế độ chăm sóc mắt, màn trập webcam vật lý và công nghệ sạc nhanh chóng, tất cả đều là tiêu chuẩn. Máy có độ dày 23.9 mm và trọng lượng chỉ 2.19 kg không quá nặng để mang đi.</p><p>Hiệu năng mạnh mẽ với chip Intel Core i5-9300H</p><p>Máy được trang bị chip Intel Core i5-9300H thế hệ mới với xung nhịp tối đa lên đến 4.1GHz và RAM DDR4 8 GB giúp xử lý các tác vụ trơn tru và máy hoạt động ổn định. Ổ cứng kèm theo máy là 1TB HDD giúp bạn thoải mái lưu trữ dữ liệu cá nhân. Ngoài ta máy còn hỗ trợ khe cắm SSD M.2 Sata để bạn dễ dàng nâng cấp ổ cứng SSD giúp khởi động máy, khởi động các hệ điều hành nhanh hơn, cũng như xử lý đa nhiệm một cách nhanh chóng.</p><p>Làm mới nhanh &amp; mượt</p><p>IdeaPad L340 thực hiện hoàn hảo bất cứ nhiệm vụ nào. Cùng với việc tăng năng suất, nó được thiết kế để giải trí khi đang di chuyển, bao gồm cả phát trực tuyến và chơi trò chơi. Đặc biệt với Webcam HD của IdeaPad L340 sẽ giúp bạn dễ dàng trò chuyện video và thực hiện các cuộc gọi hội nghị nhanh chóng. Nó cũng có TrueBlock Privacy Shutter, một công tắc để bạn đóng webcam nhanh và giúp giữ kín cuộc sống cá nhân của bạn.</p><p>Công nghệ âm thanh Dolby Audio tiên tiến</p><p>Máy được tích hợp công nghệ âm thanh Dolby Audio tiên tiến mang đến cho người dùng trải nghiệm thực sự đắm chìm với âm thanh phong phú, rõ ràng và mạnh mẽ cho mọi thứ từ phim ảnh đến podcast và âm nhạc đến các trò chơi.</p><p>Chế độ chăm sóc mắt hiện đại</p><p>Cho dù đó là cho công việc, giải trí hoặc bài tập về nhà, quá nhiều giờ trước màn hình PC có thể không tốt cho mắt của bạn. Nhưng với chế độ chăm sóc mắt của Lenovo Vantage, bạn có thể giảm phát xạ ánh sáng xanh và giảm thiểu nguy cơ mỏi mắt.</p><p>Thoải mái sử dụng với dung lượng pin khá</p><p>IdeaPad L340 sử dụng pin 3 Cell 45 WHr, dung lượng pin khá lớn, quá đủ cho việc đi lại hàng ngày của bạn hoặc để xem chương trình truyền hình yêu thích của bạn. Và với Rapid Charge, pin sẽ sạc lại tới 80% trong vòng một giờ và 100% trong chưa đầy hai tiếng.</p><p><i>* Giá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Tuy nhiên tuỳ vào từng loại sản phẩm hoặc phương thức, địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, ..</i></p><figure class="image"><img src="http://localhost:8080/images\9fb11c48e08bbc4df968a2473ce61f67.jpg"></figure>', 15, N'15 inch', N'2.1 kg', N'2cm', N'Ðen', N'http://localhost:8080/images\f78a5a8c7269f9aee6dc0a9f06d7b021.jpg', N'HDD 1TB 5400rpm, x1 slot SSD M.2 (SATA/ PCIe)', N'Free DOS', N'8GB DDR4 2666MHz (1x SO-DIMM socket, up to 16GB SDRAM)', N'Core i5-9300H', N'3 Cell 45 WHr', 1, 0, NULL)
INSERT [dbo].[tbLaptop] ([laptopid], [name], [title], [description], [quantity], [size], [weight], [height], [color], [image], [memory], [os], [ram], [cpu], [battery], [categoryid], [status], [price]) VALUES (10, N'MSI GF63 Thin 9RCX-645VN', N'Laptop MSI GF63 Thin 9RCX-645VN Core i7-9750H/ GTX 1050Ti 4GB/ Win10 (15.6 FHD IPS) - Hàng Chính Hãng', N'<p>Thiết kế mỏng nhẹ với vỏ nhôm Aluminum</p><p><strong>Laptop MSI GF63 Thin 9RCX-645VN Core i7-9750H/ GTX 1050Ti 4GB/ Win10 (15.6 FHD IPS)</strong> là dòng sẳn phẩm mới nhất của MSI sử dụng chip thế hệ thứ 9, Sản phẩm hướng đến đôi tượng game thủ chuyên nghiệp. Với cấu hình cao cấp đi kèm card đồ họa mới nhất chắc chắn sẽ làm các game thủ hài lòng. Đặc biệt với thiết kế ấn tượng phần vỏ mặt trên làm bằng vỏ kim loại xước và cấu tạo bàn phím liền kề, măt dưới với khe thông gió hình chữ X ẩn vô cùng độc đáo.</p><p>Bộ vi xử lý Intel Core i7</p><p>Máy được trang bị bộ vi xử lý Intel Core i7-9750H với xung nhịp có thể lên đến 4.5GHz, cho bạn những giây phút lướt web nhanh hơn, mạnh mẽ hơn. Bên cạnh đó, với bộ nhớ trong Ram 8GB DDR4 (2666MHz) đảm bảo xử lí các tác vụ đa nhiệm thật mượt mà và ổn định. Ngoài ra, máy còn trang bị thêm ổ cứng 512GB SSD M.2 PCIE, cho bạn lưu trữ cũng như vận hành máy một cách nhanh chóng, mượt mà hơn.</p><p>Card đồ họa thế hệ mới nhất của NVIDIA</p><p>MSI GF63 Thin 9RCX-645VN mỏng hơn và mạnh hơn với thiết kế GeForce Max-Q. Công nghệ tiên tiến này được GPU NVIDIA GeForce trang bị cho các laptop mỏng nhất, nhanh nhất thế giới. Đặc biệt máy sở hữu thiết kế viền màn hình benzel siêu mỏng cho trải nghiệm hình ảnh đẹp hơn và không bị phân tâm.</p><p>Dung lượng pin lên đến 7 giờ</p><p>Thời lượng pin trên MSI GF63 Thin 9RCX-645VN lên đến 7 tiếng, sẵn sàng đáp ứng cho mọi nhu cầu giải trí của bạn. Công nghệ sạc nhanh sẽ giúp bạn sẵn sàng trò chơi ở bất kỳ lúc nào.</p><p><i>* Giá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Tuy nhiên tuỳ vào từng loại sản phẩm hoặc phương thức, địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, ..</i></p><figure class="image"><img src="http://localhost:8080/images\b366ae9f7d105f823d30504dfd3e0b23.jpg"></figure>', NULL, N'15 inch', N'2.3KG', N'3cm', N'Ðen', N'http://localhost:8080/images\b366ae9f7d105f823d30504dfd3e0b23 (1).jpg', N'512GB SSD M.2 PCIe', N'Windows 10 Home', N'8GB DDR4 2666MHz (2x SO-DIMM socket, up to 32GB SDRAM)', N'i7-9750H', N'3 Cell 51WHr', 1, 0, NULL)
INSERT [dbo].[tbLaptop] ([laptopid], [name], [title], [description], [quantity], [size], [weight], [height], [color], [image], [memory], [os], [ram], [cpu], [battery], [categoryid], [status], [price]) VALUES (11, N'ThinkPad E490s', N'Laptop Lenovo ThinkPad E490s 20NGS01K00 Core i5-8265U/ Dos (14 FHD) - Hàng Chính Hãng', N'<p>Thiết kế hiện đại, sang trọng</p><p><strong>Laptop Lenovo ThinkPad E490s 20NGS01K00</strong> với thiết kế hoàn toàn nhỏ gọn, các góc với đường bo cong cứng cáp, đầy cá tính. Chiếc laptop này không chỉ là một trợ thủ đắc lực trong công việc, mà còn giúp bạn mang theo bất cứ đâu một cách dễ dàng.</p><p>Màn hình 14 inch</p><p>Chiếc máy tính sở hữu màn hình LCD với kích thước tiêu chuẩn 14 inch và độ phân giải Full HD (1920x1080), cho bạn trải nghiệm hình ảnh sống động và sắc nét. Không những thế, tấm nền chống chói IPS tích hợp sẽ loại bỏ hình ảnh phản chiếu giúp bạn làm việc hiệu quả ngay cả môi trường nhiều sáng.</p><p>Cấu hình mạnh mẽ</p><p>Chiếc laptop được trang bị chip Intel Core i5-8265U thế hệ mới nhất có xung nhịp1.60GHz Up to 3.90 GHz, có khả năng xử lý nhanh, đáp ứng các nhu cầu tác vụ của người dùng, cũng như giải quyết vấn đề chạy các ứng dụng nền và ứng dụng song song.</p><p>Dung lượng lưu trữ lớn</p><p>Bộ nhớ RAM DDR4 2400MHz dung lượng 8GB được trang bị trên Lenovo ThinkPad E490s 20NGS01K00 giúp bạn có thể thoải mái sử dụng các chương trình làm việc hiện nay như Adobe Photoshop, Adobe After Effect, hay chơi những game cần cấu hình cao không còn là xa vời. DDR4 là sự nâng cấp từ rõ rệt từ DDR3 với khả năng tiêu thụ điện năng ít hơn trong khi khả năng làm việc mạnh mẽ và hiệu quả hơn.</p><p>Card đồ họa Intel UHD Graphics 620&nbsp;</p><p>Đồ họa Intel UHD Graphics 620 cũng là một trong những nhân tố đóng góp vào khả năng tiết kiệm điện tối ưu khi có thể phục vụ hiển thị tốt hơn tới 20% so với HD 620 của thế hệ trước mà vẫn không sử dụng điện năng lớn như các loại đồ hoạ rời. UHD 620 được tích hợp trong CPU Intel i5-8265U cho khả năng hoạt động tối ưu hơn các loại đồ hoạ tích hợp trong thế hệ CPU cũ.</p><p>Kết nối đa phương tiện</p><p>Trong thời đại công nghệ số, mọi thông tin và công việc được giao dịch và cần xử lý ngay lập tức trên Internet, việc giữ kết nối là vô cùng quan trọng. Lenovo ThinkPad E490s 20NGS01K00 được trang bị đầy đủ các cổng giao tiếp 1x USB 2.0, 2x USB 3.1, 2x USB 3.2 Type-C, HDMI, RJ45 giúp bạn truyền tải dữ liệu nhanh chóng.</p><p><i>* Giá sản phẩm trên Tiki đã bao gồm thuế theo luật hiện hành. Tuy nhiên tuỳ vào từng loại sản phẩm hoặc phương thức, địa chỉ giao hàng mà có thể phát sinh thêm chi phí khác như phí vận chuyển, phụ phí hàng cồng kềnh, ..</i></p><figure class="image"><img src="http://localhost:8080/images\5dc4cc5b2fe43328769b55fe776d031d.jpg"></figure>', 50, N'15inch', N'2kg', N'2cm', N'Ðen', N'http://localhost:8080/images\5dc4cc5b2fe43328769b55fe776d031d (1).jpg', N'256GB SSD M.2 PCle3x4', N'Free Dos', N'8GB', N'Core i5-8265U', N'3-Cells 42Whr', 1, 0, NULL)
INSERT [dbo].[tbLaptop] ([laptopid], [name], [title], [description], [quantity], [size], [weight], [height], [color], [image], [memory], [os], [ram], [cpu], [battery], [categoryid], [status], [price]) VALUES (12, N'Asus ROG Strix G G531GT-AL007T', N'Laptop Asus ROG Strix G G531GT-AL007T Core i5-9300H/ GTX 1650 4GB/ Win10 (15.6 FHD IPS 120Hz) - Hàng Chính Hãng', N'<p>Thiết kế tối ưu hóa hiệu năng</p><p><strong>Laptop Asus ROG Strix G G531GT-AL007T Core i5-9300H/ GTX 1650 4GB/ Win10 (15.6 FHD IPS 120Hz)</strong> với màu xám kim loại và ấn tượng hơn khi kết hợp với những đường phây xước đẹp mắt. Thiết kế chiến lược này là sự hợp tác của Asus với Tập đoàn BMW Designworks cho ra đời dãi màu 3D Flow Zone sống động. Dải led ánh sáng Aura Sync bao quanh thân máy, bàn phím và logo ROG cũng được đổi mới.</p><figure class="image"><img src="http://localhost:8080/images\b18b1dd2fd1de4567b9d4c148209743c.jpg"></figure><p>Màn hình siêu mỏng</p><p>Viền màn hình bezel siêu mỏng sẽ khiến màn hình trở nên lớn hơn mà máy thì nhỏ gọn hơn so với các dòng laptop thông thường. Màn hình viền mỏng của Strix G G531GT-AL007T sẽ khiến bạn đắm chìm trong cuộc chiến, không lo bị phân tâm. Trải nghiệm bao quát hơn dù là chơi game, xem phim, stream và còn nhiều hơn thế nữa.</p><figure class="image"><img src="http://localhost:8080/images\ecc6db25d52461758e1df8bbc407561a.jpg"></figure><p>Thiết kế bản lề chắc chắn, gọn gàng</p><p>Lấy cảm hứng từ cửa gullwing, bản lề sẽ nổi lên khi mở máy lên và kín đáo đóng lại vào khung. Thiết kế bản lề ẩn này sẽ mở ra thêm không gian bổ sung để thông gió và hỗ trợ các tản nhiệt ở phía sau. Bản lề che giấu này cũng giúp cho bản lề cũng như phần nâng cấp dưới máy đỡ bụi hơn.</p><figure class="image"><img src="http://localhost:8080/images\9cf599ff3d0d7a47615a8567abd03549.jpg"></figure><p>Hiệu năng vượt trội</p><p>Mọi thứ từ chơi game nặng cho đến các tác vụ đa nhiệm hàng ngày đều nhanh và mượt mà với Strix G G531GT-AL007T. Với GeForce GTX 1650 và được hỗ trợ ROG Boost lên đến 1540 MHz 115W ở chế độ Turbo sẽ cho phép bạn có gameplay mượt mà. CPU i5 9300H mạnh mẽ được kết hợp với tối đa 32GB RAM DDR4-2666 phục vụ cho giải trí và công việc chuyên sâu. Với khả năng nâng cấp ổ SSD M.2 NVMe lên đến 1TB và FireCuda SSHD 1TB. Dung lượng lưu trữ rộng rãi và tốc độ upload dữ liệu nhanh để mang toàn bộ thư viện trò chơi của bạn đi bất cứ đâu và chơi mọi lúc mọi nơi.</p><figure class="image"><img src="http://localhost:8080/images\9cf599ff3d0d7a47615a8567abd03549.jpg"></figure><p>Tản nhiệt thông minh</p><p>Tiêu chí thiết kế tản nhiệt thông minh của ROG pha trộn các tính năng và cài đặt hệ thống phù hợp, để đảm bảo trải nghiệm tốt nhất cho từng tình huống. Strix G G531GT-AL007T tăng cường sự thông thoáng với module tản nhiệt và tự làm sạch, đẩy bụi ra ngoài để cải thiện tuổi thọ. Hệ thống quạt kép n-Blade 83 cánh quạt để tăng luồng khí và lá tản nhiệt siêu mỏng mở rộng diện tích bề mặt để tản nhiệt. Phần mềm ROG Armory Crate chuyển đổi liền mạch giữa các chế độ vận hành để tối ưu hóa hiệu suất tản nhiệt.</p><p>Công nghệ ROG RangeBoost nâng tầm trải nghiệm wifi&nbsp;</p><p>Strix G G531GT-AL007T được trang bị Wi-Fi Rangeboost cho tầm thu sóng tăng lên 30%, lưu lượng Wi-Fi cao hơn, ít mất kết nối hơn. Công nghệ ROG RangeBoost đã được cấp bằng sáng chế kết hợp bốn ăng-ten nằm ở mặt trước và sau máy. Một thuật toán đặc biệt liên tục quét và chọn cặp anten tốt nhất có thể khỏa lấp các điểm chết của những anten khác. Nhờ thuật toán này mà Strix G G531GT-AL007T thu được tín hiệu mạnh nhất. Chuẩn Wi-Fi 802.11ac Wave 2 cho tốc độ lên đến 1.7Gbps – gấp 2 lần 802.11ac 2×2 và 12 lần 802.11b/g/n!</p><figure class="image"><img src="http://localhost:8080/images\e2f38677c1a5b85c3f98a3b1c0988b51.jpg"></figure>', NULL, N'15inch', N'2Kg', N'3cm', N'Ðen', N'http://localhost:8080/images\c0ce4e7bdf9fa98860c47b38ad62fe07 (1).jpg', N'512GB SSD PCIE G3X4', N'Windows 10 Home', N'8GB DDR4 2666MHz (2x SO-DIMM socket, up to 32GB SDRAM)', N'Core i5-9300H', N'3 Cell 48WHr', 1, 0, NULL)
INSERT [dbo].[tbOrder] ([orderid], [customerid], [status], [createdate], [totalprice], [note]) VALUES (1, 1, 1, CAST(N'2019-10-25T09:03:06.047' AS DateTime), 122, N'')
INSERT [dbo].[tbOrder] ([orderid], [customerid], [status], [createdate], [totalprice], [note]) VALUES (2, 1, 1, CAST(N'2019-10-25T09:47:33.797' AS DateTime), 60, N'')
INSERT [dbo].[tbOrder] ([orderid], [customerid], [status], [createdate], [totalprice], [note]) VALUES (3, 1, 1, CAST(N'2019-10-25T18:36:16.880' AS DateTime), 1.6, N'')
INSERT [dbo].[tbRole] ([roleid], [name]) VALUES (1, N'ADMIN')
INSERT [dbo].[tbRole] ([roleid], [name]) VALUES (2, N'USER')
INSERT [dbo].[tbSupplier] ([supplierid], [name], [phone], [address], [image]) VALUES (1, N'MSI Viet Nam', N'012345678', N'Ha Noi', N'https://seeklogo.com/images/M/msi-logo-715677D331-seeklogo.com.png')
INSERT [dbo].[tbSupplier] ([supplierid], [name], [phone], [address], [image]) VALUES (2, N'Dell Viet Nam', N'012345678', N'Ha Noi', N'https://seeklogo.com/images/D/Dell-logo-506C93E553-seeklogo.com.png')
INSERT [dbo].[tbSupplier] ([supplierid], [name], [phone], [address], [image]) VALUES (3, N'HP Viet Nam', N'012345678', N'Ha Noi', N'https://seeklogo.com/images/H/hp-logo-EEECF99DCE-seeklogo.com.png')
INSERT [dbo].[tbSupplier] ([supplierid], [name], [phone], [address], [image]) VALUES (4, N'Apple Viet Nam', N'012345678', N'Ha Noi', N'https://seeklogo.com/images/A/Apple-logo-4DC2B05F7D-seeklogo.com.png')
INSERT [dbo].[tbSupplier] ([supplierid], [name], [phone], [address], [image]) VALUES (5, N'Lenovo Viet Nam', N'012345678', N'Ha Noi', N'https://seeklogo.com/images/L/lenovo-logo-E125AE3250-seeklogo.com.png')
INSERT [dbo].[tbUser] ([userid], [username], [password], [roleid], [avatar], [fullname], [status], [address], [phone]) VALUES (1, N'admin', N'$2a$10$7.LeZVjP98LnaWOlX0kBq.SFQ2umUOV.xzXpk6aq.JbXCUSK.puYy', 1, N'https://i0.wp.com/www.winhelponline.com/blog/wp-content/uploads/2017/12/user.png?resize=256%2C256&quality=100&ssl=1', N'Admin', NULL, N'Hà Nội', N'123')
ALTER TABLE [dbo].[tbArticle]  WITH CHECK ADD  CONSTRAINT [FK_tbLaptop_tbArticle] FOREIGN KEY([laptopid])
REFERENCES [dbo].[tbLaptop] ([laptopid])
GO
ALTER TABLE [dbo].[tbArticle] CHECK CONSTRAINT [FK_tbLaptop_tbArticle]
GO
ALTER TABLE [dbo].[tbInvoice]  WITH CHECK ADD  CONSTRAINT [FK_tbSupplier_tbInvoice] FOREIGN KEY([supplierId])
REFERENCES [dbo].[tbSupplier] ([supplierid])
GO
ALTER TABLE [dbo].[tbInvoice] CHECK CONSTRAINT [FK_tbSupplier_tbInvoice]
GO
ALTER TABLE [dbo].[tbInvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbInvoice_tbInvoiceDetail] FOREIGN KEY([invoiceId])
REFERENCES [dbo].[tbInvoice] ([invoiceId])
GO
ALTER TABLE [dbo].[tbInvoiceDetail] CHECK CONSTRAINT [FK_tbInvoice_tbInvoiceDetail]
GO
ALTER TABLE [dbo].[tbLaptop]  WITH CHECK ADD  CONSTRAINT [FK_tbCategory_tbLaptop] FOREIGN KEY([categoryid])
REFERENCES [dbo].[tbCategory] ([categoryid])
GO
ALTER TABLE [dbo].[tbLaptop] CHECK CONSTRAINT [FK_tbCategory_tbLaptop]
GO
ALTER TABLE [dbo].[tbOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbLaptop_tbOrderDetail] FOREIGN KEY([laptopid])
REFERENCES [dbo].[tbLaptop] ([laptopid])
GO
ALTER TABLE [dbo].[tbOrderDetail] CHECK CONSTRAINT [FK_tbLaptop_tbOrderDetail]
GO
ALTER TABLE [dbo].[tbOrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbOrder_tbOrderDetail] FOREIGN KEY([orderid])
REFERENCES [dbo].[tbOrder] ([orderid])
GO
ALTER TABLE [dbo].[tbOrderDetail] CHECK CONSTRAINT [FK_tbOrder_tbOrderDetail]
GO
ALTER TABLE [dbo].[tbPromotion]  WITH CHECK ADD  CONSTRAINT [FK_tbLaptop_tbPromotion] FOREIGN KEY([laptopid])
REFERENCES [dbo].[tbLaptop] ([laptopid])
GO
ALTER TABLE [dbo].[tbPromotion] CHECK CONSTRAINT [FK_tbLaptop_tbPromotion]
GO
ALTER TABLE [dbo].[tbUser]  WITH CHECK ADD  CONSTRAINT [FK_tbRole_tbUser] FOREIGN KEY([roleid])
REFERENCES [dbo].[tbRole] ([roleid])
GO
ALTER TABLE [dbo].[tbUser] CHECK CONSTRAINT [FK_tbRole_tbUser]
GO
