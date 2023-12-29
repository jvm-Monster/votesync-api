package com.vi.votesyncapi.model;

import com.vi.votesyncapi.resource.v1.SchoolResourceV1;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model For {@link SchoolResourceV1}
 */
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class School {
    @Id
    String schoolId;
    String schoolName;
    String schoolShortName;
    String state;

    public School(String schoolId, String schoolName, String schoolShortName,String state) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolShortName=schoolShortName;
        this.state = state;
    }


}
