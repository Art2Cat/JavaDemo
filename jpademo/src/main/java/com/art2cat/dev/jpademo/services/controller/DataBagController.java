package com.art2cat.dev.jpademo.services.controller;

import com.art2cat.dev.jpademo.models.CustomData;
import com.art2cat.dev.jpademo.models.DataBag;
import com.art2cat.dev.jpademo.repositories.CustomDataRepository;
import com.art2cat.dev.jpademo.repositories.DataBagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.art2cat.dev.jpademo.services.controller
 *
 * @author rorschach.h
 */
@RestController
@RequestMapping("/data")
public class DataBagController {

    private static final Logger LOGGER = Logger.getLogger(DataBagController.class.getName());

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomDataRepository customDataRepository;

    @Autowired
    private DataBagRepository dataBagRepository;

    @RequestMapping(value = "/getAllCustomData", method = RequestMethod.GET)
    public ResponseEntity<List<CustomData>> getAllCustomData() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CustomData> criteriaQuery = builder.createQuery(CustomData.class);
            Root<CustomData> root = criteriaQuery.from(CustomData.class);
            criteriaQuery.select(root);
            TypedQuery<CustomData> query = entityManager.createQuery(criteriaQuery);
            List<CustomData> result = query.getResultList();
            if (Objects.isNull(result) || result.isEmpty()) {
                LOGGER.warning("CustomData not found in the database");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<CustomData>>(result, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "request getAllCustomData fail: ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/saveCustomData", method = RequestMethod.POST)
    public void saveCustomData() {
        List<DataBag> dataBags = dataBagRepository.findAll();
        for (int i = 0; i < 10; i++) {

            var data = new CustomData();
            data.setName("Data " + i);
            if (i < 5) {
                data.setDataBag(dataBags.get(0));

            } else {
                data.setDataBag(dataBags.get(1));
            }
            customDataRepository.save(data);
        }

    }

    @RequestMapping(value = "/saveDataBag", method = RequestMethod.POST)
    public void saveDataBag() {

        var dataBagList = new ArrayList<DataBag>(2);

        for (int i = 0; i < 2; i++) {
            DataBag dataBag = new DataBag();
            dataBag.setName("DataBag " + i);
            dataBagList.add(dataBag);
        }
        dataBagRepository.saveAll(dataBagList);
    }

    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    public ResponseEntity<List<DataBag>> getCustomData() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<DataBag> criteriaQuery = builder.createQuery(DataBag.class);
            Root<DataBag> root = criteriaQuery.from(DataBag.class);
            criteriaQuery.select(root)
                .where(builder.equal(root.get("id"), 1));
            TypedQuery<DataBag> query = entityManager.createQuery(criteriaQuery);
            List<DataBag> result = query.getResultList();
            if (Objects.isNull(result) || result.isEmpty()) {
                LOGGER.warning("CustomData not found in the database");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<DataBag>>(result, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "request getAllCustomData fail: ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getTestsss", method = RequestMethod.GET)
    public List<CustomData> getTestss() {
        Query query = entityManager.createNativeQuery("select * from custom_data where id in :ids");
        List<Integer> ids = new ArrayList<>(3);
        ids.add(11);
        ids.add(12);
        ids.add(13);
        query.setParameter("ids", ids);
        return query.getResultList();

    }

    @RequestMapping(value = "/getSingleCustomData", method = RequestMethod.GET)
    public ResponseEntity<CustomData> getSingleCustomData() {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CustomData> criteriaQuery = builder.createQuery(CustomData.class);
            Root<CustomData> root = criteriaQuery.from(CustomData.class);
            var idPredicate = builder.equal(root.get("id"), 11);
            var secondIdPredicate = builder.equal(root.get("name"), "Data 0");
            criteriaQuery.select(root).where(idPredicate, secondIdPredicate);
            TypedQuery<CustomData> query = entityManager.createQuery(criteriaQuery);
            if (query.getResultList().isEmpty()) {
                LOGGER.warning("CustomData not found in the database");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<CustomData>(query.getSingleResult(), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "request getSingleCustomData fail: ", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
