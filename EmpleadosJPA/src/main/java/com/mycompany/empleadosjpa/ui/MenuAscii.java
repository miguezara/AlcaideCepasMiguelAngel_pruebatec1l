package com.mycompany.empleadosjpa.ui;


public class MenuAscii {
    
    
    public static void mostrarMenu() {
        System.out.println("*******************************");
        System.out.println("*    Menú de Gestión de       *");
        System.out.println("*         Empleados           *");
        System.out.println("*******************************");
        System.out.println("* 1. Agregar nuevo empleado   *");
        System.out.println("* 2. Listar empleados         *");
        System.out.println("* 3. Actualizar empleado      *");
        System.out.println("* 4. Eliminar empleado        *");
        System.out.println("* 5. Buscar empleados por cargo*");
        System.out.println("* 0. Salir                    *");
        System.out.println("*******************************");
        System.out.print("Seleccione una opción: ");
    }
}
