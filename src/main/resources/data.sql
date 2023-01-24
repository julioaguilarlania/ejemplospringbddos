INSERT INTO CLIENTES(NOMBRE,CURP,FECHA_REGISTRO) VALUES('CLIENTE A','ABCD900101HJCXYZ00','2022-01-10');
INSERT INTO CLIENTES(NOMBRE,CURP,FECHA_REGISTRO) VALUES('CLIENTE B','BCDE900202MJCXYZ00','2022-01-11');
INSERT INTO CLIENTES(NOMBRE,CURP,FECHA_REGISTRO) VALUES('CLIENTE C','CDEF900303HJCXYZ00','2022-01-12');

INSERT INTO VEHICULOS(PLACAS,CLIENTE_ID,COLOR,MARCA,MODELO,KILOMETRAJE) VALUES('ABC1234',1,'AZUL','ACURA','GT 2021',12000);
INSERT INTO VEHICULOS(PLACAS,CLIENTE_ID,COLOR,MARCA,MODELO,KILOMETRAJE) VALUES('ACD1245',1,'AMARILLO','AUDI','DOS PUERTAS 2020',23417);
INSERT INTO VEHICULOS(PLACAS,CLIENTE_ID,COLOR,MARCA,MODELO,KILOMETRAJE) VALUES('BCE2545',2,'VERDE','BMW','M17',13219);
INSERT INTO VEHICULOS(PLACAS,CLIENTE_ID,COLOR,MARCA,MODELO,KILOMETRAJE) VALUES('CDE3148',3,'CYAN','CHEVROLET','CHEVY 2020',53219);

INSERT INTO ENTRADAS(PLACAS,FECHA_INGRESO,FECHA_SALIDA,ESTATUS) VALUES('ABC1234','2021-10-01 10:01','2021-10-02 14:11','CERRADA');
INSERT INTO ENTRADAS(PLACAS,FECHA_INGRESO,FECHA_SALIDA,ESTATUS) VALUES('ABC1234','2022-07-01 10:02','2022-07-02 11:12','CERRADA');
INSERT INTO ENTRADAS(PLACAS,FECHA_INGRESO,FECHA_SALIDA,ESTATUS) VALUES('ACD1245','2022-10-01 10:01','2022-10-02 11:11','CERRADA');
INSERT INTO ENTRADAS(PLACAS,FECHA_INGRESO,ESTATUS) VALUES('BCE2545','2023-01-22 9:03','EN_PROGRESO');
INSERT INTO ENTRADAS(PLACAS,FECHA_INGRESO,ESTATUS) VALUES('CDE3148','2023-01-23 11:04','EN_PROGRESO');

INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,FECHA_INICIO,FECHA_FIN,COSTO) VALUES(1,'REVISION FRENOS','2021-10-01 11:00','2021-10-01 12:00',550.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,FECHA_INICIO,FECHA_FIN,COSTO) VALUES(2,'CAMBIO ACEITE','2022-07-01 11:00','2022-07-01 13:00',700.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,FECHA_INICIO,FECHA_FIN,COSTO) VALUES(2,'CAMBIO LLANTAS(2)','2022-07-01 13:00','2022-07-01 14:00',5600.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,FECHA_INICIO,FECHA_FIN,COSTO) VALUES(3,'CAMBIO ACEITE','2022-10-01 11:00','2022-10-01 13:00',700.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,FECHA_INICIO,FECHA_FIN,COSTO) VALUES(3,'CAMBIO BATERíA','2022-10-01 14:00','2022-10-01 15:00',700.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,FECHA_INICIO,FECHA_FIN,COSTO) VALUES(4,'AFINACIÓN MOTOR','2023-01-22 10:00','2023-01-22 13:00',1200.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,COSTO) VALUES(4,'CAMBIO LLANTAS (1)',5200.00);
INSERT INTO SERVICIOS(ENTRADA_ID,DESCRIPCION,COSTO) VALUES(5,'CAMBIO LLANTAS (1)',5200.00);


