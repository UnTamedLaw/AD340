package com.example.homework2;

import java.util.ArrayList;
import java.util.List;

public class AgeContent {
    List<String> getContent(String age) {
        List<String> contents = new ArrayList<>();
        if (age.equals("Under the age of 18")) {
            contents.add("Minecraft");
            contents.add("Fortnite");
        } else if (age.equals("18 to 22")) {
            contents.add("Dating in College");
            contents.add("How to find an internship");

        } else if (age.equals("22-29")) {
            contents.add("Guide to owning the your first house");
            contents.add("Marriage 101");
        } else if (age.equals("Over the age of 30")) {
            contents.add("How to raise kids 101");
            contents.add("Keeping marital satisfaction");

        }
        return contents;
    }
}
