package com.art2cat.dev.jpademo.services.controller;

import com.art2cat.dev.jpademo.models.Group;
import com.art2cat.dev.jpademo.models.Organization;
import com.art2cat.dev.jpademo.models.Team;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.art2cat.dev.jpademo.services.controller
 *
 * @author rorschach.h
 */
@RestController
@RequestMapping("/org")
public class OrganizationController {

    @Autowired
    private EntityManager entityManager;


    @RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
    public List<Group> getAllGroups() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        criteriaQuery.select(criteriaQuery.from(Group.class));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @RequestMapping(value = "/getAllTeams", method = RequestMethod.GET)
    public List<Team> getAllTeams() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Team> criteriaQuery = builder.createQuery(Team.class);
        criteriaQuery.select(criteriaQuery.from(Team.class));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @RequestMapping(value = "/getGroupsByName", method = RequestMethod.GET)
    public List<Group> getGroupsByName(@RequestParam(value = "name") String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);
        criteriaQuery.select(root)
            .where(
                builder.like(root.get("name").as(String.class), name + "%"),
                builder.isNotNull(root.get("phone")),
                builder.isNotNull(root.get("fax"))
            );
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
