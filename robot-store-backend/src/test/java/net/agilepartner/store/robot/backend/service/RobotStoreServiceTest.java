package net.agilepartner.store.robot.backend.service;

import net.agilepartner.store.robot.backend.Exception.IdNotFoundException;
import net.agilepartner.store.robot.backend.Exception.InvalidRobot;
import net.agilepartner.store.robot.backend.model.Robot;
import net.agilepartner.store.robot.backend.repository.IStoreDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotStoreServiceTest {

    @Spy
    private Robot unsavedRobot;

    @Spy
    private Robot savedRobot;

    private List<Robot> robotList;

    @MockBean
    private IStoreDao dao;

    @Autowired
    private IRobotStoreService service;

    @Before
    public void setUp() {
        unsavedRobot = new Robot();
        unsavedRobot.setName("Ultron");
        savedRobot = new Robot();
        savedRobot.setId(10L);
        savedRobot.setName("Ultron");
        robotList = new ArrayList<>();
        robotList.add(unsavedRobot);
    }

    @Test(expected = InvalidRobot.class)
    public void addRobot_EmptyName_ExceptionThrown() throws InvalidRobot {
        unsavedRobot.setName(null);
        service.addRobot(unsavedRobot);
    }

    @Test
    public void addRobot_ValidObject_ReturnRobot() throws InvalidRobot {
        when(dao.save(unsavedRobot)).thenReturn(savedRobot);
        Robot savedRobot = service.addRobot(unsavedRobot);
        assertThat(savedRobot.getName(), is(equalTo(unsavedRobot.getName())));
        assertThat(savedRobot.getId(), is(notNullValue()));
    }

    @Test(expected = IdNotFoundException.class)
    public void deleteRobotTest() throws IdNotFoundException {
        when(dao.exists(anyLong())).thenReturn(false);
        service.deleteRobot(500L);
    }

    @Test(expected = IdNotFoundException.class)
    public void updateRobot_IdNotFound_ThrowException() throws IdNotFoundException {
        when(dao.exists(anyLong())).thenReturn(false);
        service.updateRobot(35L, savedRobot);
    }

    @Test
    public void findRobot_IdNotFound_ReturnNull() {
        when(dao.findOne(anyLong())).thenReturn(null);
        assertThat(service.findRobot(45L), is(nullValue()));
    }

    @Test
    public void findRobot_IdFound_ReturnRobot() {
        when(dao.findOne(anyLong())).thenReturn(savedRobot);
        assertThat(service.findRobot(1L), is(equalTo(savedRobot)));
    }

    @Test
    public void listRobot_EmptyTable_ReturnEmptyList() {
        when(dao.findAll()).thenReturn(null);
        assertThat(service.listRobot(), is(empty()));
    }

    @Test
    public void listRobot_NotEmptyTable_ReturnList() {
        when(dao.findAll()).thenReturn(robotList);
        assertThat(service.listRobot(), is(not(empty())));
    }

}
