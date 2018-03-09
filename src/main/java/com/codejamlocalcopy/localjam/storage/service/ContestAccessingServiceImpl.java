package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.storage.exception.LocalJamStorageRuntimeException;
import com.codejamlocalcopy.localjam.storage.pojo.ContestRoot;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Implementation of {@link IContestAccessingService}.
 */
@Service
public class ContestAccessingServiceImpl implements IContestAccessingService {

    private final static Logger LOG = LoggerFactory.getLogger(ContestAccessingServiceImpl.class);

    private final static String MAIN_CONTEST_JSON_FILE_NAME = "main_contest.json";

    private final IContestFilePathService filePathService;

    @Autowired
    public ContestAccessingServiceImpl(IContestFilePathService filePathService) {
        this.filePathService = filePathService;
    }

    @Override
    public ContestRoot readContestRoot() {
        Path mainContestFilePath = filePathService.getContestJsonDirPath().resolve(MAIN_CONTEST_JSON_FILE_NAME);
        String jsonString = null;
        try {
            jsonString = readFileIntoString(mainContestFilePath);
        } catch (IOException e) {
            LOG.warn("Failed to read main contest file [" + mainContestFilePath + "].", e);
            return null;
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
                .create();

        return gson.fromJson(jsonString, ContestRoot.class);
    }

    @Override
    public void writeContestRoot(String json) {
        Path contestJsonDirPath = filePathService.getContestJsonDirPath();
        Path mainContestJsonFilePath = contestJsonDirPath.resolve(MAIN_CONTEST_JSON_FILE_NAME);
        try {
            Files.createDirectories(contestJsonDirPath);
            Files.write(mainContestJsonFilePath, Lists.newArrayList(json), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            LOG.error("Failed to write main contest json file into [{}].", contestJsonDirPath, e);
            throw new LocalJamStorageRuntimeException("Error writing main contest json file.", e);
        }
    }

    /**
     * Read text file into one string and return.
     *
     * @param filePath - the Path info of text file.
     * @return File content in one string.
     * @throws IOException IOException
     */
    private String readFileIntoString(Path filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        Files.lines( filePath, StandardCharsets.UTF_8).forEach(s -> sb.append(s).append("\n"));

        return sb.toString();
    }
}
