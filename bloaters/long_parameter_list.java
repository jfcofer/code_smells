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

        // Getters y setters (opcional, pero útil para acceso posterior)
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getEditorialCodigo() {
            return editorialCodigo;
        }

        public void setEditorialCodigo(String editorialCodigo) {
            this.editorialCodigo = editorialCodigo;
        }

        public String getIndice() {
            return indice;
        }

        public void setIndice(String indice) {
            this.indice = indice;
        }

        public String getContenido() {
            return contenido;
        }

        public void setContenido(String contenido) {
            this.contenido = contenido;
        }

        public String getBibliografia() {
            return bibliografia;
        }

        public void setBibliografia(String bibliografia) {
            this.bibliografia = bibliografia;
        }

        @Override
        public String toString() {
            return "GenerateReport{" +
                   "titulo='" + titulo + '\'' +
                   ", autor='" + autor + '\'' +
                   ", editorialCodigo='" + editorialCodigo + '\'' +
                   ", indice='" + indice + '\'' +
                   ", contenido='" + contenido + '\'' +
                   ", bibliografia='" + bibliografia + '\'' +
                   '}';
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
