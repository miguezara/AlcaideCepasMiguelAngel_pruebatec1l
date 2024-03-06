
import com.mycompany.empleadosjpa.logica.Empleado;
import com.mycompany.empleadosjpa.persistencia.EmpleadoJpaController;
import java.util.List;

public class ControladoraPersistencia {
    private final EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();

    public void crearEmpleado(Empleado nuevoEmpleado) {
        try {
            empleadoJpa.create(nuevoEmpleado);
        } catch (Exception ex) {
            System.out.println("Error al crear el empleado: " + ex.getMessage());
        }
    }

    public List<Empleado> listarEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    public void actualizarEmpleado(Empleado empleado) {
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            System.out.println("Error al actualizar el empleado: " + ex.getMessage());
        }
    }

    public void eliminarEmpleado(long idEmpleadoAEliminar) {
        try {
            empleadoJpa.destroy((int) idEmpleadoAEliminar);
        } catch (Exception ex) {
            System.out.println("Error al eliminar el empleado: " + ex.getMessage());
        }
    }

    public List<Empleado> buscarPorCargo(String cargo) {
        return empleadoJpa.findEmpleadosByCargo(cargo);
    }

    Empleado buscarEmpleadoPorId(int idEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
