import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Name1", "Fam1", 18));
        persons.add(new Person("Name2", "Fam2", 19));
        persons.add(new Person("Name3", "Fam3", 17));
        persons.add(new Person("Name4", "Fam4", 16));
        persons.add(new Person("Name5", "Fam5", 15));
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(Person.nameFile)) {
            gson.toJson(persons, writer);
        }catch (Exception e){
            e.printStackTrace();
        }

        persons.clear();

        persons = gson.fromJson(new FileReader(Person.nameFile), List.class);
        System.out.println(persons);

    }

}
