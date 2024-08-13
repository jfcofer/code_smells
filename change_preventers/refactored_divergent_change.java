import java.util.List;

import divergent_change.Report;

public class refactored_divergent_change {

    /*
    * En esta versión refactorizada del diseño, hemos eliminado el olor a cambio divergente 
    * y creado un sistema más escalable y fácil de mantener.
    *
    * Tratamiento:
    * 
    * - Se ha definido una interfaz ReportSender con un método sendReport, que representa 
    *   el comportamiento general para enviar informes.
    * - Se han creado clases concretas que implementan la interfaz ReportSender, cada una 
    *   encargada de un método específico para enviar el informe:
    *     - PublishingReportSender: Envía el informe mediante publicación.
    *     - SpamReportSender: Envía el informe como spam.
    *     - TargetClientReportSender: Envía el informe a una lista de clientes específicos.
    * - Se ha introducido una fábrica, ReportSenderFactory, para crear instancias de los 
    *   diferentes ReportSender según el tipo especificado.
    * - Se ha introducido la clase ReportService, que utiliza un ReportSender para generar 
    *   y enviar informes, delegando la lógica específica de envío a la instancia de 
    *   ReportSender proporcionada.
    *
    * Beneficios:
    * 
    * - Mejora la organización del código al separar claramente las responsabilidades de 
    *   envío en diferentes clases.
    * - Reduce la duplicación de código al centralizar el comportamiento de envío en la 
    *   interfaz y las implementaciones específicas.
    * - Simplifica el soporte al permitir cambios y adiciones en los métodos de envío 
    *   sin afectar otras partes del sistema.
    */

    public interface ReportSender {
        void sendReport(Report report);
    }
    
    public class PublishingReportSender implements ReportSender {
    @Override
    public void sendReport(Report report) {
        // Logic for publishing the report
        System.out.println("Publishing report: " + report.getContent());
        }
    }

    public class SpamReportSender implements ReportSender {
        @Override
        public void sendReport(Report report) {
            // Logic for sending the report as spam
            System.out.println("Sending report as spam: " + report.getContent());
        }
    }

    public class TargetClientReportSender implements ReportSender {
        private List<String> targetClients;

        public TargetClientReportSender(List<String> targetClients) {
            this.targetClients = targetClients;
        }

        @Override
        public void sendReport(Report report) {
            // Logic for sending the report to target clients
            for (String client : targetClients) {
                System.out.println("Sending report to client " + client + ": " + report.getContent());
            }
        }
    }

    public class ReportSenderFactory {
        public static ReportSender createReportSender(String type, List<String> targetClients) {
            switch (type.toLowerCase()) {
                case "publishing":
                    return new PublishingReportSender();
                case "spam":
                    return new SpamReportSender();
                case "targeted":
                    return new TargetClientReportSender(targetClients);
                default:
                    throw new IllegalArgumentException("Unknown report sender type: " + type);
            }
        }
    }

    public class ReportService {
        private ReportSender reportSender;

        public ReportService(ReportSender reportSender) {
            this.reportSender = reportSender;
        }

        public void generateAndSendReport(String content) {
            Report report = new Report(content);
            reportSender.sendReport(report);
        }
    }

}
