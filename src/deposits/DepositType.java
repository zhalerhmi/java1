package deposits;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by DOTIN SCHOOL 4 on 9/4/2016.
 */
@XmlRootElement(name = "deposit")
@XmlAccessorType(XmlAccessType.FIELD)
public class DepositType {


    public int interestRate;

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }


}

