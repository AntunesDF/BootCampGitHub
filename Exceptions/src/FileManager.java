import Exceptions.FileNotFoundException;
import Exceptions.NotEnoughPermissionsException;
import Exceptions.NotEnoughSpaceException;

/**
 * Created by codecadet on 24/05/16.
 */
public class FileManager {

    private boolean login;
    private boolean enoughSpace = true;
    private int numberOfArray = 6;
    private File[] files;



    public FileManager() {
        files = new File[numberOfArray];
    }


    public void login() {
        login = true;
        System.out.println("Logged in.");
    }


    public void logout() {
        login = false;
        System.out.println("Logged out.");
    }


    public File getFile(String fileName) throws FileNotFoundException, NotEnoughPermissionsException {

        if (!login) {
            throw new NotEnoughPermissionsException("Não vai dar.");
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                return files[i];
            }
        }
        throw new FileNotFoundException("Não há.");

    }


    public void createFile(String fileName) throws NotEnoughSpaceException, NotEnoughPermissionsException {

        if (!login) {
            throw new NotEnoughPermissionsException("Não vai dar.");
        }

        if (!enoughSpace) {
            throw new NotEnoughSpaceException("No moar room.");
        }

        for (int i = 0; i <= numberOfArray - 1; i++) {
            if (files[i] == null){
                files[i] = new File(fileName);
            }
        }

        if (files.length <= 6) {
            enoughSpace = true;
        }
        enoughSpace = false;

    }

}
