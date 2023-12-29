package com.vi.votesyncapi.helperclass;

import com.vi.votesyncapi.model.School;
import com.vi.votesyncapi.model.Student;

public class UpdateDataHelper {

    public static void updateStudentChangedData(Student source,Student target){
        if (source.getStudentName() != null && !source.getStudentName().isEmpty()) {
            target.setStudentName(source.getStudentName());
        } else if (source.getStudentId()!=null && !source.getStudentId().isEmpty()) {
            target.setStudentId(source.getStudentId());
        } else if (source.getStudentEmail()!=null&&!source.getStudentEmail().isEmpty()) {
            target.setStudentEmail(source.getStudentEmail());
        } else if (source.getStudentPassword()!=null&&!source.getStudentPassword().isEmpty()) {
            target.setStudentPassword(source.getStudentPassword());
        }
        updateSchoolChangedData(source.getSchool(),target.getSchool());
    }

    public static void updateSchoolChangedData(School source, School target){
        if (source.getSchoolName() != null && !source.getSchoolName().isEmpty()) {
            target.setSchoolName(source.getSchoolName());
        } else if (source.getSchoolId()!=null && !source.getSchoolId().isEmpty()) {
            target.setSchoolId(source.getSchoolId());
        } else if (source.getState()!=null&&!source.getState().isEmpty()) {
            target.setState(source.getState());
        }
    }
}
