
# Trabajo Final de Programación 1

## Descripción

Este proyecto es el trabajo final integrador de la materia Programación 1. El ejercicio desarrollado consiste en un sistema de gestión de ventas que permite realizar varias operaciones como agregar ventas, mostrar todas las ventas, calcular estadísticas de ventas, generar informes mensuales y cargar datos desde un archivo CSV.

## Funcionalidades

1. **Agregar venta**: Permite al usuario ingresar los detalles de una venta y agregarla a la lista de ventas.
2. **Mostrar todas las ventas**: Muestra la información de todas las ventas registradas.
3. **Calcular estadísticas de ventas**: Calcula y muestra el total de ventas, promedio de ventas, venta máxima y venta mínima.
4. **Generar informe de ventas por mes**: Genera un informe de ventas para un mes y año específicos.
5. **Cargar datos desde un archivo CSV**: Permite cargar datos de ventas desde un archivo CSV ubicado en la carpeta `dataset`.

## Características Implementadas

- **Operaciones y cálculos secuenciales**: Cálculo de total de ventas, promedio, venta máxima y mínima.
- **Ingreso de datos por parte del usuario**: Utilización de `Scanner` para ingresar datos.
- **Estructuras de selección/condicional**: Uso de `if` y `switch` para manejar las opciones del menú y condiciones.
- **Bucles**: Uso de `while` para mantener el menú en ejecución y `for` para recorrer las ventas.
- **Creación de clase**: Definición de las clases `Venta` y `VentaOnline`.
- **Creación de objetos a partir de una clase**: Instanciación de objetos `Venta` y `VentaOnline`.
- **Creación y recorrido de Arreglo**: Uso de `ArrayList` para almacenar y recorrer las ventas.
- **Herencia**: Implementación de la clase `VentaOnline` que hereda de `Venta`.

## Ejecución del Programa

Para ejecutar el programa, compílalo y corre la clase `GestionVentas`. A continuación, se muestra un ejemplo de ejecución:

```
1. Agregar venta
2. Mostrar todas las ventas
3. Calcular estadísticas de ventas
4. Generar informe de ventas por mes
5. Cargar datos desde un archivo CSV
6. Salir
Seleccione una opción: 1
Producto: Laptop
Cantidad: 2
Precio: 1500
Fecha (dd/MM/yyyy): 25/05/2023
¿Es una venta online? (s/n): s
Plataforma: Amazon
Venta agregada exitosamente.
```

## Dataset

En la carpeta `dataset` se encuentra un archivo `ventas.csv` de prueba que puede ser utilizado para ejecutar la función de carga de datos desde un CSV.

## Instrucciones de Uso

1. **Agregar Venta**:
    - Ingrese el nombre del producto, cantidad, precio, fecha y si es una venta online, la plataforma.
2. **Mostrar Ventas**:
    - Seleccione la opción 2 para mostrar todas las ventas registradas.
3. **Calcular Estadísticas**:
    - Seleccione la opción 3 para calcular y mostrar las estadísticas de ventas.
4. **Generar Informe Mensual**:
    - Seleccione la opción 4 e ingrese el mes y año en formato `MM/yyyy` para generar el informe.
5. **Cargar Datos desde CSV**:
    - Seleccione la opción 5 e ingrese la ruta del archivo CSV para cargar los datos de ventas.

## Ejemplos de Ejecución

### Ejemplo 1
```
Producto: Televisor
Cantidad: 1
Precio: 800
Fecha (dd/MM/yyyy): 15/06/2023
¿Es una venta online? (s/n): n
Venta agregada exitosamente.
```

### Ejemplo 2
```
Producto: Smartphone
Cantidad: 3
Precio: 500
Fecha (dd/MM/yyyy): 10/07/2023
¿Es una venta online? (s/n): s
Plataforma: eBay
Venta agregada exitosamente.
```

---

