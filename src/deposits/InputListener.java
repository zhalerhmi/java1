package deposits;

import javax.xml.bind.Unmarshaller;

/**
 * Created by DOTIN SCHOOL 4 on 9/6/2016.
 */
public class InputListener extends Unmarshaller.Listener {

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (target instanceof Deposit) {
            Deposit deposit = (Deposit) target;

            // deposit.setDepositTypeObject();

            deposit.setPayedInterest();

        } else
            super.afterUnmarshal(target, parent);

    }
}
