package pdf;


/**
 *
 * @author MATOSHRI
 */
public class Application {
    private String officeName,applicationNo,apllicantName,date,DOB,reciptTransactionType,COV;
    private String receiptDate,receiptNo,bankGateway,bankReferenceNo,transactionID;
    private String licenceType , referenceNo,licenceTypeAndNo;

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public String getLicenceTypeAndNo() {
        return licenceTypeAndNo;
    }

    public void setLicenceTypeAndNo(String licenceTypeAndNo) {
        if(licenceTypeAndNo.length()>=0){
         String licenceName = licenceTypeAndNo.split(":")[1];
         if(licenceName.startsWith("LL")){
             this.licenceType = "LL";
         }
         else{
             this.licenceType = "DL";   
         }
         this.referenceNo = licenceTypeAndNo.split(":")[2];
        }
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        if(referenceNo.length()>=0)
        this.referenceNo = referenceNo.split(":")[2];
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getBankGateway() {
        return bankGateway;
    }

    public void setBankGateway(String bankGateway) {
        this.bankGateway = bankGateway;
    }

    public String getBankReferenceNo() {
        return bankReferenceNo;
    }

    public void setBankReferenceNo(String bankReferenceNo) {
        this.bankReferenceNo = bankReferenceNo;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
    public String getCOV() {
        return COV;
    }

    public void setCOV(String COV) {
        this.COV = COV;
    }

    public String getReciptTransactionType() {
        return reciptTransactionType;
    }

    public void setReciptTransactionType(String reciptTransactionType) {
        this.reciptTransactionType = reciptTransactionType;
    }

  
    

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getApllicantName() {
        return apllicantName;
    }

    public void setApllicantName(String apllicantName) {
        this.apllicantName = apllicantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "Application{" + "officeName=" + officeName + ", applicationNo=" + applicationNo + ", apllicantName=" + apllicantName + ", date=" + date + ", DOB=" + DOB + ", reciptTransactionType=" + reciptTransactionType + ", COV=" + COV + ", receiptDate=" + receiptDate + ", receiptNo=" + receiptNo + ", bankGateway=" + bankGateway + ", bankReferenceNo=" + bankReferenceNo + ", transactionID=" + transactionID + ", licenceType=" + licenceType + ", referenceNo=" + referenceNo + '}';
    }

   

}