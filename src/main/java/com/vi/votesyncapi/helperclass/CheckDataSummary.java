package com.vi.votesyncapi.helperclass;

import com.vi.votesyncapi.util.ResourceBeanParam;

public class CheckDataSummary{

    public static boolean checkDataSummary(ResourceBeanParam resourceBeanParam){
        return resourceBeanParam != null && resourceBeanParam.isSummary();
    }
}
