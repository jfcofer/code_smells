public class refactored_long_parameter_list {

    public class GenerateReport {

        // Clase interna para manejar los metadatos del reporte
        public static class Metadata {
            private String titulo;
            private String autor;
            private String editorialCodigo;
    
            // Constructor para inicializar los metadatos
            public Metadata(String titulo, String autor, String editorialCodigo) {
                this.titulo = titulo;
                this.autor = autor;
                this.editorialCodigo = editorialCodigo;
            }
        }
    
        // Clase interna para manejar el contenido del reporte
        public static class Content {
            private String indice;
            private String contenido;
            private String bibliografia;
    
            // Constructor para inicializar el contenido
            public Content(String indice, String contenido, String bibliografia) {
                this.indice = indice;
                this.contenido = contenido;
                this.bibliografia = bibliografia;
            }
        }
    
        // Atributos de la clase GenerateReport
        private Metadata metadata;
        private Content content;
    
        // Constructor de GenerateReport
        public GenerateReport(Metadata metadata, Content content) {
            this.metadata = metadata;
            this.content = content;
        }

        
        // Método principal para probar la clase
        public static void main(String[] args) {
            Metadata metadata = new Metadata("El Título", "El Autor", "Editorial123");
            Content content = new Content("Índice del Reporte", "Contenido del Reporte", "Bibliografía del Reporte");
    
            GenerateReport report = new GenerateReport(metadata, content);
    
            System.out.println(report);
        }
    }
    
}