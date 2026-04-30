package sistema;

public class Invoice {
	int invoiceId;
	String number,customerName,issueDate,totalAmount,paid;
	
	DataInvoice di=new DataInvoice();
	public Invoice() {
		super();
	}
	public Invoice(int invoiceId, String number, String customerName, String issueDate, String totalAmount,
			String paid) {
		super();
		this.invoiceId = invoiceId;
		this.number = number;
		this.customerName = customerName;
		this.issueDate = issueDate;
		this.totalAmount = totalAmount;
		this.paid = paid;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	public boolean cargarInvoice() {
		return di.cargarInvoice(this);
	}

	
}
