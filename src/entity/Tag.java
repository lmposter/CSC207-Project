package entity;

import java.util.ArrayList;

public class Tag {
    public String tag;
    public static ArrayList<String> allTags = new ArrayList<>();
    public Tag(String tag){
        this.tag = tag;
        boolean notInTagsContent = ! allTags.contains(tag);
        if (notInTagsContent) {
            allTags.add(tag);
        }
    }
    public ArrayList<String> getAllTags(){
        return allTags;
    }

}
