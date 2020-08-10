package com.galvanize.springdemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommunityTest {

    @Test
    public void setCommunity()
    {
        Community community = new Community();

        community.setName("Supervisors");
        String name = community.getName();
        community.setId(1l);

        assertEquals("Supervisors", name);
        assertEquals(1, community.getId());


    }
}
