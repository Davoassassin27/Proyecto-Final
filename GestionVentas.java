// SOLER, DAVID ANDRES - Lic. en Ciencia de Datos - UCASAL - 2024
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase que representa una venta
class Venta {
    String producto;
    int cantidad;
    double precio;
    Date fecha;

    // Constructor para inicializar una venta
    public Venta(String producto, int cantidad, double precio, Date fecha) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    // Método para calcular el total de la venta
    public double totalVenta() {
        return cantidad * precio;
    }

    // Método para mostrar la información de la venta
    public void mostrarInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: " + precio + ", Fecha: " + sdf.format(fecha));
    }
}

// Clase que representa una venta online, extendiendo la clase Venta
class VentaOnline extends Venta {
    String plataforma;

    // Constructor para inicializar una venta online
    public VentaOnline(String producto, int cantidad, double precio, Date fecha, String plataforma) {
        super(producto, cantidad, precio, fecha);
        this.plataforma = plataforma;
    }

    // Sobrescribe el método mostrarInfo para incluir la plataforma
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Plataforma: " + plataforma);
    }
}

// Clase principal para la gestión de ventas
public class GestionVentas {
    private static ArrayList<Venta> ventas = new ArrayList<>();

    // Método principal que contiene el menú de opciones
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Agregar venta");
            System.out.println("2. Mostrar todas las ventas");
            System.out.println("3. Calcular estadísticas de ventas");
            System.out.println("4. Generar informe de ventas por mes");
            System.out.println("5. Cargar datos desde un archivo CSV");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarVenta(sc);
                    break;
                case 2:
                    mostrarVentas();
                    break;
                case 3:
                    calcularEstadisticas();
                    break;
                case 4:
                    generarInformeMensual(sc);
                    break;
                case 5:
                    cargarDatosDesdeCSV(sc);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Método para agregar una venta
    public static void agregarVenta(Scanner sc) {
        System.out.print("Producto: ");
        String producto = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();  // Consumir el salto de línea
        System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto.");
            return;
        }
        System.out.print("¿Es una venta online? (s/n): ");
        String esOnline = sc.nextLine();

        if (esOnline.equalsIgnoreCase("s")) {
            System.out.print("Plataforma: ");
            String plataforma = sc.nextLine();
            ventas.add(new VentaOnline(producto, cantidad, precio, fecha, plataforma));
        } else {
            ventas.add(new Venta(producto, cantidad, precio, fecha));
        }
        System.out.println("Venta agregada exitosamente.");
    }

    // Método para mostrar todas las ventas
    public static void mostrarVentas() {
        for (Venta venta : ventas) {
            venta.mostrarInfo();
        }
    }

    // Método para calcular estadísticas de ventas
    public static void calcularEstadisticas() {
        double totalVentas = 0;
        double maxVenta = Double.MIN_VALUE;
        double minVenta = Double.MAX_VALUE;

        for (Venta venta : ventas) {
            double total = venta.totalVenta();
            totalVentas += total;
            if (total > maxVenta) {
                maxVenta = total;
            }
            if (total < minVenta) {
                minVenta = total;
            }
        }

        double promedioVentas = totalVentas / ventas.size();

        System.out.println("Total de ventas: " + totalVentas);
        System.out.println("Promedio de ventas: " + promedioVentas);
        System.out.println("Venta máxima: " + maxVenta);
        System.out.println("Venta mínima: " + minVenta);
    }

    // Método para generar un informe de ventas por mes
    public static void generarInformeMensual(Scanner sc) {
        System.out.print("Ingrese el mes y año (MM/yyyy): ");
        String mesAnio = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");

        for (Venta venta : ventas) {
            if (sdf.format(venta.fecha).equals(mesAnio)) {
                venta.mostrarInfo();
            }
        }
    }

    // Método para cargar datos desde un archivo CSV
    public static void cargarDatosDesdeCSV(Scanner sc) {
        System.out.print("Ingrese la ruta del archivo CSV: ");
        String rutaCSV = sc.nextLine();

        String linea;
        String separador = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                String[] datos = linea.split(separador);
                String producto = datos[0];
                int cantidad = Integer.parseInt(datos[1]);
                double precio = Double.parseDouble(datos[2]);
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(datos[3]);
                if (datos.length > 4 && !datos[4].isEmpty()) {
                    String plataforma = datos[4];
                    ventas.add(new VentaOnline(producto, cantidad, precio, fecha, plataforma));
                } else {
                    ventas.add(new Venta(producto, cantidad, precio, fecha));
                }
            }
            System.out.println("Datos cargados exitosamente desde el archivo CSV.");
        } catch (IOException | ParseException | NumberFormatException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}
