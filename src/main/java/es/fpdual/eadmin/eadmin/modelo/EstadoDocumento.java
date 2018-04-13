package es.fpdual.eadmin.eadmin.modelo;


import java.util.*;
public enum EstadoDocumento {
	
	ACTIVO(1),APROBADO(2),ELIMINADO(3); //Son objetos y el numero es como si llamara al contructor.
	
	private final int codigo;
	
	private EstadoDocumento(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static EstadoDocumento obtenerPorCodigo(Integer codigo) {
		return Arrays.asList(EstadoDocumento.values()).stream()
				.filter(codigoLista -> codigoLista.getCodigo() == codigo.intValue()).findAny().orElse(null);
	}
}
