package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Cuota {
	private long idCuota;
	private int nroCuota;
	private LocalDate fechaVencimiento;
	private double saldoPendiente;
	private double amortizacion;
	private double interesesCuota;
	private double cuota;
	private double deuda;
	private boolean cancelada;
	private LocalDate fechaDePago;
	private double punitorios;
	private Prestamo prestamo;

	public Cuota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuota(LocalDate fechaVencimiento, double saldoPendiente, double amortizacion, double interesesCuota,
			double cuota, double deuda, boolean cancelada, LocalDate fechaDePago, double punitorios) {
		super();
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesesCuota = interesesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
	}

	public Cuota(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
			double interesesCuota, double cuota, double deuda, boolean cancelada, LocalDate fechaDePago,
			double punitorios, Prestamo prestamo) {
		super();
		this.nroCuota = nroCuota;
		this.fechaVencimiento = fechaVencimiento;
		this.saldoPendiente = saldoPendiente;
		this.amortizacion = amortizacion;
		this.interesesCuota = interesesCuota;
		this.cuota = cuota;
		this.deuda = deuda;
		this.cancelada = cancelada;
		this.fechaDePago = fechaDePago;
		this.punitorios = punitorios;
		this.prestamo = prestamo;
	}

	public long getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public double getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(double amortizacion) {
		this.amortizacion = amortizacion;
	}

	public double getInteresesCuota() {
		return interesesCuota;
	}

	public void setInteresesCuota(double interesesCuota) {
		this.interesesCuota = interesesCuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public double getPunitorios() {
		return punitorios;
	}

	public void setPunitorios(double punitorios) {
		this.punitorios = punitorios;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public int getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amortizacion, cancelada, cuota, deuda, fechaDePago, fechaVencimiento, idCuota,
				interesesCuota, nroCuota, prestamo, punitorios, saldoPendiente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuota other = (Cuota) obj;
		return Double.doubleToLongBits(amortizacion) == Double.doubleToLongBits(other.amortizacion)
				&& cancelada == other.cancelada
				&& Double.doubleToLongBits(cuota) == Double.doubleToLongBits(other.cuota)
				&& Double.doubleToLongBits(deuda) == Double.doubleToLongBits(other.deuda)
				&& Objects.equals(fechaDePago, other.fechaDePago)
				&& Objects.equals(fechaVencimiento, other.fechaVencimiento) && idCuota == other.idCuota
				&& Double.doubleToLongBits(interesesCuota) == Double.doubleToLongBits(other.interesesCuota)
				&& nroCuota == other.nroCuota && Objects.equals(prestamo, other.prestamo)
				&& Double.doubleToLongBits(punitorios) == Double.doubleToLongBits(other.punitorios)
				&& Double.doubleToLongBits(saldoPendiente) == Double.doubleToLongBits(other.saldoPendiente);
	}

	@Override
	public String toString() {
		return "Cuota [idCuota=" + idCuota + ", nroCuota=" + nroCuota + ", fechaVencimiento=" + fechaVencimiento
				+ ", saldoPendiente=" + saldoPendiente + ", amortizacion=" + amortizacion + ", interesesCuota="
				+ interesesCuota + ", cuota=" + cuota + ", deuda=" + deuda + ", cancelada=" + cancelada
				+ ", fechaDePago=" + fechaDePago + ", punitorios=" + punitorios + " ] \n";
	}

}
