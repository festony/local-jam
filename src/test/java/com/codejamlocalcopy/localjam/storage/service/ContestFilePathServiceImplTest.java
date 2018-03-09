package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.LocalJamApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.ApplicationHome;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * Tests {@link ContestFilePathServiceImpl}
 */
@RunWith(MockitoJUnitRunner.class)
public class ContestFilePathServiceImplTest {

    private ContestFilePathServiceImpl service;

    @Before
    public void setUp() {
        service = new ContestFilePathServiceImpl();
    }

    @Test
    public void shouldPickJarLocationAsRootParentDir() throws Exception {
        Path root = new ApplicationHome(LocalJamApplication.class).getDir().toPath().resolve("storage");
        Path expectedDataDirPath = root.resolve("data");
        Path expectedImageDirPath = root.resolve("image");
        Path expectedJsonDirPath = root.resolve("json");

        ReflectionTestUtils.setField(service, "contestFileRootPath", "");

        service.init();

        assertThat("data path", service.getContestDataDirPath(), equalTo(expectedDataDirPath));
        assertThat("image path", service.getContestImageDirPath(), equalTo(expectedImageDirPath));
        assertThat("json path", service.getContestJsonDirPath(), equalTo(expectedJsonDirPath));
    }

    @Test
    public void shouldPickSpecifiedLocationAsRootParentDir() throws Exception {
        Path root = Paths.get("/tmp/testStorage");
        Path expectedDataDirPath = root.resolve("data");
        Path expectedImageDirPath = root.resolve("image");
        Path expectedJsonDirPath = root.resolve("json");

        ReflectionTestUtils.setField(service, "contestFileRootPath", "/tmp/testStorage");

        service.init();

        assertThat("data path", service.getContestDataDirPath(), equalTo(expectedDataDirPath));
        assertThat("image path", service.getContestImageDirPath(), equalTo(expectedImageDirPath));
        assertThat("json path", service.getContestJsonDirPath(), equalTo(expectedJsonDirPath));
    }
}
