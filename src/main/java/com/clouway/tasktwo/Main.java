package com.clouway.tasktwo;

import com.clouway.taskone.JsonCodec;
import com.clouway.taskone.MessageCodec;
import com.clouway.taskone.Person;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        MessageCodec codec = new JsonCodec();
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[2]))){
            json.append(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Type type = new TypeToken<List<Person>>() {}.getType();
        List<Person> unmarchalled = codec.unmarchall(json.toString(), type );
        System.out.println("User Count: " + unmarchalled.size());
        int ageSum = 0;
        for (Person person : unmarchalled) {
            ageSum += person.age;
        }
        System.out.println("Average age: " + ageSum/unmarchalled.size());
    }
}