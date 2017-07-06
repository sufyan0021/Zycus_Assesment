/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.lang.OutOfMemoryError;

/**
 *
 * @author sufya
 */
public class Ser_Map {

    /**
     * @param args the command line arguments
     */
    static java.util.Map<Integer, String> map = Collections.synchronizedMap(new HashMap<Integer, String>());
    static Thread  t1;
   /* public  static void serialize()
    {
         t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try
           {
                  FileOutputStream fos =
                     new FileOutputStream("hashmap.ser");
                  ObjectOutputStream oos = new ObjectOutputStream(fos);
                  oos.writeObject(map);
                  oos.close();
                  fos.close();
                  System.out.printf("Serialized HashMap data is saved in hashmap.ser");
           }catch(IOException ioe)
            {
                  ioe.printStackTrace();
            } 
                }
            }); 
         t1.start();
        deserialize();
    }*/
   /* public static void deserialize()
    {
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try
      {
         FileInputStream fis = new FileInputStream("hashmap.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         map = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
                for(Integer key:map.keySet())
                {
                    System.out.println("Key "+key+"\tValue"+map.get(key));
                }
            }
        });
        t2.start();
    }*/
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        try{
        int i = 1;
       BufferedReader br = new BufferedReader(new FileReader("model.txt"));
        String line = br.readLine();
        while(line!=null){
             map.put(i, line);
             i++;
        }
        br.close();
        System.out.println("12");
        for(Integer Key:map.keySet())
      {
          System.out.println("33");
          System.out.println("Key "+Key+"\tValue "+map.get(Key));
      }
        }
        catch(OutOfMemoryError ex)
        {
            System.out.println("Excep occured");
            //serialize();
            t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try
           {
                  FileOutputStream fos =
                     new FileOutputStream("hashmap1.ser");
                  ObjectOutputStream oos = new ObjectOutputStream(fos);
                  oos.writeObject(map);
                  oos.close();
                  fos.close();
                  System.out.printf("Serialized HashMap data is saved in hashmap.ser");
           }catch(IOException ioe)
            {
                  ioe.printStackTrace();
            } 
                }
            }); 
         
            
        }
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try
      {
         FileInputStream fis = new FileInputStream("hashmap1.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         map = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      }catch(IOException ioe)
      {
         ioe.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      }
                for(Integer key:map.keySet())
                {
                    System.out.println("Key "+key+"\tValue"+map.get(key));
                }
            }
        });
        t1.start();
        t2.start();
     
    }
}
