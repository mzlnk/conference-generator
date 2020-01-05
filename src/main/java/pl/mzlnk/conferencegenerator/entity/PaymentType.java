package pl.mzlnk.conferencegenerator.entity;

public enum PaymentType {

    CASH("CASH"),
    CHEQUE("CHEQUE"),
    CREDIT_CARD("CREDIT_CARD");

    private String name;

    private PaymentType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
