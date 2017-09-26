package com.art2cat.dev.springmvc.spittr.spitter.web;

import com.art2cat.dev.springmvc.spittr.spitter.data.ISpitterRepository;
import com.art2cat.dev.springmvc.spittr.spitter.data.ISpittleRepository;
import com.art2cat.dev.springmvc.spittr.spitter.data.Spitter;
import com.art2cat.dev.springmvc.spittr.spitter.data.Spittle;
import com.art2cat.dev.springmvc.spittr.spitter.web.HomeController;
import com.art2cat.dev.springmvc.spittr.spitter.web.SpitterContorller;
import com.art2cat.dev.springmvc.spittr.spitter.web.SpittleController;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ControllerTest {


    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        assertEquals("home", controller.home());

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);

        ISpittleRepository mockSpittleRepository = mock(ISpittleRepository.class);

        when(mockSpittleRepository.findSpittles(Long.MAX_VALUE, 50))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockSpittleRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/spittrviews/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"));
//                .andExpect(model().attributeExists("spittleList", hasItems((T) expectedSpittles.toArray())));


    }

    @Test
    public void testSpittle() throws Exception {
        Spittle spittle = new Spittle("Hello", new Date());
        ISpittleRepository spittleRepository = mock(ISpittleRepository.class);
        when(spittleRepository.findOne(12345)).thenReturn(spittle);

        SpittleController controller = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", spittle));
    }

    @Test
    public void shouldShowRegistrationForm() throws Exception {

        ISpitterRepository spitterRepository = mock(ISpitterRepository.class);

        SpitterContorller spitterContorller = new SpitterContorller(spitterRepository);

        MockMvc mockMvc = standaloneSetup(spitterContorller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));

    }

    @Test
    public void shouldProcessRegistration() throws Exception {

        ISpitterRepository spitterRepository = mock(ISpitterRepository.class);

        Spitter unsaved = new Spitter("TestUser", "24hours",
                "FirstTest", "LastTest");
        Spitter saved = new Spitter(1L, "TestUser", "24hours",
                "FirstTest", "LastTest");

        when(spitterRepository.save(unsaved)).thenReturn(saved);

        SpitterContorller spitterContorller = new SpitterContorller(spitterRepository);

        MockMvc mockMvc = standaloneSetup(spitterContorller).build();

        mockMvc.perform(get("/spitter/register/test")
                .param("firstName", "FirstTest")
                .param("lastName", "LastTest")
                .param("userName", "TestUser")
                .param("password", "24hours"));

//                .andExpect(redirectedUrl("/spitter/TestUser"));
        verify(spitterRepository, atLeastOnce()).save(unsaved);
    }


    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
