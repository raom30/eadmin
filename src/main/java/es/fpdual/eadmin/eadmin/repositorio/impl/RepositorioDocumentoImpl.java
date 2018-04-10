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

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
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
		exportExcel("Alta", documento, "Documentos.xlsx");
		logger.info("{} creado correctamente", documento.toString());

		logger.info("Saliendo del metodo : " + rdi.getNombreMetodo());

	}

	@Override
	public void modificarDocumento(Documento documento) {

		if (!documentos.contains(documento)) {// si existe el documento pues no entra.
			throw new IllegalArgumentException("El documento no existe");
		}
		rdi.documentoTXTModificar(documento);
		exportExcel("Modificar", documento, "Documentos.xlsx");
		documentos.set(documentos.indexOf(documento), documento);// Busca la posicion y lo cambia

	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> d.getCodigo().equals(codigo))
				.findFirst();
		rdi.documentoTXTEliminar(documentoEncontrado.get());
		exportExcel("Eliminar", documentoEncontrado.get(), "Documentos.xlsx");
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
			exportExcel("Eliminar", d, "Documentos.xlsx");
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

	public static void exportExcel(String nombreHoja, Documento documento, String fileName) {

		try {

			FileInputStream inputStream = new FileInputStream(new File(fileName));

			Workbook workbook = WorkbookFactory.create(inputStream);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);

			int numeroHoja;

			if (nombreHoja.equals("Documentos")) {

				numeroHoja = 0;

			} else if (nombreHoja.equals("Alta")) {

				numeroHoja = 1;

			} else if (nombreHoja.equals("Modificar")) {

				numeroHoja = 2;

			} else {

				numeroHoja = 3;

			}

			Sheet sheet = workbook.getSheetAt(numeroHoja);

			Object[] bookData = { documento.getCodigo(), documento.getNombre(), documento.getFechaCreacion().toString(),

					documento.getEstado().toString() };

			int rowCount = sheet.getLastRowNum();

			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;

			Cell cell = row.createCell(columnCount);

			cell.setCellStyle(style);

			cell.setCellValue(rowCount);

			for (Object field : bookData) {

				cell = row.createCell(++columnCount);

				if (field instanceof String) {

					cell.setCellValue((String) field);

				} else if (field instanceof Integer) {

					cell.setCellValue((Integer) field);

				}

			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(fileName);

			workbook.write(outputStream);

			workbook.close();

			outputStream.close();

		} catch (IOException | EncryptedDocumentException | InvalidFormatException ex) {

			ex.printStackTrace();

		}

	}
}
