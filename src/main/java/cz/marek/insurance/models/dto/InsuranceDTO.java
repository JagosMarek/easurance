package cz.marek.insurance.models.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class InsuranceDTO {

    private long insuranceId;
    private long insuredId;
    @NotNull(message = "Vyberte pojištění ze seznamu")
    private long insuranceListId;
    @NotBlank(message = "Vyplňte limit")
    @NotNull(message = "Vyplňte limit")
    @Pattern(regexp = "\\d+", message = "Limit musí být kladné číslo")
    private String insuranceLimit;
    @NotNull(message = "Vyplňte datum")
    @FutureOrPresent(message = "Počáteční datum musí být dnešní nebo budoucí datum")
    private LocalDate beginning;
    @NotNull(message = "Vyplňte datum")
    @FutureOrPresent(message = "Datum ukončení musí být dnešní nebo budoucí datum")
    private LocalDate end;
    @NotBlank(message = "Vyplňte předmět pojištění")
    @NotNull(message = "Vyplňte předmět pojištění")
    private String subjectOfInsurance;

    @AssertTrue
    public boolean isBeginningBeforeEnd() {
        if (getBeginning() == null || getEnd() == null) {
            return true;
        }
        return getBeginning().isBefore(getEnd()) || getBeginning().isEqual(getEnd());
    }


    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public long getInsuranceListId() {
        return insuranceListId;
    }

    public void setInsuranceListId(long insuranceListId) {
        this.insuranceListId = insuranceListId;
    }
    public String getInsuranceLimit() {
        return insuranceLimit;
    }

    public void setInsuranceLimit(String insuranceLimit) {
        this.insuranceLimit = insuranceLimit;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDate beginning) {
        this.beginning = beginning;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getSubjectOfInsurance() {
        return subjectOfInsurance;
    }

    public void setSubjectOfInsurance(String subjectOfInsurance) {
        this.subjectOfInsurance = subjectOfInsurance;
    }
}


