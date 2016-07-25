import Exceptions.FileNotFoundException;
import Exceptions.NotEnoughPermissionsException;
import Exceptions.NotEnoughSpaceException;

/**
 * Created by codecadet on 24/05/16.
 */
public class Main {

    public static void main(String[] args) {


        FileManager fileManager = new FileManager();


        try {
            fileManager.createFile("cenas1");
            fileManager.getFile("cenas1");

        } catch (FileNotFoundException | NotEnoughPermissionsException | NotEnoughSpaceException ex) {
            System.out.println(ex.getMessage());
        }

        fileManager.login();

        try {
            fileManager.createFile("cenas1");
            fileManager.getFile("cenas1");
            fileManager.getFile("cenas2");

        } catch (FileNotFoundException | NotEnoughPermissionsException | NotEnoughSpaceException ex) {
            System.out.println(ex.getMessage());
        }

        fileManager.logout();

    }
}
