package deposits;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by DOTIN SCHOOL 4 on 9/3/2016.
 */

@XmlRootElement(name = "deposits")
@XmlAccessorType(XmlAccessType.FIELD)
public class Deposits {
    @XmlElement(name = "deposit")
    private List<Deposit> deposits = null;

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }


}
