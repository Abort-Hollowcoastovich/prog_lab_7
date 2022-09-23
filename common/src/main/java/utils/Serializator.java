package utils;

import java.io.*;

public class Serializator {
    public static <T> T deserializeObject(byte[] buffer) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (T) objectInputStream.readObject();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Deserialization problem");
            e.printStackTrace();
        }
        return null;
    }

    public static <T> byte[] serializeObject(T object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            byte[] arr = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            return arr;
        } catch (IOException e) {
            System.out.println("Serialization problem");
            e.printStackTrace();
        }
        return null;
    }
}
