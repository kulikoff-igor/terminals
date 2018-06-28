package by.diplom;

import by.diplom.model.MerchTab;
import by.diplom.model.PidGroup;
import by.diplom.model.TransScheme;
import by.diplom.repository.TerminalsRepository;
import by.diplom.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TerminalsApplication.class)
public class TerminalsApplicationTests {
    @Autowired
    private TerminalsRepository terminalsRepository;
    @Autowired
    private TerminalsService terminalsService;
    @Autowired
    private KeyTabService keyTabService;
    @Autowired
    private MerchTabService merchTabService;
    @Autowired
    private PidGroupServise pidGroupServise;
    @Autowired
    private TransSchemeService transSchemeService;
    @Autowired
    private TransTypeDescService transTypeDescService;

    @Test
    public void testKeyAuthorization() {

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(transSchemeService.getTransSchemeByNumber(1));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        // System.out.println("test --- " + terminalsService.getTerminals().get(0).getTModel().getDescription());
        /*TransScheme transScheme = new TransScheme();
        transScheme.setDescription("test");
        transScheme.setNumberTransScheme(1);
        transScheme.setTransTypeDesc(transTypeDescService.getTransTypeDescList().get(2));
        transScheme.setPidGroupList(pidGroupServise.getPidGroupsList());
        transSchemeService.addTransScheme(transScheme);*/
        //transSchemeService.getTransSchemeByNumber(1);
    }

    @Test
    public void testFindMerchTab() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(merchTabService.getMerchTab("ИП РУДЬКО П.Н."));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        // System.out.println("test --- " + terminalsService.getTerminals().get(0).getTModel().getDescription());
    }

    @Test
    public void addPidGroup() {
        List <TransScheme> transSchemeList= transSchemeService.getTransSchemeByNumber(3);
        List<PidGroup> pidGroupList;
        pidGroupList = pidGroupServise.getPidGroupsList();
        for (PidGroup pidGroup:pidGroupList){
            if(pidGroup.getNumberPidGroup()==3){
            pidGroup.setTransSchemeList(transSchemeList);
            pidGroupServise.updatePidGroup(pidGroup);}
        }
        // System.out.println("test --- " + terminalsService.getTerminals().get(0).getTModel().getDescription());
    }
    @Test
    public void addTransPidGroup() {
        List <TransScheme> transSchemeList= transSchemeService.getTransSchemeByNumber(1);
        List<PidGroup> pidGroupList;
        pidGroupList = pidGroupServise.getPidGroupsList();
        for (PidGroup pidGroup:pidGroupList){
            if(pidGroup.getNumberPidGroup()==1){
                pidGroup.setTransSchemeList(transSchemeList);
                pidGroupServise.updatePidGroup(pidGroup);}
        }
        // System.out.println("test --- " + terminalsService.getTerminals().get(0).getTModel().getDescription());
    }

    @Test
    public void contextLoads() {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(terminalsService.getTerminals().get(0));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);
        // System.out.println("test --- " + terminalsService.getTerminals().get(0).getTModel().getDescription());
    }

}
