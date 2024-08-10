public class ReportGenerator {

    public void generateReport(String title, String subtitle, String author, String date, String content, String footer, int pageNumber, boolean includeHeader, boolean includeFooter, String format) {

        System.out.println("Title: " + title);
        System.out.println("Subtitle: " + subtitle);
        System.out.println("Author: " + author);
        System.out.println("Date: " + date);
        
        System.out.println("Content: " + content);
        
        if (includeHeader) {
            System.out.println("Page Number: " + pageNumber);
        }

        if (includeFooter) {
            System.out.println("Footer: " + footer);
        }
        
        System.out.println("Format: " + format);

        System.out.println("Report generated successfully!");
    }
}