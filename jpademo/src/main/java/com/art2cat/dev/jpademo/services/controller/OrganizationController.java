package com.art2cat.dev.jpademo.services.controller;

import com.art2cat.dev.jpademo.models.Group;
import com.art2cat.dev.jpademo.models.Team;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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

    private static final Logger LOGGER = Logger.getLogger(DataBagController.class.getName());

    @Autowired
    private EntityManager entityManager;


    @RequestMapping(value = "/getAllGroups", method = RequestMethod.GET)
    public List<Group> getAllGroups() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = builder.createQuery(Tuple.class);
        Root<Group> root = criteriaQuery.from(Group.class);
//        criteriaQuery.select(root);
        criteriaQuery.multiselect(root.get("id").alias("id"), root.get("name").alias("name"));
        List<Tuple> result = entityManager.createQuery(criteriaQuery).getResultList();
        if (result.isEmpty()) {
            LOGGER.info("not group found!!");
        }

       return result.stream().map(m -> {
            Group group = new Group();
            group.setId(m.get("id", Integer.class));
            group.setName(m.get("name", String.class));
            return group;
        }).collect(Collectors.toList());
    }

    @RequestMapping(value = "/getGroupsByIds", method = RequestMethod.GET)
    public List<Group> getAllGroups(@RequestParam(value = "ids") List<Integer> ids) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = builder.createQuery(Group.class);
        Root<Group> root = criteriaQuery.from(Group.class);
        criteriaQuery.select(root);
        Predicate subIn = null;
        if (ids.size() > 5) {
            while (ids.size() > 5) {
                List<?> subList = ids.subList(0, 5);
                subIn = root.get("id").in(subList);
                ids.subList(0, 5).clear();
            }
        }
        if (Objects.isNull(subIn)) {
            criteriaQuery.where(root.get("id").in(ids));
        } else {
            criteriaQuery.where(builder.or(subIn, root.get("id").in(ids)));
        }
        List<Group> result = entityManager.createQuery(criteriaQuery).getResultList();
        if (result.isEmpty()) {
            LOGGER.info("not group found!!");
        }
        return result;
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
        criteriaQuery.select(root);
        criteriaQuery.where(
            builder.like(root.get("name").as(String.class), name + "%"));
//        criteriaQuery.where(builder.isNotNull(root.get("phone")));
//        criteriaQuery.where(builder.isNotNull(root.get("fax")));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
