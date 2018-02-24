package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.LocalJamApplication;
import com.codejamlocalcopy.localjam.storage.pojo.ContestRoot;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Implementation of {@link IContestAccessingService}.
 */
@Service
public class ContestAccessingServiceImpl implements IContestAccessingService {

    private final static Logger LOG = LoggerFactory.getLogger(ContestAccessingServiceImpl.class);

    private final static String MAIN_CONTEST_JSON_FILE_NAME = "main_contest.json";

    @Autowired
    private IContestFilePathService filePathService;

    @Override
    public ContestRoot readContestRoot() throws IOException {
        Path mainContestFilePath = filePathService.getContestJsonDirPath().resolve(MAIN_CONTEST_JSON_FILE_NAME);
        String jsonString = readFileIntoString(mainContestFilePath);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

        return gson.fromJson(jsonString, ContestRoot.class);
    }

    @Override
    public void writeContestRoot(String json) throws IOException {
        Path contestFilePath = filePathService.getContestJsonDirPath().resolve(MAIN_CONTEST_JSON_FILE_NAME);
        Files.write(contestFilePath, Lists.newArrayList(json), StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
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
