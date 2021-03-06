USE [master]
GO
/****** Object:  Database [Biblioteca]    Script Date: 13/06/2017 11:35:32 p. m. ******/
CREATE DATABASE [Biblioteca]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Biblioteca', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Biblioteca.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Biblioteca_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Biblioteca_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Biblioteca] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Biblioteca].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Biblioteca] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Biblioteca] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Biblioteca] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Biblioteca] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Biblioteca] SET ARITHABORT OFF 
GO
ALTER DATABASE [Biblioteca] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Biblioteca] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Biblioteca] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Biblioteca] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Biblioteca] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Biblioteca] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Biblioteca] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Biblioteca] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Biblioteca] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Biblioteca] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Biblioteca] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Biblioteca] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Biblioteca] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Biblioteca] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Biblioteca] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Biblioteca] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Biblioteca] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Biblioteca] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Biblioteca] SET  MULTI_USER 
GO
ALTER DATABASE [Biblioteca] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Biblioteca] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Biblioteca] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Biblioteca] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Biblioteca] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Biblioteca]
GO
/****** Object:  Table [dbo].[Categoria]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categoria](
	[CategoriaId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Categoria] PRIMARY KEY CLUSTERED 
(
	[CategoriaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cliente](
	[ClienteId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellido] [varchar](50) NOT NULL,
	[Telefono] [varchar](50) NOT NULL,
	[Status] [varchar](50) NULL,
	[Identificacion] [varchar](50) NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[ClienteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Libro]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Libro](
	[LibroId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[CategoriaId] [int] NULL,
	[Autor] [varchar](50) NULL,
	[Status] [varchar](50) NULL,
 CONSTRAINT [PK_Libro] PRIMARY KEY CLUSTERED 
(
	[LibroId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Prestamo]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Prestamo](
	[PrestamoId] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[ClienteId] [int] NOT NULL,
	[FechaPrestamo] [varchar](50) NOT NULL,
	[FechaDevolucion] [varchar](50) NOT NULL,
	[LibroId_RevistaId] [varchar](max) NULL,
	[Tipo] [varchar](max) NULL,
	[Cantidad] [int] NULL,
 CONSTRAINT [PK_Prestamo] PRIMARY KEY CLUSTERED 
(
	[PrestamoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Revista]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Revista](
	[RevistaId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[CategoriaId] [int] NOT NULL,
	[Status] [varchar](50) NULL,
 CONSTRAINT [PK_Revista] PRIMARY KEY CLUSTERED 
(
	[RevistaId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Rol]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Rol](
	[RolId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Rol] PRIMARY KEY CLUSTERED 
(
	[RolId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TablaTemporal]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TablaTemporal](
	[id] [int] NULL,
	[titulo] [varchar](50) NULL,
	[tipo] [varchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Usuarios](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[Apellido] [varchar](50) NOT NULL,
	[Usuario] [varchar](50) NOT NULL,
	[Contrasena] [varchar](50) NOT NULL,
	[RolId] [int] NOT NULL,
	[Status] [varchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Categoria] ON 

INSERT [dbo].[Categoria] ([CategoriaId], [Nombre]) VALUES (1, N'Historia')
INSERT [dbo].[Categoria] ([CategoriaId], [Nombre]) VALUES (2, N'Arte')
SET IDENTITY_INSERT [dbo].[Categoria] OFF
SET IDENTITY_INSERT [dbo].[Cliente] ON 

INSERT [dbo].[Cliente] ([ClienteId], [Nombre], [Apellido], [Telefono], [Status], [Identificacion]) VALUES (1, N'Firstname', N'LastName', N'0000000', N'Disponible', N'1231321')
SET IDENTITY_INSERT [dbo].[Cliente] OFF
SET IDENTITY_INSERT [dbo].[Libro] ON 

INSERT [dbo].[Libro] ([LibroId], [Nombre], [CategoriaId], [Autor], [Status]) VALUES (1, N'Bibliografia de C.Colon', 1, N'autor', N'Disponible')
INSERT [dbo].[Libro] ([LibroId], [Nombre], [CategoriaId], [Autor], [Status]) VALUES (2, N'Puntillismo', 2, N'Puntillin', N'Disponible')
INSERT [dbo].[Libro] ([LibroId], [Nombre], [CategoriaId], [Autor], [Status]) VALUES (3, N'El Arte de la Guerra', 1, N'Sun Tzu', N'Disponible')
SET IDENTITY_INSERT [dbo].[Libro] OFF
SET IDENTITY_INSERT [dbo].[Prestamo] ON 

INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (7, 1, 1, N'13/06/2017', N'18/06/2017', N'1$', N'Libro$', 1)
INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (8, 1, 1, N'13/06/2017', N'18/06/2017', N'3$', N'Libro$', 1)
INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (9, 1, 1, N'13/06/2017', N'18/06/2017', N'1$2$', N'Revista$Libro$', 2)
INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (10, 1, 1, N'13/06/2017', N'18/06/2017', N'2$3$', N'Libro$Libro$', 2)
INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (11, 1, 1, N'13/06/2017', N'18/06/2017', N'1$', N'Libro$', 1)
INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (12, 1, 1, N'13/06/2017', N'18/06/2017', N'2$3$', N'Libro$Libro$', 2)
INSERT [dbo].[Prestamo] ([PrestamoId], [UserId], [ClienteId], [FechaPrestamo], [FechaDevolucion], [LibroId_RevistaId], [Tipo], [Cantidad]) VALUES (13, 1, 1, N'13/06/2017', N'18/06/2017', N'3$1$', N'Libro$Revista$', 2)
SET IDENTITY_INSERT [dbo].[Prestamo] OFF
SET IDENTITY_INSERT [dbo].[Revista] ON 

INSERT [dbo].[Revista] ([RevistaId], [Nombre], [CategoriaId], [Status]) VALUES (1, N'ResvistaTest', 1, N'Disponible')
SET IDENTITY_INSERT [dbo].[Revista] OFF
SET IDENTITY_INSERT [dbo].[Rol] ON 

INSERT [dbo].[Rol] ([RolId], [Nombre]) VALUES (1, N'Administrador')
SET IDENTITY_INSERT [dbo].[Rol] OFF
INSERT [dbo].[TablaTemporal] ([id], [titulo], [tipo]) VALUES (3, N'El Arte de la Guerra', N'Libro')
INSERT [dbo].[TablaTemporal] ([id], [titulo], [tipo]) VALUES (1, N'ResvistaTest', N'Revista')
SET IDENTITY_INSERT [dbo].[Usuarios] ON 

INSERT [dbo].[Usuarios] ([UserId], [Nombre], [Apellido], [Usuario], [Contrasena], [RolId], [Status]) VALUES (1, N'Juan', N'Castillo', N'Admin', N'123', 1, N'Disponible')
SET IDENTITY_INSERT [dbo].[Usuarios] OFF
ALTER TABLE [dbo].[Libro]  WITH CHECK ADD  CONSTRAINT [FK_Libro_Categoria] FOREIGN KEY([CategoriaId])
REFERENCES [dbo].[Categoria] ([CategoriaId])
GO
ALTER TABLE [dbo].[Libro] CHECK CONSTRAINT [FK_Libro_Categoria]
GO
ALTER TABLE [dbo].[Prestamo]  WITH CHECK ADD  CONSTRAINT [FK_Prestamo_Cliente] FOREIGN KEY([ClienteId])
REFERENCES [dbo].[Cliente] ([ClienteId])
GO
ALTER TABLE [dbo].[Prestamo] CHECK CONSTRAINT [FK_Prestamo_Cliente]
GO
ALTER TABLE [dbo].[Prestamo]  WITH CHECK ADD  CONSTRAINT [FK_Prestamo_User] FOREIGN KEY([UserId])
REFERENCES [dbo].[Usuarios] ([UserId])
GO
ALTER TABLE [dbo].[Prestamo] CHECK CONSTRAINT [FK_Prestamo_User]
GO
ALTER TABLE [dbo].[Revista]  WITH CHECK ADD  CONSTRAINT [FK_Revista_Categoria] FOREIGN KEY([CategoriaId])
REFERENCES [dbo].[Categoria] ([CategoriaId])
GO
ALTER TABLE [dbo].[Revista] CHECK CONSTRAINT [FK_Revista_Categoria]
GO
ALTER TABLE [dbo].[Usuarios]  WITH CHECK ADD  CONSTRAINT [FK_User_Rol] FOREIGN KEY([RolId])
REFERENCES [dbo].[Rol] ([RolId])
GO
ALTER TABLE [dbo].[Usuarios] CHECK CONSTRAINT [FK_User_Rol]
GO
/****** Object:  StoredProcedure [dbo].[SP_FillTemp]    Script Date: 13/06/2017 11:35:32 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[SP_FillTemp]
@ClienteId int
AS 
DECLARE @Cantidad int
DECLARE @CadenaId varchar(max)
DECLARE @CadenaTipo varchar(max)

SELECT @Cantidad=Cantidad,@CadenaId=LibroId_RevistaId,@CadenaTipo=Tipo FROM Prestamo

DECLARE @position1 INT=0 
DECLARE @position4 INT=0
DECLARE @subId varchar(max);
DECLARE @subTipo varchar(max);
DECLARE @X INT = 1
DECLARE @z VARCHAR(max);
DECLARE @a VARCHAR(max);

DELETE FROM TablaTemporal
WHILE @X<=@Cantidad
    BEGIN--PRIMER WHILE
		   SET @z='';
		   SET @a='';
		   SET @subId='';
		   SET @subTipo='';
	   
		   WHILE @z <> '$'
		   BEGIN  		
      			set @z= SUBSTRING(@CadenaId, @position1, 1)
      		   
      			   IF(@z <> '$')
      				BEGIN
      				SET	@subId=@subId+@z;
      				END
      			
      				SET @position1=@position1+1;
			 END

		  WHILE @a <> '$'
		  BEGIN  		
			   set @a= SUBSTRING(@CadenaTipo, @position4, 1)
              
				  IF(@a <> '$')
				 BEGIN
				 SET	@subTipo=@subTipo+@a;
				 END
             
				 SET @position4=@position4+1;
		  END
		  if(@subTipo='Libro')
		  begin
		  INSERT INTO TablaTemporal(id,titulo,tipo)
		  values(@subId,(select Nombre from Libro where LibroId=@subId),@subTipo)
		  set @X=@X+1
	      end

		  else 
		  begin
		  INSERT INTO TablaTemporal(id,titulo,tipo)
		  values(@subId,(select Nombre from Revista where RevistaId=@subId),@subTipo)
		  set @X=@X+1
		  end
	END--PRIMER WHILE
   
GO
/****** Object:  StoredProcedure [dbo].[spInsert_Prestamo]    Script Date: 13/06/2017 11:35:33 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spInsert_Prestamo]
 @ClienteId INT,
 @UsuarioId INT,
 @FechaPrestamo VARCHAR(MAX),
 @FechaDevolucion VARCHAR(MAX),
 @CadenaId VARCHAR(max),
 @CadenaTipo  VARCHAR(max),
 @cantidad int
 
AS  

DECLARE @position1 INT=0 
DECLARE @position4 INT=0
DECLARE @subId varchar(max);
DECLARE @subTipo varchar(max);
DECLARE @X INT = 1
DECLARE @z VARCHAR(max);
DECLARE @a VARCHAR(max);
WHILE @X <= @cantidad  
BEGIN
	   SET @z='';
	   SET @a='';
	   SET @subId='';
	   SET @subTipo='';
	   
	   WHILE @z <> '$'
	   BEGIN  		
      		set @z= SUBSTRING(@CadenaId, @position1, 1)
      		   
      		   IF(@z <> '$')
      			BEGIN
      			SET	@subId=@subId+@z;
      			END
      			
      			SET @position1=@position1+1;
		 END

	  WHILE @a <> '$'
      BEGIN  		
           set @a= SUBSTRING(@CadenaTipo, @position4, 1)
              
              IF(@a <> '$')
             BEGIN
             SET	@subTipo=@subTipo+@a;
             END
             
             SET @position4=@position4+1;
      END

		  BEGIN 
			IF(@subTipo='Libro')
				begin
				    UPDATE Libro SET [Status]='Prestado' WHERE LibroId=@subId
					SET @X=@X+1;
				end
			ELSE
			    begin
					UPDATE Revista SET [Status]='Prestado' WHERE RevistaId=@subId
				  SET @X=@X+1;
				end
		END
END;  
 INSERT INTO Prestamo(Userid,ClienteId,FechaPrestamo,FechaDevolucion,LibroId_RevistaId,Tipo,Cantidad)
 Values(@UsuarioId,@ClienteId,@FechaPrestamo,@FechaDevolucion,@CadenaId,@CadenaTipo,@cantidad)
 
 UPDATE Cliente SET [Status]='No Disponible' where ClienteId=@ClienteId
GO
/****** Object:  StoredProcedure [dbo].[spUpdate_Devolucion]    Script Date: 13/06/2017 11:35:33 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[spUpdate_Devolucion]
 @ClienteId INT,
 @CadenaId VARCHAR(max),
 @CadenaTipo  VARCHAR(max),
 @cantidad int
 
AS  

DECLARE @position1 INT=0 
DECLARE @position4 INT=0
DECLARE @subId varchar(max);
DECLARE @subTipo varchar(max);
DECLARE @X INT = 1
DECLARE @z VARCHAR(max);
DECLARE @a VARCHAR(max);
WHILE @X <= @cantidad  
BEGIN
	   SET @z='';
	   SET @a='';
	   SET @subId='';
	   SET @subTipo='';
	   
	   WHILE @z <> '$'
	   BEGIN  		
      		set @z= SUBSTRING(@CadenaId, @position1, 1)
      		   
      		   IF(@z <> '$')
      			BEGIN
      			SET	@subId=@subId+@z;
      			END
      			
      			SET @position1=@position1+1;
		 END

	  WHILE @a <> '$'
      BEGIN  		
           set @a= SUBSTRING(@CadenaTipo, @position4, 1)
              
              IF(@a <> '$')
             BEGIN
             SET	@subTipo=@subTipo+@a;
             END
             
             SET @position4=@position4+1;
      END

		  BEGIN 
			IF(@subTipo='Libro')
				begin
				    UPDATE Libro SET [Status]='Disponible' WHERE LibroId=@subId
					SET @X=@X+1;
				end
			ELSE
			    begin
					UPDATE Revista SET [Status]='Disponible' WHERE RevistaId=@subId
				  SET @X=@X+1;
				end
		END
END;  

 
 UPDATE Cliente SET [Status]='Disponible' where ClienteId=@ClienteId
GO
USE [master]
GO
ALTER DATABASE [Biblioteca] SET  READ_WRITE 
GO
