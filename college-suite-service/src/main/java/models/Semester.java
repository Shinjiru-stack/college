package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableSemester.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Immutable
public interface Semester {

    /**
     *
     * @return
     */
    
    UUID getId();

    /**
     *
     * @return
     */
    @NotNull
    String getName();

    /**
     *
     * @return
     */
    @NotNull
    String getYear();

    /**
     *
     * @return
     */
    @NotNull
    Department getDepartment();

    /**
     *
     * @return
     */
    @NotNull
    List<Subject> getSubjects();
    
    
    
    
}