package negocio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.PrestamoDAO;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoABM {
	private static PrestamoABM instance;
	
	private PrestamoABM() { }
	
	public static PrestamoABM getInstance() {
		if(instance == null) {
			instance = new PrestamoABM();
		}
		return instance;
	}
	
	public void agregar(Prestamo objeto) {
		calcularCuotas(objeto);
		long idPrestamo = PrestamoDAO.getInstance().agregar(objeto);
		for(Cuota cuota : objeto.getCuotas()) {
			cuota.setPrestamo(objeto);
			CuotaABM.getInstance().modificar(cuota);
		}
	}
	
	public void modificar(Prestamo objeto) {
		PrestamoDAO.getInstance().modificar(objeto);
	}
	
	public void eliminar(Prestamo objeto) {
		PrestamoDAO.getInstance().eliminar(objeto);
	}
	
	public Prestamo traer(long id) {
		return PrestamoDAO.getInstance().traer(id);
	}

	public Prestamo traerPrestamoCuotas(long id) {
		return PrestamoDAO.getInstance().traerPrestamoCuotas(id);
	}
	
	public List<Prestamo> traer() {
		return PrestamoDAO.getInstance().traer();
	}
	
	private void calcularCuotas(Prestamo prestamo) {
		// Calcular 
		Set<Cuota> cuotas = new HashSet<Cuota>();
		Cuota c = new Cuota(1, null, 1, 1, 1, 1, 1, false, null, 1, null);

		double saldoPendiente = prestamo.getMonto();
		
		double interesSimplificado = prestamo.getIntereses() / 100;
		
		double interesCuota = saldoPendiente * interesSimplificado;
		
		double denominador = Math.pow(1+interesSimplificado, prestamo.getCantCuotas()) - 1;
		double amortizacion = interesCuota / denominador;
		
		double cuota = amortizacion + interesCuota;
		
		double deuda = saldoPendiente - amortizacion;
		
		//saldoPendiente -= amortizacion;

		double punitorios = (cuota * 2) / 100;
		
		c.setNroCuota(1);
		c.setFechaVencimiento(prestamo.getFecha().plusMonths(1));
		
		c.setSaldoPendiente(saldoPendiente);
		c.setAmortizacion(amortizacion);
		c.setInteresesCuota(interesCuota);
		c.setCuota(cuota);
		c.setDeuda(deuda);
		c.setPunitorios(punitorios);
		
		
		cuotas.add(c);
		
		for(int i=2; i < prestamo.getCantCuotas();i++) {
			
		}
		
		prestamo.setCuotas(cuotas);
	}
	
}
