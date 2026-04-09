package pract11;

import java.util.*;
import java.text.SimpleDateFormat;

public class Student {
    String name;
    Date birthDate;

    Student(String name, Date birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    String getBirthDate(String format){
        switch(format){
            case "short": new SimpleDateFormat("dd MM yy").format(birthDate);
            case "full": new SimpleDateFormat("EEEE, d MMMM yyyy").format(birthDate);

            default: return new SimpleDateFormat("dd.MM.yyyy").format(birthDate);
        }
    }

    @Override
    public String toString(){
        return name + "(родился: " + new SimpleDateFormat("dd.MM.yyyy").format(birthDate)
                + ")";
    }
}
