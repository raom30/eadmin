package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;
import java.util.List;

public class Expediente extends ModeloBaseAdministracionElectronica{

	private final Date fechaArchivado;
	private final Boolean publico;
	private final EstadoExpediente estado;
	private final List<Documento> ListaDocumento;

	public Expediente(Integer codigo, String nombre, Date fechaCreacion,Date fechaUltimaActualizacion, Date fechaArchivado, Boolean publico,
			EstadoExpediente estado, List<Documento> listaDocumento) {
		super(codigo,nombre,fechaCreacion,fechaUltimaActualizacion);
		this.fechaArchivado = fechaArchivado;
		this.publico = publico;
		this.estado = estado;
		ListaDocumento = listaDocumento;
	}
 

	public Boolean getPublico() {
		return publico;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getListaDocumento() {
		return ListaDocumento;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	@Override
	public int hashCode() {

		return codigo.hashCode() + nombre.hashCode() + fechaCreacion.hashCode() + publico.hashCode() + estado.hashCode()
				+ ListaDocumento.hashCode() + fechaArchivado.hashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			return codigo.equals(((Expediente) obj).getCodigo()) && nombre.equals(((Expediente) obj).getNombre())
					&& fechaCreacion.equals(((Expediente) obj).getFechaCreacion())
					&& publico.equals(((Expediente) obj).getPublico()) 
					&& estado.equals(((Expediente) obj).getEstado())
					&& ListaDocumento.equals(((Expediente) obj).getListaDocumento())
					&& fechaArchivado.equals(((Expediente) obj).getFechaArchivado());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Expediente con código " + codigo;
	}
}
