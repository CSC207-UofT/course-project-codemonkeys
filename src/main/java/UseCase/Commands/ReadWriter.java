package UseCase.Commands;

import UseCase.Managers.*;

import java.io.*;

/**
 * This is an abstract class for module serializing and deserializing
 * It includes saveToFile and readFromFile methods
 *
 * Author Zixin (Charlie) Guo
 * Date: Dec 05 2021
 * Version: 1.0
 */
public abstract class ReadWriter<T> {

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param o    stores the list of users to be serialized
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
     */
    public T readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        T obj = (T) input.readObject();
        input.close();
        return obj;
    }
}
