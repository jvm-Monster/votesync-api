package com.vi.votesyncapi.services_interfaces;

import com.vi.votesyncapi.util.ResourceBeanParam;
import jakarta.ws.rs.core.Response;

import jakarta.ws.rs.core.Response;

public interface Service<T, ID> {

    Response getEntityService(ID entityId, ResourceBeanParam resourceBeanParam);

    Response getAllEntitiesService(ResourceBeanParam resourceBeanParam);

    Response addEntityService(T entity);

    Response updateEntityService(T entity);

    Response deleteEntityService(ID entityId);
}
