package com.vi.votesyncapi.util;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;

@Getter
public class ResourceBeanParam {

    @QueryParam("s")
    private boolean summary;

    public void setSummary(boolean summary) {
        this.summary = summary;
    }
}
