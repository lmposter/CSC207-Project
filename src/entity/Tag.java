package entity;

import java.util.ArrayList;

public class Tag {
    public String tag;
    ArrayList<String> tagsContent = new ArrayList<>();
    Tag(String tag){
        this.tag = tag;
        boolean notInTagsContent = !(tagsContent.contains(tag));
        if (notInTagsContent) {
            tagsContent.add(tag);
        }
    }

}
