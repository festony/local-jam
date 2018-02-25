package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.storage.pojo.ContestRoot;
import com.codejamlocalcopy.localjam.test.common.TestUtils;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.fail;

/**
 * Tests {@link ContestAccessingServiceImpl}
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ContestAccessingServiceImpl.class, Files.class})
public class ContestAccessingServiceImplTest {

    private String jsonString;
    private ContestRoot expectedContestRootPojo;

    @Mock
    private IContestFilePathService filePathService;

    private ContestAccessingServiceImpl service;

    @Before
    public void setUp() throws IOException, ParseException {
        service = new ContestAccessingServiceImpl(filePathService);

        jsonString = TestUtils.getResourceAsString(this.getClass(), "test-contest-root-json.json");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        expectedContestRootPojo = new ContestRoot();

        ContestRoot.Tab tab1 = expectedContestRootPojo.new Tab();
        tab1.order = 12;

        ContestRoot.Tab.Tournament tournament1 = tab1.new Tournament();

        ContestRoot.Tab.Tournament.Contest contest1 = tournament1.new Contest();
        contest1.startDate = "Oct 22 2017";
        contest1.name = "test contest name 1";
        contest1.analysis = true;
        contest1.startDateTime = sdf.parse("2017-10-22T05:00:00+00:00");
        contest1.duration = "3hr";
        contest1.id = "123456";

        ContestRoot.Tab.Tournament.Contest contest2 = tournament1.new Contest();
        contest2.startDate = "Sep 14 2017";
        contest2.name = "test contest name 2";
        contest2.analysis = false;
        contest2.startDateTime = sdf.parse("2017-09-14T12:00:00+00:00");
        contest2.duration = "2hr 30min";
        contest2.id = "34567";

        tournament1.contests = Lists.newArrayList(contest1, contest2);
        tournament1.grouping = "test tab label 1";
        tournament1.name = "test tournament name 1";
        tournament1.lastContestStart = sdf.parse("2017-10-22T05:00:00+00:00");
        tournament1.displayLanguage = "en";

        ContestRoot.Tab.Tournament tournament2 = tab1.new Tournament();
        tournament2.contests = Lists.newArrayList();
        tournament2.grouping = "test tab label 2";
        tournament2.name = "test tournament name 2";
        tournament2.lastContestStart = sdf.parse("2017-11-25T07:10:00+00:00");
        tournament2.displayLanguage = "zh";

        tab1.tournaments = Lists.newArrayList(tournament1, tournament2);
        tab1.id = "test tab id 1";
        tab1.label = "test tab label 1";

        ContestRoot.Tab tab2 = expectedContestRootPojo.new Tab();
        tab1.order = 34;
        tab2.tournaments = Lists.newArrayList();
        tab2.id = "test tab id 2";
        tab2.label = "test tab label 2";

        expectedContestRootPojo.tabs = Lists.newArrayList(tab1, tab2);
        expectedContestRootPojo.contestsText = "test contests text";
    }

    @Test
    public void test1() throws IOException {
    }
}
