package dev.keith;

public enum ResultType {
    SUCCESS(true),
    FAIL(true),
    EXCEPTION(false),
    ERROR(false),
    ;
    ResultType(boolean canContinue) {
        this.canContinue = canContinue;
    }
    final boolean canContinue;
}
