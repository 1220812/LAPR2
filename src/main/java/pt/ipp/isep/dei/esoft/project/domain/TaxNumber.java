package pt.ipp.isep.dei.esoft.project.domain;

public class TaxNumber {
    // ATTRIBUTES

    private int taxNumber;
    private final int TAX_NUMBER_BY_DEFAULT = 0;

    // CONSTRUCTORS
    /**
     * This method creates the TaxNumber object without attributes
     */
    public TaxNumber(){
        this.taxNumber = TAX_NUMBER_BY_DEFAULT;
    }
    /**
     *
     *  This method creates the TaxNumber object
     *
     * @param taxNumber tax number
     */
    public TaxNumber(int taxNumber){
        this.taxNumber = taxNumber;
    }

    //SETS AND GETS

    /**
     *  This method returns the taxNumber of the taxNumber
     *
     * @return taxNumber
     */
    public int getTaxNumber() {
        return taxNumber;
    }

    /**
     *  This method changes the passportNumber of the PassportCard
     * @param taxNumber
     */
    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * This method returns the characteristics of the taxNumber
     * @return characteristics of the taxNumber
     */
    @Override
    public String toString() {
        return "TaxNumber{" +
                "taxNumber=" + taxNumber +
                ", TAX_NUMBER_BY_DEFAULT=" + TAX_NUMBER_BY_DEFAULT +
                '}';
    }
}