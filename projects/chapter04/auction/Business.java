import java.util.ArrayList;

public class Business
{
    private ArrayList<Invoice> invoices;
    
    public Business()
    {
        invoices = new ArrayList<Invoice>();
    }
    
    /**
     * Add a new invoice to the list.
     */
    public void addInvoice(Invoice invoice)
    {
        invoices.add(invoice);
    }
    
    /**
     * List the total of each the invoices.
     */
    public void listInvoices()
    {
        for (Invoice invoice : invoices) {
            System.out.println("Invoice for $"+ invoice.getTotal());
        }
    }
    
    /**
     * @return The sum total of all invoices.
     */
    public int totalSales()
    {
        int salesTotal = 0;
        
        for (Invoice invoice : invoices) {
            salesTotal += invoice.getTotal();
        }

        return salesTotal;
    }
}
