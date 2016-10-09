package deposits;

import exceptions.DepositBalanceException;
import exceptions.DepositTypeException;
import exceptions.DurationDaysException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


/**
 * Created by DOTIN SCHOOL 4 on 9/4/2016.
 */

@XmlRootElement(name = "deposit")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Deposit implements Comparable {

    private String customerNumber;
    private BigDecimal depositBalance;
    private BigDecimal durationInDays;
    // private String depositType;
    private DepositType depositTypeObject;
    private BigDecimal payedInterest;


    /*public String getDepositType() {

        return depositType;
    }

    @XmlElement(name = "depositType")
    public void setDepositType(String depositType) {

        this.depositType = depositType;

    }*/

    public String getDepositTypeObject() {

        return depositTypeObject.toString();

    }

    @XmlElement(name = "depositType")
    public void setDepositTypeObject(String depositType) throws IllegalAccessException, InstantiationException {
        try {
            this.depositTypeObject = (DepositType) Class.forName("deposits." + depositType).newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Customer #" + customerNumber + " has invalid deposit type.");
            throw new DepositTypeException();

        }
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    @XmlElement(name = "customerNumber")
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public BigDecimal getDurationInDays() {

        return durationInDays;
    }

    @XmlElement(name = "durationInDays")
    public void setDurationInDays(BigDecimal durationInDays) {
        if (durationInDays.compareTo(BigDecimal.ZERO) > 0) {
            this.durationInDays = durationInDays;
        } else
            System.out.println("Customer #" + customerNumber + " has invalid duration in days.");
            throw new DurationDaysException();

    }

    public BigDecimal getDepositBalance() {

        return depositBalance;

    }

    @XmlElement(name = "depositBalance")
    public void setDepositBalance(BigDecimal depositBalance) {
        if (depositBalance.compareTo(BigDecimal.ZERO) >= 0) {
            this.depositBalance = depositBalance;
        } else {
            System.out.println("Customer #" + customerNumber + " has invalid number.");
            throw new DepositBalanceException();
        }
    }


    public void setPayedInterest() {
        try {
            int interestRate = depositTypeObject.getInterestRate();

            this.payedInterest =
                    (depositBalance.multiply(BigDecimal.valueOf(interestRate)).multiply(durationInDays)).divide(BigDecimal.valueOf(36500), 5, BigDecimal.ROUND_HALF_EVEN);
        } catch (NullPointerException e) {
            System.out.println("Customer #" + customerNumber + " doesn't have valid fields to maintain a valid payed interest.");
            payedInterest = BigDecimal.valueOf(-1);
        }


    }

    public BigDecimal getPayedInterest() {
        return payedInterest;
    }


    @Override
    public int compareTo(Object o) {
        if (o != null) {
            Deposit deposit = (Deposit) o;
            return deposit.getPayedInterest().compareTo(this.payedInterest);
        } else {
            return -1;
        }
    }
}
