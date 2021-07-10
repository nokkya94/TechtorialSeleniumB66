package api_class.desserialization.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PetPOJOoption2 {

    long id;
    CategoryPojo category;
    String name;
    List<String> photoUrls;
    List<TagsPojo> tags;
    String status;



}
