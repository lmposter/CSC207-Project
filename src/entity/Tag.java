package entity;

import java.util.ArrayList;

public class Tag {
    public String tag;
    ArrayList<String> allTags = new ArrayList<>();
    Tag(String tag){
        this.tag = tag;
        boolean notInTagsContent = !(allTags.contains(tag));
        if (notInTagsContent) {
            allTags.add(tag);
        }
    }
    public ArrayList<String> getAllTags(){
        return allTags;
    }

}
