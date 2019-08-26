package contact.arturneto.courses.springboot.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
@Getter@Setter
public class PagebleResponse<T> extends PageImpl<T> {

    private boolean first;
    private boolean last;
    private int totalPages;
    public PagebleResponse(@JsonProperty("content") List<T> content,
                           @JsonProperty("number") int page,
                           @JsonProperty("size") int size,
                           @JsonProperty("totalElements") long totalElements) {

        super(content, new PageRequest(page,size), totalElements);
    }

    public PagebleResponse() {
        super(new ArrayList<>());
    }
}