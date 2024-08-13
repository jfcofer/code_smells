public class long_parameter_list {

    public static class GenerateReport {
        // Atributos de la clase GenerateReport
        private String titulo;
        private String autor;
        private String editorialCodigo;
        private String indice;
        private String contenido;
        private String bibliografia;

        // Constructor de GenerateReport con muchos parámetros
        public GenerateReport(String titulo, String autor, String editorialCodigo,
                              String indice, String contenido, String bibliografia) {
            this.titulo = titulo;
            this.autor = autor;
            this.editorialCodigo = editorialCodigo;
            this.indice = indice;
            this.contenido = contenido;
            this.bibliografia = bibliografia;
        }

        // Método principal para probar la clase
        public static void main(String[] args) {
            GenerateReport report = new GenerateReport(
                "El Título",
                "El Autor",
                "Editorial123",
                "Índice del Reporte",
                "Contenido del Reporte",
                "Bibliografía del Reporte"
            );

            System.out.println(report);
        }
    }
}
