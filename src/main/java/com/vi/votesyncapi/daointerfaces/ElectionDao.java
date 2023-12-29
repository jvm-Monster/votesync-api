package com.vi.votesyncapi.daointerfaces;

import com.vi.votesyncapi.model.Election;
import com.vi.votesyncapi.model.Student;

import java.util.List;
import java.util.Map;

/**
 * DAO for {@link Election}
 */
public interface ElectionDao {
    //Sets of Operations

    List<Election> getElections(String schoolId);
    void addElection(Election election);//add new election
    void removeElection(Election election);
    void updateElection(Election election);
}
