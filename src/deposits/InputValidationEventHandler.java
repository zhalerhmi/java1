package deposits;

import exceptions.DepositBalanceException;
import exceptions.DepositTypeException;
import exceptions.DurationDaysException;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/**
 * Created by DOTIN SCHOOL 4 on 9/7/2016.
 */
public class InputValidationEventHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        try {
            throw event.getLinkedException();
        } catch (DurationDaysException e) {
            return true;
        } catch (DepositBalanceException e) {
            return true;
        } catch (DepositTypeException e) {
            return true;
        } catch (Throwable throwable) {
            return false;
        }
    }
}
