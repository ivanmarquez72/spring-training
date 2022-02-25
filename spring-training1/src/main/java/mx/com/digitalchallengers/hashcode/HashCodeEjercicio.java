package mx.com.digitalchallengers.hashcode;

import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class HashCodeEjercicio {
    public HashCodeEjercicio() {
    }

    public void ejercicio(){
        //HashCode
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        System.out.println("s1 == s2 :"+(s1==s2));
        System.out.println("s1 == s3 :"+(s1==s3));
        System.out.println("s2 == s3 :"+(s2==s3));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(" ");


        Point blank = new Point(3,4);
        int x = blank.x;
        System.out.println(blank.x + " " + blank.y);
        int sum = blank.x * blank.x + blank.y * blank.y;
        System.out.println(sum);
        System.out.println("");
        String text = "";
        for (int i = 0; i < 10; i++) {
            String line = " hi " + i;        // new string
            //Crea 2 nuevos Strings
            text = text + line + '\n';    // two more strings
        }

        //crea 30 strings
        System.out.print("You entered:\n" + text);
        StringBuilder text2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            String line = "Helloda";
            text2.append(line);
            text2.append('\n');
        }

        //Crea 10 Strings y los concatena a text2 sin tener
        // que volver a hacer un objeto cada que concatena
        System.out.print("You entered:\n" + text2);
        String result = text2.toString();

        //Lo vuelve String
        System.out.println(result);

    }
}
