package ejercicioBibliotecaFebrero;
public class App {

    public static void main(String[] args) {
        // Crear la biblioteca y agregar usuarios y documentos
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarUsuario(new Socio("111", "Usuario1"));
        biblioteca.agregarUsuario(new UsuarioOcasional("222", "Usuario2"));
        biblioteca.agregarDocumento(new Libro("L001", "Libro1", 2000));
        biblioteca.agregarDocumento(new Revista("1", "Revista1"));

        // Mostrar lista de documentos antes de seleccionar ninguno
        System.out.println("Lista de documentos antes de seleccionar ninguno:");
        biblioteca.buscaDocumentos("");

        // Seleccionar un documento y prestarlo a un usuario
        biblioteca.seleccionarDocumento("L001");
        try {
            biblioteca.prestarDocumentoActual("111");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar lista de documentos después de realizar un préstamo
        System.out.println("\nLista de documentos después de realizar un préstamo:");
        biblioteca.buscaDocumentos("");

        // Seleccionar otro documento y prestarlo a otro usuario
        biblioteca.seleccionarDocumento("Revista1");
        try {
            biblioteca.prestarDocumentoActual("222");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mostrar informe de préstamos
        System.out.println("\nInforme de prestamos:");
        try {
			biblioteca.informePrestamos();
		} catch (Exception e) {
			System.err.println("Informe vacio");
		}

        // Intentar devolver un documento no prestado
        biblioteca.seleccionarDocumento("L001");
        biblioteca.devuelveDocumentoActual();

        // Mostrar informe de préstamos después de intentar devolver un documento no prestado
        System.out.println("\nInforme de prestamos despues de intentar devolver un documento no prestado:");
        try {
			biblioteca.informePrestamos();
		} catch (Exception e) {
			System.err.println("Informe vacio");
		}
    }
}
