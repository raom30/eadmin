package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
@Repository
public class RepositorioExpedienteImpl implements RepositorioExpediente {

	private final List<Expediente> expedientes = new ArrayList<>();
	private static final RepositorioExpedienteImpl rei = new RepositorioExpedienteImpl();

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

	@Override
	public void almacenarExpediene(Expediente expediente) {
		if (expedientes.contains(expediente)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El expediente ya existe");
		}
		rei.expedienteTXTAlta(expediente);
		expedientes.add(expediente);
		System.out.println("Insertado");
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El expediente no existe");
		} 
		rei.expedienteTXTModificar(expediente);
		expedientes.set(expedientes.indexOf(expediente), expediente);// Busca la posicion y lo cambia

	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();
		rei.expedienteTXTEliminar(expedienteEncontrado.get());
		if (expedienteEncontrado.isPresent()) {// esto es lo mismo que documentoEncontrado == null
			expedientes.remove(expedienteEncontrado.get());
		}
	}

	@Override
	public Expediente asociarDocumentoAlExpediente(Integer codigoExpediente, Documento documento) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream()
				.filter(e -> e.getCodigo().equals(codigoExpediente)).findFirst();

		if (expedienteEncontrado.isPresent()) {
			expedienteEncontrado.get().getListaDocumento().add(documento);
			return expedienteEncontrado.get();
		}

		return null;
	}

	@Override
	public Expediente desacionarDocumentoAlExpediente(Integer codigoExpediente, Integer codigoDocumento) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream()
				.filter(e -> e.getCodigo().equals(codigoExpediente)).findFirst();

		if (expedienteEncontrado.isPresent()) {
			localizaYEliminaElDocumentoYDevuelveElDocumento(codigoDocumento, expedienteEncontrado);
			return expedienteEncontrado.get();
		}

		return null;
	}

	private Documento localizaYEliminaElDocumentoYDevuelveElDocumento(Integer codigoDocumento, Optional<Expediente> expedienteEncontrado) {
		Optional<Documento> documentoEncontrado = expedienteEncontrado.get().getListaDocumento().stream()
				.filter(d -> d.getCodigo().equals(codigoDocumento)).findFirst();
		if (documentoEncontrado.isPresent()) {
			expedienteEncontrado.get().getListaDocumento().remove(documentoEncontrado.get());
			return documentoEncontrado.get();
		}
		return null;
	}
	
	public String escribirExpedienteFichero() {
		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "expedientes.txt";

		try {
			fw = new FileWriter(nFichero,true);
			pw = new PrintWriter(fw);
			for (Expediente e : expedientes) {
				pw.println(e.mostrar());
			}

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";

	}
	public String expedienteTXTAlta(Expediente expediente) {

		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "AltaExpediente.txt";

		try {
			fw = new FileWriter(nFichero,true);
			pw = new PrintWriter(fw);

			pw.println(expediente);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}
	public String expedienteTXTModificar(Expediente expediente) {

		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "MoficiarExpediente.txt";

		try {
			fw = new FileWriter(nFichero,true);
			pw = new PrintWriter(fw);

			pw.println(expediente);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}
	
	public String expedienteTXTEliminar(Expediente expediente) {

		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "EliminarExpediente.txt";

		try {
			fw = new FileWriter(nFichero,true);
			pw = new PrintWriter(fw);

			pw.println(expediente);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}

}
