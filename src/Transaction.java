class Transaction {
    private double amount;
    private String originatingAccountId;
    private String recipientAccountId;
    private String reason;

    public Transaction(double amount, String originatingAccountId, String recipientAccountId, String reason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.recipientAccountId = recipientAccountId;
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public String getOriginatingAccountId() {
        return originatingAccountId;
    }

    public String getRecipientAccountId() {
        return recipientAccountId;
    }

    public String getReason() {
        return reason;
    }
}