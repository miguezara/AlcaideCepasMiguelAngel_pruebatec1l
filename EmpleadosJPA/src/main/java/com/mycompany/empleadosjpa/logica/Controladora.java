package com.mycompany.empleadosjpa.logica;


import com.mycompany.empleadosjpa.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    private final ControladoraPersistencia controlPersis;

    public Controladora(ControladoraPersistencia controlPersis) {
        this.controlPersis = controlPersis;
    }

    public void crearEmpleado(Empleado nuevoEmpleado) {
        controlPersis.crearEmpleado(nuevoEmpleado);
    }

    public List<Empleado> listarEmpleados() {
        return controlPersis.listarEmpleados();
    }

    public void actualizarEmpleado(Empleado empleado) {
        controlPersis.actualizarEmpleado(empleado);
    }

    public void eliminarEmpleado(long idEmpleadoAEliminar) {
        controlPersis.eliminarEmpleado(idEmpleadoAEliminar);
    }

    public List<Empleado> buscarPorCargo(String cargo) {
        return controlPersis.buscarPorCargo(cargo);
    }

    // Implementación del método para crear múltiples empleados
    public void crearEmpleados(List<Empleado> nuevosEmpleados) {
        for (Empleado empleado : nuevosEmpleados) {
            controlPersis.crearEmpleado(empleado);
        }
    }

    // Implementación del método para buscar un empleado por su ID
    public Empleado buscarEmpleadoPorId(int idEmpleado) {
        return controlPersis.buscarEmpleadoPorId(idEmpleado);
    }

    // Implementación del método para actualizar varios empleados
    public void actualizarEmpleados(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            controlPersis.actualizarEmpleado(empleado);
        }
    }
        
        
    }

