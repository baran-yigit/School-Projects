USE [master]
GO
/****** Object:  Database [356Project]    Script Date: 23.06.2021 21:27:34 ******/
CREATE DATABASE [356Project]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'356Project_Data', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\356Project.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'356Project_Log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\356Project.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [356Project] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [356Project].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [356Project] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [356Project] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [356Project] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [356Project] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [356Project] SET ARITHABORT OFF 
GO
ALTER DATABASE [356Project] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [356Project] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [356Project] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [356Project] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [356Project] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [356Project] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [356Project] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [356Project] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [356Project] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [356Project] SET  DISABLE_BROKER 
GO
ALTER DATABASE [356Project] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [356Project] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [356Project] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [356Project] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [356Project] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [356Project] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [356Project] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [356Project] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [356Project] SET  MULTI_USER 
GO
ALTER DATABASE [356Project] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [356Project] SET DB_CHAINING OFF 
GO
ALTER DATABASE [356Project] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [356Project] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [356Project] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [356Project] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [356Project] SET QUERY_STORE = OFF
GO
USE [356Project]
GO
/****** Object:  Table [dbo].[OrderItem]    Script Date: 23.06.2021 21:27:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderItem](
	[OrderID] [int] NOT NULL,
	[SequenceID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[UnitPrice] [decimal](8, 2) NOT NULL,
	[ItemStatus] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SequenceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductTypeID] [int] NOT NULL,
	[ShopID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shop]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shop](
	[ShopID] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ShopID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[x]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[x] AS 
(SELECT s.ShopID, p.ProductID , SUM(oi.Quantity) AS ItemsSold FROM Product p 
INNER JOIN Shop s ON s.ShopID  = p.ShopID 
INNER JOIN OrderItem oi ON oi.ProductID  = p.ProductID 
GROUP BY s.ShopID, p.ProductID)
GO
/****** Object:  Table [dbo].[CreditCard]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CreditCard](
	[CreditCardNumber] [varchar](20) NOT NULL,
	[CustomerID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CreditCardNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [varchar](50) NOT NULL,
	[FullAddress] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[UserName] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[InvoiceNumber] [int] IDENTITY(1,1) NOT NULL,
	[InvoiceStatus] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[InvoiceNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[OrderDate] [date] NOT NULL,
	[OrderStatus] [varchar](20) NOT NULL,
	[CustomerID] [int] NOT NULL,
	[InvoiceNumber] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Payment]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[PaymetID] [int] IDENTITY(1,1) NOT NULL,
	[InvoiceNumber] [int] NOT NULL,
	[CreditCardNumber] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PaymetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductType]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductType](
	[ProductTypeID] [int] IDENTITY(1,1) NOT NULL,
	[ProductTypeDesc] [varchar](500) NULL,
	[ParentID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RestrictedShop]    Script Date: 23.06.2021 21:27:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RestrictedShop](
	[ShopID] [int] NOT NULL,
	[ProductTypeID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ShopID] ASC,
	[ProductTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CreditCard] ([CreditCardNumber], [CustomerID]) VALUES (N'5723534664123452', 4)
INSERT [dbo].[CreditCard] ([CreditCardNumber], [CustomerID]) VALUES (N'5775311057578442', 1)
INSERT [dbo].[CreditCard] ([CreditCardNumber], [CustomerID]) VALUES (N'5775311334578442', 1)
INSERT [dbo].[CreditCard] ([CreditCardNumber], [CustomerID]) VALUES (N'5775324333458435', 2)
INSERT [dbo].[CreditCard] ([CreditCardNumber], [CustomerID]) VALUES (N'5775344234618782', 3)
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([CustomerID], [FullName], [FullAddress], [Email], [UserName]) VALUES (1, N'Murat', N'Blk 123 Sunshine Avenue', N'murat@gmail.com', N'MRAT')
INSERT [dbo].[Customer] ([CustomerID], [FullName], [FullAddress], [Email], [UserName]) VALUES (2, N'Roya', N'Blk 225 North East CDC', N'roya@gmail.com', N'Roya436')
INSERT [dbo].[Customer] ([CustomerID], [FullName], [FullAddress], [Email], [UserName]) VALUES (3, N'Irmak', N'Blk 112 Singapore', N'irmak28@gmail.com', N'Irmak212')
INSERT [dbo].[Customer] ([CustomerID], [FullName], [FullAddress], [Email], [UserName]) VALUES (4, N'Baran', N'Blk 556 Serangoon Drive', N'baran09@hotmail.com', N'baran85')
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
SET IDENTITY_INSERT [dbo].[Invoice] ON 

INSERT [dbo].[Invoice] ([InvoiceNumber], [InvoiceStatus]) VALUES (1, N'paid')
INSERT [dbo].[Invoice] ([InvoiceNumber], [InvoiceStatus]) VALUES (2, N'paid')
INSERT [dbo].[Invoice] ([InvoiceNumber], [InvoiceStatus]) VALUES (3, N'issued')
SET IDENTITY_INSERT [dbo].[Invoice] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderItem] ON 

INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (1, 1, 1, 1, CAST(13.20 AS Decimal(8, 2)), N'shipped')
INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (1, 2, 3, 2, CAST(30.60 AS Decimal(8, 2)), N'shipped')
INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (2, 3, 6, 4, CAST(13.40 AS Decimal(8, 2)), N'shipped')
INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (2, 4, 7, 3, CAST(30.60 AS Decimal(8, 2)), N'shipped')
INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (2, 5, 1, 1, CAST(5.30 AS Decimal(8, 2)), N'processing')
INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (2, 6, 2, 5, CAST(16.40 AS Decimal(8, 2)), N'shipped')
INSERT [dbo].[OrderItem] ([OrderID], [SequenceID], [ProductID], [Quantity], [UnitPrice], [ItemStatus]) VALUES (3, 7, 8, 1, CAST(50.10 AS Decimal(8, 2)), N'out of stock')
SET IDENTITY_INSERT [dbo].[OrderItem] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [OrderDate], [OrderStatus], [CustomerID], [InvoiceNumber]) VALUES (1, CAST(N'2021-02-15' AS Date), N'shipped', 2, 1)
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [OrderStatus], [CustomerID], [InvoiceNumber]) VALUES (2, CAST(N'2021-03-31' AS Date), N'processing', 4, 2)
INSERT [dbo].[Orders] ([OrderID], [OrderDate], [OrderStatus], [CustomerID], [InvoiceNumber]) VALUES (3, CAST(N'2021-04-05' AS Date), N'invoice issued', 1, 2)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Payment] ON 

INSERT [dbo].[Payment] ([PaymetID], [InvoiceNumber], [CreditCardNumber]) VALUES (1, 1, N'5775324333458435')
INSERT [dbo].[Payment] ([PaymetID], [InvoiceNumber], [CreditCardNumber]) VALUES (2, 2, N'5723534664123452')
INSERT [dbo].[Payment] ([PaymetID], [InvoiceNumber], [CreditCardNumber]) VALUES (3, 2, N'5723534664123452')
INSERT [dbo].[Payment] ([PaymetID], [InvoiceNumber], [CreditCardNumber]) VALUES (4, 2, N'5723534664123452')
SET IDENTITY_INSERT [dbo].[Payment] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (1, 2, 3)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (2, 1, 2)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (3, 3, 1)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (4, 3, 1)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (5, 3, 1)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (6, 4, 1)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (7, 4, 1)
INSERT [dbo].[Product] ([ProductID], [ProductTypeID], [ShopID]) VALUES (8, 5, 4)
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
SET IDENTITY_INSERT [dbo].[ProductType] ON 

INSERT [dbo].[ProductType] ([ProductTypeID], [ProductTypeDesc], [ParentID]) VALUES (1, N'Affliated store of Cetaphil', NULL)
INSERT [dbo].[ProductType] ([ProductTypeID], [ProductTypeDesc], [ParentID]) VALUES (2, N'Official online store for Nescafe', NULL)
INSERT [dbo].[ProductType] ([ProductTypeID], [ProductTypeDesc], [ParentID]) VALUES (3, N'Mazer Official Store', NULL)
INSERT [dbo].[ProductType] ([ProductTypeID], [ProductTypeDesc], [ParentID]) VALUES (4, N'Mazer Affliated Partner', 3)
INSERT [dbo].[ProductType] ([ProductTypeID], [ProductTypeDesc], [ParentID]) VALUES (5, N'Creative Technology', NULL)
INSERT [dbo].[ProductType] ([ProductTypeID], [ProductTypeDesc], [ParentID]) VALUES (6, N'Mazer Affliated Partner Sub Affliation', 4)
SET IDENTITY_INSERT [dbo].[ProductType] OFF
GO
INSERT [dbo].[RestrictedShop] ([ShopID], [ProductTypeID]) VALUES (1, 4)
INSERT [dbo].[RestrictedShop] ([ShopID], [ProductTypeID]) VALUES (2, 1)
INSERT [dbo].[RestrictedShop] ([ShopID], [ProductTypeID]) VALUES (3, 2)
GO
SET IDENTITY_INSERT [dbo].[Shop] ON 

INSERT [dbo].[Shop] ([ShopID]) VALUES (1)
INSERT [dbo].[Shop] ([ShopID]) VALUES (2)
INSERT [dbo].[Shop] ([ShopID]) VALUES (3)
INSERT [dbo].[Shop] ([ShopID]) VALUES (4)
SET IDENTITY_INSERT [dbo].[Shop] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Customer__A9D1053406B3E8CB]    Script Date: 23.06.2021 21:27:35 ******/
ALTER TABLE [dbo].[Customer] ADD UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Customer__C9F284567A025AF3]    Script Date: 23.06.2021 21:27:35 ******/
ALTER TABLE [dbo].[Customer] ADD UNIQUE NONCLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Orders] ADD  DEFAULT (getdate()) FOR [OrderDate]
GO
ALTER TABLE [dbo].[ProductType] ADD  DEFAULT (NULL) FOR [ParentID]
GO
ALTER TABLE [dbo].[CreditCard]  WITH CHECK ADD FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([InvoiceNumber])
REFERENCES [dbo].[Invoice] ([InvoiceNumber])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD FOREIGN KEY([CreditCardNumber])
REFERENCES [dbo].[CreditCard] ([CreditCardNumber])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD FOREIGN KEY([InvoiceNumber])
REFERENCES [dbo].[Invoice] ([InvoiceNumber])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([ProductTypeID])
REFERENCES [dbo].[ProductType] ([ProductTypeID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([ShopID])
REFERENCES [dbo].[Shop] ([ShopID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RestrictedShop]  WITH CHECK ADD FOREIGN KEY([ProductTypeID])
REFERENCES [dbo].[ProductType] ([ProductTypeID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RestrictedShop]  WITH CHECK ADD FOREIGN KEY([ShopID])
REFERENCES [dbo].[Shop] ([ShopID])
GO
USE [master]
GO
ALTER DATABASE [356Project] SET  READ_WRITE 
GO
