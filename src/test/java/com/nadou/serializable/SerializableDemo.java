package com.nadou.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;

import lombok.Data;

public class SerializableDemo{
  @Test
  public void writeFile(){
     User user = new User();
     user.setName("lala");
     ObjectOutputStream oos = null;
     try {
       oos=new ObjectOutputStream(new FileOutputStream("/Users/xxx/Documents/SerializableDemo.txt"));
       oos.writeObject(user);
     } catch (IOException e) {
       e.printStackTrace();
     }finally {
       IOUtils.closeQuietly(oos);
     }
   }
  @Test
  public void readFile(){
     File file = new File("/Users/xxx/Documents/SerializableDemo.txt");
     ObjectInputStream ois = null;
     try {
       ois = new ObjectInputStream(new FileInputStream(file));
       User user = (User)ois.readObject();
       System.out.println("name:"+user.getName());
     } catch (IOException e) {
       e.printStackTrace();
     } catch (ClassNotFoundException e) {
       e.printStackTrace();
     }finally {
       IOUtils.closeQuietly(ois);
     }
   }

}

@Data
class User implements Serializable{
  private static final long serialVersionUID = 3046513312158612264L;

  private String name;
  private String sex;
}

