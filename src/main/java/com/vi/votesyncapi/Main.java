package com.vi.votesyncapi;

import com.vi.votesyncapi.dao.SchoolDaoImpl;
import com.vi.votesyncapi.dao.VoteDaoImpl;
import com.vi.votesyncapi.daointerfaces.SchoolDao;
import com.vi.votesyncapi.daointerfaces.VoteDao;
import com.vi.votesyncapi.dto.StudentDto;
import com.vi.votesyncapi.dto.VoteDto;
import com.vi.votesyncapi.mapper.StudentMapper;
import com.vi.votesyncapi.mapper.VoteMapper;
import com.vi.votesyncapi.model.*;
import com.vi.votesyncapi.util.DatabaseManager;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        VoteDao voteDao = new VoteDaoImpl(new DatabaseManager());
        System.out.println(voteDao.getStudentVotes("220309","au","AUSA","presidential"));
    }
}
