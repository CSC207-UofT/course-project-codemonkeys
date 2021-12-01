package Commands;
import Managers.UserManager;

import java.io.*;

public abstract class ReadWriter<T> {
//    /**
//     * @param filepath location of ser file
//     * @param o object to be serialized
//     */
//    void saveToFile(String filepath, Object o) throws IOException;
//
//    /**
//     * @param filepath location of ser file
//     */
//    T readFromFile(String filepath) throws IOException, ClassNotFoundException;

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param o    stores the list of users to be serialized
     * @throws IOException
     */
    public void saveToFile(String filePath, T o) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(o);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
     */
    public T readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        T users = (T) input.readObject();
        input.close();
        return users;
    }
}
