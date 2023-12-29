package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.model.ElectionType;

import java.util.List;

public interface ElectionTypeDao {
    List<ElectionType> getElections(String school,String electionType);
}
