package com.mycompany.empleadosjpa;

import com.mycompany.empleadosjpa.logica.Controladora;
import com.mycompany.empleadosjpa.logica.Empleado;
import com.mycompany.empleadosjpa.persistencia.ControladoraPersistencia;
import com.mycompany.empleadosjpa.ui.MenuAscii;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpleadosJPA {

    private static final String[] tiposDeCargo = {"Encargado", "Oficial", "Peon", "Ayudante", "Otro"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
        Controladora controladora = new Controladora(controladoraPersistencia);

        while (true) {
            MenuAscii.mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1: // Agregar nuevo empleado
                    agregarEmpleado(scanner, controladora);
                    break;
                case 2: // Listar empleados
                    listarEmpleados(controladora);
                    break;
                case 3: // Actualizar información de un empleado
                    actualizarEmpleado(scanner, controladora);
                    break;
                case 4: // Eliminar un empleado
                    eliminarEmpleado(scanner, controladora);
                    break;
                case 5: // Buscar empleados por cargo
                    buscarPorCargo(scanner, controladora);
                    break;
                case 0: // Salir
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static void agregarEmpleado(Scanner scanner, Controladora controladora) {
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del empleado:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el cargo del empleado:");
        String cargo = scanner.nextLine();

        System.out.println("Ingrese el salario del empleado:");
        double salario = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese la fecha de contratación del empleado (yyyy-MM-dd):");
    String fechaInicioStr = scanner.nextLine();
    Date fechaInicio = null;

    try {
        fechaInicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicioStr);
    } catch (ParseException e) {
        System.out.println("Error al parsear la fecha de contratación. Formato incorrecto.");
        return;
    }

        Empleado nuevoEmpleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio, true);
        controladora.crearEmpleado(nuevoEmpleado);
        System.out.println("Empleado agregado correctamente.");
    }

    private static void listarEmpleados(Controladora controladora) {
        List<Empleado> empleados = controladora.listarEmpleados();
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    private static void eliminarEmpleado(Scanner scanner, Controladora controladora) {
        System.out.println("Ingrese el ID del empleado que desea eliminar:");
        int idEmpleado = Integer.parseInt(scanner.nextLine());

        // Verificar si el empleado existe antes de eliminarlo
        Empleado empleado = controladora.buscarEmpleadoPorId(idEmpleado);
        if (empleado != null) {
            controladora.eliminarEmpleado(idEmpleado);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún empleado con el ID especificado.");
        }
    }

    private static void actualizarEmpleado(Scanner scanner, Controladora controladora) {
        System.out.println("Ingrese el ID del empleado que desea actualizar:");
        int idEmpleado = Integer.parseInt(scanner.nextLine());

        // Verificar si el empleado existe antes de actualizarlo
        Empleado empleado = controladora.buscarEmpleadoPorId(idEmpleado);
        if (empleado != null) {
            System.out.println("Ingrese el nuevo nombre del empleado:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el nuevo apellido del empleado:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el nuevo cargo del empleado:");
            String cargo = scanner.nextLine();

            System.out.println("Ingrese el nuevo salario del empleado:");
            double salario = Double.parseDouble(scanner.nextLine());

            empleado.setNombre(nombre);
            empleado.setApellido(apellido);
            empleado.setCargo(cargo);
            empleado.setSalario(salario);

            controladora.actualizarEmpleado(empleado);
            System.out.println("Empleado actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún empleado con el ID especificado.");
        }
    }

    private static void buscarPorCargo(Scanner scanner, Controladora controladora) {
        System.out.println("Tipos de cargo disponibles:");
        for (int i = 0; i < tiposDeCargo.length; i++) {
            System.out.println((i + 1) + ". " + tiposDeCargo[i]);
        }
        
        System.out.println("Seleccione el número correspondiente al tipo de cargo que desea buscar:");
        int opcionCargo = Integer.parseInt(scanner.nextLine());

        // Verifica si es valido
        if (opcionCargo >= 1 && opcionCargo <= tiposDeCargo.length) {
            String cargo = tiposDeCargo[opcionCargo - 1];
            List<Empleado> empleados = controladora.buscarPorCargo(cargo);
            System.out.println("Empleados con el cargo '" + cargo + "':");
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } else {
            System.out.println("Opción no válida. Por favor, seleccione un tipo de cargo válido.");
        }
        
    }
}
