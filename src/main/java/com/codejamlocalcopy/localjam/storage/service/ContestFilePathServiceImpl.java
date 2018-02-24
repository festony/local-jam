package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.LocalJamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Implementation of {@link IContestFilePathService}.
 */
@Service
public class ContestFilePathServiceImpl implements IContestFilePathService {

    private final static Logger LOG = LoggerFactory.getLogger(ContestFilePathServiceImpl.class);

    private final static String DEFAULT_ROOT_DIR_NAME = "storage";

    private final static String DATA_FILE_DIR_NAME = "data";

    private final static String IMAGE_FILE_DIR_NAME = "image";

    private final static String JSON_FILE_DIR_NAME = "json";

    @Value("${contest.file.root.path:}")
    private String contestFileRootPath;

    private Path contestDataDirPath;

    private Path contestImageDirPath;

    private Path contestJsonDirPath;

    @PostConstruct
    public void init() throws IOException {
        // no specified config: use default location - the running jar location + /storage .
        if (StringUtils.isBlank(contestFileRootPath)) {
            contestFileRootPath = new ApplicationHome(LocalJamApplication.class).getDir().toPath().
                    resolve(DEFAULT_ROOT_DIR_NAME).toString();
        }
        Path root = Paths.get(contestFileRootPath);

        contestDataDirPath = root.resolve(DATA_FILE_DIR_NAME);
        contestImageDirPath = root.resolve(IMAGE_FILE_DIR_NAME);
        contestJsonDirPath = root.resolve(JSON_FILE_DIR_NAME);

        Files.createDirectories(contestDataDirPath);
        Files.createDirectories(contestImageDirPath);
        Files.createDirectories(contestJsonDirPath);
    }

    @Override
    public Path getContestDataDirPath() {
        return contestDataDirPath;
    }

    @Override
    public Path getContestImageDirPath() {
        return contestImageDirPath;
    }

    @Override
    public Path getContestJsonDirPath() {
        return contestJsonDirPath;
    }
}
