public interface ProcesadorDeArchivos {
    void procesarArchivo(String ruta);
}

public class ProcesadorDeTexto implements ProcesadorDeArchivos {
    @Override
    public void procesarArchivo(String ruta) {
        System.out.println("Procesando archivo de texto: " + ruta);
        // Lógica para procesar archivos de texto
    }
}

public class ProcesadorDeImagen implements ProcesadorDeArchivos {
    @Override
    public void procesarArchivo(String ruta) {
        System.out.println("Procesando archivo de imagen: " + ruta);
        // Lógica para procesar archivos de imagen
    }
}

public class SistemaDeArchivos {
    private ProcesadorDeArchivos procesadorDeArchivos;

    public SistemaDeArchivos(ProcesadorDeArchivos procesadorDeArchivos) {
        this.procesadorDeArchivos = procesadorDeArchivos;
    }

    public void procesar(String ruta) {
        procesadorDeArchivos.procesarArchivo(ruta);
    }
}
