package com.vi.votesyncapi.beanparamresources;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceBeanParam {

    @QueryParam("s")
    private boolean summary;

}
