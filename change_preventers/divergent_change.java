import java.util.List;

public class divergent_change{

    /*
    * Imagine una clase ReportSender que es responsable de enviar informes de varias maneras:
    * publicando, enviando spam, apuntando a clientes específicos, etc. 
    * Si cada vez que necesita agregar o cambiar un método de envío, tiene que actualizar 
    * varios métodos en esta clase, demuestra el olor de cambio divergente.
    */


    
    public class Report {
        
        String content;

        public String getContent() {
            return content;
        }
    }

    
    public class ReportSender {
        private String senderType; // "publishing", "spam", or "targeted"
        private List<String> targetClients;

        public ReportSender(String senderType, List<String> targetClients) {
            this.senderType = senderType;
            this.targetClients = targetClients;
        }

        public void sendReport(Report report) {
            switch (senderType.toLowerCase()) {
                case "publishing":
                    sendAsPublication(report);
                    break;
                case "spam":
                    sendAsSpam(report);
                    break;
                case "targeted":
                    sendToTargetClients(report);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown sender type: " + senderType);
            }
        }

        private void sendAsPublication(Report report) {
            // Logic for sending the report as a publication
            System.out.println("Publishing report: " + report.getContent());
        }

        private void sendAsSpam(Report report) {
            // Logic for sending the report as spam
            System.out.println("Sending report as spam: " + report.getContent());
        }

        private void sendToTargetClients(Report report) {
            // Logic for sending the report to target clients
            for (String client : targetClients) {
                System.out.println("Sending report to client " + client + ": " + report.getContent());
            }
        }
    }
}