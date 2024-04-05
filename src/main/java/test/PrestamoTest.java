package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import datos.Cuota;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class PrestamoTest {
	public static void main(String[] args) {
		PrestamoABM prestamoABM = PrestamoABM.getInstance();
		ClienteABM clienteABM = ClienteABM.getInstance();
		

		Prestamo prestamo = new Prestamo(LocalDate.now(), 1000, 20, 12, clienteABM.traer(2L), false, null);
		prestamoABM.agregar(prestamo);
		
		/*
		 * 		Prestamo p = prestamoABM.traerPrestamoCuotas(20L);
		System.out.println(p);
		for(Cuota cuota : p.getCuotas()) {
			System.out.println(cuota);
		}
		 */
		
		
		/*
		 Prestamo prestamo = new Prestamo(LocalDate.now(), 80.20, 5, 5, clienteABM.traer(2L), false);
		 long id = prestamoABM.agregar(prestamo);
		 System.out.println(id);
		 */

		//Prestamo p = PrestamoABM.getInstance().traer(2L);
		//p.setMonto(100000.55);
		//PrestamoABM.getInstance().modificar(p);

		// Prestamo prestamo = prestamoABM.traer(2L);
		// PrestamoABM.getInstance().eliminar(prestamo);

		// List<Prestamo> prestamos = PrestamoABM.getInstance().traer();
		// System.out.println(prestamos);
		
		
		
		/*		Prestamo p = prestamoABM.traerPrestamoCuotas(2L);
		System.out.println(p);
		for(Cuota i : p.getCuotas()) {
			System.out.print(i);
		}
		*/
		

		/*
		 * Prestamo prestamo = PrestamoABM.getInstance().traerPrestamoCuotas(2L);
		 * System.out.println("Prestamo: " + prestamo); for(Cuota cuota :
		 * prestamo.getCuotas()) { System.out.println("Cuota: " + cuota); }
		 */
	}
}
