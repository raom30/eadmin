package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.EadminApplication;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private final List<Documento> documentos = new ArrayList<>();
	private static final Logger logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	private static final RepositorioDocumentoImpl rdi = new RepositorioDocumentoImpl();

	public List<Documento> getDocumentos() {
		return documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {

		logger.info("Entrado en el metodo : " + rdi.getNombreMetodo());

		if (documentos.contains(documento)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento ya existe");
		}

		rdi.documentoTXTAlta(documento);
		
		documentos.add(documento);
		exportarExcel("Documentos",documento,"Alta.xlsx");
		logger.info("{} creado correctamente", documento.toString());

		logger.info("Saliendo del metodo : " + rdi.getNombreMetodo());

	}

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento no existe");
		}
		rdi.documentoTXTModificar(documento);
		documentos.set(documentos.indexOf(documento), documento);// Busca la posicion y lo cambia

	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();
		rdi.documentoTXTEliminar(documentoEncontrado.get());
		if (documentoEncontrado.isPresent()) {// esto es lo mismo que documentoEncontrado == null

			documentos.remove(documentoEncontrado.get());
			logger.info("El Documento {} eliminado correctamente", documentoEncontrado);
		}

	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		return null;

	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		logger.info("Entrado en el metodo : " + rdi.getNombreMetodo());
		for (Documento d : documentos) {
			logger.info(d.mostrar());
		}
		logger.info("Saliendo del metodo : " + rdi.getNombreMetodo());
		return documentos;
	}

	public String getNombreMetodo() {
		// Retorna el nombre del metodo desde el cual se hace el llamado
		return new Exception().getStackTrace()[1].getMethodName();
	}

	public String escribirDocumentoFichero() {
		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "documentos.txt";

		try {
			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);
			for (Documento d : documentos) {
				pw.println(d.mostrar());
			}

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";

	}

	public String documentoTXTAlta(Documento documento) {

		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "Alta.txt";

		try {
			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);

			pw.println(documento);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}

	public String documentoTXTModificar(Documento documento) {

		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "Moficiar.txt";

		try {
			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);

			pw.println(documento);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}

	public String documentoTXTEliminar(Documento documento) {

		FileWriter fw = null;
		PrintWriter pw = null;

		String nFichero = "Eliminar.txt";

		try {
			fw = new FileWriter(nFichero, true);
			pw = new PrintWriter(fw);

			pw.println(documento);

			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.close();
		}
		return "Fichero Guardado";
	}

	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}

	public static Boolean exportarExcel(String nombreHoja, Documento documento, String fileName) {
		Map<String, Object[]> documentos = new TreeMap<String, Object[]>();
		Integer numeroLineas = 0;

		File archivoExcel = new File(fileName);

		if (!archivoExcel.exists()) {
			documentos.put("0", new Object[] { "Codigo", "Nombre", "Fecha Creacion", "fechaUltimaActualizacion",
					"publico", "Estado" });
			numeroLineas = 1;
		} else {
			ArrayList<String[]> datosExcel = importExcel(fileName, 6);
			ListIterator<String[]> it = datosExcel.listIterator();

			while (it.hasNext()) {
				numeroLineas++;
				String[] datos = it.next();
				documentos.put(numeroLineas.toString(), datos);
			}
		}
		numeroLineas++;
		documentos.put(numeroLineas.toString(),
				new Object[] { documento.getCodigo(), documento.getNombre(), documento.getFechaCreacion().toString(),
						documento.getFechaUltimaActualizacion().toString(), documento.getPublico().toString(),
						documento.getEstado().toString() });

		XSSFWorkbook libro = new XSSFWorkbook();

		XSSFSheet hoja = libro.createSheet(nombreHoja);

		int ultimaFila = hoja.getLastRowNum();

		Set<String> keyset = documentos.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// cramos la fila
			Row row = hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = documentos.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);
			// cerramos el fichero y el libro
			out.close();
			libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
