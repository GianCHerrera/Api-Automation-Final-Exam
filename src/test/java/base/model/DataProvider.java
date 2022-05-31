package base.model;

import java.util.ArrayList;

import static base.model.EmailGenerator.uuid;

/**
 * The type Data provider.
 */
public class DataProvider {
    /**
     * The List of users.
     */
    public ArrayList<User> listOfUsers = new ArrayList<>();

    /**
     * Instantiates a new Data provider.
     *
     * @param numberOfUsers the number of users
     */
    public DataProvider(int numberOfUsers) {

        for (int i = 0; i < numberOfUsers; i++) {
            String email = uuid() + "@testing.com";
            String telephone = "3129188877";
            String country = "Colombia";
            Double amount = 20033.2;
            boolean active = true;
            String name = "name";
            String lastName = "lastName";
            float accountNumber = 23231312;
            String transactionType = "NA";
            User user = new User(name, lastName, accountNumber, transactionType, email, active, country, telephone, amount);
            listOfUsers.add(user);
        }

    }

    /**
     * Check if an email is repeated string.
     *
     * @return the string
     */
    public String checkIfAnEmailIsRepeated(){
        for (int i = 0; i < listOfUsers.size(); i++) {
            String emailCheck = listOfUsers.get(i).getEmail();
            for (int j = i+1; j < listOfUsers.size(); j++) {
                if(emailCheck.equals(listOfUsers.get(j).getEmail())){
                    return "El correo " + emailCheck + " se encuentra repetido";
                }
            }
        }
        return "no hay emails duplicados";
    }

}
