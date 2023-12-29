package com.vi.votesyncapi;

import com.vi.votesyncapi.dao.SchoolDaoImpl;
import com.vi.votesyncapi.daointerfaces.SchoolDao;
import com.vi.votesyncapi.dto.StudentDto;
import com.vi.votesyncapi.dto.VoteDto;
import com.vi.votesyncapi.mapper.StudentMapper;
import com.vi.votesyncapi.mapper.VoteMapper;
import com.vi.votesyncapi.model.*;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

  /*   School school = new School("UNILAGs","Adeleke University","Osun");
        SchoolDao schoolDao = new SchoolDaoImpl();
        schoolDao.removeSchool(school.getSchoolId());
//        schoolDao.addSchool(school);*/

        //We want to generate a school id base on the name by randomly
        // picking 8 characters in the name and then adding the school abbreviation or short name at the end

        String schoolName = "AdelekeLove University";
        String schoolShortName = "_AU";

        Random random = new Random();
        char [] arrays = schoolName.toCharArray();
        Arrays.sort(arrays);

        System.out.println(arrays);

    }
}
