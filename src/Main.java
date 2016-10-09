import deposits.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, JAXBException {

        File file = new File("src\\files\\xml.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Deposits.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        jaxbUnmarshaller.setListener(new InputListener());

        jaxbUnmarshaller.setEventHandler(new InputValidationEventHandler());


        Deposits deposits = (Deposits) jaxbUnmarshaller.unmarshal(file);


        for (Deposit deposit : deposits.getDeposits()) {

            System.out.println("\nCustomer#"+deposit.getCustomerNumber());
            System.out.println("Deposit Balance: "+deposit.getDepositBalance());
            System.out.println("Duration in Days: "+deposit.getDurationInDays());
            System.out.println("Payed Interest: "+deposit.getPayedInterest());


        }


        Collections.sort(deposits.getDeposits());

        randomAccessFileWriter(deposits);


    }

    public static void randomAccessFileWriter(Deposits deposits) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {

        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src\\files\\file.txt", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Deposit deposit : deposits.getDeposits()) {
            if (randomAccessFile != null) {
               randomAccessFile.write((deposit.getCustomerNumber() + "#" + deposit.getPayedInterest() + "\n").getBytes());
            }

        }

        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }
}
